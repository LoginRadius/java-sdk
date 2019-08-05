/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Speciality data
	// </summary>
	public class Speciality {
	
		
		@SerializedName("SpecialityNames")
        private List<String> specialityNames;
		
		@SerializedName("Total")
        private int total;



		// <summary>
		//	User's speciality names
		// </summary>
		public List<String> getSpecialityNames() {
			return specialityNames;
		}
		// <summary>
		//	User's speciality names
		// </summary>
		public void setSpecialityNames(List<String> specialityNames) {
			this.specialityNames = specialityNames;
		}
		// <summary>
		//	Total User's speciality
		// </summary>
		public int getTotal() {
			return total;
		}
		// <summary>
		//	Total User's speciality
		// </summary>
		public void setTotal(int total) {
			this.total = total;
		}
    }