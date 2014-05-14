package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;
/**
The Following API is used to get the followers’ information from the user’s social account. 
The data will be normalized into LoginRadius' data format.
 */
public class FollowingAPI extends LoginRadiusAPI {
	/**
	 *getResponse
	 *
	 * this function gives user's followers on social providers
	 * @param token Authentication token
	 *
	 
	 */
	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/following", params);
	}
}
