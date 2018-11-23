package com.loginradius;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.BeforeClass;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

public class OneTouchLoginTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~OneTouchLoginTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // One Touch Login by Email (POST)
    @Test
    public void test_post_loginByEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("clientguid", account.getUid().toString());
            payload.addProperty("email", account.getEmail().get(0).getValue());
            payload.addProperty("qq_captcha_ticket", "aaa");
            payload.addProperty("qq_captcha_randstr", "aaa");
            payload.addProperty("g-recaptcha-response", "aaa");
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.ONE_TOUCH_LOGIN_BY_EMAIL,null, payload);
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

    // One Touch Login by Phone (POST)
    @Test
    public void test_post_loginByPhone() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("phone", account.getPhoneId().toString());
            payload.addProperty("name", "aaa");
            payload.addProperty("qq_captcha_ticket", "aaa");
            payload.addProperty("qq_captcha_randstr", "aaa");
            payload.addProperty("g-recaptcha-response", "aaa");
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.ONE_TOUCH_LOGIN_BY_PHONE,null, payload);
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

    // One Touch Verify OTP (PUT)
    @Test
    public void test_put_verifyOtp() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("otp","99999");
            JsonObject payload = new JsonObject();
            payload.addProperty("phone", account.getPhoneId().toString());
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.ONE_TOUCH_OTP_VERIFICATION,params,payload);
            client.getResponse(api,LoginData.class);
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
