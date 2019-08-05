/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for EmailVerificationByOtpModel API
	// </summary>
	public class EmailVerificationByOtpModel extends LockoutModel {
	
		
		@SerializedName("Email")
        private String email;
		
		@SerializedName("Otp")
        private String otp;



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
    }