package com.loginradius.sdk.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Loads {@code .env} for the demo. DEMO ONLY.
 *
 * <p>Unlike Node's {@code dotenv} or a shell, plain Java has no supported way to
 * mutate {@link System#getenv()} at runtime — so this does not attempt to; it
 * loads {@code .env} into its own map and {@link #get} checks both. A real,
 * non-blank {@code System.getenv(key)} always wins over the {@code .env} value,
 * matching Node's {@code dotenv} and the PHP demo's loader (PHP:
 * {@code if (getenv($key) === false) putenv(...)}), and deliberately not the
 * .NET demo's loader, which overwrites an already-set shell variable.
 *
 * <p>{@code mvn -q compile exec:java} runs from the project root, so
 * {@code .env} is read from the current working directory — the same
 * directory as {@code .env.example}. Java's demo has no separate {@code demo/}
 * subdirectory the way Go/Node/.NET/PHP's do.
 */
final class DemoEnv {

  private static final Map<String, String> FILE_VALUES = load();

  private DemoEnv() {}

  static String get(String key) {
    return get(key, null);
  }

  static String get(String key, String fallback) {
    String shell = System.getenv(key);
    if (shell != null && !shell.isEmpty()) {
      return shell;
    }
    String fromFile = FILE_VALUES.get(key);
    return fromFile != null ? fromFile : fallback;
  }

  private static Map<String, String> load() {
    Map<String, String> out = new HashMap<>();
    Path path = Path.of(".env");
    if (!Files.isRegularFile(path)) {
      return out;
    }
    try {
      boolean first = true;
      for (String rawLine : Files.readAllLines(path, StandardCharsets.UTF_8)) {
        String line = rawLine.trim();
        if (first) {
          // Strip a UTF-8 BOM on the very first line, if present.
          line = line.replaceFirst("^﻿", "");
          first = false;
        }
        if (line.isEmpty() || line.startsWith("#") || !line.contains("=")) {
          continue;
        }
        int eq = line.indexOf('=');
        String key = line.substring(0, eq).trim();
        String value = line.substring(eq + 1).trim();
        out.put(key, value);
      }
    } catch (IOException e) {
      // No .env is a normal, supported configuration (real shell env only).
    }
    return out;
  }
}
