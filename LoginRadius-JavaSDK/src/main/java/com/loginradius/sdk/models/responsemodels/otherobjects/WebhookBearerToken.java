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
	//	WebhookBearerToken for authentication
	// </summary>
	public class WebhookBearerToken {
	
		
		@SerializedName("Token")
        private String token;



		// <summary>
		//	Bearer Token for Webhook authentication
		// </summary>
		public String getToken() {
			return token;
		}
		// <summary>
		//	Bearer Token for Webhook authentication
		// </summary>
		public void setToken(String token) {
			this.token = token;
		}
    }