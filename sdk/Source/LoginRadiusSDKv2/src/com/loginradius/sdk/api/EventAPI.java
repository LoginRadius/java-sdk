package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;


/**
 The Event API is used to get the event data from the user’s social account. 
 The data will be normalized into LoginRadius' data format.
 */
public class EventAPI extends LoginRadiusAPI {
	/**
	 *getEvents
	 *
	 * this function used to get user's events
	 *  
	 * @param token Authentication token
	 *
	 */
	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/event", params);
	}
}