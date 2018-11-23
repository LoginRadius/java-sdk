package com.loginradius;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assume;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.advanced.api.*;
import com.loginradius.sdk.models.configuration.*;
import com.loginradius.sdk.models.activesession.*;
import com.loginradius.sdk.models.sott.*;
import com.loginradius.sdk.models.servertime.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import java.util.HashMap;
import java.util.Map;

public class InfrastructureTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~InfrastructureTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Get Configurations (GET)
    @Test
    public void test_get_config() {
        try {
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.CONFIGURATION, null);
            ConfigurationResponse res = client.getResponse(api, ConfigurationResponse.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Get Server Time (GET)
    @Test
    public void test_get_servertime() {
        try {
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.SERVERTIME, null);
            ServerTimeResponse res = client.getResponse(api, ServerTimeResponse.class);

            Assert.assertNotNull(res.getCurrentTime());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Generate SOTT (GET)
    @Test
    public void test_get_sott() {
        try {
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.GENERATE_SOTT, null);
            SottResponse res = client.getResponse(api, SottResponse.class);

            Assert.assertNotNull(res.getSott());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Get Active Session Details (GET)
    @Test
    public void test_get_session() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            Map<String, String> params = new HashMap<String,String>();
            params.put("token", login.getAccessToken());
            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.GET_ACTIVESESSION, params);
            ActiveSessionResponse res = client.getResponse(api, ActiveSessionResponse.class);

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
}
