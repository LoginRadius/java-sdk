/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.advanced;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.requestmodels.EmailIdModel;
import com.loginradius.sdk.models.requestmodels.MultiFactorAuthModelByAuthenticatorCode;
import com.loginradius.sdk.models.requestmodels.MultiFactorAuthModelByAuthenticatorCodeSecurityAnswer;
import com.loginradius.sdk.models.requestmodels.MultiFactorAuthModelByBackupCode;
import com.loginradius.sdk.models.requestmodels.MultiFactorAuthModelByEmailOtp;
import com.loginradius.sdk.models.requestmodels.MultiFactorAuthModelByEmailOtpWithLockout;
import com.loginradius.sdk.models.requestmodels.MultiFactorAuthModelWithLockout;
import com.loginradius.sdk.models.requestmodels.SecurityQuestionAnswerModelByAccessToken;
import com.loginradius.sdk.models.requestmodels.SecurityQuestionAnswerUpdateModel;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.MultiFactorAuthenticationResponse;
import com.loginradius.sdk.models.responsemodels.MultiFactorAuthenticationSettingsResponse;
import com.loginradius.sdk.models.responsemodels.SmsResponseData;
import com.loginradius.sdk.models.responsemodels.otherobjects.BackupCodeResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.GetResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.models.responsemodels.userprofile.UserProfile;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class MultiFactorAuthenticationApi {
   private static Gson gson =new Gson();

   public MultiFactorAuthenticationApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API is used to configure the Multi-factor authentication after login by using the access token when MFA is set as optional on the LoginRadius site.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <returns>Response containing Definition of Complete Multi-Factor Authentication Settings data</returns>
   // 5.7	    
		
		
   public void mfaConfigureByAccessToken(String accessToken, Boolean isVoiceOtp, final AsyncHandler<MultiFactorAuthenticationSettingsResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }

      String resourcePath = "identity/v2/auth/account/2fa";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<MultiFactorAuthenticationSettingsResponse> typeToken = new TypeToken<MultiFactorAuthenticationSettingsResponse>() {};
          MultiFactorAuthenticationSettingsResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to trigger the Multi-factor authentication settings after login for secure actions
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="multiFactorAuthModelWithLockout">Model Class containing Definition of payload for MultiFactorAuthModel With Lockout API</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 5.9	    
		
		
   public void mfaUpdateSetting(String accessToken, MultiFactorAuthModelWithLockout multiFactorAuthModelWithLockout,
      String fields, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (multiFactorAuthModelWithLockout == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiFactorAuthModelWithLockout"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/auth/account/2fa/verification/otp";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(multiFactorAuthModelWithLockout), new AsyncHandler<String>() {
			
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
   // This API is used to update the Multi-factor authentication phone number by sending the verification OTP to the provided phone number
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="phoneNo2FA">Phone Number For 2FA</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <param name="options">PreventVerificationEmail (Specifying this value prevents the verification email from being sent. Only applicable if you have the optional email verification flow)</param>
   // <returns>Response containing Definition for Complete SMS data</returns>
   // 5.11	    
		
		
   public void mfaUpdatePhoneNumberByToken(String accessToken, String phoneNo2FA,
      String smsTemplate2FA, Boolean isVoiceOtp, String options, final AsyncHandler<SmsResponseData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phoneNo2FA)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phoneNo2FA"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(options)) {
        queryParameters.put("options", options);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phoneNo2FA", phoneNo2FA);

      String resourcePath = "identity/v2/auth/account/2fa";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SmsResponseData> typeToken = new TypeToken<SmsResponseData>() {};
          SmsResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API Resets the Authenticator configurations on a given account via the access_token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="authenticator">Pass true to remove Authenticator.</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 5.12.1	    
		
		
   public void mfaResetAuthenticatorByToken(String accessToken, Boolean authenticator, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("authenticator", authenticator);

      String resourcePath = "identity/v2/auth/account/2fa/authenticator";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
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
   // This API resets the SMS Authenticator configurations on a given account via the access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="otpauthenticator">Pass 'otpauthenticator' to remove SMS Authenticator</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 5.12.2	    
		
		
   public void mfaResetSMSAuthByToken(String accessToken, Boolean otpauthenticator, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("otpauthenticator", otpauthenticator);

      String resourcePath = "identity/v2/auth/account/2fa/authenticator";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
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
   // This API is used to get a set of backup codes via access token to allow the user login on a site that has Multi-factor Authentication enabled in the event that the user does not have a secondary factor available. We generate 10 codes, each code can only be consumed once. If any user attempts to go over the number of invalid login attempts configured in the Dashboard then the account gets blocked automatically
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response containing Definition of Complete Backup Code data</returns>
   // 5.13	    
		
		
   public void mfaBackupCodeByAccessToken(String accessToken, final AsyncHandler<BackupCodeResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/2fa/backupcode";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<BackupCodeResponse> typeToken = new TypeToken<BackupCodeResponse>() {};
          BackupCodeResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // API is used to reset the backup codes on a given account via the access token. This API call will generate 10 new codes, each code can only be consumed once
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response containing Definition of Complete Backup Code data</returns>
   // 5.14	    
		
		
   public void mfaResetBackupCodeByAccessToken(String accessToken, final AsyncHandler<BackupCodeResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/2fa/backupcode/reset";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<BackupCodeResponse> typeToken = new TypeToken<BackupCodeResponse>() {};
          BackupCodeResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is created to send the OTP to the email if email OTP authenticator is enabled in app's MFA configuration.
   // </summary>
   // <param name="accessToken">access_token</param>
   // <param name="emailId">EmailId</param>
   // <param name="emailTemplate2FA">EmailTemplate2FA</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 5.17	    
		
		
   public void mfaEmailOtpByAccessToken(String accessToken, String emailId,
      String emailTemplate2FA, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(emailId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("emailId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("emailId", emailId);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate2FA)) {
        queryParameters.put("emailTemplate2FA", emailTemplate2FA);
      }

      String resourcePath = "identity/v2/auth/account/2fa/otp/email";
            
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
   // This API is used to set up MFA Email OTP authenticator on profile after login.
   // </summary>
   // <param name="accessToken">access_token</param>
   // <param name="multiFactorAuthModelByEmailOtpWithLockout">payload</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 5.18	    
		
		
   public void mfaValidateEmailOtpByAccessToken(String accessToken, MultiFactorAuthModelByEmailOtpWithLockout multiFactorAuthModelByEmailOtpWithLockout, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (multiFactorAuthModelByEmailOtpWithLockout == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiFactorAuthModelByEmailOtpWithLockout"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/2fa/verification/otp/email";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(multiFactorAuthModelByEmailOtpWithLockout), new AsyncHandler<String>() {
			
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
   // This API is used to reset the Email OTP Authenticator settings for an MFA-enabled user
   // </summary>
   // <param name="accessToken">access_token</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 5.19	    
		
		
   public void mfaResetEmailOtpAuthenticatorByAccessToken(String accessToken, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/2fa/authenticator/otp/email";
            
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
   // This API is used to set up MFA Security Question authenticator on profile after login.
   // </summary>
   // <param name="accessToken">access_token</param>
   // <param name="securityQuestionAnswerModelByAccessToken">payload</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 5.20	    
		
		
   public void mfaSecurityQuestionAnswerByAccessToken(String accessToken, SecurityQuestionAnswerModelByAccessToken securityQuestionAnswerModelByAccessToken, final AsyncHandler<PostResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (securityQuestionAnswerModelByAccessToken == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("securityQuestionAnswerModelByAccessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/2fa/securityquestionanswer";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(securityQuestionAnswerModelByAccessToken), new AsyncHandler<String>() {
			
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
   // This API is used to Reset MFA Security Question Authenticator By Access Token
   // </summary>
   // <param name="accessToken">access_token</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 5.21	    
		
		
   public void mfaResetSecurityQuestionAuthenticatorByAccessToken(String accessToken, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      String resourcePath = "identity/v2/auth/account/2fa/authenticator/securityquestionanswer";
            
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
   // This API can be used to login by emailid on a Multi-factor authentication enabled LoginRadius site.
   // </summary>
   // <param name="email">user's email</param>
   // <param name="password">Password for the email</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="loginUrl">Url where the user is logging from</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <param name="emailTemplate2FA">2FA Email template name</param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <param name="options">PreventVerificationEmail (Specifying this value prevents the verification email from being sent. Only applicable if you have the optional email verification flow)</param>
   // <returns>Complete user UserProfile data</returns>
   // 9.8.1	    
		
		
   public void mfaLoginByEmail(String email, String password,
      String emailTemplate, String fields, String loginUrl, String smsTemplate,
      String smsTemplate2FA, String verificationUrl, String emailTemplate2FA, Boolean isVoiceOtp, String options, final AsyncHandler<MultiFactorAuthenticationResponse<Identity>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(email)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("email"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(password)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("password"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }
      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(loginUrl)) {
        queryParameters.put("loginUrl", loginUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate2FA)) {
        queryParameters.put("emailTemplate2FA", emailTemplate2FA);
      }

      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(options)) {
        queryParameters.put("options", options);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("email", email);
      bodyParameters.addProperty("password", password);

      String resourcePath = "identity/v2/auth/login/2fa";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<MultiFactorAuthenticationResponse<Identity>> typeToken = new TypeToken<MultiFactorAuthenticationResponse<Identity>>() {};
          MultiFactorAuthenticationResponse<Identity> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API can be used to login by username on a Multi-factor authentication enabled LoginRadius site.
   // </summary>
   // <param name="password">Password for the email</param>
   // <param name="username">Username of the user</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="loginUrl">Url where the user is logging from</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <param name="emailTemplate2FA">2FA Email template name</param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <returns>Complete user UserProfile data</returns>
   // 9.8.2	    
		
		
   public void mfaLoginByUserName(String password, String username,
      String emailTemplate,  String fields, String loginUrl, String smsTemplate,
      String smsTemplate2FA, String verificationUrl,String emailTemplate2FA, Boolean isVoiceOtp, final AsyncHandler<MultiFactorAuthenticationResponse<Identity>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(password)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("password"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(username)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("username"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(loginUrl)) {
        queryParameters.put("loginUrl", loginUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate2FA)) {
        queryParameters.put("emailTemplate2FA", emailTemplate2FA);
      }

      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("password", password);
      bodyParameters.addProperty("username", username);

      String resourcePath = "identity/v2/auth/login/2fa";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<MultiFactorAuthenticationResponse<Identity>> typeToken = new TypeToken<MultiFactorAuthenticationResponse<Identity>>() {};
          MultiFactorAuthenticationResponse<Identity> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API can be used to login by Phone on a Multi-factor authentication enabled LoginRadius site.
   // </summary>
   // <param name="password">Password for the email</param>
   // <param name="phone">New Phone Number</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="loginUrl">Url where the user is logging from</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <param name="emailTemplate2FA">2FA Email template name</param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <param name="options">PreventVerificationEmail (Specifying this value prevents the verification email from being sent. Only applicable if you have the optional email verification flow)</param>
   // <returns>Complete user UserProfile data</returns>
   // 9.8.3	    
		
		
   public void mfaLoginByPhone(String password, String phone,
      String emailTemplate, String fields, String loginUrl, String smsTemplate,
      String smsTemplate2FA, String verificationUrl,String emailTemplate2FA, Boolean isVoiceOtp, String options, final AsyncHandler<MultiFactorAuthenticationResponse<Identity>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(password)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("password"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phone)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phone"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
        queryParameters.put("emailTemplate", emailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(loginUrl)) {
        queryParameters.put("loginUrl", loginUrl);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

     
      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate2FA)) {
        queryParameters.put("emailTemplate2FA", emailTemplate2FA);
      }
      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }
      if (!LoginRadiusValidator.isNullOrWhiteSpace(options)) {
        queryParameters.put("options", options);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("password", password);
      bodyParameters.addProperty("phone", phone);

      String resourcePath = "identity/v2/auth/login/2fa";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<MultiFactorAuthenticationResponse<Identity>> typeToken = new TypeToken<MultiFactorAuthenticationResponse<Identity>>() {};
          MultiFactorAuthenticationResponse<Identity> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to login via Multi-factor authentication by passing the One Time Password received via SMS
   // </summary>
   // <param name="multiFactorAuthModelWithLockout">Model Class containing Definition of payload for MultiFactorAuthModel With Lockout API</param>
   // <param name="secondFactorAuthenticationToken">A Uniquely generated MFA identifier token after successful authentication</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <param name="rbaBrowserEmailTemplate"></param>
   // <param name="rbaCityEmailTemplate"></param>
   // <param name="rbaCountryEmailTemplate"></param>
   // <param name="rbaIpEmailTemplate"></param>
   // <returns>Complete user UserProfile data</returns>
   // 9.12	    
		
		
   public void mfaValidateOTPByPhone(MultiFactorAuthModelWithLockout multiFactorAuthModelWithLockout, String secondFactorAuthenticationToken,
      String fields,String smsTemplate2FA, String rbaBrowserEmailTemplate, String rbaCityEmailTemplate, String rbaCountryEmailTemplate, String rbaIpEmailTemplate, final AsyncHandler<AccessToken<Identity>> handler) {

      if (multiFactorAuthModelWithLockout == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiFactorAuthModelWithLockout"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondFactorAuthenticationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondFactorAuthenticationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondFactorAuthenticationToken", secondFactorAuthenticationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserEmailTemplate)) {
        queryParameters.put("rbaBrowserEmailTemplate", rbaBrowserEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCityEmailTemplate)) {
        queryParameters.put("rbaCityEmailTemplate", rbaCityEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountryEmailTemplate)) {
        queryParameters.put("rbaCountryEmailTemplate", rbaCountryEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpEmailTemplate)) {
        queryParameters.put("rbaIpEmailTemplate", rbaIpEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/login/2fa/verification/otp";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(multiFactorAuthModelWithLockout), new AsyncHandler<String>() {
			
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
   // This API is used to validate the backup code provided by the user and if valid, we return an access token allowing the user to login incases where Multi-factor authentication (MFA) is enabled and the secondary factor is unavailable. When a user initially downloads the Backup codes, We generate 10 codes, each code can only be consumed once. if any user attempts to go over the number of invalid login attempts configured in the Dashboard then the account gets blocked automatically
   // </summary>
   // <param name="multiFactorAuthModelByBackupCode">Model Class containing Definition of payload for MultiFactorAuth By BackupCode API</param>
   // <param name="secondFactorAuthenticationToken">A Uniquely generated MFA identifier token after successful authentication</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="rbaBrowserEmailTemplate"></param>
   // <param name="rbaCityEmailTemplate"></param>
   // <param name="rbaCountryEmailTemplate"></param>
   // <param name="rbaIpEmailTemplate"></param>
   // <returns>Complete user UserProfile data</returns>
   // 9.14	    
		
		
   public void mfaValidateBackupCode(MultiFactorAuthModelByBackupCode multiFactorAuthModelByBackupCode, String secondFactorAuthenticationToken,
      String fields, String rbaBrowserEmailTemplate, String rbaCityEmailTemplate, String rbaCountryEmailTemplate, String rbaIpEmailTemplate, final AsyncHandler<AccessToken<Identity>> handler) {

      if (multiFactorAuthModelByBackupCode == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiFactorAuthModelByBackupCode"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondFactorAuthenticationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondFactorAuthenticationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondFactorAuthenticationToken", secondFactorAuthenticationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserEmailTemplate)) {
        queryParameters.put("rbaBrowserEmailTemplate", rbaBrowserEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCityEmailTemplate)) {
        queryParameters.put("rbaCityEmailTemplate", rbaCityEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountryEmailTemplate)) {
        queryParameters.put("rbaCountryEmailTemplate", rbaCountryEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpEmailTemplate)) {
        queryParameters.put("rbaIpEmailTemplate", rbaIpEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/login/2fa/verification/backupcode";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(multiFactorAuthModelByBackupCode), new AsyncHandler<String>() {
			
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
   // This API is used to update (if configured) the phone number used for Multi-factor authentication by sending the verification OTP to the provided phone number
   // </summary>
   // <param name="phoneNo2FA">Phone Number For 2FA</param>
   // <param name="secondFactorAuthenticationToken">A Uniquely generated MFA identifier token after successful authentication</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <param name="options">PreventVerificationEmail (Specifying this value prevents the verification email from being sent. Only applicable if you have the optional email verification flow)</param>
   // <returns>Response containing Definition for Complete SMS data</returns>
   // 9.16	    
		
		
   public void mfaUpdatePhoneNumber(String phoneNo2FA, String secondFactorAuthenticationToken,
      String smsTemplate2FA, Boolean isVoiceOtp,String options, final AsyncHandler<SmsResponseData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(phoneNo2FA)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phoneNo2FA"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondFactorAuthenticationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondFactorAuthenticationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondFactorAuthenticationToken", secondFactorAuthenticationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }
      
      if (!LoginRadiusValidator.isNullOrWhiteSpace(options)) {
        queryParameters.put("options", options);
      }

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phoneNo2FA", phoneNo2FA);

      String resourcePath = "identity/v2/auth/login/2fa";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SmsResponseData> typeToken = new TypeToken<SmsResponseData>() {};
          SmsResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to resending the verification OTP to the provided phone number
   // </summary>
   // <param name="secondFactorAuthenticationToken">A Uniquely generated MFA identifier token after successful authentication</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <param name="isVoiceOtp">Boolean, pass true if you wish to trigger voice OTP</param>
   // <returns>Response containing Definition for Complete SMS data</returns>
   // 9.17	    
		
		
   public void mfaResendOTP(String secondFactorAuthenticationToken, String smsTemplate2FA,
      Boolean isVoiceOtp, final AsyncHandler<SmsResponseData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondFactorAuthenticationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondFactorAuthenticationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondFactorAuthenticationToken", secondFactorAuthenticationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      if (isVoiceOtp != null && isVoiceOtp) {
        queryParameters.put("isVoiceOtp", String.valueOf(isVoiceOtp));
      }

      String resourcePath = "identity/v2/auth/login/2fa/resend";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SmsResponseData> typeToken = new TypeToken<SmsResponseData>() {};
          SmsResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // An API designed to send the MFA Email OTP to the email.
   // </summary>
   // <param name="emailIdModel">payload</param>
   // <param name="secondFactorAuthenticationToken">SecondFactorAuthenticationToken</param>
   // <param name="emailTemplate2FA">EmailTemplate2FA</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 9.18	    
		
		
   public void mfaEmailOTP(EmailIdModel emailIdModel, String secondFactorAuthenticationToken,
      String emailTemplate2FA, final AsyncHandler<PostResponse> handler) {

      if (emailIdModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("emailIdModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondFactorAuthenticationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondFactorAuthenticationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondFactorAuthenticationToken", secondFactorAuthenticationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate2FA)) {
        queryParameters.put("emailTemplate2FA", emailTemplate2FA);
      }

      String resourcePath = "identity/v2/auth/login/2fa/otp/email";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(emailIdModel), new AsyncHandler<String>() {
			
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
   // This API is used to Verify MFA Email OTP by MFA Token
   // </summary>
   // <param name="multiFactorAuthModelByEmailOtp">payload</param>
   // <param name="secondFactorAuthenticationToken">SecondFactorAuthenticationToken</param>
   // <param name="rbaBrowserEmailTemplate">RbaBrowserEmailTemplate</param>
   // <param name="rbaCityEmailTemplate">RbaCityEmailTemplate</param>
   // <param name="rbaCountryEmailTemplate">RbaCountryEmailTemplate</param>
   // <param name="rbaIpEmailTemplate">RbaIpEmailTemplate</param>
   // <returns>Response Containing Access Token and Complete Profile Data</returns>
   // 9.25	    
		
		
   public void mfaValidateEmailOtp(MultiFactorAuthModelByEmailOtp multiFactorAuthModelByEmailOtp, String secondFactorAuthenticationToken,
      String rbaBrowserEmailTemplate, String rbaCityEmailTemplate, String rbaCountryEmailTemplate, String rbaIpEmailTemplate, final AsyncHandler<AccessToken<UserProfile>> handler) {

      if (multiFactorAuthModelByEmailOtp == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiFactorAuthModelByEmailOtp"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondFactorAuthenticationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondFactorAuthenticationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondFactorAuthenticationToken", secondFactorAuthenticationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserEmailTemplate)) {
        queryParameters.put("rbaBrowserEmailTemplate", rbaBrowserEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCityEmailTemplate)) {
        queryParameters.put("rbaCityEmailTemplate", rbaCityEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountryEmailTemplate)) {
        queryParameters.put("rbaCountryEmailTemplate", rbaCountryEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpEmailTemplate)) {
        queryParameters.put("rbaIpEmailTemplate", rbaIpEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/login/2fa/verification/otp/email";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(multiFactorAuthModelByEmailOtp), new AsyncHandler<String>() {
			
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
   // This API is used to set the security questions on the profile with the MFA token when MFA flow is required.
   // </summary>
   // <param name="securityQuestionAnswerUpdateModel">payload</param>
   // <param name="secondFactorAuthenticationToken">SecondFactorAuthenticationToken</param>
   // <returns>Response Containing Access Token and Complete Profile Data</returns>
   // 9.26	    
		
		
   public void mfaSecurityQuestionAnswer(SecurityQuestionAnswerUpdateModel securityQuestionAnswerUpdateModel, String secondFactorAuthenticationToken, final AsyncHandler<AccessToken<UserProfile>> handler) {

      if (securityQuestionAnswerUpdateModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("securityQuestionAnswerUpdateModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondFactorAuthenticationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondFactorAuthenticationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondFactorAuthenticationToken", secondFactorAuthenticationToken);

      String resourcePath = "identity/v2/auth/login/2fa/securityquestionanswer";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(securityQuestionAnswerUpdateModel), new AsyncHandler<String>() {
			
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
   // This API is used to resending the verification OTP to the provided phone number
   // </summary>
   // <param name="securityQuestionAnswerUpdateModel">payload</param>
   // <param name="secondFactorAuthenticationToken">SecondFactorAuthenticationToken</param>
   // <param name="rbaBrowserEmailTemplate">RbaBrowserEmailTemplate</param>
   // <param name="rbaCityEmailTemplate">RbaCityEmailTemplate</param>
   // <param name="rbaCountryEmailTemplate">RbaCountryEmailTemplate</param>
   // <param name="rbaIpEmailTemplate">RbaIpEmailTemplate</param>
   // <returns>Response Containing Access Token and Complete Profile Data</returns>
   // 9.27	    
		
		
   public void mfaSecurityQuestionAnswerVerification(SecurityQuestionAnswerUpdateModel securityQuestionAnswerUpdateModel, String secondFactorAuthenticationToken,
      String rbaBrowserEmailTemplate, String rbaCityEmailTemplate, String rbaCountryEmailTemplate, String rbaIpEmailTemplate, final AsyncHandler<AccessToken<UserProfile>> handler) {

      if (securityQuestionAnswerUpdateModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("securityQuestionAnswerUpdateModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondFactorAuthenticationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondFactorAuthenticationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondFactorAuthenticationToken", secondFactorAuthenticationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserEmailTemplate)) {
        queryParameters.put("rbaBrowserEmailTemplate", rbaBrowserEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCityEmailTemplate)) {
        queryParameters.put("rbaCityEmailTemplate", rbaCityEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountryEmailTemplate)) {
        queryParameters.put("rbaCountryEmailTemplate", rbaCountryEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpEmailTemplate)) {
        queryParameters.put("rbaIpEmailTemplate", rbaIpEmailTemplate);
      }

      String resourcePath = "identity/v2/auth/login/2fa/verification/securityquestionanswer";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(securityQuestionAnswerUpdateModel), new AsyncHandler<String>() {
			
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
   // This API resets the SMS Authenticator configurations on a given account via the UID.
   // </summary>
   // <param name="otpauthenticator">Pass 'otpauthenticator' to remove SMS Authenticator</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.21.1	    
		
		
   public void mfaResetSMSAuthenticatorByUid(Boolean otpauthenticator, String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("uid", uid);

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("otpauthenticator", otpauthenticator);

      String resourcePath = "identity/v2/manage/account/2fa/authenticator";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
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
   // This API resets the Authenticator configurations on a given account via the UID.
   // </summary>
   // <param name="authenticator">Pass true to remove Authenticator.</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.21.2	    
		
		
   public void mfaResetAuthenticatorByUid(Boolean authenticator, String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("uid", uid);

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("authenticator", authenticator);

      String resourcePath = "identity/v2/manage/account/2fa/authenticator";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
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
   // This API is used to reset the backup codes on a given account via the UID. This API call will generate 10 new codes, each code can only be consumed once.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Complete Backup Code data</returns>
   // 18.25	    
		
		
   public void mfaBackupCodeByUid(String uid, final AsyncHandler<BackupCodeResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("uid", uid);

      String resourcePath = "identity/v2/manage/account/2fa/backupcode";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<BackupCodeResponse> typeToken = new TypeToken<BackupCodeResponse>() {};
          BackupCodeResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to reset the backup codes on a given account via the UID. This API call will generate 10 new codes, each code can only be consumed once.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Complete Backup Code data</returns>
   // 18.26	    
		
		
   public void mfaResetBackupCodeByUid(String uid, final AsyncHandler<BackupCodeResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("uid", uid);

      String resourcePath = "identity/v2/manage/account/2fa/backupcode/reset";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<BackupCodeResponse> typeToken = new TypeToken<BackupCodeResponse>() {};
          BackupCodeResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to reset the Email OTP Authenticator settings for an MFA-enabled user.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.42	    
		
		
   public void mfaResetEmailOtpAuthenticatorByUid(String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("uid", uid);

      String resourcePath = "identity/v2/manage/account/2fa/authenticator/otp/email";
            
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
   // This API is used to reset the Security Question Authenticator settings for an MFA-enabled user.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.43	    
		
		
   public void mfaResetSecurityQuestionAuthenticatorByUid(String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("uid", uid);

      String resourcePath = "identity/v2/manage/account/2fa/authenticator/securityquestionanswer";
            
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
   // This API is used to login to a user's account during the second MFA step with an Authenticator Code.
   // </summary>
   // <param name="multiFactorAuthModelByAuthenticatorCode">Model Class containing Definition of payload for MultiFactorAuthModel By Authenticator Code API</param>
   // <param name="secondfactorauthenticationtoken">A Uniquely generated MFA identifier token after successful authentication</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Complete user UserProfile data</returns>
   // 44.7	    
		
		
   public void mfaValidateAuthenticatorCode(MultiFactorAuthModelByAuthenticatorCode multiFactorAuthModelByAuthenticatorCode, String secondfactorauthenticationtoken,
      String fields, final AsyncHandler<MultiFactorAuthenticationResponse<Identity>> handler) {

      if (multiFactorAuthModelByAuthenticatorCode == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiFactorAuthModelByAuthenticatorCode"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondfactorauthenticationtoken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondfactorauthenticationtoken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondfactorauthenticationtoken", secondfactorauthenticationtoken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/auth/login/2fa/verification/authenticatorcode";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(multiFactorAuthModelByAuthenticatorCode), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<MultiFactorAuthenticationResponse<Identity>> typeToken = new TypeToken<MultiFactorAuthenticationResponse<Identity>>() {};
          MultiFactorAuthenticationResponse<Identity> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to validate an Authenticator Code as part of the MFA process.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="multiFactorAuthModelByAuthenticatorCodeSecurityAnswer">Model Class containing Definition of payload for MultiFactorAuthModel By Authenticator Code API with security answer</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Complete user UserProfile data</returns>
   // 44.8	    
		
		
   public void mfaVerifyAuthenticatorCode(String accessToken, MultiFactorAuthModelByAuthenticatorCodeSecurityAnswer multiFactorAuthModelByAuthenticatorCodeSecurityAnswer,
      String fields, final AsyncHandler<UserProfile> handler) {

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (multiFactorAuthModelByAuthenticatorCodeSecurityAnswer == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiFactorAuthModelByAuthenticatorCodeSecurityAnswer"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "identity/v2/auth/account/2fa/verification/authenticatorcode";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(multiFactorAuthModelByAuthenticatorCodeSecurityAnswer), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfile> typeToken = new TypeToken<UserProfile>() {};
          UserProfile successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
