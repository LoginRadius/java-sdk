/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for ResetPasswordBySecurityAnswerAndEmail API
	// </summary>
	public class ResetPasswordBySecurityAnswerAndEmailModel {
	
		
		@SerializedName("Email")
        private String email;
		
		@SerializedName("password")
        private String password;
		
		@SerializedName("ResetPasswordEmailTemplate")
        private String resetPasswordEmailTemplate;
		
		@SerializedName("SecurityAnswer")
        private Map<String,String> securityAnswer;



		// <summary>
		//	LoginRadius user identifier (if phone no login then phone no and if email login then email id)
		// </summary>
		public String getEmail() {
			return email;
		}
		// <summary>
		//	LoginRadius user identifier (if phone no login then phone no and if email login then email id)
		// </summary>
		public void setEmail(String email) {
			this.email = email;
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
		// <summary>
		//	If you are sending an email via the sendemail parameter, this parameter allows you to specify which reset Password email template you would like to use.
		// </summary>
		public String getResetPasswordEmailTemplate() {
			return resetPasswordEmailTemplate;
		}
		// <summary>
		//	If you are sending an email via the sendemail parameter, this parameter allows you to specify which reset Password email template you would like to use.
		// </summary>
		public void setResetPasswordEmailTemplate(String resetPasswordEmailTemplate) {
			this.resetPasswordEmailTemplate = resetPasswordEmailTemplate;
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
    }