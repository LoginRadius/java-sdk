/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for SecondFactorValidationToken
	// </summary>
	public class EventBasedMultiFactorToken {
	
		
		@SerializedName("SecondFactorValidationToken")
        private String secondFactorValidationToken;



		// <summary>
		//	second factor validation token
		// </summary>
		public String getSecondFactorValidationToken() {
			return secondFactorValidationToken;
		}
		// <summary>
		//	second factor validation token
		// </summary>
		public void setSecondFactorValidationToken(String secondFactorValidationToken) {
			this.secondFactorValidationToken = secondFactorValidationToken;
		}
    }