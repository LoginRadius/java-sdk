package com.loginradius.sdk.social.api;


import java.util.Map;

import com.loginradius.sdk.social.core.LoginRadiusException;
import com.loginradius.sdk.util.LoginRadiusJsonDeserializer;
import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;
import com.loginradius.sdk.util.RestRequest;
import com.loginradius.sdk.util.RestResponse;

/**
 *LoginRadiusAPI base class
 * 
 * 
 */
public abstract class LoginRadiusAPI {
	
	protected static final String path = "/api/v2/";

	protected RestRequest restrequest = new RestRequest();
	protected LoginRadiusJsonDeserializer deserializer = new LoginRadiusJsonDeserializer();
	
	public abstract String getResponse(String token); 

	

	protected String executeGet(String apiRelativepath,
			Map<String, String> params) {
		RestResponse response = restrequest.get(apiRelativepath,params);
		
		String jsonresponse = response.getResponse();
		
		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {

			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(
					jsonresponse, LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}

		
	}

	protected String executePost(String apiRelativepath,
			Map<String, String> getParams, Map<String, String> postParams) {

		RestResponse response = restrequest.post(apiRelativepath,
				getParams, postParams);

		String jsonresponse = response.getResponse();

		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {

			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(
					jsonresponse, LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error);
		}
	}
}
