/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for EmailVerificationByOtpModel API
	 */
	public class EmailVerificationByOtpModel extends LockoutModel {
	
		
		@SerializedName("Email")
        private String email;
		
		@SerializedName("Otp")
        private String otp;



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
    }