/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for RoleContextRole API
	 */
	public class RoleContextRoleModel {
	
		
		@SerializedName("AdditionalPermissions")
        private List<String> additionalPermissions;
		
		@SerializedName("Context")
        private String context;
		
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
		 * Array of RoleContext object, see body tab for structure
		 */
		public String getContext() {
			return context;
		}
		/**
		 * Array of RoleContext object, see body tab for structure
		 */
		public void setContext(String context) {
			this.context = context;
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