/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition response of MFA reauthentication
	// </summary>
	public class EventBasedMultiFactorAuthenticationToken {
	
		
		@SerializedName("ExpireIn")
        private String expireIn;
		
		@SerializedName("SecondFactorValidationToken")
        private UUID secondFactorValidationToken;



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
		//	second factor validation token
		// </summary>
		public UUID getSecondFactorValidationToken() {
			return secondFactorValidationToken;
		}
		// <summary>
		//	second factor validation token
		// </summary>
		public void setSecondFactorValidationToken(UUID secondFactorValidationToken) {
			this.secondFactorValidationToken = secondFactorValidationToken;
		}
    }