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
import com.loginradius.sdk.models.requestmodels.StatusModel;
import com.loginradius.sdk.models.responsemodels.AccessTokenBase;
import com.loginradius.sdk.models.responsemodels.PostMethodResponse;
import com.loginradius.sdk.models.responsemodels.PostMethodResponseBase;
import com.loginradius.sdk.models.responsemodels.ShortUrlResponse;
import com.loginradius.sdk.models.responsemodels.StatusUpdateResponse;
import com.loginradius.sdk.models.responsemodels.UserActiveSession;
import com.loginradius.sdk.models.responsemodels.otherobjects.Album;
import com.loginradius.sdk.models.responsemodels.otherobjects.Audio;
import com.loginradius.sdk.models.responsemodels.otherobjects.CheckIn;
import com.loginradius.sdk.models.responsemodels.otherobjects.Contact;
import com.loginradius.sdk.models.responsemodels.otherobjects.CursorResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.Events;
import com.loginradius.sdk.models.responsemodels.otherobjects.Group;
import com.loginradius.sdk.models.responsemodels.otherobjects.Like;
import com.loginradius.sdk.models.responsemodels.otherobjects.Page;
import com.loginradius.sdk.models.responsemodels.otherobjects.Photo;
import com.loginradius.sdk.models.responsemodels.otherobjects.Post;
import com.loginradius.sdk.models.responsemodels.otherobjects.Status;
import com.loginradius.sdk.models.responsemodels.otherobjects.StatusUpdateStats;
import com.loginradius.sdk.models.responsemodels.otherobjects.Video;
import com.loginradius.sdk.models.responsemodels.userprofile.UserProfile;
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
   // <param name="expiresIn">Allows you to specify a desired expiration time in minutes for the newly issued access_token.</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 20.2	    
		
		
   public void refreshAccessToken(String accessToken, Integer expiresIn, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("secret", LoginRadiusSDK.getApiSecret());

      if (expiresIn != null) {
        queryParameters.put("expiresIn", String.valueOf(expiresIn));
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
   // 20.11	    
		
		
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
   // 20.12	    
		
		
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
   // 20.13	    
		
		
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
   
   // <summary>
   // <b>Supported Providers:</b> Facebook, Google, Live, Vkontakte.<br><br> This API returns the photo albums associated with the passed in access tokens Social Profile.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of Album Data</returns>
   // 22.1	    
		
		
   public void getAlbums(String accessToken, final AsyncHandler<Album[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/album";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Album[]> typeToken = new TypeToken<Album[]>() {};
          Album[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Audio API is used to get audio files data from the user’s social account.<br><br><b>Supported Providers:</b> Live, Vkontakte
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of Audio Data</returns>
   // 24.1	    
		
		
   public void getAudios(String accessToken, final AsyncHandler<Audio[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/audio";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Audio[]> typeToken = new TypeToken<Audio[]>() {};
          Audio[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Check In API is used to get check Ins data from the user’s social account.<br><br><b>Supported Providers:</b> Facebook, Foursquare, Vkontakte
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of CheckIn Data</returns>
   // 25.1	    
		
		
   public void getCheckIns(String accessToken, final AsyncHandler<CheckIn[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/checkin";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<CheckIn[]> typeToken = new TypeToken<CheckIn[]>() {};
          CheckIn[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Contact API is used to get contacts/friends/connections data from the user’s social account.This is one of the APIs that makes up the LoginRadius Friend Invite System. The data will normalized into LoginRadius’ standard data format. This API requires setting permissions in your LoginRadius Dashboard. <br><br><b>Note:</b> Facebook restricts access to the list of friends that is returned. When using the Contacts API with Facebook you will only receive friends that have accepted some permissions with your app. <br><br><b>Supported Providers:</b> Facebook, Foursquare, Google, LinkedIn, Live, Twitter, Vkontakte, Yahoo
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="nextCursor">Cursor value if not all contacts can be retrieved once.</param>
   // <returns>Response containing Definition of Contact Data with Cursor</returns>
   // 27.1	    
		
		
   public void getContacts(String accessToken, String nextCursor, final AsyncHandler<CursorResponse<Contact>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(nextCursor)) {
        queryParameters.put("nextCursor", nextCursor);
      }

      String resourcePath = "api/v2/contact";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<CursorResponse<Contact>> typeToken = new TypeToken<CursorResponse<Contact>>() {};
          CursorResponse<Contact> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Event API is used to get the event data from the user’s social account.<br><br><b>Supported Providers:</b> Facebook, Live
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of Events Data</returns>
   // 28.1	    
		
		
   public void getEvents(String accessToken, final AsyncHandler<Events[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/event";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Events[]> typeToken = new TypeToken<Events[]>() {};
          Events[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // Get the following user list from the user’s social account.<br><br><b>Supported Providers:</b> Twitter
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of Contacts Data</returns>
   // 29.1	    
		
		
   public void getFollowings(String accessToken, final AsyncHandler<Contact[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/following";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Contact[]> typeToken = new TypeToken<Contact[]>() {};
          Contact[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Group API is used to get group data from the user’s social account.<br><br><b>Supported Providers:</b> Facebook, Vkontakte
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of Groups Data</returns>
   // 30.1	    
		
		
   public void getGroups(String accessToken, final AsyncHandler<Group[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/group";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Group[]> typeToken = new TypeToken<Group[]>() {};
          Group[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Like API is used to get likes data from the user’s social account.<br><br><b>Supported Providers:</b> Facebook
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of Likes Data</returns>
   // 31.1	    
		
		
   public void getLikes(String accessToken, final AsyncHandler<Like[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/like";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Like[]> typeToken = new TypeToken<Like[]>() {};
          Like[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Mention API is used to get mentions data from the user’s social account.<br><br><b>Supported Providers:</b> Twitter
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of Status Data</returns>
   // 32.1	    
		
		
   public void getMentions(String accessToken, final AsyncHandler<Status[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/mention";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Status[]> typeToken = new TypeToken<Status[]>() {};
          Status[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // Post Message API is used to post messages to the user’s contacts.<br><br><b>Supported Providers:</b> Twitter, LinkedIn <br><br>The Message API is used to post messages to the user’s contacts. This is one of the APIs that makes up the LoginRadius Friend Invite System. After using the Contact API, you can send messages to the retrieved contacts. This API requires setting permissions in your LoginRadius Dashboard.<br><br>GET & POST Message API work the same way except the API method is different
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="message">Body of your message</param>
   // <param name="subject">Subject of your message</param>
   // <param name="to">Recipient's social provider's id</param>
   // <returns>Response containing Definition for Complete Validation data</returns>
   // 33.1	    
		
		
   public void postMessage(String accessToken, String message,
      String subject, String to, final AsyncHandler<PostMethodResponseBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(message)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("message"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(subject)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("subject"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(to)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("to"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("message", message);
      queryParameters.put("subject", subject);
      queryParameters.put("to", to);

      String resourcePath = "api/v2/message";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   // The Page API is used to get the page data from the user’s social account.<br><br><b>Supported Providers:</b>  Facebook, LinkedIn
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="pageName">Name of the page you want to retrieve info from</param>
   // <returns>Response containing Definition of Complete page data</returns>
   // 34.1	    
		
		
   public void getPage(String accessToken, String pageName, final AsyncHandler<Page> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(pageName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("pageName"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("pageName", pageName);

      String resourcePath = "api/v2/page";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Page> typeToken = new TypeToken<Page>() {};
          Page successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Photo API is used to get photo data from the user’s social account.<br><br><b>Supported Providers:</b>  Facebook, Foursquare, Google, Live, Vkontakte
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="albumId">The id of the album you want to retrieve info from</param>
   // <returns>Response Containing List of Photos Data</returns>
   // 35.1	    
		
		
   public void getPhotos(String accessToken, String albumId, final AsyncHandler<Photo[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(albumId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("albumId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("albumId", albumId);

      String resourcePath = "api/v2/photo";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Photo[]> typeToken = new TypeToken<Photo[]>() {};
          Photo[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Post API is used to get post message data from the user’s social account.<br><br><b>Supported Providers:</b>  Facebook
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of Posts Data</returns>
   // 36.1	    
		
		
   public void getPosts(String accessToken, final AsyncHandler<Post[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/post";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Post[]> typeToken = new TypeToken<Post[]>() {};
          Post[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Status API is used to update the status on the user’s wall.<br><br><b>Supported Providers:</b>  Facebook, Twitter, LinkedIn
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="caption">Message displayed below the description(Requires URL, Under 70 Characters).</param>
   // <param name="description">Description of the displayed URL and Image(Requires URL)</param>
   // <param name="imageurl">Image to be displayed in the share(Requires URL).</param>
   // <param name="status">Main body of the Status update.</param>
   // <param name="title">Title of Linked URL</param>
   // <param name="url">URL to be included when clicking on the share.</param>
   // <param name="shorturl">short url</param>
   // <returns>Response conatining Definition of Validation and Short URL data</returns>
   // 37.2	    
		
		
   public void statusPosting(String accessToken, String caption,
      String description, String imageurl, String status, String title, String url,
      String shorturl, final AsyncHandler<PostMethodResponse<ShortUrlResponse>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(caption)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("caption"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(description)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("description"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(imageurl)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("imageurl"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(status)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("status"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(title)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("title"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(url)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("url"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("caption", caption);
      queryParameters.put("description", description);
      queryParameters.put("imageurl", imageurl);
      queryParameters.put("status", status);
      queryParameters.put("title", title);
      queryParameters.put("url", url);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(shorturl)) {
        queryParameters.put("shorturl", shorturl);
      }

      String resourcePath = "api/v2/status";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostMethodResponse<ShortUrlResponse>> typeToken = new TypeToken<PostMethodResponse<ShortUrlResponse>>() {};
          PostMethodResponse<ShortUrlResponse> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Status API is used to get the status messages from the user’s social account.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <returns>Response Containing List of Status Data</returns>
   // 37.3	    
		
		
   public void getStatus(String accessToken, final AsyncHandler<Status[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/status";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<Status[]> typeToken = new TypeToken<Status[]>() {};
          Status[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Trackable status API works very similar to the Status API but it returns a Post id that you can use to track the stats(shares, likes, comments) for a specific share/post/status update. This API requires setting permissions in your LoginRadius Dashboard.<br><br> The Trackable Status API is used to update the status on the user’s wall and return an Post ID value. It is commonly referred to as Permission based sharing or Push notifications.<br><br> POST Input Parameter Format: application/x-www-form-urlencoded
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="statusModel">Model Class containing Definition of payload for Status API</param>
   // <returns>Response containing Definition for Complete status data</returns>
   // 37.6	    
		
		
   public void trackableStatusPosting(String accessToken, StatusModel statusModel, final AsyncHandler<StatusUpdateResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }

      if (statusModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("statusModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      String resourcePath = "api/v2/status/trackable";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(statusModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<StatusUpdateResponse> typeToken = new TypeToken<StatusUpdateResponse>() {};
          StatusUpdateResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Trackable status API works very similar to the Status API but it returns a Post id that you can use to track the stats(shares, likes, comments) for a specific share/post/status update. This API requires setting permissions in your LoginRadius Dashboard.<br><br> The Trackable Status API is used to update the status on the user’s wall and return an Post ID value. It is commonly referred to as Permission based sharing or Push notifications.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="caption">Message displayed below the description(Requires URL, Under 70 Characters).</param>
   // <param name="description">Description of the displayed URL and Image(Requires URL)</param>
   // <param name="imageurl">Image to be displayed in the share(Requires URL).</param>
   // <param name="status">Main body of the Status update.</param>
   // <param name="title">Title of Linked URL</param>
   // <param name="url">URL to be included when clicking on the share.</param>
   // <returns>Response containing Definition for Complete status data</returns>
   // 37.7	    
		
		
   public void getTrackableStatusStats(String accessToken, String caption,
      String description, String imageurl, String status, String title, String url, final AsyncHandler<StatusUpdateResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(caption)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("caption"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(description)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("description"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(imageurl)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("imageurl"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(status)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("status"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(title)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("title"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(url)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("url"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("caption", caption);
      queryParameters.put("description", description);
      queryParameters.put("imageurl", imageurl);
      queryParameters.put("status", status);
      queryParameters.put("title", title);
      queryParameters.put("url", url);

      String resourcePath = "api/v2/status/trackable/js";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<StatusUpdateResponse> typeToken = new TypeToken<StatusUpdateResponse>() {};
          StatusUpdateResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The Trackable status API works very similar to the Status API but it returns a Post id that you can use to track the stats(shares, likes, comments) for a specific share/post/status update. This API requires setting permissions in your LoginRadius Dashboard.<br><br> This API is used to retrieve a tracked post based on the passed in post ID value. This API requires setting permissions in your LoginRadius Dashboard.<br><br> <b>Note:</b> To utilize this API you need to find the ID for the post you want to track, which might require using Trackable Status Posting API first.
   // </summary>
   // <param name="postId">Post ID value</param>
   // <returns>Response containing Definition of Complete Status Update data</returns>
   // 37.8	    
		
		
   public void trackableStatusFetching(String postId, final AsyncHandler<StatusUpdateStats> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(postId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("postId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("postId", postId);
      queryParameters.put("secret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "api/v2/status/trackable";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<StatusUpdateStats> typeToken = new TypeToken<StatusUpdateStats>() {};
          StatusUpdateStats successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The User Profile API is used to get social profile data from the user’s social account after authentication.<br><br><b>Supported Providers:</b>  All
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete UserProfile data</returns>
   // 38.1	    
		
		
   public void getSocialUserProfile(String accessToken, String fields, final AsyncHandler<UserProfile> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "api/v2/userprofile";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   
   // <summary>
   // The User Profile API is used to get the latest updated social profile data from the user’s social account after authentication. The social profile will be retrieved via oAuth and OpenID protocols. The data is normalized into LoginRadius’ standard data format. This API should be called using the access token retrieved from the refresh access token API.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="fields">The fields parameter filters the API response so that the response only includes a specific set of fields</param>
   // <returns>Response containing Definition for Complete UserProfile data</returns>
   // 38.2	    
		
		
   public void getRefreshedSocialUserProfile(String accessToken, String fields, final AsyncHandler<UserProfile> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(fields)) {
        queryParameters.put("fields", fields);
      }

      String resourcePath = "api/v2/userprofile/refresh";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
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
   
   // <summary>
   // The Video API is used to get video files data from the user’s social account.<br><br><b>Supported Providers:</b>   Facebook, Google, Live, Vkontakte
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="nextCursor">Cursor value if not all contacts can be retrieved once.</param>
   // <returns>Response containing Definition of Video Data with Cursor</returns>
   // 39.2	    
		
		
   public void getVideos(String accessToken, String nextCursor, final AsyncHandler<CursorResponse<Video>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(nextCursor)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("nextCursor"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("nextCursor", nextCursor);

      String resourcePath = "api/v2/video";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<CursorResponse<Video>> typeToken = new TypeToken<CursorResponse<Video>>() {};
          CursorResponse<Video> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
