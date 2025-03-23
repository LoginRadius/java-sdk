/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Games data
	// </summary>
	public class Games {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Category of game
		// </summary>
		public String getCategory() {
			return category;
		}
		// <summary>
		//	Category of game
		// </summary>
		public void setCategory(String category) {
			this.category = category;
		}
		// <summary>
		//	Game created date
		// </summary>
		public String getCreatedDate() {
			return createdDate;
		}
		// <summary>
		//	Game created date
		// </summary>
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		// <summary>
		//	Id of game
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of game
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Game name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Game name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }