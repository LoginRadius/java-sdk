/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	
	// </summary>
	public class EmailIdModel {
	
		
		@SerializedName("EmailId")
        private String emailId;



		// <summary>
		//	
		// </summary>
		public String getEmailId() {
			return emailId;
		}
		// <summary>
		//	
		// </summary>
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
    }