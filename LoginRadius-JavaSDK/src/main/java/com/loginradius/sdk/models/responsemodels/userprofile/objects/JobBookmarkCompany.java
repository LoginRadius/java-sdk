/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Job Bookmark Company data
	 */
	public class JobBookmarkCompany {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Company id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Company id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Company name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Company name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }