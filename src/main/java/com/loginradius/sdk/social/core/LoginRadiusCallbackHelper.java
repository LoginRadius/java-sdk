package com.loginradius.sdk.social.core;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.loginradius.sdk.social.models.AccessToken;
import com.loginradius.sdk.util.LoginRadiusJsonDeserializer;
import com.loginradius.sdk.util.LoginRadiusRestErrorResponse;
import com.loginradius.sdk.util.RestRequest;
import com.loginradius.sdk.util.RestResponse;
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

				RestResponse response = restrequest.get(
						"/api/v2/access_token", params);

				String jsonresponse = response.getResponse();

				if (response.getStatusCode() == 200) {
					return deserializer.deserializeJson(jsonresponse,
							AccessToken.class);
				} else {

					LoginRadiusRestErrorResponse error = deserializer
							.deserializeJson(jsonresponse,
									LoginRadiusRestErrorResponse.class);

					throw new LoginRadiusException(error);
				}

			} else {
				throw new LoginRadiusException(
						"LoginRadius request not contains Loginradius valid request token");
			}

		} else {
			throw new LoginRadiusException(
					"LoginRadius callback handler work with HTTP Post Request only.");
		}
	}
}
