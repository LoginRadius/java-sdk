/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for RoleContextRole API
	// </summary>
	public class RoleContextRoleModel {
	
		
		@SerializedName("AdditionalPermissions")
        private List<String> additionalPermissions;
		
		@SerializedName("Context")
        private String context;
		
		@SerializedName("Expiration")
        private String expiration;
		
		@SerializedName("Roles")
        private List<String> roles;



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
		// <summary>
		//	Array of RoleContext object, see body tab for structure
		// </summary>
		public String getContext() {
			return context;
		}
		// <summary>
		//	Array of RoleContext object, see body tab for structure
		// </summary>
		public void setContext(String context) {
			this.context = context;
		}
		// <summary>
		//	Role expiration date
		// </summary>
		public String getExpiration() {
			return expiration;
		}
		// <summary>
		//	Role expiration date
		// </summary>
		public void setExpiration(String expiration) {
			this.expiration = expiration;
		}
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