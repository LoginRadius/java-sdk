/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Interests Property
	 */
	public class Interests {
	
		
		@SerializedName("InterestedName")
        private String interestedName;
		
		@SerializedName("InterestedType")
        private String interestedType;



		/**
		 * Name of interested
		 */
		public String getInterestedName() {
			return interestedName;
		}
		/**
		 * Name of interested
		 */
		public void setInterestedName(String interestedName) {
			this.interestedName = interestedName;
		}
		/**
		 * Type of interested
		 */
		public String getInterestedType() {
			return interestedType;
		}
		/**
		 * Type of interested
		 */
		public void setInterestedType(String interestedType) {
			this.interestedType = interestedType;
		}
    }