# Contributing to the v12 Java SDK

Thank you for taking the time. This SDK is **generated**, which changes how
contributions work — please read this before opening a pull request.

## Files under `v12/` are not edited by hand

The client, facade, tests, examples, demo and docs are all produced from the
LoginRadius OpenAPI specification and a shared behavioural contract, then copied
into this repository. A change committed here is overwritten by the next
release, and it would not reach the other LoginRadius SDKs.

So a pull request that edits files under `v12/` cannot be merged, however good
the change is. This is not a judgement on the contribution — it is that the
change has to be made where the code comes from.

## Please open an issue instead

Describe what you expected and what happened. Useful detail:

- the SDK version, and the operation or option involved
- a minimal snippet that reproduces it
- for a wrong request: the parameter you set and what reached the API

We apply the fix at the source, so it arrives in the next release rather than
being patched into a file that the release would overwrite.

## If the API itself is wrong

Some problems are in the specification rather than the SDK: a missing endpoint,
an operation that declares the wrong field name, a response that does not match
what the API returns. Those cannot be fixed in a client at all. Report them the
same way and say what the API actually did — we route them to the API team.

## Running the SDK locally

You do not need any of the generation machinery to build or test what is here:

```bash
mvn -B package
```

The demo under `demo/` runs against a real tenant; see its README for the
credentials it needs. Never commit a filled `.env`.
