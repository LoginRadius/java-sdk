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
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;
import com.loginradius.sdk.util.LoginRadiusSDK;

public class ManagementPutAPI extends LRManagementAPI {

	private final String method;
	private String finalpath = "";
	private String objectRecordId = "";
	private String uid = "";
	private String role = "";
	private String recordid = "";
	private Map<String, String> map = new HashMap<String, String>();
	private JsonObject json;

	public ManagementPutAPI(String method, Map<String, String> map, JsonObject data) {

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
				role = map.get("role").replaceAll(" ", "%20");
			}if (map.containsKey("recordid")) {
				recordid = map.get("recordid");
			}
			if(!map.containsKey("apikey")){
				params.put("apikey", LoginRadiusSDK.getApiKey());
				params.put("apisecret", LoginRadiusSDK.getApiSecret());
			}
		}else{
			params.put("apikey", LoginRadiusSDK.getApiKey());
			params.put("apisecret", LoginRadiusSDK.getApiSecret());
		}

		if ("updateaccount".equals(method)) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid;
		} else if ("setpassword".equals(method)) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/password";
		} else if ("updateobjectbyrecordid".equals(method)) {
			params.remove("objectRecordId");
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/customobject/" + objectRecordId;
		} else if ("addpermissionstorole".equals(method)) {
			params.remove("role");
			finalpath = Endpoint.getV2_ManagementCreateRole() + "/" + role + "/permission";
		} else if ("assignroles".equals(method)) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateCustomObject() + "/" + uid + "/role";
		} else if ("addrolecontext".equals(method)) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementGetRoleContext() + "/" + uid + "/rolecontext";
		}else if ("resetphoneidverification".equals(method)) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/invalidatephone";
		}else if ("updateregistrationdata".equals(method)) {
			params.remove("recordid");
			finalpath = Endpoint.getGetRegistrationData_Management() +"/"+recordid;

		}else if ("accountupdatesecurityquestion".equals(method)) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() +"/"+uid;

		}else if ("accountinvalidateverificationemail".equals(method)) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() +"/"+ uid + "/invalidateemail";

		}
		
     	return executePut(finalpath, params, json);
	}
	

}