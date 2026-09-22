# Examples

One runnable class per topic. Build once, then run any of them:

```bash
mvn -q package -DskipTests
java -cp target/classes com.loginradius.sdk.examples.RequestOptions
```

Most **run offline**: they call a real SDK operation but capture the request at
the transport instead of sending it, so you see exactly what would go on the
wire without a tenant, credentials, or a network. The two that do reach the API
say so and read `LR_API_KEY` from the environment.

| Class | Shows |
|---|---|
| `Quickstart` | The minimum: construct a client, call an operation. **Needs `LR_API_KEY`.** |
| `Login` | Passwordless email login. **Needs `LR_API_KEY`.** |
| `ApiKeySecret` | API key + secret — server-side operations |
| `AccessToken` | Access token — user-context operations |
| `BearerTokenExample` | `Authorization: Bearer <token>` |
| `M2mBearerToken` | Machine-to-machine JWT |
| `ClientIdSecret` | OAuth client id + secret |
| `XLoginRadiusHeaders` | Header-only credentials, separate from the query form |
| `RequestOptions` | `originIp`, `serverRegion`, `fields`, `preventWebhook` |
| `DefaultHeaders` | Headers merged into every request, and why they cannot mask a credential |
| `RequestSigning` | `digest` / `x-Request-Expires`, and exactly which paths get signed |
| `DebugLogging` | Request logging, and the redaction that makes it safe to paste |
| `OperationServers` | The 42 operations the spec pins elsewhere, and how to redirect them |
| `TimeoutHttpClient` | How `timeout` interacts with an injected `OkHttpClient` |
| `CustomHttp` | Proxies, TLS, metrics — plugging in your own client |

This package is excluded from the published jar. It compiles with the SDK so the
examples cannot rot, but customers never receive it.
