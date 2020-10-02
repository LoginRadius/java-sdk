/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Forgot Password data
	 */
	public class ForgotPasswordResponse {
	
		
		@SerializedName("ForgotToken")
        private String forgotToken;
		
		@SerializedName("IdentityProviders")
        private List<String> identityProviders;



		/**
		 * Forgot token
		 */
		public String getForgotToken() {
			return forgotToken;
		}
		/**
		 * Forgot token
		 */
		public void setForgotToken(String forgotToken) {
			this.forgotToken = forgotToken;
		}
		/**
		 * Identity providers
		 */
		public List<String> getIdentityProviders() {
			return identityProviders;
		}
		/**
		 * Identity providers
		 */
		public void setIdentityProviders(List<String> identityProviders) {
			this.identityProviders = identityProviders;
		}
    }