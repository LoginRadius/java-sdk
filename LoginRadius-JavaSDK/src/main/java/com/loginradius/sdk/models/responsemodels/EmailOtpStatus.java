/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	
	// </summary>
	public class EmailOtpStatus {
	
		
		@SerializedName("Email")
        private String email;



		// <summary>
		//	
		// </summary>
		public String getEmail() {
			return email;
		}
		// <summary>
		//	
		// </summary>
		public void setEmail(String email) {
			this.email = email;
		}
    }