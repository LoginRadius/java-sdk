/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Reset Pin By Reset Token API
	// </summary>
	public class ResetPINByResetToken {
	
		
		@SerializedName("PIN")
        private String pin;
		
		@SerializedName("ResetToken")
        private String resetToken;



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
		//	reset token received in the email
		// </summary>
		public String getResetToken() {
			return resetToken;
		}
		// <summary>
		//	reset token received in the email
		// </summary>
		public void setResetToken(String resetToken) {
			this.resetToken = resetToken;
		}
    }