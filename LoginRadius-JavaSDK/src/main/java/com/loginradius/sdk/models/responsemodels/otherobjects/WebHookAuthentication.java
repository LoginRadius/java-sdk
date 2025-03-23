/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.Map;
import java.util.List;
import java.util.UUID;
import com.google.gson.JsonObject;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.*;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Authentication details for the webhook
	// </summary>
	public class WebHookAuthentication {
	
		
		@SerializedName("AuthType")
        private String authType;
		
		@SerializedName("BasicAuth")
        private WebhookBasicAuthCredentials basicAuth;
		
		@SerializedName("BearerToken")
        private WebhookBearerToken bearerToken;



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
		public WebhookBasicAuthCredentials getBasicAuth() {
			return basicAuth;
		}
		// <summary>
		//	Webhook Basic Authentication
		// </summary>
		public void setBasicAuth(WebhookBasicAuthCredentials basicAuth) {
			this.basicAuth = basicAuth;
		}
		// <summary>
		//	Bearer Token for authentication
		// </summary>
		public WebhookBearerToken getBearerToken() {
			return bearerToken;
		}
		// <summary>
		//	Bearer Token for authentication
		// </summary>
		public void setBearerToken(WebhookBearerToken bearerToken) {
			this.bearerToken = bearerToken;
		}
    }