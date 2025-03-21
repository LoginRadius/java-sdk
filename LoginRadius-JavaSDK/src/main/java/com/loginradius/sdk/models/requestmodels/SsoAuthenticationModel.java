/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for SSO JWT Cloud API
	// </summary>
	public class SsoAuthenticationModel  {
	
		
		@SerializedName("email")
        private String email;
		
		@SerializedName("username")
        private String username ;
		
		@SerializedName("phone")
        private String phone;
		
		
		@SerializedName("password")
        private String password;
		


		// <summary>
		//	user's email
		// </summary>
		public String getEmail() {
			return email;
		}
		// <summary>
		//	user's email
		// </summary>
		public void setEmail(String email) {
			this.email = email;
		}
		// <summary>
		//	user's username
		// </summary>
		public String getUserName() {
			return username;
		}
		// <summary>
		//	user's username
		// </summary>
		public void setUserName(String username) {
			this.username = username;
		}
		// <summary>
		//	user's phone
		// </summary>
		public String getPhone() {
			return phone;
		}
		// <summary>
		//	user's phone
		// </summary>
		public void setPhone(String phone) {
			this.phone = phone;
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