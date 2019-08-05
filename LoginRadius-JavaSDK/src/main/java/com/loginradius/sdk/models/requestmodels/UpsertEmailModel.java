/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for UpsertEmail Property
	// </summary>
	public class UpsertEmailModel {
	
		
		@SerializedName("Email")
        private List<EmailModel> email;



		// <summary>
		//	user's email
		// </summary>
		public List<EmailModel> getEmail() {
			return email;
		}
		// <summary>
		//	user's email
		// </summary>
		public void setEmail(List<EmailModel> email) {
			this.email = email;
		}
    }