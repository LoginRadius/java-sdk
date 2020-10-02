/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Validation and profile data
	 */
	public class PostMethodResponse<T> {
	
		
		@SerializedName("data")
        private T data;
		
		@SerializedName("isPosted")
        private Boolean isPosted;



		/**
		 * Complete user profile data
		 */
		public T getData() {
			return data;
		}
		/**
		 * Complete user profile data
		 */
		public void setData(T data) {
			this.data = data;
		}
		/**
		 * check data is posted
		 */
		public Boolean getIsPosted() {
			return isPosted;
		}
		/**
		 * check data is posted
		 */
		public void setIsPosted(Boolean isPosted) {
			this.isPosted = isPosted;
		}
    }