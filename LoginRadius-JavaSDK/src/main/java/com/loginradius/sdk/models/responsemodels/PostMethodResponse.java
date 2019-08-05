/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Validation and profile data
	// </summary>
	public class PostMethodResponse<T> {
	
		
		@SerializedName("data")
        private T data;
		
		@SerializedName("isPosted")
        private Boolean isPosted;



		// <summary>
		//	Complete user profile data
		// </summary>
		public T getData() {
			return data;
		}
		// <summary>
		//	Complete user profile data
		// </summary>
		public void setData(T data) {
			this.data = data;
		}
		// <summary>
		//	check data is posted
		// </summary>
		public Boolean getIsPosted() {
			return isPosted;
		}
		// <summary>
		//	check data is posted
		// </summary>
		public void setIsPosted(Boolean isPosted) {
			this.isPosted = isPosted;
		}
    }