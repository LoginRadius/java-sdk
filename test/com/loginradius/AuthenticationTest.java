package com.loginradius;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assume;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.models.*;
import com.loginradius.sdk.models.customregistrationdata.*;
import com.loginradius.sdk.models.email.*;
import com.loginradius.sdk.models.userprofile.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~AuthenticationTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Add Email (POST)
    @Test
    public void test_post_addEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject json = new JsonObject();
            json.addProperty("email", "lr-javasdk" + System.currentTimeMillis() + "@mailinator.com");
            json.addProperty("type", "Tertiary");
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.ADD_EMAIL, null, json);
            RegisterResponse res = client.getResponse(api, RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Forgot Password (POST)
    @Test
    public void test_post_forgotPassword() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("resetpasswordurl", "https://docs.loginradius.com/api");
            JsonObject json = new JsonObject();
            json.addProperty("email", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.FORGOT_PASSWORD_BYEMAIL, params, json);
            RegisterResponse res = client.getResponse(api, RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // User Registration by Email (POST)
    @Test
    public void test_post_register() {
        String email = "lr-javasdk" + System.currentTimeMillis() + "@mailinator.com";
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("sott", helper.generateSott());

            JsonArray emailArray = new JsonArray();
            JsonObject primaryEmailObj = new JsonObject();
            primaryEmailObj.addProperty("Type", "Primary");
            primaryEmailObj.addProperty("Value", email);
            emailArray.add(primaryEmailObj);

            JsonObject payload = new JsonObject();
            payload.add("Email", emailArray);
            payload.addProperty("Password", email);

            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.REGISTER, params, payload);
            RegisterResponse res = client.getResponse(api,RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            // tear down: get vtoken -> verify email -> login -> del acc
            Map<String, String> params = new HashMap<String,String>();
            params.put("verificationtoken", helper.getVerificationToken(email));
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.VERIFY_EMAIL, params);
            api.getResponse("");
            helper.deleteAccount(helper.login(email).getProfile().getUid());
        }
    }

    // Login by Email (POST)
    @Test
    public void test_post_loginByEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject json = new JsonObject();
            json.addProperty("email", account.getEmail().get(0).getValue());
            json.addProperty("password", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.EMAIL_LOGIN, null, json);
            LoginData res = client.getResponse(api, LoginData.class);

            Assert.assertNotNull(res.getAccessToken());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Login by Username (POST)
    @Test
    public void test_post_loginByUsername() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject json = new JsonObject();
            json.addProperty("username", account.getUserName().toString());
            json.addProperty("password", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.USERNAME_LOGIN, null, json);
            LoginData res = client.getResponse(api, LoginData.class);

            Assert.assertNotNull(res.getAccessToken());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Check Email Availability (GET)
    @Test
    public void test_get_emailAvailability() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("email", "lr-javasdk@mailinator.com");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.CHECK_EMAIL_AVAILABILITY, params);
            CheckAvailability res = client.getResponse(api, CheckAvailability.class);

            Assert.assertNotNull(res.getIsExist());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Check Username Availability (GET)
    @Test
    public void test_get_usernameAvailability() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("username", "lr-javasdk");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.CHECK_USERNAME_AVAILABILITY, params);
            CheckAvailability res = client.getResponse(api, CheckAvailability.class);

            Assert.assertNotNull(res.getIsExist());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Read all Profiles by Token (GET)
    @Test
    public void test_get_readAllProfiles() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.READACCOUNT_BYTOKEN,null);
            LoginRadiusUltimateUserProfile res = client.getResponse(api,LoginRadiusUltimateUserProfile.class);

            Assert.assertNotNull(res.getUid());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Privacy Policy Accept (GET)
    @Test
    public void test_get_privacyPolicyAccept() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.ACCEPT_PRIVACY_POLICY, null);
            LoginRadiusUltimateUserProfile res = client.getResponse(api,LoginRadiusUltimateUserProfile.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "There is no privacy policy available currently for your LoginRadius site.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Send Welcome Email (GET)
    @Test
    public void test_get_sendWelcomeEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SEND_WELCOME_EMAIL, null);
            PostAPIResponse res = client.getResponse(api,PostAPIResponse.class);

            Assert.assertNotNull(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Get Social Identity (GET)
    @Test
    public void test_get_getSocialId() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.GET_SOCIAL_IDENTITY, null);
            LoginRadiusUltimateUserProfile res = client.getResponse(api,LoginRadiusUltimateUserProfile.class);

            Assert.assertNotNull(res.getUid());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Validate Access token (GET)
    @Test
    public void test_get_validateToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());

            Map<String, String> params = new HashMap<String,String>();
            params.put("access_token", login.getAccessToken());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.VALIDATE_ACCESSTOKEN, params);
            AccessToken res = client.getResponse(api,AccessToken.class);

            Assert.assertNotNull(res.getAccessToken());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Verify Email (GET)
    @Test
    public void test_get_verifyEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(false, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("verificationtoken", helper.getVerificationToken(account.getEmail().get(0).getValue()));
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.VERIFY_EMAIL, params);
            EmailVerificationResponse res = client.getResponse(api,EmailVerificationResponse.class);

            Assert.assertNotNull(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Delete Account (GET)
    @Test
    public void test_get_deleteAccount() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("deletetoken", "999999");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.GET_DELETE_ACCOUNT, params);
            client.getResponse(api, PostAPIResponse.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Invalidate Access token (GET)
    @Test
    public void test_get_invalidateToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());

            Map<String, String> params = new HashMap<String,String>();
            params.put("access_token", login.getAccessToken());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.INVALIDATE_ACCESSTOKEN, params);
            RegisterResponse res = client.getResponse(api,RegisterResponse.class);

            Assert.assertNotNull(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Get Security Questions By Access Token (GET)
    @Test
    public void test_get_securityQuestionByToken() {
        Assume.assumeFalse("Test ignored::SECURITY_QUESTION_ID required", TestConstant.SECURITY_QUESTION_ID.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            helper.setAccountSecurityQuestion(login.getAccessToken(), TestConstant.SECURITY_QUESTION_ID, "answer");
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SECURITYQUESTIONS_BYACCESSTOKEN, null);
            GetSecurityQuestionsResponse[] res = client.getResponse(api,GetSecurityQuestionsResponse[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Get Security Questions By Email (GET)
    @Test
    public void test_get_securityQuestionByEmail() {
        Assume.assumeFalse("Test ignored::SECURITY_QUESTION_ID required", TestConstant.SECURITY_QUESTION_ID.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            helper.setAccountSecurityQuestion(login.getAccessToken(), TestConstant.SECURITY_QUESTION_ID, "answer");
            client.setToken(login.getAccessToken());

            Map<String, String> params = new HashMap<String,String>();
            params.put("email", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SECURITYQUESTIONS_BYEMAIL, params);
            GetSecurityQuestionsResponse[] res = client.getResponse(api,GetSecurityQuestionsResponse[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Get Security Questions By Username (GET)
    @Test
    public void test_get_securityQuestionByUsername() {
        Assume.assumeFalse("Test ignored::SECURITY_QUESTION_ID required", TestConstant.SECURITY_QUESTION_ID.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            helper.setAccountSecurityQuestion(login.getAccessToken(), TestConstant.SECURITY_QUESTION_ID, "answer");
            client.setToken(login.getAccessToken());

            Map<String, String> params = new HashMap<String,String>();
            params.put("username", account.getUserName().toString());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SECURITYQUESTIONS_BYUSERNAME, params);
            GetSecurityQuestionsResponse[] res = client.getResponse(api,GetSecurityQuestionsResponse[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Get Security Questions By Phone (GET)
    @Test
    public void test_get_securityQuestionByPhone() {
        Assume.assumeFalse("Test ignored::SECURITY_QUESTION_ID required", TestConstant.SECURITY_QUESTION_ID.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            helper.setAccountSecurityQuestion(login.getAccessToken(), TestConstant.SECURITY_QUESTION_ID, "answer");
            client.setToken(login.getAccessToken());

            Map<String, String> params = new HashMap<String,String>();
            params.put("phone", account.getPhoneId().toString());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SECURITYQUESTIONS_BYPHONE, params);
            GetSecurityQuestionsResponse[] res = client.getResponse(api,GetSecurityQuestionsResponse[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Verify Email by OTP (PUT)
    @Test
    public void test_put_verifyEmailByOtp() {
        try {
            JsonObject json = new JsonObject();
            json.addProperty("otp", "99999");
            json.addProperty("email", "lr-javasdk@mailinator.com");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.VERIFY_EMAIL_BY_OTP, null, json);
            client.getResponse(api, EmailVerificationResponse.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Change Password (PUT)
    @Test
    public void test_put_changePassword() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject json = new JsonObject();
            json.addProperty("oldpassword", account.getEmail().get(0).getValue());
            json.addProperty("newpassword", "123456");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.CHANGE_PASSWORD, null, json);
            RegisterResponse res = client.getResponse(api,RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Link Social Identities (PUT)
    @Test
    public void test_put_accountLink() {
        Assume.assumeFalse("Test ignored::CANDIDATE_TOKEN required", TestConstant.CANDIDATE_TOKEN.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());

            Map<String, String> params = new HashMap<String,String>();
            params.put("access_token", login.getAccessToken());
            JsonObject json = new JsonObject();
            json.addProperty("candidatetoken", TestConstant.CANDIDATE_TOKEN);
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.LINK_SOCIALIDENTITIES, params, json);
            RegisterResponse res = client.getResponse(api,RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Resend Email Verification (PUT)
    @Test
    public void test_put_resendEmailVerification() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(false, false);

            JsonObject json = new JsonObject();
            json.addProperty("email", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.RESEND_EMAIL_VERIFICATION, null, json);
            RegisterResponse res = client.getResponse(api,RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Reset Password by Reset Token (PUT)
    @Test
    public void test_put_resetPasswordByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject json = new JsonObject();
            json.addProperty("resettoken", helper.getForgotPasswordToken(account.getEmail().get(0).getValue()));
            json.addProperty("password", "123456");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.RESET_PASSWORD, null, json);
            RegisterResponse res = client.getResponse(api,RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Reset Password by OTP (PUT)
    @Test
    public void test_put_resetPasswordByOTP() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject json = new JsonObject();
            json.addProperty("otp", "99999");
            json.addProperty("email", account.getEmail().get(0).getValue());
            json.addProperty("password", "123456");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.RESET_PASSWORD_BY_OTP, null, json);
            client.getResponse(api, RegisterResponse.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Reset Password by Security Answer and Email (PUT)
    @Test
    public void test_put_resetPasswordByEmail() {
        Assume.assumeFalse("Test ignored::SECURITY_QUESTION_ID required", TestConstant.SECURITY_QUESTION_ID.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            helper.setAccountSecurityQuestion(login.getAccessToken(), TestConstant.SECURITY_QUESTION_ID, "answer");

            JsonObject json = new JsonObject();
            JsonObject securityanswer = new JsonObject();
            securityanswer.addProperty(TestConstant.SECURITY_QUESTION_ID, "answer");
            json.add("securityanswer", securityanswer);
            json.addProperty("email", account.getEmail().get(0).getValue());
            json.addProperty("password", "123456");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.RESET_PASSWORD_BYSECURITYANSWER, null, json);
            RegisterResponse res = client.getResponse(api, RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Reset Password by Security Answer and Phone (PUT)
    @Test
    public void test_put_resetPasswordByPhone() {
        Assume.assumeFalse("Test ignored::SECURITY_QUESTION_ID required", TestConstant.SECURITY_QUESTION_ID.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            helper.setAccountSecurityQuestion(login.getAccessToken(), TestConstant.SECURITY_QUESTION_ID, "answer");

            JsonObject json = new JsonObject();
            JsonObject securityanswer = new JsonObject();
            securityanswer.addProperty(TestConstant.SECURITY_QUESTION_ID, "answer");
            json.add("securityanswer", securityanswer);
            json.addProperty("phone", account.getPhoneId().toString());
            json.addProperty("password", "123456");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.RESET_PASSWORD_BYSECURITYANSWER, null, json);
            RegisterResponse res = client.getResponse(api, RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Reset Password by Security Answer and Username (PUT)
    @Test
    public void test_put_resetPasswordByUsername() {
        Assume.assumeFalse("Test ignored::SECURITY_QUESTION_ID required", TestConstant.SECURITY_QUESTION_ID.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            helper.setAccountSecurityQuestion(login.getAccessToken(), TestConstant.SECURITY_QUESTION_ID, "answer");

            JsonObject json = new JsonObject();
            JsonObject securityanswer = new JsonObject();
            securityanswer.addProperty(TestConstant.SECURITY_QUESTION_ID, "answer");
            json.add("securityanswer", securityanswer);
            json.addProperty("username", account.getUserName().toString());
            json.addProperty("password", "123456");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.RESET_PASSWORD_BYSECURITYANSWER, null, json);
            RegisterResponse res = client.getResponse(api, RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Set or Change UserName (PUT)
    @Test
    public void test_put_changeUsername() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject json = new JsonObject();
            json.addProperty("username", "lr-javasdk");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.CHANGE_USERNAME, null, json);
            RegisterResponse res = client.getResponse(api, RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Update Profile by Token (PUT)
    @Test
    public void test_put_updateProfileByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject json = new JsonObject();
            json.addProperty("FirstName", "Login");
            json.addProperty("LastName", "Radius");
            json.addProperty("Password", "123456");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.UPDATE_ACCOUNT_BYTOKEN, null, json);
            RegisterResponse res = client.getResponse(api, RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Update Security Question by Access token (PUT)
    @Test
    public void test_put_updateSecurityQuestionByToken() {
        Assume.assumeFalse("Test ignored::SECURITY_QUESTION_ID required", TestConstant.SECURITY_QUESTION_ID.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject json = new JsonObject();
            JsonObject securityquestionanswer = new JsonObject();
            securityquestionanswer.addProperty(TestConstant.SECURITY_QUESTION_ID, "answer");
            json.add("securityquestionanswer", securityquestionanswer);
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.UPDATE_SECURITY_QUESTION_BY_TOKEN, null, json);
            RegisterResponse res = client.getResponse(api, RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Delete Account with Email Confirmation (DEL)
    @Test
    public void test_del_deleteAccount() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationDeleteAPI(LoginRadiusConstant.DELETE_ACCOUNT_WITH_EMAIL_CONFIRMATION, null, null);
            EmailDeleteRequest res = client.getResponse(api, EmailDeleteRequest.class);

            Assert.assertTrue(res.getIsDeleteRequestAccepted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Remove Email (DEL)
    @Test
    public void test_del_removeEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject json = new JsonObject();
            json.addProperty("email", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationDeleteAPI(LoginRadiusConstant.REMOVE_EMAIL, null, json);
            DeleteResponse res = client.getResponse(api, DeleteResponse.class);

            Assert.assertTrue(res.getIsDeleted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Unlink Social Identities (DEL)
    @Test
    public void test_del_accountUnlink() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());

            Map<String, String> params = new HashMap<String,String>();
            params.put("access_token", login.getAccessToken());
            JsonObject json = new JsonObject();
            json.addProperty("provider", login.getProfile().getRegistrationProvider());
            json.addProperty("providerid", login.getProfile().getUid());
            LRAuthenticationAPI api = new AuthenticationDeleteAPI(LoginRadiusConstant.UNLINK_SOCIALIDENTITIES, params, json);
            client.getResponse(api, DeleteResponse.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }
}