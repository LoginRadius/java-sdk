/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for SecondFactorValidationToken
	 */
	public class EventBasedMultiFactorToken {
	
		
		@SerializedName("SecondFactorValidationToken")
        private String secondFactorValidationToken;



		/**
		 * second factor validation token
		 */
		public String getSecondFactorValidationToken() {
			return secondFactorValidationToken;
		}
		/**
		 * second factor validation token
		 */
		public void setSecondFactorValidationToken(String secondFactorValidationToken) {
			this.secondFactorValidationToken = secondFactorValidationToken;
		}
    }