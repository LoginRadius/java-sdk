/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete role data
	// </summary>
	public class RoleModel {
	
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Permissions")
        private Map<String,Boolean> permissions;



		// <summary>
		//	Array of String, which represents the role name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Array of String, which represents the role name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Any Permission name for the role
		// </summary>
		public Map<String,Boolean> getPermissions() {
			return permissions;
		}
		// <summary>
		//	Any Permission name for the role
		// </summary>
		public void setPermissions(Map<String,Boolean> permissions) {
			this.permissions = permissions;
		}
    }