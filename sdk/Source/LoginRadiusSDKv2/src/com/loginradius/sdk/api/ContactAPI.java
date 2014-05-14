package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;

/**
The Contact API is used to get contacts/friends/connections data from the user’s social account. 
The data will normalized into LoginRadius' data format.
 */
public class ContactAPI extends LoginRadiusAPI {
	/**
	 *getResponse
	 *
	 * this function used to get user's contact
	 *
	 * @param token Authentication token
	 
	 
	 */
	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);
	
        return executeGet("/api/v2/contact", params);
	}
}
