package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusClient;
import com.loginradius.sdk.LoginRadiusConfig;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * How {@code timeout} interacts with an injected {@link OkHttpClient}.
 *
 * <p>The rule: the SDK never imposes its default on a client you own. A timeout
 * you set on your own {@code OkHttpClient} survives; the SDK's 30-second
 * default is applied only to the client it builds itself. Set {@code timeout}
 * explicitly and it wins, because you asked for it.
 *
 * <p>Any other rule would silently retune a client you had already configured
 * for your own workload.
 */
public final class TimeoutHttpClient {

  private TimeoutHttpClient() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("The SDK's own client — the default applies");
    LoginRadiusClient a =
        LoginRadiusClient.create(LoginRadiusConfig.builder().apiKey("demo-api-key").build());
    System.out.printf("  configured timeout          %s%n", a.config().timeout());

    Examples.heading("Your client, no timeout option — yours is left alone");
    OkHttpClient yours =
        new OkHttpClient.Builder()
            .connectTimeout(90, TimeUnit.SECONDS)
            .readTimeout(90, TimeUnit.SECONDS)
            .build();
    LoginRadiusClient b =
        LoginRadiusClient.create(
            LoginRadiusConfig.builder().apiKey("demo-api-key").httpClient(yours).build());
    System.out.printf("  your read timeout           %d ms%n", yours.readTimeoutMillis());
    System.out.printf("  SDK overrode it?            %s%n", b.config().timeoutSet() ? "yes" : "no");

    Examples.heading("Your client AND an explicit timeout — the explicit one wins");
    LoginRadiusClient c =
        LoginRadiusClient.create(
            LoginRadiusConfig.builder()
                .apiKey("demo-api-key")
                .httpClient(yours)
                .timeout(Duration.ofSeconds(5))
                .build());
    System.out.printf("  configured timeout          %s%n", c.config().timeout());
    System.out.printf("  applied to your client?     %s%n", c.config().timeoutSet() ? "yes" : "no");

    System.out.println();
    System.out.println("Injecting a client keeps your proxy, TLS, dispatcher, and interceptors.");
    System.out.println("The SDK only adds its own credential interceptor on top.");
  }
}
