package com.loginradius;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assume;

import com.loginradius.sdk.advanced.api.*;
import com.loginradius.sdk.models.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.models.userprofile.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import java.util.HashMap;
import java.util.Map;

public class TokenManagementTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~TokenManagementTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Access Token via Facebook Token (GET)
    @Test
    public void test_get_viaFbToken() {
        Assume.assumeFalse("Test ignored::FACEBOOK_TOKEN required", TestConstant.FACEBOOK_TOKEN.equals(""));
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("fb_access_token", TestConstant.FACEBOOK_TOKEN);
            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.ACCESS_TOKEN_VIA_FBTOKEN, params);
            AccessToken res = client.getResponse(api, AccessToken.class);

            Assert.assertNotNull(res.getAccessToken());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Access Token via Twitter Token (GET)
    @Test
    public void test_get_viaTwToken() {
        Assume.assumeFalse("Test ignored::TWITTER_TOKEN and TWITTER_SECRET required", TestConstant.TWITTER_TOKEN.equals("") || TestConstant.TWITTER_SECRET.equals(""));
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("tw_access_token", TestConstant.TWITTER_TOKEN);
            params.put("tw_token_secret", TestConstant.TWITTER_SECRET);
            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.ACCESS_TOKEN_VIA_TWTOKEN, params);
            AccessToken res = client.getResponse(api, AccessToken.class);

            Assert.assertNotNull(res.getAccessToken());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Access Token via Vkontakte Token (GET)
    @Test
    public void test_get_viaVkToken() {
        Assume.assumeFalse("Test ignored::VKONTAKTE_TOKEN required", TestConstant.VKONTAKTE_TOKEN.equals(""));
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("vk_access_token", TestConstant.VKONTAKTE_TOKEN);
            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.ACCESS_TOKEN_VIA_VKTOKEN, params);
            AccessToken res = client.getResponse(api, AccessToken.class);

            Assert.assertNotNull(res.getAccessToken());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Access Token via Google JWT (GET)
    @Test
    public void test_get_viaGoogleToken() {
        Assume.assumeFalse("Test ignored::GOOGLE_TOKEN required", TestConstant.GOOGLE_TOKEN.equals(""));
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("id_token", TestConstant.GOOGLE_TOKEN);
            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.ACCESS_TOKEN_VIA_GOOGLEJWT, params);
            AccessToken res = client.getResponse(api, AccessToken.class);

            Assert.assertNotNull(res.getAccessToken());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Refresh User Profile (GET)
    @Test
    public void test_get_refreshProfile() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.REFRESH_PROFILE, null);
            LoginRadiusUltimateUserProfile res = client.getResponse(api, LoginRadiusUltimateUserProfile.class);

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

    // Refresh Token (GET)
    @Test
    public void test_get_refreshToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.REFRESHTOKEN, null);
            AccessToken res = client.getResponse(api, AccessToken.class);

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

}
