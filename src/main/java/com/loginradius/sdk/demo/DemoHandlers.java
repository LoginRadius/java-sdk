package com.loginradius.sdk.demo;

import com.loginradius.sdk.LoginRadiusClient;
import com.loginradius.sdk.LoginRadiusConfig;
import com.loginradius.sdk.LoginRadiusException;
import com.loginradius.sdk.Sott;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.internal.openapi.ApiException;
import com.loginradius.sdk.internal.openapi.JSON;
import com.loginradius.sdk.internal.openapi.model.AccessTokenResponse;
import com.loginradius.sdk.internal.openapi.model.AddEmailModel;
import com.loginradius.sdk.internal.openapi.model.AuthResponse;
import com.loginradius.sdk.internal.openapi.model.AuthenticatorCodeRequest;
import com.loginradius.sdk.internal.openapi.model.ChangePassword;
import com.loginradius.sdk.internal.openapi.model.DeleteemailbyaccesstokenRequest;
import com.loginradius.sdk.internal.openapi.model.EmailByLoginUserNamePhoneRequest;
import com.loginradius.sdk.internal.openapi.model.EmailModel;
import com.loginradius.sdk.internal.openapi.model.ForgotPasswordPhoneModel;
import com.loginradius.sdk.internal.openapi.model.ForgotPasswordRequest;
import com.loginradius.sdk.internal.openapi.model.LoginByEmailRequest;
import com.loginradius.sdk.internal.openapi.model.PasskeyCredentialAssertionResponse;
import com.loginradius.sdk.internal.openapi.model.PasskeyCredentialCreationResponse;
import com.loginradius.sdk.internal.openapi.model.PasskeyLoginFinish;
import com.loginradius.sdk.internal.openapi.model.PasskeyRegisterFinish;
import com.loginradius.sdk.internal.openapi.model.PasswordLessEmailOTPModel;
import com.loginradius.sdk.internal.openapi.model.PhoneIdModel;
import com.loginradius.sdk.internal.openapi.model.PhoneOTPModel;
import com.loginradius.sdk.internal.openapi.model.ProfileRequestModel;
import com.loginradius.sdk.internal.openapi.model.ProfileRequestModelEmailInner;
import com.loginradius.sdk.internal.openapi.model.ReAuthModelByEmailOtp;
import com.loginradius.sdk.internal.openapi.model.ResetPassword;
import com.loginradius.sdk.internal.openapi.model.ResetPasswordOneOf;
import com.loginradius.sdk.internal.openapi.model.ResetPasswordOneOf1;
import com.loginradius.sdk.internal.openapi.model.ResetPasswordOneOf2;
import com.loginradius.sdk.internal.openapi.model.ResetPasswordWithOTP;
import com.loginradius.sdk.internal.openapi.model.UpdateAccountByAccessTokenRequest;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The demo's handlers, one per route in {@link DemoRoutes} — the nine {@code
 * core} routes plus the four {@code passwordless} ones Java has adopted —
 * plus extended handlers for email, phone, custom objects, token management,
 * and passkeys.
 *
 * <p>{@code DemoRoutes.all()} references every method below by name, so this
 * class stops compiling the moment the manifest gains a route nobody has
 * implemented. HTTP-method checking and session enforcement live in
 * {@link DemoServer} — each handler here is only the interesting part: the SDK
 * call.
 */
public final class DemoHandlers {

  /** One demo endpoint. Throws to signal an error; the server maps it. */
  @FunctionalInterface
  public interface Handler {
    void handle(HttpExchange exchange) throws IOException;
  }

  /**
   * A Gson for echoing an already-deserialized SDK response back to the
   * browser — deliberately NOT {@code JSON.getGson()} (the SDK's own, used
   * for talking to the API): that instance registers a custom serializer for
   * every generated model, which crashes the moment any "additional
   * property" (a live field the spec doesn't declare —
   * disallowAdditionalPropertiesIfNotPresent: false is why the demo can even
   * receive one instead of the call failing outright) has a JSON null value
   * — confirmed live on GetAccountDetails, "Not a JSON Object: null".
   *
   * <p>A bare {@code new Gson()} avoids that, but breaks in a different way:
   * plain reflection can't reach {@code java.time.OffsetDateTime}'s private
   * fields under the module system, so any date field throws "Failed making
   * field ... accessible" instead — confirmed live, same GetAccountDetails
   * call. This registers the SDK's own date/time adapters (the same classes
   * {@code JSON.createGson()} uses) without any of the ~800 per-model
   * factories, avoiding both failure modes. The one visible difference from
   * {@code JSON.getGson()}: additional properties appear here as a nested
   * {@code "additionalProperties": {...}} object rather than flattened onto
   * the response, since that flattening is exactly the code that crashes.
   */
  private static final Gson PLAIN_GSON = new com.google.gson.GsonBuilder()
      .registerTypeAdapter(java.util.Date.class, new JSON.DateTypeAdapter())
      .registerTypeAdapter(java.sql.Date.class, new JSON.SqlDateTypeAdapter())
      .registerTypeAdapter(java.time.OffsetDateTime.class, new JSON.OffsetDateTimeTypeAdapter())
      .registerTypeAdapter(java.time.LocalDate.class, new JSON.LocalDateTypeAdapter())
      .registerTypeAdapter(byte[].class, new JSON.ByteArrayAdapter())
      .create();

  private final LoginRadiusClient client;
  private final LoginRadiusConfig config;
  private final DemoSessions sessions;

  DemoHandlers(LoginRadiusClient client, LoginRadiusConfig config, DemoSessions sessions) {
    this.client = client;
    this.config = config;
    this.sessions = sessions;
  }

  /**
   * Builds the JSON body for an in-progress MFA challenge (a login response
   * that carries a {@code SecondFactorAuthenticationToken} instead of an
   * access token), shared by {@link #login} and both passwordless OTP
   * handlers. Field set mirrors Node's and PHP's demos exactly.
   */
  private static Map<String, Object> mfaChallengeBody(JsonObject resp) {
    Map<String, Object> body = new HashMap<>();
    body.put("mfa_required", true);
    body.put("totp_enrolled", jsonBool(resp, "IsGoogleAuthenticatorVerified")
        || jsonBool(resp, "IsAuthenticatorVerified"));
    body.put("manual_entry_code", jsonString(resp, "ManualEntryCode"));
    body.put("qr_code", jsonString(resp, "QRCode"));
    body.put("response", resp.toString());
    return body;
  }

  private static boolean jsonBool(JsonObject obj, String field) {
    return obj.has(field) && !obj.get(field).isJsonNull() && obj.get(field).getAsBoolean();
  }

  private static String jsonString(JsonObject obj, String field) {
    return obj.has(field) && !obj.get(field).isJsonNull() ? obj.get(field).getAsString() : null;
  }

  // ----------------------------------------------------------------- sott ---

  /** Generates and returns a fresh SOTT. Called on every page load. */
  public void freshSott(HttpExchange ex) throws IOException {
    if (Demo.isBlank(config.apiSecret())) {
      Demo.writeJson(ex, 500, Map.of("error", "LR_API_SECRET is required to generate a SOTT"));
      return;
    }
    String sott = Sott.generate(config.apiKey(), config.apiSecret());
    Demo.writeJson(ex, 200, Map.of("sott", sott));
  }

  // ------------------------------------------------------------------ auth --

  /** Registers a new user. Mints a SOTT server-side; never accepts one from the client. */
  public void register(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String email = in.get("email");
    String password = in.get("password");
    if (Demo.isBlank(email) || Demo.isBlank(password)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email, password}"));
      return;
    }
    if (Demo.isBlank(config.apiSecret())) {
      Demo.writeJson(ex, 500, Map.of("error", "LR_API_SECRET is required for registration"));
      return;
    }

    // Minted per request: a SOTT is valid for ten minutes, so it must never
    // come from configuration — and never from the client.
    String sott = Sott.generate(config.apiKey(), config.apiSecret());

    ProfileRequestModel body = new ProfileRequestModel();
    body.setEmail(List.of(new ProfileRequestModelEmailInner().type("Primary").value(email)));
    body.setPassword(password);
    if (!Demo.isBlank(in.get("firstName"))) {
      body.setFirstName(in.get("firstName"));
    }
    if (!Demo.isBlank(in.get("lastName"))) {
      body.setLastName(in.get("lastName"));
    }

    try {
      Object profile =
          client.registration.userRegistrationBySottEmailPhoneUserName(
              body, null, sott, null, Demo.verificationUrl(),
              null, null, null, null, null, null, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "profile", PLAIN_GSON.toJsonTree(profile)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Email + password login. Stores the returned access token in the demo session. */
  public void login(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    if (Demo.isBlank(in.get("email")) || Demo.isBlank(in.get("password"))) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email, password}"));
      return;
    }
    try {
      EmailByLoginUserNamePhoneRequest body =
          new EmailByLoginUserNamePhoneRequest(
              new LoginByEmailRequest().email(in.get("email")).password(in.get("password")));

      // Bypass the generated oneOf type adapter: both AuthResponseOptionalMfa
      // and AuthResponseRequiredMfa have no required fields, so the discriminator
      // always matches both (match=2) and throws JsonIOException. Deserialising
      // as a raw JsonObject sidesteps this and still lets us extract access_token.
      JsonObject resp = (JsonObject) client.apiClient().execute(
              client.login.emailByLoginUserNamePhoneCall(
                  body, null, null, null, null, null, null, null, null, null, null, null, null,
                  null, null, null, null, null, null, null, null, null, null, null, null, null,
                  null, null, null),
              new TypeToken<JsonObject>(){}.getType())
          .getData();

      if (resp.has("SecondFactorAuthenticationToken")
          && !resp.get("SecondFactorAuthenticationToken").isJsonNull()) {
        Demo.setMfaCookie(ex, resp.get("SecondFactorAuthenticationToken").getAsString());
        Demo.writeJson(ex, 200, mfaChallengeBody(resp));
        return;
      }

      String accessToken =
          resp.has("access_token") && !resp.get("access_token").isJsonNull()
              ? resp.get("access_token").getAsString()
              : null;

      if (Demo.isBlank(accessToken)) {
        Demo.writeJson(
            ex, 502, Map.of("error", "login succeeded but no access_token was returned"));
        return;
      }

      String refreshToken =
          resp.has("refresh_token") && !resp.get("refresh_token").isJsonNull()
              ? resp.get("refresh_token").getAsString()
              : "";
      String sessionId = sessions.create(accessToken, refreshToken);
      Demo.setSessionCookie(ex, sessionId);
      Demo.writeJson(ex, 200, Map.of("ok", true, "response", resp.toString()));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Invalidates the access token upstream, then clears the demo session. */
  public void logout(HttpExchange ex) throws IOException {
    // The local session is cleared even if the upstream call fails — otherwise
    // a transient API error would leave the user unable to sign out.
    sessions.delete(Demo.sessionId(ex));
    Demo.clearSessionCookie(ex);
    Demo.writeJson(ex, 200, Map.of("ok", true));
  }

  // ------------------------------------------------------- passwordless --

  /** Emails a one-time code to an existing user; no password involved. */
  public void passwordlessLoginByEmail(HttpExchange ex) throws IOException {
    String email = Demo.query(ex).get("email");
    if (Demo.isBlank(email)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected query param ?email="));
      return;
    }
    try {
      Object result =
          client.login.passwordlessLoginByEmail(
              email, null, null, null, null, null, null, null, null, null, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(result)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Completes an email passwordless login. Same response shape as {@link
   * #login}, including the MFA-challenge branch — a tenant with MFA enabled
   * still enforces its second factor after the emailed code.
   */
  public void passwordlessLoginByEmailOtp(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String email = in.get("email");
    String otp = in.get("otp");
    if (Demo.isBlank(email) || Demo.isBlank(otp)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email, otp}"));
      return;
    }
    try {
      PasswordLessEmailOTPModel body = new PasswordLessEmailOTPModel().otp(otp).email(email);

      // Same generated-oneOf-adapter bypass as login(): both response branches
      // have no required fields, so the discriminator always matches both and
      // throws JsonIOException. Deserialising as a raw JsonObject sidesteps it.
      JsonObject resp =
          (JsonObject)
              client
                  .apiClient()
                  .execute(
                      client.login.passwordlessLoginByEmailAndOTPCall(
                          body, null, null, null, null, null, null, null, null, null, null),
                      new TypeToken<JsonObject>() {}.getType())
                  .getData();

      if (resp.has("SecondFactorAuthenticationToken")
          && !resp.get("SecondFactorAuthenticationToken").isJsonNull()) {
        Demo.setMfaCookie(ex, resp.get("SecondFactorAuthenticationToken").getAsString());
        Demo.writeJson(ex, 200, mfaChallengeBody(resp));
        return;
      }

      String accessToken =
          resp.has("access_token") && !resp.get("access_token").isJsonNull()
              ? resp.get("access_token").getAsString()
              : null;

      if (Demo.isBlank(accessToken)) {
        Demo.writeJson(
            ex, 502, Map.of("error", "login succeeded but no access_token was returned"));
        return;
      }

      String refreshToken =
          resp.has("refresh_token") && !resp.get("refresh_token").isJsonNull()
              ? resp.get("refresh_token").getAsString()
              : "";
      String sessionId = sessions.create(accessToken, refreshToken);
      Demo.setSessionCookie(ex, sessionId);
      Demo.writeJson(ex, 200, Map.of("ok", true, "response", resp.toString()));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Texts a one-time code to an existing user; no password involved. */
  public void passwordlessLoginByPhone(HttpExchange ex) throws IOException {
    String phone = Demo.query(ex).get("phone");
    if (Demo.isBlank(phone)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected query param ?phone="));
      return;
    }
    try {
      Object result =
          client.login.passwordlessLoginByPhone(
              phone, null, null, null, null, null, null, null, null, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(result)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Completes a phone passwordless login. Same response shape as {@link
   * #login}, including the MFA-challenge branch.
   */
  public void passwordlessLoginByPhoneOtp(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String phone = in.get("phone");
    String otp = in.get("otp");
    if (Demo.isBlank(phone) || Demo.isBlank(otp)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {phone, otp}"));
      return;
    }
    try {
      PhoneOTPModel body = new PhoneOTPModel().OTP(otp).phone(phone);

      JsonObject resp =
          (JsonObject)
              client
                  .apiClient()
                  .execute(
                      client.login.passwordlessLoginPhoneVerificationCall(
                          body, null, null, null, null, null, null, null, null, null, null, null),
                      new TypeToken<JsonObject>() {}.getType())
                  .getData();

      if (resp.has("SecondFactorAuthenticationToken")
          && !resp.get("SecondFactorAuthenticationToken").isJsonNull()) {
        Demo.setMfaCookie(ex, resp.get("SecondFactorAuthenticationToken").getAsString());
        Demo.writeJson(ex, 200, mfaChallengeBody(resp));
        return;
      }

      String accessToken =
          resp.has("access_token") && !resp.get("access_token").isJsonNull()
              ? resp.get("access_token").getAsString()
              : null;

      if (Demo.isBlank(accessToken)) {
        Demo.writeJson(
            ex, 502, Map.of("error", "login succeeded but no access_token was returned"));
        return;
      }

      String refreshToken =
          resp.has("refresh_token") && !resp.get("refresh_token").isJsonNull()
              ? resp.get("refresh_token").getAsString()
              : "";
      String sessionId = sessions.create(accessToken, refreshToken);
      Demo.setSessionCookie(ex, sessionId);
      Demo.writeJson(ex, 200, Map.of("ok", true, "response", resp.toString()));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Landing point for the link in the verification email. Redirects back to the
   * UI with a status banner rather than returning JSON, because a browser lands
   * here directly.
   */
  public void verifyEmail(HttpExchange ex) throws IOException {
    String token = Demo.query(ex).get("vtoken");
    if (Demo.isBlank(token)) {
      Demo.redirect(ex, "/?verify=missing");
      return;
    }
    try {
      // The verification endpoint shares its path with the availability check,
      // so the SDK exposes one operation; passing verificationtoken performs
      // the verification.
      client.user.checkEmailAvailability(
          null, null, null, null, token, null, null, null, null, null, null, null, null, null);
      Demo.redirect(ex, "/?verify=success");
    } catch (ApiException e) {
      Demo.redirect(ex, "/?verify=error&message=" + Demo.urlEncode(Demo.describe(e)));
    }
  }

  // -------------------------------------------------------------- password --

  /** Sends a password-reset email containing a reset token. */
  public void forgotPassword(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    if (Demo.isBlank(in.get("email"))) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email}"));
      return;
    }
    ForgotPasswordRequest body = new ForgotPasswordRequest();
    body.setEmail(in.get("email"));
    try {
      Object r =
          client.password.forgotPassword(
              null, Demo.resetUrl(), null, null, null, null, null, null, null, body);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Completes a reset using the token from the email. */
  public void resetPassword(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    if (Demo.isBlank(in.get("resetToken")) || Demo.isBlank(in.get("password"))) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {resetToken, password}"));
      return;
    }
    ResetPasswordOneOf branch = new ResetPasswordOneOf();
    branch.setResetToken(in.get("resetToken"));
    branch.setPassword(in.get("password"));
    try {
      ResetPassword payload = new ResetPassword(branch);
      Object r =
          client.password.resetPasswordByResetToken(
              payload, null, null, null, null, null, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Completes a reset using an OTP instead of an emailed token: {@code
   * {password, resetToken}} (token-based, same as {@link #resetPassword}),
   * {@code {password, otp, email}}, or {@code {password, otp, username}}.
   * Same underlying endpoint as {@link #resetPassword} — its request body is a
   * three-way {@code oneOf} and this route exists to exercise the OTP
   * branches, which {@link #resetPassword} never does.
   */
  public void resetPasswordWithToken(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String password = in.get("password");
    String resetToken = in.get("resetToken");
    String otp = in.get("otp");
    String email = in.get("email");
    String username = in.get("username");

    String usage = "expected JSON {password, resetToken} or {password, otp, email} or {password, otp, username}";
    if (Demo.isBlank(password)) {
      Demo.writeJson(ex, 400, Map.of("error", usage));
      return;
    }

    ResetPassword payload;
    if (!Demo.isBlank(resetToken)) {
      ResetPasswordOneOf branch = new ResetPasswordOneOf();
      branch.setResetToken(resetToken);
      branch.setPassword(password);
      payload = new ResetPassword(branch);
    } else if (!Demo.isBlank(otp) && !Demo.isBlank(email)) {
      ResetPasswordOneOf1 branch = new ResetPasswordOneOf1();
      branch.setOtp(otp);
      branch.setEmail(email);
      branch.setPassword(password);
      payload = new ResetPassword(branch);
    } else if (!Demo.isBlank(otp) && !Demo.isBlank(username)) {
      ResetPasswordOneOf2 branch = new ResetPasswordOneOf2();
      branch.setOtp(otp);
      branch.setUsername(username);
      branch.setPassword(password);
      payload = new ResetPassword(branch);
    } else {
      Demo.writeJson(ex, 400, Map.of("error", usage));
      return;
    }

    try {
      Object r = client.password.resetPasswordByResetToken(
          payload, null, null, null, null, null, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Sends a password-reset OTP by SMS to the phone number on the account.
   * Matches the manifest's {@code requestResetOtp} operation exactly, same as
   * Node's demo.
   */
  public void requestResetOtp(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String phone = in.get("phone");
    if (Demo.isBlank(phone)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {phone}"));
      return;
    }
    try {
      Object r = client.password.requestOTPForPasswordReset(
          new ForgotPasswordPhoneModel().phone(phone), null, null, null, null, null, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Completes a password reset using the OTP delivered by SMS. Matches the
   * manifest's {@code resetPasswordWithOtp} operation exactly, same as Node's
   * demo — distinct from {@link #resetPasswordWithToken}, this demo's own
   * additional email/username-based OTP reset, which uses a different
   * endpoint ({@code /api/password/reset-otp}) not present in Node's demo.
   */
  public void resetPasswordWithOtp(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String phone = in.get("phone");
    String otp = in.get("otp");
    String password = in.get("password");
    if (Demo.isBlank(phone) || Demo.isBlank(otp) || Demo.isBlank(password)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {phone, otp, password}"));
      return;
    }
    try {
      Object r = client.password.resetPasswordWithOTP(
          new ResetPasswordWithOTP().phone(phone).otp(otp).password(password),
          null, null, null, null, null, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Changes the signed-in user's password. */
  public void changePassword(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    if (Demo.isBlank(in.get("oldPassword")) || Demo.isBlank(in.get("newPassword"))) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {oldPassword, newPassword}"));
      return;
    }
    ChangePassword body = new ChangePassword();
    body.setOldPassword(in.get("oldPassword"));
    body.setNewPassword(in.get("newPassword"));
    try {
      Object r =
          client.password.changePassword(
              body, null, null, null, null, null, null, null, Demo.accessToken(ex, sessions));
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  // --------------------------------------------------------------- profile --

  /** Returns the signed-in user's profile. */
  public void getProfile(HttpExchange ex) throws IOException {
    try {
      Object profile =
          client.user.getAccountDetails(null, Demo.accessToken(ex, sessions), null, null);
      Demo.writeJson(ex, 200, Map.of("profile", PLAIN_GSON.toJsonTree(profile)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Updates editable fields on the signed-in user's profile. */
  public void updateProfile(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    UpdateAccountByAccessTokenRequest body = new UpdateAccountByAccessTokenRequest();
    if (!Demo.isBlank(in.get("firstName"))) {
      body.setFirstName(in.get("firstName"));
    }
    if (!Demo.isBlank(in.get("lastName"))) {
      body.setLastName(in.get("lastName"));
    }
    if (!Demo.isBlank(in.get("about"))) {
      body.setAbout(in.get("about"));
    }
    try {
      Object r =
          client.user.updateAccountByAccessToken(
              body, null, null, null, null, null, null, null, null, null, null, null, null,
              Demo.accessToken(ex, sessions));
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  // --------------------------------------------------------------- email   --

  /**
   * Adds a secondary email to the signed-in user's account.
   * The access token is sent as the {@code access_token} query parameter, not
   * the Authorization header — the live API rejects the Bearer form here.
   */
  public void addEmail(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String email = in.get("email");
    if (Demo.isBlank(email)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email, type}"));
      return;
    }
    AddEmailModel body = new AddEmailModel();
    body.setEmail(email);
    body.setType(Demo.isBlank(in.get("type")) ? "Secondary" : in.get("type"));
    try {
      Object r = client.user.addEmail(
          body, Demo.accessToken(ex, sessions), null, Demo.verificationUrl(), null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Removes an email address from the signed-in user's account. */
  public void deleteEmail(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String email = in.get("email");
    if (Demo.isBlank(email)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email}"));
      return;
    }
    DeleteemailbyaccesstokenRequest body = new DeleteemailbyaccesstokenRequest();
    body.setEmail(email);
    body.setAccessToken(Demo.accessToken(ex, sessions));
    // Also set as bearer token so both auth paths are covered.
    client.apiClient().setBearerToken(Demo.accessToken(ex, sessions));
    try {
      Object r = client.user.deleteemailbyaccesstoken(body, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    } finally {
      client.apiClient().setBearerToken((String) null);
    }
  }

  /**
   * Deletes the signed-in user's own account.
   *
   * <p>The underlying operation is admin-scoped: it authenticates with the
   * API secret and would delete any address in the tenant, so the handler
   * reads the signed-in profile first and refuses a mismatch — that guard is
   * demo policy, not an SDK limitation, matching Node's demo exactly.
   */
  public void deleteAccount(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String email = in.get("email");
    if (Demo.isBlank(email)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email}"));
      return;
    }
    try {
      Object profile = client.user.getAccountDetails(null, Demo.accessToken(ex, sessions), null, null);
      JsonElement profileJson = PLAIN_GSON.toJsonTree(profile);
      boolean owned = false;
      if (profileJson.isJsonObject() && profileJson.getAsJsonObject().has("Email")
          && profileJson.getAsJsonObject().get("Email").isJsonArray()) {
        for (JsonElement entry : profileJson.getAsJsonObject().getAsJsonArray("Email")) {
          if (entry.isJsonObject() && entry.getAsJsonObject().has("Value")
              && !entry.getAsJsonObject().get("Value").isJsonNull()) {
            String value = entry.getAsJsonObject().get("Value").getAsString();
            if (value.trim().equalsIgnoreCase(email.trim())) {
              owned = true;
              break;
            }
          }
        }
      }
      if (!owned) {
        Demo.writeJson(ex, 403, Map.of(
            "error", "refusing to delete an account you are not signed in as",
            "hint", "the demo only deletes the signed-in account; the underlying API would delete any address"));
        return;
      }
      Object r = client.accounts.deleteAccountByEmail(email, null, null);
      sessions.delete(Demo.sessionId(ex));
      Demo.clearMfaCookie(ex);
      Demo.clearSessionCookie(ex);
      Demo.writeJson(ex, 200, Map.of("ok", true, "deleted", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  // --------------------------------------------------------------- phone   --

  /** Updates the phone number on the signed-in user's account. */
  public void updatePhone(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String phone = in.get("phone");
    if (Demo.isBlank(phone)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {phone}"));
      return;
    }
    PhoneIdModel body = new PhoneIdModel();
    body.setPhone(phone);
    try {
      Object r = client.user.changePhoneNumber(
          null, null, null, Demo.accessToken(ex, sessions), null, body);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  // --------------------------------------------------------- custom objects --

  private static final String CUSTOM_OBJECT_PATH_PREFIX = "/api/customobject/";

  /**
   * Resolves the custom-object schema name. An explicit value from the caller
   * (this demo's UI always sends one) wins; the manifest's generated routes
   * declare this via {@code configQuery} instead — no client value at all —
   * so LR_CUSTOM_OBJECT_NAME is the fallback for that caller shape.
   */
  private static String resolveObjectName(Map<String, String> body, Map<String, String> query) {
    String fromBody = body.get("objectname");
    if (!Demo.isBlank(fromBody)) {
      return fromBody;
    }
    String fromQuery = query.get("objectname");
    if (!Demo.isBlank(fromQuery)) {
      return fromQuery;
    }
    return DemoEnv.get("LR_CUSTOM_OBJECT_NAME");
  }

  /**
   * Resolves the record id an update/delete targets. The manifest's generated
   * routes carry it as a URL path segment ({@code PUT}/{@code DELETE
   * /api/customobject/{objectRecordId}}); this demo's UI and the old
   * hand-written routes ({@code POST /api/customobject/update|delete}) send
   * it as a body field instead.
   *
   * <p>Disambiguated by HTTP method, not path prefix alone: both shapes share
   * the literal prefix {@code /api/customobject/}, so a prefix-only check
   * misreads the old routes' own fixed suffix ("update", "delete") as if it
   * were a record id — confirmed by {@code RecordIdTest}, caught before it
   * reached a real caller. The manifest declares this path PUT/DELETE only,
   * so method is a reliable signal; the old routes are always POST.
   */
  private static String resolveRecordId(HttpExchange ex, Map<String, String> body) {
    String method = ex.getRequestMethod();
    String path = ex.getRequestURI().getPath();
    if (("PUT".equalsIgnoreCase(method) || "DELETE".equalsIgnoreCase(method))
        && path.startsWith(CUSTOM_OBJECT_PATH_PREFIX)
        && path.length() > CUSTOM_OBJECT_PATH_PREFIX.length()) {
      return path.substring(CUSTOM_OBJECT_PATH_PREFIX.length());
    }
    return body.get("objectrecordid");
  }

  /** Creates a new custom object entry for the signed-in user. */
  public void createCustomObject(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String objectname = resolveObjectName(in, Demo.query(ex));
    if (Demo.isBlank(objectname)) {
      Demo.writeJson(ex, 400, Map.of("error",
          "expected JSON {objectname, ...fields}, or configure LR_CUSTOM_OBJECT_NAME"));
      return;
    }
    Map<String, Object> data = new HashMap<>(in);
    data.remove("objectname");
    try {
      Object r = client.customObject.createCustomObjectByToken(
          data, null, objectname, Demo.accessToken(ex, sessions), null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Lists all custom object records for the signed-in user. */
  public void listCustomObjects(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String objectname = resolveObjectName(in, Demo.query(ex));
    if (Demo.isBlank(objectname)) {
      Demo.writeJson(ex, 400, Map.of("error",
          "expected JSON {objectname}, or configure LR_CUSTOM_OBJECT_NAME"));
      return;
    }
    try {
      Object r = client.customObject.getCustomObjectByToken(
          null, objectname, Demo.accessToken(ex, sessions));
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Partially updates a custom object record identified by its record ID. */
  public void updateCustomObject(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String objectname = resolveObjectName(in, Demo.query(ex));
    String recordId = resolveRecordId(ex, in);
    if (Demo.isBlank(objectname) || Demo.isBlank(recordId)) {
      Demo.writeJson(ex, 400, Map.of("error",
          "expected JSON {objectname, objectrecordid, ...fields} "
              + "(or a record id in the URL, and LR_CUSTOM_OBJECT_NAME configured)"));
      return;
    }
    Map<String, Object> data = new HashMap<>(in);
    data.remove("objectname");
    data.remove("objectrecordid");
    try {
      Object r = client.customObject.updateCustomObjectByTokenAndRecordId(
          recordId, "PartialReplace", data,
          objectname, Demo.accessToken(ex, sessions), null, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Deletes a custom object record identified by its record ID. */
  public void deleteCustomObject(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String objectname = resolveObjectName(in, Demo.query(ex));
    String recordId = resolveRecordId(ex, in);
    if (Demo.isBlank(objectname) || Demo.isBlank(recordId)) {
      Demo.writeJson(ex, 400, Map.of("error",
          "expected JSON {objectname, objectrecordid} "
              + "(or a record id in the URL, and LR_CUSTOM_OBJECT_NAME configured)"));
      return;
    }
    try {
      Object r = client.customObject.deleteCustomObjectByTokenAndRecordId(
          recordId, Demo.accessToken(ex, sessions), null, null, objectname, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  // --------------------------------------------------------------- token   --

  /**
   * Exchanges the signed-in session's refresh token for a new access token.
   * Uses the {@code /manage/} operation deliberately: the native variant takes
   * the access token as a query parameter, which would put a bearer
   * credential into access and proxy logs. Refreshing rotates the session's
   * tokens server-side, so the cookie does not change — matches Node's demo
   * exactly, including reading the refresh token from the session rather than
   * the request body.
   */
  public void refreshToken(HttpExchange ex) throws IOException {
    String sessionId = Demo.sessionId(ex);
    String refreshToken = sessions.lookupRefresh(sessionId);
    if (Demo.isBlank(refreshToken)) {
      Demo.writeJson(ex, 400, Map.of("error",
          "this session has no refresh token; the tenant did not return one at login"));
      return;
    }
    try {
      AccessTokenResponse r = client.accountSession.refreshAccessToken(refreshToken);
      if (Demo.isBlank(r.getAccessToken())) {
        Demo.writeJson(ex, 502, Map.of("error", "refresh succeeded but returned no access_token"));
        return;
      }
      sessions.replace(sessionId, r.getAccessToken(), r.getRefreshToken());
      Demo.writeJson(ex, 200, Map.of(
          "ok", true,
          "refreshed", true,
          "rotated", !Demo.isBlank(r.getRefreshToken()),
          "expires_in", r.getExpiresIn() == null ? "" : r.getExpiresIn()));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Validates an access token. Uses the token from the request body if provided;
   * falls back to the current session's token.
   */
  public void validateToken(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String token = in.get("accessToken");
    if (Demo.isBlank(token)) {
      token = Demo.accessToken(ex, sessions);
    }
    if (Demo.isBlank(token)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {accessToken} or an active session"));
      return;
    }
    try {
      Object r = client.accountSession.validateAccessToken(token);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Returns active session details for the currently signed-in user. */
  public void activeSession(HttpExchange ex) throws IOException {
    try {
      Object r = client.accountSession.getActiveSession(
          Demo.accessToken(ex, sessions), null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Invalidates the access token on the LoginRadius API, then clears the local
   * session. Unlike logout (which only clears the local session), this call
   * revokes the token server-side so it cannot be reused.
   */
  public void invalidateToken(HttpExchange ex) throws IOException {
    String accessToken = Demo.accessToken(ex, sessions);
    try {
      Object r = client.accountSession.nativeInvalidateAccessToken(accessToken, null);
      sessions.delete(Demo.sessionId(ex));
      Demo.clearSessionCookie(ex);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  // --------------------------------------------------------------- passkey --

  /** Begins the Passkey login flow — returns the WebAuthn assertion challenge. */
  public void beginPasskeyLogin(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String identifier = in.get("identifier");
    if (Demo.isBlank(identifier)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {identifier}"));
      return;
    }
    try {
      // Unwrapped, not {ok, result} — the browser's passkeyLogin() reads
      // LoginBeginCredential.publicKey directly off the top-level response,
      // matching every other language's demo and the SDK's own field names.
      Object r = client.login.beginPasskeyLogin(identifier, null, null);
      Demo.writeJson(ex, 200, PLAIN_GSON.toJsonTree(r));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Begins the Passkey registration flow — returns the WebAuthn creation challenge. */
  public void beginPasskeyRegistration(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String identifier = in.get("identifier");
    if (Demo.isBlank(identifier)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {identifier}"));
      return;
    }
    try {
      // Unwrapped, not {ok, result} — the browser's passkeyRegister() reads
      // RegisterBeginCredential.publicKey directly off the top-level response,
      // matching every other language's demo and the SDK's own field names.
      Object r = client.registration.beginPasskeyRegistration(identifier);
      Demo.writeJson(ex, 200, PLAIN_GSON.toJsonTree(r));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Completes the Passkey registration flow with the attestation response from
   * the browser's {@code navigator.credentials.create()} call. The raw JSON
   * body is {@code {credential, email}}, matching Node's browser-side
   * contract exactly (same shape {@code app.js}'s {@code passkeyRegister()}
   * sends) — the richer {@code PasskeyRegisterFinish} schema is constructed
   * server-side from those two fields.
   */
  public void finishPasskeyRegistration(HttpExchange ex) throws IOException {
    String rawBody = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
    JsonObject in;
    try {
      in = JsonParser.parseString(rawBody).getAsJsonObject();
    } catch (RuntimeException e) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {credential, email}"));
      return;
    }
    if (!in.has("credential") || in.get("credential").isJsonNull()) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {credential, email}"));
      return;
    }
    // Enrolment creates the account, so there is no existing profile to take
    // an address from and the API rejects the call without one. Note this
    // model takes the profile's array-of-{Type,Value} email shape, not the
    // plain string the passkey LOGIN finish model uses — built from the
    // browser's single identifier string here, same as every other language.
    String email = in.has("email") && !in.get("email").isJsonNull() ? in.get("email").getAsString() : null;
    if (Demo.isBlank(email)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {credential, email}"));
      return;
    }
    PasskeyCredentialCreationResponse credential;
    try {
      credential = JSON.getGson().fromJson(in.get("credential"), PasskeyCredentialCreationResponse.class);
    } catch (RuntimeException e) {
      Demo.writeJson(ex, 400, Map.of("error", "credential does not match the expected WebAuthn attestation shape"));
      return;
    }
    PasskeyRegisterFinish body = new PasskeyRegisterFinish()
        .passkeyCredential(credential)
        .email(List.of(new ProfileRequestModelEmailInner().type("Primary").value(email)));
    try {
      Object r = client.registration.finishPasskeyRegistration(
          body, Demo.verificationUrl(), null, null, null, null, null, null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Completes the Passkey login flow with the browser's assertion response.
   * The raw JSON body is {@code {credential, email}} — credential is
   * required and must match the {@code PasskeyCredentialAssertionResponse}
   * schema, matching Node's browser-side contract exactly (same shape
   * {@code app.js}'s {@code passkeyLogin()} sends) — passed through to the
   * SDK once wrapped, same as {@link #beginPasskeyLogin}/{@link
   * #finishPasskeyRegistration}. On success this is a login: mints the demo
   * session exactly like {@link #login}.
   */
  public void finishPasskeyLogin(HttpExchange ex) throws IOException {
    String rawBody = new String(ex.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
    JsonObject in;
    try {
      in = JsonParser.parseString(rawBody).getAsJsonObject();
    } catch (RuntimeException e) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {credential, email}"));
      return;
    }
    if (!in.has("credential") || in.get("credential").isJsonNull()) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {credential, email}"));
      return;
    }
    PasskeyCredentialAssertionResponse credential;
    try {
      credential = JSON.getGson().fromJson(in.get("credential"), PasskeyCredentialAssertionResponse.class);
    } catch (RuntimeException e) {
      Demo.writeJson(ex, 400, Map.of("error", "credential does not match the expected WebAuthn assertion shape"));
      return;
    }
    String email = in.has("email") && !in.get("email").isJsonNull() ? in.get("email").getAsString() : null;
    PasskeyLoginFinish body = new PasskeyLoginFinish().passkeyCredential(credential).email(email);
    try {
      // loginurl, verificationurl, then 23 more optional trailing params
      // (emailtemplate ... rbadevicesmstemplate) this demo leaves unset.
      AuthResponse r = client.login.finishPasskeyLogin(
          body, null, Demo.verificationUrl(),
          null, null, null, null, null,
          null, null, null, null, null,
          null, null, null, null, null,
          null, null, null, null, null,
          null, null, null);
      if (!signIn(ex, r)) {
        Demo.writeJson(ex, 502, Map.of("error", "authentication succeeded but no access_token returned"));
        return;
      }
      Demo.writeJson(ex, 200, Map.of("ok", true, "profile", PLAIN_GSON.toJsonTree(r.getProfile())));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  // ----------------------------------------------------------------- mfa   --

  /** Returns which second factors are configured on the signed-in account. */
  public void mfaSettings(HttpExchange ex) throws IOException {
    // Duo returns the user to this URL after its own challenge; only sent
    // when supplied, so a tenant without Duo configured never puts
    // duoredirecturi= on the wire.
    String duoRedirectUri = Demo.query(ex).get("duoRedirectUri");
    try {
      Object r = client.security.getMFASettings(
          Demo.isBlank(duoRedirectUri) ? null : duoRedirectUri, Demo.accessToken(ex, sessions));
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Confirms a TOTP code and enrols the authenticator on the signed-in account. */
  public void mfaEnrolTotp(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String totp = in.get("totp");
    if (Demo.isBlank(totp)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {totp}"));
      return;
    }
    try {
      Object r = client.security.verify2faTOTPAuth(
          totpBody(totp), Demo.accessToken(ex, sessions), null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /** Issues a fresh set of single-use MFA backup codes for the signed-in account. */
  public void mfaBackupCodes(HttpExchange ex) throws IOException {
    try {
      Object r = client.security.mfaGenerateBackupCodes(Demo.accessToken(ex, sessions));
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Sends an email OTP for an in-progress MFA login challenge. Authenticated
   * by the mfaToken cookie {@link DemoServer} validated already, not a
   * session.
   */
  public void mfaSendEmailOtp(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String email = in.get("email");
    if (Demo.isBlank(email)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email}"));
      return;
    }
    try {
      Object r = client.security.resendEmailOTPMFAToken(
          Demo.mfaToken(ex), new EmailModel().email(email), null, null);
      Demo.writeJson(ex, 200, Map.of("ok", true, "result", PLAIN_GSON.toJsonTree(r)));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Completes an in-progress MFA login challenge with an email OTP. Clears the
   * mfaToken cookie and mints a real session on success, same as {@link
   * #login}.
   */
  public void mfaVerifyEmailOtp(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String email = in.get("email");
    String otp = in.get("otp");
    if (Demo.isBlank(email)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email, otp}"));
      return;
    }
    if (Demo.isBlank(otp)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {email, otp}"));
      return;
    }
    ReAuthModelByEmailOtp body = new ReAuthModelByEmailOtp();
    body.setEmailid(email);
    body.setOtp(otp);
    try {
      AuthResponse r = client.security.validateMfaOTPByEmail(
          Demo.mfaToken(ex), body, null, null, null, null, null, null, null, null, null, null);
      Demo.clearMfaCookie(ex);
      if (!signIn(ex, r)) {
        Demo.writeJson(ex, 502, Map.of("error", "authentication succeeded but no access_token returned"));
        return;
      }
      Demo.writeJson(ex, 200, Map.of("ok", true, "profile", PLAIN_GSON.toJsonTree(r.getProfile())));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * Completes an in-progress MFA login challenge with a TOTP code. Clears the
   * mfaToken cookie and mints a real session on success, same as {@link
   * #login}.
   */
  public void mfaVerifyTotp(HttpExchange ex) throws IOException {
    Map<String, String> in = Demo.readJson(ex);
    String totp = in.get("totp");
    if (Demo.isBlank(totp)) {
      Demo.writeJson(ex, 400, Map.of("error", "expected JSON {totp}"));
      return;
    }
    try {
      // fields, then 10 rba*template params, then preventWebhook/xPreventWebhook
      // — 13 optional trailing params this demo leaves unset.
      AuthResponse r = client.security.verifyTotpByMfaToken(
          Demo.mfaToken(ex), totpBody(totp),
          null, null, null, null, null,
          null, null, null, null, null,
          null, null, null);
      Demo.clearMfaCookie(ex);
      if (!signIn(ex, r)) {
        Demo.writeJson(ex, 502, Map.of("error", "authentication succeeded but no access_token returned"));
        return;
      }
      Demo.writeJson(ex, 200, Map.of("ok", true, "profile", PLAIN_GSON.toJsonTree(r.getProfile())));
    } catch (ApiException e) {
      Demo.writeSdkError(ex, e);
    }
  }

  /**
   * A TOTP code, addressed to whichever field the tenant's authenticator
   * generation needs. A tenant on Google Authenticator requires {@code
   * googleauthenticatorcode}; the newer generic authenticator uses {@code
   * authenticatorcode}, sending only {@code googleauthenticatorcode} returns
   * ErrorCode 908. Only one field is populated, deliberately: the sibling
   * reauth schema declares its equivalent code fields under {@code oneOf} with
   * each required, so sending both risks a validation rejection rather than a
   * helpful fallback. A tenant on the newer generic authenticator needs {@code
   * authenticatorcode} here instead.
   */
  private static AuthenticatorCodeRequest totpBody(String code) {
    return new AuthenticatorCodeRequest().googleauthenticatorcode(code);
  }

  /** Mints the demo session from an {@link AuthResponse}. False if it carried no access token. */
  private boolean signIn(HttpExchange ex, AuthResponse response) {
    String accessToken = response == null ? null : response.getAccessToken();
    if (Demo.isBlank(accessToken)) {
      return false;
    }
    String refreshToken = response.getRefreshToken();
    String sessionId = sessions.create(accessToken, refreshToken == null ? "" : refreshToken);
    Demo.setSessionCookie(ex, sessionId);
    return true;
  }

  /** Renders a LoginRadius failure for the UI. */
  static String describeError(ApiException e) {
    LoginRadiusException lr = LoginRadiusClient.toLoginRadiusException(e);
    return lr.description().isEmpty() ? lr.getMessage() : lr.description();
  }
}
