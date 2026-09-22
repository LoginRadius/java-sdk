package com.loginradius.sdk.demo;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.LoginRadiusClient;
import com.loginradius.sdk.LoginRadiusException;
import com.loginradius.sdk.internal.openapi.ApiException;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Small HTTP helpers shared by the demo handlers. DEMO ONLY. */
final class Demo {

  private static final Gson GSON = new Gson();
  private static final String COOKIE = "lr_session";
  private static final String MFA_COOKIE = "lr_mfa";

  private Demo() {}

  static boolean isBlank(String s) {
    return s == null || s.isEmpty();
  }

  /** Reads a JSON object body into a flat string map. Never throws. */
  static Map<String, String> readJson(HttpExchange ex) throws IOException {
    String body = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
    if (body.isEmpty()) {
      return Map.of();
    }
    try {
      Map<String, Object> raw =
          GSON.fromJson(body, new TypeToken<Map<String, Object>>() {}.getType());
      Map<String, String> out = new HashMap<>();
      if (raw != null) {
        raw.forEach((k, v) -> out.put(k, v == null ? null : String.valueOf(v)));
      }
      return out;
    } catch (JsonSyntaxException e) {
      return Map.of();
    }
  }

  static void writeJson(HttpExchange ex, int status, Map<String, ?> body) throws IOException {
    byte[] out = GSON.toJson(body).getBytes(StandardCharsets.UTF_8);
    ex.getResponseHeaders().add("Content-Type", "application/json");
    ex.sendResponseHeaders(status, out.length);
    ex.getResponseBody().write(out);
    ex.close();
  }

  /**
   * Writes an SDK response verbatim as the top-level JSON body, rather than
   * wrapping it under an {@code {ok, result}} envelope. Used where the browser
   * needs the SDK's own field names unwrapped — the WebAuthn challenge
   * endpoints, whose {@code RegisterBeginCredential}/{@code
   * LoginBeginCredential} shape the passkey ceremony reads directly.
   */
  static void writeJson(HttpExchange ex, int status, JsonElement body) throws IOException {
    byte[] out = GSON.toJson(body).getBytes(StandardCharsets.UTF_8);
    ex.getResponseHeaders().add("Content-Type", "application/json");
    ex.sendResponseHeaders(status, out.length);
    ex.getResponseBody().write(out);
    ex.close();
  }

  /** Maps a generated ApiException onto the facade's typed error for the UI. */
  static void writeSdkError(HttpExchange ex, ApiException e) throws IOException {
    LoginRadiusException lr = LoginRadiusClient.toLoginRadiusException(e);
    int status = lr.statusCode() == 0 ? 502 : lr.statusCode();
    Map<String, Object> body = new HashMap<>();
    body.put("error", lr.code().isEmpty() ? "loginradius_error" : lr.code());
    body.put("message", lr.description().isEmpty() ? lr.getMessage() : lr.description());
    body.put("auth", lr.isAuth());
    body.put("forbidden", lr.isForbidden());
    body.put("rateLimited", lr.isRateLimit());
    body.put("server", lr.isServer());
    writeJson(ex, status, body);
  }

  static String describe(ApiException e) {
    return DemoHandlers.describeError(e);
  }

  static void redirect(HttpExchange ex, String location) throws IOException {
    ex.getResponseHeaders().add("Location", location);
    ex.sendResponseHeaders(302, -1);
    ex.close();
  }

  static Map<String, String> query(HttpExchange ex) {
    Map<String, String> out = new HashMap<>();
    String raw = ex.getRequestURI().getRawQuery();
    if (raw == null) {
      return out;
    }
    for (String pair : raw.split("&")) {
      int eq = pair.indexOf('=');
      if (eq <= 0) {
        continue;
      }
      out.put(
          URLDecoder.decode(pair.substring(0, eq), StandardCharsets.UTF_8),
          URLDecoder.decode(pair.substring(eq + 1), StandardCharsets.UTF_8));
    }
    return out;
  }

  static String urlEncode(String s) {
    return URLEncoder.encode(s == null ? "" : s, StandardCharsets.UTF_8);
  }

  static String sessionId(HttpExchange ex) {
    List<String> cookies = ex.getRequestHeaders().get("Cookie");
    if (cookies == null) {
      return null;
    }
    for (String header : cookies) {
      for (String part : header.split(";")) {
        String p = part.trim();
        if (p.startsWith(COOKIE + "=")) {
          return p.substring(COOKIE.length() + 1);
        }
      }
    }
    return null;
  }

  /**
   * Issues the demo session cookie.
   *
   * <p>HttpOnly keeps the access token out of reach of page scripts, and
   * SameSite=Lax is what lets the email-verification redirect arrive with the
   * cookie still attached. The demo serves plain HTTP on localhost, so Secure
   * is deliberately absent — add it before running this anywhere real.
   */
  static void setSessionCookie(HttpExchange ex, String sessionId) {
    ex.getResponseHeaders()
        .add("Set-Cookie", COOKIE + "=" + sessionId + "; Path=/; HttpOnly; SameSite=Lax");
  }

  static void clearSessionCookie(HttpExchange ex) {
    ex.getResponseHeaders()
        .add("Set-Cookie", COOKIE + "=; Path=/; Max-Age=0; HttpOnly; SameSite=Lax");
  }

  /**
   * The access token for an authenticated route. Safe to call only from a
   * handler whose route sets requiresSession — DemoServer validated it already.
   */
  static String accessToken(HttpExchange ex, DemoSessions sessions) {
    return sessions.lookup(sessionId(ex));
  }

  /**
   * The second-factor token from an in-progress MFA login challenge, held in a
   * cookie separate from the session — a half-authenticated user must never
   * hold anything the session middleware accepts. Safe to call only from a
   * handler whose route requires the mfaToken auth mode.
   */
  static String mfaToken(HttpExchange ex) {
    List<String> cookies = ex.getRequestHeaders().get("Cookie");
    if (cookies == null) {
      return null;
    }
    for (String header : cookies) {
      for (String part : header.split(";")) {
        String p = part.trim();
        if (p.startsWith(MFA_COOKIE + "=")) {
          return p.substring(MFA_COOKIE.length() + 1);
        }
      }
    }
    return null;
  }

  /** Issues the MFA-challenge cookie, carrying the second-factor token directly. */
  static void setMfaCookie(HttpExchange ex, String token) {
    ex.getResponseHeaders()
        .add("Set-Cookie", MFA_COOKIE + "=" + token + "; Path=/; HttpOnly; SameSite=Lax; Max-Age=900");
  }

  static void clearMfaCookie(HttpExchange ex) {
    ex.getResponseHeaders()
        .add("Set-Cookie", MFA_COOKIE + "=; Path=/; Max-Age=0; HttpOnly; SameSite=Lax");
  }

  static String verificationUrl() {
    return DemoEnv.get("LR_VERIFICATION_URL", "http://localhost:8080/api/auth/verify");
  }

  static String resetUrl() {
    return DemoEnv.get("LR_RESET_PASSWORD_URL", "http://localhost:8080/?reset=1");
  }
}
