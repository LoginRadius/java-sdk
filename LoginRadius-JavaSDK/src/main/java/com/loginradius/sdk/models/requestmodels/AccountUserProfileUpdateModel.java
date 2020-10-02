/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Account Update API
	 */
	public class AccountUserProfileUpdateModel extends UserProfileUpdateModel {
	
		
		@SerializedName("DisableLogin")
        private Boolean disableLogin;
		
		@SerializedName("EmailVerified")
        private Boolean emailVerified;
		
		@SerializedName("IsActive")
        private Boolean isActive;
		
		@SerializedName("IsDeleted")
        private Boolean isDeleted;
		
		@SerializedName("IsLoginLocked")
        private Boolean isLoginLocked;
		
		@SerializedName("PhoneIdVerified")
        private Boolean phoneIdVerified;
		
		@SerializedName("PrivacyPolicy")
        private PrivacyPolicy privacyPolicy;
		
		@SerializedName("RegistrationSource")
        private String registrationSource;



		/**
		 * To disable traditional login for user
		 */
		public Boolean getDisableLogin() {
			return disableLogin;
		}
		/**
		 * To disable traditional login for user
		 */
		public void setDisableLogin(Boolean disableLogin) {
			this.disableLogin = disableLogin;
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
		 * Object type by default false, string represents Version, AcceptSource and datetime represents AcceptDateTime
		 */
		public PrivacyPolicy getPrivacyPolicy() {
			return privacyPolicy;
		}
		/**
		 * Object type by default false, string represents Version, AcceptSource and datetime represents AcceptDateTime
		 */
		public void setPrivacyPolicy(PrivacyPolicy privacyPolicy) {
			this.privacyPolicy = privacyPolicy;
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
    }