/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Reset Pin By Username and Otp API
	// </summary>
	public class ResetPINByUsernameAndOtpModel extends LockoutModel {
	
		
		@SerializedName("Otp")
        private String otp;
		
		@SerializedName("PIN")
        private String pin;
		
		@SerializedName("Username")
        private String username;



		// <summary>
		//	The Verification Code
		// </summary>
		public String getOtp() {
			return otp;
		}
		// <summary>
		//	The Verification Code
		// </summary>
		public void setOtp(String otp) {
			this.otp = otp;
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
		//	Username of the user
		// </summary>
		public String getUsername() {
			return username;
		}
		// <summary>
		//	Username of the user
		// </summary>
		public void setUsername(String username) {
			this.username = username;
		}
    }