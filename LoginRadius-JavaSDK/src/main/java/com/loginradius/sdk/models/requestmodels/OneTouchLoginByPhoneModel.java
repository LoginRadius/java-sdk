/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for OneTouchLogin By PhoneModel API
	 */
	public class OneTouchLoginByPhoneModel extends ReCaptchaBodyModel {
	
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Phone")
        private String phone;



		/**
		 * Name of the customer
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of the customer
		 */
		public void setName(String name) {
			this.name = name;
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
    }