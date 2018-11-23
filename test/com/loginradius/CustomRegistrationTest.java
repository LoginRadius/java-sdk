package com.loginradius;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assume;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.models.customregistrationdata.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

public class CustomRegistrationTest {

    private static LoginRadiusClient client;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~CustomRegistrationTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
    }

    // Add Registration Data (POST)
    @Test
    public void test_post_registrationData() {
        Assume.assumeFalse("Test ignored::REGISTRATIONDATA_TYPE required", TestConstant.REGISTRATIONDATA_TYPE.equals(""));
        try {
            JsonObject json = new JsonObject();
            JsonArray registerarray = new JsonArray();
            JsonObject arrayobj = new JsonObject();
            arrayobj.addProperty("isactive", true);
            arrayobj.addProperty("type", TestConstant.REGISTRATIONDATA_TYPE);
            arrayobj.addProperty("key", "tempKey");
            arrayobj.addProperty("value", "tempValue");
            registerarray.add(arrayobj);
            json.add("Data",registerarray);
            LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.ADD_REGISTRATION_DATA, null, json);
            RegisterResponse res = client.getResponse(api,RegisterResponse.class);

            Assert.assertTrue(res.getIsPosted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

//    // Validate secret code (POST)
//    @Test
//    public void test_post_validateCode() {
//        Assume.assumeFalse("Test ignored::REGISTRATIONDATA_RECORDID required", TestConstant.REGISTRATIONDATA_RECORDID.equals(""));
//        try {
//            JsonObject json = new JsonObject();
//            json.addProperty("recordid", TestConstant.REGISTRATIONDATA_RECORDID);
//            json.addProperty("code", "99999");
//            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.VALIDATE_SECRETCODE, null, json);
//            client.getResponse(api,ValidateResponse.class);
//        } catch (LoginRadiusException e) {
//            Assert.assertNotNull(e.getErrorResponse().getDescription());
//        } catch (Exception e) {
//            Assert.fail(e.getMessage());
//        }
//    }

    // Get Registration Data (GET)
    @Test
    public void test_get_registrationData() {
        Assume.assumeFalse("Test ignored::REGISTRATIONDATA_TYPE required", TestConstant.REGISTRATIONDATA_TYPE.equals(""));
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("type", TestConstant.REGISTRATIONDATA_TYPE);
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.GET_REGISTRATION_DATA, params);
            GetRegistrationDataResponse[] res = client.getResponse(api, GetRegistrationDataResponse[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Auth Get Registration Data (GET)
    @Test
    public void test_get_authRegistrationData() {
        Assume.assumeFalse("Test ignored::REGISTRATIONDATA_TYPE required", TestConstant.REGISTRATIONDATA_TYPE.equals(""));
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("type", TestConstant.REGISTRATIONDATA_TYPE);
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.GET_REGISTRATION_DATA, params);
            GetRegistrationDataResponse[] res = client.getResponse(api, GetRegistrationDataResponse[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Update Registration Data (PUT)
    @Test
    public void test_put_registrationData() {
        Assume.assumeFalse("Test ignored::REGISTRATIONDATA_TYPE and REGISTRATIONDATA_RECORDID required", TestConstant.REGISTRATIONDATA_TYPE.equals("") || TestConstant.REGISTRATIONDATA_RECORDID.equals(""));
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("recordid", TestConstant.REGISTRATIONDATA_RECORDID);
            JsonObject json = new JsonObject();
            json.addProperty("isactive", true);
            json.addProperty("type", TestConstant.REGISTRATIONDATA_TYPE);
            json.addProperty("key", "tempKey");
            json.addProperty("value", "tempValue");
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.UPDATE_REGISTRATION_DATA, params, json);
            UpdateRegistrationDataResponse res = client.getResponse(api,UpdateRegistrationDataResponse.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Delete Registration Data (DEL)
    @Test
    public void test_del_registrationData() {
        Assume.assumeFalse("Test ignored::REGISTRATIONDATA_RECORDID required", TestConstant.REGISTRATIONDATA_RECORDID.equals(""));
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("recordid", TestConstant.REGISTRATIONDATA_RECORDID);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_REGISTRATION_DATA, params, null);
            DeleteResponse res = client.getResponse(api, DeleteResponse.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Delete All Records by Datasource (DEL)
    @Test
    public void test_del_byDatasource() {
        Assume.assumeFalse("Test ignored::REGISTRATIONDATA_TYPE required", TestConstant.REGISTRATIONDATA_TYPE.equals(""));
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("type", TestConstant.REGISTRATIONDATA_TYPE);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_RECORD_BY_DATASOURCE, params, null);
            DeleteResponse res = client.getResponse(api, DeleteResponse.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
