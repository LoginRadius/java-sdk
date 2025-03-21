/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete PasswordHash data
	// </summary>
	public class UserPasswordHash {
	
		
		@SerializedName("PasswordHash")
        private String passwordHash;



		// <summary>
		//	Password hash
		// </summary>
		public String getPasswordHash() {
			return passwordHash;
		}
		// <summary>
		//	Password hash
		// </summary>
		public void setPasswordHash(String passwordHash) {
			this.passwordHash = passwordHash;
		}
    }