/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Movies data
	 */
	public class Movies {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Category of movie
		 */
		public String getCategory() {
			return category;
		}
		/**
		 * Category of movie
		 */
		public void setCategory(String category) {
			this.category = category;
		}
		/**
		 * Movie created date
		 */
		public String getCreatedDate() {
			return createdDate;
		}
		/**
		 * Movie created date
		 */
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		/**
		 * Id of movie
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of movie
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Name of movie
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of movie
		 */
		public void setName(String name) {
			this.name = name;
		}
    }