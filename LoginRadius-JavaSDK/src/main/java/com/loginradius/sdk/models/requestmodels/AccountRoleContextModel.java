/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of RoleContext payload
	// </summary>
	public class AccountRoleContextModel {
	
		
		@SerializedName("RoleContext")
        private List<RoleContextRoleModel> roleContext;



		// <summary>
		//	Array of RoleContext object, see body tab for structure
		// </summary>
		public List<RoleContextRoleModel> getRoleContext() {
			return roleContext;
		}
		// <summary>
		//	Array of RoleContext object, see body tab for structure
		// </summary>
		public void setRoleContext(List<RoleContextRoleModel> roleContext) {
			this.roleContext = roleContext;
		}
    }