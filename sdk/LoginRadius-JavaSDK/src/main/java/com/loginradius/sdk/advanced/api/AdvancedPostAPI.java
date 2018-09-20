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
import com.loginradius.sdk.util.LoginRadiusSDK;

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
		  if(!map.containsKey("key")){
			params.put("key", LoginRadiusSDK.getApiKey());
			params.put("secret", LoginRadiusSDK.getApiSecret());
		   }
			finalpath = Endpoint.getV2_AdvancedIdentity();
		} else if ("querydata".equals(method)) {
			if(!map.containsKey("apikey")){
				params.put("apikey", LoginRadiusSDK.getApiKey());
				params.put("apisecret", LoginRadiusSDK.getApiSecret());
			}
			finalpath = Endpoint.getV2_AdvancedQueryData();
		} else if ("subscriberesthooks".equals(method)) {
			if(!map.containsKey("api_key")){
				params.put("api_key", LoginRadiusSDK.getApiKey());
				params.put("api_secret", LoginRadiusSDK.getApiSecret());
			}
			finalpath = Endpoint.getV2_AdvancedSubscribeRestHooks();
		} else if ("unsubscriberesthooks".equals(method)) {
			if(!map.containsKey("api_key")){
				params.put("api_key", LoginRadiusSDK.getApiKey());
				params.put("api_secret", LoginRadiusSDK.getApiSecret());
			}
			finalpath = Endpoint.getV2_AdvancedUnsubscribeRestHooks();
		}else if ("trackablestatusposting".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_STATUS() + "/trackable";
		}

		return executePost(finalpath, params, json);
	}

}
