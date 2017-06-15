package com.loginradius.sdk.management.api;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright © 2017 LoginRadius Inc. All rights reserved.  
   
 */

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.loginradius.sdk.resource.Endpoint;
//import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class ManagementDeleteAPI extends LRManagementAPI {

	private final String method;
	private String finalpath = "";
	private String objectRecordId = "";
	private String uid = "";
	private String role = "";
	private String rolecontextname = "";
	private Map<String, String> map = new HashMap<String, String>();

	private JsonObject json;

	public ManagementDeleteAPI(String method, Map<String, String> map, JsonObject data) {

		this.method = method;
		this.map = map;
		if (data != null) {
			this.json = data;
		} else {
			JsonObject registerdata = new JsonObject();
			registerdata.addProperty("", "");
			this.json = registerdata;
		}

	}

	@Override
	public String getResponse(String token) {
		// TODO Auto-generated method stub

		// write the validator

		if (!ArgumentValidator.pathValidator(this.method)) {

			throw new LoginRadiusException(
					"Invalid Argument used. Please refer documentation and use the correct argument");

		}

		Map<String, String> params = new HashMap<String, String>();
		if (this.map != null && !this.map.isEmpty()) {
			params.putAll(map);
			if (map.containsKey("objectRecordId")) {
				objectRecordId = map.get("objectRecordId");
			}
			if (map.containsKey("uid")) {
				uid = map.get("uid");
			}
			if (map.containsKey("role")) {
				role = map.get("role");
			}
			if (map.containsKey("rolecontextname")) {
				rolecontextname = map.get("rolecontextname");
			}
		}

		if ("deleteaccount".equals(method)) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid;
		} else if ("deletecustomobjectbyid".equals(method)) {
			params.remove("uid");
			params.remove("objectRecordId");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/customobject/" + objectRecordId;
		} else if ("deleterole".equals(method)) {
			params.remove("role");
			finalpath = Endpoint.getV2_ManagementCreateRole() + "/" + role;
		} else if ("removepermissions".equals(method)) {
			params.remove("role");
			finalpath = Endpoint.getV2_ManagementCreateRole() + "/" + role + "/permission";
		} else if ("deletecontext".equals(method)) {
			params.remove("uid");
			params.remove("rolecontextname");
			finalpath = Endpoint.getV2_ManagementGetRoleContext() + "/" + uid + "/rolecontext" + rolecontextname;
		} else if ("deleteroleandpermission".equals(method)) {
			params.remove("uid");
			params.remove("rolecontextname");
			finalpath = Endpoint.getV2_ManagementGetRoleContext() + "/" + uid + "/rolecontext" + rolecontextname
					+ "/role";
		}

		return executeDelete(finalpath, params, json);
	}

}