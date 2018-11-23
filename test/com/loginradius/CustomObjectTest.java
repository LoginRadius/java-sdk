package com.loginradius;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assume;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.models.customobject.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

public class CustomObjectTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~CustomObjectTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        Assume.assumeFalse("Test ignored::CUSTOM_OBJECT_NAME required", TestConstant.CUSTOM_OBJECT_NAME.equals(""));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Create Custom Object by UID (POST)
    @Test
    public void test_post_createByUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map < String, String > params = new HashMap < String, String > ();
            params.put("uid", account.getUid().toString());
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            JsonObject json = new JsonObject();
            json.addProperty("anything", "i want");
            LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.CREATE_CUSTOM_OBJECT, params, json);
            CreateCustomObject res = client.getResponse(api, CreateCustomObject.class);

            Assert.assertNotNull(res.getId());
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

    // Create Custom Object by Token (POST)
    @Test
    public void test_post_createByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            Map < String, String > params = new HashMap < String, String > ();
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            JsonObject json = new JsonObject();
            json.addProperty("anything", "i want");
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.CREATE_CUSTOM_OBJECT, params, json);
            CreateCustomObject res = client.getResponse(api, CreateCustomObject.class);

            Assert.assertNotNull(res.getId());
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

    // Custom Object by ObjectRecordId and UID (GET)
    @Test
    public void test_get_byObjectRecordIdAndUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            String objectRecordId = helper.setAccountCustomObject(account.getUid().toString());

            Map < String, String > params = new HashMap < String, String > ();
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            params.put("uid", account.getUid().toString());
            params.put("objectrecordid", objectRecordId);
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.CUSTOMOBJECT_BYID, params);
            CreateCustomObject res = client.getResponse(api, CreateCustomObject.class);

            Assert.assertNotNull(res.getId());
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

    // Custom Object by ObjectRecordId and Token (GET)
    @Test
    public void test_get_byObjectRecordIdAndToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());
            String objectRecordId = helper.setAccountCustomObject(account.getUid().toString());

            Map < String, String > params = new HashMap < String, String > ();
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            params.put("objectrecordid", objectRecordId);
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.CUSTOMOBJECT_BYID, params);
            CreateCustomObject res = client.getResponse(api, CreateCustomObject.class);

            Assert.assertNotNull(res.getId());
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

    // Custom Object by UID (GET)
    @Test
    public void test_get_byUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            helper.setAccountCustomObject(account.getUid().toString());

            Map < String, String > params = new HashMap < String, String > ();
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.CUSTOMOBJECT_BYUID, params);
            ReadCustomObject res = client.getResponse(api, ReadCustomObject.class);

            Assert.assertNotNull(res.getData());
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

    // Custom Object by Token (GET)
    @Test
    public void test_get_byToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());
            helper.setAccountCustomObject(account.getUid().toString());

            Map < String, String > params = new HashMap < String, String > ();
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.CUSTOMOBJECT_BYTOKEN, params);
            ReadCustomObject res = client.getResponse(api, ReadCustomObject.class);

            Assert.assertNotNull(res.getData());
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

    // Custom Object Update by UID (PUT)
    @Test
    public void test_put_updateByUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            String objectRecordId = helper.setAccountCustomObject(account.getUid().toString());

            Map < String, String > params = new HashMap < String, String > ();
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            params.put("updatetype", "replace");
            params.put("uid", account.getUid().toString());
            params.put("objectrecordid", objectRecordId);
            JsonObject json = new JsonObject();
            json.addProperty("loginradius", "java sdk");
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.UPDATE_OBJECT_BYRECORDID, params, json);
            CreateCustomObject res = client.getResponse(api, CreateCustomObject.class);

            Assert.assertNotNull(res.getId());
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

    // Custom Object Update by Access Token (PUT)
    @Test
    public void test_put_updateByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());
            String objectRecordId = helper.setAccountCustomObject(account.getUid().toString());

            Map < String, String > params = new HashMap < String, String > ();
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            params.put("updatetype", "replace");
            params.put("objectrecordid", objectRecordId);
            JsonObject json = new JsonObject();
            json.addProperty("loginradius", "java sdk");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.UPDATE_OBJECT_BYRECORDID, params, json);
            CreateCustomObject res = client.getResponse(api, CreateCustomObject.class);

            Assert.assertNotNull(res.getId());
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

    // Delete Custom Object by ObjectRecordId (DEL)
    @Test
    public void test_del_byUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            String objectRecordId = helper.setAccountCustomObject(account.getUid().toString());

            Map < String, String > params = new HashMap < String, String > ();
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            params.put("uid", account.getUid().toString());
            params.put("objectrecordid", objectRecordId);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_CUSTOMOBJECT_BYID, params, null);
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

    // Custom Object Delete by Record Id And Token (DEL)
    @Test
    public void test_del_byToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());
            String objectRecordId = helper.setAccountCustomObject(account.getUid().toString());

            Map<String, String> params = new HashMap<String,String>();
            params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
            params.put("objectrecordid", objectRecordId);
            LRAuthenticationAPI api = new AuthenticationDeleteAPI(LoginRadiusConstant.DELETE_CUSTOMOBJECT, params, null);
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
