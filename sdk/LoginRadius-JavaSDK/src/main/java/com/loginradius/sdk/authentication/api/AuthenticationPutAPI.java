package com.loginradius.sdk.authentication.api;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright � 2017 LoginRadius Inc. All rights reserved.  
   
 */

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class AuthenticationPutAPI extends LRAuthenticationAPI {

	private final String method;

	private String finalpath = "";
	private String objectRecordId = "";
	private Map<String, String> map = new HashMap<String, String>();

	private JsonObject json;

	public AuthenticationPutAPI(String method, Map<String, String> map, JsonObject data) {

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
			if (map.containsKey("objectRecordId")) {
				objectRecordId = map.get("objectRecordId");
			}
		}

		if ("changeusername".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getUserNameAvailability();
		} else if ("resendemailverification".equals(method)) {
			finalpath = Endpoint.getRegistrationUrl();
		} else if ("resetpassword".equals(method)) {
			finalpath = Endpoint.getForgotPasswordUrlEmail();
		} else if ("changepassword".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getForgotPasswordUrlEmail();
		} else if ("linksocialidentities".equals(method)) {
			finalpath = Endpoint.getSocialIdentities();
		} else if ("updateobjectbyrecordid".equals(method)) {
			params.remove("objectRecordId");
			params.put("access_token", token);
			finalpath = Endpoint.getCustomObject() + "/" + objectRecordId;
		} else if ("updatephone".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getUpdatephoneUrl();
		} else if ("resetpasswordbyotp".equals(method)) {
			finalpath = Endpoint.getForgotPasswordUrlMobile();
		} else if ("verifyotp".equals(method)) {
			finalpath = Endpoint.getVerifyotpUrl();
		} else if ("verifyotpbytoken".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getVerifyotpUrl();
		} else if ("updateaccountbytoken".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getUpdateProfileUrl();
		} else if ("2FAUpdatePhoneNumber".equals(method)) {
			finalpath = Endpoint.get2FALogin();
		} else if ("2FAUpdatePhoneNumberbyToken".equals(method)) {
			finalpath = Endpoint.get2FAByToken();
			params.put("access_token", token);
		}else if ("instantregistrationotpverification".equals(method)) {
			finalpath = Endpoint.getInstant_Registration_Otp_Verification();

		}else if ("resetpasswordbysecurityanswer".equals(method)) {
			finalpath = Endpoint.getResetPasswordbySecurityAnswer();

		}

		return executePut(finalpath, params, json);
	}

}
