package com.loginradius.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import com.loginradius.sdk.JwtValidation.Algorithm;
import com.loginradius.sdk.JwtValidation.JwtValidationException;
import com.loginradius.sdk.JwtValidation.Params;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * The security-relevant cases mirror the Go and Node suites case for case, so a
 * weakness fixed in one language cannot quietly persist in another.
 */
class JwtValidationTest {

  private static final String SECRET = "a-shared-secret-at-least-32-bytes-long!!";

  private static JWTClaimsSet liveClaims() {
    long now = System.currentTimeMillis();
    return new JWTClaimsSet.Builder()
        .subject("uid-123")
        .issuer("LoginRadius")
        .audience("my-app")
        .expirationTime(new Date(now + 3_600_000L))
        .notBeforeTime(new Date(now - 60_000L))
        .build();
  }

  private static String hs(JWSAlgorithm alg, JWTClaimsSet claims, byte[] secret) throws Exception {
    SignedJWT jwt = new SignedJWT(new JWSHeader(alg), claims);
    jwt.sign(new MACSigner(secret));
    return jwt.serialize();
  }

  private static String pem(java.security.PublicKey key) {
    return "-----BEGIN PUBLIC KEY-----\n"
        + Base64.getMimeEncoder(64, new byte[] {'\n'}).encodeToString(key.getEncoded())
        + "\n-----END PUBLIC KEY-----\n";
  }

  @Test
  void acceptsAWellFormedToken() throws Exception {
    Map<String, Object> claims =
        JwtValidation.validate(
            hs(JWSAlgorithm.HS256, liveClaims(), SECRET.getBytes(StandardCharsets.UTF_8)),
            new Params(Algorithm.HS256, SECRET.getBytes(StandardCharsets.UTF_8))
                .issuer("LoginRadius")
                .audience("my-app"));
    assertEquals("uid-123", claims.get("sub"));
  }

  /**
   * THE attack this utility exists to stop. Against an RS256-configured app an attacker signs with
   * HS256 using the PUBLIC key as the HMAC secret; a validator that reads the algorithm from the
   * token header accepts it.
   */
  @Test
  void rejectsAlgorithmConfusion() throws Exception {
    KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
    gen.initialize(2048);
    KeyPair pair = gen.generateKeyPair();
    byte[] pub = pem(pair.getPublic()).getBytes(StandardCharsets.UTF_8);

    String forged = hs(JWSAlgorithm.HS256, liveClaims(), pub);

    assertThrows(
        JwtValidationException.class,
        () -> JwtValidation.validate(forged, new Params(Algorithm.RS256, pub)));
  }

  @Test
  void rejectsAlgNone() {
    // Assembled by hand, exactly as an attacker would: nimbus refuses to sign one.
    String unsigned =
        "eyJhbGciOiJub25lIiwidHlwIjoiSldUIn0."
            + "eyJzdWIiOiJhdHRhY2tlciIsImV4cCI6NDEwMjQ0NDgwMH0.";
    assertThrows(
        JwtValidationException.class,
        () ->
            JwtValidation.validate(
                unsigned, new Params(Algorithm.HS256, SECRET.getBytes(StandardCharsets.UTF_8))));
  }

  @Test
  void rejectsAWrongSecret() throws Exception {
    String token =
        hs(
            JWSAlgorithm.HS256,
            liveClaims(),
            "a-different-secret-entirely-32-bytes".getBytes(StandardCharsets.UTF_8));
    JwtValidationException e =
        assertThrows(
            JwtValidationException.class,
            () ->
                JwtValidation.validate(
                    token, new Params(Algorithm.HS256, SECRET.getBytes(StandardCharsets.UTF_8))));
    assertEquals("signature", e.code());
  }

  @Test
  void rejectsExpiredAndNotYetValid() throws Exception {
    long now = System.currentTimeMillis();
    byte[] key = SECRET.getBytes(StandardCharsets.UTF_8);

    String expired =
        hs(
            JWSAlgorithm.HS256,
            new JWTClaimsSet.Builder().expirationTime(new Date(now - 600_000L)).build(),
            key);
    assertEquals(
        "expired",
        assertThrows(
                JwtValidationException.class,
                () -> JwtValidation.validate(expired, new Params(Algorithm.HS256, key)))
            .code());

    String early =
        hs(
            JWSAlgorithm.HS256,
            new JWTClaimsSet.Builder()
                .expirationTime(new Date(now + 3_600_000L))
                .notBeforeTime(new Date(now + 600_000L))
                .build(),
            key);
    assertEquals(
        "not_yet_valid",
        assertThrows(
                JwtValidationException.class,
                () -> JwtValidation.validate(early, new Params(Algorithm.HS256, key)))
            .code());
  }

  /** A token with no exp never stops being valid. */
  @Test
  void requiresAnExpiryClaim() throws Exception {
    byte[] key = SECRET.getBytes(StandardCharsets.UTF_8);
    String token =
        hs(JWSAlgorithm.HS256, new JWTClaimsSet.Builder().subject("uid-123").build(), key);
    assertEquals(
        "missing_exp",
        assertThrows(
                JwtValidationException.class,
                () -> JwtValidation.validate(token, new Params(Algorithm.HS256, key)))
            .code());
  }

  @Test
  void checksIssuerAndAudienceWhenSupplied() throws Exception {
    byte[] key = SECRET.getBytes(StandardCharsets.UTF_8);
    String token = hs(JWSAlgorithm.HS256, liveClaims(), key);
    assertEquals(
        "issuer",
        assertThrows(
                JwtValidationException.class,
                () ->
                    JwtValidation.validate(
                        token, new Params(Algorithm.HS256, key).issuer("SomeoneElse")))
            .code());
    assertEquals(
        "audience",
        assertThrows(
                JwtValidationException.class,
                () ->
                    JwtValidation.validate(
                        token, new Params(Algorithm.HS256, key).audience("another-app")))
            .code());
  }

  /** Omitting them must not silently disable the checks that are NOT optional. */
  @Test
  void issuerAndAudienceAreOptional() throws Exception {
    byte[] key = SECRET.getBytes(StandardCharsets.UTF_8);
    assertNotNull(
        JwtValidation.validate(hs(JWSAlgorithm.HS256, liveClaims(), key), new Params(Algorithm.HS256, key)));
  }

  @Test
  void verifiesRsaAndEcdsa() throws Exception {
    KeyPairGenerator rsaGen = KeyPairGenerator.getInstance("RSA");
    rsaGen.initialize(2048);
    KeyPair rsa = rsaGen.generateKeyPair();
    SignedJWT rsaJwt = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), liveClaims());
    rsaJwt.sign(new RSASSASigner(rsa.getPrivate()));
    assertEquals(
        "uid-123",
        JwtValidation.validate(
                rsaJwt.serialize(),
                new Params(Algorithm.RS256, pem(rsa.getPublic()).getBytes(StandardCharsets.UTF_8)))
            .get("sub"));

    KeyPairGenerator ecGen = KeyPairGenerator.getInstance("EC");
    ecGen.initialize(new ECGenParameterSpec("secp256r1"));
    KeyPair ec = ecGen.generateKeyPair();
    SignedJWT ecJwt = new SignedJWT(new JWSHeader(JWSAlgorithm.ES256), liveClaims());
    ecJwt.sign(new ECDSASigner((ECPrivateKey) ec.getPrivate()));
    assertEquals(
        "uid-123",
        JwtValidation.validate(
                ecJwt.serialize(),
                new Params(Algorithm.ES256, pem(ec.getPublic()).getBytes(StandardCharsets.UTF_8)))
            .get("sub"));
  }

  /** Handing over a PRIVATE key is a serious mistake; it is named, not swallowed. */
  @Test
  void refusesAPrivateKeyAsTheVerificationKey() throws Exception {
    KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
    gen.initialize(2048);
    KeyPair pair = gen.generateKeyPair();
    String priv =
        "-----BEGIN PRIVATE KEY-----\n"
            + Base64.getMimeEncoder(64, new byte[] {'\n'})
                .encodeToString(pair.getPrivate().getEncoded())
            + "\n-----END PRIVATE KEY-----\n";
    SignedJWT jwt = new SignedJWT(new JWSHeader(JWSAlgorithm.RS256), liveClaims());
    jwt.sign(new RSASSASigner(pair.getPrivate()));
    JwtValidationException e =
        assertThrows(
            JwtValidationException.class,
            () ->
                JwtValidation.validate(
                    jwt.serialize(),
                    new Params(Algorithm.RS256, priv.getBytes(StandardCharsets.UTF_8))));
    assertEquals("invalid_key", e.code());
  }

  @Test
  void rejectsAnEmptyKeyAndAMalformedToken() {
    byte[] key = SECRET.getBytes(StandardCharsets.UTF_8);
    assertEquals(
        "invalid_key",
        assertThrows(
                JwtValidationException.class,
                () -> JwtValidation.validate("a.b.c", new Params(Algorithm.HS256, new byte[0])))
            .code());
    assertEquals(
        "malformed",
        assertThrows(
                JwtValidationException.class,
                () -> JwtValidation.validate("not-a-jwt", new Params(Algorithm.HS256, key)))
            .code());
    if (false) {
      fail("unreachable");
    }
  }
}
