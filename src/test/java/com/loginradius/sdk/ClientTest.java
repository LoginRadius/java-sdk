package com.loginradius.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.loginradius.sdk.internal.openapi.ApiException;
import java.lang.reflect.Field;
import java.util.Locale;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.Test;

/**
 * CROSS-LANGUAGE PARITY. Mirrors Go's {@code TestResolveBaseURLPrecedence},
 * {@code TestNewClientWiresEveryService}, and
 * {@code TestOperationServersHonourClientConfiguration}.
 */
class ClientTest {

  // ---- base URL precedence -------------------------------------------------

  @Test
  void resolveBaseUrlPrecedence() {
    // Declared in the shared SDK manifest as an ordered list; the order is the
    // contract, so assert each level beats the ones below it.
    assertEquals(
        "https://staging.internal",
        LoginRadiusConfig.builder()
            .apiKey("k")
            .baseURL("https://staging.internal")
            .customDomain("auth.acme.com")
            .domain("acme")
            .build()
            .resolveBaseUrl());

    assertEquals(
        "https://auth.acme.com",
        LoginRadiusConfig.builder()
            .apiKey("k")
            .customDomain("auth.acme.com")
            .domain("acme")
            .build()
            .resolveBaseUrl());

    assertEquals(
        "https://acme.hub.loginradius.com",
        LoginRadiusConfig.builder().apiKey("k").domain("acme").build().resolveBaseUrl());

    assertEquals(
        "https://api.loginradius.com",
        LoginRadiusConfig.builder().apiKey("k").build().resolveBaseUrl());
  }

  @Test
  void constructionRequiresACredential() {
    // A client with no credential at all would send unauthenticated requests
    // and fail per-call with a confusing 401.
    assertThrows(
        IllegalArgumentException.class,
        () -> LoginRadiusClient.create(LoginRadiusConfig.builder().build()));

    assertNotNull(LoginRadiusClient.create(LoginRadiusConfig.builder().apiKey("k").build()));
  }

  @Test
  void wiresEveryService() throws IllegalAccessException {
    LoginRadiusClient client =
        LoginRadiusClient.create(LoginRadiusConfig.builder().apiKey("k").build());

    // Every service field is derived from the generated client, so a null here
    // means a service the facade failed to wire.
    int services = 0;
    for (Field field : LoginRadiusClient.class.getDeclaredFields()) {
      if (!field.getType().getName().endsWith("Api")) {
        continue;
      }
      assertNotNull(field.get(client), field.getName() + " was not wired");
      services++;
    }
    assertTrue(services > 50, "expected the full service set, found " + services);
  }

  // ---- operation servers ---------------------------------------------------

  /**
   * Issues a request against an operation the spec pins to {@code
   * https://{domain}.hub.loginradius.com} and reports the host it actually
   * addressed.
   */
  private static String pinnedOperationHost(String domain, String baseUrl) {
    RecordingInterceptor recorder = new RecordingInterceptor();
    LoginRadiusConfig.Builder cfg =
        LoginRadiusConfig.builder()
            .apiKey("k")
            .httpClient(new OkHttpClient.Builder().addInterceptor(recorder).build());
    if (domain != null) {
      cfg.domain(domain);
    }
    if (baseUrl != null) {
      cfg.baseURL(baseUrl);
    }

    LoginRadiusClient client = LoginRadiusClient.create(cfg.build());
    try {
      client.bigCommerceSso.getBigCommerceLoginUrl("tok", "mystore", null, null);
    } catch (ApiException | RuntimeException e) {
      // The canned response does not deserialise into the operation's model,
      // which is fine — the request has already been recorded.
    }

    assertNotNull(recorder.request(), "no request reached the transport");
    return recorder.request().url().host();
  }

  @Test
  void operationServersHonourClientConfiguration() {
    // No server options: the spec's own placeholder stands, exactly as it does
    // in Go. Before ApiClient.buildUrl substituted variables this was a literal
    // "{domain}.hub.loginradius.com" — okhttp accepts that host and lowercases
    // it, so the call failed as a DNS error rather than as anything actionable.
    assertEquals("example.hub.loginradius.com", pinnedOperationHost(null, null));

    // domain() fills the {domain} template variable.
    assertEquals("acme.hub.loginradius.com", pinnedOperationHost("acme", null));

    // An explicit base URL means "send everything here" and wins over the pin —
    // otherwise a caller pointing at a proxy or a staging host would still have
    // this operation go to production.
    assertEquals("staging.internal", pinnedOperationHost(null, "https://staging.internal"));
  }

  @Test
  void pinnedOperationKeepsItsOwnPath() {
    RecordingInterceptor recorder = new RecordingInterceptor();
    LoginRadiusClient client =
        LoginRadiusClient.create(
            LoginRadiusConfig.builder()
                .apiKey("k")
                .domain("acme")
                .httpClient(new OkHttpClient.Builder().addInterceptor(recorder).build())
                .build());

    try {
      client.bigCommerceSso.getBigCommerceLoginUrl("tok", "mystore", null, null);
    } catch (ApiException | RuntimeException e) {
      // See pinnedOperationHost.
    }

    String path = recorder.request().url().encodedPath();
    assertNotEquals("/", path, "the operation's own path was dropped");
    assertTrue(
        path.toLowerCase(Locale.ROOT).contains("bigcommerce"),
        "unexpected path for a pinned operation: " + path);
  }
}
