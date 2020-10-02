/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition response of MFA reauthentication
	 */
	public class EventBasedMultiFactorAuthenticationToken {
	
		
		@SerializedName("ExpireIn")
        private String expireIn;
		
		@SerializedName("SecondFactorValidationToken")
        private UUID secondFactorValidationToken;



		/**
		 * Expiration time of Access Token
		 */
		public String getExpireIn() {
			return expireIn;
		}
		/**
		 * Expiration time of Access Token
		 */
		public void setExpireIn(String expireIn) {
			this.expireIn = expireIn;
		}
		/**
		 * second factor validation token
		 */
		public UUID getSecondFactorValidationToken() {
			return secondFactorValidationToken;
		}
		/**
		 * second factor validation token
		 */
		public void setSecondFactorValidationToken(UUID secondFactorValidationToken) {
			this.secondFactorValidationToken = secondFactorValidationToken;
		}
    }