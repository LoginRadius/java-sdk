/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Interests data
	// </summary>
	public class Interests {
	
		
		@SerializedName("InterestedName")
        private String interestedName;
		
		@SerializedName("InterestedType")
        private String interestedType;



		// <summary>
		//	Name of interested
		// </summary>
		public String getInterestedName() {
			return interestedName;
		}
		// <summary>
		//	Name of interested
		// </summary>
		public void setInterestedName(String interestedName) {
			this.interestedName = interestedName;
		}
		// <summary>
		//	Type of interested
		// </summary>
		public String getInterestedType() {
			return interestedType;
		}
		// <summary>
		//	Type of interested
		// </summary>
		public void setInterestedType(String interestedType) {
			this.interestedType = interestedType;
		}
    }