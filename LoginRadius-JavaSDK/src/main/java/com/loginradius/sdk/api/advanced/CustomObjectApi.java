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
import com.loginradius.sdk.models.enums.CustomObjectUpdateOperationType;
import com.loginradius.sdk.models.responsemodels.ListData;
import com.loginradius.sdk.models.responsemodels.UserCustomObjectData;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class CustomObjectApi {
   private static Gson gson =new Gson();

   public CustomObjectApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API is used to write information in JSON format to the custom object for the specified account.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <param name="payload">LoginRadius Custom Object Name</param>
   // <returns>Response containing Definition for Complete user custom object data</returns>
   // 6.1	    
		
		
   public void createCustomObjectByToken(String accessToken, String objectName,
      JsonObject payload, final AsyncHandler<UserCustomObjectData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }

      if (payload == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("payload"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("objectName", objectName);

      String resourcePath = "identity/v2/auth/customobject";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(payload), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserCustomObjectData> typeToken = new TypeToken<UserCustomObjectData>() {};
          UserCustomObjectData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to update the specified custom object data of the specified account. If the value of updatetype is 'replace' then it will fully replace custom object with the new custom object and if the value of updatetype is 'partialreplace' then it will perform an upsert type operation
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <param name="objectRecordId">Unique identifier of the user's record in Custom Object</param>
   // <param name="payload">LoginRadius Custom Object Name</param>
   // <param name="updateType">Possible values: replace, partialreplace.</param>
   // <returns>Response containing Definition for Complete user custom object data</returns>
   // 6.2	    
		
		
   public void updateCustomObjectByToken(String accessToken, String objectName,
      String objectRecordId, JsonObject payload, CustomObjectUpdateOperationType updateType, final AsyncHandler<UserCustomObjectData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectRecordId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectRecordId"));
      }

      if (payload == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("payload"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("objectName", objectName);

      if (updateType != null) {
        queryParameters.put("updateType", String.valueOf(updateType));
      }

      String resourcePath = "identity/v2/auth/customobject/" + objectRecordId;
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(payload), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserCustomObjectData> typeToken = new TypeToken<UserCustomObjectData>() {};
          UserCustomObjectData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve the specified Custom Object data for the specified account.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <returns>Complete user CustomObject data</returns>
   // 6.3	    
		
		
   public void getCustomObjectByToken(String accessToken, String objectName, final AsyncHandler<ListData<UserCustomObjectData>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("objectName", objectName);

      String resourcePath = "identity/v2/auth/customobject";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListData<UserCustomObjectData>> typeToken = new TypeToken<ListData<UserCustomObjectData>>() {};
          ListData<UserCustomObjectData> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve the Custom Object data for the specified account.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <param name="objectRecordId">Unique identifier of the user's record in Custom Object</param>
   // <returns>Response containing Definition for Complete user custom object data</returns>
   // 6.4	    
		
		
   public void getCustomObjectByRecordIDAndToken(String accessToken, String objectName,
      String objectRecordId, final AsyncHandler<UserCustomObjectData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectRecordId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectRecordId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("objectName", objectName);

      String resourcePath = "identity/v2/auth/customobject/" + objectRecordId;
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserCustomObjectData> typeToken = new TypeToken<UserCustomObjectData>() {};
          UserCustomObjectData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to remove the specified Custom Object data using ObjectRecordId of a specified account.
   // </summary>
   // <param name="accessToken">Uniquely generated identifier key by LoginRadius that is activated after successful authentication.</param>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <param name="objectRecordId">Unique identifier of the user's record in Custom Object</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 6.5	    
		
		
   public void deleteCustomObjectByToken(String accessToken, String objectName,
      String objectRecordId, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(accessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectRecordId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectRecordId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("access_token", accessToken);
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("objectName", objectName);

      String resourcePath = "identity/v2/auth/customobject/" + objectRecordId;
            
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
   // This API is used to write information in JSON format to the custom object for the specified account.
   // </summary>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <param name="payload">LoginRadius Custom Object Name</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition for Complete user custom object data</returns>
   // 19.1	    
		
		
   public void createCustomObjectByUid(String objectName, JsonObject payload,
      String uid, final AsyncHandler<UserCustomObjectData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }

      if (payload == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("payload"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("objectName", objectName);

      String resourcePath = "identity/v2/manage/account/" + uid + "/customobject";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(payload), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserCustomObjectData> typeToken = new TypeToken<UserCustomObjectData>() {};
          UserCustomObjectData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to update the specified custom object data of a specified account. If the value of updatetype is 'replace' then it will fully replace custom object with new custom object and if the value of updatetype is partialreplace then it will perform an upsert type operation.
   // </summary>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <param name="objectRecordId">Unique identifier of the user's record in Custom Object</param>
   // <param name="payload">LoginRadius Custom Object Name</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <param name="updateType">Possible values: replace, partialreplace.</param>
   // <returns>Response containing Definition for Complete user custom object data</returns>
   // 19.2	    
		
		
   public void updateCustomObjectByUid(String objectName, String objectRecordId,
      JsonObject payload, String uid, CustomObjectUpdateOperationType updateType, final AsyncHandler<UserCustomObjectData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectRecordId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectRecordId"));
      }

      if (payload == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("payload"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("objectName", objectName);

      if (updateType != null) {
        queryParameters.put("updateType", String.valueOf(updateType));
      }

      String resourcePath = "identity/v2/manage/account/" + uid + "/customobject/" + objectRecordId;
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(payload), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserCustomObjectData> typeToken = new TypeToken<UserCustomObjectData>() {};
          UserCustomObjectData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve all the custom objects by UID from cloud storage.
   // </summary>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Complete user CustomObject data</returns>
   // 19.3	    
		
		
   public void getCustomObjectByUid(String objectName, String uid, final AsyncHandler<ListData<UserCustomObjectData>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("objectName", objectName);

      String resourcePath = "identity/v2/manage/account/" + uid + "/customobject";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListData<UserCustomObjectData>> typeToken = new TypeToken<ListData<UserCustomObjectData>>() {};
          ListData<UserCustomObjectData> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve the Custom Object data for the specified account.
   // </summary>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <param name="objectRecordId">Unique identifier of the user's record in Custom Object</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition for Complete user custom object data</returns>
   // 19.4	    
		
		
   public void getCustomObjectByRecordID(String objectName, String objectRecordId,
      String uid, final AsyncHandler<UserCustomObjectData> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectRecordId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectRecordId"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("objectName", objectName);

      String resourcePath = "identity/v2/manage/account/" + uid + "/customobject/" + objectRecordId;
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserCustomObjectData> typeToken = new TypeToken<UserCustomObjectData>() {};
          UserCustomObjectData successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to remove the specified Custom Object data using ObjectRecordId of specified account.
   // </summary>
   // <param name="objectName">LoginRadius Custom Object Name</param>
   // <param name="objectRecordId">Unique identifier of the user's record in Custom Object</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 19.5	    
		
		
   public void deleteCustomObjectByRecordID(String objectName, String objectRecordId,
      String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectName"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(objectRecordId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("objectRecordId"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());
      queryParameters.put("objectName", objectName);

      String resourcePath = "identity/v2/manage/account/" + uid + "/customobject/" + objectRecordId;
            
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
}
