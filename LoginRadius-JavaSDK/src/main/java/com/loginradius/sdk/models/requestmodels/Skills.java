/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Skills Property
	// </summary>
	public class Skills {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	id of skill
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	id of skill
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	name of skills
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	name of skills
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }