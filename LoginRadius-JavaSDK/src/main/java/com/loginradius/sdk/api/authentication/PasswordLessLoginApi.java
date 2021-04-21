/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.authentication;

import com.loginradius.sdk.helper.*;
import com.loginradius.sdk.util.*;
import com.google.gson.Gson;
import java.util.Iterator;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import com.loginradius.sdk.models.responsemodels.*;
import com.loginradius.sdk.models.responsemodels.userprofile.*;
import com.loginradius.sdk.models.requestmodels.*;
import com.loginradius.sdk.models.responsemodels.otherobjects.*;


public class PasswordLessLoginApi {
   private static Gson gson =new Gson();

   public PasswordLessLoginApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API verifies an account by OTP and allows the customer to login.
   // </summary>
   // <param name="passwordLessLoginOtpModel">Model Class containing Definition of payload for PasswordLessLoginOtpModel API</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.6	    
		
		
   public void passwordlessLoginPhoneVerification(PasswordLessLoginOtpModel passwordLessLoginOtpModel, String fields,
      String smsTemplate, final AsyncHandler<AccessToken<Identity>> handler) {

      if (passwordLessLoginOtpModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("passwordLessLoginOtpModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      String resourcePath = "identity/v2/auth/login/passwordlesslogin/otp/verify";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(passwordLessLoginOtpModel), new AsyncHandler<String>() {
			
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
   // API can be used to send a One-time Passcode (OTP) provided that the account has a verified PhoneID
   // </summary>
   // <param name="phone">The Registered Phone Number</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response Containing Definition of SMS Data</returns>
   // 9.15	    
		
		
   public void passwordlessLoginByPhone(String phone, String smsTemplate, final AsyncHandler<GetResponse<SMSResponseData>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("phone", phone);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      String resourcePath = "identity/v2/auth/login/passwordlesslogin/otp";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<GetResponse<SMSResponseData>> typeToken = new TypeToken<GetResponse<SMSResponseData>>() {};
          GetResponse<SMSResponseData> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to send a Passwordless Login verification link to the provided Email ID
   // </summary>
   // <param name="email">Email of the user</param>
   // <param name="passwordLessLoginTemplate">Passwordless Login Template Name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 9.18.1	    
		
		
   public void passwordlessLoginByEmail(String email, String passwordLessLoginTemplate,
      String verificationUrl, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("email", email);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(passwordLessLoginTemplate)) {
        queryParameters.put("passwordLessLoginTemplate", passwordLessLoginTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      String resourcePath = "identity/v2/auth/login/passwordlesslogin/email";
            
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
   // This API is used to send a Passwordless Login Verification Link to a customer by providing their UserName
   // </summary>
   // <param name="username">UserName of the user</param>
   // <param name="passwordLessLoginTemplate">Passwordless Login Template Name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 9.18.2	    
		
		
   public void passwordlessLoginByUserName(String username, String passwordLessLoginTemplate,
      String verificationUrl, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(username)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("username"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("username", username);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(passwordLessLoginTemplate)) {
        queryParameters.put("passwordLessLoginTemplate", passwordLessLoginTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      String resourcePath = "identity/v2/auth/login/passwordlesslogin/email";
            
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
   // This API is used to verify the Passwordless Login verification link. Note: If you are using Passwordless Login by Phone you will need to use the Passwordless Login Phone Verification API
   // </summary>
   // <param name="verificationToken">Verification token received in the email</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.19	    
		
		
   public void passwordlessLoginVerification(String verificationToken, String fields,
      String welcomeEmailTemplate, final AsyncHandler<AccessToken<Identity>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(verificationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("verificationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("verificationToken", verificationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/login/passwordlesslogin/email/verify";
            
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
   
   // <summary>
   // 
   // </summary>
   // <param name="passwordLessLoginByEmailAndOtpModel"></param>
   // <param name="fields"></param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.23	    
		
		
   public void passwordlessLoginVerificationByEmailAndOTP(PasswordLessLoginByEmailAndOtpModel passwordLessLoginByEmailAndOtpModel, String fields, final AsyncHandler<AccessToken<Identity>> handler) {

      if (passwordLessLoginByEmailAndOtpModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("passwordLessLoginByEmailAndOtpModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/auth/login/passwordlesslogin/email/verifyotp";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(passwordLessLoginByEmailAndOtpModel), new AsyncHandler<String>() {
			
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
   // 
   // </summary>
   // <param name="passwordLessLoginByUserNameAndOtpModel"></param>
   // <param name="fields"></param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.24	    
		
		
   public void passwordlessLoginVerificationByUserNameAndOTP(PasswordLessLoginByUserNameAndOtpModel passwordLessLoginByUserNameAndOtpModel, String fields, final AsyncHandler<AccessToken<Identity>> handler) {

      if (passwordLessLoginByUserNameAndOtpModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("passwordLessLoginByUserNameAndOtpModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/auth/login/passwordlesslogin/username/verifyotp";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(passwordLessLoginByUserNameAndOtpModel), new AsyncHandler<String>() {
			
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
