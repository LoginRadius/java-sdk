/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Speciality data
	 */
	public class Speciality {
	
		
		@SerializedName("SpecialityNames")
        private List<String> specialityNames;
		
		@SerializedName("Total")
        private int total;



		/**
		 * User's speciality names
		 */
		public List<String> getSpecialityNames() {
			return specialityNames;
		}
		/**
		 * User's speciality names
		 */
		public void setSpecialityNames(List<String> specialityNames) {
			this.specialityNames = specialityNames;
		}
		/**
		 * Total User's speciality
		 */
		public int getTotal() {
			return total;
		}
		/**
		 * Total User's speciality
		 */
		public void setTotal(int total) {
			this.total = total;
		}
    }