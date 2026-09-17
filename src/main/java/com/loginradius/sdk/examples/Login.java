package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusClient;
import com.loginradius.sdk.LoginRadiusConfig;
import com.loginradius.sdk.LoginRadiusException;
import com.loginradius.sdk.internal.openapi.ApiException;

/**
 * A passwordless login flow: the user receives a one-time email link which, on
 * click, delivers an access token.
 *
 * <p>This example covers the first half — initiating the email. Completing the
 * flow happens in the browser via the verification endpoint; the demo server in
 * {@code com.loginradius.sdk.demo} shows that half.
 *
 * <p>Unlike the rest of this package this example really does call the API:
 *
 * <pre>{@code
 * LR_API_KEY=... java -cp target/classes \
 *     com.loginradius.sdk.examples.Login user@example.com
 * }</pre>
 */
public final class Login {

  private Login() {}

  /** Entry point. */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("usage: Login <email>");
      System.exit(2);
    }
    String email = args[0];

    String apiKey = System.getenv("LR_API_KEY");
    if (apiKey == null || apiKey.isEmpty()) {
      System.err.println("LR_API_KEY is required");
      System.exit(2);
    }

    LoginRadiusClient client =
        LoginRadiusClient.create(LoginRadiusConfig.builder().apiKey(apiKey).build());

    try {
      var response =
          client.login.passwordlessLoginByEmail(
              email, null, null, null, null, null, null, null, null, null, null, null);
      System.out.println("login email sent: " + response);
    } catch (ApiException e) {
      // The typed exception carries the HTTP status, the LoginRadius error
      // code, and the raw body — branch on intent, not on status codes.
      LoginRadiusException lr = LoginRadiusClient.toLoginRadiusException(e);
      if (lr.isAuth()) {
        System.err.println("authentication rejected: " + lr.description());
      } else {
        System.err.printf("failed: %s (code %s)%n", lr.description(), lr.code());
      }
      System.exit(1);
    }
  }
}
