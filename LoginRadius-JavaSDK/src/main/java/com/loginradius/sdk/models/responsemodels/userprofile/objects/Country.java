/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Country data
	 */
	public class Country {
	
		
		@SerializedName("Code")
        private String code;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Country code
		 */
		public String getCode() {
			return code;
		}
		/**
		 * Country code
		 */
		public void setCode(String code) {
			this.code = code;
		}
		/**
		 * Country name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Country name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }