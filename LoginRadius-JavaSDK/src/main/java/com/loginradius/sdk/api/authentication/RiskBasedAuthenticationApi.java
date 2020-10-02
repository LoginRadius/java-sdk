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

   
   
   /**
    * This API retrieves a copy of the user data based on the Email
    * @param emailAuthenticationModel Model Class containing Definition of payload for Email Authentication API
    * @param emailTemplate Email template name
    * @param fields The fields parameter filters the API response so that the response only includes a specific set of fields
    * @param loginUrl Url where the user is logging from
    * @param passwordDelegation Password Delegation Allows you to use a third-party service to store your passwords rather than LoginRadius Cloud storage.
    * @param passwordDelegationApp RiskBased Authentication Password Delegation App
    * @param rbaBrowserEmailTemplate Risk Based Authentication Browser EmailTemplate
    * @param rbaBrowserSmsTemplate Risk Based Authentication Browser Sms Template
    * @param rbaCityEmailTemplate Risk Based Authentication City Email Template
    * @param rbaCitySmsTemplate Risk Based Authentication City SmsTemplate
    * @param rbaCountryEmailTemplate Risk Based Authentication Country EmailTemplate
    * @param rbaCountrySmsTemplate Risk Based Authentication Country SmsTemplate
    * @param rbaIpEmailTemplate Risk Based Authentication Ip EmailTemplate
    * @param rbaIpSmsTemplate Risk Based Authentication Ip SmsTemplate
    * @param rbaOneclickEmailTemplate Risk Based Authentication Oneclick EmailTemplate
    * @param rbaOTPSmsTemplate Risk Based Authentication Oneclick EmailTemplate
    * @param smsTemplate SMS Template name
    * @param verificationUrl Email verification url
    * @return Response containing User Profile Data and access token
    * @since 9.2.4
    */
		
		
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
   
   /**
    * This API retrieves a copy of the user data based on the Username
    * @param userNameAuthenticationModel Model Class containing Definition of payload for Username Authentication API
    * @param emailTemplate Email template name
    * @param fields The fields parameter filters the API response so that the response only includes a specific set of fields
    * @param loginUrl Url where the user is logging from
    * @param passwordDelegation Password Delegation Allows you to use a third-party service to store your passwords rather than LoginRadius Cloud storage.
    * @param passwordDelegationApp RiskBased Authentication Password Delegation App
    * @param rbaBrowserEmailTemplate Risk Based Authentication Browser EmailTemplate
    * @param rbaBrowserSmsTemplate Risk Based Authentication Browser Sms Template
    * @param rbaCityEmailTemplate Risk Based Authentication City Email Template
    * @param rbaCitySmsTemplate Risk Based Authentication City SmsTemplate
    * @param rbaCountryEmailTemplate Risk Based Authentication Country EmailTemplate
    * @param rbaCountrySmsTemplate Risk Based Authentication Country SmsTemplate
    * @param rbaIpEmailTemplate Risk Based Authentication Ip EmailTemplate
    * @param rbaIpSmsTemplate Risk Based Authentication Ip SmsTemplate
    * @param rbaOneclickEmailTemplate Risk Based Authentication Oneclick EmailTemplate
    * @param rbaOTPSmsTemplate Risk Based Authentication OTPSmsTemplate
    * @param smsTemplate SMS Template name
    * @param verificationUrl Email verification url
    * @return Response containing User Profile Data and access token
    * @since 9.2.5
    */
		
		
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
   
   /**
    * This API retrieves a copy of the user data based on the Phone
    * @param phoneAuthenticationModel Model Class containing Definition of payload for PhoneAuthenticationModel API
    * @param emailTemplate Email template name
    * @param fields The fields parameter filters the API response so that the response only includes a specific set of fields
    * @param loginUrl Url where the user is logging from
    * @param passwordDelegation Password Delegation Allows you to use a third-party service to store your passwords rather than LoginRadius Cloud storage.
    * @param passwordDelegationApp RiskBased Authentication Password Delegation App
    * @param rbaBrowserEmailTemplate Risk Based Authentication Browser EmailTemplate
    * @param rbaBrowserSmsTemplate Risk Based Authentication Browser Sms Template
    * @param rbaCityEmailTemplate Risk Based Authentication City Email Template
    * @param rbaCitySmsTemplate Risk Based Authentication City SmsTemplate
    * @param rbaCountryEmailTemplate Risk Based Authentication Country EmailTemplate
    * @param rbaCountrySmsTemplate Risk Based Authentication Country SmsTemplate
    * @param rbaIpEmailTemplate Risk Based Authentication Ip EmailTemplate
    * @param rbaIpSmsTemplate Risk Based Authentication Ip SmsTemplate
    * @param rbaOneclickEmailTemplate Risk Based Authentication Oneclick EmailTemplate
    * @param rbaOTPSmsTemplate Risk Based Authentication OTPSmsTemplate
    * @param smsTemplate SMS Template name
    * @param verificationUrl Email verification url
    * @return Response containing User Profile Data and access token
    * @since 9.2.6
    */
		
		
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
