/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Movies Property
	// </summary>
	public class Movies {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Category of movie
		// </summary>
		public String getCategory() {
			return category;
		}
		// <summary>
		//	Category of movie
		// </summary>
		public void setCategory(String category) {
			this.category = category;
		}
		// <summary>
		//	Movie created date
		// </summary>
		public String getCreatedDate() {
			return createdDate;
		}
		// <summary>
		//	Movie created date
		// </summary>
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		// <summary>
		//	Id of movie
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of movie
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Name of movie
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of movie
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }