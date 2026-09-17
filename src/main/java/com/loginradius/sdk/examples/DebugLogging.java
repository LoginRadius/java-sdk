package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;

/**
 * {@code debug} — a one-line summary of every request.
 *
 * <p>The property worth verifying here is REDACTION: credential header values
 * are replaced before anything is written, so a debug log can be pasted into a
 * ticket without leaking an API secret or an access token. The header NAME is
 * kept, because knowing which credential was sent is the point of the log.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class DebugLogging {

  private DebugLogging() {}

  /** Entry point. */
  public static void main(String[] args) {
    Examples.heading("Debug output");

    Examples.capture(
        LoginRadiusConfig.builder()
            .apiKey("SUPER-SECRET-KEY")
            .apiSecret("SUPER-SECRET-VALUE")
            .bearerToken("SUPER-SECRET-TOKEN")
            .debug(System.out));

    System.out.println();
    System.out.println("Every credential above appears by header name with its value replaced.");
    System.out.println("Pass any PrintStream — a file, a rotating logger, or System.err.");
  }
}
