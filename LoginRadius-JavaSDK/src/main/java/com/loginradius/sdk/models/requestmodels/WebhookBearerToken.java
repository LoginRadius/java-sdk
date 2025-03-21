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
	//	Model Class containing Definition for WebhookBearerToken Property
	// </summary>
	public class WebhookBearerToken {
	
		
		@SerializedName("Token")
        private String token;



		// <summary>
		//	Webhook Bearer Token
		// </summary>
		public String getToken() {
			return token;
		}
		// <summary>
		//	Webhook Bearer Token
		// </summary>
		public void setToken(String token) {
			this.token = token;
		}
    }