package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusClient;
import com.loginradius.sdk.LoginRadiusConfig;
import com.loginradius.sdk.Signing;
import java.util.function.Consumer;

/**
 * {@code apiRequestSigning} — the {@code digest} and {@code x-Request-Expires}
 * headers the LoginRadius API accepts on management endpoints.
 *
 * <p>Signing is opt-in and off by default. When enabled it applies only to
 * {@code /manage/} paths, and never to {@code /manage/account/access_token} —
 * that call is how you obtain the credential you would sign with.
 *
 * <p>The API secret is stripped from the URL before the signature is computed,
 * so the secret never appears in a signed URL nor on the wire.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class RequestSigning {

  private RequestSigning() {}

  /** Entry point. */
  public static void main(String[] args) {
    show("A management endpoint — signed", Examples::anyManagementOperation);
    show("An auth endpoint — not signed", Examples::anyAuthOperation);
    show("The access-token exchange — excluded", Examples::accessTokenExchange);

    System.out.println();
    System.out.println("Signing cannot be validated offline: these prove the headers are applied");
    System.out.println("where they should be, not that the API accepts the signature. Make one");
    System.out.println("real /manage/ call against your tenant before relying on it.");
  }

  private static void show(String label, Consumer<LoginRadiusClient> call) {
    Examples.heading(label);

    Examples.Captured request =
        Examples.capture(
            LoginRadiusConfig.builder()
                .apiKey("demo-api-key")
                .apiSecret("demo-api-secret")
                .apiRequestSigning(true),
            call);

    Examples.showUrl("URL sent:", request);
    Examples.showHeaders(request, Signing.DIGEST_HEADER, Signing.EXPIRES_HEADER);
    Examples.showQuery(request, "apisecret");
  }
}
