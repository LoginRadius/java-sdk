/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of RoleContext payload
	 */
	public class AccountRoleContextModel {
	
		
		@SerializedName("RoleContext")
        private List<RoleContextRoleModel> roleContext;



		/**
		 * Array of RoleContext object, see body tab for structure
		 */
		public List<RoleContextRoleModel> getRoleContext() {
			return roleContext;
		}
		/**
		 * Array of RoleContext object, see body tab for structure
		 */
		public void setRoleContext(List<RoleContextRoleModel> roleContext) {
			this.roleContext = roleContext;
		}
    }