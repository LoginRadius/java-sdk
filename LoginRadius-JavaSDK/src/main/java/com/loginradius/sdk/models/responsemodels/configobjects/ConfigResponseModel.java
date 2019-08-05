
package com.loginradius.sdk.models.responsemodels.configobjects;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfigResponseModel {

	@SerializedName("SocialSchema")
	@Expose
	private SocialSchema socialSchema;
	@SerializedName("RegistrationFormSchema")
	@Expose
	private List<RegistrationFormSchema> registrationFormSchema = null;
	@SerializedName("SecurityQuestions")
	@Expose
	private SecurityQuestions securityQuestions;
	@SerializedName("IsHttps")
	@Expose
	private Boolean isHttps;
	@SerializedName("AppName")
	@Expose
	private String appName;
	@SerializedName("IsCustomerRegistration")
	@Expose
	private Boolean isCustomerRegistration;
	@SerializedName("ApiVersion")
	@Expose
	private ApiVersion apiVersion;
	@SerializedName("EmailVerificationFlow")
	@Expose
	private String emailVerificationFlow;
	@SerializedName("IsPhoneLogin")
	@Expose
	private Boolean isPhoneLogin;
	@SerializedName("IsDisabledSocialRegistration")
	@Expose
	private Boolean isDisabledSocialRegistration;
	@SerializedName("IsDisabledAccountLinking")
	@Expose
	private Boolean isDisabledAccountLinking;
	@SerializedName("IsAgeRestriction")
	@Expose
	private Boolean isAgeRestriction;
	@SerializedName("IsSecurityQuestion")
	@Expose
	private Boolean isSecurityQuestion;
	@SerializedName("AskRequiredFieldsOnTraditionalLogin")
	@Expose
	private Boolean askRequiredFieldsOnTraditionalLogin;
	@SerializedName("IsLogoutOnEmailVerification")
	@Expose
	private Boolean isLogoutOnEmailVerification;
	@SerializedName("IsNoCallbackForSocialLogin")
	@Expose
	private Boolean isNoCallbackForSocialLogin;
	@SerializedName("IsUserNameLogin")
	@Expose
	private Boolean isUserNameLogin;
	@SerializedName("IsMobileCallbackForSocialLogin")
	@Expose
	private Boolean isMobileCallbackForSocialLogin;
	@SerializedName("IsInvisibleRecaptcha")
	@Expose
	private Boolean isInvisibleRecaptcha;
	@SerializedName("IsBackendJobEnabled")
	@Expose
	private Boolean isBackendJobEnabled;
	@SerializedName("AskPasswordOnSocialLogin")
	@Expose
	private Boolean askPasswordOnSocialLogin;
	@SerializedName("AskEmailIdForUnverifiedUserLogin")
	@Expose
	private Boolean askEmailIdForUnverifiedUserLogin;
	@SerializedName("AskOptionalFieldsOnSocialSignup")
	@Expose
	private Boolean askOptionalFieldsOnSocialSignup;
	@SerializedName("IsRiskBasedAuthentication")
	@Expose
	private Boolean isRiskBasedAuthentication;
	@SerializedName("IsV2Recaptcha")
	@Expose
	private Boolean isV2Recaptcha;
	@SerializedName("CheckPhoneNoAvailabilityOnRegistration")
	@Expose
	private Boolean checkPhoneNoAvailabilityOnRegistration;
	@SerializedName("DuplicateEmailWithUniqueUsername")
	@Expose
	private Boolean duplicateEmailWithUniqueUsername;
	@SerializedName("StoreOnlyRegistrationFormFieldsForSocial")
	@Expose
	private Boolean storeOnlyRegistrationFormFieldsForSocial;
	@SerializedName("OTPEmailVerification")
	@Expose
	private Boolean oTPEmailVerification;
	@SerializedName("LoginLockedConfiguration")
	@Expose
	private LoginLockedConfiguration loginLockedConfiguration;
	@SerializedName("IsInstantSignin")
	@Expose
	private IsInstantSignin isInstantSignin;
	@SerializedName("IsLoginOnEmailVerification")
	@Expose
	private Boolean isLoginOnEmailVerification;
	@SerializedName("TwoFactorAuthentication")
	@Expose
	private TwoFactorAuthentication twoFactorAuthentication;
	@SerializedName("IsRememberMe")
	@Expose
	private Boolean isRememberMe;
	@SerializedName("V2RecaptchaSiteKey")
	@Expose
	private String v2RecaptchaSiteKey;
	@SerializedName("QQTencentCaptchaKey")
	@Expose
	private String qQTencentCaptchaKey;
	@SerializedName("NoRegistration")
	@Expose
	private Boolean noRegistration;
	@SerializedName("CustomDomain")
	@Expose
	private Object customDomain;
	@SerializedName("PrivacyPolicyConfiguration")
	@Expose
	private PrivacyPolicyConfiguration privacyPolicyConfiguration;
	@SerializedName("OptionalRecaptchaConfiguration")
	@Expose
	private OptionalRecaptchaConfiguration optionalRecaptchaConfiguration;
	@SerializedName("ApiRequestSigningConfig")
	@Expose
	private ApiRequestSigningConfig apiRequestSigningConfig;

	/// <summary>
	/// SocialSchema
	/// </summary>
	public SocialSchema getSocialSchema() {
		return socialSchema;
	}

	/// <summary>
	/// SocialSchema
	/// </summary>
	public void setSocialSchema(SocialSchema socialSchema) {
		this.socialSchema = socialSchema;
	}

	/// <summary>
	/// RegistrationFormSchema
	/// </summary>
	public List<RegistrationFormSchema> getRegistrationFormSchema() {
		return registrationFormSchema;
	}

	/// <summary>
	/// RegistrationFormSchema
	/// </summary>
	public void setRegistrationFormSchema(List<RegistrationFormSchema> registrationFormSchema) {
		this.registrationFormSchema = registrationFormSchema;
	}

	/// <summary>
	/// SecurityQuestions
	/// </summary>
	public SecurityQuestions getSecurityQuestions() {
		return securityQuestions;
	}

	/// <summary>
	/// SecurityQuestions
	/// </summary>
	public void setSecurityQuestions(SecurityQuestions securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	/// <summary>
	/// IsHttps
	/// </summary>
	public Boolean getIsHttps() {
		return isHttps;
	}

	/// <summary>
	/// IsHttps
	/// </summary>
	public void setIsHttps(Boolean isHttps) {
		this.isHttps = isHttps;
	}

	/// <summary>
	/// AppName
	/// </summary>
	public String getAppName() {
		return appName;
	}

	/// <summary>
	/// AppName
	/// </summary>
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/// <summary>
	/// IsCustomerRegistration
	/// </summary>
	public Boolean getIsCustomerRegistration() {
		return isCustomerRegistration;
	}

	/// <summary>
	/// IsCustomerRegistration
	/// </summary>
	public void setIsCustomerRegistration(Boolean isCustomerRegistration) {
		this.isCustomerRegistration = isCustomerRegistration;
	}

	/// <summary>
	/// ApiVersion
	/// </summary>
	public ApiVersion getApiVersion() {
		return apiVersion;
	}

	/// <summary>
	/// ApiVersion
	/// </summary>
	public void setApiVersion(ApiVersion apiVersion) {
		this.apiVersion = apiVersion;
	}

	/// <summary>
	/// EmailVerificationFlow
	/// </summary>
	public String getEmailVerificationFlow() {
		return emailVerificationFlow;
	}

	/// <summary>
	/// EmailVerificationFlow
	/// </summary>
	public void setEmailVerificationFlow(String emailVerificationFlow) {
		this.emailVerificationFlow = emailVerificationFlow;
	}

	/// <summary>
	/// IsPhoneLogin
	/// </summary>
	public Boolean getIsPhoneLogin() {
		return isPhoneLogin;
	}

	/// <summary>
	/// IsPhoneLogin
	/// </summary>
	public void setIsPhoneLogin(Boolean isPhoneLogin) {
		this.isPhoneLogin = isPhoneLogin;
	}

	/// <summary>
	/// IsDisabledSocialRegistration
	/// </summary>
	public Boolean getIsDisabledSocialRegistration() {
		return isDisabledSocialRegistration;
	}

	/// <summary>
	/// IsDisabledSocialRegistration
	/// </summary>
	public void setIsDisabledSocialRegistration(Boolean isDisabledSocialRegistration) {
		this.isDisabledSocialRegistration = isDisabledSocialRegistration;
	}

	/// <summary>
	/// IsDisabledAccountLinking
	/// </summary>
	public Boolean getIsDisabledAccountLinking() {
		return isDisabledAccountLinking;
	}

	/// <summary>
	/// IsDisabledAccountLinking
	/// </summary>
	public void setIsDisabledAccountLinking(Boolean isDisabledAccountLinking) {
		this.isDisabledAccountLinking = isDisabledAccountLinking;
	}

	/// <summary>
	/// IsAgeRestriction
	/// </summary>
	public Boolean getIsAgeRestriction() {
		return isAgeRestriction;
	}

	/// <summary>
	/// IsAgeRestriction
	/// </summary>
	public void setIsAgeRestriction(Boolean isAgeRestriction) {
		this.isAgeRestriction = isAgeRestriction;
	}

	/// <summary>
	/// IsSecurityQuestion
	/// </summary>
	public Boolean getIsSecurityQuestion() {
		return isSecurityQuestion;
	}

	/// <summary>
	/// IsSecurityQuestion
	/// </summary>
	public void setIsSecurityQuestion(Boolean isSecurityQuestion) {
		this.isSecurityQuestion = isSecurityQuestion;
	}

	/// <summary>
	/// AskRequiredFieldsOnTraditionalLogin
	/// </summary>
	public Boolean getAskRequiredFieldsOnTraditionalLogin() {
		return askRequiredFieldsOnTraditionalLogin;
	}

	/// <summary>
	/// AskRequiredFieldsOnTraditionalLogin
	/// </summary>
	public void setAskRequiredFieldsOnTraditionalLogin(Boolean askRequiredFieldsOnTraditionalLogin) {
		this.askRequiredFieldsOnTraditionalLogin = askRequiredFieldsOnTraditionalLogin;
	}

	/// <summary>
	/// IsLogoutOnEmailVerification
	/// </summary>
	public Boolean getIsLogoutOnEmailVerification() {
		return isLogoutOnEmailVerification;
	}

	/// <summary>
	/// IsLogoutOnEmailVerification
	/// </summary>
	public void setIsLogoutOnEmailVerification(Boolean isLogoutOnEmailVerification) {
		this.isLogoutOnEmailVerification = isLogoutOnEmailVerification;
	}

	/// <summary>
	/// IsNoCallbackForSocialLogin
	/// </summary>
	public Boolean getIsNoCallbackForSocialLogin() {
		return isNoCallbackForSocialLogin;
	}

	/// <summary>
	/// IsNoCallbackForSocialLogin
	/// </summary>
	public void setIsNoCallbackForSocialLogin(Boolean isNoCallbackForSocialLogin) {
		this.isNoCallbackForSocialLogin = isNoCallbackForSocialLogin;
	}

	/// <summary>
	/// IsUserNameLogin
	/// </summary>
	public Boolean getIsUserNameLogin() {
		return isUserNameLogin;
	}

	/// <summary>
	/// IsUserNameLogin
	/// </summary>
	public void setIsUserNameLogin(Boolean isUserNameLogin) {
		this.isUserNameLogin = isUserNameLogin;
	}

	/// <summary>
	/// IsMobileCallbackForSocialLogin
	/// </summary>
	public Boolean getIsMobileCallbackForSocialLogin() {
		return isMobileCallbackForSocialLogin;
	}

	/// <summary>
	/// IsMobileCallbackForSocialLogin
	/// </summary>
	public void setIsMobileCallbackForSocialLogin(Boolean isMobileCallbackForSocialLogin) {
		this.isMobileCallbackForSocialLogin = isMobileCallbackForSocialLogin;
	}

	/// <summary>
	/// IsInvisibleRecaptcha
	/// </summary>
	public Boolean getIsInvisibleRecaptcha() {
		return isInvisibleRecaptcha;
	}

	/// <summary>
	/// IsInvisibleRecaptcha
	/// </summary>
	public void setIsInvisibleRecaptcha(Boolean isInvisibleRecaptcha) {
		this.isInvisibleRecaptcha = isInvisibleRecaptcha;
	}

	/// <summary>
	/// IsBackendJobEnabled
	/// </summary>
	public Boolean getIsBackendJobEnabled() {
		return isBackendJobEnabled;
	}

	/// <summary>
	/// IsBackendJobEnabled
	/// </summary>
	public void setIsBackendJobEnabled(Boolean isBackendJobEnabled) {
		this.isBackendJobEnabled = isBackendJobEnabled;
	}

	/// <summary>
	/// AskPasswordOnSocialLogin
	/// </summary>
	public Boolean getAskPasswordOnSocialLogin() {
		return askPasswordOnSocialLogin;
	}

	/// <summary>
	/// AskPasswordOnSocialLogin
	/// </summary>
	public void setAskPasswordOnSocialLogin(Boolean askPasswordOnSocialLogin) {
		this.askPasswordOnSocialLogin = askPasswordOnSocialLogin;
	}

	/// <summary>
	/// AskEmailIdForUnverifiedUserLogin
	/// </summary>
	public Boolean getAskEmailIdForUnverifiedUserLogin() {
		return askEmailIdForUnverifiedUserLogin;
	}

	/// <summary>
	/// AskEmailIdForUnverifiedUserLogin
	/// </summary>
	public void setAskEmailIdForUnverifiedUserLogin(Boolean askEmailIdForUnverifiedUserLogin) {
		this.askEmailIdForUnverifiedUserLogin = askEmailIdForUnverifiedUserLogin;
	}

	/// <summary>
	/// AskOptionalFieldsOnSocialSignup
	/// </summary>
	public Boolean getAskOptionalFieldsOnSocialSignup() {
		return askOptionalFieldsOnSocialSignup;
	}

	/// <summary>
	/// AskOptionalFieldsOnSocialSignup
	/// </summary>
	public void setAskOptionalFieldsOnSocialSignup(Boolean askOptionalFieldsOnSocialSignup) {
		this.askOptionalFieldsOnSocialSignup = askOptionalFieldsOnSocialSignup;
	}

	/// <summary>
	/// IsRiskBasedAuthentication
	/// </summary>
	public Boolean getIsRiskBasedAuthentication() {
		return isRiskBasedAuthentication;
	}

	/// <summary>
	/// IsRiskBasedAuthentication
	/// </summary>
	public void setIsRiskBasedAuthentication(Boolean isRiskBasedAuthentication) {
		this.isRiskBasedAuthentication = isRiskBasedAuthentication;
	}

	/// <summary>
	/// IsV2Recaptcha
	/// </summary>
	public Boolean getIsV2Recaptcha() {
		return isV2Recaptcha;
	}

	/// <summary>
	/// IsV2Recaptcha
	/// </summary>
	public void setIsV2Recaptcha(Boolean isV2Recaptcha) {
		this.isV2Recaptcha = isV2Recaptcha;
	}

	/// <summary>
	/// CheckPhoneNoAvailabilityOnRegistration
	/// </summary>
	public Boolean getCheckPhoneNoAvailabilityOnRegistration() {
		return checkPhoneNoAvailabilityOnRegistration;
	}

	/// <summary>
	/// CheckPhoneNoAvailabilityOnRegistration
	/// </summary>
	public void setCheckPhoneNoAvailabilityOnRegistration(Boolean checkPhoneNoAvailabilityOnRegistration) {
		this.checkPhoneNoAvailabilityOnRegistration = checkPhoneNoAvailabilityOnRegistration;
	}

	/// <summary>
	/// DuplicateEmailWithUniqueUsername
	/// </summary>
	public Boolean getDuplicateEmailWithUniqueUsername() {
		return duplicateEmailWithUniqueUsername;
	}

	/// <summary>
	/// DuplicateEmailWithUniqueUsername
	/// </summary>
	public void setDuplicateEmailWithUniqueUsername(Boolean duplicateEmailWithUniqueUsername) {
		this.duplicateEmailWithUniqueUsername = duplicateEmailWithUniqueUsername;
	}

	/// <summary>
	/// StoreOnlyRegistrationFormFieldsForSocial
	/// </summary>
	public Boolean getStoreOnlyRegistrationFormFieldsForSocial() {
		return storeOnlyRegistrationFormFieldsForSocial;
	}

	/// <summary>
	/// StoreOnlyRegistrationFormFieldsForSocial
	/// </summary>
	public void setStoreOnlyRegistrationFormFieldsForSocial(Boolean storeOnlyRegistrationFormFieldsForSocial) {
		this.storeOnlyRegistrationFormFieldsForSocial = storeOnlyRegistrationFormFieldsForSocial;
	}

	/// <summary>
	/// OTPEmailVerification
	/// </summary>
	public Boolean getOTPEmailVerification() {
		return oTPEmailVerification;
	}

	/// <summary>
	/// OTPEmailVerification
	/// </summary>
	public void setOTPEmailVerification(Boolean oTPEmailVerification) {
		this.oTPEmailVerification = oTPEmailVerification;
	}

	/// <summary>
	/// LoginLockedConfiguration
	/// </summary>
	public LoginLockedConfiguration getLoginLockedConfiguration() {
		return loginLockedConfiguration;
	}

	/// <summary>
	/// LoginLockedConfiguration
	/// </summary>
	public void setLoginLockedConfiguration(LoginLockedConfiguration loginLockedConfiguration) {
		this.loginLockedConfiguration = loginLockedConfiguration;
	}

	/// <summary>
	/// IsInstantSignin
	/// </summary>
	public IsInstantSignin getIsInstantSignin() {
		return isInstantSignin;
	}

	/// <summary>
	/// IsInstantSignin
	/// </summary>
	public void setIsInstantSignin(IsInstantSignin isInstantSignin) {
		this.isInstantSignin = isInstantSignin;
	}

	/// <summary>
	/// IsLoginOnEmailVerification
	/// </summary>
	public Boolean getIsLoginOnEmailVerification() {
		return isLoginOnEmailVerification;
	}

	/// <summary>
	/// IsLoginOnEmailVerification
	/// </summary>
	public void setIsLoginOnEmailVerification(Boolean isLoginOnEmailVerification) {
		this.isLoginOnEmailVerification = isLoginOnEmailVerification;
	}

	/// <summary>
	/// TwoFactorAuthentication
	/// </summary>
	public TwoFactorAuthentication getTwoFactorAuthentication() {
		return twoFactorAuthentication;
	}

	/// <summary>
	/// TwoFactorAuthentication
	/// </summary>
	public void setTwoFactorAuthentication(TwoFactorAuthentication twoFactorAuthentication) {
		this.twoFactorAuthentication = twoFactorAuthentication;
	}

	/// <summary>
	/// IsRememberMe
	/// </summary>
	public Boolean getIsRememberMe() {
		return isRememberMe;
	}

	/// <summary>
	/// IsRememberMe
	/// </summary>
	public void setIsRememberMe(Boolean isRememberMe) {
		this.isRememberMe = isRememberMe;
	}

	/// <summary>
	/// V2RecaptchaSiteKey
	/// </summary>
	public String getV2RecaptchaSiteKey() {
		return v2RecaptchaSiteKey;
	}

	/// <summary>
	/// V2RecaptchaSiteKey
	/// </summary>
	public void setV2RecaptchaSiteKey(String v2RecaptchaSiteKey) {
		this.v2RecaptchaSiteKey = v2RecaptchaSiteKey;
	}

	/// <summary>
	/// QQTencentCaptchaKey
	/// </summary>
	public String getQQTencentCaptchaKey() {
		return qQTencentCaptchaKey;
	}

	/// <summary>
	/// QQTencentCaptchaKey
	/// </summary>
	public void setQQTencentCaptchaKey(String qQTencentCaptchaKey) {
		this.qQTencentCaptchaKey = qQTencentCaptchaKey;
	}

	/// <summary>
	/// NoRegistration
	/// </summary>
	public Boolean getNoRegistration() {
		return noRegistration;
	}

	/// <summary>
	/// NoRegistration
	/// </summary>
	public void setNoRegistration(Boolean noRegistration) {
		this.noRegistration = noRegistration;
	}

	/// <summary>
	/// CustomDomain
	/// </summary>
	public Object getCustomDomain() {
		return customDomain;
	}

	/// <summary>
	/// CustomDomain
	/// </summary>
	public void setCustomDomain(Object customDomain) {
		this.customDomain = customDomain;
	}

	/// <summary>
	/// PrivacyPolicyConfiguration
	/// </summary>
	public PrivacyPolicyConfiguration getPrivacyPolicyConfiguration() {
		return privacyPolicyConfiguration;
	}

	/// <summary>
	/// PrivacyPolicyConfiguration
	/// </summary>
	public void setPrivacyPolicyConfiguration(PrivacyPolicyConfiguration privacyPolicyConfiguration) {
		this.privacyPolicyConfiguration = privacyPolicyConfiguration;
	}

	/// <summary>
	/// OptionalRecaptchaConfiguration
	/// </summary>
	public OptionalRecaptchaConfiguration getOptionalRecaptchaConfiguration() {
		return optionalRecaptchaConfiguration;
	}

	/// <summary>
	/// OptionalRecaptchaConfiguration
	/// </summary>
	public void setOptionalRecaptchaConfiguration(OptionalRecaptchaConfiguration optionalRecaptchaConfiguration) {
		this.optionalRecaptchaConfiguration = optionalRecaptchaConfiguration;
	}

	/// <summary>
	/// ApiRequestSigningConfig
	/// </summary>
	public ApiRequestSigningConfig getApiRequestSigningConfig() {
		return apiRequestSigningConfig;
	}

	/// <summary>
	/// ApiRequestSigningConfig
	/// </summary>
	public void setApiRequestSigningConfig(ApiRequestSigningConfig apiRequestSigningConfig) {
		this.apiRequestSigningConfig = apiRequestSigningConfig;
	}

}
