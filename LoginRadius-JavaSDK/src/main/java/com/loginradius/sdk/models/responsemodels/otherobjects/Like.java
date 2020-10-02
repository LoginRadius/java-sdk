/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete like data
	 */
	public class Like {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Website")
        private String website;



		/**
		 * Like category
		 */
		public String getCategory() {
			return category;
		}
		/**
		 * Like category
		 */
		public void setCategory(String category) {
			this.category = category;
		}
		/**
		 * Date of Creation of Profile
		 */
		public String getCreatedDate() {
			return createdDate;
		}
		/**
		 * Date of Creation of Profile
		 */
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		/**
		 * detailed information
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * detailed information
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		/**
		 * ID of the User
		 */
		public String getID() {
			return iD;
		}
		/**
		 * ID of the User
		 */
		public void setID(String iD) {
			this.iD = iD;
		}
		/**
		 * Name of the customer
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of the customer
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Personal Website a User has
		 */
		public String getWebsite() {
			return website;
		}
		/**
		 * Personal Website a User has
		 */
		public void setWebsite(String website) {
			this.website = website;
		}
    }