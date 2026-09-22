package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;

/**
 * Auth scheme: BearerToken ({@code Authorization: Bearer <token>}).
 *
 * <p>Endpoints protected with the HTTP bearer scheme accept a bearer token in the standard Authorization header.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class BearerTokenExample {

  private BearerTokenExample() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("What goes on the wire");

    Examples.Captured request = Examples.capture(LoginRadiusConfig.builder().apiKey("demo-api-key").bearerToken("demo-bearer-token"));

    Examples.showHeaders(request, "Authorization", "X-LoginRadius-ApiKey");
    Examples.showQuery(request, "apikey");

    System.out.println();
    System.out.println("The bearer token goes in the standard Authorization header, not the query.");
  }
}
