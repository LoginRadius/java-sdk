/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Courses data
	 */
	public class Courses {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Number")
        private String number;



		/**
		 * Course id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Course id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Course name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Course name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Course number
		 */
		public String getNumber() {
			return number;
		}
		/**
		 * Course number
		 */
		public void setNumber(String number) {
			this.number = number;
		}
    }