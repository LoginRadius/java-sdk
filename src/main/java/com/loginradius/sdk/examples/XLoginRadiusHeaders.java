package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;

/**
 * Auth scheme: XLoginRadiusAPIKey + XLoginRadiusAPISecret (header-only).
 *
 * <p>Use these when the header credentials must differ from the query-parameter ones — for example when a gateway in front of the API rewrites or consumes the query form.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class XLoginRadiusHeaders {

  private XLoginRadiusHeaders() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("What goes on the wire");

    Examples.Captured request = Examples.capture(LoginRadiusConfig.builder().apiKey("query-api-key").xLoginRadiusApiKey("header-api-key").xLoginRadiusApiSecret("header-api-secret"));

    Examples.showHeaders(request, "X-LoginRadius-ApiKey", "X-LoginRadius-ApiSecret");
    Examples.showQuery(request, "apikey");

    System.out.println();
    System.out.println("The header credentials override the header form only; the query form still\n" +
        "carries whatever apiKey was set. That separation is the point of these options.");
  }
}
