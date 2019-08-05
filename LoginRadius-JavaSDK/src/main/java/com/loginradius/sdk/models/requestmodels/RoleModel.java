/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Roles API
	// </summary>
	public class RoleModel {
	
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Permissions")
        private Map<String,Boolean> permissions;



		// <summary>
		//	Name of role
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of role
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