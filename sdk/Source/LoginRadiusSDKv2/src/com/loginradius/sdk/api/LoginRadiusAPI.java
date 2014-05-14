package com.loginradius.sdk.api;

import java.util.Map;

import com.loginradius.sdk.core.LoginRadiusException;
import com.loginradius.sdk.util.LoginRadiusJsonDeserializer;
import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;
import com.loginradius.sdk.util.LoginRadiusRestRequest;
import com.loginradius.sdk.util.LoginRadiusRestResponse;

/**
 *LoginRadiusAPI base class
 * 
 * 
 */
public abstract class LoginRadiusAPI {

	protected LoginRadiusRestRequest restrequest = new LoginRadiusRestRequest();
	protected LoginRadiusJsonDeserializer deserializer = new LoginRadiusJsonDeserializer();

	public abstract String getResponse(String token);

	protected String executeGet(String apiRelativepath,
			Map<String, String> params) {

		LoginRadiusRestResponse response = restrequest.Get(apiRelativepath,params);
		
		String jsonresponse = response.getResponse();
		
		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {

			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(
					jsonresponse, LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error.message);
		}
	}

	protected String executePost(String apiRelativepath,
			Map<String, String> getParams, Map<String, String> postParams) {

		LoginRadiusRestResponse response = restrequest.Post(apiRelativepath,
				getParams, postParams);

		String jsonresponse = response.getResponse();

		if (response.getStatusCode() == 200) {
			return jsonresponse;
		} else {

			LoginRadiusRestErrorResponse error = deserializer.deserializeJson(
					jsonresponse, LoginRadiusRestErrorResponse.class);

			throw new LoginRadiusException(error.message);
		}
	}
}
