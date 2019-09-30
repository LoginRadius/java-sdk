/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Account Update API
	// </summary>
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



		// <summary>
		//	To disable traditional login for user
		// </summary>
		public Boolean getDisableLogin() {
			return disableLogin;
		}
		// <summary>
		//	To disable traditional login for user
		// </summary>
		public void setDisableLogin(Boolean disableLogin) {
			this.disableLogin = disableLogin;
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
		//	Object type by default false, string represents Version, AcceptSource and datetime represents AcceptDateTime
		// </summary>
		public PrivacyPolicy getPrivacyPolicy() {
			return privacyPolicy;
		}
		// <summary>
		//	Object type by default false, string represents Version, AcceptSource and datetime represents AcceptDateTime
		// </summary>
		public void setPrivacyPolicy(PrivacyPolicy privacyPolicy) {
			this.privacyPolicy = privacyPolicy;
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
    }