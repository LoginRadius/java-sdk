/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for PermissionsModel Property
	// </summary>
	public class PermissionsModel {
	
		
		@SerializedName("Permissions")
        private List<String> permissions;



		// <summary>
		//	Any Permission name for the role
		// </summary>
		public List<String> getPermissions() {
			return permissions;
		}
		// <summary>
		//	Any Permission name for the role
		// </summary>
		public void setPermissions(List<String> permissions) {
			this.permissions = permissions;
		}
    }