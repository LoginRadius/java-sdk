package com.loginradius;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.BeforeClass;

import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.advanced.api.*;
import com.loginradius.sdk.models.*;
import com.loginradius.sdk.models.album.*;
import com.loginradius.sdk.models.audio.*;
import com.loginradius.sdk.models.company.*;
import com.loginradius.sdk.models.checkin.*;
import com.loginradius.sdk.models.event.*;
import com.loginradius.sdk.models.following.*;
import com.loginradius.sdk.models.group.*;
import com.loginradius.sdk.models.like.*;
import com.loginradius.sdk.models.mention.*;
import com.loginradius.sdk.models.page.*;
import com.loginradius.sdk.models.photo.*;
import com.loginradius.sdk.models.post.*;
import com.loginradius.sdk.models.video.*;
import com.loginradius.sdk.models.userprofile.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.models.login.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import java.util.HashMap;
import java.util.Map;

public class SocialTest {

    private static LoginRadiusClient client;
    private static Helper helper;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~SocialTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Access Token (GET)
    @Test
    public void test_get_exchangeToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());

            Map<String,String> params = new HashMap<String,String>();
            params.put("token", login.getAccessToken());
            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.SOCIAL_EXCHANGE_ACCESSTOKEN, params);
            AccessToken res = client.getResponse(api,AccessToken.class);

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

    // Token Validate (GET)
    @Test
    public void test_get_validateToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.TOKEN_VALIDATE, null);
            AccessToken res = client.getResponse(api,AccessToken.class);

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

    // Token Invalidate (GET)
    @Test
    public void test_get_invalidateToken() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAdvancedAPI api = new AdvancedGetAPI(LoginRadiusConstant.TOKEN_INVALIDATE, null);
            RegisterResponse res = client.getResponse(api,RegisterResponse.class);

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

    // User Profile (GET)
    @Test
    public void test_get_profile() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.USERPROFILE, null);
            LoginRadiusUltimateUserProfile res = client.getResponse(api,LoginRadiusUltimateUserProfile.class);

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

    // Album (GET)
    @Test
    public void test_get_album() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.ALBUM, null);
            LoginRadiusAlbum[] res = client.getResponse(api,LoginRadiusAlbum[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Audio (GET)
    @Test
    public void test_get_audio() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.AUDIO, null);
            LoginRadiusAudio[] res = client.getResponse(api,LoginRadiusAudio[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Check In (GET)
    @Test
    public void test_get_checkin() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.CHECKIN, null);
            LoginRadiusCheckIn[] res = client.getResponse(api,LoginRadiusCheckIn[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Company (GET)
    @Test
    public void test_get_company() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.COMPANY, null);
            LoginRadiusCompany[] res = client.getResponse(api,LoginRadiusCompany[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Contact (GET)
    @Test
    public void test_get_contact() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            Map<String,String> params = new HashMap<String,String>();
            params.put("nextcursor", "99999");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.CONTACT, params);
            LoginRadiusContactCursorResponse res = client.getResponse(api,LoginRadiusContactCursorResponse.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Event (GET)
    @Test
    public void test_get_event() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.EVENT, null);
            LoginRadiusEvent[] res = client.getResponse(api,LoginRadiusEvent[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Following (GET)
    @Test
    public void test_get_following() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.FOLLOWING, null);
            LoginRadiusFollowing[] res = client.getResponse(api,LoginRadiusFollowing[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Group (GET)
    @Test
    public void test_get_group() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.GROUP, null);
            LoginRadiusGroup[] res = client.getResponse(api,LoginRadiusGroup[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Like (GET)
    @Test
    public void test_get_like() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.LIKE, null);
            LoginRadiusLike[] res = client.getResponse(api,LoginRadiusLike[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Mention (GET)
    @Test
    public void test_get_mention() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.MENTION, null);
            LoginRadiusMention[] res = client.getResponse(api,LoginRadiusMention[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Message (GET)
    @Test
    public void test_get_message() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            Map<String,String> params = new HashMap<String,String>();
            params.put("to", "aaa");
            params.put("subject", "aaa");
            params.put("message", "aaa");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.GET_MESSAGE, params);
            client.getResponse(api,PostAPIResponse.class);
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

    // Page (GET)
    @Test
    public void test_get_page() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            Map<String,String> params = new HashMap<String,String>();
            params.put("pagename", "99999");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.PAGE, params);
            LoginRadiusPage res = client.getResponse(api,LoginRadiusPage.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Photo (GET)
    @Test
    public void test_get_photo() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            Map<String,String> params = new HashMap<String,String>();
            params.put("albumid","99999");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.PHOTO, params);
            LoginRadiusPhoto[] res = client.getResponse(api,LoginRadiusPhoto[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Post (GET)
    @Test
    public void test_get_post() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.POST, null);
            LoginRadiusPost[] res = client.getResponse(api,LoginRadiusPost[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Status Posting (GET)
    @Test
    public void test_get_status() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            Map<String,String> params = new HashMap<String,String>();
            params.put("title","aaa");
            params.put("url","aaa");
            params.put("imageurl","aaa");
            params.put("status","aaa");
            params.put("caption","aaa");
            params.put("description","aaa");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.GET_STATUS_POSTING,params);
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

    // Video (GET)
    @Test
    public void test_get_video() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);
            LoginData login = helper.login(account.getEmail().get(0).getValue());
            client.setToken(login.getAccessToken());

            Map<String,String> params = new HashMap<String,String>();
            params.put("nextcursor","99999");
            LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.VIDEO,params);
            LoginRadiusVideo[] res = client.getResponse(api,LoginRadiusVideo[].class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            String ok = "Your LoginRadius site does not have permission to access this endpoint, please contact LoginRadius support for more information.";
            if (!e.getErrorResponse().getDescription().equals(ok)) {
                Assert.fail(e.getErrorResponse().getDescription());
            }
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }
}
