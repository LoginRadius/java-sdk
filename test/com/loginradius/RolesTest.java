package com.loginradius;

import org.junit.*;

import com.loginradius.sdk.management.api.*;
import com.loginradius.sdk.models.register.*;
import com.loginradius.sdk.models.role.*;
import com.loginradius.sdk.models.rolecontext.*;
import com.loginradius.sdk.util.*;
import com.loginradius.sdk.resource.*;

import com.google.gson.*;
import java.util.HashMap;
import java.util.Map;

public class RolesTest {

    private static LoginRadiusClient client;
    private static Helper helper;
    private static String roleName = "lr-javasdk-role";
    private static String permissionName = "lr-javasdk-permission";
    private static String contextName = "lr-javasdk-context";

    @BeforeClass
    public static void setUpClass() {
        System.out.println("~~~~RolesTest::setUpClass~~~~");

        Assume.assumeFalse("Test ignored::IS_MFA_ENABLED set to true", TestConstant.IS_MFA_ENABLED.equals(true));
        LoginRadiusSDK.Initialize init = new LoginRadiusSDK.Initialize();
        init.setApiKey(TestConstant.API_KEY);
        init.setApiSecret(TestConstant.API_SECRET);
        client = new LoginRadiusClient();
        helper = new Helper(client);
    }

    // Roles Create (POST)
    @Test
    public void test_post_create() {
        try {
            JsonObject jsonObj = new JsonObject();
            jsonObj.addProperty("UpdateUser", "true");
            jsonObj.addProperty("DeleteUser", "true");
            JsonObject registerdata = new JsonObject();
            JsonArray registerarray = new JsonArray();
            JsonObject arraysets = new JsonObject();
            arraysets.addProperty("Name", roleName);
            arraysets.add("Permissions", jsonObj);
            registerarray.add(arraysets);
            registerdata.add("Roles", registerarray);
            LRManagementAPI api = new ManagementPostAPI(LoginRadiusConstant.CREATEROLE, null, registerdata);
            LoginRadiusRoleResponse res = client.getResponse(api, LoginRadiusRoleResponse.class);
            helper.deleteRole(roleName);

            Assert.assertNotNull(res.getCount());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Get Context with Roles and Permissions (GET)
    @Test
    public void test_get_context() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.GET_ROLECONTEXT,params);
            RoleContextResponse res = client.getResponse(api,RoleContextResponse.class);

            Assert.assertNotNull(res.getData());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Roles List (GET)
    @Test
    public void test_get_rolesList() {
        try {
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.GET_ROLE, null);
            LoginRadiusRoleResponse res = client.getResponse(api, LoginRadiusRoleResponse.class);

            Assert.assertNotNull(res.getData());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Roles by UID (GET)
    @Test
    public void test_get_rolesByUid() {
        RegistrationData account = null;
        try {
            account = helper.createAccount(true, false);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            LRManagementAPI api = new ManagementGetAPI(LoginRadiusConstant.GET_ROLES_BYUID, params);
            AssignRoles res = client.getResponse(api, AssignRoles.class);

            Assert.assertNotNull(res.getRoles());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
        }
    }

    // Add Permissions to Role (PUT)
    @Test
    public void test_put_addPermissionsToRole() {
        LoginRadiusRoleResponse role = null;
        try {
            role = helper.createRole(roleName, permissionName);

            Map<String, String> params = new HashMap<String,String>();
            params.put("role", roleName);
            JsonObject json = new JsonObject();
            JsonArray array = new JsonArray();
            array.add(new JsonPrimitive("EditUser"));
            array.add(new JsonPrimitive("DeleteUser"));
            json.add("permissions", array);
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.ADD_PERMISSIONS_TOROLE, params, json);
            AddRolePermissions res = client.getResponse(api, AddRolePermissions.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (role != null) {
                helper.deleteRole(roleName);
            }
        }
    }

    // Assign Roles by UID (PUT)
    @Test
    public void test_put_assignRolesByUid() {
        RegistrationData account = null;
        LoginRadiusRoleResponse role = null;
        try {
            account = helper.createAccount(true, false);
            role = helper.createRole(roleName, permissionName);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            JsonObject json = new JsonObject();
            JsonArray array = new JsonArray();
            array.add(new JsonPrimitive(roleName));
            json.add("roles", array);
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.ASSIGNROLES, params, json);
            AssignRoles res = client.getResponse(api, AssignRoles.class);

            Assert.assertNotNull(res.getRoles());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
            if (role != null) {
                helper.deleteRole(roleName);
            }
        }
    }

    // Upsert Context (PUT)
    @Test
    public void test_put_context() {
        RegistrationData account = null;
        LoginRadiusRoleResponse role = null;
        try {
            account = helper.createAccount(true, false);
            role = helper.createRole(roleName, permissionName);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            JsonObject json = new JsonObject();
            JsonArray registerarray = new JsonArray();
            JsonObject arraysets = new JsonObject();
            arraysets.addProperty("context", contextName);

            JsonArray array = new JsonArray();
            array.add(new JsonPrimitive(roleName));
            arraysets.add("roles",array);

            JsonArray arraypermission = new JsonArray();
            arraypermission.add(new JsonPrimitive("temp"));
            arraysets.add("additionalpermissions",arraypermission);

            registerarray.add(arraysets);
            json.add("rolecontext",registerarray);
            LRManagementAPI api = new ManagementPutAPI(LoginRadiusConstant.ADD_ROLECONTEXT, params, json);
            RoleContextResponse res = client.getResponse(api,RoleContextResponse.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
            if (role != null) {
                helper.deleteRole(roleName);
            }
        }
    }

    // Delete Role (DEL)
    @Test
    public void test_del_role() {
        try {
            helper.createRole(roleName, permissionName);

            Map<String, String> params = new HashMap<String,String>();
            params.put("role", roleName);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_ROLE, params, null);
            DeleteResponse res = client.getResponse(api, DeleteResponse.class);

            Assert.assertTrue(res.getIsDeleted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    // Unassign Roles by UID (DEL)
    @Test
    public void test_del_unassignRolesByUid() {
        RegistrationData account = null;
        LoginRadiusRoleResponse role = null;
        try {
            account = helper.createAccount(true, false);
            role = helper.createRole(roleName, permissionName);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            JsonObject json = new JsonObject();
            JsonArray array = new JsonArray();
            array.add(new JsonPrimitive(roleName));
            json.add("roles", array);

            LRManagementAPI assign = new ManagementPutAPI(LoginRadiusConstant.ASSIGNROLES, params, json);
            assign.getResponse("");

            LRManagementAPI unassign = new ManagementDeleteAPI(LoginRadiusConstant.UNASSIGN_ROLES_BY_UID, params, json);
            DeleteResponse res = client.getResponse(unassign, DeleteResponse.class);

            Assert.assertTrue(res.getIsDeleted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
            if (role != null) {
                helper.deleteRole(roleName);
            }
        }
    }

    // Remove Permissions (DEL)
    @Test
    public void test_del_permissions() {
        LoginRadiusRoleResponse role = null;
        try {
            role = helper.createRole(roleName, permissionName);

            Map<String, String> params = new HashMap<String,String>();
            params.put("role_name", roleName);
            JsonObject json = new JsonObject();
            JsonArray array = new JsonArray();
            array.add(new JsonPrimitive(permissionName));
            json.add("permissions", array);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.REMOVE_PERMISSIONS, params, json);
            AddRolePermissions res = client.getResponse(api, AddRolePermissions.class);

            Assert.assertNotNull(res);
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (role != null) {
                helper.deleteRole(roleName);
            }
        }
    }

    // Delete Role Context (DEL)
    @Test
    public void test_del_context() {
        RegistrationData account = null;
        LoginRadiusRoleResponse role = null;
        try {
            account = helper.createAccount(true, false);
            role = helper.createRole(roleName, permissionName);
            helper.setRoleContext(account.getUid().toString(), roleName, contextName, permissionName);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            params.put("rolecontextname", contextName);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_CONTEXT, params, null);
            DeleteResponse res = client.getResponse(api, DeleteResponse.class);

            Assert.assertTrue(res.getIsDeleted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
            if (role != null) {
                helper.deleteRole(roleName);
            }
        }
    }

    // Delete Role from Context (DEL)
    @Test
    public void test_del_roleFromContext() {
        RegistrationData account = null;
        LoginRadiusRoleResponse role = null;
        try {
            account = helper.createAccount(true, false);
            role = helper.createRole(roleName, permissionName);
            helper.setRoleContext(account.getUid().toString(), roleName, contextName, permissionName);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            params.put("rolecontextname", contextName);
            JsonObject json = new JsonObject();
            JsonArray array = new JsonArray();
            array.add(new JsonPrimitive(roleName));
            json.add("roles", array);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_ROLE_FROM_CONTEXT, params, json);
            DeleteResponse res = client.getResponse(api, DeleteResponse.class);

            Assert.assertTrue(res.getIsDeleted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
            if (role != null) {
                helper.deleteRole(roleName);
            }
        }
    }

    // Delete Additional Permission from Context (DEL)
    @Test
    public void test_del_permissionFromContext() {
        RegistrationData account = null;
        LoginRadiusRoleResponse role = null;
        try {
            account = helper.createAccount(true, false);
            role = helper.createRole(roleName, permissionName);
            helper.setRoleContext(account.getUid().toString(), roleName, contextName, permissionName);

            Map<String, String> params = new HashMap<String,String>();
            params.put("uid", account.getUid().toString());
            params.put("rolecontextname", contextName);
            JsonObject json = new JsonObject();
            JsonArray array = new JsonArray();
            array.add(new JsonPrimitive(permissionName));
            json.add("additionalpermissions", array);
            LRManagementAPI api = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_ROLE_AND_PERMISSION, params, json);
            DeleteResponse res = client.getResponse(api, DeleteResponse.class);

            Assert.assertTrue(res.getIsDeleted());
        } catch (LoginRadiusException e) {
            Assert.fail(e.getErrorResponse().getDescription());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            if (account != null) {
                helper.deleteAccount(account.getUid().toString());
            }
            if (role != null) {
                helper.deleteRole(roleName);
            }
        }
    }
}
