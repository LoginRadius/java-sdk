package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;
/**
The Group API is used to get group data from the user’s social account. 
The data will be normalized into LoginRadius' data format.
*/
public class GroupAPI extends LoginRadiusAPI {
	/**
	 *getResponse
	 *
	 * this function used to get user social groups
	 *
	 * @param token Authentication token
	 *
	 
	 */
	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/group", params);
	}
}
