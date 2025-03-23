/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for MultiFactorAuthModel By Authenticator Code API with security answer
	// </summary>
	public class MultiFactorAuthModelByAuthenticatorCodeSecurityAnswer extends MultiFactorAuthModelByAuthenticatorCode {
	
		
		@SerializedName("SecurityAnswer")
        private Map<String,String> securityAnswer;



		// <summary>
		//	Valid JSON object of Unique Security Question ID and Answer of set Security Question. It is only required for locked accounts when logging in. Details about this feature
		// </summary>
		public Map<String,String> getSecurityAnswer() {
			return securityAnswer;
		}
		// <summary>
		//	Valid JSON object of Unique Security Question ID and Answer of set Security Question. It is only required for locked accounts when logging in. Details about this feature
		// </summary>
		public void setSecurityAnswer(Map<String,String> securityAnswer) {
			this.securityAnswer = securityAnswer;
		}
    }