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
		
		@SerializedName("session_expires_in")
        private String session_expires_in;
		
		@SerializedName("session_token")
        private UUID session_token;



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
		// <summary>
		//	session token expiry time
		// </summary>
		public String getSession_expires_in() {
			return session_expires_in;
		}
		// <summary>
		//	session token expiry time
		// </summary>
		public void setSession_expires_in(String session_expires_in) {
			this.session_expires_in = session_expires_in;
		}
		// <summary>
		//	session token of user
		// </summary>
		public UUID getSession_token() {
			return session_token;
		}
		// <summary>
		//	session token of user
		// </summary>
		public void setSession_token(UUID session_token) {
			this.session_token = session_token;
		}
    }