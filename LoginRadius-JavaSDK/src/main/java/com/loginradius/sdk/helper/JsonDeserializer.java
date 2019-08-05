package com.loginradius.sdk.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonDeserializer {
	private JsonDeserializer() {
	}

	private static Gson gson = new Gson();

	public static <T> T deserializeJson(String jsonString, TypeToken<T> type) {
		T result = null;
		result = gson.fromJson(jsonString, type.getType());
		return result;
	}

}
