package com.loginradius.sdk.examples;

import com.loginradius.sdk.LoginRadiusClient;
import com.loginradius.sdk.LoginRadiusConfig;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Shared plumbing for the runnable examples.
 *
 * <p>Every example in this package RUNS OFFLINE. Each calls a real SDK
 * operation against a throwaway HTTP server on localhost, so the output is
 * exactly what the SDK put on the wire — no tenant, no credentials, no
 * outbound network. Run one with:
 *
 * <pre>{@code
 * mvn -q package -DskipTests
 * java -cp target/classes com.loginradius.sdk.examples.RequestOptions
 * }</pre>
 *
 * <p>A local server rather than an interceptor is deliberate. OkHttp runs
 * application interceptors in the order they were added, and the SDK adds its
 * credential interceptor <em>after</em> the ones on a client you supplied — so
 * an interceptor of yours that short-circuits the chain observes the request
 * before any credential is applied, and would show nothing. Letting the request
 * complete against localhost is the only way to see the finished article.
 *
 * <p>This package is excluded from the published jar — see the
 * {@code maven-jar-plugin} configuration in {@code pom.xml}. It compiles with
 * the SDK so the examples cannot rot, but customers never receive it.
 */
public final class Examples {

  private Examples() {}

  /** One request, as it arrived at the server. */
  public static final class Captured {
    private final String method;
    private final URI uri;
    private final Map<String, String> headers;

    Captured(String method, URI uri, Map<String, String> headers) {
      this.method = method;
      this.uri = uri;
      this.headers = headers;
    }

    /** The request method. */
    public String method() {
      return method;
    }

    /** The path and query, as received. */
    public URI uri() {
      return uri;
    }

    /** A header value, or null when absent. Names match case-insensitively. */
    public String header(String name) {
      return headers.get(name.toLowerCase(java.util.Locale.ROOT));
    }

    /** A query-parameter value, or null when absent. */
    public String query(String name) {
      HttpUrl url = HttpUrl.parse("http://localhost" + uri);
      return url == null ? null : url.queryParameter(name);
    }
  }

  /**
   * Runs one operation against a throwaway local server and returns the request
   * that arrived.
   *
   * <p>Any operation would do: the options these examples demonstrate apply to
   * every request, which is the whole point of them living in the transport.
   */
  public static Captured capture(LoginRadiusConfig.Builder builder) {
    return capture(builder, Examples::anyAuthOperation);
  }

  /**
   * Runs {@code call} against a throwaway local server and returns the request
   * that arrived. Use this when the example needs a particular endpoint —
   * signing, for instance, applies only to management paths.
   */
  public static Captured capture(
      LoginRadiusConfig.Builder builder, Consumer<LoginRadiusClient> call) {
    List<Captured> seen = new ArrayList<>();
    HttpServer server;
    try {
      server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }

    server.createContext(
        "/",
        (HttpExchange exchange) -> {
          Map<String, String> headers = new LinkedHashMap<>();
          exchange
              .getRequestHeaders()
              .forEach(
                  (name, values) ->
                      headers.put(
                          name.toLowerCase(java.util.Locale.ROOT), String.join(",", values)));
          seen.add(new Captured(exchange.getRequestMethod(), exchange.getRequestURI(), headers));

          byte[] body = "{}".getBytes(StandardCharsets.UTF_8);
          exchange.getResponseHeaders().add("Content-Type", "application/json");
          exchange.sendResponseHeaders(200, body.length);
          exchange.getResponseBody().write(body);
          exchange.close();
        });
    server.start();

    try {
      int port = server.getAddress().getPort();
      LoginRadiusClient client =
          LoginRadiusClient.create(builder.baseURL("http://127.0.0.1:" + port).build());
      try {
        call.accept(client);
      } catch (Exception expected) {
        // The canned response does not deserialise into the operation's model;
        // the request is what matters.
      }
    } finally {
      server.stop(0);
    }

    if (seen.isEmpty()) {
      throw new IllegalStateException("no request reached the local server");
    }
    return seen.get(seen.size() - 1);
  }

  /**
   * Captures only the URL an operation would address, without sending anything.
   *
   * <p>Used by the operation-servers example, which is about hosts the SDK
   * chooses — pointing it at localhost would defeat the point.
   */
  public static Request captureUrlOnly(
      LoginRadiusConfig.Builder builder, Consumer<LoginRadiusClient> call) {
    UrlRecorder recorder = new UrlRecorder();
    LoginRadiusClient client =
        LoginRadiusClient.create(
            builder
                .httpClient(new OkHttpClient.Builder().addInterceptor(recorder).build())
                .build());
    try {
      call.accept(client);
    } catch (Exception expected) {
      // See capture().
    }
    if (recorder.captured == null) {
      throw new IllegalStateException("no request was built");
    }
    return recorder.captured;
  }

  private static final class UrlRecorder implements Interceptor {
    private Request captured;

    @Override
    public Response intercept(Chain chain) {
      captured = chain.request();
      return new Response.Builder()
          .request(captured)
          .protocol(Protocol.HTTP_1_1)
          .code(200)
          .message("OK")
          .body(ResponseBody.create("{}", MediaType.get("application/json")))
          .build();
    }
  }

  /** GET /identity/v2/auth/login/... — an ordinary, unsigned endpoint. */
  public static void anyAuthOperation(LoginRadiusClient client) {
    try {
      client.login.checkUserNameAvailability("alice", null, null, null, null, null);
    } catch (Exception expected) {
      // See capture().
    }
  }

  /** GET /identity/v2/manage/account/{uid} — a management endpoint. */
  public static void anyManagementOperation(LoginRadiusClient client) {
    try {
      client.accounts.getAccountIdentityByUID("demo-uid", null, null);
    } catch (Exception expected) {
      // See capture().
    }
  }

  /**
   * GET /identity/v2/manage/account/access_token — a management endpoint that
   * signing deliberately excludes, because it is how you obtain the credential
   * you would sign with.
   */
  public static void accessTokenExchange(LoginRadiusClient client) {
    try {
      client.accounts.getImpersonationToken("demo-uid", null, null);
    } catch (Exception expected) {
      // See capture().
    }
  }

  /** Prints headers, or a placeholder when absent. */
  public static void showHeaders(Captured request, String... names) {
    for (String name : names) {
      String value = request.header(name);
      System.out.printf("  %-28s %s%n", name + ":", value == null ? "(not sent)" : value);
    }
  }

  /** Prints query parameters, or a placeholder when absent. */
  public static void showQuery(Captured request, String... names) {
    for (String name : names) {
      String value = request.query(name);
      System.out.printf("  %-28s %s%n", "?" + name + "=", value == null ? "(not sent)" : value);
    }
  }

  /** Prints the request line as received. */
  public static void showUrl(String label, Captured request) {
    System.out.printf("  %-28s %s %s%n", label, request.method(), request.uri());
  }

  /** Prints a URL the SDK built. */
  public static void showUrl(String label, Request request) {
    System.out.printf("  %-28s %s%n", label, request.url());
  }

  /** Section heading. */
  public static void heading(String title) {
    System.out.println();
    System.out.println(title);
    System.out.println("-".repeat(title.length()));
  }
}
