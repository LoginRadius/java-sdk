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
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class NativeSocialApi {
   private static Gson gson =new Gson();

   public NativeSocialApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   /**
    * The API is used to get LoginRadius access token by sending Facebook's access token. It will be valid for the specific duration of time specified in the response.
    * @param fbAccessToken Facebook Access Token
    * @param socialAppName Name of Social provider APP
    * @return Response containing Definition of Complete Token data
    * @since 20.3
    */
		
		
   public void getAccessTokenByFacebookAccessToken(String fbAccessToken, String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(fbAccessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("fbAccessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("fb_Access_Token", fbAccessToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("socialAppName", socialAppName);
      }

      String resourcePath = "api/v2/access_token/facebook";
            
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
   
   /**
    * The API is used to get LoginRadius access token by sending Twitter's access token. It will be valid for the specific duration of time specified in the response.
    * @param twAccessToken Twitter Access Token
    * @param twTokenSecret Twitter Token Secret
    * @param socialAppName Name of Social provider APP
    * @return Response containing Definition of Complete Token data
    * @since 20.4
    */
		
		
   public void getAccessTokenByTwitterAccessToken(String twAccessToken, String twTokenSecret,
      String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(twAccessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("twAccessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(twTokenSecret)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("twTokenSecret"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("tw_Access_Token", twAccessToken);
      queryParameters.put("tw_Token_Secret", twTokenSecret);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("socialAppName", socialAppName);
      }

      String resourcePath = "api/v2/access_token/twitter";
            
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
   
   /**
    * The API is used to get LoginRadius access token by sending Google's access token. It will be valid for the specific duration of time specified in the response.
    * @param googleAccessToken Google Access Token
    * @param clientId Google Client ID
    * @param refreshToken LoginRadius refresh token
    * @param socialAppName Name of Social provider APP
    * @return Response containing Definition of Complete Token data
    * @since 20.5
    */
		
		
   public void getAccessTokenByGoogleAccessToken(String googleAccessToken, String clientId,
      String refreshToken, String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(googleAccessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("googleAccessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("google_Access_Token", googleAccessToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(clientId)) {
        queryParameters.put("client_id", clientId);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(refreshToken)) {
        queryParameters.put("refresh_token", refreshToken);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("socialAppName", socialAppName);
      }

      String resourcePath = "api/v2/access_token/google";
            
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
   
   /**
    * This API is used to Get LoginRadius Access Token using google jwt id token for google native mobile login/registration.
    * @param idToken Google JWT id_token
    * @return Response containing Definition of Complete Token data
    * @since 20.6
    */
		
		
   public void getAccessTokenByGoogleJWTAccessToken(String idToken, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(idToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("idToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("id_Token", idToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());

      String resourcePath = "api/v2/access_token/googlejwt";
            
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
   
   /**
    * The API is used to get LoginRadius access token by sending Linkedin's access token. It will be valid for the specific duration of time specified in the response.
    * @param lnAccessToken Linkedin Access Token
    * @param socialAppName Name of Social provider APP
    * @return Response containing Definition of Complete Token data
    * @since 20.7
    */
		
		
   public void getAccessTokenByLinkedinAccessToken(String lnAccessToken, String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(lnAccessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("lnAccessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("ln_Access_Token", lnAccessToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("socialAppName", socialAppName);
      }

      String resourcePath = "api/v2/access_token/linkedin";
            
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
   
   /**
    * The API is used to get LoginRadius access token by sending Foursquare's access token. It will be valid for the specific duration of time specified in the response.
    * @param fsAccessToken Foursquare Access Token
    * @return Response containing Definition of Complete Token data
    * @since 20.8
    */
		
		
   public void getAccessTokenByFoursquareAccessToken(String fsAccessToken, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(fsAccessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("fsAccessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("fs_Access_Token", fsAccessToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());

      String resourcePath = "api/v2/access_token/foursquare";
            
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
   
   /**
    * The API is used to get LoginRadius access token by sending a valid Apple ID OAuth Code. It will be valid for the specific duration of time specified in the response.
    * @param code Apple Code
    * @param socialAppName Name of Social provider APP
    * @return Response containing Definition of Complete Token data
    * @since 20.12
    */
		
		
   public void getAccessTokenByAppleIdCode(String code, String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(code)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("code"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("code", code);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("socialAppName", socialAppName);
      }

      String resourcePath = "api/v2/access_token/apple";
            
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
   
   /**
    * This API is used to retrieve a LoginRadius access token by passing in a valid WeChat OAuth Code.
    * @param code WeChat Code
    * @return Response containing Definition of Complete Token data
    * @since 20.13
    */
		
		
   public void getAccessTokenByWeChatCode(String code, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(code)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("code"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("code", code);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());

      String resourcePath = "api/v2/access_token/wechat";
            
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
   
   /**
    * The API is used to get LoginRadius access token by sending Vkontakte's access token. It will be valid for the specific duration of time specified in the response.
    * @param vkAccessToken Vkontakte Access Token
    * @return Response containing Definition of Complete Token data
    * @since 20.15
    */
		
		
   public void getAccessTokenByVkontakteAccessToken(String vkAccessToken, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(vkAccessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("vkAccessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("vk_access_token", vkAccessToken);

      String resourcePath = "api/v2/access_token/vkontakte";
            
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
   
   /**
    * The API is used to get LoginRadius access token by sending Google's AuthCode. It will be valid for the specific duration of time specified in the response.
    * @param googleAuthcode Google AuthCode
    * @param socialAppName Name of Social provider APP
    * @return Response containing Definition of Complete Token data
    * @since 20.16
    */
		
		
   public void getAccessTokenByGoogleAuthCode(String googleAuthcode, String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(googleAuthcode)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("googleAuthcode"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("google_authcode", googleAuthcode);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("socialAppName", socialAppName);
      }

      String resourcePath = "api/v2/access_token/google";
            
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
}
