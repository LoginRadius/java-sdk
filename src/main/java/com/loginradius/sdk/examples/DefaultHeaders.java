package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusConfig;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * {@code defaultHeaders} — headers merged into every outgoing request.
 *
 * <p>Useful for correlation IDs, tenant traces, or anything your gateway needs.
 * The property worth understanding is PRECEDENCE: default headers are applied
 * first, so the SDK's own credential and User-Agent headers always win. A
 * default header cannot silently replace a credential.
 *
 * <p>RUNS OFFLINE — see {@link Examples}.
 */
public final class DefaultHeaders {

  private DefaultHeaders() {}

  /** Entry point. */
  public static void main(String[] args) {
    Map<String, String> headers = new LinkedHashMap<>();
    headers.put("X-Tenant-Trace", "trace-abc123");
    headers.put("X-Correlation-Id", "req-42");
    // Deliberately attempts to hijack two headers the SDK owns.
    headers.put("X-LoginRadius-ApiKey", "HIJACKED");
    headers.put("User-Agent", "HIJACKED");

    Examples.Captured request =
        Examples.capture(
            LoginRadiusConfig.builder().apiKey("REAL-API-KEY").defaultHeaders(headers));

    Examples.heading("Merged in");
    Examples.showHeaders(request, "X-Tenant-Trace", "X-Correlation-Id");

    Examples.heading("Attempted overrides — the SDK's values stand");
    Examples.showHeaders(request, "X-LoginRadius-ApiKey", "User-Agent");

    System.out.println();
    System.out.println("Both show the SDK's own value, not HIJACKED. Letting a default header");
    System.out.println("override a credential would mean silently sending the wrong one.");
  }
}
