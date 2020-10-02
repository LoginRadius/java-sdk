/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Page Category data
	 */
	public class PageCategoryList {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Page category id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Page category id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Page category name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Page category name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }