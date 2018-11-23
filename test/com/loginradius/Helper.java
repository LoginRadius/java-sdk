package com.loginradius;

import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.authentication.api.*;
import com.loginradius.sdk.models.role.LoginRadiusRoleResponse;
import com.loginradius.sdk.models.login.LoginData;
import com.loginradius.sdk.models.two_factor.TwoFactorLogin;
import com.loginradius.sdk.models.customobject.CreateCustomObject;
import com.loginradius.sdk.models.password.ForgotPasswordTokenResponse;
import com.loginradius.sdk.models.email.EmailVerificationTokenResponse;
import com.loginradius.sdk.models.register.RegistrationData;
import com.loginradius.sdk.util.LoginRadiusConstant;
import com.loginradius.sdk.resource.LoginRadiusClient;
import com.loginradius.sdk.resource.Sott;

import com.google.gson.JsonPrimitive;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.util.HashMap;
import java.util.Map;

public class Helper {

    private LoginRadiusClient client;

    public Helper(LoginRadiusClient client) {
        this.client = client;
    }

    public RegistrationData createAccount(Boolean isEmailVerified, Boolean isPhoneVerified) {
        String email = "lr-javasdk" + System.currentTimeMillis() + "@mailinator.com";
        String secondaryEmail = "secondary-" + email;

        JsonArray emailArray = new JsonArray();
        JsonObject primaryEmailObj = new JsonObject();
        JsonObject secondaryEmailObj = new JsonObject();
        primaryEmailObj.addProperty("Type", "Primary");
        primaryEmailObj.addProperty("Value", email);
        secondaryEmailObj.addProperty("Type", "Secondary");
        secondaryEmailObj.addProperty("Value", secondaryEmail);
        emailArray.add(primaryEmailObj);
        emailArray.add(secondaryEmailObj);

        JsonObject payload = new JsonObject();
        payload.add("Email", emailArray);
        payload.addProperty("Password", email);
        payload.addProperty("EmailVerified", isEmailVerified);
        payload.addProperty("PhoneIDVerified", isPhoneVerified);
        payload.addProperty("UserName", "lr-javasdk" + System.currentTimeMillis());
        payload.addProperty("PhoneId", "12016768877");

        LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.CREATEACCOUNT, null, payload);
        RegistrationData res = client.getResponse(api, RegistrationData.class);

        return res;
    }

    public LoginData login(String email) {
        JsonObject json = new JsonObject();
        json.addProperty("email", email);
        json.addProperty("password", email);
        LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.EMAIL_LOGIN, null, json);
        LoginData res = client.getResponse(api, LoginData.class);

        return res;
    }

    public TwoFactorLogin mfaLogin(String email) {
        JsonObject json = new JsonObject();
        json.addProperty("email", email);
        json.addProperty("password", email);
        LRAuthenticationAPI api = new AuthenticationPostAPI(LoginRadiusConstant.MFA_LOGIN, null, json);
        TwoFactorLogin res = client.getResponse(api, TwoFactorLogin.class);

        return res;
    }

    public String getVerificationToken(String email) {
        JsonObject json = new JsonObject();
        json.addProperty("email", email);
        LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.GET_EMAIL_VERIFICATION_TOKEN, null, json);
        EmailVerificationTokenResponse res = client.getResponse(api, EmailVerificationTokenResponse.class);
        return res.getVerificationToken();
    }

    public String getForgotPasswordToken(String email) {
        JsonObject json = new JsonObject();
        json.addProperty("email", email);
        LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.GET_FORGOT_PASSWORD_TOKEN, null, json);
        ForgotPasswordTokenResponse res = client.getResponse(api, ForgotPasswordTokenResponse.class);
        return res.getForgotToken();
    }

    public void deleteAccount(String uid) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("uid", uid);
        LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_ACCOUNT, params, null);
        api.getResponse("");
    }

    public void setAccountSecurityQuestion(String token, String questionId, String answer) {
        JsonObject json = new JsonObject();
        JsonObject securityquestionanswer = new JsonObject();
        securityquestionanswer.addProperty(questionId, answer);
        json.add("securityquestionanswer", securityquestionanswer);
        LRAuthenticationAPI api = new AuthenticationPutAPI(LoginRadiusConstant.UPDATE_SECURITY_QUESTION_BY_TOKEN, null, json);
        api.getResponse(token);
    }

    public String setAccountCustomObject(String uid) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("uid", uid);
        params.put("objectname", TestConstant.CUSTOM_OBJECT_NAME);
        JsonObject json = new JsonObject();
        json.addProperty("anything", "i want");
        LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.CREATE_CUSTOM_OBJECT, params, json);
        CreateCustomObject res = client.getResponse(api, CreateCustomObject.class);
        return res.getId();
    }

    public LoginRadiusRoleResponse createRole(String roleName, String permissionName) {
        JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty(permissionName, "true");
        JsonObject registerdata = new JsonObject();
        JsonArray registerarray = new JsonArray();
        JsonObject arraysets = new JsonObject();
        arraysets.addProperty("Name", roleName);
        arraysets.add("Permissions", jsonObj);
        registerarray.add(arraysets);
        registerdata.add("Roles", registerarray);
        LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.CREATEROLE, null, registerdata);
        LoginRadiusRoleResponse res = client.getResponse(api, LoginRadiusRoleResponse.class);

        return res;
    }

    public void deleteRole(String roleName) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("role", roleName);
        LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_ROLE, params, null);
        api.getResponse("");
    }

    public void setRoleContext(String uid, String roleName, String contextName, String permissionName) {
        Map<String, String> params = new HashMap<String,String>();
        params.put("uid", uid);

        JsonObject json = new JsonObject();
        JsonArray registerarray = new JsonArray();
        JsonObject arraysets = new JsonObject();
        arraysets.addProperty("context", contextName);

        JsonArray array = new JsonArray();
        array.add(new JsonPrimitive(roleName));
        arraysets.add("roles", array);

        JsonArray arraypermission = new JsonArray();
        arraypermission.add(new JsonPrimitive(permissionName));
        arraysets.add("additionalpermissions", arraypermission);

        registerarray.add(arraysets);
        json.add("rolecontext",registerarray);

        LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.ADD_ROLECONTEXT, params, json);
        api.getResponse("");
    }

    public String generateSott() {
        try {
            return Sott.main(TestConstant.API_SECRET, TestConstant.API_KEY, null);
        } catch (Exception e) {
            return "";
        }
    }
}
