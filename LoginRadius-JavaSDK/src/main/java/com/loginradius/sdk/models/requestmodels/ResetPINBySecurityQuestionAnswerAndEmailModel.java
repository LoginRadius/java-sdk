/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Reset Pin By Security Question and Email API
	 */
	public class ResetPINBySecurityQuestionAnswerAndEmailModel extends ResetPINBySecurityQuestionAnswer {
	
		
		@SerializedName("Email")
        private String email;



		/**
		 * user's email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * user's email
		 */
		public void setEmail(String email) {
			this.email = email;
		}
    }