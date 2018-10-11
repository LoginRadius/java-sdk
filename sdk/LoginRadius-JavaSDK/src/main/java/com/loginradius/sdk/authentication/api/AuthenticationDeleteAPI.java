package com.loginradius.sdk.authentication.api;


/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright 2017 LoginRadius Inc. All rights reserved.
   
 */

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.loginradius.sdk.resource.EndpointContent;
import com.loginradius.sdk.resource.LoginRadiusException;

public class AuthenticationDeleteAPI extends LRAuthenticationAPI {
	private final String method;
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
		EndpointContent api = getApi(method);
		if (api == null) {
			throw new LoginRadiusException("Invalid Argument used. Please refer documentation and use the correct argument");
		}

		Map<String, String> params = getParams(api.getIsToken(), api.getTemplateParams(), map, token);
		String finalPath = getFinalPath(api.getPath(), map);

		return executeDelete(finalPath, params, json);
	}
}