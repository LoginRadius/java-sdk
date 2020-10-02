/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Skills data
	 */
	public class Skills {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * id of skill
		 */
		public String getId() {
			return id;
		}
		/**
		 * id of skill
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * name of skills
		 */
		public String getName() {
			return name;
		}
		/**
		 * name of skills
		 */
		public void setName(String name) {
			this.name = name;
		}
    }