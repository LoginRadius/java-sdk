/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.responsemodels.ConsentProfile;
import com.loginradius.sdk.models.responsemodels.otherobjects.PINInformation;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.AcceptedPrivacyPolicy;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Email;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.ExternalIds;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.RegistrationData;

	/**
	 * Response containing Definition for Complete UserProfile data
	 */
	public class UserProfile extends SocialUserProfile {
	
		
		@SerializedName("ConsentProfile")
        private ConsentProfile consentProfile;
		
		@SerializedName("CustomFields")
        private Map<String,String> customFields;
		
		@SerializedName("EmailVerified")
        private Boolean emailVerified;
		
		@SerializedName("ExternalIds")
        private List<ExternalIds> externalIds;
		
		@SerializedName("ExternalUserLoginId")
        private String externalUserLoginId;
		
		@SerializedName("IsActive")
        private Boolean isActive;
		
		@SerializedName("IsCustomUid")
        private Boolean isCustomUid;
		
		@SerializedName("IsDeleted")
        private Boolean isDeleted;
		
		@SerializedName("IsEmailSubscribed")
        private Boolean isEmailSubscribed;
		
		@SerializedName("IsLoginLocked")
        private Boolean isLoginLocked;
		
		@SerializedName("IsRequiredFieldsFilledOnce")
        private Boolean isRequiredFieldsFilledOnce;
		
		@SerializedName("IsSecurePassword")
        private Boolean isSecurePassword;
		
		@SerializedName("LastLoginLocation")
        private String lastLoginLocation;
		
		@SerializedName("LastPasswordChangeDate")
        private String lastPasswordChangeDate;
		
		@SerializedName("LastPasswordChangeToken")
        private String lastPasswordChangeToken;
		
		@SerializedName("LoginLockedType")
        private String loginLockedType;
		
		@SerializedName("NoOfLogins")
        private Integer noOfLogins;
		
		@SerializedName("Password")
        private String password;
		
		@SerializedName("PasswordExpirationDate")
        private String passwordExpirationDate;
		
		@SerializedName("PhoneId")
        private String phoneId;
		
		@SerializedName("PhoneIdVerified")
        private Boolean phoneIdVerified;
		
		@SerializedName("PIN")
        private PINInformation pin;
		
		@SerializedName("PrivacyPolicy")
        private AcceptedPrivacyPolicy privacyPolicy;
		
		@SerializedName("RegistrationData")
        private RegistrationData registrationData;
		
		@SerializedName("RegistrationProvider")
        private String registrationProvider;
		
		@SerializedName("RegistrationSource")
        private String registrationSource;
		
		@SerializedName("Roles")
        private List<String> roles;
		
		@SerializedName("Uid")
        private String uid;
		
		@SerializedName("UnverifiedEmail")
        private List<Email> unverifiedEmail;
		
		@SerializedName("UserName")
        private String userName;



		/**
		 * Response containing consent profile
		 */
		public ConsentProfile getConsentProfile() {
			return consentProfile;
		}
		/**
		 * Response containing consent profile
		 */
		public void setConsentProfile(ConsentProfile consentProfile) {
			this.consentProfile = consentProfile;
		}
		/**
		 * Custom fields as user set on LoginRadius Admin Console.
		 */
		public Map<String,String> getCustomFields() {
			return customFields;
		}
		/**
		 * Custom fields as user set on LoginRadius Admin Console.
		 */
		public void setCustomFields(Map<String,String> customFields) {
			this.customFields = customFields;
		}
		/**
		 * boolean type value, default is true
		 */
		public Boolean getEmailVerified() {
			return emailVerified;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setEmailVerified(Boolean emailVerified) {
			this.emailVerified = emailVerified;
		}
		/**
		 * Array of Objects,string represents SourceId,Source
		 */
		public List<ExternalIds> getExternalIds() {
			return externalIds;
		}
		/**
		 * Array of Objects,string represents SourceId,Source
		 */
		public void setExternalIds(List<ExternalIds> externalIds) {
			this.externalIds = externalIds;
		}
		/**
		 * External User Login Id
		 */
		public String getExternalUserLoginId() {
			return externalUserLoginId;
		}
		/**
		 * External User Login Id
		 */
		public void setExternalUserLoginId(String externalUserLoginId) {
			this.externalUserLoginId = externalUserLoginId;
		}
		/**
		 * boolean type value, default is true
		 */
		public Boolean getIsActive() {
			return isActive;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}
		/**
		 * id is custom of not
		 */
		public Boolean getIsCustomUid() {
			return isCustomUid;
		}
		/**
		 * id is custom of not
		 */
		public void setIsCustomUid(Boolean isCustomUid) {
			this.isCustomUid = isCustomUid;
		}
		/**
		 * boolean type value, default is true
		 */
		public Boolean getIsDeleted() {
			return isDeleted;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setIsDeleted(Boolean isDeleted) {
			this.isDeleted = isDeleted;
		}
		/**
		 * boolean type value, default is true
		 */
		public Boolean getIsEmailSubscribed() {
			return isEmailSubscribed;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setIsEmailSubscribed(Boolean isEmailSubscribed) {
			this.isEmailSubscribed = isEmailSubscribed;
		}
		/**
		 * Pass true if wants to lock the user's Login field else false.
		 */
		public Boolean getIsLoginLocked() {
			return isLoginLocked;
		}
		/**
		 * Pass true if wants to lock the user's Login field else false.
		 */
		public void setIsLoginLocked(Boolean isLoginLocked) {
			this.isLoginLocked = isLoginLocked;
		}
		/**
		 * Required fields filled once or not
		 */
		public Boolean getIsRequiredFieldsFilledOnce() {
			return isRequiredFieldsFilledOnce;
		}
		/**
		 * Required fields filled once or not
		 */
		public void setIsRequiredFieldsFilledOnce(Boolean isRequiredFieldsFilledOnce) {
			this.isRequiredFieldsFilledOnce = isRequiredFieldsFilledOnce;
		}
		/**
		 * Is secure password or not
		 */
		public Boolean getIsSecurePassword() {
			return isSecurePassword;
		}
		/**
		 * Is secure password or not
		 */
		public void setIsSecurePassword(Boolean isSecurePassword) {
			this.isSecurePassword = isSecurePassword;
		}
		/**
		 * Last login location
		 */
		public String getLastLoginLocation() {
			return lastLoginLocation;
		}
		/**
		 * Last login location
		 */
		public void setLastLoginLocation(String lastLoginLocation) {
			this.lastLoginLocation = lastLoginLocation;
		}
		/**
		 * Last password change date
		 */
		public String getLastPasswordChangeDate() {
			return lastPasswordChangeDate;
		}
		/**
		 * Last password change date
		 */
		public void setLastPasswordChangeDate(String lastPasswordChangeDate) {
			this.lastPasswordChangeDate = lastPasswordChangeDate;
		}
		/**
		 * Last password change token
		 */
		public String getLastPasswordChangeToken() {
			return lastPasswordChangeToken;
		}
		/**
		 * Last password change token
		 */
		public void setLastPasswordChangeToken(String lastPasswordChangeToken) {
			this.lastPasswordChangeToken = lastPasswordChangeToken;
		}
		/**
		 * Type of Lockout
		 */
		public String getLoginLockedType() {
			return loginLockedType;
		}
		/**
		 * Type of Lockout
		 */
		public void setLoginLockedType(String loginLockedType) {
			this.loginLockedType = loginLockedType;
		}
		/**
		 * Number of Logins
		 */
		public Integer getNoOfLogins() {
			return noOfLogins;
		}
		/**
		 * Number of Logins
		 */
		public void setNoOfLogins(Integer noOfLogins) {
			this.noOfLogins = noOfLogins;
		}
		/**
		 * Password for the email
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * Password for the email
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * Date of password expiration
		 */
		public String getPasswordExpirationDate() {
			return passwordExpirationDate;
		}
		/**
		 * Date of password expiration
		 */
		public void setPasswordExpirationDate(String passwordExpirationDate) {
			this.passwordExpirationDate = passwordExpirationDate;
		}
		/**
		 * Phone ID (Unique Phone Number Identifier of the user)
		 */
		public String getPhoneId() {
			return phoneId;
		}
		/**
		 * Phone ID (Unique Phone Number Identifier of the user)
		 */
		public void setPhoneId(String phoneId) {
			this.phoneId = phoneId;
		}
		/**
		 * boolean type value, default is false
		 */
		public Boolean getPhoneIdVerified() {
			return phoneIdVerified;
		}
		/**
		 * boolean type value, default is false
		 */
		public void setPhoneIdVerified(Boolean phoneIdVerified) {
			this.phoneIdVerified = phoneIdVerified;
		}
		/**
		 * PIN of user
		 */
		public PINInformation getPIN() {
			return pin;
		}
		/**
		 * PIN of user
		 */
		public void setPIN(PINInformation pin) {
			this.pin = pin;
		}
		/**
		 * Object type by default false, string represents Version, AcceptSource and datetime represents AcceptDateTime
		 */
		public AcceptedPrivacyPolicy getPrivacyPolicy() {
			return privacyPolicy;
		}
		/**
		 * Object type by default false, string represents Version, AcceptSource and datetime represents AcceptDateTime
		 */
		public void setPrivacyPolicy(AcceptedPrivacyPolicy privacyPolicy) {
			this.privacyPolicy = privacyPolicy;
		}
		/**
		 * User Registartion Data
		 */
		public RegistrationData getRegistrationData() {
			return registrationData;
		}
		/**
		 * User Registartion Data
		 */
		public void setRegistrationData(RegistrationData registrationData) {
			this.registrationData = registrationData;
		}
		/**
		 * Provider with which user registered
		 */
		public String getRegistrationProvider() {
			return registrationProvider;
		}
		/**
		 * Provider with which user registered
		 */
		public void setRegistrationProvider(String registrationProvider) {
			this.registrationProvider = registrationProvider;
		}
		/**
		 * URL of the webproperty from where the user is registered.
		 */
		public String getRegistrationSource() {
			return registrationSource;
		}
		/**
		 * URL of the webproperty from where the user is registered.
		 */
		public void setRegistrationSource(String registrationSource) {
			this.registrationSource = registrationSource;
		}
		/**
		 */
		//	
		/**
		 */
		public List<String> getRoles() {
			return roles;
		}
		/**
		 */
		//	
		/**
		 */
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
		/**
		 */
		//	UID, the unified identifier for each user account
		/**
		 */
		public String getUid() {
			return uid;
		}
		/**
		 */
		//	UID, the unified identifier for each user account
		/**
		 */
		public void setUid(String uid) {
			this.uid = uid;
		}
		/**
		 */
		//	Unverified Email Address
		/**
		 */
		public List<Email> getUnverifiedEmail() {
			return unverifiedEmail;
		}
		/**
		 */
		//	Unverified Email Address
		/**
		 */
		public void setUnverifiedEmail(List<Email> unverifiedEmail) {
			this.unverifiedEmail = unverifiedEmail;
		}
		/**
		 */
		//	Username of the user
		/**
		 */
		public String getUserName() {
			return userName;
		}
		/**
		 */
		//	Username of the user
		/**
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
    }