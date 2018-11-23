package com.loginradius;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.BeforeClass;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.models.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import java.util.HashMap;
import java.util.Map;

public class SmartLoginTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~SmartLoginTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Smart Login By Email (GET)
    @Test
    public void test_get_loginByEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("email", account.getEmail().get(0).getValue());
            params.put("clientguid", account.getUid().toString());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SMART_LOGIN,params);
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

    // Smart Login By Username (GET)
    @Test
    public void test_get_loginByUsername() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("username", account.getUserName().toString());
            params.put("clientguid", account.getUid().toString());
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SMART_LOGIN,params);
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

    // Smart Login Ping (GET)
    @Test
    public void test_get_ping() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("clientguid","99999");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SMART_LOGIN_PING,params);
            client.getResponse(api,LoginData.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Smart Login Verify Token (GET)
    @Test
    public void test_get_verifyToken() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("verificationtoken","99999");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SMART_LOGIN_VERIFYTOKEN,params);
            client.getResponse(api,VerifiedResponse.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
