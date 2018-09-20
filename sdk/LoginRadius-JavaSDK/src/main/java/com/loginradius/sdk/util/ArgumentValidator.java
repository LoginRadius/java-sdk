package com.loginradius.sdk.util;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright � 2017 LoginRadius Inc. All rights reserved.  
   
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.loginradius.sdk.resource.LoginRadiusException;

public class ArgumentValidator {

	public static String allowedPathNames[] = { "userprofile", "contact", "company", "event", "group", "like",
			"subscriberesthooks", "unsubscriberesthooks", "status", "album", "checkin", "audio", "video", "photo",
			"post", "page", "following", "mention", "tokenvalidate", "tokeninvalidate", "message", "emaillogin","accountprofilesbyemail",
			"addemail", "verifyemail", "checkemailavailability", "checkusernameavailability", "deleterole",
			"removepermissions", "getsocialidentity", "createcustomobject", "login", "register", "account", "password",
			"username", "socialIdentity", "deletecustomobjectbyid", "customobject", "customobjectbyid", "phone", "otp",
			"loginbyphone","accountprofilesbyphone", "phoneavailability", "forgotpasswordbyotp", "resendotp", "deleteaccount",
			"resendotpbytoken", "changeusername", "resendemailverification", "resetpassword", "changepassword",
			"linksocialidentities", "assignroles", "querydata", "updateobjectbyrecordid", "updatephone",
			"resetpasswordbyotp", "verifyotp", "verifyotpbytoken", "removeemail", "deleteaccountwithemailconfirmation",
			"unlinksocialidentities", "deletecustomobject", "usernamelogin", "readaccountbytoken",
			"customobjectbytoken", "updateaccountbytoken", "forgotpasswordbyemail", "createaccount", "createrole",
			"accountprofilesbyuid", "getpassword", "customobjectbyuid", "getrole", "getrolesbyuid", "updateaccount",
			"setpassword", "addpermissionstorole", "testresthookssettings", "listofresthooks", "getsubscribedurl",
			"accesstokenviafbtoken", "accesstokenviatwtoken", "refreshprofile", "shortenURL", "trackablestatusfetching",
			"gettrackablestatusstats","getactivesession", "trackablestatusposting", "refreshtoken", "configuration","servertime","2FALogin",
			"2FAbyGoogleAuthenticator","2FAbyToken","2FAVerifybyGoogleAuthenticator","2FALoginByBackupcode","2FAGetBackupcode",
			"2FAResetBackupcode","2FAGetBackupcodeByUid","2FAResetBackupcodeByUid","2FAUpdatePhoneNumber","2FAUpdatePhoneNumberbyToken",
			"RemoveGoogleAuthenticatorByToken","RemoveGoogleAuthenticatorByUid","getrolecontext","addrolecontext","deletecontext","deleteroleandpermission",
			"emailautologin","emailautologinping","accesstokenbyuid","validateaccesstoken","invalidateaccesstoken","instantregistrationbyemail","instantregistrationbyphone",
			"instantregistrationotpverification","addregistrationdata","getregistrationdata","updateregistrationdata","validatesecretcode","deleteregistrationdata",
			"resetphoneidverification","securityquestionsbyaccesstoken","securityquestionsbyemail","securityquestionsbyusername","securityquestionsbyphone","generatesott",
			"verifyautologinemail","resetpasswordbysecurityanswer","privacypolicy","onetouchloginbyemail","onetouchloginbyphone","onetouchotp","passwordlesslogin",
			"passwordlessloginverification","smartlogin","smartloginping","smartloginverifytoken","verifyemailbyotp","phoneloginusingonetimepasscode",
			"2FAValidateOtp","phonsendonetimepasscode","resetpasswordbyotp","accountprofilesbyusername","unassignrolesbyuid","deleterolefromcontext","removephonebyaccesstoken","sendwelcomeemail",
			"updatesecurityquestion","forgotpasswordtoken","emailverificationtoken","accountidentitiesbyemail","accountinvalidateverificationemail","accountupdatesecurityquestion"};

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
