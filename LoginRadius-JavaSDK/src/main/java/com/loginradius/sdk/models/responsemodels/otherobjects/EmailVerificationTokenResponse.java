/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Verification data
	 */
	public class EmailVerificationTokenResponse {
	
		
		@SerializedName("VerificationToken")
        private String verificationToken;



		/**
		 * Verification token received in the email
		 */
		public String getVerificationToken() {
			return verificationToken;
		}
		/**
		 * Verification token received in the email
		 */
		public void setVerificationToken(String verificationToken) {
			this.verificationToken = verificationToken;
		}
    }