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

		switch (method) {

		case "tokenvalidate":

			params.put("access_token", token);
			finalpath = Endpoint.getExchangetoken() + "/Validate";

			break;
		case "tokeninvalidate":
			params.put("access_token", token);
			finalpath = Endpoint.getExchangetoken() + "/invalidate";
			break;
		case "testresthookssettings":

			finalpath = Endpoint.getV2_AdvancedRestHooksSettings();
			break;
		case "listofresthooks":

			finalpath = Endpoint.getV2_AdvancedListofRestHooks();
			break;
		case "getsubscribedurl":

			finalpath = Endpoint.getV2_AdvancedGetSubscribedurl();
			break;
		case "accesstokenviafbtoken":

			finalpath = Endpoint.getV2_AdvancedAccessTokenViaSocialToken() + "facebook";
			break;

		case "accesstokenviatwtoken":

			finalpath = Endpoint.getV2_AdvancedAccessTokenViaSocialToken() + "twitter";
			break;
		case "refreshprofile":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_AdvancedRefreshUserProfile();
			break;

		case "refreshtoken":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_AdvancedRefreshToken();
			break;
		case "shortenURL":

			finalpath = Endpoint.getV2_AdvancedShortenURL();
			break;

		case "trackablestatusfetching":

			finalpath = Endpoint.getV2_STATUS() + "/trackable";
			break;
		case "gettrackablestatusstats":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_STATUS() + "/trackable/js";
			break;
		default:
			break;

		}

		return executeGet(finalpath, params);

	}

}
