/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Television data
	// </summary>
	public class Television {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Television category
		// </summary>
		public String getCategory() {
			return category;
		}
		// <summary>
		//	Television category
		// </summary>
		public void setCategory(String category) {
			this.category = category;
		}
		// <summary>
		//	Date
		// </summary>
		public String getCreatedDate() {
			return createdDate;
		}
		// <summary>
		//	Date
		// </summary>
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		// <summary>
		//	Id of television
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of television
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Name of volunteer
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of volunteer
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }