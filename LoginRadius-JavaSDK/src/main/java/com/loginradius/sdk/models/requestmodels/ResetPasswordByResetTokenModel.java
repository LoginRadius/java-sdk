/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for ResetToken API
	 */
	public class ResetPasswordByResetTokenModel extends LockoutModel {
	
		
		@SerializedName("Password")
        private String password;
		
		@SerializedName("ResetPasswordEmailTemplate")
        private String resetPasswordEmailTemplate;
		
		@SerializedName("ResetToken")
        private String resetToken;
		
		@SerializedName("WelcomeEmailTemplate")
        private String welcomeEmailTemplate;



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
		 * reset token received in the email
		 */
		public String getResetToken() {
			return resetToken;
		}
		/**
		 * reset token received in the email
		 */
		public void setResetToken(String resetToken) {
			this.resetToken = resetToken;
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