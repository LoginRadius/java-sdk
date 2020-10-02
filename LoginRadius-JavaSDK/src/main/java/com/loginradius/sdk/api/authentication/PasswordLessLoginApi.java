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
import com.loginradius.sdk.models.requestmodels.PasswordLessLoginOtpModel;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.SMSResponseData;
import com.loginradius.sdk.models.responsemodels.otherobjects.GetResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class PasswordLessLoginApi {
   private static Gson gson =new Gson();

   public PasswordLessLoginApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   /**
    * This API verifies an account by OTP and allows the customer to login.
    * @param passwordLessLoginOtpModel Model Class containing Definition of payload for PasswordLessLoginOtpModel API
    * @param fields The fields parameter filters the API response so that the response only includes a specific set of fields
    * @param smsTemplate SMS Template name
    * @return Response containing User Profile Data and access token
    * @since 9.6
    */
		
		
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
   
   /**
    * API can be used to send a One-time Passcode (OTP) provided that the account has a verified PhoneID
    * @param phone The Registered Phone Number
    * @param smsTemplate SMS Template name
    * @return Response Containing Definition of SMS Data
    * @since 9.15
    */
		
		
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
   
   /**
    * This API is used to send a Passwordless Login verification link to the provided Email ID
    * @param email Email of the user
    * @param passwordLessLoginTemplate Passwordless Login Template Name
    * @param verificationUrl Email verification url
    * @return Response containing Definition of Complete Validation data
    * @since 9.18.1
    */
		
		
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
   
   /**
    * This API is used to send a Passwordless Login Verification Link to a customer by providing their UserName
    * @param username UserName of the user
    * @param passwordLessLoginTemplate Passwordless Login Template Name
    * @param verificationUrl Email verification url
    * @return Response containing Definition of Complete Validation data
    * @since 9.18.2
    */
		
		
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
   
   /**
    * This API is used to verify the Passwordless Login verification link. Note: If you are using Passwordless Login by Phone you will need to use the Passwordless Login Phone Verification API
    * @param verificationToken Verification token received in the email
    * @param fields The fields parameter filters the API response so that the response only includes a specific set of fields
    * @param welcomeEmailTemplate Name of the welcome email template
    * @return Response containing User Profile Data and access token
    * @since 9.19
    */
		
		
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
}
