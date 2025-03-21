/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Reset Pin By Security Question and UserName API
	// </summary>
	public class ResetPINBySecurityQuestionAnswerAndUsernameModel extends ResetPINBySecurityQuestionAnswer {
	
		
		@SerializedName("Username")
        private String username;



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