package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;

/**
 * Auth scheme: ClientId + ClientSecret (query parameters).
 *
 * <p>OAuth-style endpoints — typically multipurpose token operations and account linking. These identify an OAuth client rather than your LoginRadius app.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class ClientIdSecret {

  private ClientIdSecret() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("What goes on the wire");

    Examples.Captured request = Examples.capture(LoginRadiusConfig.builder().clientId("demo-client-id").clientSecret("demo-client-secret"));

    Examples.showHeaders(request, "X-LoginRadius-ApiKey");
    Examples.showQuery(request, "client_id", "client_secret");

    System.out.println();
    System.out.println("The client secret is server-side-only, exactly like the API secret.");
  }
}
