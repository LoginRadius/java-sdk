package com.loginradius;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.BeforeClass;

import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.models.*;
import com.loginradius.sdk.models.userprofile.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.models.password.*;
import com.loginradius.sdk.models.email.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

public class AccountTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~AccountTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Account Create (POST)
    @Test
    public void test_post_create() {
        RegistrationData account = null;
        try {
            String email = "lr-javasdk" + System.currentTimeMillis() + "@mailinator.com";

            JsonObject json = new JsonObject();
            JsonArray registerarray = new JsonArray();
            JsonObject arraysets = new JsonObject();
            arraysets.addProperty("Type", "Primary");
            arraysets.addProperty("Value", email);
            registerarray.add(arraysets);
            json.add("Email", registerarray);
            json.addProperty("Password", email);
            LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.CREATEACCOUNT, null, json);
            account = client.getResponse(api, RegistrationData.class);

            Assert.assertNotNull(account);
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

    // Email Verification Token (POST)
    @Test
    public void test_post_emailVerificationToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(false, false);

            JsonObject json = new JsonObject();
            json.addProperty("email", account.getEmail().get(0).getValue());
            LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.GET_EMAIL_VERIFICATION_TOKEN, null, json);
            EmailVerificationTokenResponse res = client.getResponse(api, EmailVerificationTokenResponse.class);

            Assert.assertNotNull(res.getVerificationToken());
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

    // Forgot Password Token (POST)
    @Test
    public void test_post_forgotPasswordToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(false, false);

            JsonObject json = new JsonObject();
            json.addProperty("email", account.getEmail().get(0).getValue());
            LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.GET_FORGOT_PASSWORD_TOKEN, null, json);
            ForgotPasswordTokenResponse res = client.getResponse(api, ForgotPasswordTokenResponse.class);

            Assert.assertNotNull(res.getForgotToken());
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

    // Account Identities by Email (GET)
    @Test
    public void test_get_identitiesByEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("email", account.getEmail().get(0).getValue());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.ACCOUNT_IDENTITIES_BY_EMAIL, params);
            AccountIdentitiesResponse res = client.getResponse(api, AccountIdentitiesResponse.class);

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

    // Access Token based on UID or User impersonation API (GET)
    @Test
    public void test_get_accessTokenByUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.ACCESSTOKEN_BYUID, params);
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

    // Account Password (GET)
    @Test
    public void test_get_password() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.GET_PASSWORD, params);
            GetPasswordResponse res = client.getResponse(api, GetPasswordResponse.class);

            Assert.assertNotNull(res.getPasswordHash());
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

    // Account Profiles by Email (GET)
    @Test
    public void test_get_profilesByEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("email", account.getEmail().get(0).getValue());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.ACCOUNT_PROFILES_BYEMAIL, params);
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

    // Account Profiles by Username (GET)
    @Test
    public void test_get_profilesByUsername() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("username", account.getUserName().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.ACCOUNT_PROFILES_BYUSERNAME, params);
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

    // Account Profiles by Phone (GET)
    @Test
    public void test_get_profilesByPhone() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("phone", account.getPhoneId().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.ACCOUNT_PROFILES_BYPHONE, params);
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

    // Account Profiles by UID (GET)
    @Test
    public void test_get_profilesByUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.ACCOUNT_PROFILES_BYUID, params);
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

    // Account Set Password (PUT)
    @Test
    public void test_put_setPassword() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            JsonObject json = new JsonObject();
            json.addProperty("password", "123456");
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.SET_PASSWORD, params, json);
            GetPasswordResponse res = client.getResponse(api, GetPasswordResponse.class);

            Assert.assertNotNull(res.getPasswordHash());
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

    // Account Update (PUT)
    @Test
    public void test_put_update() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            JsonObject json = new JsonObject();
            json.addProperty("FirstName", "Login");
            json.addProperty("LastName", "Radius");
            json.addProperty("Password", "123456");
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.UPDATE_ACCOUNT, params, json);
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

    // Account Update Security Question Configuration (PUT)
    @Test
    public void test_put_updateSecurityQuestion() {
        Assume.assumeFalse("Test ignored::SECURITY_QUESTION_ID required", TestConstant.SECURITY_QUESTION_ID.equals(""));
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            JsonObject json = new JsonObject();
            JsonObject securityquestionanswer = new JsonObject();
            securityquestionanswer.addProperty(TestConstant.SECURITY_QUESTION_ID, "answer");
            json.add("securityquestionanswer", securityquestionanswer);
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.ACCOUNT_UPDATE_SECURITY_QUESTION_CONFIG, params, json);
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

    // Account Invalidate Verification Email (PUT)
    @Test
    public void test_put_invalidateVerificationEmail() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.ACCOUNT_INVALIDATE_VERIFICATION_EMAIL, params, null);
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

    // Account Email Delete (DEL)
    @Test
    public void test_del_email() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            JsonObject json = new JsonObject();
            json.addProperty("email", account.getEmail().get(1).getValue());
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.REMOVE_EMAIL, params, json);
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

    // Account Delete (DEL)
    @Test
    public void test_del_account() {
        try {
            RegistrationData account = helper.createAccount(true, false);

            Map<String,String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_ACCOUNT, params, null);
            DeleteResponse res = client.getResponse(api, DeleteResponse.class);

            Assert.assertNotNull(res.getIsDeleted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
