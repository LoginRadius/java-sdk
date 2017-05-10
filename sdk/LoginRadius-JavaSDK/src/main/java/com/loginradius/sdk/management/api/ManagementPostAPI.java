package com.loginradius.sdk.management.api;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class ManagementPostAPI extends LRManagementAPI {

	private final String method;
	private String finalpath = "";
	private String uid = "";
	private Map<String, String> map = new HashMap<String, String>();

	private JsonObject json;

	public ManagementPostAPI(String method, Map<String, String> map, JsonObject data) {

		this.method = method;
		this.map = map;
		this.json = data;
		if (data != null) {

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
			if (map.containsKey("uid")) {
				uid = map.get("uid");
			}
		}

		if ("createaccount".equals(method)) {
			finalpath = Endpoint.getV2_ManagementCreateAccount();
		}else if ("createcustomobject".equals(method )) {
			params.remove("uid");
			params.put("access_token", token);
			finalpath = Endpoint.getV2_ManagementCreateCustomObject() + "/" + uid + "/customobject";
		}else if ("createrole".equals(method )) {
			finalpath = Endpoint.getV2_ManagementCreateRole();
		}
		
		return executePost(finalpath, params, json);

	}

}
