# v12 changelog

## v12.0.0-rc.1

The first Java SDK generated from the LoginRadius OpenAPI specification. There
is no earlier v12, and no 11.x Java SDK it replaces in place — see
`MIGRATION_GUIDE.md` if you are coming from a hand-written integration.

### What's new

- **Generated from the OpenAPI spec.** Every operation in
  `LoginRadius-Public-APIs.yaml` is reachable through a typed service on
  `LoginRadiusClient` — 57 services.
- **Typed request and response models** for every schema in the spec, rather
  than maps and hand-built JSON.
- **Centralised authentication.** All nine credentials are injected by a single
  OkHttp interceptor, configured once on `LoginRadiusConfig`. Each is sent as a
  header by preference — keeping secrets out of access logs and URL caches —
  and additionally as a query parameter for the operations that accept nothing
  else.
- **Typed errors.** `LoginRadiusException` exposes the HTTP status, LoginRadius
  error code, description, and raw body, plus `isAuth()`, `isForbidden()`,
  `isRateLimit()`, and `isServer()`. The API's three different error envelopes
  are normalised to one shape.
- **Cross-cutting request options** applied to every request: `originIp`,
  `serverRegion`, `fields`, `preventWebhook`, and arbitrary `defaultHeaders`.
  Default headers are merged at the lowest precedence and cannot mask a
  credential.
- **Request signing.** Opt-in `digest` / `x-Request-Expires` headers on
  `/manage/` endpoints, excluding the access-token exchange. The API secret is
  stripped from the URL before signing.
- **Debug logging** with credential values redacted, so a log is safe to share.
- **SOTT generation** matching every other LoginRadius SDK byte for byte,
  guarded by golden-value tests.
- **Custom OkHttpClient support** that extends your client rather than replacing
  it, and leaves your timeouts alone unless you set one explicitly.

### Fixed before first release

- **The 42 operations the spec pins to their own host.** The generator inlines
  each pin into the operation, so neither `setBasePath` nor the client-level
  server list reached them: an explicit `baseURL` was silently ignored for
  migration, cloud-api, OIDC, OAuth, and SSO traffic. 31 of them additionally
  carried an unsubstituted template variable, so the request went to a host with
  literal braces in it and failed as a DNS error.
- **`java.version` was left at the generator's 1.8 default** rather than the 17
  the manifest declares.

### Known limitations

- Request signing has not been validated against a live tenant. The
  implementation matches the reference algorithm and is covered by
  cross-language golden-value tests, but no signed request has been accepted by
  the API yet. It ships opt-in and off by default.
