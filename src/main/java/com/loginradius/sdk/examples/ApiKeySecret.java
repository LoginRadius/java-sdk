package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;

/**
 * Auth scheme: APIKey + APISecret.
 *
 * <p>Server-side-only operations — token exchange, account lookup, and management endpoints. The secret must never reach a browser or a mobile app; it is the credential that authorises acting on any user's behalf.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class ApiKeySecret {

  private ApiKeySecret() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("What goes on the wire");

    Examples.Captured request = Examples.capture(LoginRadiusConfig.builder().apiKey("demo-api-key").apiSecret("demo-api-secret"));

    Examples.showHeaders(request, "X-LoginRadius-ApiKey", "X-LoginRadius-ApiSecret");
    Examples.showQuery(request, "apikey", "apisecret");

    System.out.println();
    System.out.println("Both credentials are sent as headers AND query parameters: some LoginRadius\n" +
        "operations accept nothing else. Keep the secret server-side.");
  }
}
