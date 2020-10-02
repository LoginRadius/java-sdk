/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Forgot Pin Otp By Phone API
	 */
	public class ForgotPINOtpByPhoneModel {
	
		
		@SerializedName("Phone")
        private String phone;



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
    }