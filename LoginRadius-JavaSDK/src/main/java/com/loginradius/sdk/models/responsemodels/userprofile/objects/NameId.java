/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete NameId data
	// </summary>
	public class NameId {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }