/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Favorite data
	 */
	public class FavoriteThings {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Type")
        private String type;



		/**
		 * Id of favorite things
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of favorite things
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Name of favorite things
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of favorite things
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Type of favorite things
		 */
		public String getType() {
			return type;
		}
		/**
		 * Type of favorite things
		 */
		public void setType(String type) {
			this.type = type;
		}
    }