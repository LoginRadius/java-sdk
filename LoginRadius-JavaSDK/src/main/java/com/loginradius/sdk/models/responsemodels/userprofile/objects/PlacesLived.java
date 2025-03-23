/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete PlacesLived data
	// </summary>
	public class PlacesLived {
	
		
		@SerializedName("IsPrimary")
        private Boolean isPrimary;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	place is primary or not
		// </summary>
		public Boolean getIsPrimary() {
			return isPrimary;
		}
		// <summary>
		//	place is primary or not
		// </summary>
		public void setIsPrimary(Boolean isPrimary) {
			this.isPrimary = isPrimary;
		}
		// <summary>
		//	Name of lived place
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of lived place
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }