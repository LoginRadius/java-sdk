/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Volunteer Property
	// </summary>
	public class Volunteer {
	
		
		@SerializedName("Cause")
        private String cause;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Organization")
        private String organization;
		
		@SerializedName("Role")
        private String role;



		// <summary>
		//	Cause of volunteer
		// </summary>
		public String getCause() {
			return cause;
		}
		// <summary>
		//	Cause of volunteer
		// </summary>
		public void setCause(String cause) {
			this.cause = cause;
		}
		// <summary>
		//	Volunteer Id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Volunteer Id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Volunteer organization
		// </summary>
		public String getOrganization() {
			return organization;
		}
		// <summary>
		//	Volunteer organization
		// </summary>
		public void setOrganization(String organization) {
			this.organization = organization;
		}
		// <summary>
		//	Volunteer role
		// </summary>
		public String getRole() {
			return role;
		}
		// <summary>
		//	Volunteer role
		// </summary>
		public void setRole(String role) {
			this.role = role;
		}
    }