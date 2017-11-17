
package com.loginradius.sdk.models.configuration;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfigurationResponse {

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
    @SerializedName("IsAccessToken")
    @Expose
    private Boolean isAccessToken;
    @SerializedName("AppName")
    @Expose
    private String appName;
    @SerializedName("IsCustomerRegistration")
    @Expose
    private Boolean isCustomerRegistration;
    @SerializedName("EmailVerificationFlow")
    @Expose
    private String emailVerificationFlow;
    @SerializedName("IsPhoneLogin")
    @Expose
    private Boolean isPhoneLogin;
    @SerializedName("IsDisabledRegistration")
    @Expose
    private Boolean isDisabledRegistration;
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
    @SerializedName("EmailVerificationUrl")
    @Expose
    private String emailVerificationUrl;
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
    @SerializedName("PasswordLength")
    @Expose
    private PasswordLength passwordLength;
    @SerializedName("IsInvisibleRecaptcha")
    @Expose
    private Boolean isInvisibleRecaptcha;
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
    @SerializedName("NoRegistration")
    @Expose
    private Boolean noRegistration;

    public SocialSchema getSocialSchema() {
        return socialSchema;
    }

    public void setSocialSchema(SocialSchema socialSchema) {
        this.socialSchema = socialSchema;
    }

    public List<RegistrationFormSchema> getRegistrationFormSchema() {
        return registrationFormSchema;
    }

    public void setRegistrationFormSchema(List<RegistrationFormSchema> registrationFormSchema) {
        this.registrationFormSchema = registrationFormSchema;
    }

    public SecurityQuestions getSecurityQuestions() {
        return securityQuestions;
    }

    public void setSecurityQuestions(SecurityQuestions securityQuestions) {
        this.securityQuestions = securityQuestions;
    }

    public Boolean getIsHttps() {
        return isHttps;
    }

    public void setIsHttps(Boolean isHttps) {
        this.isHttps = isHttps;
    }

    public Boolean getIsAccessToken() {
        return isAccessToken;
    }

    public void setIsAccessToken(Boolean isAccessToken) {
        this.isAccessToken = isAccessToken;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Boolean getIsCustomerRegistration() {
        return isCustomerRegistration;
    }

    public void setIsCustomerRegistration(Boolean isCustomerRegistration) {
        this.isCustomerRegistration = isCustomerRegistration;
    }

    public String getEmailVerificationFlow() {
        return emailVerificationFlow;
    }

    public void setEmailVerificationFlow(String emailVerificationFlow) {
        this.emailVerificationFlow = emailVerificationFlow;
    }

    public Boolean getIsPhoneLogin() {
        return isPhoneLogin;
    }

    public void setIsPhoneLogin(Boolean isPhoneLogin) {
        this.isPhoneLogin = isPhoneLogin;
    }

    public Boolean getIsDisabledRegistration() {
        return isDisabledRegistration;
    }

    public void setIsDisabledRegistration(Boolean isDisabledRegistration) {
        this.isDisabledRegistration = isDisabledRegistration;
    }

    public Boolean getIsDisabledAccountLinking() {
        return isDisabledAccountLinking;
    }

    public void setIsDisabledAccountLinking(Boolean isDisabledAccountLinking) {
        this.isDisabledAccountLinking = isDisabledAccountLinking;
    }

    public Boolean getIsAgeRestriction() {
        return isAgeRestriction;
    }

    public void setIsAgeRestriction(Boolean isAgeRestriction) {
        this.isAgeRestriction = isAgeRestriction;
    }

    public Boolean getIsSecurityQuestion() {
        return isSecurityQuestion;
    }

    public void setIsSecurityQuestion(Boolean isSecurityQuestion) {
        this.isSecurityQuestion = isSecurityQuestion;
    }

    public Boolean getAskRequiredFieldsOnTraditionalLogin() {
        return askRequiredFieldsOnTraditionalLogin;
    }

    public void setAskRequiredFieldsOnTraditionalLogin(Boolean askRequiredFieldsOnTraditionalLogin) {
        this.askRequiredFieldsOnTraditionalLogin = askRequiredFieldsOnTraditionalLogin;
    }

    public String getEmailVerificationUrl() {
        return emailVerificationUrl;
    }

    public void setEmailVerificationUrl(String emailVerificationUrl) {
        this.emailVerificationUrl = emailVerificationUrl;
    }

    public Boolean getIsLogoutOnEmailVerification() {
        return isLogoutOnEmailVerification;
    }

    public void setIsLogoutOnEmailVerification(Boolean isLogoutOnEmailVerification) {
        this.isLogoutOnEmailVerification = isLogoutOnEmailVerification;
    }

    public Boolean getIsNoCallbackForSocialLogin() {
        return isNoCallbackForSocialLogin;
    }

    public void setIsNoCallbackForSocialLogin(Boolean isNoCallbackForSocialLogin) {
        this.isNoCallbackForSocialLogin = isNoCallbackForSocialLogin;
    }

    public Boolean getIsUserNameLogin() {
        return isUserNameLogin;
    }

    public void setIsUserNameLogin(Boolean isUserNameLogin) {
        this.isUserNameLogin = isUserNameLogin;
    }

    public Boolean getIsMobileCallbackForSocialLogin() {
        return isMobileCallbackForSocialLogin;
    }

    public void setIsMobileCallbackForSocialLogin(Boolean isMobileCallbackForSocialLogin) {
        this.isMobileCallbackForSocialLogin = isMobileCallbackForSocialLogin;
    }

    public PasswordLength getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(PasswordLength passwordLength) {
        this.passwordLength = passwordLength;
    }

    public Boolean getIsInvisibleRecaptcha() {
        return isInvisibleRecaptcha;
    }

    public void setIsInvisibleRecaptcha(Boolean isInvisibleRecaptcha) {
        this.isInvisibleRecaptcha = isInvisibleRecaptcha;
    }

    public Boolean getAskPasswordOnSocialLogin() {
        return askPasswordOnSocialLogin;
    }

    public void setAskPasswordOnSocialLogin(Boolean askPasswordOnSocialLogin) {
        this.askPasswordOnSocialLogin = askPasswordOnSocialLogin;
    }

    public Boolean getAskEmailIdForUnverifiedUserLogin() {
        return askEmailIdForUnverifiedUserLogin;
    }

    public void setAskEmailIdForUnverifiedUserLogin(Boolean askEmailIdForUnverifiedUserLogin) {
        this.askEmailIdForUnverifiedUserLogin = askEmailIdForUnverifiedUserLogin;
    }

    public Boolean getAskOptionalFieldsOnSocialSignup() {
        return askOptionalFieldsOnSocialSignup;
    }

    public void setAskOptionalFieldsOnSocialSignup(Boolean askOptionalFieldsOnSocialSignup) {
        this.askOptionalFieldsOnSocialSignup = askOptionalFieldsOnSocialSignup;
    }

    public Boolean getIsRiskBasedAuthentication() {
        return isRiskBasedAuthentication;
    }

    public void setIsRiskBasedAuthentication(Boolean isRiskBasedAuthentication) {
        this.isRiskBasedAuthentication = isRiskBasedAuthentication;
    }

    public Boolean getIsV2Recaptcha() {
        return isV2Recaptcha;
    }

    public void setIsV2Recaptcha(Boolean isV2Recaptcha) {
        this.isV2Recaptcha = isV2Recaptcha;
    }

    public IsInstantSignin getIsInstantSignin() {
        return isInstantSignin;
    }

    public void setIsInstantSignin(IsInstantSignin isInstantSignin) {
        this.isInstantSignin = isInstantSignin;
    }

    public Boolean getIsLoginOnEmailVerification() {
        return isLoginOnEmailVerification;
    }

    public void setIsLoginOnEmailVerification(Boolean isLoginOnEmailVerification) {
        this.isLoginOnEmailVerification = isLoginOnEmailVerification;
    }

    public TwoFactorAuthentication getTwoFactorAuthentication() {
        return twoFactorAuthentication;
    }

    public void setTwoFactorAuthentication(TwoFactorAuthentication twoFactorAuthentication) {
        this.twoFactorAuthentication = twoFactorAuthentication;
    }

    public Boolean getIsRememberMe() {
        return isRememberMe;
    }

    public void setIsRememberMe(Boolean isRememberMe) {
        this.isRememberMe = isRememberMe;
    }

    public String getV2RecaptchaSiteKey() {
        return v2RecaptchaSiteKey;
    }

    public void setV2RecaptchaSiteKey(String v2RecaptchaSiteKey) {
        this.v2RecaptchaSiteKey = v2RecaptchaSiteKey;
    }

    public Boolean getNoRegistration() {
        return noRegistration;
    }

    public void setNoRegistration(Boolean noRegistration) {
        this.noRegistration = noRegistration;
    }

}
