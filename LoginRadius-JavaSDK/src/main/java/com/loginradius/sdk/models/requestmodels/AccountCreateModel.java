/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Account Create API
	// </summary>
	public class AccountCreateModel extends AuthUserRegistrationModel {
	
		
		@SerializedName("DisableLogin")
        private Boolean disableLogin;
		
		@SerializedName("EmailVerified")
        private Boolean emailVerified;
		
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