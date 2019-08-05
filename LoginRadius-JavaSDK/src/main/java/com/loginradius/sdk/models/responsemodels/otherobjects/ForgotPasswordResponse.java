/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Forgot Password data
	// </summary>
	public class ForgotPasswordResponse {
	
		
		@SerializedName("ForgotToken")
        private String forgotToken;
		
		@SerializedName("IdentityProviders")
        private List<String> identityProviders;



		// <summary>
		//	Forgot token
		// </summary>
		public String getForgotToken() {
			return forgotToken;
		}
		// <summary>
		//	Forgot token
		// </summary>
		public void setForgotToken(String forgotToken) {
			this.forgotToken = forgotToken;
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
    }