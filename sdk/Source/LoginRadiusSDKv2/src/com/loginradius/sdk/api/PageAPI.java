package com.loginradius.sdk.api;

import java.util.HashMap;
import java.util.Map;
/**
The Page API is used to get the page data from the user’s social account. 
The data will be normalized into LoginRadius' data format.
 */
public class PageAPI extends LoginRadiusAPI {
	private String pagename;
	public String getPagename() {
		return pagename;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	/**
	 *getResponse	
	 * this function is use to get pages data from user's social account
	 *
	 * @param token Authentication token
	 * 
	 
	 */
	@Override
	public String getResponse(String token) 
	{
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);
		params.put("pagename",pagename);

		return executeGet("/api/v2/page", params);
	}

}
