/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for ResetPasswordBySecurityAnswerAndEmail API
	 */
	public class ResetPasswordBySecurityAnswerAndEmailModel {
	
		
		@SerializedName("Email")
        private String email;
		
		@SerializedName("password")
        private String password;
		
		@SerializedName("ResetPasswordEmailTemplate")
        private String resetPasswordEmailTemplate;
		
		@SerializedName("SecurityAnswer")
        private Map<String,String> securityAnswer;



		/**
		 * LoginRadius user identifier (if phone no login then phone no and if email login then email id)
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * LoginRadius user identifier (if phone no login then phone no and if email login then email id)
		 */
		public void setEmail(String email) {
			this.email = email;
		}
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
		 * If you are sending an email via the sendemail parameter, this parameter allows you to specify which reset Password email template you would like to use.
		 */
		public String getResetPasswordEmailTemplate() {
			return resetPasswordEmailTemplate;
		}
		/**
		 * If you are sending an email via the sendemail parameter, this parameter allows you to specify which reset Password email template you would like to use.
		 */
		public void setResetPasswordEmailTemplate(String resetPasswordEmailTemplate) {
			this.resetPasswordEmailTemplate = resetPasswordEmailTemplate;
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
    }