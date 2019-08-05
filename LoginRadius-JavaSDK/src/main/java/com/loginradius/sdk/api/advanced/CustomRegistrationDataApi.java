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
import com.loginradius.sdk.models.requestmodels.RegistrationDataCreateModelList;
import com.loginradius.sdk.models.requestmodels.RegistrationDataUpdateModel;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.PostValidationResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.RegistrationDataField;
import com.loginradius.sdk.models.responsemodels.otherobjects.UserProfilePostResponse;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class CustomRegistrationDataApi {
   private static Gson gson =new Gson();

   public CustomRegistrationDataApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // This API is used to retrieve dropdown data.
   // </summary>
   // <param name="type">Type of the Datasource</param>
   // <param name="limit">Retrieve number of records at a time(max limit is 50)</param>
   // <param name="parentId">Id of parent dropdown member(if any).</param>
   // <param name="skip">Skip number of records from start</param>
   // <returns>Complete user Registration data</returns>
   // 7.1	    
		
		
   public void authGetRegistrationData(String type, Integer limit,
      String parentId, Integer skip, final AsyncHandler<RegistrationDataField[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(type)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("type"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      if (limit != null) {
        queryParameters.put("limit", String.valueOf(limit));
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(parentId)) {
        queryParameters.put("parentId", parentId);
      }

      if (skip != null) {
        queryParameters.put("skip", String.valueOf(skip));
      }

      String resourcePath = "identity/v2/auth/registrationdata/" + type;
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<RegistrationDataField[]> typeToken = new TypeToken<RegistrationDataField[]>() {};
          RegistrationDataField[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API allows you to validate code for a particular dropdown member.
   // </summary>
   // <param name="code">Secret Code</param>
   // <param name="recordId">Selected dropdown item’s record id</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 7.2	    
		
		
   public void validateRegistrationDataCode(String code, String recordId, final AsyncHandler<PostValidationResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(code)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("code"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(recordId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("recordId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());

      JsonObject bodyParameters = new JsonObject();
      bodyParameters.addProperty("code", code);
      bodyParameters.addProperty("recordId", recordId);

      String resourcePath = "identity/v2/auth/registrationdata/validatecode";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(bodyParameters), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<PostValidationResponse> typeToken = new TypeToken<PostValidationResponse>() {};
          PostValidationResponse successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to retrieve dropdown data.
   // </summary>
   // <param name="type">Type of the Datasource</param>
   // <param name="limit">Retrive number of records at a time(max limit is 50</param>
   // <param name="parentId">Id of parent dropdown member(if any).</param>
   // <param name="skip">Skip number of records from start</param>
   // <returns>Complete user Registration data Fields</returns>
   // 16.1	    
		
		
   public void getRegistrationData(String type, Integer limit,
      String parentId, Integer skip, final AsyncHandler<RegistrationDataField[]> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(type)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("type"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      if (limit != null) {
        queryParameters.put("limit", String.valueOf(limit));
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(parentId)) {
        queryParameters.put("parentId", parentId);
      }

      if (skip != null) {
        queryParameters.put("skip", String.valueOf(skip));
      }

      String resourcePath = "identity/v2/manage/registrationdata/" + type;
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<RegistrationDataField[]> typeToken = new TypeToken<RegistrationDataField[]>() {};
          RegistrationDataField[] successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API allows you to fill data into a dropdown list which you have created for user Registeration. For more details on how to use this API please see our Custom Registration Data Overview
   // </summary>
   // <param name="registrationDataCreateModelList">Model Class containing Definition of List of Registration Data</param>
   // <returns>Response containing Definition of Complete Validation data</returns>
   // 16.2	    
		
		
   public void addRegistrationData(RegistrationDataCreateModelList registrationDataCreateModelList, final AsyncHandler<PostResponse> handler) {

      if (registrationDataCreateModelList == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("registrationDataCreateModelList"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/registrationdata";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(registrationDataCreateModelList), new AsyncHandler<String>() {
			
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
   // This API allows you to update a dropdown item
   // </summary>
   // <param name="registrationDataUpdateModel">Model Class containing Definition of payload for Registration Data update API</param>
   // <param name="recordId">Registration data RecordId</param>
   // <returns>Complete user Registration data Field</returns>
   // 16.3	    
		
		
   public void updateRegistrationData(RegistrationDataUpdateModel registrationDataUpdateModel, String recordId, final AsyncHandler<UserProfilePostResponse<RegistrationDataField>> handler) {

      if (registrationDataUpdateModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("registrationDataUpdateModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(recordId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("recordId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/registrationdata/" + recordId;
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(registrationDataUpdateModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<UserProfilePostResponse<RegistrationDataField>> typeToken = new TypeToken<UserProfilePostResponse<RegistrationDataField>>() {};
          UserProfilePostResponse<RegistrationDataField> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API allows you to delete an item from a dropdown list.
   // </summary>
   // <param name="recordId">Registration data RecordId</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 16.4	    
		
		
   public void deleteRegistrationData(String recordId, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(recordId)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("recordId"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/registrationdata/" + recordId;
            
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
   // This API allows you to delete all records contained in a datasource.
   // </summary>
   // <param name="type">Type of the Datasource</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 16.5	    
		
		
   public void deleteAllRecordsByDataSource(String type, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(type)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("type"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/registrationdata/type/" + type;
            
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
