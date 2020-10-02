/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of RoleContext
	 */
	public class RoleContextResponse {
	
		
		@SerializedName("AdditionalPermissions")
        private List<String> additionalPermissions;
		
		@SerializedName("Expiration")
        private String expiration;
		
		@SerializedName("Roles")
        private List<String> roles;



		/**
		 * Array of String, which represents the additional permissions
		 */
		public List<String> getAdditionalPermissions() {
			return additionalPermissions;
		}
		/**
		 * Array of String, which represents the additional permissions
		 */
		public void setAdditionalPermissions(List<String> additionalPermissions) {
			this.additionalPermissions = additionalPermissions;
		}
		/**
		 * Role expiration date
		 */
		public String getExpiration() {
			return expiration;
		}
		/**
		 * Role expiration date
		 */
		public void setExpiration(String expiration) {
			this.expiration = expiration;
		}
		/**
		 * Array of String, which represents the role name
		 */
		public List<String> getRoles() {
			return roles;
		}
		/**
		 * Array of String, which represents the role name
		 */
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
    }