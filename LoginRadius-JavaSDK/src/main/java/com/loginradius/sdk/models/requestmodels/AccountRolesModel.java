/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Create Role API
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