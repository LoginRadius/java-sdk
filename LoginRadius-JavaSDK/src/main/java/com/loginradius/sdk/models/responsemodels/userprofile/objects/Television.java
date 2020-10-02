/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Television data
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
		 * Id of television
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of television
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Name of volunteer
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of volunteer
		 */
		public void setName(String name) {
			this.name = name;
		}
    }