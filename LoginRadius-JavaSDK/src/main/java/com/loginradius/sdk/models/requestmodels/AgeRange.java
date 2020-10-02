/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Age Range Property
	 */
	public class AgeRange {
	
		
		@SerializedName("Max")
        private Integer max;
		
		@SerializedName("Min")
        private Integer min;



		/**
		 * Maximum Value Range
		 */
		public Integer getMax() {
			return max;
		}
		/**
		 * Maximum Value Range
		 */
		public void setMax(Integer max) {
			this.max = max;
		}
		/**
		 * Minimum Value Range
		 */
		public Integer getMin() {
			return min;
		}
		/**
		 * Minimum Value Range
		 */
		public void setMin(Integer min) {
			this.min = min;
		}
    }