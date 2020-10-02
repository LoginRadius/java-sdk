/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for PIN
	 */
	public class PINRequiredModel {
	
		
		@SerializedName("PIN")
        private String pin;



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