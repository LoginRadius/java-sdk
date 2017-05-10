package com.loginradius.sdk.advanced.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class AdvancedGetAPI extends LRAdvancedAPI {
	
	private String method = "";
	private String finalpath = "";

	private Map<String, String> map = new HashMap<String, String>();

	public AdvancedGetAPI(String method, Map<String, String> map) {

		this.method = method;

		this.map = map;

	}

	public String getResponse(String token) {

		// ARgument validator should go here.

		if (!ArgumentValidator.pathValidator(this.method)) {

			throw new LoginRadiusException(
					"Invalid Argument used. Please refer documentation and use the correct argument");

		}

		Map<String, String> params = new HashMap<String, String>();
		if (this.map != null && !this.map.isEmpty()) {
			params.putAll(map);

		}
		
		
		
		if ("tokenvalidate".equals(method )) {
			params.put("access_token", token);
			finalpath = Endpoint.getExchangetoken() + "/Validate";
		}
		else if ("tokeninvalidate".equals(method )) {
			params.put("access_token", token);
			finalpath = Endpoint.getExchangetoken() + "/invalidate";
		}
		else if ("testresthookssettings".equals(method )) {
			finalpath = Endpoint.getV2_AdvancedRestHooksSettings();
		}
		else if ("listofresthooks".equals(method )) {
			finalpath = Endpoint.getV2_AdvancedListofRestHooks();
		}else if ("getsubscribedurl".equals(method )) {
			finalpath = Endpoint.getV2_AdvancedGetSubscribedurl();
		}
		else if ("accesstokenviafbtoken".equals(method )) {
			finalpath = Endpoint.getV2_AdvancedAccessTokenViaSocialToken() + "facebook";
		}
		else if ("accesstokenviatwtoken".equals(method )) {
			finalpath = Endpoint.getV2_AdvancedAccessTokenViaSocialToken() + "twitter";
		}
		else if ("refreshprofile".equals(method )) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_AdvancedRefreshUserProfile();
		}else if ("refreshtoken".equals(method )) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_AdvancedRefreshToken();
		}
		else if ("shortenURL".equals(method )) {
			finalpath = Endpoint.getV2_AdvancedShortenURL();
		}
		else if ("trackablestatusfetching".equals(method )) {
			finalpath = Endpoint.getV2_STATUS() + "/trackable";
		}
		else if ("gettrackablestatusstats".equals(method )) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_STATUS() + "/trackable/js";
		}
		
		
		return executeGet(finalpath, params);

	}

}
