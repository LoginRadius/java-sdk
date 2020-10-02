/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
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

   
   
   /**
    * API is used to retrieve all the assigned roles of a particular User.
    * @param uid UID, the unified identifier for each user account
    * @return Response containing Definition of Complete Roles data
    * @since 18.6
    */
		
		
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
   
   /**
    * This API is used to assign your desired roles to a given user.
    * @param accountRolesModel Model Class containing Definition of payload for Create Role API
    * @param uid UID, the unified identifier for each user account
    * @return Response containing Definition of Complete Roles data
    * @since 18.7
    */
		
		
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
   
   /**
    * This API is used to unassign roles from a user.
    * @param accountRolesModel Model Class containing Definition of payload for Create Role API
    * @param uid UID, the unified identifier for each user account
    * @return Response containing Definition of Delete Request
    * @since 18.8
    */
		
		
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
   
   /**
    * This API Gets the contexts that have been configured and the associated roles and permissions.
    * @param uid UID, the unified identifier for each user account
    * @return Complete user RoleContext data
    * @since 18.9
    */
		
		
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
   
   /**
    * The API is used to retrieve role context by the context name.
    * @param contextName Name of context
    * @return Complete user RoleContext data
    * @since 18.10
    */
		
		
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
   
   /**
    * This API creates a Context with a set of Roles
    * @param accountRoleContextModel Model Class containing Definition of RoleContext payload
    * @param uid UID, the unified identifier for each user account
    * @return Complete user RoleContext data
    * @since 18.11
    */
		
		
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
   
   /**
    * This API Deletes the specified Role Context
    * @param contextName Name of context
    * @param uid UID, the unified identifier for each user account
    * @return Response containing Definition of Delete Request
    * @since 18.12
    */
		
		
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
   
   /**
    * This API Deletes the specified Role from a Context.
    * @param contextName Name of context
    * @param roleContextRemoveRoleModel Model Class containing Definition of payload for RoleContextRemoveRole API
    * @param uid UID, the unified identifier for each user account
    * @return Response containing Definition of Delete Request
    * @since 18.13
    */
		
		
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
   
   /**
    * This API Deletes Additional Permissions from Context.
    * @param contextName Name of context
    * @param roleContextAdditionalPermissionRemoveRoleModel Model Class containing Definition of payload for RoleContextAdditionalPermissionRemoveRole API
    * @param uid UID, the unified identifier for each user account
    * @return Response containing Definition of Delete Request
    * @since 18.14
    */
		
		
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
   
   /**
    * This API retrieves the complete list of created roles with permissions of your app.
    * @return Complete user Roles List data
    * @since 41.1
    */
		
		
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
   
   /**
    * This API creates a role with permissions.
    * @param rolesModel Model Class containing Definition of payload for Roles API
    * @return Complete user Roles data
    * @since 41.2
    */
		
		
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
   
   /**
    * This API is used to delete the role.
    * @param role Created RoleName
    * @return Response containing Definition of Delete Request
    * @since 41.3
    */
		
		
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
   
   /**
    * This API is used to add permissions to a given role.
    * @param permissionsModel Model Class containing Definition for PermissionsModel Property
    * @param role Created RoleName
    * @return Response containing Definition of Complete role data
    * @since 41.4
    */
		
		
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
   
   /**
    * API is used to remove permissions from a role.
    * @param permissionsModel Model Class containing Definition for PermissionsModel Property
    * @param role Created RoleName
    * @return Response containing Definition of Complete role data
    * @since 41.5
    */
		
		
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
