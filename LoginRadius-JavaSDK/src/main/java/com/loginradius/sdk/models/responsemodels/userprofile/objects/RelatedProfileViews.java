/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Related profileviews data
	// </summary>
	public class RelatedProfileViews {
	
		
		@SerializedName("FirstName")
        private String firstName;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("LastName")
        private String lastName;



		// <summary>
		//	user's first name
		// </summary>
		public String getFirstName() {
			return firstName;
		}
		// <summary>
		//	user's first name
		// </summary>
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		// <summary>
		//	Id of profile view
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of profile view
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	user's last name
		// </summary>
		public String getLastName() {
			return lastName;
		}
		// <summary>
		//	user's last name
		// </summary>
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
    }