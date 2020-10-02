/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Roles API
	 */
	public class RoleModel {
	
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Permissions")
        private Map<String,Boolean> permissions;



		/**
		 * Name of role
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of role
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