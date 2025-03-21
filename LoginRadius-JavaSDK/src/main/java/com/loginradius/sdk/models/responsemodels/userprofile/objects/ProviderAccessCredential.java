/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Provider Access Credential data
	// </summary>
	public class ProviderAccessCredential {
	
		
		@SerializedName("AccessToken")
        private String accessToken;
		
		@SerializedName("TokenSecret")
        private String tokenSecret;



		// <summary>
		//	Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		// </summary>
		public String getAccessToken() {
			return accessToken;
		}
		// <summary>
		//	Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		// </summary>
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
		// <summary>
		//	secret token of the provider
		// </summary>
		public String getTokenSecret() {
			return tokenSecret;
		}
		// <summary>
		//	secret token of the provider
		// </summary>
		public void setTokenSecret(String tokenSecret) {
			this.tokenSecret = tokenSecret;
		}
    }