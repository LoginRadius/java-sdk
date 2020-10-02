/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Token data
	 */
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



		/**
		 * Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		 */
		public UUID getAccess_Token() {
			return access_token;
		}
		/**
		 * Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		 */
		public void setAccess_Token(UUID access_token) {
			this.access_token = access_token;
		}
		/**
		 * Expiration time of Access Token
		 */
		public String getExpires_In() {
			return expires_in;
		}
		/**
		 * Expiration time of Access Token
		 */
		public void setExpires_In(String expires_in) {
			this.expires_in = expires_in;
		}
		/**
		 * refresh token to refresh access token
		 */
		public UUID getRefresh_Token() {
			return refresh_token;
		}
		/**
		 * refresh token to refresh access token
		 */
		public void setRefresh_Token(UUID refresh_token) {
			this.refresh_token = refresh_token;
		}
		/**
		 * session token expiry time
		 */
		public String getSession_expires_in() {
			return session_expires_in;
		}
		/**
		 * session token expiry time
		 */
		public void setSession_expires_in(String session_expires_in) {
			this.session_expires_in = session_expires_in;
		}
		/**
		 * session token of user
		 */
		public UUID getSession_token() {
			return session_token;
		}
		/**
		 * session token of user
		 */
		public void setSession_token(UUID session_token) {
			this.session_token = session_token;
		}
    }