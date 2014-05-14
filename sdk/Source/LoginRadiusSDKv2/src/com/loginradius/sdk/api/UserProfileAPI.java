package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;
/**
 *The User Profile API is used to get social profile data from the user’s social account after authentication. 
 *The social profile will be retrieved via oAuth and OpenID protocols. 
 *The data is normalized into LoginRadius' standard data format.
 * 
 */
public class UserProfileAPI extends LoginRadiusAPI {
	/**
	 *getResponse	
	 * this function used to get user profile details
	 *
	 * @param token Authentication token
	
	 
	 */
	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/userprofile", params);
	}

}
