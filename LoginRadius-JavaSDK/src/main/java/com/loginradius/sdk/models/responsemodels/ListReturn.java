/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete List data
	 */
	public class ListReturn<T> {
	
		
		@SerializedName("Data")
        private List<T> data;



		/**
		 * Data
		 */
		public List<T> getData() {
			return data;
		}
		/**
		 * Data
		 */
		public void setData(List<T> data) {
			this.data = data;
		}
    }