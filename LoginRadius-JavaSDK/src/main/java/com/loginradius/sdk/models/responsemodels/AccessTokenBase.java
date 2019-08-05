/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Token data
	// </summary>
	public class AccessTokenBase {
	
		
		@SerializedName("access_token")
        private UUID access_token;
		
		@SerializedName("expires_in")
        private String expires_in;
		
		@SerializedName("refresh_token")
        private UUID refresh_token;



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
		//	Expiration time of Access Token
		// </summary>
		public String getExpires_In() {
			return expires_in;
		}
		// <summary>
		//	Expiration time of Access Token
		// </summary>
		public void setExpires_In(String expires_in) {
			this.expires_in = expires_in;
		}
		// <summary>
		//	refresh token to refresh access token
		// </summary>
		public UUID getRefresh_Token() {
			return refresh_token;
		}
		// <summary>
		//	refresh token to refresh access token
		// </summary>
		public void setRefresh_Token(UUID refresh_token) {
			this.refresh_token = refresh_token;
		}
    }