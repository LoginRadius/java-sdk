/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
*/

package com.loginradius.sdk.api.account;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.requestmodels.AccountRoleContextModel;
import com.loginradius.sdk.models.requestmodels.PermissionsModel;
import com.loginradius.sdk.models.requestmodels.RoleContextAdditionalPermissionRemoveRoleModel;
import com.loginradius.sdk.models.requestmodels.RoleContextRemoveRoleModel;
import com.loginradius.sdk.models.requestmodels.RolesModel;
import com.loginradius.sdk.models.responsemodels.ListData;
import com.loginradius.sdk.models.responsemodels.ListReturn;
import com.loginradius.sdk.models.responsemodels.otherobjects.DeleteResponse;
import com.loginradius.sdk.models.responsemodels.otherobjects.RoleContextResponseModel;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.RoleContext;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class RoleApi {
   private static Gson gson =new Gson();

   public RoleApi(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // API is used to retrieve all the assigned roles of a particular User.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Complete Roles data</returns>
   // 18.6	    
		
		
   public void getRolesByUid(String uid, final AsyncHandler<com.loginradius.sdk.models.responsemodels.otherobjects.AccountRolesModel> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/role";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.AccountRolesModel> typeToken = new TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.AccountRolesModel>() {};
          com.loginradius.sdk.models.responsemodels.otherobjects.AccountRolesModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to assign your desired roles to a given user.
   // </summary>
   // <param name="accountRolesModel">Model Class containing Definition of payload for Create Role API</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Complete Roles data</returns>
   // 18.7	    
		
		
   public void assignRolesByUid(com.loginradius.sdk.models.requestmodels.AccountRolesModel accountRolesModel, String uid, final AsyncHandler<com.loginradius.sdk.models.responsemodels.otherobjects.AccountRolesModel> handler) {

      if (accountRolesModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accountRolesModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/role";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(accountRolesModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.AccountRolesModel> typeToken = new TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.AccountRolesModel>() {};
          com.loginradius.sdk.models.responsemodels.otherobjects.AccountRolesModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to unassign roles from a user.
   // </summary>
   // <param name="accountRolesModel">Model Class containing Definition of payload for Create Role API</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.8	    
		
		
   public void unassignRolesByUid(com.loginradius.sdk.models.requestmodels.AccountRolesModel accountRolesModel, String uid, final AsyncHandler<DeleteResponse> handler) {

      if (accountRolesModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accountRolesModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/role";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(accountRolesModel), new AsyncHandler<String>() {
			
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
   // This API Gets the contexts that have been configured and the associated roles and permissions.
   // </summary>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Complete user RoleContext data</returns>
   // 18.9	    
		
		
   public void getRoleContextByUid(String uid, final AsyncHandler<ListReturn<RoleContext>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/rolecontext";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListReturn<RoleContext>> typeToken = new TypeToken<ListReturn<RoleContext>>() {};
          ListReturn<RoleContext> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The API is used to retrieve role context by the context name.
   // </summary>
   // <param name="contextName">Name of context</param>
   // <returns>Complete user RoleContext data</returns>
   // 18.10	    
		
		
   public void getRoleContextByContextName(String contextName, final AsyncHandler<ListReturn<RoleContextResponseModel>> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(contextName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("contextName"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/rolecontext/" + contextName;
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListReturn<RoleContextResponseModel>> typeToken = new TypeToken<ListReturn<RoleContextResponseModel>>() {};
          ListReturn<RoleContextResponseModel> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API creates a Context with a set of Roles
   // </summary>
   // <param name="accountRoleContextModel">Model Class containing Definition of RoleContext payload</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Complete user RoleContext data</returns>
   // 18.11	    
		
		
   public void updateRoleContextByUid(AccountRoleContextModel accountRoleContextModel, String uid, final AsyncHandler<ListReturn<RoleContext>> handler) {

      if (accountRoleContextModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("accountRoleContextModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/rolecontext";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(accountRoleContextModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListReturn<RoleContext>> typeToken = new TypeToken<ListReturn<RoleContext>>() {};
          ListReturn<RoleContext> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API Deletes the specified Role Context
   // </summary>
   // <param name="contextName">Name of context</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.12	    
		
		
   public void deleteRoleContextByUid(String contextName, String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(contextName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("contextName"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/rolecontext/" + contextName;
            
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
   // This API Deletes the specified Role from a Context.
   // </summary>
   // <param name="contextName">Name of context</param>
   // <param name="roleContextRemoveRoleModel">Model Class containing Definition of payload for RoleContextRemoveRole API</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.13	    
		
		
   public void deleteRolesFromRoleContextByUid(String contextName, RoleContextRemoveRoleModel roleContextRemoveRoleModel,
      String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(contextName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("contextName"));
      }

      if (roleContextRemoveRoleModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("roleContextRemoveRoleModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/rolecontext/" + contextName + "/role";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(roleContextRemoveRoleModel), new AsyncHandler<String>() {
			
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
   // This API Deletes Additional Permissions from Context.
   // </summary>
   // <param name="contextName">Name of context</param>
   // <param name="roleContextAdditionalPermissionRemoveRoleModel">Model Class containing Definition of payload for RoleContextAdditionalPermissionRemoveRole API</param>
   // <param name="uid">UID, the unified identifier for each user account</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 18.14	    
		
		
   public void deleteAdditionalPermissionFromRoleContextByUid(String contextName, RoleContextAdditionalPermissionRemoveRoleModel roleContextAdditionalPermissionRemoveRoleModel,
      String uid, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(contextName)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("contextName"));
      }

      if (roleContextAdditionalPermissionRemoveRoleModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("roleContextAdditionalPermissionRemoveRoleModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(uid)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("uid"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/account/" + uid + "/rolecontext/" + contextName + "/additionalpermission";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(roleContextAdditionalPermissionRemoveRoleModel), new AsyncHandler<String>() {
			
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
   // This API retrieves the complete list of created roles with permissions of your app.
   // </summary>
   // <returns>Complete user Roles List data</returns>
   // 41.1	    
		
		
   public void getRolesList(final AsyncHandler<ListData<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel>> handler) {
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/role";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListData<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel>> typeToken = new TypeToken<ListData<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel>>() {};
          ListData<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API creates a role with permissions.
   // </summary>
   // <param name="rolesModel">Model Class containing Definition of payload for Roles API</param>
   // <returns>Complete user Roles data</returns>
   // 41.2	    
		
		
   public void createRoles(RolesModel rolesModel, final AsyncHandler<ListData<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel>> handler) {

      if (rolesModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("rolesModel"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/role";
            
      LoginRadiusRequest.execute("POST", resourcePath, queryParameters, gson.toJson(rolesModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<ListData<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel>> typeToken = new TypeToken<ListData<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel>>() {};
          ListData<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel> successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to delete the role.
   // </summary>
   // <param name="role">Created RoleName</param>
   // <returns>Response containing Definition of Delete Request</returns>
   // 41.3	    
		
		
   public void deleteRole(String role, final AsyncHandler<DeleteResponse> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(role)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("role"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/role/" + role;
            
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
   // This API is used to add permissions to a given role.
   // </summary>
   // <param name="permissionsModel">Model Class containing Definition for PermissionsModel Property</param>
   // <param name="role">Created RoleName</param>
   // <returns>Response containing Definition of Complete role data</returns>
   // 41.4	    
		
		
   public void addRolePermissions(PermissionsModel permissionsModel, String role, final AsyncHandler<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel> handler) {

      if (permissionsModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("permissionsModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(role)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("role"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/role/" + role + "/permission";
            
      LoginRadiusRequest.execute("PUT", resourcePath, queryParameters, gson.toJson(permissionsModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel> typeToken = new TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel>() {};
          com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // API is used to remove permissions from a role.
   // </summary>
   // <param name="permissionsModel">Model Class containing Definition for PermissionsModel Property</param>
   // <param name="role">Created RoleName</param>
   // <returns>Response containing Definition of Complete role data</returns>
   // 41.5	    
		
		
   public void removeRolePermissions(PermissionsModel permissionsModel, String role, final AsyncHandler<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel> handler) {

      if (permissionsModel == null) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("permissionsModel"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(role)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("role"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("apiSecret", LoginRadiusSDK.getApiSecret());

      String resourcePath = "identity/v2/manage/role/" + role + "/permission";
            
      LoginRadiusRequest.execute("DELETE", resourcePath, queryParameters, gson.toJson(permissionsModel), new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel> typeToken = new TypeToken<com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel>() {};
          com.loginradius.sdk.models.responsemodels.otherobjects.RoleModel successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
