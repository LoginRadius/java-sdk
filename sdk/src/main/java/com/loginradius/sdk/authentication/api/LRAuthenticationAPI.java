package com.loginradius.sdk.authentication.api;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.LoginRadiusJsonDeserializer;
import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;
import com.loginradius.sdk.util.RestRequest;
import com.loginradius.sdk.util.RestResponse;

/**
 * LoginRadiusAPI base class
 * 
 * 
 */
public abstract class LRAuthenticationAPI {

	Gson gson = new Gson();

	protected RestRequest restrequest = new RestRequest();
	protected LoginRadiusJsonDeserializer deserializer = new LoginRadiusJsonDeserializer();

	public abstract String getResponse(String token);

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
