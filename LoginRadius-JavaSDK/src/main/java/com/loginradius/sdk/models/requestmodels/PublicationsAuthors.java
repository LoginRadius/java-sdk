/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for PublicationsAuthors Property
	 */
	public class PublicationsAuthors {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Author id of the publication
		 */
		public String getId() {
			return id;
		}
		/**
		 * Author id of the publication
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Author name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Author name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }