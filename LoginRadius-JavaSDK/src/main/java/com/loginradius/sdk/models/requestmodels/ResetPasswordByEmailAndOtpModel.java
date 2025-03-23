/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for ResetPasswordByEmailAndOtp API
	// </summary>
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



		// <summary>
		//	user's email
		// </summary>
		public String getEmail() {
			return email;
		}
		// <summary>
		//	user's email
		// </summary>
		public void setEmail(String email) {
			this.email = email;
		}
		// <summary>
		//	The Verification Code
		// </summary>
		public String getOtp() {
			return otp;
		}
		// <summary>
		//	The Verification Code
		// </summary>
		public void setOtp(String otp) {
			this.otp = otp;
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
		//	If you are sending an email via the sendemail parameter, this parameter allows you to specify which reset Password email template you would like to use.
		// </summary>
		public String getResetPasswordEmailTemplate() {
			return resetPasswordEmailTemplate;
		}
		// <summary>
		//	If you are sending an email via the sendemail parameter, this parameter allows you to specify which reset Password email template you would like to use.
		// </summary>
		public void setResetPasswordEmailTemplate(String resetPasswordEmailTemplate) {
			this.resetPasswordEmailTemplate = resetPasswordEmailTemplate;
		}
		// <summary>
		//	If you are sending an email via the sendemail parameter, this parameter allows you to specify which welcome email template you would like to use.
		// </summary>
		public String getWelcomeEmailTemplate() {
			return welcomeEmailTemplate;
		}
		// <summary>
		//	If you are sending an email via the sendemail parameter, this parameter allows you to specify which welcome email template you would like to use.
		// </summary>
		public void setWelcomeEmailTemplate(String welcomeEmailTemplate) {
			this.welcomeEmailTemplate = welcomeEmailTemplate;
		}
    }