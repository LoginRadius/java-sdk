package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;

public class StatusAPI extends LoginRadiusAPI {

	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/status", params);
	}
}