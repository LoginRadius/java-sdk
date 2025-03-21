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
import com.loginradius.sdk.models.requestmodels.*;

	// <summary>
	//	Model Class containing Definition for WebHookSubscriptionUpdateModel Property
	// </summary>
	public class WebHookSubscriptionUpdateModel {
	
		
		@SerializedName("Headers")
        private Map<String,String> headers;
		
		@SerializedName("QueryParams")
        private Map<String,String> queryParams;
		
		@SerializedName("Authentication")
        private WebhookAuthCredentials authentication;



		// <summary>
		//	Custom headers for the webhook
		// </summary>
		public Map<String,String> getHeaders() {
			return headers;
		}
		// <summary>
		//	Custom headers for the webhook
		// </summary>
		public void setHeaders(Map<String,String> headers) {
			this.headers = headers;
		}
		// <summary>
		//	Query parameters for the webhook
		// </summary>
		public Map<String,String> getQueryParams() {
			return queryParams;
		}
		// <summary>
		//	Query parameters for the webhook
		// </summary>
		public void setQueryParams(Map<String,String> queryParams) {
			this.queryParams = queryParams;
		}
		// <summary>
		//	Authentication details for the webhook
		// </summary>
		public WebhookAuthCredentials getAuthentication() {
			return authentication;
		}
		// <summary>
		//	Authentication details for the webhook
		// </summary>
		public void setAuthentication(WebhookAuthCredentials authentication) {
			this.authentication = authentication;
		}
    }