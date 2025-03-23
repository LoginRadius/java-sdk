/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete MultiToken
	// </summary>
	public class MultiToken {
	
		
		@SerializedName("ExpiresIn")
        private String expiresIn;
		
		@SerializedName("IdentityProviders")
        private List<String> identityProviders;
		
		@SerializedName("Token")
        private String token;



		// <summary>
		//	
		// </summary>
		public String getExpiresIn() {
			return expiresIn;
		}
		// <summary>
		//	
		// </summary>
		public void setExpiresIn(String expiresIn) {
			this.expiresIn = expiresIn;
		}
		// <summary>
		//	Identity providers
		// </summary>
		public List<String> getIdentityProviders() {
			return identityProviders;
		}
		// <summary>
		//	Identity providers
		// </summary>
		public void setIdentityProviders(List<String> identityProviders) {
			this.identityProviders = identityProviders;
		}
		// <summary>
		//	Token
		// </summary>
		public String getToken() {
			return token;
		}
		// <summary>
		//	Token
		// </summary>
		public void setToken(String token) {
			this.token = token;
		}
    }