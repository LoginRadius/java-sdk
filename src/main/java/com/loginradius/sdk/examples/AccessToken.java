package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;

/**
 * Auth scheme: AccessToken (query {@code access_token}).
 *
 * <p>User-context endpoints operate on the signed-in user's own profile and sessions. The token comes from a login response and identifies that user.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class AccessToken {

  private AccessToken() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("What goes on the wire");

    Examples.Captured request = Examples.capture(LoginRadiusConfig.builder().apiKey("demo-api-key").accessToken("demo-access-token"));

    Examples.showHeaders(request, "X-LoginRadius-ApiKey");
    Examples.showQuery(request, "apikey", "access_token");

    System.out.println();
    System.out.println("The access token identifies the user; the API key identifies your app.\n" +
        "Both are sent — the endpoint needs to know who is calling and on whose behalf.");
  }
}
