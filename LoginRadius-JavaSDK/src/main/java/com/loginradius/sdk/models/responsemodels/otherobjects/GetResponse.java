/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete GetType data
	 */
	public class GetResponse<T> {
	
		
		@SerializedName("Data")
        private T data;



		/**
		 * Data
		 */
		public T getData() {
			return data;
		}
		/**
		 * Data
		 */
		public void setData(T data) {
			this.data = data;
		}
    }