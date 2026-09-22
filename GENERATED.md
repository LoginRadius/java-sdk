# This directory is generated

Everything in `v12/` — the client, the facade, the tests, the examples, the
demo, the docs and the package metadata — is generated from the LoginRadius
OpenAPI specification and copied here.

**Do not edit files here.** The next release overwrites them, and a fix made
here never reaches the other LoginRadius SDKs.

## Found a problem?

Open an issue on this repository. Include the SDK version, the operation or
option involved, and what you expected — that is enough for us to reproduce it.

A pull request that edits files in `v12/` cannot be merged, because the change
would be lost on the next release. If you have a fix in mind, describe it in the
issue and we will apply it at the source.

## Why it works this way

Generating the SDK from the specification is what keeps it complete and in step
with the API: every operation is present, the models match the wire format, and
credential handling, base-URL precedence and error classification are defined in
one place rather than repeated per method. The cost is that generated files are
not editable in place; the benefit is that a fix is made once, at the source,
and cannot be lost.
