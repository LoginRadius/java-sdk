/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for PermissionsModel Property
	 */
	public class PermissionsModel {
	
		
		@SerializedName("Permissions")
        private List<String> permissions;



		/**
		 * Any Permission name for the role
		 */
		public List<String> getPermissions() {
			return permissions;
		}
		/**
		 * Any Permission name for the role
		 */
		public void setPermissions(List<String> permissions) {
			this.permissions = permissions;
		}
    }