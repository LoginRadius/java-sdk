/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Reset Pin By Email and Otp API
	 */
	public class ResetPINByEmailAndOtpModel extends LockoutModel {
	
		
		@SerializedName("Email")
        private String email;
		
		@SerializedName("Otp")
        private String otp;
		
		@SerializedName("PIN")
        private String pin;



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
		 * PIN of user
		 */
		public String getPIN() {
			return pin;
		}
		/**
		 * PIN of user
		 */
		public void setPIN(String pin) {
			this.pin = pin;
		}
    }