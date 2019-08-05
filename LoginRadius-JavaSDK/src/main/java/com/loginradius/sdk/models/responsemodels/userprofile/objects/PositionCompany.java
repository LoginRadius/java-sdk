/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Position Company data
	// </summary>
	public class PositionCompany {
	
		
		@SerializedName("Industry")
        private String industry;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Type")
        private String type;



		// <summary>
		//	position company industry
		// </summary>
		public String getIndustry() {
			return industry;
		}
		// <summary>
		//	position company industry
		// </summary>
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		// <summary>
		//	position company name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	position company name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	position company type
		// </summary>
		public String getType() {
			return type;
		}
		// <summary>
		//	position company type
		// </summary>
		public void setType(String type) {
			this.type = type;
		}
    }