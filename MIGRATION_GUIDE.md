# Adopting the v12 Java SDK

## Scope of this guide

This covers what v12 looks like and how to move an existing integration onto it:
construction, credentials, request and response shapes, error handling, server
selection, and custom HTTP.

It covers the v11 → v12 differences that change *every* call site:
coordinates, construction, the call style, and error handling.

**It does not include a full endpoint-by-endpoint mapping** from v11's method
surface. Every operation in the API is present in v12, so the mapping exists —
it just is not written out here. The representative flows below show how to
derive it, and `docs/API.md` lists all 392 operations with the
endpoint each one calls, which is the reliable way to find a v11 method's
counterpart. Tell us which methods you depend on and we will prioritise those.

## Why migrate

- Every operation in the API, not a hand-maintained subset that drifts behind it.
- Typed models everywhere, instead of maps and hand-built JSON.
- One place where credentials, signing, and logging are applied — so one place
  to audit.
- Behaviour defined once and applied everywhere in the client, rather than
  re-implemented per method, so credentials and error handling are consistent
  across every operation.

## Decide whether to migrate

You should migrate if you need operations the old integration never covered, if
you want typed errors rather than status-code checks scattered through your
code, or if you need the cross-cutting options (`originIp`, `serverRegion`,
`fields`, `preventWebhook`, default headers, signing).

You can wait if your integration touches only a handful of stable endpoints and
works. v12 is a new artifact; nothing forces the move on a schedule.

## What's different at a glance

| | Before | v12 |
|---|---|---|
| Construction | per-service objects, often static | one `LoginRadiusClient` per tenant |
| Credentials | passed per call, or global mutable state | set once on `LoginRadiusConfig` |
| Requests | maps / hand-built JSON | typed model classes |
| Responses | maps / raw JSON | typed model classes |
| Errors | status codes, raw bodies | `LoginRadiusException` + predicates |
| Base URL | often hardcoded | four-level precedence, see below |
| Java level | 8 | 17 |

## Coordinates

The Maven coordinate is unchanged, so this is a version bump rather than a new
dependency:

```xml
<!-- v11 -->
<dependency>
  <groupId>com.loginradius.sdk</groupId>
  <artifactId>java-sdk</artifactId>
  <version>11.7.0</version>
</dependency>

<!-- v12 -->
<dependency>
  <groupId>com.loginradius.sdk</groupId>
  <artifactId>java-sdk</artifactId>
  <version>12.0.0-rc.1</version>
</dependency>
```

Because the coordinate is the same, Maven will not let both versions resolve in
one build. There is no side-by-side period: a module is on v11 or on v12.

## Construction

v11 configured the SDK through a **process-global singleton**, then instantiated
one class per API. v12 gives you a client object that owns its configuration:

```java
// v11 — global state, set once at startup
LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
init.setApiKey("<api-key>");
init.setApiSecret("<api-secret>");

AuthenticationApi authenticationApi = new AuthenticationApi();
AccountApi accountApi = new AccountApi();

// v12 — configuration belongs to the client
LoginRadiusClient client = LoginRadiusClient.create(
    LoginRadiusConfig.builder()
        .apiKey(System.getenv("LR_API_KEY"))
        .apiSecret(System.getenv("LR_API_SECRET"))   // server-side only
        .build());

// every service hangs off that client
client.login; client.account; client.user;
```

That difference matters if you serve more than one tenant: v11's global config
made a second credential set impossible without reconfiguring the whole process
between calls. In v12 you construct one client per tenant and hold both.

## Call style — the change that touches every call site

v11 was **callback-based**. Every method took an `AsyncHandler<T>` and reported
through `onSuccess` / `onFailure`. v12 methods **return their result** and throw
on failure:

```java
// v11
authenticationApi.loginByEmail(model, null, null, null, null,
    new AsyncHandler<AccessToken<Identity>>() {
      @Override public void onSuccess(AccessToken<Identity> response) {
        System.out.println(response.getAccess_Token());
      }
      @Override public void onFailure(ErrorResponse errorResponse) {
        System.out.println(errorResponse.getDescription());
      }
    });

// v12
var response = client.login.emailByLoginUserNamePhone(model, null, null, null,
    null, null, null, null, null, null, null, null);
System.out.println(response.getAccessToken());
```

Anonymous-handler nesting disappears, and so does the class of bug where a
`onFailure` body forgot to stop the surrounding flow. In exchange, code that
relied on the callback returning immediately now blocks — wrap the call in
whatever executor your application already uses if you need that back.

Build it once per tenant and hold it. Every service field shares the underlying
HTTP client, interceptors, and configuration, so constructing per request throws
away connection pooling for no benefit.

`create` throws `IllegalArgumentException` if no credential is set at all, which
is otherwise a confusing 401 on the first call.

## Auth posture

Nine credentials, each sent as a header by preference and additionally as a
query parameter where the API accepts nothing else. Set only what your endpoints
need.

`apiSecret` and `clientSecret` are **server-side only**. They authorise acting
on any user's behalf; a build that ships either to a browser or a mobile app has
leaked the tenant.

## Request and response shapes

Operations take typed models:

```java
EmailByLoginUserNamePhoneRequest body =
    new EmailByLoginUserNamePhoneRequest(
        new LoginByEmailRequest().email(email).password(password));

EmailByLoginUserNamePhone200Response response =
    client.login.emailByLoginUserNamePhone(body, null, null, /* … */);
```

Operations with many optional parameters take them positionally, so a call with
one required argument still passes `null` for the rest. Where a response is a
`oneOf`, the model exposes each branch as a getter that throws
`ClassCastException` if that branch did not match — check the branch you expect
rather than assuming.

## Error handling

v11 delivered failures to `onFailure(ErrorResponse)` — a second code path,
easy to leave empty, and impossible to propagate out of the enclosing method
without extra plumbing. v12 throws, so failures travel on the same path as every
other exception in your application:

```java
// v11
accountApi.getAccountProfileByUid(uid, null, new AsyncHandler<Identity>() {
  @Override public void onSuccess(Identity response) { use(response); }
  @Override public void onFailure(ErrorResponse e) {
    // no way to rethrow usefully from here
    log.warn(e.getDescription());
  }
});

// v12
try {
  client.accounts.getAccountIdentityByUID(uid, null, null);
} catch (ApiException e) {
  LoginRadiusException lr = LoginRadiusClient.toLoginRadiusException(e);

  if (lr.isAuth())      { /* credential rejected — do not retry as-is */ }
  if (lr.isRateLimit()) { /* back off */ }
  if (lr.isServer())    { /* retry with backoff */ }

  log.warn("{} ({}) status={}", lr.description(), lr.code(), lr.statusCode());
}
```

The API returns three different error envelopes depending on the endpoint
family — PascalCase, camelCase, and the OAuth `{error, error_description}`
shape. All three normalise to the same exception, so your handling works
everywhere rather than on some endpoints only.

An empty or non-JSON body — common when a gateway or WAF blocks the request
before the API sees it — still produces a typed exception carrying a
status-based hint.

## Server selection

```
baseURL("https://…")           →  exactly that
customDomain("auth.acme.com")  →  https://auth.acme.com
domain("acme")                 →  https://acme.hub.loginradius.com
(nothing)                      →  https://api.loginradius.com
```

The specification pins 42 operations to their own host. An explicit `baseURL`
redirects those too — that is what makes pointing the SDK at a proxy or a
staging environment actually move all of your traffic.

## Custom HTTP client

```java
OkHttpClient yours = new OkHttpClient.Builder()
    .proxy(proxy)
    .connectTimeout(Duration.ofSeconds(90))
    .build();

LoginRadiusConfig.builder().apiKey(key).httpClient(yours).build();
```

Your client is extended, not replaced. The SDK adds its credential interceptor
and leaves your timeouts alone unless you set `timeout` explicitly.

## Representative endpoint mapping

v11 method names came from a hand-written surface; v12's come from the
specification's `operationId`. Most differ, and the reliable way to find a
counterpart is to match the **HTTP endpoint** rather than the name —
`docs/API.md` lists the endpoint for all 392 operations.

| v11 | v12 | Endpoint |
| --- | --- | --- |
| `AuthenticationApi.loginByEmail` | `client.login.emailByLoginUserNamePhone` | `POST /identity/v2/auth/login` |
| `AccountApi.getAccountProfileByUid` | `client.accounts.getAccountIdentityByUID` | `GET /identity/v2/manage/account/{uid}` |

Note the second one is admin-scoped (`/manage/`, authorised by the API secret).
For the signed-in user's own profile, `client.user.getAccountDetails` calls
`GET /identity/v2/auth/account` with their access token — usually what a
customer-facing integration wants.

## What we don't migrate for you

- Stored access tokens and sessions. Tokens issued before the migration remain
  valid; the SDK does not manage their lifecycle.
- Your error-handling policy. The predicates tell you what kind of failure it
  was; retry and backoff are yours.
- Secret storage. The SDK reads what you give it and never persists anything.

## Need help?

<support@loginradius.com>
