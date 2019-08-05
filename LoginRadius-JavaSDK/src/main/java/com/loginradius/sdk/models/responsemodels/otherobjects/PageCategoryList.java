/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Page Category data
	// </summary>
	public class PageCategoryList {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Page category id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Page category id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Page category name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Page category name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }