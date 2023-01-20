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
import com.loginradius.sdk.models.requestmodels.AuthUserRegistrationModel;
import com.loginradius.sdk.models.requestmodels.PhoneAuthenticationModel;
import com.loginradius.sdk.models.requestmodels.ResetPasswordByOTPModel;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.SMSResponseData;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.ExistResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.UserProfilePostResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class PhoneAuthenticationApi {
   private static Gson gson =new Gson();

   public PhoneAuthenticationApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API retrieves a copy of the user data based on the Phone
   // </summary>
   // <param name="phoneAuthenticationModel">Model Class containing Definition of payload for PhoneAuthenticationModel API</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="loginUrl">Url where the user is logging from</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.2.3	    
		
		
   public void loginByPhone(PhoneAuthenticationModel phoneAuthenticationModel, String fields,
      String loginUrl, String smsTemplate, final AsyncHandler<AccessToken<Identity>> handler) {

      if (phoneAuthenticationModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phoneAuthenticationModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(loginUrl)) {
        queryParameters.put("loginUrl", loginUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      String resourcePath = "identity/v2/auth/login";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(phoneAuthenticationModel), new AsyncHandler<String>() {
			
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
   // This API is used to send the OTP to reset the account password.
   // </summary>
   // <param name="phone">New Phone Number</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response Containing Validation Data and SMS Data</returns>
   // 10.4	    
		
		
   public void forgotPasswordByPhoneOTP(String phone, String smsTemplate, final AsyncHandler<UserProfilePostResponse<SMSResponseData>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phone", phone);

      String resourcePath = "identity/v2/auth/password/otp";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<SMSResponseData>> typeToken = new TypeToken<UserProfilePostResponse<SMSResponseData>>() {};
          UserProfilePostResponse<SMSResponseData> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to reset the password
   // </summary>
   // <param name="resetPasswordByOTPModel">Model Class containing Definition of payload for ResetPasswordByOTP API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 10.5	    
		
		
   public void resetPasswordByPhoneOTP(ResetPasswordByOTPModel resetPasswordByOTPModel, final AsyncHandler<PostResponse> handler) {

      if (resetPasswordByOTPModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPasswordByOTPModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/password/otp";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPasswordByOTPModel), new AsyncHandler<String>() {
			
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
   // This API is used to validate the verification code sent to verify a user's phone number
   // </summary>
   // <param name="otp">The Verification Code</param>
   // <param name="phone">New Phone Number</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 11.1.1	    
		
		
   public void phoneVerificationByOTP(String otp, String phone,
      String fields, String smsTemplate, final AsyncHandler<AccessToken<Identity>> handler) {      

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

      String resourcePath = "identity/v2/auth/phone/otp";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
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
   // This API is used to consume the verification code sent to verify a user's phone number. Use this call for front-end purposes in cases where the user is already logged in by passing the user's access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="otp">The Verification Code</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 11.1.2	    
		
		
   public void phoneVerificationOTPByAccessToken(String accessToken, String otp,
      String smsTemplate, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(otp)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("otp"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("otp", otp);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      String resourcePath = "identity/v2/auth/phone/otp";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   // This API is used to resend a verification OTP to verify a user's Phone Number. The user will receive a verification code that they will need to input
   // </summary>
   // <param name="phone">New Phone Number</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response Containing Validation Data and SMS Data</returns>
   // 11.2.1	    
		
		
   public void phoneResendVerificationOTP(String phone, String smsTemplate, final AsyncHandler<UserProfilePostResponse<SMSResponseData>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phone", phone);

      String resourcePath = "identity/v2/auth/phone/otp";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<SMSResponseData>> typeToken = new TypeToken<UserProfilePostResponse<SMSResponseData>>() {};
          UserProfilePostResponse<SMSResponseData> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to resend a verification OTP to verify a user's Phone Number in cases in which an active token already exists
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="phone">New Phone Number</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response Containing Validation Data and SMS Data</returns>
   // 11.2.2	    
		
		
   public void phoneResendVerificationOTPByToken(String accessToken, String phone,
      String smsTemplate, final AsyncHandler<UserProfilePostResponse<SMSResponseData>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phone", phone);

      String resourcePath = "identity/v2/auth/phone/otp";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<SMSResponseData>> typeToken = new TypeToken<UserProfilePostResponse<SMSResponseData>>() {};
          UserProfilePostResponse<SMSResponseData> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to update the login Phone Number of users
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="phone">New Phone Number</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response Containing Validation Data and SMS Data</returns>
   // 11.5	    
		
		
   public void updatePhoneNumber(String accessToken, String phone,
      String smsTemplate, final AsyncHandler<UserProfilePostResponse<SMSResponseData>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phone", phone);

      String resourcePath = "identity/v2/auth/phone";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<SMSResponseData>> typeToken = new TypeToken<UserProfilePostResponse<SMSResponseData>>() {};
          UserProfilePostResponse<SMSResponseData> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to check the Phone Number exists or not on your site.
   // </summary>
   // <param name="phone">The Registered Phone Number</param>
   // <returns>Response containing Definition Complete ExistResponse data</returns>
   // 11.6	    
		
		
   public void checkPhoneNumberAvailability(String phone, final AsyncHandler<ExistResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("phone", phone);

      String resourcePath = "identity/v2/auth/phone";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ExistResponse> typeToken = new TypeToken<ExistResponse>() {};
          ExistResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to delete the Phone ID on a user's account via the access token
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 11.7	    
		
		
   public void removePhoneIDByAccessToken(String accessToken, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/phone";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<DeleteResponse> typeToken = new TypeToken<DeleteResponse>() {};
          DeleteResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API registers the new users into your Cloud Storage and triggers the phone verification process.
   // </summary>
   // <param name="authUserRegistrationModel">Model Class containing Definition of payload for Auth User Registration API</param>
   // <param name="sott">LoginRadius Secured One Time Token</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="options">PreventVerificationEmail (Specifying this value prevents the verification email from being sent. Only applicable if you have the optional email verification flow)</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <param name="welcomeEmailTemplate">Name of the welcome email template</param>
   // <param name="emailTemplate">Name of the email template</param>
   // <returns>Response containing Definition of Complete Validation, UserProfile data and Access Token</returns>
   // 17.1.2	    
		
		
   public void userRegistrationByPhone(AuthUserRegistrationModel authUserRegistrationModel, String sott,
      String fields, String options, String smsTemplate, String verificationUrl, String welcomeEmailTemplate, String emailTemplate, final AsyncHandler<UserProfilePostResponse<AccessToken<Identity>>> handler) {

      if (authUserRegistrationModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("authUserRegistrationModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(sott)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("sott"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("sott", sott);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(options)) {
        queryParameters.put("options", options);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(welcomeEmailTemplate)) {
        queryParameters.put("welcomeEmailTemplate", welcomeEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      String resourcePath = "identity/v2/auth/register";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(authUserRegistrationModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<AccessToken<Identity>>> typeToken = new TypeToken<UserProfilePostResponse<AccessToken<Identity>>>() {};
          UserProfilePostResponse<AccessToken<Identity>> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
