package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusClient;
import com.loginradius.sdk.LoginRadiusConfig;
import okhttp3.Request;

/**
 * The fix for a defect that silently ignored your server configuration.
 *
 * <p>The OpenAPI specification pins 42 operations to their own host — the
 * migration and cloud-api services, plus the tenant-hub and custom-domain
 * templates. The generator inlines each pin into the operation itself, so
 * neither {@code baseURL} nor the client-level server list reached them.
 *
 * <p>Two consequences, both fixed:
 *
 * <ul>
 *   <li>A caller who set {@code baseURL} to a proxy or staging host still had
 *       those 42 operations go to production.</li>
 *   <li>A pin carrying a template variable was used verbatim, so the request
 *       went to a host with the braces still in it.</li>
 * </ul>
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class OperationServers {

  private OperationServers() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("Nothing configured — the spec's placeholder stands");
    show(LoginRadiusConfig.builder().apiKey("demo-api-key"));
    System.out.println("  (that is the specification's own default, not a real tenant)");

    Examples.heading("domain(\"acme\") — fills the {domain} template variable");
    show(LoginRadiusConfig.builder().apiKey("demo-api-key").domain("acme"));

    Examples.heading("baseURL(...) — means \"send everything here\", pins included");
    show(
        LoginRadiusConfig.builder()
            .apiKey("demo-api-key")
            .baseURL("https://staging.internal"));

    Examples.heading("An ordinary, unpinned operation for comparison");
    Request unpinned =
        Examples.captureUrlOnly(
            LoginRadiusConfig.builder().apiKey("demo-api-key").baseURL("https://staging.internal"),
            Examples::anyAuthOperation);
    Examples.showUrl("URL sent:", unpinned);
  }

  private static void show(LoginRadiusConfig.Builder builder) {
    // GetBigCommerceLoginUrl is pinned to https://{domain}.hub.loginradius.com.
    // captureUrlOnly, not capture: this example is about which host the SDK
    // picks, so pointing it at localhost would defeat the point.
    Request request = Examples.captureUrlOnly(builder, OperationServers::pinnedOperation);
    Examples.showUrl("URL sent:", request);
  }

  private static void pinnedOperation(LoginRadiusClient client) {
    try {
      client.bigCommerceSso.getBigCommerceLoginUrl("demo-token", "mystore", null, null);
    } catch (Exception expected) {
      // See Examples.capture.
    }
  }
}
