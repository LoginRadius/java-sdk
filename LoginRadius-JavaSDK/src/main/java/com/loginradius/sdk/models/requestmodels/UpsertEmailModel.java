/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for UpsertEmail Property
	 */
	public class UpsertEmailModel {
	
		
		@SerializedName("Email")
        private List<EmailModel> email;



		/**
		 * user's email
		 */
		public List<EmailModel> getEmail() {
			return email;
		}
		/**
		 * user's email
		 */
		public void setEmail(List<EmailModel> email) {
			this.email = email;
		}
    }