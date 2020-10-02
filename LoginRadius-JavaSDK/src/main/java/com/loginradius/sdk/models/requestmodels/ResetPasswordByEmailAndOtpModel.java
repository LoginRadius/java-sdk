/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for ResetPasswordByEmailAndOtp API
	 */
	public class ResetPasswordByEmailAndOtpModel extends LockoutModel {
	
		
		@SerializedName("Email")
        private String email;
		
		@SerializedName("Otp")
        private String otp;
		
		@SerializedName("Password")
        private String password;
		
		@SerializedName("ResetPasswordEmailTemplate")
        private String resetPasswordEmailTemplate;
		
		@SerializedName("WelcomeEmailTemplate")
        private String welcomeEmailTemplate;



		/**
		 * user's email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * user's email
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * The Verification Code
		 */
		public String getOtp() {
			return otp;
		}
		/**
		 * The Verification Code
		 */
		public void setOtp(String otp) {
			this.otp = otp;
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
		 * If you are sending an email via the sendemail parameter, this parameter allows you to specify which reset Password email template you would like to use.
		 */
		public String getResetPasswordEmailTemplate() {
			return resetPasswordEmailTemplate;
		}
		/**
		 * If you are sending an email via the sendemail parameter, this parameter allows you to specify which reset Password email template you would like to use.
		 */
		public void setResetPasswordEmailTemplate(String resetPasswordEmailTemplate) {
			this.resetPasswordEmailTemplate = resetPasswordEmailTemplate;
		}
		/**
		 * If you are sending an email via the sendemail parameter, this parameter allows you to specify which welcome email template you would like to use.
		 */
		public String getWelcomeEmailTemplate() {
			return welcomeEmailTemplate;
		}
		/**
		 * If you are sending an email via the sendemail parameter, this parameter allows you to specify which welcome email template you would like to use.
		 */
		public void setWelcomeEmailTemplate(String welcomeEmailTemplate) {
			this.welcomeEmailTemplate = welcomeEmailTemplate;
		}
    }