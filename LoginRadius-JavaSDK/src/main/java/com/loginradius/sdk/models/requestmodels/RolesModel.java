/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Roles API
	// </summary>
	public class RolesModel {
	
		
		@SerializedName("Roles")
        private List<com.loginradius.sdk.models.requestmodels.RoleModel> roles;



		// <summary>
		//	Array of String, which represents the role name
		// </summary>
		public List<com.loginradius.sdk.models.requestmodels.RoleModel> getRoles() {
			return roles;
		}
		// <summary>
		//	Array of String, which represents the role name
		// </summary>
		public void setRoles(List<com.loginradius.sdk.models.requestmodels.RoleModel> roles) {
			this.roles = roles;
		}
    }