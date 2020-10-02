/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for RoleContextAdditionalPermissionRemoveRole API
	 */
	public class RoleContextAdditionalPermissionRemoveRoleModel {
	
		
		@SerializedName("AdditionalPermissions")
        private List<String> additionalPermissions;



		/**
		 * Array of String, which represents the additional permissions
		 */
		public List<String> getAdditionalPermissions() {
			return additionalPermissions;
		}
		/**
		 * Array of String, which represents the additional permissions
		 */
		public void setAdditionalPermissions(List<String> additionalPermissions) {
			this.additionalPermissions = additionalPermissions;
		}
    }