# LoginRadius Java SDK — v12

[![CI](https://github.com/LoginRadius/java-sdk/actions/workflows/ci.yml/badge.svg)](https://github.com/LoginRadius/java-sdk/actions/workflows/ci.yml)

Official Java SDK for the [LoginRadius](https://www.loginradius.com) Customer
Identity and Access Management (CIAM) platform, generated from the LoginRadius
OpenAPI specification: every operation is present, the models match the wire
format, and credentials, base-URL precedence, error classification, request
signing and SOTT are applied in one place rather than per call.

## What changed in v12

v12 is generated rather than hand-written. Practically, that means:

- **Full API coverage.** 57 services covering every operation in the spec, not a
  hand-maintained subset that drifts behind the API.
- **Typed models** for every request and response.
- **One credential path.** Credentials, cross-cutting request options, signing,
  and debug logging are applied by a single interceptor, so there is one place
  to audit rather than one per method.
- **Typed errors** with intent-based predicates (`isAuth()`, `isRateLimit()`)
  instead of status-code comparisons at every call site.

v12 has never been released, so it is not a drop-in replacement for 11.x. See
`MIGRATION_GUIDE.md`.

## Install

```xml
<dependency>
  <groupId>com.loginradius.sdk</groupId>
  <artifactId>java-sdk</artifactId>
  <version>12.0.0-rc.1</version>
</dependency>
```
12.0.0-rc.1 is a prerelease. Maven resolves an exact version, so this
coordinate works as written; a `[12.0.0,)` range would skip it.

Requires Java 17 or later.

## Quickstart

```java
LoginRadiusClient client = LoginRadiusClient.create(
    LoginRadiusConfig.builder()
        .apiKey(System.getenv("LR_API_KEY"))
        .build());

var result = client.login.checkUserNameAvailability("alice", null, null, null, null, null);
```

Construct one client per tenant and reuse it: every service field shares the
underlying HTTP client, interceptors, and configuration.

## Authentication

Set whichever credentials your endpoints require; the SDK sends only what you
set. Each is sent as a header and, where the API accepts nothing else, also as a
query parameter.

| Option | Sent as | Notes |
|---|---|---|
| `apiKey` | `X-LoginRadius-ApiKey`, `?apikey` | Almost every endpoint |
| `apiSecret` | `X-LoginRadius-ApiSecret`, `?apisecret` | **Server-side only** |
| `accessToken` | `?access_token` | User-context endpoints |
| `bearerToken` | `Authorization: Bearer` | |
| `m2mBearerToken` | `Authorization: Bearer` | Machine-to-machine JWT |
| `clientId` / `clientSecret` | `?client_id`, `?client_secret` | **Secret is server-side only** |
| `xLoginRadiusApiKey` / `xLoginRadiusApiSecret` | headers only | When header and query values must differ |

Never ship `apiSecret` or `clientSecret` to a browser or mobile app: they
authorise acting on any user's behalf.

## Server selection

Resolved in this order — the first one set wins:

```
baseURL("https://…")        →  exactly that
customDomain("auth.acme.com") →  https://auth.acme.com
domain("acme")              →  https://acme.hub.loginradius.com
(nothing)                   →  https://api.loginradius.com
```

The specification pins 42 operations to their own host — the migration and
cloud-api services, plus tenant-hub and custom-domain templates. Setting
`baseURL` redirects those too, so pointing the SDK at a proxy or a staging host
really does move all of your traffic. Leave it unset and the pins stand, with
their template variables filled from `domain` / `customDomain`.

## Cross-cutting request options

Applied to every request by the same interceptor that injects credentials:

```java
LoginRadiusConfig.builder()
    .apiKey(key)
    .originIp("203.0.113.7")     // X-Origin-IP — risk-based auth, audit trails
    .serverRegion("eu")          // ?region
    .fields("Email,Uid")         // ?fields — response field selector
    .preventWebhook(true)        // X-PreventWebhook
    .defaultHeaders(Map.of("X-Correlation-Id", id))
    .build();
```

Default headers are merged at the lowest precedence: they cannot mask the SDK's
own credential or `User-Agent` headers.

## Request signing

Opt-in and off by default:

```java
LoginRadiusConfig.builder().apiKey(k).apiSecret(s).apiRequestSigning(true).build();
```

Adds `digest` and `x-Request-Expires` to `/manage/` requests only, never to
`/manage/account/access_token`. The API secret is stripped from the URL before
the signature is computed, so it never appears in a signed URL.

## Debug logging

```java
LoginRadiusConfig.builder().apiKey(k).debug(System.err).build();
```

Credential values are redacted before anything is written; the header name is
kept, so a debug log is safe to paste into a ticket.

## Custom HTTP client

```java
OkHttpClient yours = new OkHttpClient.Builder().proxy(proxy).build();
LoginRadiusConfig.builder().apiKey(k).httpClient(yours).build();
```

Your client is extended, never replaced — your proxy, TLS, dispatcher, and
interceptors keep applying. The SDK adds only its credential interceptor, and
leaves your timeouts alone unless you set `timeout` explicitly.

Note the ordering: OkHttp runs application interceptors in the order added, and
the SDK's is added after yours, so an interceptor of yours sees the request
before credentials are applied. Use a network interceptor to observe the
finished request.

## Error handling

```java
try {
  client.account.getAccountProfileByUid(uid, null, null);
} catch (ApiException e) {
  LoginRadiusException lr = LoginRadiusClient.toLoginRadiusException(e);
  if (lr.isAuth())       { /* credential rejected */ }
  if (lr.isRateLimit())  { /* back off */ }
  System.err.println(lr.description() + " (" + lr.code() + ")");
}
```

The API returns three different error envelopes depending on the endpoint
family; all three are normalised to the same typed exception.

## Examples

15 runnable examples under `com.loginradius.sdk.examples` — most run offline.
See that package's `README.md`.

## Demo

A complete browser flow — register, log in, profile, password reset — in
`com.loginradius.sdk.demo`. Copy `.env.example` to `.env`, fill it in, and run
`DemoServer`.

## Migrating from v11

See `MIGRATION_GUIDE.md`.

## Support

- Bugs and feature requests: <https://github.com/LoginRadius/java-sdk/issues>
- Account or integration questions: <support@loginradius.com>
- API documentation: <https://www.loginradius.com/docs/api/openapi/customer-identity-api>

## API reference

The API itself is documented at
[https://www.loginradius.com/docs/api/openapi/customer-identity-api](https://www.loginradius.com/docs/api/openapi/customer-identity-api) — endpoint behaviour, request and response fields, and what
each operation does. This SDK is generated from the same specification, so the
two stay in step.

[`docs/API.md`](./docs/API.md) lists every one of the 392
operations with its method name, HTTP verb and path, grouped across the
57 services.

Javadoc for this SDK's own types is published with each release and rendered at
[javadoc.io](https://javadoc.io); your IDE shows the same content inline from the
sources jar.

## Validating a LoginRadius JWT

`JwtValidation.validate` verifies a token issued by one of your JWT apps. It is
entirely local — no network call, no credentials, no client.

```java
Map<String, Object> claims = JwtValidation.validate(token,
    new JwtValidation.Params(JwtValidation.Algorithm.HS256, secret.getBytes(UTF_8))
        .issuer("LoginRadius"));
```

Signature, `exp` and `nbf` are always checked; issuer and audience are checked
when supplied. HS256/384/512 take the shared secret; RS*/ES* take the
PEM-encoded **public** key. Throws `JwtValidationException`, whose `code()` is a
short stable reason.

> **The algorithm is yours to state, and is never read from the token.** A
> validator that trusts the token's own `alg` header can be attacked: against an
> RS256 app, an attacker signs with HS256 using the public key as the HMAC
> secret. Passing the algorithm your app is configured for is what prevents it.

## License

MIT
