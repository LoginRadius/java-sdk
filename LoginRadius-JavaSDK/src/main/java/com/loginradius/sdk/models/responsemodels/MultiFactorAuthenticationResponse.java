/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Multi-Factor Authentication data
	 */
	public class MultiFactorAuthenticationResponse<T> {
	
		
		@SerializedName("access_token")
        private UUID access_token;
		
		@SerializedName("expires_in")
        private String expires_in;
		
		@SerializedName("Profile")
        private T profile;
		
		@SerializedName("refresh_token")
        private UUID refresh_token;
		
		@SerializedName("SecondFactorAuthentication")
        private MultiFactorAuthenticationToken secondFactorAuthentication;



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
		 * Complete user profile data
		 */
		public T getProfile() {
			return profile;
		}
		/**
		 * Complete user profile data
		 */
		public void setProfile(T profile) {
			this.profile = profile;
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
		 * second factor authentication
		 */
		public MultiFactorAuthenticationToken getSecondFactorAuthentication() {
			return secondFactorAuthentication;
		}
		/**
		 * second factor authentication
		 */
		public void setSecondFactorAuthentication(MultiFactorAuthenticationToken secondFactorAuthentication) {
			this.secondFactorAuthentication = secondFactorAuthentication;
		}
    }