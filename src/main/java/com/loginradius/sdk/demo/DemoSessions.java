package com.loginradius.sdk.demo;

import java.security.SecureRandom;
import java.util.HexFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory session store mapping an opaque cookie value to the tokens
 * LoginRadius returned.
 *
 * <p>The cookie deliberately carries an opaque id rather than the access
 * token itself. Refreshing rotates the access token, and a cookie holding the
 * old one would keep sending an invalidated credential; an id lets the
 * rotation happen server-side without touching the browser — same reasoning
 * as Node's demo.
 *
 * <p>DEMO ONLY. A real application would use a signed cookie or a session
 * store; keeping tokens in a process map loses them on restart and does not
 * survive more than one instance.
 */
final class DemoSessions {

  private record Entry(String accessToken, String refreshToken) {}

  private final Map<String, Entry> sessions = new ConcurrentHashMap<>();
  private final SecureRandom random = new SecureRandom();

  /** Mints a session id for an access token, with an optional refresh token. */
  String create(String accessToken, String refreshToken) {
    byte[] buf = new byte[16];
    random.nextBytes(buf);
    String id = HexFormat.of().formatHex(buf);
    sessions.put(id, new Entry(accessToken, refreshToken == null ? "" : refreshToken));
    return id;
  }

  /** Mints a session id for an access token with no refresh token. */
  String create(String accessToken) {
    return create(accessToken, "");
  }

  /** Returns the access token for a session id, or null. */
  String lookup(String id) {
    Entry e = id == null ? null : sessions.get(id);
    return e == null ? null : e.accessToken();
  }

  /** Returns the refresh token for a session id, or an empty string if the tenant returned none. */
  String lookupRefresh(String id) {
    Entry e = id == null ? null : sessions.get(id);
    return e == null || e.refreshToken() == null ? "" : e.refreshToken();
  }

  /**
   * Swaps the tokens held under an existing id, used after a successful
   * refresh so the rotated tokens take effect without forcing the user to
   * sign in again. A blank refreshToken leaves the stored one alone — some
   * tenants rotate only the access token.
   */
  void replace(String id, String accessToken, String refreshToken) {
    Entry existing = sessions.get(id);
    if (existing == null) {
      return;
    }
    String next = (refreshToken == null || refreshToken.isEmpty()) ? existing.refreshToken() : refreshToken;
    sessions.put(id, new Entry(accessToken, next));
  }

  void delete(String id) {
    if (id != null) {
      sessions.remove(id);
    }
  }
}
