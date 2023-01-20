/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.social;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.responsemodels.AccessTokenBase;
import com.loginradius.sdk.models.responsemodels.PostMethodResponseBase;
import com.loginradius.sdk.models.responsemodels.UserActiveSession;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class SocialApi {
   private static Gson gson =new Gson();

   public SocialApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API Is used to translate the Request Token returned during authentication into an Access Token that can be used with other API calls.
   // </summary>
   // <param name="token">Token generated from a successful oauth from social platform</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 20.1	    
		
		
   public void exchangeAccessToken(String token, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(token)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("token"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("secret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("token", token);

      String resourcePath = "api/v2/access_token";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessTokenBase> typeToken = new TypeToken<AccessTokenBase>() {};
          AccessTokenBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Refresh Access Token API is used to refresh the provider access token after authentication. It will be valid for up to 60 days on LoginRadius depending on the provider. In order to use the access token in other APIs, always refresh the token using this API.<br><br><b>Supported Providers :</b> Facebook,Yahoo,Google,Twitter, Linkedin.<br><br> Contact LoginRadius support team to enable this API.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="expiresIn">Allows you to specify a desired expiration time in minutes for the newly issued access token.</param>
   // <param name="isWeb">Is web or not.</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 20.2	    
		
		
   public void refreshAccessToken(String accessToken, Integer expiresIn,
      Boolean isWeb, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("secret", LoginRadiusSDK.getApiSecret());

      if (expiresIn != null) {
        queryParameters.put("expiresIn", String.valueOf(expiresIn));
      }

      if (isWeb != null && isWeb) {
        queryParameters.put("isWeb", String.valueOf(isWeb));
      }

      String resourcePath = "api/v2/access_token/refresh";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessTokenBase> typeToken = new TypeToken<AccessTokenBase>() {};
          AccessTokenBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API validates access token, if valid then returns a response with its expiry otherwise error.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 20.9	    
		
		
   public void validateAccessToken(String accessToken, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("secret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "api/v2/access_token/validate";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessTokenBase> typeToken = new TypeToken<AccessTokenBase>() {};
          AccessTokenBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This api invalidates the active access token or expires an access token validity.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response containing Definition for Complete Validation data</returns>
   // 20.10	    
		
		
   public void inValidateAccessToken(String accessToken, final AsyncHandler<PostMethodResponseBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("secret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "api/v2/access_token/invalidate";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostMethodResponseBase> typeToken = new TypeToken<PostMethodResponseBase>() {};
          PostMethodResponseBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This api is use to get all active session by Access Token.
   // </summary>
   // <param name="token">Token generated from a successful oauth from social platform</param>
   // <returns>Response containing Definition for Complete active sessions</returns>
   // 20.11.1	    
		
		
   public void getActiveSession(String token, final AsyncHandler<UserActiveSession> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(token)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("token"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("secret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("token", token);

      String resourcePath = "api/v2/access_token/activesession";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserActiveSession> typeToken = new TypeToken<UserActiveSession>() {};
          UserActiveSession successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This api is used to get all active sessions by AccountID(UID).
   // </summary>
   // <param name="accountId">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition for Complete active sessions</returns>
   // 20.11.2	    
		
		
   public void getActiveSessionByAccountID(String accountId, final AsyncHandler<UserActiveSession> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accountId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accountId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("accountId", accountId);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("secret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "api/v2/access_token/activesession";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserActiveSession> typeToken = new TypeToken<UserActiveSession>() {};
          UserActiveSession successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This api is used to get all active sessions by ProfileId.
   // </summary>
   // <param name="profileId">Social Provider Id</param>
   // <returns>Response containing Definition for Complete active sessions</returns>
   // 20.11.3	    
		
		
   public void getActiveSessionByProfileID(String profileId, final AsyncHandler<UserActiveSession> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(profileId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("profileId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("profileId", profileId);
      queryParameters.put("secret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "api/v2/access_token/activesession";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserActiveSession> typeToken = new TypeToken<UserActiveSession>() {};
          UserActiveSession successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
