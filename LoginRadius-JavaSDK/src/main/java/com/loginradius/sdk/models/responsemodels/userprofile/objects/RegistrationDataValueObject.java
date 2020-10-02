/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Registration Data value
	 */
	public class RegistrationDataValueObject {
	
		
		@SerializedName("Id")
        private String id;



		/**
		 * ID of the User
		 */
		public String getId() {
			return id;
		}
		/**
		 * ID of the User
		 */
		public void setId(String id) {
			this.id = id;
		}
    }