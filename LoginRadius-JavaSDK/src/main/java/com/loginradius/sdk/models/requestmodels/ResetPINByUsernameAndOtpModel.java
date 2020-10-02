/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Reset Pin By Username and Otp API
	 */
	public class ResetPINByUsernameAndOtpModel extends LockoutModel {
	
		
		@SerializedName("Otp")
        private String otp;
		
		@SerializedName("PIN")
        private String pin;
		
		@SerializedName("Username")
        private String username;



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
		/**
		 * Username of the user
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * Username of the user
		 */
		public void setUsername(String username) {
			this.username = username;
		}
    }