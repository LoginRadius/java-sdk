/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.advanced;

import com.loginradius.sdk.helper.*;
import com.loginradius.sdk.util.*;
import com.google.gson.Gson;
import java.util.Iterator;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import com.loginradius.sdk.models.responsemodels.otherobjects.*;
import com.loginradius.sdk.models.requestmodels.*;
import com.loginradius.sdk.models.responsemodels.*;


public class WebHookApi {
   private static Gson gson =new Gson();

   public WebHookApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API is used to get details of a webhook subscription by Id
   // </summary>
   // <param name="hookId">Unique ID of the webhook</param>
   // <returns>Response containing Definition for Complete WebHook data</returns>
   // 40.1	    
		
		
   public void getWebhookSubscriptionDetail(String hookId, final AsyncHandler<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(hookId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("hookId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "v2/manage/webhooks/" + hookId;
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel> typeToken = new TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel>() {};
          com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to create a new webhook subscription on your LoginRadius site.
   // </summary>
   // <param name="webHookSubscribeModel">Model Class containing Definition of payload for Webhook Subscribe API</param>
   // <returns>Response containing Definition for Complete WebHook data</returns>
   // 40.2	    
		
		
   public void createWebhookSubscription(com.loginradius.sdk.models.requestmodels.WebHookSubscribeModel webHookSubscribeModel, final AsyncHandler<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel> handler) {

      if (webHookSubscribeModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("webHookSubscribeModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "v2/manage/webhooks";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(webHookSubscribeModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel> typeToken = new TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel>() {};
          com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to delete webhook subscription
   // </summary>
   // <param name="hookId">Unique ID of the webhook</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 40.3	    
		
		
   public void deleteWebhookSubscription(String hookId, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(hookId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("hookId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "v2/manage/webhooks/" + hookId;
            
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
   // This API is used to update a webhook subscription
   // </summary>
   // <param name="hookId">Unique ID of the webhook</param>
   // <param name="webHookSubscriptionUpdateModel">Model Class containing Definition for WebHookSubscriptionUpdateModel Property</param>
   // <returns>Response containing Definition for Complete WebHook data</returns>
   // 40.4	    
		
		
   public void updateWebhookSubscription(String hookId, WebHookSubscriptionUpdateModel webHookSubscriptionUpdateModel, final AsyncHandler<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(hookId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("hookId"));
      }

      if (webHookSubscriptionUpdateModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("webHookSubscriptionUpdateModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "v2/manage/webhooks/" + hookId;
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(webHookSubscriptionUpdateModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel> typeToken = new TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel>() {};
          com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to get the list of all the webhooks
   // </summary>
   // <returns>Response Containing List of Webhhook Data</returns>
   // 40.5	    
		
		
   public void listAllWebhooks(final AsyncHandler<ListReturn<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel>> handler) {
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "v2/manage/webhooks";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListReturn<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel>> typeToken = new TypeToken<ListReturn<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel>>() {};
          ListReturn<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve all the webhook events.
   // </summary>
   // <returns>Model Class containing Definition for WebHookEventModel Property</returns>
   // 40.6	    
		
		
   public void getWebhookEvents(final AsyncHandler<WebHookEventModel> handler) {
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "v2/manage/webhooks/events";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<WebHookEventModel> typeToken = new TypeToken<WebHookEventModel>() {};
          WebHookEventModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
