package com.loginradius;

import org.junit.*;

import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.advanced.api.*;
import com.loginradius.sdk.models.*;
import com.loginradius.sdk.models.webhook.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

public class WebhooksTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~WebhooksTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // WebHook Subscribe API (POST)
    @Test
    public void test_post_subscribe() {
        JsonObject json = new JsonObject();
        try {
            json.addProperty("TargetUrl", "https://www.lr-javasdk" + System.currentTimeMillis() + ".ca");
            json.addProperty("Event", "Register");
            LRAdvancedAPI sub = new AdvancedPostAPI(LoginRadiusConstant.WEBHOOK_SUBSCRIBE, null, json);
            PostAPIResponse res = client.getResponse(sub, PostAPIResponse.class);

            Assert.assertNotNull(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            LRManagementAPI unsub = new ManagementDeleteAPI(LoginRadiusConstant.WEBHOOK_UNSUBSCRIBE, null, json);
            unsub.getResponse("");
        }
    }

    // Webhook Test (GET)
    @Test
    public void test_get_test() {
        try {
            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.WEBHOOK_TEST, null);
            WebhookTestResponse res = client.getResponse(api, WebhookTestResponse.class);

            Assert.assertNotNull(res.getIsAllowed());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Webhook Subscribed URLs (GET)
    @Test
    public void test_get_subscribed() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("event", "Register");
            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.WEBHOOK_SUBSCRIBED_URLS, params);
            WebhookResponse res = client.getResponse(api, WebhookResponse.class);

            Assert.assertNotNull(res.getCount());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // WebHook Unsubscribe (DEL)
    @Test
    public void test_del_unsub() {
        try {
            JsonObject json = new JsonObject();
            json.addProperty("TargetUrl", "https://www.lr-javasdk" + System.currentTimeMillis() + ".ca");
            json.addProperty("Event", "Register");
            LRAdvancedAPI sub = new AdvancedPostAPI(LoginRadiusConstant.WEBHOOK_SUBSCRIBE, null, json);
            sub.getResponse("");

            LRManagementAPI unsub = new ManagementDeleteAPI(LoginRadiusConstant.WEBHOOK_UNSUBSCRIBE, null, json);
            DeleteResponse res = client.getResponse(unsub, DeleteResponse.class);

            Assert.assertTrue(res.getIsDeleted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
