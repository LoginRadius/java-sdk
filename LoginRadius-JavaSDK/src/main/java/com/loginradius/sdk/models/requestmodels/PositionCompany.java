/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for PositionCompany Property
	 */
	public class PositionCompany {
	
		
		@SerializedName("Industry")
        private String industry;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Type")
        private String type;



		/**
		 * position company industry
		 */
		public String getIndustry() {
			return industry;
		}
		/**
		 * position company industry
		 */
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		/**
		 * position company name
		 */
		public String getName() {
			return name;
		}
		/**
		 * position company name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * position company type
		 */
		public String getType() {
			return type;
		}
		/**
		 * position company type
		 */
		public void setType(String type) {
			this.type = type;
		}
    }