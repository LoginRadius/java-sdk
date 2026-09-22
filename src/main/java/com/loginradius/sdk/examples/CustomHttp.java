package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Plugging a custom {@link OkHttpClient} into the SDK — for a proxy, custom
 * TLS, request logging, metrics, or connection-pool tuning.
 *
 * <p>Your client is extended, never replaced: the SDK adds its credential
 * interceptor on top of whatever you configured. Note the ordering — your
 * application interceptors run BEFORE the SDK's, so an interceptor of yours
 * observes the request before credentials are applied. Use a network
 * interceptor if you need to see the finished request.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class CustomHttp {

  private CustomHttp() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("A client with your own interceptor");

    OkHttpClient yours =
        new OkHttpClient.Builder()
            // A network interceptor sees the request as it goes out, after the
            // SDK's credential interceptor has run.
            .addNetworkInterceptor(new Logging())
            .build();

    Examples.capture(LoginRadiusConfig.builder().apiKey("demo-api-key").httpClient(yours));

    System.out.println();
    System.out.println("For a proxy, set it on your OkHttpClient.Builder with .proxy(...).");
    System.out.println("For custom TLS, use .sslSocketFactory(...). The SDK touches neither.");
  }

  private static final class Logging implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
      Request request = chain.request();
      System.out.printf("  -> %s %s%n", request.method(), request.url().encodedPath());
      System.out.printf("     credentials present: %s%n", request.header("X-LoginRadius-ApiKey") != null);
      return chain.proceed(request);
    }
  }
}
