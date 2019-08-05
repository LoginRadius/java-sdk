/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Age data
	// </summary>
	public class AgeRange {
	
		
		@SerializedName("Max")
        private Integer max;
		
		@SerializedName("Min")
        private Integer min;



		// <summary>
		//	Maximum Value Range
		// </summary>
		public Integer getMax() {
			return max;
		}
		// <summary>
		//	Maximum Value Range
		// </summary>
		public void setMax(Integer max) {
			this.max = max;
		}
		// <summary>
		//	Minimum Value Range
		// </summary>
		public Integer getMin() {
			return min;
		}
		// <summary>
		//	Minimum Value Range
		// </summary>
		public void setMin(Integer min) {
			this.min = min;
		}
    }