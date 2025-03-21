/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Books Property
	// </summary>
	public class Books {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Book category
		// </summary>
		public String getCategory() {
			return category;
		}
		// <summary>
		//	Book category
		// </summary>
		public void setCategory(String category) {
			this.category = category;
		}
		// <summary>
		//	Date of Creation of Profile
		// </summary>
		public String getCreatedDate() {
			return createdDate;
		}
		// <summary>
		//	Date of Creation of Profile
		// </summary>
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		// <summary>
		//	Id of book
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of book
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	book name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	book name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }