/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for InspirationalPeople Property
	// </summary>
	public class InspirationalPeople {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	ID of inspirational people
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	ID of inspirational people
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	name of inspirational people
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	name of inspirational people
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }