/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for PinInfo
	// </summary>
	public class PINModel {
	
		
		@SerializedName("PIN")
        private String pin;
		
		@SerializedName("Skipped")
        private Boolean skipped;



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
    }