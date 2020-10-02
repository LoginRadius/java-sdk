/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete PasswordHash data
	 */
	public class UserPasswordHash {
	
		
		@SerializedName("PasswordHash")
        private String passwordHash;



		/**
		 * Password hash
		 */
		public String getPasswordHash() {
			return passwordHash;
		}
		/**
		 * Password hash
		 */
		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
    }