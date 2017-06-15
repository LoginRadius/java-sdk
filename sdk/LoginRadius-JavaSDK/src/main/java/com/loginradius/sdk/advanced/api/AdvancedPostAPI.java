package com.loginradius.sdk.advanced.api;


/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright © 2017 LoginRadius Inc. All rights reserved.  
   
 */

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class AdvancedPostAPI extends LRAdvancedAPI {

	private final String method;

	private String finalpath = "";

	private Map<String, String> map = new HashMap<String, String>();

	private JsonObject json;

	public AdvancedPostAPI(String method, Map<String, String> map, JsonObject data) {

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

		if ("getsocialidentity".equals(method)) {
			finalpath = Endpoint.getV2_AdvancedIdentity();
		} else if ("querydata".equals(method)) {
			finalpath = Endpoint.getV2_AdvancedQueryData();
		} else if ("subscriberesthooks".equals(method)) {
			finalpath = Endpoint.getV2_AdvancedSubscribeRestHooks();
		} else if ("unsubscriberesthooks".equals(method)) {
			finalpath = Endpoint.getV2_AdvancedUnsubscribeRestHooks();
		} else if ("addemail".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getAddEmailUrl();
		} else if ("createcustomobject".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getCustomObject();
		} else if ("forgotpasswordbyotp".equals(method)) {
			finalpath = Endpoint.getForgotPasswordUrlMobile();
		} else if ("resendotp".equals(method)) {
			finalpath = Endpoint.getVerifyotpUrl();
		} else if ("resendotpbytoken".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getVerifyotpUrl();
		} else if ("forgotpasswordbyemail".equals(method)) {
			finalpath = Endpoint.getForgotPasswordUrlEmail();
		} else if ("trackablestatusposting".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_STATUS() + "/trackable";
		}

		return executePost(finalpath, params, json);
	}

}
