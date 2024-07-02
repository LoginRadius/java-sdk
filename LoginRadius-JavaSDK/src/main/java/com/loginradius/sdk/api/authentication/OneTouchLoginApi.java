/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.authentication;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.requestmodels.OneTouchLoginByEmailModel;
import com.loginradius.sdk.models.requestmodels.OneTouchLoginByPhoneModel;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.VerifiedResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.models.responsemodels.userprofile.UserProfile;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class OneTouchLoginApi {
   private static Gson gson =new Gson();

   public OneTouchLoginApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API is used to send a link to a specified email for a frictionless login/registration
   // </summary>
   // <param name="oneTouchLoginByEmailModel">Model Class containing Definition of payload for OneTouchLogin By EmailModel API</param>
   // <param name="oneTouchLoginEmailTemplate">Name of the One Touch Login Email Template</param>
   // <param name="redirecturl">Url where the user will redirect after success authentication</param>
   // <param name="welcomeemailtemplate">Name of the welcome email template</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 1.2	    
		
		
   public void oneTouchLoginByEmail(OneTouchLoginByEmailModel oneTouchLoginByEmailModel, String oneTouchLoginEmailTemplate,
      String redirecturl, String welcomeemailtemplate, final AsyncHandler<PostResponse> handler) {

      if (oneTouchLoginByEmailModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("oneTouchLoginByEmailModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(oneTouchLoginEmailTemplate)) {
        queryParameters.put("oneTouchLoginEmailTemplate", oneTouchLoginEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(redirecturl)) {
        queryParameters.put("redirecturl", redirecturl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeemailtemplate)) {
        queryParameters.put("welcomeemailtemplate", welcomeemailtemplate);
      }

      String resourcePath = "identity/v2/auth/onetouchlogin/email";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(oneTouchLoginByEmailModel), new AsyncHandler<String>() {
			
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
   // This API is used to send one time password to a given phone number for a frictionless login/registration.
   // </summary>
   // <param name="oneTouchLoginByPhoneModel">Model Class containing Definition of payload for OneTouchLogin By PhoneModel API</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 1.4	    
		
		
   public void oneTouchLoginByPhone(OneTouchLoginByPhoneModel oneTouchLoginByPhoneModel, String smsTemplate,
      Boolean isVoiceOtp, final AsyncHandler<PostResponse> handler) {

      if (oneTouchLoginByPhoneModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("oneTouchLoginByPhoneModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }

      String resourcePath = "identity/v2/auth/onetouchlogin/phone";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(oneTouchLoginByPhoneModel), new AsyncHandler<String>() {
			
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
   // This API is used to verify the otp for One Touch Login.
   // </summary>
   // <param name="otp">The Verification Code</param>
   // <param name="phone">New Phone Number</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response Containing Access Token and Complete Profile Data</returns>
   // 1.5	    
		
		
   public void oneTouchLoginOTPVerification(String otp, String phone,
      String fields, String smsTemplate, final AsyncHandler<AccessToken<UserProfile>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(otp)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("otp"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("otp", otp);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phone", phone);

      String resourcePath = "identity/v2/auth/onetouchlogin/phone/verify";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessToken<UserProfile>> typeToken = new TypeToken<AccessToken<UserProfile>>() {};
          AccessToken<UserProfile> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API verifies the provided token for One Touch Login
   // </summary>
   // <param name="verificationToken">Verification token received in the email</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Complete verified response data</returns>
   // 8.4.2	    
		
		
   public void oneTouchEmailVerification(String verificationToken, String welcomeEmailTemplate, final AsyncHandler<VerifiedResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(verificationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("verificationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("verificationToken", verificationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/email/onetouchlogin";
            
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
   // This API is used to check if the One Touch Login link has been clicked or not.
   // </summary>
   // <param name="clientGuid">Unique string used in the Smart Login request</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.21.2	    
		
		
   public void oneTouchLoginPing(String clientGuid, String fields, final AsyncHandler<AccessToken<Identity>> handler) {      

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
