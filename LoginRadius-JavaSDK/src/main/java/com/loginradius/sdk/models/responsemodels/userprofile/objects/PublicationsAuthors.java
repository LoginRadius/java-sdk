/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Publications Authors data
	// </summary>
	public class PublicationsAuthors {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Author id of the publication
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Author id of the publication
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Author name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Author name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }