package com.loginradius.sdk.resource;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright � 2017 LoginRadius Inc. All rights reserved.  
   
 */

import java.util.Map;

/**
 * Object for setting LoginRadius end point into requesting urls
 * 
 *
 */
public class Endpoint {
	private static final String LOGINRADIUS_API_ROOT = "https://api.loginradius.com";
	private static final String LOGINRADIUS_CONFIGURATION= "https://config.lrcontent.com/ciam/appinfo";
	private static final String API_V2_LOGIN = "/identity/v2/auth/login";
	private static final String API_REGISTER = "/identity/v2/auth/register";
	private static final String API_FORGOT_PASSWORD_EAMIL = "/identity/v2/auth/password";
	private static final String API_CHANGE_PASSWORDE = "/identity/v2/auth/password/change";
	private static final String API_FORGOT_PASSWORD_MOBILE = "/identity/v2/auth/password/otp";
	private static final String LOGINRADIUS_VERIFYOTP = "/identity/v2/auth/phone/otp";
	private static final String LOGINRADIUS_UPDATEPHONE = "/identity/v2/auth/phone";
	private static final String LOGINRADIUS_UPDATEPROFILE = "/identity/v2/auth/account";
	private static final String LOGINRADIUS_ADDEMAIL = "/identity/v2/auth/email";
	private static final String LOGINRADIUS_SOCIALIDENTITIES = "/identity/v2/auth/socialIdentity";
	private static final String LOGINRADIUS_CHECKUSERNAMEAVAILABILITY = "/identity/v2/auth/username";
	private static final String API_V2_AUTO_LOGIN = "/identity/v2/auth/login/autologin";
	private static final String API_V2_AUTO_LOGIN_EMAIL_VERIFY = "/identity/v2/auth/email/autologin";
	private static final String API_V2_READALL_PROFILES_BYTOKEN = "/identity/v2/auth/account";
	private static final String API_V2_ALBUM = "/api/v2/album";
	private static final String API_V2_AUDIO = "/api/v2/audio";
	private static final String API_V2_CHECKIN = "/api/v2/checkin";
	private static final String API_V2_COMPANY = "/api/v2/company";
	private static final String API_V2_CONTACT = "/api/v2/contact";
	private static final String API_V2_EVENT = "/api/v2/event";
	private static final String API_V2_FOLLOWING = "/api/v2/following";
	private static final String API_V2_GROUP = "/api/v2/group";
	private static final String API_V2_LIKE = "/api/v2/like";
	private static final String API_V2_MENTION = "/api/v2/mention";
	private static final String API_V2_MESSAGE = "/api/v2/message";
	private static final String API_V2_PAGE = "/api/v2/page";
	private static final String API_V2_PHOTO = "/api/v2/photo";
	private static final String API_V2_POST = "/api/v2/post";
	private static final String API_V2_STATUS = "/api/v2/status";
	private static final String API_V2_USERPROFILE = "/api/v2/userprofile";

	private static final String API_V2_VIDEO = "/api/v2/video";

	public static final String TOKEN_EXACHANGE = "/api/v2/access_token";
	public static final String API_V2_CustomObjects = "/identity/v2/auth/customobject";
	
	public static final String API_V2_INSTANT_REGISTRATION = "/identity/v2/auth/noregistration";
	public static final String API_V2_GET_REGISTRATION_DATA = "/identity/v2/auth/registrationdata";
	public static final String API_V2_GET_SECURITY_QUESTIONS = "/identity/v2/auth/securityquestion";
	public static final String API_V2_RESET_PASSWORD_BY_SECURITY_ANSWER = "/identity/v2/auth/password/securityanswer";
	/**
	 * 
	 * Management API EndPoint
	 **/

	public static final String API_V2_MANAGEMENT_CREATEACCOUNT = "/identity/v2/manage/account";
	public static final String API_V2_MANAGEMENT_ACCESSTOKEN_BY_UID = "/identity/v2/manage/account/access_token";
	public static final String API_V2_MANAGEMENT_ROLE = "/identity/v2/manage/role";
	public static final String API_V2_GET_REGISTRATION_MANAGEMENT_DATA = "/identity/v2/manage/registrationdata";
	public static final String API_V2_ADD_REGISTRATION_DATA = "/identity/v2/manage/registrationdata";
	public static final String API_V2_FORGOT_PASSWORD_TOKEN = "/identity/v2/manage/account/forgot/token";
	public static final String API_V2_EMAIL_VERIFICATION_TOKEN = "/identity/v2/manage/account/verify/token";
	public static final String API_V2_ACCOUNT_IDENTITIES_BY_EMAIL = "/identity/v2/manage/account/identities";

	/**
	 * 
	 * Advanced API EndPoint
	 **/

	public static final String API_V2_ADVANCED_IDENTITY = "/api/v2/identity";
	public static final String API_V2_ADVANCED_AGGREGATION_QUERYDATA = "/api/v2/insights";
	public static final String API_V2_ADVANCED_SUBSCRIBE_RESTHOOKS = "/api/v2/resthook/subscribe";
	public static final String API_V2_ADVANCED_UNSUBSCRIBE_RESTHOOKS = "/api/v2/resthook/unsubscribe";
	public static final String API_V2_ADVANCED_TEST_RESTHOOKS_SETTINGS = "/api/v2/resthook/test";
	public static final String API_V2_ADVANCED_LIST_OF_RESTHOOKS = "/api/v2/resthook/fields";
	public static final String API_V2_ADVANCED_GET_SUBSCRIBED_URL = "/api/v2/resthook/subscription";
	public static final String API_V2_ADVANCED_ACCESSTOKEN_VIA_SOCIALTOKEN = "/api/v2/access_token/";
	public static final String API_V2_ADVANCED_REFRESH_USERPROFILE = "/api/v2/userprofile/refresh";
	public static final String API_V2_ADVANCED_REFRESHTOKEN = "/api/v2/access_token/refresh";
	public static final String API_V2_ADVANCED_SHORTENURL = "/sharing/v1/shorturl";
	public static final String API_V2_SERVERTIME = "/identity/v2/serverinfo";

	/**
	 * 
	 * 2FA API EndPoint
	 **/

	public static final String API_V2_2FA_LOGIN = "/identity/v2/auth/login/2fa";
	public static final String API_V2_2FA_GOOGLE_AUTH = "/identity/v2/auth/account/2fa/verification/otp";
	public static final String API_V2_2FA_VERIFY_GOOGLE_AUTH = "/identity/v2/auth/login/2fa/verification/googleauthenticatorcode";
	public static final String API_V2_2FA_VERIFY_GOOGLE_BY_OTP = "/identity/v2/auth/login/2fa/verification/otp";
	public static final String API_V2_2FA_BY_TOKEN = "/identity/v2/auth/account/2fa";
	public static final String API_V2_2FA_BY_LOGIN_BACKUPCODE = "/identity/v2/auth/login/2fa/verification/backupcode";
	public static final String API_V2_2FA_GET_BACKUPCODE = "/identity/v2/auth/account/2fa/backupcode";
	public static final String API_V2_2FA_RESET_BACKUPCODE = "/identity/v2/auth/account/2fa/backupcode/reset";
	public static final String API_V2_2FA_GET_BACKUPCODE_BY_UID = "/identity/v2/auth/manage/account/2fa/backupcode";
	public static final String API_V2_2FA_RESET_BACKUPCODE_BY_UID = "/identity/v2/manage/account/2fa/backupcode/reset";
	public static final String API_V2_2FA_REMOVE_GOOGLE_AUTH_BY_TOKEN = "/identity/v2/auth/account/2fa/authenticator";
	public static final String API_V2_2FA_REMOVE_GOOGLE_AUTH_BY_UID = "/identity/v2/manage/account/2fa/authenticator";

	public static final String API_V2_AUTH_VALIDATE_ACCESS_TOKEN = "/identity/v2/auth/access_token/validate";
	public static final String API_V2_AUTH_INVALIDATE_ACCESS_TOKEN = "/identity/v2/auth/access_token/invalidate";
	public static final String API_V2_PRIVACY_POLICY_ACCEPT = "/identity/v2/auth/privacypolicy/accept";
	public static final String API_V2_ONE_TOUCH_LOGIN_BY_EMAIL  = "/identity/v2/auth/onetouchlogin/email";
	public static final String API_V2_ONE_TOUCH_LOGIN_BY_PHONE  = "/identity/v2/auth/onetouchlogin/phone";
	public static final String API_V2_ONE_TOUCH_OTP_VERIFICATION  = "/identity/v2/auth/onetouchlogin/phone/verify";
	
	
	public static final String API_V2_PASSWORDLESS_LOGIN_BYEMAIL  = "/identity/v2/auth/login/passwordlesslogin/email";
	public static final String API_V2_PASSWORDLESS_LOGIN_VERIFICATION  = "/identity/v2/auth/login/passwordlesslogin/email/verify";
	public static final String API_V2_PHONE_LOGIN_USING_ONETIMEPASSCODE  = "/identity/v2/auth/login/passwordlesslogin/otp/verify";
	public static final String API_V2_PHONE_SEND_ONETIMEPASSCODE  = "/identity/v2/auth/login/passwordlesslogin/otp";
	
	public static final String API_V2_SMARTLOGIN  = "/identity/v2/auth/login/smartlogin";
	public static final String API_V2_SMARTLOGIN_PING  = "/identity/v2/auth/login/smartlogin/ping";
	public static final String API_V2_SMARTLOGIN_VERIFYTOKEN  = "/identity/v2/auth/email/smartlogin";
	
	
	public static final String API_V2_VERIFY_EMAIL_BY_OTP  = "/identity/v2/auth/email";
	public static final String API_V2_RESET_PASSWORD_BY_OTP  = "/identity/v2/auth/password/reset";
	
	public static final String API_V2_SEND_WELCOME_EMAIL  = "/identity/v2/auth/account/sendwelcomeemail";
	public static final String API_V2_UPDATE_SECURITY_QUESTION_BY_TOKEN  = "/identity/v2/auth/account";
	
	public static final String API_V2_DELETE_ACCOUNT_WITH_EMAIL_CONFIRMATION  = "/identity/v2/auth/account";
	/**
	 * Creates Management API url after appending LoginRadius api root url
	 * 
	 * @return complete url for fetching data
	 * 
	 * 
	 */
	
	public static String getV2_ManagementCreateAccount() {
		return LOGINRADIUS_API_ROOT + API_V2_MANAGEMENT_CREATEACCOUNT;
	}

	public static String getV2_ManagementCreateCustomObject() {
		return LOGINRADIUS_API_ROOT + API_V2_MANAGEMENT_CREATEACCOUNT;
	}

	public static String getV2_ManagementCreateRole() {
		return LOGINRADIUS_API_ROOT + API_V2_MANAGEMENT_ROLE;
	}

	public static String getV2_ManagementGetRoleContext() {
		return LOGINRADIUS_API_ROOT + API_V2_MANAGEMENT_CREATEACCOUNT;
	}

	public static String getV2_Management_GetAccessToken_By_Uid() {
		return LOGINRADIUS_API_ROOT + API_V2_MANAGEMENT_ACCESSTOKEN_BY_UID;
	}

	public static String getV2_AdvancedIdentity() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_IDENTITY;
	}

	public static String getV2_AdvancedQueryData() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_AGGREGATION_QUERYDATA;
	}

	public static String getV2_AdvancedSubscribeRestHooks() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_SUBSCRIBE_RESTHOOKS;
	}

	public static String getV2_AdvancedUnsubscribeRestHooks() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_UNSUBSCRIBE_RESTHOOKS;
	}

	public static String getV2_AdvancedRestHooksSettings() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_TEST_RESTHOOKS_SETTINGS;
	}

	public static String getV2_AdvancedListofRestHooks() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_LIST_OF_RESTHOOKS;
	}

	public static String getV2_AdvancedGetSubscribedurl() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_GET_SUBSCRIBED_URL;
	}

	public static String getV2_AdvancedAccessTokenViaSocialToken() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_ACCESSTOKEN_VIA_SOCIALTOKEN;
	}

	public static String getV2_AdvancedRefreshUserProfile() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_REFRESH_USERPROFILE;
	}

	public static String getV2_AdvancedRefreshToken() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_REFRESHTOKEN;
	}

	public static String getV2_AdvancedShortenURL() {
		return LOGINRADIUS_API_ROOT + API_V2_ADVANCED_SHORTENURL;
	}
	
	public static String getV2_AddRegistrationData() {
		return LOGINRADIUS_API_ROOT + API_V2_ADD_REGISTRATION_DATA;
	}
	
	
	
	public static String getV2_AuthReadProfilesByToken() {
		return LOGINRADIUS_API_ROOT + API_V2_READALL_PROFILES_BYTOKEN;
	}
	
	
	

	/**
	 * Creates Auth url after appending LoginRadius api root url
	 * 
	 * @return complete url for fetching data
	 */

	public static String getV2_VIDEO() {
		return LOGINRADIUS_API_ROOT + API_V2_VIDEO;
	}

	public static String getV2_USERPROFILE() {
		return LOGINRADIUS_API_ROOT + API_V2_USERPROFILE;
	}

	public static String getV2_STATUS() {
		return LOGINRADIUS_API_ROOT + API_V2_STATUS;
	}

	public static String getV2_POST() {
		return LOGINRADIUS_API_ROOT + API_V2_POST;
	}

	public static String getV2_PHOTO() {
		return LOGINRADIUS_API_ROOT + API_V2_PHOTO;
	}

	public static String getV2_PAGE() {
		return LOGINRADIUS_API_ROOT + API_V2_PAGE;
	}

	public static String getV2_MESSAGE() {
		return LOGINRADIUS_API_ROOT + API_V2_MESSAGE;
	}

	public static String getV2_MENTION() {
		return LOGINRADIUS_API_ROOT + API_V2_MENTION;
	}

	public static String getV2_LIKE() {
		return LOGINRADIUS_API_ROOT + API_V2_LIKE;
	}

	public static String getV2_GROUP() {
		return LOGINRADIUS_API_ROOT + API_V2_GROUP;
	}

	public static String getV2_FOLLOWING() {
		return LOGINRADIUS_API_ROOT + API_V2_FOLLOWING;
	}

	public static String getV2_EVENT() {
		return LOGINRADIUS_API_ROOT + API_V2_EVENT;
	}

	public static String getV2_CONTACT() {
		return LOGINRADIUS_API_ROOT + API_V2_CONTACT;
	}

	public static String getV2_COMPANY() {
		return LOGINRADIUS_API_ROOT + API_V2_COMPANY;
	}

	public static String getV2_ALBUM() {
		return LOGINRADIUS_API_ROOT + API_V2_ALBUM;
	}

	public static String getV2_CHECKIN() {
		return LOGINRADIUS_API_ROOT + API_V2_CHECKIN;
	}

	public static String getV2_AUDIO() {
		return LOGINRADIUS_API_ROOT + API_V2_AUDIO;
	}

	public static String getLoginUrl() {
		return LOGINRADIUS_API_ROOT + API_V2_LOGIN;
	}

	public static String getAutoLoginUrl() {
		return LOGINRADIUS_API_ROOT + API_V2_AUTO_LOGIN;
	}
	
	
	public static String getAutoLoginEmailVerify() {
		return LOGINRADIUS_API_ROOT + API_V2_AUTO_LOGIN_EMAIL_VERIFY;
	}

	public static String getUpdateProfileUrl() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_UPDATEPROFILE;
	}

	public static String getRegistrationUrl() {
		return LOGINRADIUS_API_ROOT + API_REGISTER;
	}

	public static String getVerifyotpUrl() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_VERIFYOTP;
	}

	public static String getUpdatephoneUrl() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_UPDATEPHONE;
	}

	public static String getAddEmailUrl() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_ADDEMAIL;
	}

	public static String getForgotPasswordUrlEmail() {
		return LOGINRADIUS_API_ROOT + API_FORGOT_PASSWORD_EAMIL;
	}
	
	public static String getChangePasswordUrl() {
		return LOGINRADIUS_API_ROOT + API_CHANGE_PASSWORDE;
	}
	
	public static String getForgotPasswordUrlMobile() {
		return LOGINRADIUS_API_ROOT + API_FORGOT_PASSWORD_MOBILE;
	}

	public static String getConfigurationUrl() {
		return LOGINRADIUS_CONFIGURATION;
	}


	public static String getSocialIdentities() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_SOCIALIDENTITIES;
	}

	public static String getExchangetoken() {
		return LOGINRADIUS_API_ROOT + TOKEN_EXACHANGE;
	}

	public static String getUserNameAvailability() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_CHECKUSERNAMEAVAILABILITY;
	}

	public static String getCustomObject() {
		return LOGINRADIUS_API_ROOT + API_V2_CustomObjects;
	}

	public static String getServerTime() {
		return LOGINRADIUS_API_ROOT + API_V2_SERVERTIME;
	}

	public static String get2FALogin() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_LOGIN;
	}

	public static String getGoogleAuthenticatorCode() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_GOOGLE_AUTH;
	}
	
	public static String getGoogleAuthenticatorCodeVerifyByOtp() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_VERIFY_GOOGLE_AUTH;
	}
	

	public static String get2FAByToken() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_BY_TOKEN;
	}

	public static String getVerifyGoogleAuthenticatorCode() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_VERIFY_GOOGLE_AUTH;
	}

	public static String getLoginByBackupcode() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_BY_LOGIN_BACKUPCODE;
	}

	public static String getBackupcode() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_GET_BACKUPCODE;
	}

	public static String getResetBackupcode() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_RESET_BACKUPCODE;
	}

	public static String getBackupcodeByUid() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_GET_BACKUPCODE_BY_UID;
	}

	public static String getResetBackupcodeByUid() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_RESET_BACKUPCODE_BY_UID;
	}

	public static String getGoogleAuthenticatorByToken() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_REMOVE_GOOGLE_AUTH_BY_TOKEN;
	}

	public static String getGoogleAuthenticatorByUid() {
		return LOGINRADIUS_API_ROOT + API_V2_2FA_REMOVE_GOOGLE_AUTH_BY_UID;
	}

	public static String getAuth_ValidateAccesstoken() {
		return LOGINRADIUS_API_ROOT + API_V2_AUTH_VALIDATE_ACCESS_TOKEN;
	}

	public static String getAuth_InvalidateAccesstoken() {
		return LOGINRADIUS_API_ROOT + API_V2_AUTH_INVALIDATE_ACCESS_TOKEN;
	}
	
	
	public static String getInstant_Registrationby_Email() {
		return LOGINRADIUS_API_ROOT + API_V2_INSTANT_REGISTRATION +"/email";
	}
	
	
	public static String getInstant_Registrationby_Phone() {
		return LOGINRADIUS_API_ROOT + API_V2_INSTANT_REGISTRATION +"/phone";
	}

	public static String getInstant_Registration_Otp_Verification() {
		return LOGINRADIUS_API_ROOT + API_V2_INSTANT_REGISTRATION +"/phone/verify";
	}

	public static String getGetRegistrationData() {
		return LOGINRADIUS_API_ROOT + API_V2_GET_REGISTRATION_DATA;
	}
	
	public static String getGetRegistrationData_Management() {
		return LOGINRADIUS_API_ROOT + API_V2_GET_REGISTRATION_MANAGEMENT_DATA;
	}
	
	
	public static String getGetSecurityQuestionsByAccessToken() {
		return LOGINRADIUS_API_ROOT + API_V2_GET_SECURITY_QUESTIONS;
	}
	
	
	public static String getResetPasswordbySecurityAnswer() {
		return LOGINRADIUS_API_ROOT + API_V2_RESET_PASSWORD_BY_SECURITY_ANSWER;
	}
	
	
	public static String getPrivacyPolicyAccept() {
		return LOGINRADIUS_API_ROOT + API_V2_PRIVACY_POLICY_ACCEPT;
	}
	
	
	public static String getOneTouchLoginByEmail() {
		return LOGINRADIUS_API_ROOT + API_V2_ONE_TOUCH_LOGIN_BY_EMAIL;
	}
	
	
	public static String getOneTouchLoginByPhone() {
		return LOGINRADIUS_API_ROOT + API_V2_ONE_TOUCH_LOGIN_BY_PHONE;
	}
	
	
	public static String getOneTouchOtpVerification() {
		return LOGINRADIUS_API_ROOT + API_V2_ONE_TOUCH_OTP_VERIFICATION;
	}
	
	
	public static String getPasswordlessLogin() {
		return LOGINRADIUS_API_ROOT + API_V2_PASSWORDLESS_LOGIN_BYEMAIL;
	}
	
	
	public static String getPasswordlessLoginVerification() {
		return LOGINRADIUS_API_ROOT + API_V2_PASSWORDLESS_LOGIN_VERIFICATION;
	}
	
	public static String getPhoneLoginByOneTimePassCode() {
		return LOGINRADIUS_API_ROOT + API_V2_PHONE_LOGIN_USING_ONETIMEPASSCODE;
	}
	
	public static String getPhoneSendOneTimePassCode() {
		return LOGINRADIUS_API_ROOT + API_V2_PHONE_SEND_ONETIMEPASSCODE;
	}
	
	public static String getSmartLogin() {
		return LOGINRADIUS_API_ROOT + API_V2_SMARTLOGIN;
	}
	
	
	public static String getSmartLoginPing() {
		return LOGINRADIUS_API_ROOT + API_V2_SMARTLOGIN_PING;
	}
	
	
	public static String getSmartLoginVerifyToken() {
		return LOGINRADIUS_API_ROOT + API_V2_SMARTLOGIN_VERIFYTOKEN;
	}
	
	public static String getVerifyEmailByOtp() {
		return LOGINRADIUS_API_ROOT + API_V2_VERIFY_EMAIL_BY_OTP;
	}
	
	
	public static String getResetPasswordByOtp() {
		return LOGINRADIUS_API_ROOT + API_V2_RESET_PASSWORD_BY_OTP;
	}
	
	
	public static String getSendWelcomeEmail() {
		return LOGINRADIUS_API_ROOT + API_V2_SEND_WELCOME_EMAIL;
	}
	
	public static String getUpdateSecurityQuestionByToken(){
		return  LOGINRADIUS_API_ROOT + API_V2_UPDATE_SECURITY_QUESTION_BY_TOKEN;
		
	}
	
	
	public static String getDeleteAccountWithEmailConfirmation(){
		return  LOGINRADIUS_API_ROOT + API_V2_DELETE_ACCOUNT_WITH_EMAIL_CONFIRMATION;
		
	}
	
	
	public static String getForgotPasswordToken(){
		return  LOGINRADIUS_API_ROOT + API_V2_FORGOT_PASSWORD_TOKEN;
		
	}
	
	
	public static String getEmailVerificationToken(){
		return  LOGINRADIUS_API_ROOT + API_V2_EMAIL_VERIFICATION_TOKEN;
		
	}
	
	
	
	public static String getAccountIdentitiesByEmail(){
		return  LOGINRADIUS_API_ROOT + API_V2_ACCOUNT_IDENTITIES_BY_EMAIL;
		
	}
	
	
	
	
	
	

	/**
	 * Creates url after appending loginradius api root url and query parameters
	 * 
	 * @param url
	 *            url for appending to the api url
	 * @param queryArgs
	 *            extra parameters for sending with url
	 * @return complete url for fetching data
	 */
	public static String GetRequestUrl(String url, Map<String, String> queryArgs) {
		String keyvalueString = createKeyValueString(queryArgs);
		if (url.contains("?"))
			return url + "&" + keyvalueString;

		return url + "?" + keyvalueString;
	}

	/**
	 * Creates key-value string
	 * 
	 * @param queryArgs
	 *            parameters that will attach to the url
	 * @return query string with the given parameters
	 */
	public static String createKeyValueString(Map<String, String> queryArgs) {
		if (queryArgs != null) {
			String[] sb = new String[queryArgs.size()];
			int i = 0;
			for (Map.Entry<String, String> entry : queryArgs.entrySet()) {
				sb[i] = entry.getKey() + "=" + entry.getValue();
				i++;
			}
			return combine(sb, "&");
		} else
			return null;
	}

	/**
	 * Combine to create key-value string
	 * 
	 * @param s
	 *            Array String where the glue will be appended
	 * @param glue
	 *            String to be appended with Array String
	 * @return appended String
	 */
	public static String combine(String[] s, String glue) {
		int k = s.length;
		if (k == 0)
			return null;
		StringBuilder out = new StringBuilder();
		out.append(s[0]);
		for (int x = 1; x < k; ++x)
			out.append(glue).append(s[x]);
		return out.toString();
	}
}
