/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Sott data
	 */
	public class SottResponseData {
	
		
		@SerializedName("ExpiryTime")
        private String expiryTime;
		
		@SerializedName("Sott")
        private String sott;



		/**
		 * Sott expiry time
		 */
		public String getExpiryTime() {
			return expiryTime;
		}
		/**
		 * Sott expiry time
		 */
		public void setExpiryTime(String expiryTime) {
			this.expiryTime = expiryTime;
		}
		/**
		 * SOTT is a secure one time token
		 */
		public String getSott() {
			return sott;
		}
		/**
		 * SOTT is a secure one time token
		 */
		public void setSott(String sott) {
			this.sott = sott;
		}
    }