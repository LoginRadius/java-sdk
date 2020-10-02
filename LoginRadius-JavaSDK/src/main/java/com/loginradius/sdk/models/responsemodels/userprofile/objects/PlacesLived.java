/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete PlacesLived data
	 */
	public class PlacesLived {
	
		
		@SerializedName("IsPrimary")
        private Boolean isPrimary;
		
		@SerializedName("Name")
        private String name;



		/**
		 * place is primary or not
		 */
		public Boolean getIsPrimary() {
			return isPrimary;
		}
		/**
		 * place is primary or not
		 */
		public void setIsPrimary(Boolean isPrimary) {
			this.isPrimary = isPrimary;
		}
		/**
		 * Name of lived place
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of lived place
		 */
		public void setName(String name) {
			this.name = name;
		}
    }