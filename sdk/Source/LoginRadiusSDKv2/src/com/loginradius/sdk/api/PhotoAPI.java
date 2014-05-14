package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;
/**
The photo API is used to get photo data from the user’s social account. 
The data will be normalized into LoginRadius' data format
 */
public class PhotoAPI extends LoginRadiusAPI
{
	private String albumid;
    public String getAlbumid() {
		return albumid;
	}
	public void setAlbumid(String albumid) {
		this.albumid = albumid;
	}
	/**
	 *getResponse	
	 * this function is use to get photo details of user
	 *
	 * @param token Authentication token
	
	 
	 */
	@Override
	public String getResponse(String token) 
    {
    	Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);
		params.put("albumid",albumid);

		return executeGet("/api/v2/photo", params);
	}

}
