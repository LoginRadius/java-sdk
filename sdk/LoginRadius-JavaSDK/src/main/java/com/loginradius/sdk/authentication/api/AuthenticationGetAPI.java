package com.loginradius.sdk.authentication.api;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright © 2017 LoginRadius Inc. All rights reserved.  
   
 */

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class AuthenticationGetAPI extends LRAuthenticationAPI {

	private String method = "";
	private String finalpath = "";
	private String objectRecordId = "";
	private String timeDifferance = "";
	private String type = "";

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
			} else if (map.containsKey("difference")) {
				timeDifferance = map.get("difference");
			}else if (map.containsKey("type")) {
				type = map.get("type");
			}
		}

		if ("userprofile".equals(method)) {
			finalpath = Endpoint.getV2_USERPROFILE();
			params.put("access_token", token);
		} else if ("contact".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_CONTACT();
		} else if ("company".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_COMPANY();
		} else if ("event".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_EVENT();
		} else if ("group".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_GROUP();
		} else if ("like".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_LIKE();
		} else if ("status".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_STATUS();
		} else if ("album".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_ALBUM();
		} else if ("checkin".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_CHECKIN();
		} else if ("audio".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_AUDIO();
		} else if ("video".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_VIDEO();
		} else if ("photo".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_PHOTO();
		} else if ("post".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_POST();
		} else if ("page".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_PAGE();
		} else if ("following".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_FOLLOWING();
		} else if ("mention".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_MENTION();
		} else if ("message".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_MESSAGE();
		} else if ("message".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_MESSAGE();
		} else if ("emaillogin".equals(method)) {
			finalpath = Endpoint.getLoginUrl();
		} else if ("verifyemail".equals(method)) {
			finalpath = Endpoint.getAddEmailUrl();
		} else if ("checkemailavailability".equals(method)) {
			finalpath = Endpoint.getAddEmailUrl();
		} else if ("checkusernameavailability".equals(method)) {
			finalpath = Endpoint.getUserNameAvailability();
		} else if ("phoneavailability".equals(method)) {
			finalpath = Endpoint.getUpdatephoneUrl();
		} else if ("getsocialidentity".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getSocialIdentities();
		} else if ("loginbyphone".equals(method)) {
			finalpath = Endpoint.getLoginUrl();
		} else if ("usernamelogin".equals(method)) {
			finalpath = Endpoint.getLoginUrl();
		} else if ("readaccountbytoken".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_USERPROFILE();
		} else if ("customobjectbytoken".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getCustomObject();
		} else if ("customobjectbyid".equals(method)) {
			params.remove("objectRecordId");
			params.put("access_token", token);
			finalpath = Endpoint.getCustomObject() + "/" + objectRecordId;
		} else if ("socialinterface".equals(method)) {
			finalpath = Endpoint.getSocialInterfaceUrl(params.get("apikey"));
			params.remove("apikey");

		} else if ("servertime".equals(method)) {
			if (timeDifferance != null && timeDifferance != "") {
				finalpath = Endpoint.getServerTime() + "?";
			} else {
				finalpath = Endpoint.getServerTime();
			}
		} else if ("2FALogin".equals(method)) {
			finalpath = Endpoint.get2FALogin();
		} else if ("2FAbyGoogleAuthenticator".equals(method)) {
			finalpath = Endpoint.getGoogleAuthenticatorCode();
			params.put("access_token", token);
		} else if ("2FAbyToken".equals(method)) {
			finalpath = Endpoint.get2FAByToken();
			params.put("access_token", token);
		} else if ("2FAVerifybyGoogleAuthenticator".equals(method)) {
			finalpath = Endpoint.getVerifyGoogleAuthenticatorCode();

		} else if ("2FALoginByBackupcode".equals(method)) {
			finalpath = Endpoint.getLoginByBackupcode();

		} else if ("2FAGetBackupcode".equals(method)) {
			finalpath = Endpoint.getBackupcode();
			params.put("access_token", token);
		} else if ("2FAResetBackupcode".equals(method)) {
			finalpath = Endpoint.getResetBackupcode();
			params.put("access_token", token);
		} else if ("2FAGetBackupcodeByUid".equals(method)) {
			finalpath = Endpoint.getBackupcodeByUid();

		} else if ("2FAResetBackupcodeByUid".equals(method)) {
			finalpath = Endpoint.getResetBackupcodeByUid();

		} else if ("emailautologin".equals(method)) {
			finalpath = Endpoint.getAutoLoginUrl();

		} else if ("emailautologinping".equals(method)) {
			finalpath = Endpoint.getAutoLoginUrl() + "/ping";

		} else if ("validateaccesstoken".equals(method)) {
			finalpath = Endpoint.getAuth_ValidateAccesstoken();

		} else if ("invalidateaccesstoken".equals(method)) {
			finalpath = Endpoint.getAuth_InvalidateAccesstoken();

		} else if ("instantregistrationbyemail".equals(method)) {
			finalpath = Endpoint.getInstant_Registrationby_Email();

		}else if ("instantregistrationbyphone".equals(method)) {
			finalpath = Endpoint.getInstant_Registrationby_Phone();

		}else if ("getregistrationdata".equals(method)) {
			params.remove("type");
			finalpath = Endpoint.getGetRegistrationData() +"/"+type;

		}else if ("securityquestionsbyaccesstoken".equals(method)) {
			params.put("access_token", token);
            finalpath = Endpoint.getGetSecurityQuestionsByAccessToken()+"/accesstoken";

		}else if ("securityquestionsbyemail".equals(method)) {
            finalpath = Endpoint.getGetSecurityQuestionsByAccessToken()+"/email";

		}else if ("securityquestionsbyusername".equals(method)) {
            finalpath = Endpoint.getGetSecurityQuestionsByAccessToken()+"/username";

		}else if ("securityquestionsbyphone".equals(method)) {
            finalpath = Endpoint.getGetSecurityQuestionsByAccessToken()+"/phone";

		}

		return executeGet(finalpath, params);

	}

}
