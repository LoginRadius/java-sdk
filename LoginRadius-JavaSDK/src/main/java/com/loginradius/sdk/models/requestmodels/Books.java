/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Books Property
	 */
	public class Books {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Book category
		 */
		public String getCategory() {
			return category;
		}
		/**
		 * Book category
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
		 * Id of book
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of book
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * book name
		 */
		public String getName() {
			return name;
		}
		/**
		 * book name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }