/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Username Authentication API
	// </summary>
	public class UserNameAuthenticationModel extends ReCaptchaModel {
	
		
		@SerializedName("password")
        private String password;
		
		@SerializedName("SecurityAnswer")
        private Map<String,String> securityAnswer;
		
		@SerializedName("username")
        private String username;



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
		// <summary>
		//	Valid JSON object of Unique Security Question ID and Answer of set Security Question. It is only required for locked accounts when logging in. Details about this feature
		// </summary>
		public Map<String,String> getSecurityAnswer() {
			return securityAnswer;
		}
		// <summary>
		//	Valid JSON object of Unique Security Question ID and Answer of set Security Question. It is only required for locked accounts when logging in. Details about this feature
		// </summary>
		public void setSecurityAnswer(Map<String,String> securityAnswer) {
			this.securityAnswer = securityAnswer;
		}
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
    }