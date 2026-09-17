package com.loginradius.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.jupiter.api.Test;

/**
 * CROSS-LANGUAGE PARITY.
 *
 * <p>The golden values below are asserted identically by the Go, Node, and
 * .NET SDKs. Every LoginRadius SDK must emit a byte-identical SOTT and request
 * signature, because the API validates the payload exactly — a drifted IV,
 * iteration count, salt, or timestamp format yields a token that is silently
 * rejected.
 *
 * <p>The signing values came from the reference implementation in
 * admin-console-backend, not from this SDK's own output, so these prove the
 * port matches the known-working algorithm rather than merely matching itself.
 *
 * <p>If this fails, fix the implementation, not the expectation. The shared
 * parameters live in sdk-factory's manifest/sdk.yaml.
 */
class CryptoParityTest {

  private static final String API_KEY = "test-api-key";
  private static final String API_SECRET = "test-api-secret";
  private static final String URI =
      "https://api.loginradius.com/identity/v2/manage/account/uid?apikey=test-api-key";

  private static Date utc(int y, int mo, int d, int h, int mi, int s) {
    Calendar c = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    c.clear();
    c.set(y, mo - 1, d, h, mi, s);
    return c.getTime();
  }

  @Test
  void sottMatchesTheOtherSdks() {
    assertEquals(
        "yvLBFPR3aRNl1YlisgPpEdphb73sUfne2Jem7hTKWU6RLlkcfjYOhe5B7kSHorQS"
            + "*1059092e1510bfbc5388d7438b943106",
        Sott.generateWithWindow(API_KEY, API_SECRET, utc(2026, 1, 2, 3, 4, 5), utc(2026, 1, 2, 3, 14, 5)));
  }

  @Test
  void sottRejectsMissingCredentials() {
    Date start = utc(2026, 1, 2, 3, 4, 5);
    Date end = utc(2026, 1, 2, 3, 14, 5);
    org.junit.jupiter.api.Assertions.assertThrows(
        IllegalArgumentException.class, () -> Sott.generateWithWindow("", API_SECRET, start, end));
    org.junit.jupiter.api.Assertions.assertThrows(
        IllegalArgumentException.class, () -> Sott.generateWithWindow(API_KEY, "", start, end));
  }

  @Test
  void signingMatchesTheReferenceImplementation() {
    Date now = utc(2026, 1, 2, 3, 4, 5);

    Signing.Headers noBody = Signing.sign(API_SECRET, URI, null, now);
    assertEquals("SHA-256=WhdnDwiFzLUkrhBOUQYzrec+ZllDrY6X0hdovov8bKY=", noBody.digest);
    assertEquals("2026-01-02 03:24:05", noBody.expires);

    Signing.Headers withBody = Signing.sign(API_SECRET, URI, "{\"Uid\":\"abc123\"}", now);
    assertEquals("SHA-256=cVEPKKM+Dd1fzQePAPDKMKCn+2QollSbzWfVx8YxSzM=", withBody.digest);
  }

  /**
   * Guards the escaper. {@code URLEncoder} is NOT encodeURIComponent: it renders
   * a space as {@code +} and escapes {@code !'()*~}. Signing a URL containing an
   * email address with the wrong escaper yields a digest the API rejects.
   */
  @Test
  void encodeUriComponentMatchesJavaScript() {
    assertEquals(
        "a%20b!'()*~-_.%C3%A9%2F%3F%26%3D", Signing.encodeUriComponent("a b!'()*~-_.é/?&="));
  }

  @Test
  void signingScopeIsManagementPathsOnly() {
    assertTrue(Signing.shouldSign("/identity/v2/manage/account/uid"));
    assertTrue(Signing.shouldSign("/v2/manage/roles"));
    assertFalse(Signing.shouldSign("/identity/v2/auth/login"));
    // The access-token exchange is explicitly excluded by the reference.
    assertFalse(Signing.shouldSign("/identity/v2/manage/account/access_token"));
  }
}
