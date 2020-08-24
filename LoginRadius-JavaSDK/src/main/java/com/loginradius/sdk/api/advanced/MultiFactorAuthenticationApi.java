/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
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
import com.loginradius.sdk.models.requestmodels.MultiFactorAuthModelByBackupCode;
import com.loginradius.sdk.models.requestmodels.MultiFactorAuthModelByGoogleAuthenticatorCode;
import com.loginradius.sdk.models.requestmodels.MultiFactorAuthModelWithLockout;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.MultiFactorAuthenticationResponse;
import com.loginradius.sdk.models.responsemodels.MultiFactorAuthenticationSettingsResponse;
import com.loginradius.sdk.models.responsemodels.SMSResponseData;
import com.loginradius.sdk.models.responsemodels.otherobjects.BackupCodeResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
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
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <returns>Response containing Definition of Complete Multi-Factor Authentication Settings data</returns>
   // 5.7	    
		
		
   public void mfaConfigureByAccessToken(String accessToken, String smsTemplate2FA, final AsyncHandler<MultiFactorAuthenticationSettingsResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
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
   // This API is used to Enable Multi-factor authentication by access token on user login
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="multiFactorAuthModelByGoogleAuthenticatorCode">Model Class containing Definition of payload for MultiFactorAuthModel By GoogleAuthenticator Code API</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <returns>Response containing Definition for Complete profile data</returns>
   // 5.10	    
		
		
   public void mfaUpdateByAccessToken(String accessToken, MultiFactorAuthModelByGoogleAuthenticatorCode multiFactorAuthModelByGoogleAuthenticatorCode,
      String fields, String smsTemplate, final AsyncHandler<Identity> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (multiFactorAuthModelByGoogleAuthenticatorCode == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("multiFactorAuthModelByGoogleAuthenticatorCode"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      String resourcePath = "identity/v2/auth/account/2fa/verification/googleauthenticatorcode";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(multiFactorAuthModelByGoogleAuthenticatorCode), new AsyncHandler<String>() {
			
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
   // <returns>Response containing Definition for Complete SMS data</returns>
   // 5.11	    
		
		
   public void mfaUpdatePhoneNumberByToken(String accessToken, String phoneNo2FA,
      String smsTemplate2FA, final AsyncHandler<SMSResponseData> handler) {      

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

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phoneNo2FA", phoneNo2FA);

      String resourcePath = "identity/v2/auth/account/2fa";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SMSResponseData> typeToken = new TypeToken<SMSResponseData>() {};
          SMSResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API Resets the Google Authenticator configurations on a given account via the access token
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="googleauthenticator">boolean type value,Enable google Authenticator Code.</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 5.12.1	    
		
		
   public void mfaResetGoogleAuthByToken(String accessToken, Boolean googleauthenticator, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("googleauthenticator", googleauthenticator);

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
   // <returns>Complete user UserProfile data</returns>
   // 9.8.1	    
		
		
   public void mfaLoginByEmail(String email, String password,
      String emailTemplate, String fields, String loginUrl, String smsTemplate, String smsTemplate2FA,
      String verificationUrl, final AsyncHandler<MultiFactorAuthenticationResponse<Identity>> handler) {      

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
   // <returns>Complete user UserProfile data</returns>
   // 9.8.2	    
		
		
   public void mfaLoginByUserName(String password, String username,
      String emailTemplate, String fields, String loginUrl, String smsTemplate, String smsTemplate2FA,
      String verificationUrl, final AsyncHandler<MultiFactorAuthenticationResponse<Identity>> handler) {      

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
   // <returns>Complete user UserProfile data</returns>
   // 9.8.3	    
		
		
   public void mfaLoginByPhone(String password, String phone,
      String emailTemplate, String fields, String loginUrl, String smsTemplate, String smsTemplate2FA,
      String verificationUrl, final AsyncHandler<MultiFactorAuthenticationResponse<Identity>> handler) {      

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
   // <returns>Complete user UserProfile data</returns>
   // 9.12	    
		
		
   public void mfaValidateOTPByPhone(MultiFactorAuthModelWithLockout multiFactorAuthModelWithLockout, String secondFactorAuthenticationToken,
      String fields, String smsTemplate2FA, final AsyncHandler<AccessToken<Identity>> handler) {

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
   // This API is used to login via Multi-factor-authentication by passing the google authenticator code.
   // </summary>
   // <param name="googleAuthenticatorCode">The code generated by google authenticator app after scanning QR code</param>
   // <param name="secondFactorAuthenticationToken">A Uniquely generated MFA identifier token after successful authentication</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="smsTemplate2FA">SMS Template Name</param>
   // <returns>Complete user UserProfile data</returns>
   // 9.13	    
		
		
   public void mfaValidateGoogleAuthCode(String googleAuthenticatorCode, String secondFactorAuthenticationToken,
      String fields, String smsTemplate2FA, final AsyncHandler<AccessToken<Identity>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(googleAuthenticatorCode)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("googleAuthenticatorCode"));
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

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("googleAuthenticatorCode", googleAuthenticatorCode);

      String resourcePath = "identity/v2/auth/login/2fa/verification/googleauthenticatorcode";
            
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
   // This API is used to validate the backup code provided by the user and if valid, we return an access token allowing the user to login incases where Multi-factor authentication (MFA) is enabled and the secondary factor is unavailable. When a user initially downloads the Backup codes, We generate 10 codes, each code can only be consumed once. if any user attempts to go over the number of invalid login attempts configured in the Dashboard then the account gets blocked automatically
   // </summary>
   // <param name="multiFactorAuthModelByBackupCode">Model Class containing Definition of payload for MultiFactorAuth By BackupCode API</param>
   // <param name="secondFactorAuthenticationToken">A Uniquely generated MFA identifier token after successful authentication</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Complete user UserProfile data</returns>
   // 9.14	    
		
		
   public void mfaValidateBackupCode(MultiFactorAuthModelByBackupCode multiFactorAuthModelByBackupCode, String secondFactorAuthenticationToken,
      String fields, final AsyncHandler<AccessToken<Identity>> handler) {

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
   // <returns>Response containing Definition for Complete SMS data</returns>
   // 9.16	    
		
		
   public void mfaUpdatePhoneNumber(String phoneNo2FA, String secondFactorAuthenticationToken,
      String smsTemplate2FA, final AsyncHandler<SMSResponseData> handler) {      

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

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("phoneNo2FA", phoneNo2FA);

      String resourcePath = "identity/v2/auth/login/2fa";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SMSResponseData> typeToken = new TypeToken<SMSResponseData>() {};
          SMSResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
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
   // <returns>Response containing Definition for Complete SMS data</returns>
   // 9.17	    
		
		
   public void mfaResendOTP(String secondFactorAuthenticationToken, String smsTemplate2FA, final AsyncHandler<SMSResponseData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(secondFactorAuthenticationToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("secondFactorAuthenticationToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("secondFactorAuthenticationToken", secondFactorAuthenticationToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate2FA)) {
        queryParameters.put("smsTemplate2FA", smsTemplate2FA);
      }

      String resourcePath = "identity/v2/auth/login/2fa/resend";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<SMSResponseData> typeToken = new TypeToken<SMSResponseData>() {};
          SMSResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
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
   // This API resets the Google Authenticator configurations on a given account via the UID.
   // </summary>
   // <param name="googleauthenticator">boolean type value,Enable google Authenticator Code.</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.21.2	    
		
		
   public void mfaResetGoogleAuthenticatorByUid(Boolean googleauthenticator, String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("uid", uid);

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("googleauthenticator", googleauthenticator);

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
}
