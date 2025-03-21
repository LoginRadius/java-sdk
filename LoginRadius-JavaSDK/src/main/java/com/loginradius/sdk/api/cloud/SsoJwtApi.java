/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.cloud;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.requestmodels.SsoAuthenticationModel;
import com.loginradius.sdk.models.responsemodels.SsoJwtResponseData;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class SsoJwtApi {
   private static Gson gson =new Gson();

   public SsoJwtApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   

   // <summary>
   // This API is used to get the JWT token by access token.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="jwtAppName">Jwt App Name</param>
   // <returns>Response containing Definition Complete SsoJwtResponseData data</returns>
    
	public void jwtTokenByAccessToken(String accessToken, String jwtAppName,final AsyncHandler<SsoJwtResponseData> handler) {

		if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
			throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
		}

		if (LoginRadiusValidator.isNullOrWhiteSpace(jwtAppName)) {
			throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("jwtAppName"));
		}
		
		Map<String, String> queryParameters = new HashMap<String, String>();
	    queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
	    queryParameters.put("access_token", accessToken);
	    queryParameters.put("jwtapp", jwtAppName);

		String resourcePath = "sso/jwt/api/token";

		LoginRadiusRequest.execute("GET", resourcePath, queryParameters,null,new AsyncHandler<String>() {

					@Override
					public void onSuccess(String response) {
				          TypeToken<SsoJwtResponseData> typeToken = new TypeToken<SsoJwtResponseData>() {};
				          SsoJwtResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
				          handler.onSuccess(successResponse);
					}

					@Override
					public void onFailure(ErrorResponse errorResponse) {
						handler.onFailure(errorResponse);
					}
				});
	}
   
	   // <summary>
	   // This API is used to get a JWT token by Email and Password.
	   // </summary>
	   // <param name="ssoAuthenticationModel">Model Class containing Definition of payload for SSO Jwt Cloud Api</param>
	   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
	   // <param name="jwtAppName">Jwt App Name</param>
	   // <returns>Response containing Definition Complete SsoJwtResponseData data</returns>
	    
	public void jwtTokenByEmail(SsoAuthenticationModel ssoAuthenticationModel, String jwtAppName,String emailTemplate,String loginUrl, String verificationUrl,final AsyncHandler<SsoJwtResponseData> handler) {

	    if (ssoAuthenticationModel == null) {
	          throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("ssoAuthenticationModel"));
	    }
		if (LoginRadiusValidator.isNullOrWhiteSpace(jwtAppName)) {
			throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("jwtAppName"));
		}
		
		Map<String, String> queryParameters = new HashMap<String, String>();
	    queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
	    queryParameters.put("jwtapp", jwtAppName);
	   
	    if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
	        queryParameters.put("emailTemplate", emailTemplate);
	    }

	    if (!LoginRadiusValidator.isNullOrWhiteSpace(loginUrl)) {
	        queryParameters.put("loginUrl", loginUrl);
	    }

	    if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
	        queryParameters.put("verificationurl", verificationUrl);
	    }
		String resourcePath = "sso/jwt/api/login";

		LoginRadiusRequest.execute("POST", resourcePath, queryParameters,gson.toJson(ssoAuthenticationModel),new AsyncHandler<String>() {

					@Override
					public void onSuccess(String response) {
						   TypeToken<SsoJwtResponseData> typeToken = new TypeToken<SsoJwtResponseData>() {};
					       SsoJwtResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
					       handler.onSuccess(successResponse);
					}

					@Override
					public void onFailure(ErrorResponse errorResponse) {
						handler.onFailure(errorResponse);
					}
				});
	}
	
	   // <summary>
	   // This API is used to get a JWT token by UserName and Password.
	   // </summary>
	   // <param name="ssoAuthenticationModel">Model Class containing Definition of payload for SSO Jwt Cloud Api</param>
	   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
	   // <param name="jwtAppName">Jwt App Name</param>
	   // <returns>Response containing Definition Complete SsoJwtResponseData data</returns>
	    
	public void jwtTokenByUserName(SsoAuthenticationModel ssoAuthenticationModel, String jwtAppName, String emailTemplate,String loginUrl, String verificationUrl, final AsyncHandler<SsoJwtResponseData> handler) {

		
		  if (ssoAuthenticationModel == null) {
	          throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("ssoAuthenticationModel"));
	    }

		if (LoginRadiusValidator.isNullOrWhiteSpace(jwtAppName)) {
			throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("jwtAppName"));
		}
		
		Map<String, String> queryParameters = new HashMap<String, String>();
	    queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
	    queryParameters.put("jwtapp", jwtAppName);

	    if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
	        queryParameters.put("emailTemplate", emailTemplate);
	    }

	    if (!LoginRadiusValidator.isNullOrWhiteSpace(loginUrl)) {
	        queryParameters.put("loginUrl", loginUrl);
	    }

	    if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
	        queryParameters.put("verificationurl", verificationUrl);
	    }
		String resourcePath = "sso/jwt/api/login";

		LoginRadiusRequest.execute("POST", resourcePath, queryParameters,gson.toJson(ssoAuthenticationModel),new AsyncHandler<String>() {

					@Override
					public void onSuccess(String response) {
						 TypeToken<SsoJwtResponseData> typeToken = new TypeToken<SsoJwtResponseData>() {};
					     SsoJwtResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
					     handler.onSuccess(successResponse);
					}

					@Override
					public void onFailure(ErrorResponse errorResponse) {
						handler.onFailure(errorResponse);
					}
				});
	}
	   // <summary>
	   // This API is used to get a JWT token by Phone and Password.
	   // </summary>
	   // <param name="ssoAuthenticationModel">Model Class containing Definition of payload for SSO Jwt Cloud Api</param>
	   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
	   // <param name="jwtAppName">Jwt App Name</param>
	   // <returns>Response containing Definition Complete SsoJwtResponseData data</returns>
	    
	public void jwtTokenByPhone(SsoAuthenticationModel ssoAuthenticationModel,String jwtAppName,String emailTemplate,String loginUrl, String verificationUrl,final AsyncHandler<SsoJwtResponseData> handler) {

		if (ssoAuthenticationModel == null) {
	          throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("ssoAuthenticationModel"));
	    }

		if (LoginRadiusValidator.isNullOrWhiteSpace(jwtAppName)) {
			throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("jwtAppName"));
		}
		
		Map<String, String> queryParameters = new HashMap<String, String>();
	    queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
	    queryParameters.put("jwtapp", jwtAppName);

	    
	    if (!LoginRadiusValidator.isNullOrWhiteSpace(emailTemplate)) {
	        queryParameters.put("emailTemplate", emailTemplate);
	    }

	    if (!LoginRadiusValidator.isNullOrWhiteSpace(loginUrl)) {
	        queryParameters.put("loginUrl", loginUrl);
	    }

	    if (!LoginRadiusValidator.isNullOrWhiteSpace(verificationUrl)) {
	        queryParameters.put("verificationurl", verificationUrl);
	    }
	    
		String resourcePath = "sso/jwt/api/login";

		LoginRadiusRequest.execute("POST", resourcePath, queryParameters,gson.toJson(ssoAuthenticationModel),new AsyncHandler<String>() {

					@Override
					public void onSuccess(String response) {
						 TypeToken<SsoJwtResponseData> typeToken = new TypeToken<SsoJwtResponseData>() {};
					     SsoJwtResponseData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
					     handler.onSuccess(successResponse);
					}

					@Override
					public void onFailure(ErrorResponse errorResponse) {
						handler.onFailure(errorResponse);
					}
				});
	}
   

}
