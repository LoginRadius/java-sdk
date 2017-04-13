package com.loginradius.sdk.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.loginradius.sdk.resource.LoginRadiusException;

public class ArgumentValidator {

	public static String allowedPathNames[] = { "userprofile", "contact", "company", "event", "group", "like",
			"subscriberesthooks", "unsubscriberesthooks", "status", "album", "checkin", "audio", "video", "photo",
			"post", "page", "following", "mention", "tokenvalidate", "tokeninvalidate", "message", "emaillogin",
			"addemail", "verifyemail", "checkemailavailability", "checkusernameavailability", "deleterole",
			"removepermissions", "getsocialidentity", "createcustomobject", "login", "register", "account", "password",
			"username", "socialIdentity", "deletecustomobjectbyid", "customobject", "customobjectbyid", "phone", "otp",
			"loginbyphone", "phoneavailability", "forgotpasswordbyotp", "resendotp", "deleteaccount",
			"resendotpbytoken", "changeusername", "resendemailverification", "resetpassword", "changepassword",
			"linksocialidentities", "assignroles", "querydata", "updateobjectbyrecordid", "updatephone",
			"resetpasswordbyotp", "verifyotp", "verifyotpbytoken", "removeemail", "deleteaccountwithemailconfirmation",
			"unlinksocialidentities", "deletecustomobject", "usernamelogin", "readaccountbytoken",
			"customobjectbytoken", "updateaccountbytoken", "forgotpasswordbyemail", "createaccount", "createrole",
			"loginbyuid", "getpassword", "customobjectbyuid", "getrole", "getrolesbyuid", "updateaccount",
			"setpassword", "addpermissionstorole", "testresthookssettings", "listofresthooks", "getsubscribedurl",
			"accesstokenviafbtoken", "accesstokenviatwtoken", "refreshprofile", "shortenURL", "trackablestatusfetching",
			"gettrackablestatusstats", "trackablestatusposting", "refreshtoken", "socialinterface" };

	private static List<String> pathNames = new ArrayList<String>();

	static {

		pathNames = Arrays.asList(allowedPathNames);

	}

	public static boolean pathValidator(String path) {

		String field = path;

		boolean match = false;

		if (field == null) {
			throw new LoginRadiusException("Invalid argument");

		} else {

			field = field.trim();
			if (!pathNames.contains(field)) {

				match = false;

			} else {
				match = true;
			}

		}

		return match;

	}

	public static boolean isEmpty(final String s) {
		// Null-safe, short-circuit evaluation.
		return s == null || "null".equalsIgnoreCase(s) || s.trim().isEmpty();
	}

}
