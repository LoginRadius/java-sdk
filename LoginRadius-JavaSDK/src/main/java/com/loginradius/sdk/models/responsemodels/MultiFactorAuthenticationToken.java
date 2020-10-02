/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete MFAuthentication Token
	 */
	public class MultiFactorAuthenticationToken extends MultiFactorAuthenticationSettingsResponse {
	
		
		@SerializedName("ExpireIn")
        private String expireIn;
		
		@SerializedName("SecondFactorAuthenticationToken")
        private UUID secondFactorAuthenticationToken;



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
		 * second factor authentication token
		 */
		public UUID getSecondFactorAuthenticationToken() {
			return secondFactorAuthenticationToken;
		}
		/**
		 * second factor authentication token
		 */
		public void setSecondFactorAuthenticationToken(UUID secondFactorAuthenticationToken) {
			this.secondFactorAuthenticationToken = secondFactorAuthenticationToken;
		}
    }