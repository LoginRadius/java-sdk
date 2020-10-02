/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Reset Pin By Phone and Otp API
	 */
	public class ResetPINByPhoneAndOTPModel extends LockoutModel {
	
		
		@SerializedName("Otp")
        private String otp;
		
		@SerializedName("Phone")
        private String phone;
		
		@SerializedName("PIN")
        private String pin;



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
		 * New Phone Number
		 */
		public String getPhone() {
			return phone;
		}
		/**
		 * New Phone Number
		 */
		public void setPhone(String phone) {
			this.phone = phone;
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