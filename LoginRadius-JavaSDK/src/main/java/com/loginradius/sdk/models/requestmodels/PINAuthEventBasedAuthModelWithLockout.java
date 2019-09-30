/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for PIN
	// </summary>
	public class PINAuthEventBasedAuthModelWithLockout {
	
		
		@SerializedName("PIN")
        private String pin;



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
    }