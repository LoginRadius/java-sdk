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
	//	Credentials for basic authentication
	// </summary>
	public class WebhookBasicAuthCredentials {
	
		
		@SerializedName("Username")
        private String username;
		
		@SerializedName("Password")
        private String password;



		// <summary>
		//	Username for basic authentication
		// </summary>
		public String getUsername() {
			return username;
		}
		// <summary>
		//	Username for basic authentication
		// </summary>
		public void setUsername(String username) {
			this.username = username;
		}
		// <summary>
		//	Password for basic authentication
		// </summary>
		public String getPassword() {
			return password;
		}
		// <summary>
		//	Password for basic authentication
		// </summary>
		public void setPassword(String password) {
			this.password = password;
		}
    }