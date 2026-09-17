package com.loginradius.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

/**
 * CROSS-LANGUAGE PARITY.
 *
 * <p>Every case here mirrors one in the Go suite ({@code loginradius_test.go})
 * and the Node suite ({@code __tests__/request-options.test.ts}), asserting the
 * same concrete values from {@code manifest/sdk.yaml}. The manifest is the
 * contract; these are what stop one language drifting away from it quietly.
 *
 * <p>A manifest change is <em>supposed</em> to break these. Update every
 * language's suite in the same change.
 */
class TransportTest {

  private static final String LOGIN_PATH = "https://api.loginradius.com/identity/v2/auth/login";
  private static final String MANAGE_PATH =
      "https://api.loginradius.com/identity/v2/manage/account/uid";

  /**
   * Drives the credential interceptor, the way Go's {@code roundTrip} helper
   * drives its transport, and hands back what reached the wire.
   */
  private static RecordingInterceptor send(LoginRadiusConfig cfg, String url) {
    RecordingInterceptor recorder = new RecordingInterceptor();
    OkHttpClient http =
        new OkHttpClient.Builder()
            .addInterceptor(new AuthInterceptor(cfg))
            // Added after, so it observes the request the SDK actually built.
            .addInterceptor(recorder)
            .build();

    try (Response ignored = http.newCall(new Request.Builder().url(url).build()).execute()) {
      // The response is irrelevant; the request has been captured.
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }

    assertNotNull(recorder.request(), "transport was not reached");
    return recorder;
  }

  private static RecordingInterceptor send(LoginRadiusConfig cfg) {
    return send(cfg, LOGIN_PATH);
  }

  // ---- credentials ---------------------------------------------------------

  @Test
  void injectsCredentialsAsHeadersAndQueryParameters() {
    RecordingInterceptor got =
        send(LoginRadiusConfig.builder().apiKey("KEY").apiSecret("SECRET").build());

    assertEquals("KEY", got.header("X-LoginRadius-ApiKey"));
    assertEquals("SECRET", got.header("X-LoginRadius-ApiSecret"));
    // The query form exists because some LoginRadius operations accept nothing
    // else; it must be sent alongside the header, not instead of it.
    assertEquals("KEY", got.query("apikey"));
  }

  @Test
  void omitsUnsetCredentials() {
    RecordingInterceptor got = send(LoginRadiusConfig.builder().apiKey("KEY").build());

    assertNull(got.header("X-LoginRadius-ApiSecret"));
    assertNull(got.query("apisecret"));
  }

  @Test
  void perCallParametersWinOverClientWideOnes() {
    RecordingInterceptor got =
        send(
            LoginRadiusConfig.builder().apiKey("CLIENT_KEY").build(),
            LOGIN_PATH + "?apikey=PER_CALL_KEY");

    // An operation that already carries the credential must not have it
    // appended a second time — two values would go out and the API would read
    // whichever came first.
    assertEquals("PER_CALL_KEY", got.query("apikey"));
    assertEquals(1, got.queryCount("apikey"));
  }

  // ---- cross-cutting request options ---------------------------------------

  @Test
  void requestOptionsAppliedToEveryRequest() {
    RecordingInterceptor got =
        send(
            LoginRadiusConfig.builder()
                .apiKey("KEY")
                .originIp("203.0.113.7")
                .serverRegion("eu")
                .fields("Email,Uid")
                .preventWebhook(true)
                .build());

    assertEquals("203.0.113.7", got.header("X-Origin-IP"));
    assertEquals("true", got.header("X-PreventWebhook"));
    assertEquals("eu", got.query("region"));
    assertEquals("Email,Uid", got.query("fields"));
  }

  @Test
  void requestOptionsOmittedWhenUnset() {
    RecordingInterceptor got = send(LoginRadiusConfig.builder().apiKey("KEY").build());

    assertNull(got.header("X-Origin-IP"));
    assertNull(got.header("X-PreventWebhook"));
    assertNull(got.query("region"));
    assertNull(got.query("fields"));
  }

  @Test
  void defaultHeadersNeverMaskACredential() {
    // Default headers are applied first so the SDK's own headers overwrite
    // them. Letting a caller override X-LoginRadius-ApiKey here would silently
    // send the wrong credential.
    Map<String, String> defaults = new LinkedHashMap<>();
    defaults.put("X-Tenant-Trace", "abc123");
    defaults.put("X-LoginRadius-ApiKey", "HIJACKED");
    defaults.put("User-Agent", "HIJACKED");

    RecordingInterceptor got =
        send(LoginRadiusConfig.builder().apiKey("REAL_KEY").defaultHeaders(defaults).build());

    assertEquals("abc123", got.header("X-Tenant-Trace"));
    assertEquals("REAL_KEY", got.header("X-LoginRadius-ApiKey"));
    assertNotEquals("HIJACKED", got.header("User-Agent"));
  }

  // ---- request signing -----------------------------------------------------

  private static LoginRadiusConfig signingConfig() {
    return LoginRadiusConfig.builder()
        .apiKey("KEY")
        .apiSecret("SECRET")
        .apiRequestSigning(true)
        .build();
  }

  @Test
  void signingAppliedOnlyToManagementPaths() {
    RecordingInterceptor signed = send(signingConfig(), MANAGE_PATH);
    assertNotNull(signed.header(Signing.DIGEST_HEADER), "management request was not signed");
    assertNotNull(signed.header(Signing.EXPIRES_HEADER), "management request has no expiry stamp");

    RecordingInterceptor unsigned = send(signingConfig(), LOGIN_PATH);
    assertNull(unsigned.header(Signing.DIGEST_HEADER), "only /manage/ paths should be signed");

    // The access-token exchange lives under /manage/ but is explicitly
    // excluded: it is the call that obtains the credential to sign with.
    RecordingInterceptor excluded =
        send(signingConfig(), "https://api.loginradius.com/identity/v2/manage/account/access_token");
    assertNull(excluded.header(Signing.DIGEST_HEADER), "access_token exchange must not be signed");
  }

  @Test
  void signingStripsTheSecretFromTheSignedUrl() {
    RecordingInterceptor got = send(signingConfig(), MANAGE_PATH);

    // apisecret is removed before the URL is signed AND before it is sent — a
    // signature computed over a URL carrying the secret would also mean the
    // secret went out on the wire.
    assertNull(got.query("apisecret"));
    assertNotNull(got.header(Signing.DIGEST_HEADER));
  }

  @Test
  void signingRequiresBothOptInAndSecret() {
    RecordingInterceptor noOptIn =
        send(LoginRadiusConfig.builder().apiKey("KEY").apiSecret("SECRET").build(), MANAGE_PATH);
    assertNull(noOptIn.header(Signing.DIGEST_HEADER));

    RecordingInterceptor noSecret =
        send(
            LoginRadiusConfig.builder().apiKey("KEY").apiRequestSigning(true).build(), MANAGE_PATH);
    assertNull(noSecret.header(Signing.DIGEST_HEADER));
  }

  // ---- debug logging -------------------------------------------------------

  @Test
  void debugRedactsCredentialValues() {
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    send(
        LoginRadiusConfig.builder()
            .apiKey("SUPER_SECRET_KEY")
            .apiSecret("SUPER_SECRET_VALUE")
            .bearerToken("SUPER_SECRET_TOKEN")
            .debug(new PrintStream(buffer, true, StandardCharsets.UTF_8))
            .build());

    String out = buffer.toString(StandardCharsets.UTF_8);
    assertFalse(out.isEmpty(), "debug stream received nothing");
    for (String secret :
        new String[] {"SUPER_SECRET_KEY", "SUPER_SECRET_VALUE", "SUPER_SECRET_TOKEN"}) {
      assertFalse(out.contains(secret), "debug log leaked a credential value: " + out);
    }
    assertTrue(
        out.toLowerCase(java.util.Locale.ROOT).contains("x-loginradius-apikey"),
        "debug log should name the header: " + out);
    assertTrue(out.contains("[REDACTED]"), "debug log should mark redacted values: " + out);
  }
}
