package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;

/**
 *The Company API is used to get the followed company’s data in the user’s social account. 
 *The data will be normalized into LoginRadius' data format.
 * 
 */
public class CompanyAPI extends LoginRadiusAPI {

	
	
	/**
	 *getResponse	
	 * this function is use to get company names followed by user
	 *
	 * @param token Authentication token
	
	 
	 */
	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/company", params);
	}
}