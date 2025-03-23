/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	
	// </summary>
	public class PasswordLessLoginByUserNameAndOtpModel {
	
		
		@SerializedName("Otp")
        private String otp;
		
		@SerializedName("UserName")
        private String userName;
		
		@SerializedName("welcomeEmailTemplate")
        private String welcomeEmailTemplate;



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
		public String getUserName() {
			return userName;
		}
		// <summary>
		//	
		// </summary>
		public void setUserName(String userName) {
			this.userName = userName;
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