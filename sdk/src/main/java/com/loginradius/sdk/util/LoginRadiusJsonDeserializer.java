package com.loginradius.sdk.util;

import com.google.gson.Gson;

/**
 * LoginRadiusJsonDeserializer class to deserialize json response
 *
 */
public class LoginRadiusJsonDeserializer {

	private Gson gson = new Gson();

	public <T> T deserializeJson(String jsonString, Class<T> type) {

		T result = null;

		result = gson.fromJson(jsonString, type);

		return result;
	}

	// This method is used to get the json string from the given object

	public <T> String serializeJson(T object) {

		String result = null;

		result = gson.toJson(object, object.getClass());

		return result;
	}

}
