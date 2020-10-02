/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Phone data
	 */
	public class Phone {
	
		
		@SerializedName("PhoneNumber")
        private String phoneNumber;
		
		@SerializedName("PhoneType")
        private String phoneType;



		/**
		 * Phone number
		 */
		public String getPhoneNumber() {
			return phoneNumber;
		}
		/**
		 * Phone number
		 */
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		/**
		 * Phone type
		 */
		public String getPhoneType() {
			return phoneType;
		}
		/**
		 * Phone type
		 */
		public void setPhoneType(String phoneType) {
			this.phoneType = phoneType;
		}
    }