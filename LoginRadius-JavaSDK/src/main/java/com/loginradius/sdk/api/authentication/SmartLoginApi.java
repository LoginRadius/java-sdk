/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.authentication;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.VerifiedResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class SmartLoginApi {
   private static Gson gson =new Gson();

   public SmartLoginApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API verifies the provided token for Smart Login
   // </summary>
   // <param name="verificationToken">Verification token received in the email</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Complete verified response data</returns>
   // 8.4.1	    
		
		
   public void smartLoginTokenVerification(String verificationToken, String welcomeEmailTemplate, final AsyncHandler<VerifiedResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(verificationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("verificationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("verificationToken", verificationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/email/smartlogin";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<VerifiedResponse> typeToken = new TypeToken<VerifiedResponse>() {};
          VerifiedResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API sends a Smart Login link to the user's Email Id.
   // </summary>
   // <param name="clientGuid">Unique string used in the Smart Login request</param>
   // <param name="email">Email of the user</param>
   // <param name="redirectUrl">Url where the user will redirect after success authentication</param>
   // <param name="smartLoginEmailTemplate">Email template for Smart Login link</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 9.17.1	    
		
		
   public void smartLoginByEmail(String clientGuid, String email,
      String redirectUrl, String smartLoginEmailTemplate, String welcomeEmailTemplate, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(clientGuid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("clientGuid"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("clientGuid", clientGuid);
      queryParameters.put("email", email);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(redirectUrl)) {
        queryParameters.put("redirectUrl", redirectUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smartLoginEmailTemplate)) {
        queryParameters.put("smartLoginEmailTemplate", smartLoginEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/login/smartlogin";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API sends a Smart Login link to the user's Email Id.
   // </summary>
   // <param name="clientGuid">Unique string used in the Smart Login request</param>
   // <param name="username">UserName of the user</param>
   // <param name="redirectUrl">Url where the user will redirect after success authentication</param>
   // <param name="smartLoginEmailTemplate">Email template for Smart Login link</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 9.17.2	    
		
		
   public void smartLoginByUserName(String clientGuid, String username,
      String redirectUrl, String smartLoginEmailTemplate, String welcomeEmailTemplate, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(clientGuid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("clientGuid"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(username)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("username"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("clientGuid", clientGuid);
      queryParameters.put("username", username);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(redirectUrl)) {
        queryParameters.put("redirectUrl", redirectUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smartLoginEmailTemplate)) {
        queryParameters.put("smartLoginEmailTemplate", smartLoginEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/login/smartlogin";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostResponse> typeToken = new TypeToken<PostResponse>() {};
          PostResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to check if the Smart Login link has been clicked or not
   // </summary>
   // <param name="clientGuid">Unique string used in the Smart Login request</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.21.1	    
		
		
   public void smartLoginPing(String clientGuid, String fields, final AsyncHandler<AccessToken<Identity>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(clientGuid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("clientGuid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("clientGuid", clientGuid);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/auth/login/smartlogin/ping";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
}
