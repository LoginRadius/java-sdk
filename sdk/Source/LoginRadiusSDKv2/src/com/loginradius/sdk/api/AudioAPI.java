package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;
/**
* The AudioAPI is used to get audio files data from the user’s social account. 
* The data will be normalized into LoginRadius' data format.
*/
public class AudioAPI extends LoginRadiusAPI
{
	/**
	 *getResponse	
	 * this function is use to get audio files  by user
	 *
	 * @param token Authentication token
	 * 
	 
	 */
    @Override
	public String getResponse(String token) 
    {
    	Map<String, String> params = new HashMap<String, String>();
	    params.put("access_token", token);

	    return executeGet("/api/v2/audio", params);
	}

}
