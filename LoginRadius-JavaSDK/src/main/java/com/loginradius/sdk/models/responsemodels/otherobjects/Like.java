/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete like data
	// </summary>
	public class Like {
	
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Website")
        private String website;



		// <summary>
		//	Like category
		// </summary>
		public String getCategory() {
			return category;
		}
		// <summary>
		//	Like category
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
		//	detailed information
		// </summary>
		public String getDescription() {
			return description;
		}
		// <summary>
		//	detailed information
		// </summary>
		public void setDescription(String description) {
			this.description = description;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public String getID() {
			return iD;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public void setID(String iD) {
			this.iD = iD;
		}
		// <summary>
		//	Name of the customer
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of the customer
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Personal Website a User has
		// </summary>
		public String getWebsite() {
			return website;
		}
		// <summary>
		//	Personal Website a User has
		// </summary>
		public void setWebsite(String website) {
			this.website = website;
		}
    }