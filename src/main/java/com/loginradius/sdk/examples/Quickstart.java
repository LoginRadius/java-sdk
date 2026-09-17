package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusClient;
import com.loginradius.sdk.LoginRadiusConfig;
import com.loginradius.sdk.LoginRadiusException;
import com.loginradius.sdk.internal.openapi.ApiException;

/**
 * The minimum needed to call a LoginRadius endpoint with the v12 SDK:
 * construct a client with an API key, then call an operation through a service
 * handle.
 *
 * <p>Unlike the rest of this package this example really does call the API, so
 * it needs {@code LR_API_KEY} in the environment.
 *
 * <pre>{@code
 * LR_API_KEY=... java -cp target/classes com.loginradius.sdk.examples.Quickstart
 * }</pre>
 */
public final class Quickstart {

  private Quickstart() {}

  /** Entry point. */
  public static void main(String[] args) {
    String apiKey = System.getenv("LR_API_KEY");
    if (apiKey == null || apiKey.isEmpty()) {
      System.err.println("set LR_API_KEY to run this example");
      System.exit(1);
    }

    // One client per tenant, reused for the life of the process: every service
    // handle shares its HTTP client, interceptors, and configuration.
    LoginRadiusClient client =
        LoginRadiusClient.create(LoginRadiusConfig.builder().apiKey(apiKey).build());

    try {
      var result = client.login.checkUserNameAvailability("alice", null, null, null, null, null);
      System.out.println("username available: " + result);
    } catch (ApiException e) {
      // Convert to the facade's typed exception so you branch on intent rather
      // than on status codes.
      LoginRadiusException lr = LoginRadiusClient.toLoginRadiusException(e);
      System.err.printf("failed: %s (code %s)%n", lr.description(), lr.code());
      if (lr.isAuth()) {
        System.err.println("the API key was rejected");
      }
      System.exit(1);
    }
  }
}
