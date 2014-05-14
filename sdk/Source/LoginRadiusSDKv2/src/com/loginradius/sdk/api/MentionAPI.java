package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;

/**
The Mention API is used to get mention data from the user’s social account. 
The data will be normalized into LoginRadius' data format.
 */
public class MentionAPI extends LoginRadiusAPI {


	/**
	 *getResponse
	 *
	 * this function used to get user mentions
	 *  
	 * @param token Authentication token
	 *
	 */
	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/mention", params);
	}
}