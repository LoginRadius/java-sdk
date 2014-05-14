package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;
/**

The Post API is used to get posted messages from the user’s social account. 
The data will be normalized into LoginRadius' data format.
*/
public class PostAPI extends LoginRadiusAPI {

	/**
	 *getResponse	
	 * this function used to get user posts
	 *
	 * @param token Authentication token
	
	 
	 */
	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/post", params);
	}
}