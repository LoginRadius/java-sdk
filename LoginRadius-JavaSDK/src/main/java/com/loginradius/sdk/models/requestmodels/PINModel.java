/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for PinInfo
	 */
	public class PINModel {
	
		
		@SerializedName("PIN")
        private String pin;
		
		@SerializedName("Skipped")
        private Boolean skipped;



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
		 * possible values are true/false/null
		 */
		public Boolean getSkipped() {
			return skipped;
		}
		/**
		 * possible values are true/false/null
		 */
		public void setSkipped(Boolean skipped) {
			this.skipped = skipped;
		}
    }