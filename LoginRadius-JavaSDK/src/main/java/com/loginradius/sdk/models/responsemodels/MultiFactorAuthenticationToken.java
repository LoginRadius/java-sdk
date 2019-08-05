/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete MFAuthentication Token
	// </summary>
	public class MultiFactorAuthenticationToken extends MultiFactorAuthenticationSettingsResponse {
	
		
		@SerializedName("ExpireIn")
        private String expireIn;
		
		@SerializedName("SecondFactorAuthenticationToken")
        private UUID secondFactorAuthenticationToken;



		// <summary>
		//	Expiration time of Access Token
		// </summary>
		public String getExpireIn() {
			return expireIn;
		}
		// <summary>
		//	Expiration time of Access Token
		// </summary>
		public void setExpireIn(String expireIn) {
			this.expireIn = expireIn;
		}
		// <summary>
		//	second factor authentication token
		// </summary>
		public UUID getSecondFactorAuthenticationToken() {
			return secondFactorAuthenticationToken;
		}
		// <summary>
		//	second factor authentication token
		// </summary>
		public void setSecondFactorAuthenticationToken(UUID secondFactorAuthenticationToken) {
			this.secondFactorAuthenticationToken = secondFactorAuthenticationToken;
		}
    }