package com.loginradius;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.BeforeClass;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.models.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.models.phone.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

public class PhoneAuthenticationTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~PhoneAuthenticationTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Phone Login (POST)
    @Test
    public void test_post_login() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);

            JsonObject json = new JsonObject();
            json.addProperty("phone", account.getPhoneId().toString());
            json.addProperty("password", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.POST_LOGINBY_PHONE, null, json);
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

    // Phone Forgot Password by OTP (POST)
    @Test
    public void test_post_forgotPasswordByOtp() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);

            JsonObject json = new JsonObject();
            json.addProperty("phone", account.getPhoneId().toString());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.FORGOT_PASSWORDBY_OTP, null, json);
            PhoneForgotPasswordResponse res = client.getResponse(api,PhoneForgotPasswordResponse.class);

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

    // Phone Resend Verification OTP (POST)
    @Test
    public void test_post_resendOtp() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject json = new JsonObject();
            json.addProperty("phone", account.getPhoneId().toString());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.RESEND_OTP, null, json);
            PhoneSendOtpResponse res = client.getResponse(api,PhoneSendOtpResponse.class);

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

    // Phone Resend Verification OTP by Token (POST)
    @Test
    public void test_post_resendOtpByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject json = new JsonObject();
            json.addProperty("phone", account.getPhoneId().toString());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.RESEND_OTP_BYTOKEN, null, json);
            PhoneSendOtpResponse res = client.getResponse(api,PhoneSendOtpResponse.class);

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

    // Phone Number Availability (GET)
    @Test
    public void test_get_phoneAvailability() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("phone", "12016768877");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.PHONE_AVAILABILITY, params);
            CheckAvailability res = client.getResponse(api,CheckAvailability.class);

            Assert.assertNotNull(res.getIsExist());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Phone Number Update (PUT)
    @Test
    public void test_put_updatePhone() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject json = new JsonObject();
            json.addProperty("phone", "12016768887");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.UPDATE_PHONE, null, json);
            PhoneForgotPasswordResponse res = client.getResponse(api,PhoneForgotPasswordResponse.class);

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

    // Phone Reset Password by OTP (PUT)
    @Test
    public void test_put_resetPasswordByOtp() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject json = new JsonObject();
            json.addProperty("phone", account.getPhoneId().toString());
            json.addProperty("otp", "99999");
            json.addProperty("password", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.PHONE_RESET_PASSWORD_BYOTP, null, json);
            client.getResponse(api,RegisterResponse.class);
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

    // Phone Verification by OTP (PUT)
    @Test
    public void test_put_verificationByOtp() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("otp", "99999");
            JsonObject json = new JsonObject();
            json.addProperty("phone", account.getPhoneId().toString());
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.VERIFYOTP, params, json);
            client.getResponse(api, LoginData.class);
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

    // Phone Verification OTP by Token (PUT)
    @Test
    public void test_put_verifyOtpByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            Map<String, String> params = new HashMap<String,String>();
            params.put("otp","99999");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.VERIFY_OTP_BYTOKEN, params, null);
            client.getResponse(api,RegisterResponse.class);
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

    // Reset phone ID verification (PUT)
    @Test
    public void test_put_resetVerification() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.RESET_PHONEID_VERIFICATION, params, null);
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

    // Remove Phone ID by Access Token (DEL)
    @Test
    public void test_put_removePhoneByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationDeleteAPI(LoginRadiusConstant.REMOVE_PHONE_BY_ACCESSTOKEN, null, null);
            DeleteResponse res = client.getResponse(api, DeleteResponse.class);

            Assert.assertNotNull(res.getIsDeleted());
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
}
