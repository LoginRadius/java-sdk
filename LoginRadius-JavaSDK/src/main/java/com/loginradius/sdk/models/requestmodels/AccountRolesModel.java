/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Create Role API
	 */
	public class AccountRolesModel {
	
		
		@SerializedName("Roles")
        private List<String> roles;



		/**
		 * Array of String, which represents the role name
		 */
		public List<String> getRoles() {
			return roles;
		}
		/**
		 * Array of String, which represents the role name
		 */
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
    }