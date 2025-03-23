/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for RoleContextAdditionalPermissionRemoveRole API
	// </summary>
	public class RoleContextAdditionalPermissionRemoveRoleModel {
	
		
		@SerializedName("AdditionalPermissions")
        private List<String> additionalPermissions;



		// <summary>
		//	Array of String, which represents the additional permissions
		// </summary>
		public List<String> getAdditionalPermissions() {
			return additionalPermissions;
		}
		// <summary>
		//	Array of String, which represents the additional permissions
		// </summary>
		public void setAdditionalPermissions(List<String> additionalPermissions) {
			this.additionalPermissions = additionalPermissions;
		}
    }