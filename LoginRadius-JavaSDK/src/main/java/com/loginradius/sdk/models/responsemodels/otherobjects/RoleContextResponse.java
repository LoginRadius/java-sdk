/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of RoleContext
	// </summary>
	public class RoleContextResponse {
	
		
		@SerializedName("AdditionalPermissions")
        private List<String> additionalPermissions;
		
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