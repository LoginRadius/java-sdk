/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response Model Class containing Definition of PIN Information
	 */
	public class PINInformation {
	
		
		@SerializedName("LastPINChangeDate")
        private String lastPINChangeDate;
		
		@SerializedName("LastPINChangeToken")
        private String lastPINChangeToken;
		
		@SerializedName("PIN")
        private String pin;
		
		@SerializedName("Skipped")
        private Boolean skipped;
		
		@SerializedName("SkippedDate")
        private String skippedDate;



		/**
		 * Last PIN Change Date
		 */
		public String getLastPINChangeDate() {
			return lastPINChangeDate;
		}
		/**
		 * Last PIN Change Date
		 */
		public void setLastPINChangeDate(String lastPINChangeDate) {
			this.lastPINChangeDate = lastPINChangeDate;
		}
		/**
		 * Last PIN Change Token
		 */
		public String getLastPINChangeToken() {
			return lastPINChangeToken;
		}
		/**
		 * Last PIN Change Token
		 */
		public void setLastPINChangeToken(String lastPINChangeToken) {
			this.lastPINChangeToken = lastPINChangeToken;
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
		/**
		 * Skipped Date
		 */
		public String getSkippedDate() {
			return skippedDate;
		}
		/**
		 * Skipped Date
		 */
		public void setSkippedDate(String skippedDate) {
			this.skippedDate = skippedDate;
		}
    }