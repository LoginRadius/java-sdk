/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for NameId Property
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