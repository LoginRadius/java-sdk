package com.loginradius.sdk;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Terminal interceptor that captures the fully decorated request and answers
 * with a canned response, so a test can assert on what the SDK would put on the
 * wire without one going anywhere.
 *
 * <p>This is the Java counterpart of the recording transport the Go suite uses.
 * It must sit <em>after</em> {@code AuthInterceptor} in the chain — anything
 * earlier sees the request before the credentials are applied and asserts
 * nothing.
 */
final class RecordingInterceptor implements Interceptor {

  private final int status;
  private final String body;

  private Request captured;

  RecordingInterceptor() {
    this(200, "{}");
  }

  RecordingInterceptor(int status, String body) {
    this.status = status;
    this.body = body;
  }

  /** The last request that reached the transport. */
  Request request() {
    return captured;
  }

  /** Header value, or null when the header is absent. */
  String header(String name) {
    return captured == null ? null : captured.header(name);
  }

  /** Query-parameter value, or null when the parameter is absent. */
  String query(String name) {
    return captured == null ? null : captured.url().queryParameter(name);
  }

  /** How many times a query parameter appears — a duplicate is a bug. */
  int queryCount(String name) {
    return captured == null ? 0 : captured.url().queryParameterValues(name).size();
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    captured = chain.request();
    return new Response.Builder()
        .request(captured)
        .protocol(Protocol.HTTP_1_1)
        .code(status)
        .message("OK")
        .body(ResponseBody.create(body, MediaType.get("application/json")))
        .build();
  }
}
