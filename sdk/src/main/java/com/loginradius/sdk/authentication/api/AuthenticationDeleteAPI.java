package com.loginradius.sdk.authentication.api;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class AuthenticationDeleteAPI extends LRAuthenticationAPI {
	private final String method;

	private String finalpath = "";
	private String objectRecordId = "";
	private Map<String, String> map = new HashMap<String, String>();

	private JsonObject json;

	public AuthenticationDeleteAPI(String method, Map<String, String> map, JsonObject data) {

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
		}

		switch (method) {
		case "removeemail":

			params.put("access_token", token);
			finalpath = Endpoint.getAddEmailUrl();
			break;
		case "deleteaccountwithemailconfirmation":

			params.put("access_token", token);
			finalpath = Endpoint.getAddEmailUrl();
			break;
		case "unlinksocialidentities":

			finalpath = Endpoint.getSocialIdentities();
			break;
		case "deletecustomobject":
			params.remove("objectRecordId");

			params.put("access_token", token);
			finalpath = Endpoint.getCustomObject() + "/" + objectRecordId;

			break;

		default:
			break;

		}

		return executeDelete(finalpath, params, json);
	}

}
