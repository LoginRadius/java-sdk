/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for MultiFactorAuthModel By Authenticator Code API
	// </summary>
	public class MultiFactorAuthModelByAuthenticatorCode {
	
		
		@SerializedName("AuthenticatorCode")
        private String authenticatorCode;



		// <summary>
		//	The code generated by authenticator app after scanning QR code
		// </summary>
		public String getAuthenticatorCode() {
			return authenticatorCode;
		}
		// <summary>
		//	The code generated by authenticator app after scanning QR code
		// </summary>
		public void setAuthenticatorCode(String authenticatorCode) {
			this.authenticatorCode = authenticatorCode;
		}
    }