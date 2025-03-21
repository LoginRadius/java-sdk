/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Courses Property
	// </summary>
	public class Courses {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Number")
        private String number;



		// <summary>
		//	Course id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Course id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Course name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Course name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Course number
		// </summary>
		public String getNumber() {
			return number;
		}
		// <summary>
		//	Course number
		// </summary>
		public void setNumber(String number) {
			this.number = number;
		}
    }