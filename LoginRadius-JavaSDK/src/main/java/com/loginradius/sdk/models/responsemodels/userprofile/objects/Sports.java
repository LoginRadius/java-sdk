/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Sports data
	 */
	public class Sports {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Id of sport
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of sport
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Name of sport
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of sport
		 */
		public void setName(String name) {
			this.name = name;
		}
    }