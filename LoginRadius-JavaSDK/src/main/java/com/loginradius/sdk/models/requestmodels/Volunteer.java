/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Volunteer Property
	 */
	public class Volunteer {
	
		
		@SerializedName("Cause")
        private String cause;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Organization")
        private String organization;
		
		@SerializedName("Role")
        private String role;



		/**
		 * Cause of volunteer
		 */
		public String getCause() {
			return cause;
		}
		/**
		 * Cause of volunteer
		 */
		public void setCause(String cause) {
			this.cause = cause;
		}
		/**
		 * Volunteer Id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Volunteer Id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Volunteer organization
		 */
		public String getOrganization() {
			return organization;
		}
		/**
		 * Volunteer organization
		 */
		public void setOrganization(String organization) {
			this.organization = organization;
		}
		/**
		 * Volunteer role
		 */
		public String getRole() {
			return role;
		}
		/**
		 * Volunteer role
		 */
		public void setRole(String role) {
			this.role = role;
		}
    }