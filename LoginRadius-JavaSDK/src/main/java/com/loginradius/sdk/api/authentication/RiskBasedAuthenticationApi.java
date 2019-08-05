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
import com.loginradius.sdk.models.requestmodels.EmailAuthenticationModel;
import com.loginradius.sdk.models.requestmodels.PhoneAuthenticationModel;
import com.loginradius.sdk.models.requestmodels.UserNameAuthenticationModel;
import com.loginradius.sdk.models.responsemodels.AccessToken;
import com.loginradius.sdk.models.responsemodels.userprofile.Identity;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class RiskBasedAuthenticationApi {
   private static Gson gson =new Gson();

   public RiskBasedAuthenticationApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API retrieves a copy of the user data based on the Email
   // </summary>
   // <param name="emailAuthenticationModel">Model Class containing Definition of payload for Email Authentication API</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="loginUrl">Url where the user is logging from</param>
   // <param name="passwordDelegation">Password Delegation Allows you to use a third-party service to store your passwords rather than LoginRadius Cloud storage.</param>
   // <param name="passwordDelegationApp">RiskBased Authentication Password Delegation App</param>
   // <param name="rbaBrowserEmailTemplate">Risk Based Authentication Browser EmailTemplate</param>
   // <param name="rbaBrowserSmsTemplate">Risk Based Authentication Browser Sms Template</param>
   // <param name="rbaCityEmailTemplate">Risk Based Authentication City Email Template</param>
   // <param name="rbaCitySmsTemplate">Risk Based Authentication City SmsTemplate</param>
   // <param name="rbaCountryEmailTemplate">Risk Based Authentication Country EmailTemplate</param>
   // <param name="rbaCountrySmsTemplate">Risk Based Authentication Country SmsTemplate</param>
   // <param name="rbaIpEmailTemplate">Risk Based Authentication Ip EmailTemplate</param>
   // <param name="rbaIpSmsTemplate">Risk Based Authentication Ip SmsTemplate</param>
   // <param name="rbaOneclickEmailTemplate">Risk Based Authentication Oneclick EmailTemplate</param>
   // <param name="rbaOTPSmsTemplate">Risk Based Authentication Oneclick EmailTemplate</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.2.4	    
		
		
   public void rbaLoginByEmail(EmailAuthenticationModel emailAuthenticationModel, String emailTemplate,
      String fields, String loginUrl, Boolean passwordDelegation, String passwordDelegationApp, String rbaBrowserEmailTemplate,
      String rbaBrowserSmsTemplate, String rbaCityEmailTemplate, String rbaCitySmsTemplate, String rbaCountryEmailTemplate,
      String rbaCountrySmsTemplate, String rbaIpEmailTemplate, String rbaIpSmsTemplate, String rbaOneclickEmailTemplate,
      String rbaOTPSmsTemplate, String smsTemplate, String verificationUrl, final AsyncHandler<AccessToken<Identity>> handler) {

      if (emailAuthenticationModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("emailAuthenticationModel"));
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

      if (passwordDelegation != null && passwordDelegation) {
        queryParameters.put("passwordDelegation", String.valueOf(passwordDelegation));
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(passwordDelegationApp)) {
        queryParameters.put("passwordDelegationApp", passwordDelegationApp);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserEmailTemplate)) {
        queryParameters.put("rbaBrowserEmailTemplate", rbaBrowserEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserSmsTemplate)) {
        queryParameters.put("rbaBrowserSmsTemplate", rbaBrowserSmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCityEmailTemplate)) {
        queryParameters.put("rbaCityEmailTemplate", rbaCityEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCitySmsTemplate)) {
        queryParameters.put("rbaCitySmsTemplate", rbaCitySmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountryEmailTemplate)) {
        queryParameters.put("rbaCountryEmailTemplate", rbaCountryEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountrySmsTemplate)) {
        queryParameters.put("rbaCountrySmsTemplate", rbaCountrySmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpEmailTemplate)) {
        queryParameters.put("rbaIpEmailTemplate", rbaIpEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpSmsTemplate)) {
        queryParameters.put("rbaIpSmsTemplate", rbaIpSmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaOneclickEmailTemplate)) {
        queryParameters.put("rbaOneclickEmailTemplate", rbaOneclickEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaOTPSmsTemplate)) {
        queryParameters.put("rbaOTPSmsTemplate", rbaOTPSmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      String resourcePath = "identity/v2/auth/login";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(emailAuthenticationModel), new AsyncHandler<String>() {
			
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
   // This API retrieves a copy of the user data based on the Username
   // </summary>
   // <param name="userNameAuthenticationModel">Model Class containing Definition of payload for Username Authentication API</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="loginUrl">Url where the user is logging from</param>
   // <param name="passwordDelegation">Password Delegation Allows you to use a third-party service to store your passwords rather than LoginRadius Cloud storage.</param>
   // <param name="passwordDelegationApp">RiskBased Authentication Password Delegation App</param>
   // <param name="rbaBrowserEmailTemplate">Risk Based Authentication Browser EmailTemplate</param>
   // <param name="rbaBrowserSmsTemplate">Risk Based Authentication Browser Sms Template</param>
   // <param name="rbaCityEmailTemplate">Risk Based Authentication City Email Template</param>
   // <param name="rbaCitySmsTemplate">Risk Based Authentication City SmsTemplate</param>
   // <param name="rbaCountryEmailTemplate">Risk Based Authentication Country EmailTemplate</param>
   // <param name="rbaCountrySmsTemplate">Risk Based Authentication Country SmsTemplate</param>
   // <param name="rbaIpEmailTemplate">Risk Based Authentication Ip EmailTemplate</param>
   // <param name="rbaIpSmsTemplate">Risk Based Authentication Ip SmsTemplate</param>
   // <param name="rbaOneclickEmailTemplate">Risk Based Authentication Oneclick EmailTemplate</param>
   // <param name="rbaOTPSmsTemplate">Risk Based Authentication OTPSmsTemplate</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.2.5	    
		
		
   public void rbaLoginByUserName(UserNameAuthenticationModel userNameAuthenticationModel, String emailTemplate,
      String fields, String loginUrl, Boolean passwordDelegation, String passwordDelegationApp, String rbaBrowserEmailTemplate,
      String rbaBrowserSmsTemplate, String rbaCityEmailTemplate, String rbaCitySmsTemplate, String rbaCountryEmailTemplate,
      String rbaCountrySmsTemplate, String rbaIpEmailTemplate, String rbaIpSmsTemplate, String rbaOneclickEmailTemplate,
      String rbaOTPSmsTemplate, String smsTemplate, String verificationUrl, final AsyncHandler<AccessToken<Identity>> handler) {

      if (userNameAuthenticationModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("userNameAuthenticationModel"));
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

      if (passwordDelegation != null && passwordDelegation) {
        queryParameters.put("passwordDelegation", String.valueOf(passwordDelegation));
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(passwordDelegationApp)) {
        queryParameters.put("passwordDelegationApp", passwordDelegationApp);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserEmailTemplate)) {
        queryParameters.put("rbaBrowserEmailTemplate", rbaBrowserEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserSmsTemplate)) {
        queryParameters.put("rbaBrowserSmsTemplate", rbaBrowserSmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCityEmailTemplate)) {
        queryParameters.put("rbaCityEmailTemplate", rbaCityEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCitySmsTemplate)) {
        queryParameters.put("rbaCitySmsTemplate", rbaCitySmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountryEmailTemplate)) {
        queryParameters.put("rbaCountryEmailTemplate", rbaCountryEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountrySmsTemplate)) {
        queryParameters.put("rbaCountrySmsTemplate", rbaCountrySmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpEmailTemplate)) {
        queryParameters.put("rbaIpEmailTemplate", rbaIpEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpSmsTemplate)) {
        queryParameters.put("rbaIpSmsTemplate", rbaIpSmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaOneclickEmailTemplate)) {
        queryParameters.put("rbaOneclickEmailTemplate", rbaOneclickEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaOTPSmsTemplate)) {
        queryParameters.put("rbaOTPSmsTemplate", rbaOTPSmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
      }

      String resourcePath = "identity/v2/auth/login";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(userNameAuthenticationModel), new AsyncHandler<String>() {
			
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
   // This API retrieves a copy of the user data based on the Phone
   // </summary>
   // <param name="phoneAuthenticationModel">Model Class containing Definition of payload for PhoneAuthenticationModel API</param>
   // <param name="emailTemplate">Email template name</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <param name="loginUrl">Url where the user is logging from</param>
   // <param name="passwordDelegation">Password Delegation Allows you to use a third-party service to store your passwords rather than LoginRadius Cloud storage.</param>
   // <param name="passwordDelegationApp">RiskBased Authentication Password Delegation App</param>
   // <param name="rbaBrowserEmailTemplate">Risk Based Authentication Browser EmailTemplate</param>
   // <param name="rbaBrowserSmsTemplate">Risk Based Authentication Browser Sms Template</param>
   // <param name="rbaCityEmailTemplate">Risk Based Authentication City Email Template</param>
   // <param name="rbaCitySmsTemplate">Risk Based Authentication City SmsTemplate</param>
   // <param name="rbaCountryEmailTemplate">Risk Based Authentication Country EmailTemplate</param>
   // <param name="rbaCountrySmsTemplate">Risk Based Authentication Country SmsTemplate</param>
   // <param name="rbaIpEmailTemplate">Risk Based Authentication Ip EmailTemplate</param>
   // <param name="rbaIpSmsTemplate">Risk Based Authentication Ip SmsTemplate</param>
   // <param name="rbaOneclickEmailTemplate">Risk Based Authentication Oneclick EmailTemplate</param>
   // <param name="rbaOTPSmsTemplate">Risk Based Authentication OTPSmsTemplate</param>
   // <param name="smsTemplate">SMS Template name</param>
   // <param name="verificationUrl">Email verification url</param>
   // <returns>Response containing User Profile Data and access token</returns>
   // 9.2.6	    
		
		
   public void rbaLoginByPhone(PhoneAuthenticationModel phoneAuthenticationModel, String emailTemplate,
      String fields, String loginUrl, Boolean passwordDelegation, String passwordDelegationApp, String rbaBrowserEmailTemplate,
      String rbaBrowserSmsTemplate, String rbaCityEmailTemplate, String rbaCitySmsTemplate, String rbaCountryEmailTemplate,
      String rbaCountrySmsTemplate, String rbaIpEmailTemplate, String rbaIpSmsTemplate, String rbaOneclickEmailTemplate,
      String rbaOTPSmsTemplate, String smsTemplate, String verificationUrl, final AsyncHandler<AccessToken<Identity>> handler) {

      if (phoneAuthenticationModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("phoneAuthenticationModel"));
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

      if (passwordDelegation != null && passwordDelegation) {
        queryParameters.put("passwordDelegation", String.valueOf(passwordDelegation));
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(passwordDelegationApp)) {
        queryParameters.put("passwordDelegationApp", passwordDelegationApp);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserEmailTemplate)) {
        queryParameters.put("rbaBrowserEmailTemplate", rbaBrowserEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaBrowserSmsTemplate)) {
        queryParameters.put("rbaBrowserSmsTemplate", rbaBrowserSmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCityEmailTemplate)) {
        queryParameters.put("rbaCityEmailTemplate", rbaCityEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCitySmsTemplate)) {
        queryParameters.put("rbaCitySmsTemplate", rbaCitySmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountryEmailTemplate)) {
        queryParameters.put("rbaCountryEmailTemplate", rbaCountryEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaCountrySmsTemplate)) {
        queryParameters.put("rbaCountrySmsTemplate", rbaCountrySmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpEmailTemplate)) {
        queryParameters.put("rbaIpEmailTemplate", rbaIpEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaIpSmsTemplate)) {
        queryParameters.put("rbaIpSmsTemplate", rbaIpSmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaOneclickEmailTemplate)) {
        queryParameters.put("rbaOneclickEmailTemplate", rbaOneclickEmailTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(rbaOTPSmsTemplate)) {
        queryParameters.put("rbaOTPSmsTemplate", rbaOTPSmsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(smsTemplate)) {
        queryParameters.put("smsTemplate", smsTemplate);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
        queryParameters.put("verificationUrl", verificationUrl);
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
}
