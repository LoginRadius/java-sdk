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
	//	Model Class containing Definition for WebhookAuthCredentials Property
	// </summary>
	public class WebhookAuthCredentials {
	
		
		@SerializedName("Username")
        private String username;
		
		@SerializedName("Password")
        private String password;



		// <summary>
		//	Username of the user
		// </summary>
		public String getUsername() {
			return username;
		}
		// <summary>
		//	Username of the user
		// </summary>
		public void setUsername(String username) {
			this.username = username;
		}
		// <summary>
		//	Password for the email
		// </summary>
		public String getPassword() {
			return password;
		}
		// <summary>
		//	Password for the email
		// </summary>
		public void setPassword(String password) {
			this.password = password;
		}
    }