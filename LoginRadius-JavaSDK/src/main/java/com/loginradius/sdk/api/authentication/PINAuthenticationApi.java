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
import com.loginradius.sdk.models.requestmodels.ChangePINModel;
import com.loginradius.sdk.models.requestmodels.ForgotPINLinkByEmailModel;
import com.loginradius.sdk.models.requestmodels.ForgotPINLinkByUserNameModel;
import com.loginradius.sdk.models.requestmodels.ForgotPINOtpByPhoneModel;
import com.loginradius.sdk.models.requestmodels.LoginByPINModel;
import com.loginradius.sdk.models.requestmodels.PINRequiredModel;
import com.loginradius.sdk.models.requestmodels.ResetPINByEmailAndOtpModel;
import com.loginradius.sdk.models.requestmodels.ResetPINByPhoneAndOTPModel;
import com.loginradius.sdk.models.requestmodels.ResetPINByResetToken;
import com.loginradius.sdk.models.requestmodels.ResetPINBySecurityQuestionAnswerAndEmailModel;
import com.loginradius.sdk.models.requestmodels.ResetPINBySecurityQuestionAnswerAndPhoneModel;
import com.loginradius.sdk.models.requestmodels.ResetPINBySecurityQuestionAnswerAndUsernameModel;
import com.loginradius.sdk.models.requestmodels.ResetPINByUsernameAndOtpModel;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.SmsResponseData;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.UserProfilePostResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class PINAuthenticationApi {
   private static Gson gson =new Gson();

   public PINAuthenticationApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API is used to login a user by pin and session token.
   // </summary>
   // <param name="loginByPINModel">Model Class containing Definition of payload for LoginByPin API</param>
   // <param name="sessionToken">Session Token of user</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.22	    
		
		
   public void pinLogin(LoginByPINModel loginByPINModel, String sessionToken, final AsyncHandler<AccessToken<Identity>> handler) {

      if (loginByPINModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("loginByPINModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(sessionToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("sessionToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("session_token", sessionToken);

      String resourcePath = "identity/v2/auth/login/pin";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(loginByPINModel), new AsyncHandler<String>() {
			
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
   // This API sends the reset pin email to specified email address.
   // </summary>
   // <param name="forgotPINLinkByEmailModel">Model Class containing Definition for Forgot Pin Link By Email API</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="resetPINUrl">Reset PIN Url</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.1	    
		
		
   public void sendForgotPINEmailByEmail(ForgotPINLinkByEmailModel forgotPINLinkByEmailModel, String emailTemplate,
      String resetPINUrl, final AsyncHandler<PostResponse> handler) {

      if (forgotPINLinkByEmailModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("forgotPINLinkByEmailModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(resetPINUrl)) {
        queryParameters.put("resetPINUrl", resetPINUrl);
      }

      String resourcePath = "identity/v2/auth/pin/forgot/email";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(forgotPINLinkByEmailModel), new AsyncHandler<String>() {
			
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
   // This API sends the reset pin email using username.
   // </summary>
   // <param name="forgotPINLinkByUserNameModel">Model Class containing Definition for Forgot Pin Link By UserName API</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="resetPINUrl">Reset PIN Url</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.2	    
		
		
   public void sendForgotPINEmailByUsername(ForgotPINLinkByUserNameModel forgotPINLinkByUserNameModel, String emailTemplate,
      String resetPINUrl, final AsyncHandler<PostResponse> handler) {

      if (forgotPINLinkByUserNameModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("forgotPINLinkByUserNameModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(resetPINUrl)) {
        queryParameters.put("resetPINUrl", resetPINUrl);
      }

      String resourcePath = "identity/v2/auth/pin/forgot/username";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(forgotPINLinkByUserNameModel), new AsyncHandler<String>() {
			
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
   // This API is used to reset pin using reset token.
   // </summary>
   // <param name="resetPINByResetToken">Model Class containing Definition of payload for Reset Pin By Reset Token API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.3	    
		
		
   public void resetPINByResetToken(ResetPINByResetToken resetPINByResetToken, final AsyncHandler<PostResponse> handler) {

      if (resetPINByResetToken == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPINByResetToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/pin/reset/token";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPINByResetToken), new AsyncHandler<String>() {
			
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
   // This API is used to reset pin using security question answer and email.
   // </summary>
   // <param name="resetPINBySecurityQuestionAnswerAndEmailModel">Model Class containing Definition of payload for Reset Pin By Security Question and Email API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.4	    
		
		
   public void resetPINByEmailAndSecurityAnswer(ResetPINBySecurityQuestionAnswerAndEmailModel resetPINBySecurityQuestionAnswerAndEmailModel, final AsyncHandler<PostResponse> handler) {

      if (resetPINBySecurityQuestionAnswerAndEmailModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPINBySecurityQuestionAnswerAndEmailModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/pin/reset/securityanswer/email";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPINBySecurityQuestionAnswerAndEmailModel), new AsyncHandler<String>() {
			
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
   // This API is used to reset pin using security question answer and username.
   // </summary>
   // <param name="resetPINBySecurityQuestionAnswerAndUsernameModel">Model Class containing Definition of payload for Reset Pin By Security Question and UserName API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.5	    
		
		
   public void resetPINByUsernameAndSecurityAnswer(ResetPINBySecurityQuestionAnswerAndUsernameModel resetPINBySecurityQuestionAnswerAndUsernameModel, final AsyncHandler<PostResponse> handler) {

      if (resetPINBySecurityQuestionAnswerAndUsernameModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPINBySecurityQuestionAnswerAndUsernameModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/pin/reset/securityanswer/username";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPINBySecurityQuestionAnswerAndUsernameModel), new AsyncHandler<String>() {
			
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
   // This API is used to reset pin using security question answer and phone.
   // </summary>
   // <param name="resetPINBySecurityQuestionAnswerAndPhoneModel">Model Class containing Definition of payload for Reset Pin By Security Question and Phone API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.6	    
		
		
   public void resetPINByPhoneAndSecurityAnswer(ResetPINBySecurityQuestionAnswerAndPhoneModel resetPINBySecurityQuestionAnswerAndPhoneModel, final AsyncHandler<PostResponse> handler) {

      if (resetPINBySecurityQuestionAnswerAndPhoneModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPINBySecurityQuestionAnswerAndPhoneModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/pin/reset/securityanswer/phone";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPINBySecurityQuestionAnswerAndPhoneModel), new AsyncHandler<String>() {
			
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
   // This API sends the OTP to specified phone number
   // </summary>
   // <param name="forgotPINOtpByPhoneModel">Model Class containing Definition for Forgot Pin Otp By Phone API</param>
   // <param name="smsTemplate"></param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <returns>Response Containing Validation Data and SMS Data</returns>
   // 42.7	    
		
		
   public void sendForgotPINSMSByPhone(ForgotPINOtpByPhoneModel forgotPINOtpByPhoneModel, String smsTemplate,
      Boolean isVoiceOtp, final AsyncHandler<UserProfilePostResponse<SmsResponseData>> handler) {

      if (forgotPINOtpByPhoneModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("forgotPINOtpByPhoneModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }

      String resourcePath = "identity/v2/auth/pin/forgot/otp";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(forgotPINOtpByPhoneModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<SmsResponseData>> typeToken = new TypeToken<UserProfilePostResponse<SmsResponseData>>() {};
          UserProfilePostResponse<SmsResponseData> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to change a user's PIN using access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="changePINModel">Model Class containing Definition for change PIN Property</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.8	    
		
		
   public void changePINByAccessToken(String accessToken, ChangePINModel changePINModel, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (changePINModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("changePINModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/pin/change";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(changePINModel), new AsyncHandler<String>() {
			
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
   // This API is used to reset pin using phoneId and OTP.
   // </summary>
   // <param name="resetPINByPhoneAndOTPModel">Model Class containing Definition of payload for Reset Pin By Phone and Otp API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.9	    
		
		
   public void resetPINByPhoneAndOtp(ResetPINByPhoneAndOTPModel resetPINByPhoneAndOTPModel, final AsyncHandler<PostResponse> handler) {

      if (resetPINByPhoneAndOTPModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPINByPhoneAndOTPModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/pin/reset/otp/phone";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPINByPhoneAndOTPModel), new AsyncHandler<String>() {
			
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
   // This API is used to reset pin using email and OTP.
   // </summary>
   // <param name="resetPINByEmailAndOtpModel">Model Class containing Definition of payload for Reset Pin By Email and Otp API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.10	    
		
		
   public void resetPINByEmailAndOtp(ResetPINByEmailAndOtpModel resetPINByEmailAndOtpModel, final AsyncHandler<PostResponse> handler) {

      if (resetPINByEmailAndOtpModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPINByEmailAndOtpModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/pin/reset/otp/email";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPINByEmailAndOtpModel), new AsyncHandler<String>() {
			
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
   // This API is used to reset pin using username and OTP.
   // </summary>
   // <param name="resetPINByUsernameAndOtpModel">Model Class containing Definition of payload for Reset Pin By Username and Otp API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 42.11	    
		
		
   public void resetPINByUsernameAndOtp(ResetPINByUsernameAndOtpModel resetPINByUsernameAndOtpModel, final AsyncHandler<PostResponse> handler) {

      if (resetPINByUsernameAndOtpModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("resetPINByUsernameAndOtpModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/pin/reset/otp/username";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(resetPINByUsernameAndOtpModel), new AsyncHandler<String>() {
			
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
   // This API is used to change a user's PIN using Pin Auth token.
   // </summary>
   // <param name="pINRequiredModel">Model Class containing Definition for PIN</param>
   // <param name="pinAuthToken">Pin Auth Token</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 42.12	    
		
		
   public void setPINByPinAuthToken(PINRequiredModel pINRequiredModel, String pinAuthToken, final AsyncHandler<AccessToken<Identity>> handler) {

      if (pINRequiredModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("pINRequiredModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(pinAuthToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("pinAuthToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("pinAuthToken", pinAuthToken);

      String resourcePath = "identity/v2/auth/pin/set/pinauthtoken";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(pINRequiredModel), new AsyncHandler<String>() {
			
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
   // This API is used to invalidate pin session token.
   // </summary>
   // <param name="sessionToken">Session Token of user</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 44.1	    
		
		
   public void inValidatePinSessionToken(String sessionToken, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(sessionToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("sessionToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("session_token", sessionToken);

      String resourcePath = "identity/v2/auth/session_token/invalidate";
            
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
}
