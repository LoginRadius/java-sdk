/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Reset Pin By Security Question and UserName API
	 */
	public class ResetPINBySecurityQuestionAnswerAndUsernameModel extends ResetPINBySecurityQuestionAnswer {
	
		
		@SerializedName("Username")
        private String username;



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