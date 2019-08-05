/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Languages data
	// </summary>
	public class Languages {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Proficiency")
        private String proficiency;



		// <summary>
		//	Language id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Language id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Name of language
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of language
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Proficiency in language
		// </summary>
		public String getProficiency() {
			return proficiency;
		}
		// <summary>
		//	Proficiency in language
		// </summary>
		public void setProficiency(String proficiency) {
			this.proficiency = proficiency;
		}
    }