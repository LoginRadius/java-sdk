/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	
	// </summary>
	public class PasswordLessLoginByEmailAndOtpModel {
	
		
		@SerializedName("Email")
        private String email;
		
		@SerializedName("Otp")
        private String otp;
		
		@SerializedName("welcomeEmailTemplate")
        private String welcomeEmailTemplate;



		// <summary>
		//	
		// </summary>
		public String getEmail() {
			return email;
		}
		// <summary>
		//	
		// </summary>
		public void setEmail(String email) {
			this.email = email;
		}
		// <summary>
		//	
		// </summary>
		public String getOtp() {
			return otp;
		}
		// <summary>
		//	
		// </summary>
		public void setOtp(String otp) {
			this.otp = otp;
		}
		// <summary>
		//	
		// </summary>
		public String getWelcomeEmailTemplate() {
			return welcomeEmailTemplate;
		}
		// <summary>
		//	
		// </summary>
		public void setWelcomeEmailTemplate(String welcomeEmailTemplate) {
			this.welcomeEmailTemplate = welcomeEmailTemplate;
		}
    }