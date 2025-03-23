/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Roles data
	// </summary>
	public class AccountRolesModel {
	
		
		@SerializedName("Roles")
        private List<String> roles;



		// <summary>
		//	Array of String, which represents the role name
		// </summary>
		public List<String> getRoles() {
			return roles;
		}
		// <summary>
		//	Array of String, which represents the role name
		// </summary>
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
    }