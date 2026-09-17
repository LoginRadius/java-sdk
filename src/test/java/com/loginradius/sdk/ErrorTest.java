package com.loginradius.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.loginradius.sdk.internal.openapi.ApiException;
import java.util.Collections;
import org.junit.jupiter.api.Test;

/**
 * CROSS-LANGUAGE PARITY. Mirrors Go's {@code TestExtractEnvelopeAcrossWireShapes},
 * {@code TestErrorPredicates}, and {@code TestDefaultDescriptionForStatus}, and
 * Node's {@code errors.test.ts}.
 *
 * <p>Table-driven, like the Go suite: junit-jupiter-params is not on the
 * generated project's test classpath and adding a dependency to prove the same
 * thing a loop proves is not worth the drift risk.
 */
class ErrorTest {

  private static LoginRadiusException from(int status, String body) {
    return LoginRadiusException.from(new ApiException(status, Collections.emptyMap(), body));
  }

  /**
   * The LoginRadius API returns three different error envelopes depending on
   * which family of endpoints answered. All three must classify identically, or
   * a caller's error handling works on some endpoints and not others.
   */
  @Test
  void extractsEnvelopeAcrossWireShapes() {
    String[][] cases = {
      {
        "ApiError / ErrorResponse (PascalCase)",
        "{\"ErrorCode\":1043,\"Message\":\"Invalid credentials\","
            + "\"Description\":\"The email and password do not match.\"}",
        "1043",
        "The email and password do not match.",
      },
      {
        "ErrorResponseNative (camelCase, /api/v2/*)",
        "{\"errorCode\":1066,\"message\":\"Token expired\","
            + "\"description\":\"The access token has expired.\"}",
        "1066",
        "The access token has expired.",
      },
      {
        "OAuthErrorResponse (token endpoints)",
        "{\"error\":\"invalid_grant\",\"error_description\":\"Refresh token is invalid.\"}",
        "invalid_grant",
        "Refresh token is invalid.",
      },
    };

    for (String[] tc : cases) {
      LoginRadiusException e = from(400, tc[1]);
      assertEquals(tc[2], e.code(), tc[0]);
      assertEquals(tc[3], e.description(), tc[0]);
    }
  }

  @Test
  void predicates() {
    // status, isAuth, isForbidden, isRateLimit, isServer
    Object[][] cases = {
      {401, true, false, false, false},
      {403, false, true, false, false},
      {429, false, false, true, false},
      {500, false, false, false, true},
      {503, false, false, false, true},
      {599, false, false, false, true},
      {400, false, false, false, false},
      {200, false, false, false, false},
    };

    for (Object[] tc : cases) {
      int status = (Integer) tc[0];
      LoginRadiusException e = from(status, "{}");
      assertEquals(tc[1], e.isAuth(), "isAuth for " + status);
      assertEquals(tc[2], e.isForbidden(), "isForbidden for " + status);
      assertEquals(tc[3], e.isRateLimit(), "isRateLimit for " + status);
      assertEquals(tc[4], e.isServer(), "isServer for " + status);
    }
  }

  @Test
  void unusableBodiesStillProduceATypedError() {
    // An HTML error page from a proxy, or an empty body, must not throw while
    // building the error — the status code is still actionable.
    for (String body : new String[] {"", "not json", "<html>502</html>", "[]"}) {
      LoginRadiusException e = from(502, body);
      assertEquals(502, e.statusCode(), "body: " + body);
      assertTrue(e.isServer(), "body: " + body);
    }
  }

  @Test
  void carriesAHintForStatusesWithoutAnEnvelope() {
    // The hints come from manifest/sdk.yaml so all four SDKs say the same thing
    // for a bare 401 or 403.
    assertFalse(from(401, "").description().isEmpty());
    assertFalse(from(403, "").description().isEmpty());
  }

  @Test
  void keepsTheRawBodyForDiagnosis() {
    String body = "{\"ErrorCode\":1043,\"Message\":\"Invalid credentials\"}";
    assertTrue(from(400, body).rawBody().contains("1043"));
  }
}
