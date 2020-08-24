/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response Model Class containing Definition of PIN Information
	// </summary>
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



		// <summary>
		//	Last PIN Change Date
		// </summary>
		public String getLastPINChangeDate() {
			return lastPINChangeDate;
		}
		// <summary>
		//	Last PIN Change Date
		// </summary>
		public void setLastPINChangeDate(String lastPINChangeDate) {
			this.lastPINChangeDate = lastPINChangeDate;
		}
		// <summary>
		//	Last PIN Change Token
		// </summary>
		public String getLastPINChangeToken() {
			return lastPINChangeToken;
		}
		// <summary>
		//	Last PIN Change Token
		// </summary>
		public void setLastPINChangeToken(String lastPINChangeToken) {
			this.lastPINChangeToken = lastPINChangeToken;
		}
		// <summary>
		//	PIN of user
		// </summary>
		public String getPIN() {
			return pin;
		}
		// <summary>
		//	PIN of user
		// </summary>
		public void setPIN(String pin) {
			this.pin = pin;
		}
		// <summary>
		//	possible values are true/false/null
		// </summary>
		public Boolean getSkipped() {
			return skipped;
		}
		// <summary>
		//	possible values are true/false/null
		// </summary>
		public void setSkipped(Boolean skipped) {
			this.skipped = skipped;
		}
		// <summary>
		//	Skipped Date
		// </summary>
		public String getSkippedDate() {
			return skippedDate;
		}
		// <summary>
		//	Skipped Date
		// </summary>
		public void setSkippedDate(String skippedDate) {
			this.skippedDate = skippedDate;
		}
    }