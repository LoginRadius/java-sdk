package com.loginradius.sdk.demo;

import com.loginradius.sdk.LoginRadiusClient;
import com.loginradius.sdk.LoginRadiusConfig;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * A runnable demo of the LoginRadius Java SDK.
 *
 * <p>Uses the JDK's built-in {@code HttpServer} rather than a web framework, so
 * the demo adds no dependency beyond the SDK itself — the same reasoning as the
 * Go demo using {@code net/http}.
 *
 * <pre>
 *   cp .env.example .env   # fill in your tenant credentials
 *   mvn -q compile exec:java -Dexec.mainClass=com.loginradius.sdk.demo.DemoServer
 * </pre>
 *
 * <p>Reads {@code .env} from the current working directory via {@link DemoEnv}
 * (a real, non-blank shell environment variable always takes precedence — set
 * one instead of {@code .env} if you prefer: {@code export LR_API_KEY=...}).
 * Reads the same variables as every other language's demo: {@code LR_API_KEY},
 * {@code LR_API_SECRET}, and the optional server-selection trio
 * {@code LR_DOMAIN} / {@code LR_CUSTOM_DOMAIN} / {@code LR_BASE_URL}.
 */
public final class DemoServer {

  private DemoServer() {}

  public static void main(String[] args) throws IOException {
    String apiKey = DemoEnv.get("LR_API_KEY");
    if (Demo.isBlank(apiKey)) {
      System.err.println("LR_API_KEY is required");
      System.exit(1);
    }

    // The SOTT query-parameter encoding fix (see the facade's own
    // SottEncodingInterceptor) is applied by LoginRadiusClient itself now —
    // the demo needs no OkHttpClient of its own for it.
    LoginRadiusConfig.Builder b =
        LoginRadiusConfig.builder().apiKey(apiKey).userAgent("loginradius-java-demo/0.1");
    if (!Demo.isBlank(DemoEnv.get("LR_API_SECRET"))) {
      b.apiSecret(DemoEnv.get("LR_API_SECRET"));
    }
    // Server selection, same precedence as every other SDK.
    if (!Demo.isBlank(DemoEnv.get("LR_DOMAIN"))) {
      b.domain(DemoEnv.get("LR_DOMAIN"));
    }
    if (!Demo.isBlank(DemoEnv.get("LR_CUSTOM_DOMAIN"))) {
      b.customDomain(DemoEnv.get("LR_CUSTOM_DOMAIN"));
    }
    if (!Demo.isBlank(DemoEnv.get("LR_BASE_URL"))) {
      b.baseURL(DemoEnv.get("LR_BASE_URL"));
    }

    LoginRadiusConfig config = b.build();
    LoginRadiusClient client = LoginRadiusClient.create(config);
    DemoSessions sessions = new DemoSessions();
    DemoHandlers handlers = new DemoHandlers(client, config, sessions);

    int port = Integer.parseInt(DemoEnv.get("LR_DEMO_PORT", "8080"));
    HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

    // The UI and its assets. Not part of the shared contract — each language's
    // demo ships its own markup, which is deliberate; only the stylesheet is
    // shared. This is a prefix context, so it also catches /demo.css.
    server.createContext("/", DemoServer::serveUi);

    // The API surface comes from DemoRoutes, generated from manifest/sdk.yaml.
    // Registering from the table (rather than by hand) is what keeps every
    // language's demo on the same endpoints: method checking and session
    // enforcement are applied uniformly here instead of being re-implemented,
    // slightly differently, in each handler.
    //
    // Grouped by path for the same reason the hand-written extra routes below
    // are: the JDK's HttpServer allows only one context per exact path, and
    // the manifest itself declares more than one method at some paths (e.g.
    // POST+PUT /api/password/otp, GET+POST /api/customobject). Registering
    // one createContext per route, naively, let the last registration at a
    // shared path silently shadow the others — confirmed live: PUT
    // /api/password/otp and GET /api/customobject were both unreachable
    // (405) until this grouped dispatch.
    //
    // A path containing a manifest path parameter (e.g.
    // /api/customobject/{objectRecordId}) is grouped by its literal prefix
    // instead — the JDK's HttpServer has no template syntax of its own, only
    // longest-prefix matching, so "/api/customobject/" is registered as a
    // context and the segment after it is read directly from the request URI
    // by whichever handler needs it (see DemoHandlers.resolveRecordId).
    // Confirmed live: without this, PUT/DELETE with a real id in the URL
    // matched the unrelated GET/POST /api/customobject context instead.
    Map<String, List<DemoRoutes.Route>> generated = new LinkedHashMap<>();
    for (DemoRoutes.Route route : DemoRoutes.all(handlers)) {
      int brace = route.path.indexOf('{');
      String key = brace < 0 ? route.path : route.path.substring(0, brace);
      generated.computeIfAbsent(key, p -> new ArrayList<>()).add(route);
    }
    for (Map.Entry<String, List<DemoRoutes.Route>> e : generated.entrySet()) {
      List<DemoRoutes.Route> routes = e.getValue();
      server.createContext(e.getKey(), ex -> dispatch(ex, routes, sessions));
    }

    // Non-contract endpoint: returns a fresh SOTT on every GET request.
    server.createContext("/api/sott", ex -> {
      if (!"GET".equalsIgnoreCase(ex.getRequestMethod())) {
        ex.getResponseHeaders().add("Allow", "GET");
        Demo.writeJson(ex, 405, Map.of("error", "method not allowed"));
        return;
      }
      handlers.freshSott(ex);
    });

    // Extended API routes — not part of the shared manifest contract.
    //
    // Grouped by path rather than registered one createContext per call: the
    // JDK's HttpServer allows only one context per exact path, and a future
    // hand-written route could share a path with another method (as the
    // generated table's own routes do, e.g. /api/mfa/login/email).
    Map<String, List<ExtraRoute>> extra = new LinkedHashMap<>();
    addRoute(extra, "POST", "/api/email/delete",           AuthMode.SESSION,   handlers::deleteEmail);
    addRoute(extra, "POST", "/api/account/delete",         AuthMode.SESSION,   handlers::deleteAccount);
    addRoute(extra, "POST", "/api/phone/update",           AuthMode.SESSION,   handlers::updatePhone);
    addRoute(extra, "POST", "/api/password/reset-otp",     AuthMode.NONE,      handlers::resetPasswordWithToken);
    addRoute(extra, "POST", "/api/customobject/create",    AuthMode.SESSION,   handlers::createCustomObject);
    addRoute(extra, "POST", "/api/customobject/list",      AuthMode.SESSION,   handlers::listCustomObjects);
    addRoute(extra, "POST", "/api/customobject/update",    AuthMode.SESSION,   handlers::updateCustomObject);
    addRoute(extra, "POST", "/api/customobject/delete",    AuthMode.SESSION,   handlers::deleteCustomObject);
    addRoute(extra, "POST", "/api/token/validate",         AuthMode.NONE,      handlers::validateToken);
    addRoute(extra, "GET",  "/api/session/active",         AuthMode.SESSION,   handlers::activeSession);
    addRoute(extra, "POST", "/api/token/invalidate",       AuthMode.SESSION,   handlers::invalidateToken);
    addRoute(extra, "POST", "/api/passkey/login/begin",    AuthMode.NONE,      handlers::beginPasskeyLogin);
    addRoute(extra, "POST", "/api/passkey/register/begin", AuthMode.NONE,      handlers::beginPasskeyRegistration);

    for (Map.Entry<String, List<ExtraRoute>> e : extra.entrySet()) {
      List<ExtraRoute> routes = e.getValue();
      server.createContext(e.getKey(), ex -> dispatchExtra(ex, routes, sessions));
    }

    server.setExecutor(null);
    System.out.printf("demo listening on http://localhost:%d/%n", port);
    server.start();
  }

  /**
   * How a hand-written extra route authenticates. {@code MFA_TOKEN} is
   * distinct from {@code SESSION}: it is satisfied by the second-factor token
   * a challenge login returned, held in its own cookie, and a session cookie
   * must never open one of these routes — a half-authenticated user must never
   * hold anything the session middleware accepts.
   */
  private enum AuthMode {
    NONE,
    SESSION,
    MFA_TOKEN
  }

  private record ExtraRoute(String method, AuthMode auth, DemoHandlers.Handler handler) {}

  /**
   * Declares one hand-written extra route, outside the generated manifest
   * contract. Several methods can share one path (see {@code extra} in
   * {@link #main}) — {@link #dispatchExtra} picks the matching one.
   */
  private static void addRoute(
      Map<String, List<ExtraRoute>> table,
      String method,
      String path,
      AuthMode auth,
      DemoHandlers.Handler handler) {
    table.computeIfAbsent(path, p -> new ArrayList<>()).add(new ExtraRoute(method, auth, handler));
  }

  /**
   * Applies the cross-cutting rules for a hand-written extra route: HTTP-method
   * matching (aggregating every method registered at this path into one
   * {@code Allow} header when none match) and the route's auth mode.
   */
  private static void dispatchExtra(HttpExchange ex, List<ExtraRoute> routes, DemoSessions sessions)
      throws IOException {
    for (ExtraRoute route : routes) {
      if (!route.method().equalsIgnoreCase(ex.getRequestMethod())) {
        continue;
      }
      switch (route.auth()) {
        case SESSION -> {
          if (sessions.lookup(Demo.sessionId(ex)) == null) {
            Demo.writeJson(ex, 401, Map.of("error", "not signed in"));
            return;
          }
        }
        case MFA_TOKEN -> {
          if (Demo.mfaToken(ex) == null) {
            Demo.writeJson(ex, 401, Map.of(
                "error", "no MFA challenge in progress",
                "hint", "sign in first; a login that requires a second factor starts the challenge"));
            return;
          }
        }
        case NONE -> {
          // No credential required.
        }
      }
      try {
        route.handler().handle(ex);
      } catch (RuntimeException e) {
        Demo.writeJson(ex, 500, Map.of("error", String.valueOf(e.getMessage())));
      }
      return;
    }
    String allow = String.join(", ", routes.stream().map(ExtraRoute::method).distinct().toList());
    ex.getResponseHeaders().add("Allow", allow);
    Demo.writeJson(ex, 405, Map.of("error", "method not allowed"));
  }

  /**
   * Applies the cross-cutting rules the generated table declares: HTTP-method
   * matching (aggregating every method registered at this path into one
   * {@code Allow} header when none match, same as {@link #dispatchExtra}) and
   * the route's session requirement.
   */
  private static void dispatch(HttpExchange ex, List<DemoRoutes.Route> routes, DemoSessions sessions)
      throws IOException {
    for (DemoRoutes.Route route : routes) {
      if (!route.method.equalsIgnoreCase(ex.getRequestMethod())) {
        continue;
      }
      if (route.requiresSession && sessions.lookup(Demo.sessionId(ex)) == null) {
        Demo.writeJson(ex, 401, Map.of("error", "not signed in"));
        return;
      }
      try {
        route.handler.handle(ex);
      } catch (RuntimeException e) {
        Demo.writeJson(ex, 500, Map.of("error", String.valueOf(e.getMessage())));
      }
      return;
    }
    String allow = String.join(", ", routes.stream().map(r -> r.method).distinct().toList());
    ex.getResponseHeaders().add("Allow", allow);
    Demo.writeJson(ex, 405, Map.of("error", "method not allowed"));
  }

  /**
   * A flat asset name. The demo's web root has no subdirectories, so a
   * legitimate asset name contains no separator — refusing anything else,
   * rather than resolving it, is what keeps a crafted request path from
   * reaching a classpath resource outside {@code /demo/}.
   */
  private static final Pattern SAFE_ASSET = Pattern.compile("[A-Za-z0-9._-]+");

  /**
   * Serves the demo's static assets from the classpath: {@code index.html} at
   * "/", and anything else under {@code /demo/} by name — {@code demo.css}
   * among them, which is rendered from the factory's shared template so every
   * SDK's demo looks the same.
   *
   * <p>Serving the whole directory rather than only index.html: a page that
   * links a stylesheet the server will not hand out renders unstyled, and it
   * does so silently, behind a 404 nobody sees without opening devtools.
   */
  private static void serveUi(HttpExchange ex) throws IOException {
    String path = ex.getRequestURI().getPath();
    String name = "/".equals(path) ? "index.html" : path.substring(1);
    if (!SAFE_ASSET.matcher(name).matches()) {
      Demo.writeJson(ex, 404, Map.of("error", "not found"));
      return;
    }
    try (InputStream in = DemoServer.class.getResourceAsStream("/demo/" + name)) {
      if (in == null) {
        // index.html missing means the resource overlay did not ship; say so in
        // the browser rather than as a 404 that looks like a bad URL.
        if (!"index.html".equals(name)) {
          Demo.writeJson(ex, 404, Map.of("error", "not found"));
          return;
        }
        write(ex, "text/html; charset=utf-8", "<h1>demo UI missing</h1>".getBytes(StandardCharsets.UTF_8));
        return;
      }
      write(ex, contentType(name), in.readAllBytes());
    }
  }

  /**
   * The Content-Type for an asset name. Spelled out rather than taken from
   * {@code URLConnection.guessContentTypeFromName}, which returns null for
   * {@code .css} on some JDKs — and a stylesheet served without
   * {@code text/css} is ignored by every browser.
   */
  private static String contentType(String name) {
    if (name.endsWith(".html")) return "text/html; charset=utf-8";
    if (name.endsWith(".css")) return "text/css; charset=utf-8";
    if (name.endsWith(".js")) return "text/javascript; charset=utf-8";
    if (name.endsWith(".svg")) return "image/svg+xml";
    if (name.endsWith(".png")) return "image/png";
    if (name.endsWith(".ico")) return "image/x-icon";
    return "application/octet-stream";
  }

  private static void write(HttpExchange ex, String contentType, byte[] body) throws IOException {
    ex.getResponseHeaders().add("Content-Type", contentType);
    ex.sendResponseHeaders(200, body.length);
    ex.getResponseBody().write(body);
    ex.close();
  }
}
