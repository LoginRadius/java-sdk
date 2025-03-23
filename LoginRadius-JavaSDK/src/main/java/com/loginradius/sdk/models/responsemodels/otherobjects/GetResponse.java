/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete GetType data
	// </summary>
	public class GetResponse<T> {
	
		
		@SerializedName("Data")
        private T data;



		// <summary>
		//	Data
		// </summary>
		public T getData() {
			return data;
		}
		// <summary>
		//	Data
		// </summary>
		public void setData(T data) {
			this.data = data;
		}
    }