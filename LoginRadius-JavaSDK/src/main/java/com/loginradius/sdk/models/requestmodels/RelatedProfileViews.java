/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for RelatedProfileViews Property
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
		 * ID of the User
		 */
		public String getId() {
			return id;
		}
		/**
		 * ID of the User
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