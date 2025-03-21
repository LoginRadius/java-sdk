/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;
import java.util.List;
import java.util.UUID;
import com.google.gson.JsonObject;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.*;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for WebhookAuthenticationModel Property
	// </summary>
	public class WebhookAuthenticationModel {
	
		
		@SerializedName("AuthType")
        private String authType;
		
		@SerializedName("BasicAuth")
        private WebhookAuthCredentials basicAuth;



		// <summary>
		//	Webhook Authentication Type
		// </summary>
		public String getAuthType() {
			return authType;
		}
		// <summary>
		//	Webhook Authentication Type
		// </summary>
		public void setAuthType(String authType) {
			this.authType = authType;
		}
		// <summary>
		//	Webhook Basic Authentication
		// </summary>
		public WebhookAuthCredentials getBasicAuth() {
			return basicAuth;
		}
		// <summary>
		//	Webhook Basic Authentication
		// </summary>
		public void setBasicAuth(WebhookAuthCredentials basicAuth) {
			this.basicAuth = basicAuth;
		}
    }