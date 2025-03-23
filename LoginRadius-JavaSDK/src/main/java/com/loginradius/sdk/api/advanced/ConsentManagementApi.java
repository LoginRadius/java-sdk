/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.advanced;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.requestmodels.ConsentSubmitModel;
import com.loginradius.sdk.models.requestmodels.ConsentUpdateModel;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.ConsentLogsResponseModel;
import com.loginradius.sdk.models.responsemodels.ConsentProfile;
import com.loginradius.sdk.models.responsemodels.ConsentProfileValidResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class ConsentManagementApi {
   private static Gson gson =new Gson();

   public ConsentManagementApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API is used to get the Consent logs of the user.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing consent logs</returns>
   // 18.37	    
		
		
   public void getConsentLogsByUid(String uid, final AsyncHandler<ConsentLogsResponseModel> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/consent/logs";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ConsentLogsResponseModel> typeToken = new TypeToken<ConsentLogsResponseModel>() {};
          ConsentLogsResponseModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is to submit consent form using consent token.
   // </summary>
   // <param name="consentToken">The consent token received after login error 1226 </param>
   // <param name="consentSubmitModel">Model class containing list of multiple consent</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 43.1	    
		
		
   public void submitConsentByConsentToken(String consentToken, ConsentSubmitModel consentSubmitModel, final AsyncHandler<AccessToken<Identity>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(consentToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("consentToken"));
      }

      if (consentSubmitModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("consentSubmitModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("consentToken", consentToken);

      String resourcePath = "identity/v2/auth/consent";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(consentSubmitModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessToken<Identity>> typeToken = new TypeToken<AccessToken<Identity>>() {};
          AccessToken<Identity> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to fetch consent logs.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response containing consent logs</returns>
   // 43.2	    
		
		
   public void getConsentLogs(String accessToken, final AsyncHandler<ConsentLogsResponseModel> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/consent/logs";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ConsentLogsResponseModel> typeToken = new TypeToken<ConsentLogsResponseModel>() {};
          ConsentLogsResponseModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // API to provide a way to end user to submit a consent form for particular event type.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="consentSubmitModel">Model class containing list of multiple consent</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 43.3	    
		
		
   public void submitConsentByAccessToken(String accessToken, ConsentSubmitModel consentSubmitModel, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (consentSubmitModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("consentSubmitModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/consent/profile";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(consentSubmitModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Identity> typeToken = new TypeToken<Identity>() {};
          Identity successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to check if consent is submitted for a particular event or not.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="event">Allowed events: Login, Register, UpdateProfile, ResetPassword, ChangePassword, emailVerification, AddEmail, RemoveEmail, BlockAccount, DeleteAccount, SetUsername, AssignRoles, UnassignRoles, SetPassword, LinkAccount, UnlinkAccount, UpdatePhoneId, VerifyPhoneNumber, CreateCustomObject, UpdateCustomobject, DeleteCustomObject</param>
   // <param name="isCustom">true/false</param>
   // <returns>Response containing consent profile</returns>
   // 43.4	    
		
		
   public void verifyConsentByAccessToken(String accessToken, String event,
      Boolean isCustom, final AsyncHandler<ConsentProfileValidResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(event)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("event"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("event", event);
      queryParameters.put("isCustom", String.valueOf(isCustom));

      String resourcePath = "identity/v2/auth/consent/verify";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ConsentProfileValidResponse> typeToken = new TypeToken<ConsentProfileValidResponse>() {};
          ConsentProfileValidResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is to update consents using access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="consentUpdateModel">Model class containg list of multiple consent</param>
   // <returns>Response containing consent profile</returns>
   // 43.5	    
		
		
   public void updateConsentProfileByAccessToken(String accessToken, ConsentUpdateModel consentUpdateModel, final AsyncHandler<ConsentProfile> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (consentUpdateModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("consentUpdateModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/consent";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(consentUpdateModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ConsentProfile> typeToken = new TypeToken<ConsentProfile>() {};
          ConsentProfile successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
