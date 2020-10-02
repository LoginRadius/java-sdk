/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Username Authentication API
	 */
	public class UserNameAuthenticationModel extends ReCaptchaModel {
	
		
		@SerializedName("password")
        private String password;
		
		@SerializedName("SecurityAnswer")
        private Map<String,String> securityAnswer;
		
		@SerializedName("username")
        private String username;



		/**
		 * Password for the email
		 */
		public String getPassword() {
			return password;
		}
		/**
		 * Password for the email
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 * Valid JSON object of Unique Security Question ID and Answer of set Security Question. It is only required for locked accounts when logging in. Details about this feature
		 */
		public Map<String,String> getSecurityAnswer() {
			return securityAnswer;
		}
		/**
		 * Valid JSON object of Unique Security Question ID and Answer of set Security Question. It is only required for locked accounts when logging in. Details about this feature
		 */
		public void setSecurityAnswer(Map<String,String> securityAnswer) {
			this.securityAnswer = securityAnswer;
		}
		/**
		 * Username of the user
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * Username of the user
		 */
		public void setUsername(String username) {
			this.username = username;
		}
    }