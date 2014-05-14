package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;
/**
*The Check In API is used to get check-ins data from the user’s social account. 
*The data will be normalized into LoginRadius' data format.
*/
public class CheckInAPI extends LoginRadiusAPI
{
	/**
	 *getResponse	
	 * this function is use to get checkin data
	 *
	 * @param token Authentication token
	 * 
	 
	 */
    @Override
	public String getResponse(String token) 
    {
	
    	Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/checkin", params);
	}

}
