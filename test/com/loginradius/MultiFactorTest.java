package com.loginradius;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Assume;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.models.userprofile.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.models.two_factor.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////
// MFA ENABLED -> OPTIONAL FLOW //
//////////////////////////////////

public class MultiFactorTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~MultiFactorTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to false", TestConstant.IS_MFA_ENABLED.equals(false));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);

        // Require MFA Enabled and Flow set to optional
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);
            TwoFactorLogin login = helper.mfaLogin(account.getEmail().get(0).getValue());
            Assume.assumeFalse("Test ignored::Set MFA flow to optional.", login.getAccessToken().equals("00000000-0000-0000-0000-000000000000"));
        } catch(LoginRadiusException e) {
            String desc = "Two factor authentication is not enabled, please enable two factor authentication for login.";
            Assume.assumeFalse("Test ignored::MFA must be enabled.", e.getErrorResponse().getDescription().equals(desc));
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // MFA Email Login (POST)
    @Test
    public void test_post_emailLogin() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject json = new JsonObject();
            json.addProperty("email", account.getEmail().get(0).getValue());
            json.addProperty("password", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.MFA_LOGIN, null, json);
            TwoFactorLogin res = client.getResponse(api, TwoFactorLogin.class);

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

    // MFA Username Login (POST)
    @Test
    public void test_post_usernameLogin() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            JsonObject json = new JsonObject();
            json.addProperty("username", account.getUserName().toString());
            json.addProperty("password", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.MFA_LOGIN, null, json);
            TwoFactorLogin res = client.getResponse(api, TwoFactorLogin.class);

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

    // MFA Phone Login (POST)
    @Test
    public void test_post_phoneLogin() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);

            JsonObject json = new JsonObject();
            json.addProperty("phone", account.getPhoneId().toString());
            json.addProperty("password", account.getEmail().get(0).getValue());
            LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.MFA_LOGIN, null, json);
            TwoFactorLogin res = client.getResponse(api, TwoFactorLogin.class);

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

    // MFA Validate Access Token (GET)
    @Test
    public void test_get_validateToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);
            TwoFactorLogin login = helper.mfaLogin(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.MFA_BYTOKEN,null);
            TwoFactorTokenResponse res = client.getResponse(api,TwoFactorTokenResponse.class);

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

    // MFA Backup Code by Access Token (GET)
    @Test
    public void test_get_backUpCodeByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);
            TwoFactorLogin login = helper.mfaLogin(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.MFA_GETBACKUPCODE, null);
            client.getResponse(api, BackUpCodesResponse.class);
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

    // MFA Reset Backup Code by access token (GET)
    @Test
    public void test_get_resetBackUpCodeByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);
            TwoFactorLogin login = helper.mfaLogin(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.MFA_RESETBACKUPCODE, null);
            client.getResponse(api, BackUpCodesResponse.class);
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

    // MFA Backup Code by UID (GET)
    @Test
    public void test_get_backUpCodeByUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.MFA_GETBACKUPCODE_BYUID, params);
            client.getResponse(api, BackUpCodesResponse.class);
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

    // MFA Reset Backup Code by UID (GET)
    @Test
    public void test_get_resetBackUpCodeByUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, true);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.MFA_RESETBACKUPCODE_BYUID, params);
            client.getResponse(api, BackUpCodesResponse.class);
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

    // MFA Validate Backup code (PUT)
    @Test
    public void test_put_validateBackUpCode() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("secondfactorauthenticationtoken", "99999");
            JsonObject payload = new JsonObject();
            payload.addProperty("backupcode", "99999");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.MFA_VALIDATE_BYBACKUPCODE,params,payload);
            client.getResponse(api, LoginData.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // MFA Validate OTP (PUT)
    @Test
    public void test_put_validateOtp() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("secondfactorauthenticationtoken", "99999");
            JsonObject payload = new JsonObject();
            payload.addProperty("otp", "99999");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.MFA_VALIDATE_OTP, params, payload);
            client.getResponse(api, LoginData.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // MFA Validate Google Auth Code (PUT)
    @Test
    public void test_put_validateGoogleAuthCode() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("secondfactorauthenticationtoken", "999999");
            JsonObject payload = new JsonObject();
            payload.addProperty("googleauthenticatorcode", "999999");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.MFA_VERIFY_BYGOOGLEAUTHENTICATOR,params,payload);
            client.getResponse(api, LoginData.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // MFA Update Phone Number (PUT)
    @Test
    public void test_put_updatePhone() {
        try {
            Map<String, String> params = new HashMap<String,String>();
            params.put("secondfactorauthenticationtoken", "99999");
            JsonObject data = new JsonObject();
            data.addProperty("phoneno2fa", "99999");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.MFA_UPDATE_PHONENUMBER, params, data);
            client.getResponse(api, UpdatePhoneResponse.class);
        } catch (LoginRadiusException e) {
            Assert.assertNotNull(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // MFA Update Phone Number by Token (PUT)
    @Test
    public void test_put_updatePhoneByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            TwoFactorLogin login = helper.mfaLogin(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject data = new JsonObject();
            data.addProperty("phoneno2fa", "12016768877");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.MFA_UPDATE_PHONENUMBER_BYTOKEN, null, data);
            UpdatePhoneResponse res = client.getResponse(api, UpdatePhoneResponse.class);

            Assert.assertNotNull(res.getSid());
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

    // Update MFA by Access Token (PUT)
    @Test
    public void test_put_updateMfaByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            TwoFactorLogin login = helper.mfaLogin(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject data = new JsonObject();
            data.addProperty("googleauthenticatorcode", "99999");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.MFA_UPDATE_BYTOKEN, null, data);
            client.getResponse(api, LoginRadiusUltimateUserProfile.class);
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

    // Update MFA Setting (PUT)
    @Test
    public void test_put_updateMfaSetting() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            TwoFactorLogin login = helper.mfaLogin(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject data = new JsonObject();
            data.addProperty("otp", "99999");
            LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.MFA_UPDATE_SETTING, null, data);
            client.getResponse(api, LoginRadiusUltimateUserProfile.class);
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

    // MFA Reset Google Authenticator by Token (DEL)
    @Test
    public void test_del_googleAuthByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            TwoFactorLogin login = helper.mfaLogin(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject data = new JsonObject();
            data.addProperty("googleauthenticator", true);
            LRAuthenticationAPI api = new AuthenticationDeleteAPI(LoginRadiusConstant.MFA_RESET_AUTHENTICATOR_BYTOKEN, null, data);
            client.getResponse(api, DeleteResponse.class);
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

    // MFA Reset Sms Authenticator by Token (DEL)
    @Test
    public void test_del_smsAuthByToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            TwoFactorLogin login = helper.mfaLogin(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            JsonObject data = new JsonObject();
            data.addProperty("otpauthenticator", true);
            LRAuthenticationAPI api = new AuthenticationDeleteAPI(LoginRadiusConstant.MFA_RESET_AUTHENTICATOR_BYTOKEN, null, data);
            client.getResponse(api, DeleteResponse.class);
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

    // MFA Reset Google Authenticator By UID (DEL)
    @Test
    public void test_del_googleAuthByUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            JsonObject data = new JsonObject();
            data.addProperty("googleauthenticator", true);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.MFA_RESET_AUTHENTICATOR_BYUID, params, data);
            client.getResponse(api, DeleteResponse.class);
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

    // MFA Reset Sms Authenticator By UID (DEL)
    @Test
    public void test_del_smsAuthByUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            JsonObject data = new JsonObject();
            data.addProperty("otpauthenticator", true);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.MFA_RESET_AUTHENTICATOR_BYUID, params, data);
            client.getResponse(api, DeleteResponse.class);
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
