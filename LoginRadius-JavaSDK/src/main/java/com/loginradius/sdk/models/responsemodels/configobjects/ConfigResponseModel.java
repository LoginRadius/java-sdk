
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

	/**
	 * SocialSchema
	 */
	public SocialSchema getSocialSchema() {
		return socialSchema;
	}

	/**
	 * SocialSchema
	 */
	public void setSocialSchema(SocialSchema socialSchema) {
		this.socialSchema = socialSchema;
	}

	/**
	 * RegistrationFormSchema
	 */
	public List<RegistrationFormSchema> getRegistrationFormSchema() {
		return registrationFormSchema;
	}

	/**
	 * RegistrationFormSchema
	 */
	public void setRegistrationFormSchema(List<RegistrationFormSchema> registrationFormSchema) {
		this.registrationFormSchema = registrationFormSchema;
	}

	/**
	 * SecurityQuestions
	 */
	public SecurityQuestions getSecurityQuestions() {
		return securityQuestions;
	}

	/**
	 * SecurityQuestions
	 */
	public void setSecurityQuestions(SecurityQuestions securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	/**
	 * IsHttps
	 */
	public Boolean getIsHttps() {
		return isHttps;
	}

	/**
	 * IsHttps
	 */
	public void setIsHttps(Boolean isHttps) {
		this.isHttps = isHttps;
	}

	/**
	 * AppName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * AppName
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * IsCustomerRegistration
	 */
	public Boolean getIsCustomerRegistration() {
		return isCustomerRegistration;
	}

	/**
	 * IsCustomerRegistration
	 */
	public void setIsCustomerRegistration(Boolean isCustomerRegistration) {
		this.isCustomerRegistration = isCustomerRegistration;
	}

	/**
	 * ApiVersion
	 */
	public ApiVersion getApiVersion() {
		return apiVersion;
	}

	/**
	 * ApiVersion
	 */
	public void setApiVersion(ApiVersion apiVersion) {
		this.apiVersion = apiVersion;
	}

	/**
	 * EmailVerificationFlow
	 */
	public String getEmailVerificationFlow() {
		return emailVerificationFlow;
	}

	/**
	 * EmailVerificationFlow
	 */
	public void setEmailVerificationFlow(String emailVerificationFlow) {
		this.emailVerificationFlow = emailVerificationFlow;
	}

	/**
	 * IsPhoneLogin
	 */
	public Boolean getIsPhoneLogin() {
		return isPhoneLogin;
	}

	/**
	 * IsPhoneLogin
	 */
	public void setIsPhoneLogin(Boolean isPhoneLogin) {
		this.isPhoneLogin = isPhoneLogin;
	}

	/**
	 * IsDisabledSocialRegistration
	 */
	public Boolean getIsDisabledSocialRegistration() {
		return isDisabledSocialRegistration;
	}

	/**
	 * IsDisabledSocialRegistration
	 */
	public void setIsDisabledSocialRegistration(Boolean isDisabledSocialRegistration) {
		this.isDisabledSocialRegistration = isDisabledSocialRegistration;
	}

	/**
	 * IsDisabledAccountLinking
	 */
	public Boolean getIsDisabledAccountLinking() {
		return isDisabledAccountLinking;
	}

	/**
	 * IsDisabledAccountLinking
	 */
	public void setIsDisabledAccountLinking(Boolean isDisabledAccountLinking) {
		this.isDisabledAccountLinking = isDisabledAccountLinking;
	}

	/**
	 * IsAgeRestriction
	 */
	public Boolean getIsAgeRestriction() {
		return isAgeRestriction;
	}

	/**
	 * IsAgeRestriction
	 */
	public void setIsAgeRestriction(Boolean isAgeRestriction) {
		this.isAgeRestriction = isAgeRestriction;
	}

	/**
	 * IsSecurityQuestion
	 */
	public Boolean getIsSecurityQuestion() {
		return isSecurityQuestion;
	}

	/**
	 * IsSecurityQuestion
	 */
	public void setIsSecurityQuestion(Boolean isSecurityQuestion) {
		this.isSecurityQuestion = isSecurityQuestion;
	}

	/**
	 * AskRequiredFieldsOnTraditionalLogin
	 */
	public Boolean getAskRequiredFieldsOnTraditionalLogin() {
		return askRequiredFieldsOnTraditionalLogin;
	}

	/**
	 * AskRequiredFieldsOnTraditionalLogin
	 */
	public void setAskRequiredFieldsOnTraditionalLogin(Boolean askRequiredFieldsOnTraditionalLogin) {
		this.askRequiredFieldsOnTraditionalLogin = askRequiredFieldsOnTraditionalLogin;
	}

	/**
	 * IsLogoutOnEmailVerification
	 */
	public Boolean getIsLogoutOnEmailVerification() {
		return isLogoutOnEmailVerification;
	}

	/**
	 * IsLogoutOnEmailVerification
	 */
	public void setIsLogoutOnEmailVerification(Boolean isLogoutOnEmailVerification) {
		this.isLogoutOnEmailVerification = isLogoutOnEmailVerification;
	}

	/**
	 * IsNoCallbackForSocialLogin
	 */
	public Boolean getIsNoCallbackForSocialLogin() {
		return isNoCallbackForSocialLogin;
	}

	/**
	 * IsNoCallbackForSocialLogin
	 */
	public void setIsNoCallbackForSocialLogin(Boolean isNoCallbackForSocialLogin) {
		this.isNoCallbackForSocialLogin = isNoCallbackForSocialLogin;
	}

	/**
	 * IsUserNameLogin
	 */
	public Boolean getIsUserNameLogin() {
		return isUserNameLogin;
	}

	/**
	 * IsUserNameLogin
	 */
	public void setIsUserNameLogin(Boolean isUserNameLogin) {
		this.isUserNameLogin = isUserNameLogin;
	}

	/**
	 * IsMobileCallbackForSocialLogin
	 */
	public Boolean getIsMobileCallbackForSocialLogin() {
		return isMobileCallbackForSocialLogin;
	}

	/**
	 * IsMobileCallbackForSocialLogin
	 */
	public void setIsMobileCallbackForSocialLogin(Boolean isMobileCallbackForSocialLogin) {
		this.isMobileCallbackForSocialLogin = isMobileCallbackForSocialLogin;
	}

	/**
	 * IsInvisibleRecaptcha
	 */
	public Boolean getIsInvisibleRecaptcha() {
		return isInvisibleRecaptcha;
	}

	/**
	 * IsInvisibleRecaptcha
	 */
	public void setIsInvisibleRecaptcha(Boolean isInvisibleRecaptcha) {
		this.isInvisibleRecaptcha = isInvisibleRecaptcha;
	}

	/**
	 * IsBackendJobEnabled
	 */
	public Boolean getIsBackendJobEnabled() {
		return isBackendJobEnabled;
	}

	/**
	 * IsBackendJobEnabled
	 */
	public void setIsBackendJobEnabled(Boolean isBackendJobEnabled) {
		this.isBackendJobEnabled = isBackendJobEnabled;
	}

	/**
	 * AskPasswordOnSocialLogin
	 */
	public Boolean getAskPasswordOnSocialLogin() {
		return askPasswordOnSocialLogin;
	}

	/**
	 * AskPasswordOnSocialLogin
	 */
	public void setAskPasswordOnSocialLogin(Boolean askPasswordOnSocialLogin) {
		this.askPasswordOnSocialLogin = askPasswordOnSocialLogin;
	}

	/**
	 * AskEmailIdForUnverifiedUserLogin
	 */
	public Boolean getAskEmailIdForUnverifiedUserLogin() {
		return askEmailIdForUnverifiedUserLogin;
	}

	/**
	 * AskEmailIdForUnverifiedUserLogin
	 */
	public void setAskEmailIdForUnverifiedUserLogin(Boolean askEmailIdForUnverifiedUserLogin) {
		this.askEmailIdForUnverifiedUserLogin = askEmailIdForUnverifiedUserLogin;
	}

	/**
	 * AskOptionalFieldsOnSocialSignup
	 */
	public Boolean getAskOptionalFieldsOnSocialSignup() {
		return askOptionalFieldsOnSocialSignup;
	}

	/**
	 * AskOptionalFieldsOnSocialSignup
	 */
	public void setAskOptionalFieldsOnSocialSignup(Boolean askOptionalFieldsOnSocialSignup) {
		this.askOptionalFieldsOnSocialSignup = askOptionalFieldsOnSocialSignup;
	}

	/**
	 * IsRiskBasedAuthentication
	 */
	public Boolean getIsRiskBasedAuthentication() {
		return isRiskBasedAuthentication;
	}

	/**
	 * IsRiskBasedAuthentication
	 */
	public void setIsRiskBasedAuthentication(Boolean isRiskBasedAuthentication) {
		this.isRiskBasedAuthentication = isRiskBasedAuthentication;
	}

	/**
	 * IsV2Recaptcha
	 */
	public Boolean getIsV2Recaptcha() {
		return isV2Recaptcha;
	}

	/**
	 * IsV2Recaptcha
	 */
	public void setIsV2Recaptcha(Boolean isV2Recaptcha) {
		this.isV2Recaptcha = isV2Recaptcha;
	}

	/**
	 * CheckPhoneNoAvailabilityOnRegistration
	 */
	public Boolean getCheckPhoneNoAvailabilityOnRegistration() {
		return checkPhoneNoAvailabilityOnRegistration;
	}

	/**
	 * CheckPhoneNoAvailabilityOnRegistration
	 */
	public void setCheckPhoneNoAvailabilityOnRegistration(Boolean checkPhoneNoAvailabilityOnRegistration) {
		this.checkPhoneNoAvailabilityOnRegistration = checkPhoneNoAvailabilityOnRegistration;
	}

	/**
	 * DuplicateEmailWithUniqueUsername
	 */
	public Boolean getDuplicateEmailWithUniqueUsername() {
		return duplicateEmailWithUniqueUsername;
	}

	/**
	 * DuplicateEmailWithUniqueUsername
	 */
	public void setDuplicateEmailWithUniqueUsername(Boolean duplicateEmailWithUniqueUsername) {
		this.duplicateEmailWithUniqueUsername = duplicateEmailWithUniqueUsername;
	}

	/**
	 * StoreOnlyRegistrationFormFieldsForSocial
	 */
	public Boolean getStoreOnlyRegistrationFormFieldsForSocial() {
		return storeOnlyRegistrationFormFieldsForSocial;
	}

	/**
	 * StoreOnlyRegistrationFormFieldsForSocial
	 */
	public void setStoreOnlyRegistrationFormFieldsForSocial(Boolean storeOnlyRegistrationFormFieldsForSocial) {
		this.storeOnlyRegistrationFormFieldsForSocial = storeOnlyRegistrationFormFieldsForSocial;
	}

	/**
	 * OTPEmailVerification
	 */
	public Boolean getOTPEmailVerification() {
		return oTPEmailVerification;
	}

	/**
	 * OTPEmailVerification
	 */
	public void setOTPEmailVerification(Boolean oTPEmailVerification) {
		this.oTPEmailVerification = oTPEmailVerification;
	}

	/**
	 * LoginLockedConfiguration
	 */
	public LoginLockedConfiguration getLoginLockedConfiguration() {
		return loginLockedConfiguration;
	}

	/**
	 * LoginLockedConfiguration
	 */
	public void setLoginLockedConfiguration(LoginLockedConfiguration loginLockedConfiguration) {
		this.loginLockedConfiguration = loginLockedConfiguration;
	}

	/**
	 * IsInstantSignin
	 */
	public IsInstantSignin getIsInstantSignin() {
		return isInstantSignin;
	}

	/**
	 * IsInstantSignin
	 */
	public void setIsInstantSignin(IsInstantSignin isInstantSignin) {
		this.isInstantSignin = isInstantSignin;
	}

	/**
	 * IsLoginOnEmailVerification
	 */
	public Boolean getIsLoginOnEmailVerification() {
		return isLoginOnEmailVerification;
	}

	/**
	 * IsLoginOnEmailVerification
	 */
	public void setIsLoginOnEmailVerification(Boolean isLoginOnEmailVerification) {
		this.isLoginOnEmailVerification = isLoginOnEmailVerification;
	}

	/**
	 * TwoFactorAuthentication
	 */
	public TwoFactorAuthentication getTwoFactorAuthentication() {
		return twoFactorAuthentication;
	}

	/**
	 * TwoFactorAuthentication
	 */
	public void setTwoFactorAuthentication(TwoFactorAuthentication twoFactorAuthentication) {
		this.twoFactorAuthentication = twoFactorAuthentication;
	}

	/**
	 * IsRememberMe
	 */
	public Boolean getIsRememberMe() {
		return isRememberMe;
	}

	/**
	 * IsRememberMe
	 */
	public void setIsRememberMe(Boolean isRememberMe) {
		this.isRememberMe = isRememberMe;
	}

	/**
	 * V2RecaptchaSiteKey
	 */
	public String getV2RecaptchaSiteKey() {
		return v2RecaptchaSiteKey;
	}

	/**
	 * V2RecaptchaSiteKey
	 */
	public void setV2RecaptchaSiteKey(String v2RecaptchaSiteKey) {
		this.v2RecaptchaSiteKey = v2RecaptchaSiteKey;
	}

	/**
	 * QQTencentCaptchaKey
	 */
	public String getQQTencentCaptchaKey() {
		return qQTencentCaptchaKey;
	}

	/**
	 * QQTencentCaptchaKey
	 */
	public void setQQTencentCaptchaKey(String qQTencentCaptchaKey) {
		this.qQTencentCaptchaKey = qQTencentCaptchaKey;
	}

	/**
	 * NoRegistration
	 */
	public Boolean getNoRegistration() {
		return noRegistration;
	}

	/**
	 * NoRegistration
	 */
	public void setNoRegistration(Boolean noRegistration) {
		this.noRegistration = noRegistration;
	}

	/**
	 * CustomDomain
	 */
	public Object getCustomDomain() {
		return customDomain;
	}

	/**
	 * CustomDomain
	 */
	public void setCustomDomain(Object customDomain) {
		this.customDomain = customDomain;
	}

	/**
	 * PrivacyPolicyConfiguration
	 */
	public PrivacyPolicyConfiguration getPrivacyPolicyConfiguration() {
		return privacyPolicyConfiguration;
	}

	/**
	 * PrivacyPolicyConfiguration
	 */
	public void setPrivacyPolicyConfiguration(PrivacyPolicyConfiguration privacyPolicyConfiguration) {
		this.privacyPolicyConfiguration = privacyPolicyConfiguration;
	}

	/**
	 * OptionalRecaptchaConfiguration
	 */
	public OptionalRecaptchaConfiguration getOptionalRecaptchaConfiguration() {
		return optionalRecaptchaConfiguration;
	}

	/**
	 * OptionalRecaptchaConfiguration
	 */
	public void setOptionalRecaptchaConfiguration(OptionalRecaptchaConfiguration optionalRecaptchaConfiguration) {
		this.optionalRecaptchaConfiguration = optionalRecaptchaConfiguration;
	}

	/**
	 * ApiRequestSigningConfig
	 */
	public ApiRequestSigningConfig getApiRequestSigningConfig() {
		return apiRequestSigningConfig;
	}

	/**
	 * ApiRequestSigningConfig
	 */
	public void setApiRequestSigningConfig(ApiRequestSigningConfig apiRequestSigningConfig) {
		this.apiRequestSigningConfig = apiRequestSigningConfig;
	}

}
