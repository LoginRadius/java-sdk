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

	// <summary>
	//	Response containing Definition for Complete UserProfile data
	// </summary>
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



		// <summary>
		//	Response containing consent profile
		// </summary>
		public ConsentProfile getConsentProfile() {
			return consentProfile;
		}
		// <summary>
		//	Response containing consent profile
		// </summary>
		public void setConsentProfile(ConsentProfile consentProfile) {
			this.consentProfile = consentProfile;
		}
		// <summary>
		//	Custom fields as user set on LoginRadius Admin Console.
		// </summary>
		public Map<String,String> getCustomFields() {
			return customFields;
		}
		// <summary>
		//	Custom fields as user set on LoginRadius Admin Console.
		// </summary>
		public void setCustomFields(Map<String,String> customFields) {
			this.customFields = customFields;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public Boolean getEmailVerified() {
			return emailVerified;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setEmailVerified(Boolean emailVerified) {
			this.emailVerified = emailVerified;
		}
		// <summary>
		//	Array of Objects,string represents SourceId,Source
		// </summary>
		public List<ExternalIds> getExternalIds() {
			return externalIds;
		}
		// <summary>
		//	Array of Objects,string represents SourceId,Source
		// </summary>
		public void setExternalIds(List<ExternalIds> externalIds) {
			this.externalIds = externalIds;
		}
		// <summary>
		//	External User Login Id
		// </summary>
		public String getExternalUserLoginId() {
			return externalUserLoginId;
		}
		// <summary>
		//	External User Login Id
		// </summary>
		public void setExternalUserLoginId(String externalUserLoginId) {
			this.externalUserLoginId = externalUserLoginId;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public Boolean getIsActive() {
			return isActive;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}
		// <summary>
		//	id is custom of not
		// </summary>
		public Boolean getIsCustomUid() {
			return isCustomUid;
		}
		// <summary>
		//	id is custom of not
		// </summary>
		public void setIsCustomUid(Boolean isCustomUid) {
			this.isCustomUid = isCustomUid;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public Boolean getIsDeleted() {
			return isDeleted;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setIsDeleted(Boolean isDeleted) {
			this.isDeleted = isDeleted;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public Boolean getIsEmailSubscribed() {
			return isEmailSubscribed;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setIsEmailSubscribed(Boolean isEmailSubscribed) {
			this.isEmailSubscribed = isEmailSubscribed;
		}
		// <summary>
		//	Pass true if wants to lock the user's Login field else false.
		// </summary>
		public Boolean getIsLoginLocked() {
			return isLoginLocked;
		}
		// <summary>
		//	Pass true if wants to lock the user's Login field else false.
		// </summary>
		public void setIsLoginLocked(Boolean isLoginLocked) {
			this.isLoginLocked = isLoginLocked;
		}
		// <summary>
		//	Required fields filled once or not
		// </summary>
		public Boolean getIsRequiredFieldsFilledOnce() {
			return isRequiredFieldsFilledOnce;
		}
		// <summary>
		//	Required fields filled once or not
		// </summary>
		public void setIsRequiredFieldsFilledOnce(Boolean isRequiredFieldsFilledOnce) {
			this.isRequiredFieldsFilledOnce = isRequiredFieldsFilledOnce;
		}
		// <summary>
		//	Is secure password or not
		// </summary>
		public Boolean getIsSecurePassword() {
			return isSecurePassword;
		}
		// <summary>
		//	Is secure password or not
		// </summary>
		public void setIsSecurePassword(Boolean isSecurePassword) {
			this.isSecurePassword = isSecurePassword;
		}
		// <summary>
		//	Last login location
		// </summary>
		public String getLastLoginLocation() {
			return lastLoginLocation;
		}
		// <summary>
		//	Last login location
		// </summary>
		public void setLastLoginLocation(String lastLoginLocation) {
			this.lastLoginLocation = lastLoginLocation;
		}
		// <summary>
		//	Last password change date
		// </summary>
		public String getLastPasswordChangeDate() {
			return lastPasswordChangeDate;
		}
		// <summary>
		//	Last password change date
		// </summary>
		public void setLastPasswordChangeDate(String lastPasswordChangeDate) {
			this.lastPasswordChangeDate = lastPasswordChangeDate;
		}
		// <summary>
		//	Last password change token
		// </summary>
		public String getLastPasswordChangeToken() {
			return lastPasswordChangeToken;
		}
		// <summary>
		//	Last password change token
		// </summary>
		public void setLastPasswordChangeToken(String lastPasswordChangeToken) {
			this.lastPasswordChangeToken = lastPasswordChangeToken;
		}
		// <summary>
		//	Type of Lockout
		// </summary>
		public String getLoginLockedType() {
			return loginLockedType;
		}
		// <summary>
		//	Type of Lockout
		// </summary>
		public void setLoginLockedType(String loginLockedType) {
			this.loginLockedType = loginLockedType;
		}
		// <summary>
		//	Number of Logins
		// </summary>
		public Integer getNoOfLogins() {
			return noOfLogins;
		}
		// <summary>
		//	Number of Logins
		// </summary>
		public void setNoOfLogins(Integer noOfLogins) {
			this.noOfLogins = noOfLogins;
		}
		// <summary>
		//	Password for the email
		// </summary>
		public String getPassword() {
			return password;
		}
		// <summary>
		//	Password for the email
		// </summary>
		public void setPassword(String password) {
			this.password = password;
		}
		// <summary>
		//	Date of password expiration
		// </summary>
		public String getPasswordExpirationDate() {
			return passwordExpirationDate;
		}
		// <summary>
		//	Date of password expiration
		// </summary>
		public void setPasswordExpirationDate(String passwordExpirationDate) {
			this.passwordExpirationDate = passwordExpirationDate;
		}
		// <summary>
		//	Phone ID (Unique Phone Number Identifier of the user)
		// </summary>
		public String getPhoneId() {
			return phoneId;
		}
		// <summary>
		//	Phone ID (Unique Phone Number Identifier of the user)
		// </summary>
		public void setPhoneId(String phoneId) {
			this.phoneId = phoneId;
		}
		// <summary>
		//	boolean type value, default is false
		// </summary>
		public Boolean getPhoneIdVerified() {
			return phoneIdVerified;
		}
		// <summary>
		//	boolean type value, default is false
		// </summary>
		public void setPhoneIdVerified(Boolean phoneIdVerified) {
			this.phoneIdVerified = phoneIdVerified;
		}
		// <summary>
		//	PIN of user
		// </summary>
		public PINInformation getPIN() {
			return pin;
		}
		// <summary>
		//	PIN of user
		// </summary>
		public void setPIN(PINInformation pin) {
			this.pin = pin;
		}
		// <summary>
		//	Object type by default false, string represents Version, AcceptSource and datetime represents AcceptDateTime
		// </summary>
		public AcceptedPrivacyPolicy getPrivacyPolicy() {
			return privacyPolicy;
		}
		// <summary>
		//	Object type by default false, string represents Version, AcceptSource and datetime represents AcceptDateTime
		// </summary>
		public void setPrivacyPolicy(AcceptedPrivacyPolicy privacyPolicy) {
			this.privacyPolicy = privacyPolicy;
		}
		// <summary>
		//	User Registartion Data
		// </summary>
		public RegistrationData getRegistrationData() {
			return registrationData;
		}
		// <summary>
		//	User Registartion Data
		// </summary>
		public void setRegistrationData(RegistrationData registrationData) {
			this.registrationData = registrationData;
		}
		// <summary>
		//	Provider with which user registered
		// </summary>
		public String getRegistrationProvider() {
			return registrationProvider;
		}
		// <summary>
		//	Provider with which user registered
		// </summary>
		public void setRegistrationProvider(String registrationProvider) {
			this.registrationProvider = registrationProvider;
		}
		// <summary>
		//	URL of the webproperty from where the user is registered.
		// </summary>
		public String getRegistrationSource() {
			return registrationSource;
		}
		// <summary>
		//	URL of the webproperty from where the user is registered.
		// </summary>
		public void setRegistrationSource(String registrationSource) {
			this.registrationSource = registrationSource;
		}
		// <summary>
		//	
		// </summary>
		public List<String> getRoles() {
			return roles;
		}
		// <summary>
		//	
		// </summary>
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public String getUid() {
			return uid;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public void setUid(String uid) {
			this.uid = uid;
		}
		// <summary>
		//	Unverified Email Address
		// </summary>
		public List<Email> getUnverifiedEmail() {
			return unverifiedEmail;
		}
		// <summary>
		//	Unverified Email Address
		// </summary>
		public void setUnverifiedEmail(List<Email> unverifiedEmail) {
			this.unverifiedEmail = unverifiedEmail;
		}
		// <summary>
		//	Username of the user
		// </summary>
		public String getUserName() {
			return userName;
		}
		// <summary>
		//	Username of the user
		// </summary>
		public void setUserName(String userName) {
			this.userName = userName;
		}
    }