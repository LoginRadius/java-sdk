/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Forgot Pin Link By UserName API
	// </summary>
	public class ForgotPINLinkByUserNameModel {
	
		
		@SerializedName("UserName")
        private String userName;



		// <summary>
		//	Username of the user
		// </summary>
		public String getUserName() {
			return userName;
		}
		// <summary>
		//	Username of the user
		// </summary>
		public void setUserName(String userName) {
			this.userName = userName;
		}
    }