package com.loginradius.demo

import org.scalatra._
import scalate.ScalateSupport

import com.loginradius.sdk.authentication.api._
import com.loginradius.sdk.management.api._
import com.loginradius.sdk.models.GetPasswordResponse
import com.loginradius.sdk.models.userprofile.LoginRadiusUltimateUserProfile
import com.loginradius.sdk.models.register.RegisterResponse
import com.loginradius.sdk.models.register.DeleteResponse
import com.loginradius.sdk.models.customobject.CreateCustomObject
import com.loginradius.sdk.models.customobject.ReadCustomObject
import com.loginradius.sdk.models.role.AssignRoles
import com.loginradius.sdk.models.role.LoginRadiusRoleResponse
import com.loginradius.sdk.resource.LoginRadiusException
import com.loginradius.sdk.resource.LoginRadiusClient
import com.loginradius.sdk.util.LoginRadiusConstant

import com.google.gson._
import scala.collection.JavaConverters._

class User(var client: LoginRadiusClient) extends ScalatraServlet with ScalateSupport {

	var gson: Gson = new Gson()

	get("/profile") {
		contentType="text/html"
		layoutTemplate("/WEB-INF/templates/views/profile.ssp")
	}

	post("/profile") {
		contentType="text/html"
		layoutTemplate("/WEB-INF/templates/views/profile.ssp")
	}

	get("/user") {
		try {
			client.setToken(params("token"));
			var api: LRAuthenticationAPI = new AuthenticationGetAPI(LoginRadiusConstant.READACCOUNT_BYTOKEN, null)
			var res: LoginRadiusUltimateUserProfile = client.getResponse(api, classOf[LoginRadiusUltimateUserProfile])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	put("/password/change") {
		try {
			var json: JsonObject = new JsonObject()
			json.add("oldpassword", new JsonPrimitive(params("oldpassword")))
			json.add("newpassword", new JsonPrimitive(params("newpassword")))
			var api: LRAuthenticationAPI = new AuthenticationPutAPI(LoginRadiusConstant.CHANGE_PASSWORD, null, json)
			var res: RegisterResponse = client.getResponse(api, classOf[RegisterResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	put("/password/set") {
		try {
			var map: java.util.Map[String,String] = Map("uid" -> params("uid")).asJava
			var json: JsonObject = new JsonObject()
			json.add("password", new JsonPrimitive(params("password")))
			var api: LRManagementAPI = new ManagementPutAPI(LoginRadiusConstant.SET_PASSWORD, map, json)
			var res: GetPasswordResponse = client.getResponse(api, classOf[GetPasswordResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	put("/account") {
		try {
			var map: java.util.Map[String,String] = Map("uid" -> params("uid")).asJava
			var json: JsonObject = new JsonObject()
			json.add("FirstName", new JsonPrimitive(params("firstname")))
			json.add("LastName", new JsonPrimitive(params("lastname")))
			json.add("About", new JsonPrimitive(params("about")))
			var api: LRManagementAPI = new ManagementPutAPI(LoginRadiusConstant.UPDATE_ACCOUNT, map, json)
			var res: LoginRadiusUltimateUserProfile = client.getResponse(api, classOf[LoginRadiusUltimateUserProfile])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	post("/customobject") {
		try {
			var map: java.util.Map[String,String] = Map("uid" -> params("uid"), "objectname" -> params("objectname")).asJava
			var json: JsonObject = new JsonParser().parse(request.body).getAsJsonObject();
			var api: LRManagementAPI = new ManagementPostAPI(LoginRadiusConstant.CREATE_CUSTOM_OBJECT, map, json)
			var res: CreateCustomObject = client.getResponse(api, classOf[CreateCustomObject])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	get("/customobject") {
		try {
			var map: java.util.Map[String,String] = Map("uid" -> params("uid"), "objectname" -> params("objectname")).asJava
			var api: LRManagementAPI = new ManagementGetAPI(LoginRadiusConstant.CUSTOMOBJECT_BYUID, map)
			var res: ReadCustomObject = client.getResponse(api, classOf[ReadCustomObject])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	put("/customobject") {
		try {
			var map: java.util.Map[String,String] = Map("uid" -> params("uid"), "objectname" -> params("objectname"), "objectrecordid" -> params("objectrecordid"), "updatetype" -> "replace").asJava
			var json: JsonObject = new JsonParser().parse(request.body).getAsJsonObject();
			var api: LRManagementAPI = new ManagementPutAPI(LoginRadiusConstant.UPDATE_OBJECT_BYRECORDID, map, json)
			var res: CreateCustomObject = client.getResponse(api, classOf[CreateCustomObject])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	delete("/customobject") {
		try {
			var map: java.util.Map[String,String] = Map("uid" -> params("uid"), "objectname" -> params("objectname"), "objectrecordid" -> params("objectrecordid")).asJava
			var api: LRManagementAPI = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_CUSTOMOBJECT_BYID, map, null)
			var res: DeleteResponse = client.getResponse(api, classOf[DeleteResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	delete("/mfa/reset") {
		try {
			var map: java.util.Map[String,String] = Map("uid" -> params("uid")).asJava
			var json: JsonObject = new JsonObject()
			json.add("googleauthenticator", new JsonPrimitive(true))
			var api: LRManagementAPI = new ManagementDeleteAPI(LoginRadiusConstant.MFA_RESET_AUTHENTICATOR_BYUID, map, json)
			var res: DeleteResponse = client.getResponse(api, classOf[DeleteResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	post("/role") {
		try {
			var jsonObj: JsonObject = new JsonObject()
			var registerdata: JsonObject = new JsonObject()
			var registerarray: JsonArray = new JsonArray()
			var arraysets: JsonObject = new JsonObject()
			arraysets.add("Name", new JsonPrimitive(params("role")))
			arraysets.add("Permissions", jsonObj)
			registerarray.add(arraysets)
			registerdata.add("Roles", registerarray)
			var api: LRManagementAPI = new ManagementPostAPI(LoginRadiusConstant.CREATEROLE, null, registerdata)
			var res: LoginRadiusRoleResponse = client.getResponse(api, classOf[LoginRadiusRoleResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	get("/role") {
		try {
			var api: LRManagementAPI = new ManagementGetAPI(LoginRadiusConstant.GET_ROLE, null)
			var res: LoginRadiusRoleResponse = client.getResponse(api, classOf[LoginRadiusRoleResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	delete("/role") {
		try {
			var map: java.util.Map[String,String] = Map("role" -> params("role")).asJava
			var api: LRManagementAPI = new ManagementDeleteAPI(LoginRadiusConstant.DELETE_ROLE, map, null)
			var res: DeleteResponse = client.getResponse(api, classOf[DeleteResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	get("/role/user") {
		try {
			var map: java.util.Map[String,String] = Map("uid" -> params("uid")).asJava
			var api: LRManagementAPI = new ManagementGetAPI(LoginRadiusConstant.GET_ROLES_BYUID, map)
			var res: AssignRoles = client.getResponse(api, classOf[AssignRoles])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	put("/role/user") {
		try {
			var map: java.util.Map[String,String] = Map("uid" -> params("uid")).asJava
			var json: JsonObject = new JsonObject()
			var array: JsonArray = new JsonArray()
			array.add(new JsonPrimitive(params("role")))
			json.add("roles", array)
			var api: LRManagementAPI = new ManagementPutAPI(LoginRadiusConstant.ASSIGNROLES, map, json)
			var res: DeleteResponse = client.getResponse(api, classOf[DeleteResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}

	get("/logout") {
		try {
			var map: java.util.Map[String,String] = Map("access_token" -> params("token")).asJava
			var api: LRAuthenticationAPI = new AuthenticationGetAPI(LoginRadiusConstant.INVALIDATE_ACCESSTOKEN, map)
			var res: RegisterResponse = client.getResponse(api, classOf[RegisterResponse])
			Ok(gson.toJson(res))
		} catch {
			case e: LoginRadiusException => {
				NotFound(e.getErrorResponse().getDescription().toString())
			}
			case e: Exception => NotFound(e.getMessage())
		}
	}
}
