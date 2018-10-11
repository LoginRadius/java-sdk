package com.loginradius.sdk.management.api;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright 2017 LoginRadius Inc. All rights reserved.
   
 */

import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.EndpointContent;
import com.loginradius.sdk.resource.LoginRadiusClient;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.LoginRadiusJsonDeserializer;
import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;
import com.loginradius.sdk.util.RestRequest;
import com.loginradius.sdk.util.RestResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;

public abstract class LRManagementAPI {

	Gson gson = new GsonBuilder().serializeNulls().create();

	protected RestRequest restrequest = new RestRequest();
	protected LoginRadiusJsonDeserializer deserializer = new LoginRadiusJsonDeserializer();

	public abstract String getResponse(String token);

	protected EndpointContent getApi(String method) {
		Map<String, EndpointContent> apis = LoginRadiusClient.getManagementAPILookup();
		return apis.get(method);
	}

	protected String getFinalPath(String path, Map<String, String> map) {
		return Endpoint.getFinalPath(path, map);
	}

	protected Map<String, String> getParams(Boolean isAccessToken, String[] templateParams, Map<String, String> map, String token) {
		Map<String, String> params = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER); // allow removing case-insensitive templateparams
		if (map != null && !map.isEmpty()) {
			params.putAll(map);
			if (!map.containsKey("apikey")) {
				params.put("apikey", LoginRadiusSDK.getApiKey());
				params.put("apisecret", LoginRadiusSDK.getApiSecret());
			}
		} else {
			params.put("apikey", LoginRadiusSDK.getApiKey());
			params.put("apisecret", LoginRadiusSDK.getApiSecret());
		}

		if (isAccessToken && !token.equals("")) {
			params.put("access_token", token);
		}

		for (int i=0; i<templateParams.length; i++ ) {
			if (params.containsKey(templateParams[i])) {
				params.remove(templateParams[i]);
			}
		}

		return params;
	}

	protected String executeGet(String apiRelativepath, Map<String, String> params) {
		RestResponse response = restrequest.get(apiRelativepath, params);

		String jsonresponse = response.getResponse();

		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {

			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(jsonresponse,
					LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}

	}

	protected String executePost(String apiRelativepath, Map<String, String> getParams, JsonObject json) {

		RestResponse response = restrequest.post(apiRelativepath, getParams, gson.toJson(json));

		String jsonresponse = response.getResponse();

		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {

			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(jsonresponse,
					LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}
	}

	protected String executePut(String apiRelativepath, Map<String, String> getParams, JsonObject json) {

		RestResponse response = restrequest.put(apiRelativepath, getParams, gson.toJson(json));

		String jsonresponse = response.getResponse();

		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {

			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(jsonresponse,
					LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}
	}

	protected String executeDelete(String apiRelativepath, Map<String, String> getParams, JsonObject json) {

		RestResponse response = restrequest.delete(apiRelativepath, getParams, gson.toJson(json));

		String jsonresponse = response.getResponse();

		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {

			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(jsonresponse,
					LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}
	}
}
