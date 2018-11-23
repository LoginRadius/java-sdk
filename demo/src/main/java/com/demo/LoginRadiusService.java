package com.demo;

import com.google.gson.JsonParser;
import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.models.GetPasswordResponse;
import com.loginradius.sdk.models.login.LoginData;
import com.loginradius.sdk.models.two_factor.TwoFactorLogin;
import com.loginradius.sdk.models.userprofile.LoginRadiusUltimateUserProfile;
import com.loginradius.sdk.models.register.RegisterResponse;
import com.loginradius.sdk.models.register.DeleteResponse;
import com.loginradius.sdk.models.email.EmailVerificationResponse;
import com.loginradius.sdk.models.customobject.CreateCustomObject;
import com.loginradius.sdk.models.customobject.ReadCustomObject;
import com.loginradius.sdk.models.role.AssignRoles;
import com.loginradius.sdk.models.role.LoginRadiusRoleResponse;
import com.loginradius.sdk.resource.LoginRadiusClient;
import com.loginradius.sdk.resource.Sott;
import com.loginradius.sdk.util.LoginRadiusConstant;
import com.loginradius.sdk.util.LoginRadiusSDK;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

/**
 * Created by LoginRadius Development Team on 09/23/2018
 */
@Service
public class LoginRadiusService {

    @Value("${app.apikey}")
    private String apikey;
    @Value("${app.apisecret}")
    private String apisecret;
    @Value("${server.port}")
    private String server_port;

    private LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
    private LoginRadiusClient client = new LoginRadiusClient();
    private Gson gson = new Gson();

    private String emailverification = "";
    private String resetpassword = "";

    @PostConstruct
    public void init() {
        init.setApiKey(apikey);
        init.setApiSecret(apisecret);
        emailverification = "http://localhost:" + server_port + "/emailverification";
        resetpassword = "http://localhost:" + server_port + "/resetpassword";
    }

    public String login(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("email", request.getParameter("email"));
        params.put("password", request.getParameter("password"));
        LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.EMAIL_LOGIN, params);
        LoginData res = client.getResponse(api, LoginData.class);
        return gson.toJson(res);
    }

    public String mfaLogin(HttpServletRequest request) {
        JsonObject json = new JsonObject();
        json.addProperty("email", request.getParameter("email"));
        json.addProperty("password", request.getParameter("password"));
        LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.MFA_LOGIN,null,json);
        TwoFactorLogin res = client.getResponse(api, TwoFactorLogin.class);
        return gson.toJson(res);
    }

    public String mfaVerify(HttpServletRequest request) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("secondfactorauthenticationtoken", request.getParameter("token"));
        JsonObject json = new JsonObject();
        json.addProperty("googleauthenticatorcode", request.getParameter("code"));
        LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.MFA_VERIFY_BYGOOGLEAUTHENTICATOR,params,json);
        TwoFactorLogin res = client.getResponse(api, TwoFactorLogin.class);
        return gson.toJson(res);
    }

    public String register(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("verificationurl", emailverification);
        params.put("sott", getSott());

        JsonObject json = new JsonObject();
        JsonArray arr = new JsonArray();
        JsonObject arr_sets = new JsonObject();
        arr_sets.addProperty("Type", "Primary");
        arr_sets.addProperty("Value", request.getParameter("email"));
        arr.add(arr_sets);
        json.add("Email", arr);
        json.addProperty("Password", request.getParameter("password"));
        LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.REGISTER, params, json);
        RegisterResponse res = client.getResponse(api, RegisterResponse.class);
        return gson.toJson(res);
    }

    public String emailVerify(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("verificationtoken", request.getParameter("token"));
        LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.VERIFY_EMAIL, params);
        EmailVerificationResponse res = client.getResponse(api, EmailVerificationResponse.class);
        return gson.toJson(res);
    }

    public String passwordlessLogin(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("email", request.getParameter("email"));
        params.put("verificationurl", emailverification);
        LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.PASSWORDLESS_LOGIN, params);
        RegisterResponse res = client.getResponse(api, RegisterResponse.class);
        return gson.toJson(res);
    }

    public String passwordlessVerify(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("verificationtoken", request.getParameter("token"));
        LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.PASSWORDLESS_LOGIN_VERIFICATION,params);
        LoginData res = client.getResponse(api, LoginData.class);
        return gson.toJson(res);
    }

    public String forgotPassword(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("resetpasswordurl", resetpassword);
        JsonObject json = new JsonObject();
        json.addProperty("email", request.getParameter("email"));
        LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.FORGOT_PASSWORD_BYEMAIL, params, json);
        RegisterResponse res = client.getResponse(api, RegisterResponse.class);
        return gson.toJson(res);
    }

    public String resetPassword(HttpServletRequest request) {
        JsonObject json = new JsonObject();
        json.addProperty("resettoken", request.getParameter("token"));
        json.addProperty("password", request.getParameter("password"));
        LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.RESET_PASSWORD, null, json);
        RegisterResponse res = client.getResponse(api, RegisterResponse.class);
        return gson.toJson(res);
    }

    public String getUserProfile(HttpServletRequest request) {
        client.setToken(request.getParameter("token"));
        LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.READACCOUNT_BYTOKEN,null);
        LoginRadiusUltimateUserProfile res = client.getResponse(api, LoginRadiusUltimateUserProfile.class);
        return gson.toJson(res);
    }

    public String changePassword(HttpServletRequest request) {
        JsonObject json = new JsonObject();
        json.addProperty("oldpassword", request.getParameter("oldpassword"));
        json.addProperty("newpassword", request.getParameter("newpassword"));
        LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.CHANGE_PASSWORD, null, json);
        RegisterResponse res = client.getResponse(api, RegisterResponse.class);
        return gson.toJson(res);
    }

    public String setPassword(HttpServletRequest request) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("uid", request.getParameter("uid"));
        JsonObject json = new JsonObject();
        json.addProperty("password", request.getParameter("password"));
        LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.SET_PASSWORD, params, json);
        GetPasswordResponse res = client.getResponse(api, GetPasswordResponse.class);
        return gson.toJson(res);
    }

    public String accountUpdate(HttpServletRequest request) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("uid", request.getParameter("uid"));
        JsonObject json = new JsonObject();
        json.addProperty("FirstName", request.getParameter("firstname"));
        json.addProperty("LastName", request.getParameter("lastname"));
        json.addProperty("About", request.getParameter("about"));
        LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.UPDATE_ACCOUNT, params, json);
        LoginRadiusUltimateUserProfile res = client.getResponse(api, LoginRadiusUltimateUserProfile.class);
        return gson.toJson(res);
    }

    public String createCustomObject(HttpServletRequest request) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("uid", request.getParameter("uid"));
        params.put("objectname", request.getParameter("objectname"));
        JsonObject json = getRequestBody(request);
        LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.CREATE_CUSTOM_OBJECT, params, json);
        CreateCustomObject res = client.getResponse(api, CreateCustomObject.class);
        return gson.toJson(res);
    }

    public String updateCustomObject(HttpServletRequest request) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("objectname", request.getParameter("objectname"));
        params.put("updatetype", "replace");
        params.put("uid", request.getParameter("uid"));
        params.put("objectrecordid", request.getParameter("objectrecordid"));
        JsonObject json = getRequestBody(request);
        LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.UPDATE_OBJECT_BYRECORDID, params, json);
        CreateCustomObject res = client.getResponse(api, CreateCustomObject.class);
        return gson.toJson(res);
    }

    public String deleteCustomObject(HttpServletRequest request) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("objectname", request.getParameter("objectname"));
        params.put("uid", request.getParameter("uid"));
        params.put("objectrecordid", request.getParameter("objectrecordid"));
        LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_CUSTOMOBJECT_BYID, params, null);
        DeleteResponse res = client.getResponse(api, DeleteResponse.class);
        return gson.toJson(res);
    }

    public String getCustomObject(HttpServletRequest request) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("objectname", request.getParameter("objectname"));
        params.put("uid", request.getParameter("uid"));
        LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.CUSTOMOBJECT_BYUID, params);
        ReadCustomObject res = client.getResponse(api, ReadCustomObject.class);
        return gson.toJson(res);
    }

    public String mfaReset(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("uid", request.getParameter("uid"));
        JsonObject json = new JsonObject();
        json.addProperty("googleauthenticator", true);
        LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.MFA_RESET_AUTHENTICATOR_BYUID, params, json);
        DeleteResponse res = client.getResponse(api, DeleteResponse.class);
        return gson.toJson(res);
    }

    public String getAllRoles(HttpServletRequest request) {
        LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.GET_ROLE, null);
        LoginRadiusRoleResponse res = client.getResponse(api, LoginRadiusRoleResponse.class);
        return gson.toJson(res);
    }

    public String getUserRoles(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("uid", request.getParameter("uid"));
        LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.GET_ROLES_BYUID, params);
        AssignRoles res = client.getResponse(api, AssignRoles.class);
        return gson.toJson(res);
    }

    public String createRole(HttpServletRequest request) {
        JsonObject jsonObj = new JsonObject();
        JsonObject registerdata = new JsonObject();
        JsonArray registerarray = new JsonArray();
        JsonObject arraysets = new JsonObject();
        arraysets.addProperty("Name", request.getParameter("role"));
        arraysets.add("Permissions", jsonObj);
        registerarray.add(arraysets);
        registerdata.add("Roles", registerarray);
        LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.CREATEROLE, null, registerdata);
        LoginRadiusRoleResponse res = client.getResponse(api, LoginRadiusRoleResponse.class);
        return gson.toJson(res);
    }

    public String deleteRole(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("role", request.getParameter("role"));
        LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_ROLE, params, null);
        DeleteResponse res = client.getResponse(api, DeleteResponse.class);
        return gson.toJson(res);
    }

    public String assignRole(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("uid", request.getParameter("uid"));
        JsonObject json = new JsonObject();
        JsonArray array = new JsonArray();
        array.add(request.getParameter("role"));
        json.add("roles", array);
        LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.ASSIGNROLES, params, json);
        AssignRoles res = client.getResponse(api, AssignRoles.class);
        return gson.toJson(res);
    }

    public String logout(HttpServletRequest request) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("access_token", request.getParameter("token"));
        LRAuthenticationAPI api = new AuthenticationGetAPI(LoginRadiusConstant.INVALIDATE_ACCESSTOKEN, params);
        RegisterResponse res = client.getResponse(api, RegisterResponse.class);
        return gson.toJson(res);
    }

    private String getSott() {
        try {
            return Sott.main(apisecret, apikey, null);
        } catch(Exception e) {
            return "";
        }
    }

    private JsonObject getRequestBody(HttpServletRequest request) {
        String line;
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            String data = buffer.toString();
            return new JsonParser().parse(data).getAsJsonObject();
        } catch(Exception e) {
            return null;
        }
    }
}