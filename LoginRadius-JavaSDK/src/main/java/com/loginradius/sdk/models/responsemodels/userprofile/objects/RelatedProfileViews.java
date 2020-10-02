/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Related profileviews data
	 */
	public class RelatedProfileViews {
	
		
		@SerializedName("FirstName")
        private String firstName;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("LastName")
        private String lastName;



		/**
		 * user's first name
		 */
		public String getFirstName() {
			return firstName;
		}
		/**
		 * user's first name
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		/**
		 * Id of profile view
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of profile view
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * user's last name
		 */
		public String getLastName() {
			return lastName;
		}
		/**
		 * user's last name
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
    }