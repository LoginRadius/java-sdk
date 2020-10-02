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
	public class PageCodeName {
	
		
		@SerializedName("Code")
        private String code;
		
		@SerializedName("Name")
        private String name;



		/**
		 * page code
		 */
		public String getCode() {
			return code;
		}
		/**
		 * page code
		 */
		public void setCode(String code) {
			this.code = code;
		}
		/**
		 * page code name
		 */
		public String getName() {
			return name;
		}
		/**
		 * page code name
		 */
		public void setName(String name) {
			this.name = name;
		}
    }