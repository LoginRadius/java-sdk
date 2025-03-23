/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete List data
	// </summary>
	public class ListData<T> {
	
		
		@SerializedName("Count")
        private int count;
		
		@SerializedName("data")
        private List<T> data;



		// <summary>
		//	count
		// </summary>
		public int getCount() {
			return count;
		}
		// <summary>
		//	count
		// </summary>
		public void setCount(int count) {
			this.count = count;
		}
		// <summary>
		//	Data
		// </summary>
		public List<T> getData() {
			return data;
		}
		// <summary>
		//	Data
		// </summary>
		public void setData(List<T> data) {
			this.data = data;
		}
    }