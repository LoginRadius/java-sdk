package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;

/**
 * The four client-wide request options the legacy v11 SDK had and v12 was
 * missing: {@code originIp}, {@code serverRegion}, {@code fields}, and
 * {@code preventWebhook}.
 *
 * <p>Each is applied to EVERY outgoing request by the same interceptor that
 * injects credentials, so there is one place to audit rather than 210
 * hand-written call sites.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class RequestOptions {

  private RequestOptions() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("With every option set");
    Examples.Captured configured =
        Examples.capture(
            LoginRadiusConfig.builder()
                .apiKey("demo-api-key")
                .originIp("203.0.113.7")
                .serverRegion("eu")
                .fields("Email,Uid")
                .preventWebhook(true));
    Examples.showHeaders(configured, "X-Origin-IP", "X-PreventWebhook");
    Examples.showQuery(configured, "region", "fields");

    Examples.heading("With none set — nothing is added");
    Examples.Captured bare = Examples.capture(LoginRadiusConfig.builder().apiKey("demo-api-key"));
    Examples.showHeaders(bare, "X-Origin-IP", "X-PreventWebhook");
    Examples.showQuery(bare, "region", "fields");

    System.out.println();
    System.out.println("An unset option sends nothing at all — it never sends an empty value,");
    System.out.println("which the API would treat as a real (and wrong) filter.");
  }
}
