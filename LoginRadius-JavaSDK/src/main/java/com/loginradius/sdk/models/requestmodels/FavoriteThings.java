/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for FavoriteThings Property
	// </summary>
	public class FavoriteThings {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Type")
        private String type;



		// <summary>
		//	Id of favorite things
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of favorite things
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Name of favorite things
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of favorite things
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Type of favorite things
		// </summary>
		public String getType() {
			return type;
		}
		// <summary>
		//	Type of favorite things
		// </summary>
		public void setType(String type) {
			this.type = type;
		}
    }