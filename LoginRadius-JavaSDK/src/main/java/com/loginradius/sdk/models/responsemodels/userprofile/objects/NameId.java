/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete NameId data
	 */
	public class NameId {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }