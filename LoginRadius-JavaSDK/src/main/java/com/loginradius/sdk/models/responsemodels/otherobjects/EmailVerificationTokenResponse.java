/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Verification data
	// </summary>
	public class EmailVerificationTokenResponse {
	
		
		@SerializedName("VerificationToken")
        private String verificationToken;



		// <summary>
		//	Verification token received in the email
		// </summary>
		public String getVerificationToken() {
			return verificationToken;
		}
		// <summary>
		//	Verification token received in the email
		// </summary>
		public void setVerificationToken(String verificationToken) {
			this.verificationToken = verificationToken;
		}
    }