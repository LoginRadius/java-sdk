package com.loginradius.sdk.authentication.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class AuthenticationGetAPI extends LRAuthenticationAPI {

	private String method = "";
	private String finalpath = "";
	private String objectRecordId = "";

	private Map<String, String> map = new HashMap<String, String>();

	public AuthenticationGetAPI(String method, Map<String, String> map) {

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
			if (map.containsKey("objectRecordId")) {
				objectRecordId = map.get("objectRecordId");
			}
		}

		switch (method) {

		case "userprofile":
			finalpath = Endpoint.getV2_USERPROFILE();

			params.put("access_token", token);
			break;
		case "contact":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_CONTACT();
			break;
		case "company":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_COMPANY();
			break;
		case "event":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_EVENT();
			break;
		case "group":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_GROUP();
			break;
		case "like":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_LIKE();
			break;
		case "status":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_STATUS();
			break;
		case "album":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_ALBUM();
			break;
		case "checkin":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_CHECKIN();
			break;
		case "audio":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_AUDIO();
			break;
		case "video":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_VIDEO();
			break;
		case "photo":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_PHOTO();
			break;
		case "post":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_POST();
			break;

		case "page":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_PAGE();
			break;
		case "following":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_FOLLOWING();
			break;
		case "mention":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_MENTION();
			break;
		case "message":
			params.put("access_token", token);
			finalpath = Endpoint.getV2_MESSAGE();
			break;
		case "emaillogin":
			finalpath = Endpoint.getLoginUrl();
			break;
		case "verifyemail":

			finalpath = Endpoint.getAddEmailUrl();
			break;
		case "checkemailavailability":

			finalpath = Endpoint.getAddEmailUrl();
			break;
		case "checkusernameavailability":

			finalpath = Endpoint.getUserNameAvailability();
			break;
		case "phoneavailability":

			finalpath = Endpoint.getUpdatephoneUrl();
			break;
		case "getsocialidentity":
			params.put("access_token", token);
			finalpath = Endpoint.getSocialIdentities();
			break;
		case "loginbyphone":

			finalpath = Endpoint.getLoginUrl();
			break;
		case "usernamelogin":
			finalpath = Endpoint.getLoginUrl();
			break;
		case "readaccountbytoken":

			params.put("access_token", token);
			finalpath = Endpoint.getV2_USERPROFILE();
			break;

		case "customobjectbytoken":

			params.put("access_token", token);
			finalpath = Endpoint.getCustomObject();
			break;
		case "customobjectbyid":
			params.remove("objectRecordId");
			params.put("access_token", token);
			finalpath = Endpoint.getCustomObject() + "/" + objectRecordId;
			break;
		case "socialinterface":

			finalpath = Endpoint.getSocialInterfaceUrl(params.get("apikey"));
			params.remove("apikey");
			break;

		default:
			break;

		}

		return executeGet(finalpath, params);

	}

}
