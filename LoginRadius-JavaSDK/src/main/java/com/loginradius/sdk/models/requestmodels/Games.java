/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Games Property
	 */
	public class Games {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Category of game
		 */
		public String getCategory() {
			return category;
		}
		/**
		 * Category of game
		 */
		public void setCategory(String category) {
			this.category = category;
		}
		/**
		 * Game created date
		 */
		public String getCreatedDate() {
			return createdDate;
		}
		/**
		 * Game created date
		 */
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		/**
		 * Id of game
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of game
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Game name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Game name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }