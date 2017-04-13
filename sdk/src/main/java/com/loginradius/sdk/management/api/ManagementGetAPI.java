package com.loginradius.sdk.management.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class ManagementGetAPI extends LRManagementAPI {

	private String method = "";
	private String finalpath = "";
	private String objectRecordId = "";
	private String uid = "";

	private Map<String, String> map = new HashMap<String, String>();

	public ManagementGetAPI(String method, Map<String, String> map) {

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
			if (map.containsKey("uid")) {
				uid = map.get("uid");
			}
		}

		switch (method) {

		case "emaillogin":
			finalpath = Endpoint.getV2_ManagementCreateAccount();
			break;
		case "usernamelogin":
			finalpath = Endpoint.getV2_ManagementCreateAccount();
			break;
		case "loginbyphone":
			finalpath = Endpoint.getV2_ManagementCreateAccount();
			break;
		case "loginbyuid":
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid;
			break;
		case "getpassword":
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/password";
			break;
		case "customobjectbyuid":
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/customobject";
			break;
		case "customobjectbyid":
			params.remove("objectRecordId");
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/customobject/" + objectRecordId;
			break;

		case "getrole":
			finalpath = Endpoint.getV2_ManagementCreateRole();
			break;
		case "getrolesbyuid":

			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/role";
			break;

		default:
			break;

		}
		return executeGet(finalpath, params);

	}
}
