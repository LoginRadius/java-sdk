/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Roles API
	 */
	public class RolesModel {
	
		
		@SerializedName("Roles")
        private List<com.loginradius.sdk.models.requestmodels.RoleModel> roles;



		/**
		 * Array of String, which represents the role name
		 */
		public List<com.loginradius.sdk.models.requestmodels.RoleModel> getRoles() {
			return roles;
		}
		/**
		 * Array of String, which represents the role name
		 */
		public void setRoles(List<com.loginradius.sdk.models.requestmodels.RoleModel> roles) {
			this.roles = roles;
		}
    }