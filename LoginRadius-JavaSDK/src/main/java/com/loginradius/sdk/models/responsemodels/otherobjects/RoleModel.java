/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete role data
	 */
	public class RoleModel {
	
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Permissions")
        private Map<String,Boolean> permissions;



		/**
		 * Array of String, which represents the role name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Array of String, which represents the role name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Any Permission name for the role
		 */
		public Map<String,Boolean> getPermissions() {
			return permissions;
		}
		/**
		 * Any Permission name for the role
		 */
		public void setPermissions(Map<String,Boolean> permissions) {
			this.permissions = permissions;
		}
    }