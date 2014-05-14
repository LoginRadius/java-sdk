package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;

/**
The Video API is used to get videos data from the user’s social account. 
The data will be normalized into LoginRadius' data format.
 */
public class VideoAPI extends LoginRadiusAPI
{
	/**
	 *getResponse	
	 * this function is use to get video details of user
	 *
	 * @param token Authentication token
	
	 
	 */
    @Override
	public String getResponse(String token) 
    {
        Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);

		return executeGet("/api/v2/video", params);
	}

}
