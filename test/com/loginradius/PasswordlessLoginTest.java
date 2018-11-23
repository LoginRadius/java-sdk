package com.loginradius;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.BeforeClass;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.models.onetouch.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

public class PasswordlessLoginTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~PasswordlessLoginTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Passwordless Login By Email (GET)
    @Test
    public void test_get_loginByEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("email", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.PASSWORDLESS_LOGIN,params);
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

    // Passwordless Login By Username (GET)
    @Test
    public void test_get_loginByUsername() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("username", account.getUserName().toString());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.PASSWORDLESS_LOGIN,params);
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

    // Passwordless Login Verification (GET)
    @Test
    public void test_get_verify() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("verificationtoken","99999");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.PASSWORDLESS_LOGIN_VERIFICATION,params);
            client.getResponse(api,LoginData.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Phone Send One Time Passcode (GET)
    @Test
    public void test_get_sendOtp() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("phone", account.getPhoneId().toString());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.PHONE_SEND_ONETIMEPASSCODE, params);
            AccountSidResponse res = client.getResponse(api, AccountSidResponse.class);

            Assert.assertNotNull(res.getData().getAccountSid());
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

    // Phone Login Using One Time Passcode (PUT)
    @Test
    public void test_put_loginByOtp() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject payload = new JsonObject();
            payload.addProperty("phone", account.getPhoneId().toString());
            payload.addProperty("otp", "99999");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.PHONE_LOGIN_USING_ONETIMEPASSCODE,null,payload);
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
}
