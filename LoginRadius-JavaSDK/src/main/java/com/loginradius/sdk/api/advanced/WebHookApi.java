/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.advanced;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.responsemodels.EntityPermissionAcknowledgement;
import com.loginradius.sdk.models.responsemodels.ListData;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class WebHookApi {
   private static Gson gson =new Gson();

   public WebHookApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API is used to fatch all the subscribed URLs, for particular event
   // </summary>
   // <param name="event">Allowed events: Login, Register, UpdateProfile, ResetPassword, ChangePassword, emailVerification, AddEmail, RemoveEmail, BlockAccount, DeleteAccount, SetUsername, AssignRoles, UnassignRoles, SetPassword, LinkAccount, UnlinkAccount, UpdatePhoneId, VerifyPhoneNumber, CreateCustomObject, UpdateCustomobject, DeleteCustomObject</param>
   // <returns>Response Containing List of Webhhook Data</returns>
   // 40.1	    
		
		
   public void getWebHookSubscribedURLs(String event, final AsyncHandler<ListData<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(event)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("event"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("event", event);

      String resourcePath = "api/v2/webhook";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListData<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel>> typeToken = new TypeToken<ListData<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel>>() {};
          ListData<com.loginradius.sdk.models.responsemodels.otherobjects.WebHookSubscribeModel> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // API can be used to configure a WebHook on your LoginRadius site. Webhooks also work on subscribe and notification model, subscribe your hook and get a notification. Equivalent to RESThook but these provide security on basis of signature and RESThook work on unique URL. Following are the events that are allowed by LoginRadius to trigger a WebHook service call.
   // </summary>
   // <param name="webHookSubscribeModel">Model Class containing Definition of payload for Webhook Subscribe API</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 40.2	    
		
		
   public void webHookSubscribe(com.loginradius.sdk.models.requestmodels.WebHookSubscribeModel webHookSubscribeModel, final AsyncHandler<PostResponse> handler) {

      if (webHookSubscribeModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("webHookSubscribeModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "api/v2/webhook";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(webHookSubscribeModel), new AsyncHandler<String>() {
			
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
   // API can be used to test a subscribed WebHook.
   // </summary>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 40.3	    
		
		
   public void webhookTest(final AsyncHandler<EntityPermissionAcknowledgement> handler) {
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "api/v2/webhook/test";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<EntityPermissionAcknowledgement> typeToken = new TypeToken<EntityPermissionAcknowledgement>() {};
          EntityPermissionAcknowledgement successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // API can be used to unsubscribe a WebHook configured on your LoginRadius site.
   // </summary>
   // <param name="webHookSubscribeModel">Model Class containing Definition of payload for Webhook Subscribe API</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 40.4	    
		
		
   public void webHookUnsubscribe(com.loginradius.sdk.models.requestmodels.WebHookSubscribeModel webHookSubscribeModel, final AsyncHandler<DeleteResponse> handler) {

      if (webHookSubscribeModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("webHookSubscribeModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apikey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apisecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "api/v2/webhook";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(webHookSubscribeModel), new AsyncHandler<String>() {
			
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
}
