/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Token Information
	// </summary>
	public class TokenInfoResponseModel {
	
		
		@SerializedName("access_token")
        private UUID access_token;
		
		@SerializedName("isrememberme")
        private Boolean isrememberme;
		
		@SerializedName("provider")
        private String provider;



		// <summary>
		//	Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		// </summary>
		public UUID getAccess_Token() {
			return access_token;
		}
		// <summary>
		//	Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		// </summary>
		public void setAccess_Token(UUID access_token) {
			this.access_token = access_token;
		}
		// <summary>
		//	is remember login or not
		// </summary>
		public Boolean getIsRememberMe() {
			return isrememberme;
		}
		// <summary>
		//	is remember login or not
		// </summary>
		public void setIsRememberMe(Boolean isrememberme) {
			this.isrememberme = isrememberme;
		}
		// <summary>
		//	Name of the provider
		// </summary>
		public String getProvider() {
			return provider;
		}
		// <summary>
		//	Name of the provider
		// </summary>
		public void setProvider(String provider) {
			this.provider = provider;
		}
    }