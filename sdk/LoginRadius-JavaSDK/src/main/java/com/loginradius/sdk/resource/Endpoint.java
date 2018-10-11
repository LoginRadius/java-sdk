package com.loginradius.sdk.resource;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright 2017 LoginRadius Inc. All rights reserved.
   
 */

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;




public class Endpoint {
	public static String LOGINRADIUS_API_ROOT;
	// AUTH
	private static final String AUTH_EMAIL = "/identity/v2/auth/email";
	private static final String AUTH_PASSWORD = "/identity/v2/auth/password";
	private static final String AUTH_REGISTER = "/identity/v2/auth/register";
	private static final String AUTH_LOGIN = "/identity/v2/auth/login";
	private static final String AUTH_USERNAME = "/identity/v2/auth/username";
	private static final String AUTH_ACCOUNT = "/identity/v2/auth/account";
	private static final String AUTH_PRIVACYPOLICY = "/identity/v2/auth/privacypolicy/accept";
	private static final String AUTH_SEND_WELCOME_EMAIL = "/identity/v2/auth/account/sendwelcomeemail";
	private static final String AUTH_SOCIAL_IDENTITY = "/identity/v2/auth/socialidentity";
	private static final String AUTH_VALIDATE_ACCESS_TOKEN = "/identity/v2/auth/access_token/validate";
	private static final String AUTH_INVALIDATE_ACCESS_TOKEN = "/identity/v2/auth/access_token/invalidate";
	private static final String AUTH_SECURITY_QUESTION = "/identity/v2/auth/securityquestion";
	private static final String AUTH_CHANGE_PASSWORD = "/identity/v2/auth/password/change";
	private static final String AUTH_RESET_PASSWORD  = "/identity/v2/auth/password/reset";
	private static final String AUTH_RESET_PASSWORD_BY_SECURITY_ANSWER = "/identity/v2/auth/password/securityanswer";
	private static final String AUTH_CUSTOMOBJECT = "/identity/v2/auth/customobject";

	// PHONE AUTH
	private static final String PHONE_AUTH = "/identity/v2/auth/phone";
	private static final String PHONE_AUTH_PASSWORD_OTP = "/identity/v2/auth/password/otp";
	private static final String PHONE_AUTH_VERIFICATION_OTP = "/identity/v2/auth/phone/otp";

	// ACCOUNT
	private static final String ACCOUNT_CREATE = "/identity/v2/manage/account";
	private static final String ACCOUNT_VERIFICATION_TOKEN = "/identity/v2/manage/account/verify/token";
	private static final String ACCOUNT_FORGOT_PASSWORD_TOKEN = "/identity/v2/manage/account/forgot/token";
	private static final String ACCOUNT_IDENTITIES = "/identity/v2/manage/account/identities";
	private static final String ACCOUNT_ACCESSTOKEN = "/identity/v2/manage/account/access_token";

	// SOCIAL
	private static final String SOCIAL_MESSAGE = "/api/v2/message";
	private static final String SOCIAL_STATUS = "/api/v2/status";
	private static final String SOCIAL_ACCESS_TOKEN = "/api/v2/access_token";
	private static final String SOCIAL_ALBUM = "/api/v2/album";
	private static final String SOCIAL_AUDIO = "/api/v2/audio";
	private static final String SOCIAL_CHECKIN = "/api/v2/checkin";
	private static final String SOCIAL_COMPANY = "/api/v2/company";
	private static final String SOCIAL_CONTACT = "/api/v2/contact";
	private static final String SOCIAL_EVENT = "/api/v2/event";
	private static final String SOCIAL_FOLLOWING = "/api/v2/following";
	private static final String SOCIAL_GROUP = "/api/v2/group";
	private static final String SOCIAL_LIKE = "/api/v2/like";
	private static final String SOCIAL_MENTION = "/api/v2/mention";
	private static final String SOCIAL_PAGE = "/api/v2/page";
	private static final String SOCIAL_PHOTO = "/api/v2/photo";
	private static final String SOCIAL_POST = "/api/v2/post";
	private static final String SOCIAL_VIDEO = "/api/v2/video";
	private static final String SOCIAL_USERPROFILE = "/api/v2/userprofile";

	// MFA
	private static final String MFA_LOGIN = "/identity/v2/auth/login/2fa";
	private static final String MFA_ACCOUNT = "/identity/v2/auth/account/2fa";
	private static final String MFA_ACCOUNT_BACKUPCODE = "/identity/v2/auth/account/2fa/backupcode";
	private static final String MFA_ACCOUNT_RESET_BACKUPCODE = "/identity/v2/auth/account/2fa/backupcode/reset";
	private static final String MFA_ACCOUNT_BACKUPCODE_BY_UID = "/identity/v2/manage/account/2fa/backupcode";
	private static final String MFA_ACCOUNT_RESET_BACKUPCODE_BY_UID = "/identity/v2/manage/account/2fa/backupcode/reset";
	private static final String MFA_VERIFY_BACKUPCODE = "/identity/v2/auth/login/2fa/verification/backupcode";
	private static final String MFA_VERIFY_OTP = "/identity/v2/auth/login/2fa/verification/otp";
	private static final String MFA_VERIFY_GOOGLEAUTHCODE = "/identity/v2/auth/login/2fa/verification/googleauthenticatorcode";
	private static final String MFA_ACCOUNT_VERIFY_GOOGLEAUTHCODE = "/identity/v2/auth/account/2fa/verification/googleauthenticatorcode";
	private static final String MFA_ACCOUNT_VERIFY_OTP = "/identity/v2/auth/account/2fa/verification/otp";
	private static final String MFA_RESET_AUTH_BY_TOKEN = "/identity/v2/auth/account/2fa/authenticator";
	private static final String MFA_RESET_AUTH_BY_UID = "/identity/v2/manage/account/2fa/authenticator";

	// SMART LOGIN
	private static final String AUTH_SMARTLOGIN  = "/identity/v2/auth/login/smartlogin";
	private static final String AUTH_SMARTLOGIN_PING  = "/identity/v2/auth/login/smartlogin/ping";
	private static final String AUTH_SMARTLOGIN_VERIFYTOKEN  = "/identity/v2/auth/email/smartlogin";

	// ONE TOUCH LOGIN
	private static final String ONETOUCH_LOGIN_BY_EMAIL  = "/identity/v2/auth/onetouchlogin/email";
	private static final String ONETOUCH_LOGIN_BY_PHONE  = "/identity/v2/auth/onetouchlogin/phone";
	private static final String ONETOUCH_OTP_VERIFICATION  = "/identity/v2/auth/onetouchlogin/phone/verify";

	// PASSWORDLESS LOGIN
	private static final String PASSWORDLESS_LOGIN_BY_EMAIL  = "/identity/v2/auth/login/passwordlesslogin/email";
	private static final String PASSWORDLESS_LOGIN_VERIFICATION  = "/identity/v2/auth/login/passwordlesslogin/email/verify";
	private static final String PASSWORDLESS_LOGIN_OTP  = "/identity/v2/auth/login/passwordlesslogin/otp";
	private static final String PASSWORDLESS_LOGIN_VERIFY_OTP  = "/identity/v2/auth/login/passwordlesslogin/otp/verify";

	// CONFIGURATION / INFRASTRUCTURE
	private static final String LOGINRADIUS_CONFIGURATION= "https://config.lrcontent.com/ciam/appinfo";
	private static final String LOGINRADIUS_SERVERTIME = "/identity/v2/serverinfo";
	private static final String LOGINRADIUS_GENERATE_SOTT = "/identity/v2/manage/account/sott";
	private static final String LOGINRADIUS_ACTIVE_SESSION_DETAILS = "/api/v2/access_token/activesession";

	// ROLES MANAGEMENT
	private static final String ROLE_MANAGEMENT = "/identity/v2/manage/role";

	// CUSTOM REGISTRATION DATA
	private static final String REGISTRATION_DATA_MANAGE = "/identity/v2/manage/registrationdata";
	private static final String REGISTRATION_DATA_AUTH = "/identity/v2/auth/registrationdata";

	// ADVANCED
	private static final String API_V2_WEBHOOK = "/api/v2/webhook";
	private static final String API_V2_ADVANCED_REFRESH_USERPROFILE = "/api/v2/userprofile/refresh";
	private static final String API_V2_ADVANCED_REFRESHTOKEN = "/api/v2/access_token/refresh";
	private static final String API_V2_ADVANCED_SHORTENURL = "/sharing/v1/shorturl";
	private static final String API_V2_ADVANCED_IDENTITY = "/api/v2/identity";
	private static final String API_V2_ADVANCED_AGGREGATION_QUERYDATA = "/api/v2/insights";
	private static final String API_V2_ADVANCED_SUBSCRIBE_RESTHOOKS = "/api/v2/resthook/subscribe";
	private static final String API_V2_ADVANCED_UNSUBSCRIBE_RESTHOOKS = "/api/v2/resthook/unsubscribe";
	private static final String API_V2_ADVANCED_TEST_RESTHOOKS_SETTINGS = "/api/v2/resthook/test";
	private static final String API_V2_ADVANCED_LIST_OF_RESTHOOKS = "/api/v2/resthook/fields";
	private static final String API_V2_ADVANCED_GET_SUBSCRIBED_URL = "/api/v2/resthook/subscription";
	private static final String API_V2_ADVANCED_ACCESSTOKEN_VIA_SOCIALTOKEN = "/api/v2/access_token";

	/**
	 * Creates complete API url after appending LoginRadius api root url
	 * 
	 * @return complete url for fetching data
	 * 
	 * 
	 */
	public static String getV2_ManagementCreateAccount() {
		return LOGINRADIUS_API_ROOT + ACCOUNT_CREATE;
	}

	public static String getV2_ManagementCreateCustomObject() {
		return LOGINRADIUS_API_ROOT + ACCOUNT_CREATE;
	}

	public static String getV2_ManagementCreateRole() {
		return LOGINRADIUS_API_ROOT + ROLE_MANAGEMENT;
	}

	public static String getV2_ManagementGetRoleContext() {
		return LOGINRADIUS_API_ROOT + ACCOUNT_CREATE;
	}

	public static String getV2_Management_GetAccessToken_By_Uid() {
		return LOGINRADIUS_API_ROOT + ACCOUNT_ACCESSTOKEN;
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
		return LOGINRADIUS_API_ROOT + REGISTRATION_DATA_MANAGE;
	}
	
	public static String getV2_AuthReadProfilesByToken() {
		return LOGINRADIUS_API_ROOT + AUTH_ACCOUNT;
	}

	public static String getV2_VIDEO() {
		return LOGINRADIUS_API_ROOT + SOCIAL_VIDEO;
	}

	public static String getV2_USERPROFILE() {
		return LOGINRADIUS_API_ROOT + SOCIAL_USERPROFILE;
	}

	public static String getV2_STATUS() {
		return LOGINRADIUS_API_ROOT + SOCIAL_STATUS;
	}

	public static String getV2_POST() {
		return LOGINRADIUS_API_ROOT + SOCIAL_POST;
	}

	public static String getV2_PHOTO() {
		return LOGINRADIUS_API_ROOT + SOCIAL_PHOTO;
	}

	public static String getV2_PAGE() {
		return LOGINRADIUS_API_ROOT + SOCIAL_PAGE;
	}

	public static String getV2_MESSAGE() {
		return LOGINRADIUS_API_ROOT + SOCIAL_MESSAGE;
	}

	public static String getV2_MENTION() {
		return LOGINRADIUS_API_ROOT + SOCIAL_MENTION;
	}

	public static String getV2_LIKE() {
		return LOGINRADIUS_API_ROOT + SOCIAL_LIKE;
	}

	public static String getV2_GROUP() {
		return LOGINRADIUS_API_ROOT + SOCIAL_GROUP;
	}

	public static String getV2_FOLLOWING() {
		return LOGINRADIUS_API_ROOT + SOCIAL_FOLLOWING;
	}

	public static String getV2_EVENT() {
		return LOGINRADIUS_API_ROOT + SOCIAL_EVENT;
	}

	public static String getV2_CONTACT() {
		return LOGINRADIUS_API_ROOT + SOCIAL_CONTACT;
	}

	public static String getV2_COMPANY() {
		return LOGINRADIUS_API_ROOT + SOCIAL_COMPANY;
	}

	public static String getV2_ALBUM() {
		return LOGINRADIUS_API_ROOT + SOCIAL_ALBUM;
	}

	public static String getV2_CHECKIN() {
		return LOGINRADIUS_API_ROOT + SOCIAL_CHECKIN;
	}

	public static String getV2_AUDIO() {
		return LOGINRADIUS_API_ROOT + SOCIAL_AUDIO;
	}

	public static String getLoginUrl() {
		return LOGINRADIUS_API_ROOT + AUTH_LOGIN;
	}

	public static String getUpdateProfileUrl() {
		return LOGINRADIUS_API_ROOT + AUTH_ACCOUNT;
	}

	public static String getRegistrationUrl() {
		return LOGINRADIUS_API_ROOT + AUTH_REGISTER;
	}

	public static String getVerifyotpUrl() {
		return LOGINRADIUS_API_ROOT + PHONE_AUTH_VERIFICATION_OTP;
	}

	public static String getUpdatephoneUrl() {
		return LOGINRADIUS_API_ROOT + PHONE_AUTH;
	}

	public static String getAddEmailUrl() {
		return LOGINRADIUS_API_ROOT + AUTH_EMAIL;
	}

	public static String getForgotPasswordUrlEmail() {
		return LOGINRADIUS_API_ROOT + AUTH_PASSWORD;
	}
	
	public static String getChangePasswordUrl() {
		return LOGINRADIUS_API_ROOT + AUTH_CHANGE_PASSWORD;
	}
	
	public static String getForgotPasswordUrlMobile() {
		return LOGINRADIUS_API_ROOT + PHONE_AUTH_PASSWORD_OTP;
	}

	public static String getConfigurationUrl() {
		return LOGINRADIUS_CONFIGURATION;
	}

	public static String getSocialIdentities() {
		return LOGINRADIUS_API_ROOT + AUTH_SOCIAL_IDENTITY;
	}

	public static String getExchangetoken() {
		return LOGINRADIUS_API_ROOT + SOCIAL_ACCESS_TOKEN;
	}

	public static String getUserNameAvailability() {
		return LOGINRADIUS_API_ROOT + AUTH_USERNAME;
	}

	public static String getCustomObject() {
		return LOGINRADIUS_API_ROOT + AUTH_CUSTOMOBJECT;
	}

	public static String getServerTime() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_SERVERTIME;
	}

	public static String getGenerateSott() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_GENERATE_SOTT;
	}

	public static String getActiveSessionDetails() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_ACTIVE_SESSION_DETAILS;
	}

	public static String getWebHook() {
		return LOGINRADIUS_API_ROOT + API_V2_WEBHOOK;
	}

	public static String get2FALogin() {
		return LOGINRADIUS_API_ROOT + MFA_LOGIN;
	}

	public static String getAccountVerifyOTP() {
		return LOGINRADIUS_API_ROOT + MFA_ACCOUNT_VERIFY_OTP;
	}
	
	public static String getVerifyByOtp() {
		return LOGINRADIUS_API_ROOT + MFA_VERIFY_OTP;
	}

	public static String get2FAByToken() {
		return LOGINRADIUS_API_ROOT + MFA_ACCOUNT;
	}

	public static String getVerifyGoogleAuthenticatorCode() {
		return LOGINRADIUS_API_ROOT + MFA_VERIFY_GOOGLEAUTHCODE;
	}

	public static String getAccountVerifyGoogleAuthenticatorCode() {
		return LOGINRADIUS_API_ROOT + MFA_ACCOUNT_VERIFY_GOOGLEAUTHCODE;
	}

	public static String getLoginByBackupcode() {
		return LOGINRADIUS_API_ROOT + MFA_VERIFY_BACKUPCODE;
	}

	public static String getBackupcode() {
		return LOGINRADIUS_API_ROOT + MFA_ACCOUNT_BACKUPCODE;
	}

	public static String getResetBackupcode() {
		return LOGINRADIUS_API_ROOT + MFA_ACCOUNT_RESET_BACKUPCODE;
	}

	public static String getBackupcodeByUid() {
		return LOGINRADIUS_API_ROOT + MFA_ACCOUNT_BACKUPCODE_BY_UID;
	}

	public static String getResetBackupcodeByUid() {
		return LOGINRADIUS_API_ROOT + MFA_ACCOUNT_RESET_BACKUPCODE_BY_UID;
	}

	public static String getResetMFAByToken() {
		return LOGINRADIUS_API_ROOT + MFA_RESET_AUTH_BY_TOKEN;
	}

	public static String getResetMFAByUid() {
		return LOGINRADIUS_API_ROOT + MFA_RESET_AUTH_BY_UID;
	}

	public static String getAuth_ValidateAccesstoken() {
		return LOGINRADIUS_API_ROOT + AUTH_VALIDATE_ACCESS_TOKEN;
	}

	public static String getAuth_InvalidateAccesstoken() {
		return LOGINRADIUS_API_ROOT + AUTH_INVALIDATE_ACCESS_TOKEN;
	}

	public static String getGetRegistrationData() {
		return LOGINRADIUS_API_ROOT + REGISTRATION_DATA_AUTH;
	}
	
	public static String getGetRegistrationData_Management() {
		return LOGINRADIUS_API_ROOT + REGISTRATION_DATA_MANAGE;
	}
	
	public static String getGetSecurityQuestionsByAccessToken() {
		return LOGINRADIUS_API_ROOT + AUTH_SECURITY_QUESTION;
	}
	
	public static String getResetPasswordbySecurityAnswer() {
		return LOGINRADIUS_API_ROOT + AUTH_RESET_PASSWORD_BY_SECURITY_ANSWER;
	}
	
	public static String getPrivacyPolicyAccept() {
		return LOGINRADIUS_API_ROOT + AUTH_PRIVACYPOLICY;
	}
	
	public static String getOneTouchLoginByEmail() {
		return LOGINRADIUS_API_ROOT + ONETOUCH_LOGIN_BY_EMAIL;
	}
	
	public static String getOneTouchLoginByPhone() {
		return LOGINRADIUS_API_ROOT + ONETOUCH_LOGIN_BY_PHONE;
	}
	
	public static String getOneTouchOtpVerification() {
		return LOGINRADIUS_API_ROOT + ONETOUCH_OTP_VERIFICATION;
	}
	
	public static String getPasswordlessLogin() {
		return LOGINRADIUS_API_ROOT + PASSWORDLESS_LOGIN_BY_EMAIL;
	}
	
	public static String getPasswordlessLoginVerification() {
		return LOGINRADIUS_API_ROOT + PASSWORDLESS_LOGIN_VERIFICATION;
	}
	
	public static String getPhoneLoginByOneTimePassCode() {
		return LOGINRADIUS_API_ROOT + PASSWORDLESS_LOGIN_VERIFY_OTP;
	}

	public static String getPhoneSendOneTimePassCode() {
		return LOGINRADIUS_API_ROOT + PASSWORDLESS_LOGIN_OTP;
	}

	public static String getSmartLogin() {
		return LOGINRADIUS_API_ROOT + AUTH_SMARTLOGIN;
	}
	
	public static String getSmartLoginPing() {
		return LOGINRADIUS_API_ROOT + AUTH_SMARTLOGIN_PING;
	}

	public static String getSmartLoginVerifyToken() {
		return LOGINRADIUS_API_ROOT + AUTH_SMARTLOGIN_VERIFYTOKEN;
	}

	public static String getVerifyEmailByOtp() {
		return LOGINRADIUS_API_ROOT + AUTH_EMAIL;
	}

	public static String getResetPasswordByOtp() {
		return LOGINRADIUS_API_ROOT + AUTH_RESET_PASSWORD;
	}

	public static String getSendWelcomeEmail() {
		return LOGINRADIUS_API_ROOT + AUTH_SEND_WELCOME_EMAIL;
	}

	public static String getUpdateSecurityQuestionByToken(){
		return  LOGINRADIUS_API_ROOT + AUTH_ACCOUNT;
	}

	public static String getDeleteAccountWithEmailConfirmation(){
		return  LOGINRADIUS_API_ROOT + AUTH_ACCOUNT;
	}

	public static String getForgotPasswordToken(){
		return  LOGINRADIUS_API_ROOT + ACCOUNT_FORGOT_PASSWORD_TOKEN;
	}

	public static String getEmailVerificationToken(){
		return  LOGINRADIUS_API_ROOT + ACCOUNT_VERIFICATION_TOKEN;
	}

	public static String getAccountIdentitiesByEmail(){
		return  LOGINRADIUS_API_ROOT + ACCOUNT_IDENTITIES;
	}

	public static Map<String, EndpointContent> authenticationAPILookUp() {
		Map<String, EndpointContent> map = new HashMap<String, EndpointContent>();

		// GET APIs ============================================================
		map.put("checkemailavailability", new EndpointContent(getAddEmailUrl(), false));
		map.put("checkusernameavailability", new EndpointContent(getUserNameAvailability(), false));
		map.put("readaccountbytoken", new EndpointContent(getV2_AuthReadProfilesByToken(), true));
		map.put("privacypolicy", new EndpointContent(getPrivacyPolicyAccept(), true));
		map.put("sendwelcomeemail", new EndpointContent(getSendWelcomeEmail(), true));
		map.put("getsocialidentity", new EndpointContent(getSocialIdentities(), true));
		map.put("validateaccesstoken", new EndpointContent(getAuth_ValidateAccesstoken(), false));
		map.put("verifyemail", new EndpointContent(getAddEmailUrl(), false));
		map.put("getdeleteaccount", new EndpointContent(getUpdateProfileUrl() + "/delete", false));
		map.put("invalidateaccesstoken", new EndpointContent(getAuth_InvalidateAccesstoken(), false));
		map.put("securityquestionsbyaccesstoken", new EndpointContent(getGetSecurityQuestionsByAccessToken() + "/accesstoken", true));
		map.put("securityquestionsbyemail", new EndpointContent(getGetSecurityQuestionsByAccessToken() + "/email", false));
		map.put("securityquestionsbyusername", new EndpointContent(getGetSecurityQuestionsByAccessToken() + "/username", false));
		map.put("securityquestionsbyphone", new EndpointContent(getGetSecurityQuestionsByAccessToken() + "/phone", false));
		map.put("album", new EndpointContent(getV2_ALBUM(), true));
		map.put("contact", new EndpointContent(getV2_CONTACT(), true));
		map.put("company", new EndpointContent(getV2_COMPANY(), true));
		map.put("event", new EndpointContent(getV2_EVENT(), true));
		map.put("group", new EndpointContent(getV2_GROUP(), true));
		map.put("like", new EndpointContent(getV2_LIKE(), true));
		map.put("getstatus", new EndpointContent(getV2_STATUS(), true));
		map.put("checkin", new EndpointContent(getV2_CHECKIN(), true));
		map.put("audio", new EndpointContent(getV2_AUDIO(), true));
		map.put("video", new EndpointContent(getV2_VIDEO(), true));
		map.put("photo", new EndpointContent(getV2_PHOTO(), true));
		map.put("post", new EndpointContent(getV2_POST(), true));
		map.put("page", new EndpointContent(getV2_PAGE(), true));
		map.put("following", new EndpointContent(getV2_FOLLOWING(), true));
		map.put("mention", new EndpointContent(getV2_MENTION(), true));
		map.put("getmessage", new EndpointContent(getV2_MESSAGE() + "/js", true));
		map.put("userprofile", new EndpointContent(getV2_USERPROFILE(), true));
		map.put("getstatusposting", new EndpointContent(getV2_STATUS() + "/js", true));
		map.put("customobjectbytoken", new EndpointContent(getCustomObject(), true));
		map.put("customobjectbyid", new EndpointContent(getCustomObject() + "/{{objectrecordid}}", true, "objectrecordid"));
		map.put("loginbyphone", new EndpointContent(getLoginUrl(), false));
		map.put("phoneavailability", new EndpointContent(getUpdatephoneUrl(), false));
		map.put("2FAbyToken", new EndpointContent(get2FAByToken(), true));
		map.put("2FAGetBackupcode", new EndpointContent(getBackupcode(), true));
		map.put("2FAResetBackupcode", new EndpointContent(getResetBackupcode(), true));
		map.put("smartlogin", new EndpointContent(getSmartLogin(), false));
		map.put("smartloginping", new EndpointContent(getSmartLoginPing(), false));
		map.put("smartloginverifytoken", new EndpointContent(getSmartLoginVerifyToken(), false));
		map.put("passwordlesslogin", new EndpointContent(getPasswordlessLogin(), false));
		map.put("passwordlessloginverification", new EndpointContent(getPasswordlessLoginVerification(), false));
		map.put("phonsendonetimepasscode", new EndpointContent(getPhoneSendOneTimePassCode(), false));
		map.put("configuration", new EndpointContent(getConfigurationUrl(), false));
		map.put("servertime", new EndpointContent(getServerTime(), false));
		map.put("getregistrationdata", new EndpointContent(getGetRegistrationData() + "/{{type}}", false, "type"));

		// POST APIs ============================================================
		map.put("addemail", new EndpointContent(getAddEmailUrl(), true));
		map.put("forgotpasswordbyemail", new EndpointContent(getForgotPasswordUrlEmail(), false));
		map.put("register", new EndpointContent(getRegistrationUrl(), false));
		map.put("emaillogin", new EndpointContent(getLoginUrl(), false));
		map.put("usernamelogin", new EndpointContent(getLoginUrl(), false));
		map.put("postmessage", new EndpointContent(getV2_MESSAGE(), true));
		map.put("poststatus", new EndpointContent(getV2_STATUS(), true));
		map.put("createcustomobject", new EndpointContent(getCustomObject(), true));
		map.put("postloginbyphone", new EndpointContent(getLoginUrl(), false));
		map.put("forgotpasswordbyotp", new EndpointContent(getForgotPasswordUrlMobile(), false));
		map.put("resendotp", new EndpointContent(getVerifyotpUrl(), false));
		map.put("resendotpbytoken", new EndpointContent(getVerifyotpUrl(), true));
		map.put("2FALogin", new EndpointContent(get2FALogin(), false));
		map.put("onetouchloginbyemail", new EndpointContent(getOneTouchLoginByEmail(), false));
		map.put("onetouchloginbyphone", new EndpointContent(getOneTouchLoginByPhone(), false));
		map.put("validatesecretcode", new EndpointContent(getGetRegistrationData() + "/validatecode", false));

		// PUT APIs ============================================================
		map.put("verifyemailbyotp", new EndpointContent(getVerifyEmailByOtp(), false));
		map.put("changepassword", new EndpointContent(getChangePasswordUrl(), true));
		map.put("linksocialidentities", new EndpointContent(getSocialIdentities(), false));
		map.put("resendemailverification", new EndpointContent(getRegistrationUrl(), false));
		map.put("resetpassword", new EndpointContent(getResetPasswordByOtp(), false));
		map.put("resetpasswordbyotp", new EndpointContent(getResetPasswordByOtp(), false));
		map.put("resetpasswordbysecurityanswer", new EndpointContent(getResetPasswordbySecurityAnswer(), false));
		map.put("changeusername", new EndpointContent(getUserNameAvailability(), true));
		map.put("updateaccountbytoken", new EndpointContent(getUpdateProfileUrl(), true));
		map.put("updatesecurityquestion", new EndpointContent(getUpdateSecurityQuestionByToken(), true));
		map.put("updateobjectbyrecordid", new EndpointContent(getCustomObject() + "/{{objectrecordid}}", true, "objectrecordid"));
		map.put("updatephone", new EndpointContent(getUpdatephoneUrl(), true));
		map.put("phoneresetpasswordbyotp", new EndpointContent(getForgotPasswordUrlMobile(), false));
		map.put("verifyotp", new EndpointContent(getVerifyotpUrl(), false));
		map.put("verifyotpbytoken", new EndpointContent(getVerifyotpUrl(), true));
		map.put("2FALoginByBackupcode", new EndpointContent(getLoginByBackupcode(), false));
		map.put("2FAValidateOtp", new EndpointContent(getVerifyByOtp(), false));
		map.put("2FAVerifybyGoogleAuthenticator", new EndpointContent(getVerifyGoogleAuthenticatorCode(), false));
		map.put("2FAUpdatePhoneNumber", new EndpointContent(get2FALogin(), false));
		map.put("2FAUpdatePhoneNumberbyToken", new EndpointContent(get2FAByToken(), true));
		map.put("2FAAccountVerifybyGoogleAuthenticator", new EndpointContent(getAccountVerifyGoogleAuthenticatorCode(), true));
		map.put("2FAUpdateSetting", new EndpointContent(getAccountVerifyOTP(), true));
		map.put("onetouchotp", new EndpointContent(getOneTouchOtpVerification(), false));
		map.put("phoneloginusingonetimepasscode", new EndpointContent(getPhoneLoginByOneTimePassCode(), false));

		// DEL APIs ============================================================
		map.put("deleteaccountwithemailconfirmation", new EndpointContent(getDeleteAccountWithEmailConfirmation(), true));
		map.put("removeemail", new EndpointContent(getAddEmailUrl(), true));
		map.put("unlinksocialidentities", new EndpointContent(getSocialIdentities(), false));
		map.put("deletecustomobject", new EndpointContent(getCustomObject() + "/{{objectrecordid}}", true, "objectrecordid"));
		map.put("removephonebyaccesstoken", new EndpointContent(getUpdatephoneUrl(), true));
		map.put("2FAResetByToken", new EndpointContent(getResetMFAByToken(), true));

		return map;
	}

	public static Map<String, EndpointContent> managementAPILookUp() {
		Map<String, EndpointContent> map = new HashMap<String, EndpointContent>();

		// GET APIs ============================================================
		map.put("accountidentitiesbyemail", new EndpointContent(getAccountIdentitiesByEmail(), false));
		map.put("accesstokenbyuid", new EndpointContent(getV2_Management_GetAccessToken_By_Uid(), false));
		map.put("getpassword", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/password", false, "uid"));
		map.put("accountprofilesbyemail", new EndpointContent(getV2_ManagementCreateAccount(), false));
		map.put("accountprofilesbyusername", new EndpointContent(getV2_ManagementCreateAccount(), false));
		map.put("accountprofilesbyphone", new EndpointContent(getV2_ManagementCreateAccount(), false));
		map.put("accountprofilesbyuid", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}", false, "uid"));
		map.put("customobjectbyuid", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/customobject", false, "uid"));
		map.put("customobjectbyid", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/customobject/{{objectrecordid}}", false, "uid", "objectrecordid"));
		map.put("2FAGetBackupcodeByUid", new EndpointContent(getBackupcodeByUid(), false));
		map.put("2FAResetBackupcodeByUid", new EndpointContent(getResetBackupcodeByUid(), false));
		map.put("generatesott", new EndpointContent(getGenerateSott(), false));
		map.put("getrolecontext", new EndpointContent(getV2_ManagementGetRoleContext() + "/{{uid}}/rolecontext", false, "uid"));
		map.put("getrole", new EndpointContent(getV2_ManagementCreateRole(), false));
		map.put("getrolesbyuid", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/role", false, "uid"));
		map.put("getregistrationdata", new EndpointContent(getGetRegistrationData_Management() + "/{{type}}", false, "type"));

		// POST APIs ============================================================
		map.put("createaccount", new EndpointContent(getV2_ManagementCreateAccount(), false));
		map.put("emailverificationtoken", new EndpointContent(getEmailVerificationToken(), false));
		map.put("forgotpasswordtoken", new EndpointContent(getForgotPasswordToken(), false));
		map.put("createcustomobject", new EndpointContent(getV2_ManagementCreateCustomObject() + "/{{uid}}/customobject", false, "uid"));
		map.put("createrole", new EndpointContent(getV2_ManagementCreateRole(), false));
		map.put("addregistrationdata", new EndpointContent(getV2_AddRegistrationData(), false));

		// PUT APIs ============================================================
		map.put("setpassword", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/password", false, "uid"));
		map.put("updateaccount", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}", false, "uid"));
		map.put("accountupdatesecurityquestion", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}", false, "uid"));
		map.put("accountinvalidateverificationemail", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/invalidateemail", false, "uid"));
		map.put("updateobjectbyrecordid", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/customobject/{{objectrecordid}}", false, "uid", "objectrecordid"));
		map.put("resetphoneidverification", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/invalidatephone", false, "uid"));
		map.put("addpermissionstorole", new EndpointContent(getV2_ManagementCreateRole() + "/{{role}}/permission", false, "role"));
		map.put("assignroles", new EndpointContent(getV2_ManagementCreateCustomObject() + "/{{uid}}/role", false, "uid"));
		map.put("addrolecontext", new EndpointContent(getV2_ManagementGetRoleContext() + "/{{uid}}/rolecontext", false, "uid"));
		map.put("updateregistrationdata", new EndpointContent(getGetRegistrationData_Management() + "/{{recordid}}", false, "recordid"));

		// DEL APIs ============================================================
		map.put("removeemail", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/email", false, "uid"));
		map.put("deleteaccount", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}", false, "uid"));
		map.put("deletecustomobjectbyid", new EndpointContent(getV2_ManagementCreateAccount() + "/{{uid}}/customobject/{{objectrecordid}}", false, "uid", "objectrecordid"));
		map.put("2FAResetByUid", new EndpointContent(getResetMFAByUid(), false));
		map.put("deleterole", new EndpointContent(getV2_ManagementCreateRole() + "/{{role}}", false, "role"));
		map.put("unassignrolesbyuid", new EndpointContent(getV2_ManagementGetRoleContext() + "/{{uid}}/role", false, "uid"));
		map.put("removepermissions", new EndpointContent(getV2_ManagementCreateRole() + "/{{role_name}}/permission", false, "role_name"));
		map.put("deletecontext", new EndpointContent(getV2_ManagementGetRoleContext() + "/{{uid}}/rolecontext/{{rolecontextname}}", false, "uid", "rolecontextname"));
		map.put("deleterolefromcontext", new EndpointContent(getV2_ManagementGetRoleContext() + "/{{uid}}/rolecontext/{{rolecontextname}}/role", false, "uid", "rolecontextname"));
		map.put("deleteroleandpermission", new EndpointContent(getV2_ManagementGetRoleContext() + "/{{uid}}/rolecontext/{{rolecontextname}}/additionalpermission", false, "uid", "rolecontextname"));
		map.put("deleteregistrationdata", new EndpointContent(getGetRegistrationData_Management() + "/{{recordid}}", false, "recordid"));
		map.put("deletebydatasource", new EndpointContent(getGetRegistrationData_Management() + "/type/{{type}}", false, "type"));
		map.put("webhookunsubscribe", new EndpointContent(getWebHook(), false));

		return map;
	}

	public static Map<String, EndpointContent> advancedAPILookUp() {
		Map<String, EndpointContent> map = new HashMap<String, EndpointContent>();

		// GET APIs ============================================================
		map.put("socialexchangeaccesstoken", new EndpointContent(null, "secret", getExchangetoken(), false));
		map.put("tokenvalidate", new EndpointContent("key", "secret", getExchangetoken() + "/validate", true));
		map.put("tokeninvalidate", new EndpointContent("key", "secret", getExchangetoken() + "/invalidate", true));
		map.put("getactivesession", new EndpointContent("key", "secret", getActiveSessionDetails(), true));
		map.put("accesstokenviafbtoken", new EndpointContent("key", null, getV2_AdvancedAccessTokenViaSocialToken() + "/facebook", false));
		map.put("accesstokenviatwtoken", new EndpointContent("key", null, getV2_AdvancedAccessTokenViaSocialToken() + "/twitter", false));
		map.put("accesstokenviavktoken", new EndpointContent("key", null, getV2_AdvancedAccessTokenViaSocialToken() + "/vkontakte", false));
		map.put("accesstokenviagooglejwt", new EndpointContent("key", null, getV2_AdvancedAccessTokenViaSocialToken() + "/googlejwt", false));
		map.put("refreshprofile", new EndpointContent(getV2_AdvancedRefreshUserProfile(), true));
		map.put("refreshtoken", new EndpointContent(null, "secret", getV2_AdvancedRefreshToken(), true));
		map.put("shortenURL", new EndpointContent("key", null, getV2_AdvancedShortenURL(), false));
		map.put("testresthookssettings", new EndpointContent("api_key", "api_secret", getV2_AdvancedRestHooksSettings(), false));
		map.put("listofresthooks", new EndpointContent("api_key", "api_secret", getV2_AdvancedListofRestHooks(), false));
		map.put("getsubscribedurl", new EndpointContent("api_key", "api_secret", getV2_AdvancedGetSubscribedurl(), false));
		map.put("trackablestatusfetching", new EndpointContent(null, "secret", getV2_STATUS() + "/trackable", false));
		map.put("gettrackablestatusstats", new EndpointContent(getV2_STATUS() + "/trackable/js", true));
		map.put("webhooktest", new EndpointContent("apikey", "apisecret", getWebHook() + "/test", false));
		map.put("webhooksubscribedurls", new EndpointContent("apikey", "apisecret", getWebHook(), false));

		// POST APIs ============================================================
		map.put("getsocialidentity", new EndpointContent("key", "secret", getV2_AdvancedIdentity(), false));
		map.put("querydata", new EndpointContent("apikey", "apisecret", getV2_AdvancedQueryData(), false));
		map.put("subscriberesthooks", new EndpointContent("api_key", "api_secret", getV2_AdvancedSubscribeRestHooks(), false));
		map.put("unsubscriberesthooks", new EndpointContent("api_key", "api_secret", getV2_AdvancedUnsubscribeRestHooks(), false));
		map.put("trackablestatusposting", new EndpointContent(getV2_STATUS() + "/trackable", true));
		map.put("webhooksubscribe", new EndpointContent("apikey", "apisecret", getWebHook(), false));

		return map;
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

	/**
	 * Replaces placeholders in path String if necessary
	 *
	 * @param path path for endpoint
	 * @param map input parameter map
	 * @return String with placeholders replaced (if necessary)
	 */
	public static String getFinalPath(String path, Map<String, String> map) {
		String finalPath = path;
		Map<String, String> data = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		if (map != null && !map.isEmpty()) {
			data.putAll(map);
		}
		if (isPlaceholders(path)) {
			finalPath = replacePlaceholders(path, data);
		}
		return finalPath;
	}

	/**
	 * Checks whether a path contains a placeholder in the form {{...}}
	 *
	 * @param path			path to check
	 * @return true if contains placeholder, otherwise false
	 */
	private static Boolean isPlaceholders(String path) {
		return path.contains("{{") && path.contains("}}");
	}

	/**
	 * Replaces placeholders in the form {{...}} with the corresponding field.
	 *		ensures map values with {{ | }} will not effect the result
	 *
	 * @param path			path containing placeholders
	 * @param data 			map containing field value (pass treemap for map with case-insensitive keys)
	 * @return string with placeholders replaced
	 */
	private static String replacePlaceholders(String path, Map<String, String> data) {
		String res = path;
		String[] arr = res.split("/");
		for (int i=0; i < arr.length; i++) {
			if (isPlaceholders(arr[i])) {
				String field = arr[i].substring(arr[i].indexOf("{{") + 2, arr[i].indexOf("}}"));
				arr[i] = data.get(field);
			}
		}
		return join(arr);
	}
	
	/**
	 * Join array of strings with delimitor "/"
	 *
	 * @param arr
	 * @return string
	 */
	private static String join(String[] arr) {
		String res = "";
		for (int i=0; i < arr.length; i++) {
			res += arr[i];
			if (i != arr.length - 1) {
				res += "/";
			}
		}
		return res;
	}
}