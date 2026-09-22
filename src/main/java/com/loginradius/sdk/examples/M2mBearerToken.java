package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;

/**
 * Auth scheme: M2MBearerToken ({@code Authorization: Bearer <JWT>}).
 *
 * <p>Machine-to-machine endpoints require an M2M JWT, obtained from the OAuth M2M token endpoint rather than from a user login.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class M2mBearerToken {

  private M2mBearerToken() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("What goes on the wire");

    Examples.Captured request = Examples.capture(LoginRadiusConfig.builder().apiKey("demo-api-key").m2mBearerToken("demo-m2m-jwt"));

    Examples.showHeaders(request, "Authorization", "X-LoginRadius-ApiKey");
    Examples.showQuery(request, "apikey");

    System.out.println();
    System.out.println("An M2M token represents a service, not a user, so there is no access_token\n" +
        "and no signed-in identity behind the call.");
  }
}
