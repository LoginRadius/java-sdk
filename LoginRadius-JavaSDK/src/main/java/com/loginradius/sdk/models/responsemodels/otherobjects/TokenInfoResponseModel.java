/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Token Information
	 */
	public class TokenInfoResponseModel {
	
		
		@SerializedName("access_token")
        private UUID access_token;
		
		@SerializedName("isrememberme")
        private Boolean isrememberme;
		
		@SerializedName("provider")
        private String provider;



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
		 * is remember login or not
		 */
		public Boolean getIsRememberMe() {
			return isrememberme;
		}
		/**
		 * is remember login or not
		 */
		public void setIsRememberMe(Boolean isrememberme) {
			this.isrememberme = isrememberme;
		}
		/**
		 * Name of the provider
		 */
		public String getProvider() {
			return provider;
		}
		/**
		 * Name of the provider
		 */
		public void setProvider(String provider) {
			this.provider = provider;
		}
    }