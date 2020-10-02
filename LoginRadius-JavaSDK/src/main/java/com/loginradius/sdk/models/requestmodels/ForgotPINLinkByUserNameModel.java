/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Forgot Pin Link By UserName API
	 */
	public class ForgotPINLinkByUserNameModel {
	
		
		@SerializedName("UserName")
        private String userName;



		/**
		 * Username of the user
		 */
		public String getUserName() {
			return userName;
		}
		/**
		 * Username of the user
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
    }