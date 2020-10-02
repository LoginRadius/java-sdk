/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Television Property
	 */
	public class Television {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Television category
		 */
		public String getCategory() {
			return category;
		}
		/**
		 * Television category
		 */
		public void setCategory(String category) {
			this.category = category;
		}
		/**
		 * Date
		 */
		public String getCreatedDate() {
			return createdDate;
		}
		/**
		 * Date
		 */
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
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
    }