/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Reset Pin By Reset Token API
	 */
	public class ResetPINByResetToken {
	
		
		@SerializedName("PIN")
        private String pin;
		
		@SerializedName("ResetToken")
        private String resetToken;



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
		 * reset token received in the email
		 */
		public String getResetToken() {
			return resetToken;
		}
		/**
		 * reset token received in the email
		 */
		public void setResetToken(String resetToken) {
			this.resetToken = resetToken;
		}
    }