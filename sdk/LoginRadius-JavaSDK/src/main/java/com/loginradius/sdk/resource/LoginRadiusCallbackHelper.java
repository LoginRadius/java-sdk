package com.loginradius.sdk.resource;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright © 2017 LoginRadius Inc. All rights reserved.  
   
 */

import com.loginradius.sdk.models.AccessToken;
import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.util.LoginRadiusJsonDeserializer;
import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;
import com.loginradius.sdk.util.RestRequest;
import com.loginradius.sdk.util.RestResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class LoginRadiusCallbackHelper {

	private String secret;

	RestRequest restrequest = new RestRequest();
	LoginRadiusJsonDeserializer deserializer = new LoginRadiusJsonDeserializer();

	public LoginRadiusCallbackHelper(String secret) {
		this.secret = secret;
	}

	public AccessToken GetLoginRadiusToken(HttpServletRequest request) {

		if (request.getMethod().equalsIgnoreCase("POST")) {
			String request_token = request.getParameter("token");

			if (request_token != null && (!request_token.isEmpty())) {

				Map<String, String> params = new HashMap<String, String>();
				params.put("token", request_token);
				params.put("secret", secret);

				RestResponse response = restrequest.get(Endpoint.getExchangetoken(), params);

				String jsonresponse = response.getResponse();

				if (response.getStatusCode() == 200) {
					return deserializer.deserializeJson(jsonresponse, AccessToken.class);
				} else {

					LoginRadiusRestErrorResponse error = deserializer.deserializeJson(jsonresponse,
							LoginRadiusRestErrorResponse.class);

					throw new LoginRadiusException(error);
				}

			} else {
				throw new LoginRadiusException("LoginRadius request not contains Loginradius valid request token");
			}

		} else {
			throw new LoginRadiusException("LoginRadius callback handler work with HTTP Post Request only.");
		}
	}
}
