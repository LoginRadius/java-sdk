package com.loginradius.sdk.authentication.api;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class AuthenticationPostAPI extends LRAuthenticationAPI {

	private final String method;

	private String finalpath = "";

	private Map<String, String> map = new HashMap<String, String>();

	private JsonObject json;

	public AuthenticationPostAPI(String method, Map<String, String> map, JsonObject data) {

		this.method = method;

		this.map = map;
		if (data != null) {
			this.json = data;
		} else {
			JsonObject registerdata = new JsonObject();
			registerdata.addProperty("", "");
			this.json = registerdata;
		}

	}

	@Override
	public String getResponse(String token) {
		// TODO Auto-generated method stub

		// write the validator

		if (!ArgumentValidator.pathValidator(this.method)) {

			throw new LoginRadiusException(
					"Invalid Argument used. Please refer documentation and use the correct argument");

		}

		Map<String, String> params = new HashMap<String, String>();
		if (this.map != null && !this.map.isEmpty()) {
			params.putAll(map);

		}

		switch (method) {

		case "status":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_STATUS();
			break;
		case "message":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_MESSAGE();
			break;
		case "register":

			finalpath = Endpoint.getRegistrationUrl();
			break;

		case "password":

			finalpath = Endpoint.getForgotPasswordUrlEmail();
			break;
		case "email":
			break;
		case "addemail":

			params.put("access_token", token);
			finalpath = Endpoint.getAddEmailUrl();
			break;

		case "createcustomobject":

			params.put("access_token", token);
			finalpath = Endpoint.getCustomObject();
			break;

		case "forgotpasswordbyotp":

			finalpath = Endpoint.getForgotPasswordUrlMobile();
			break;
		case "resendotp":

			finalpath = Endpoint.getVerifyotpUrl();
			break;
		case "resendotpbytoken":

			params.put("access_token", token);
			finalpath = Endpoint.getVerifyotpUrl();
			break;

		case "forgotpasswordbyemail":

			finalpath = Endpoint.getForgotPasswordUrlEmail();
			break;
		default:
			break;

		}

		return executePost(finalpath, params, json);
	}

}
