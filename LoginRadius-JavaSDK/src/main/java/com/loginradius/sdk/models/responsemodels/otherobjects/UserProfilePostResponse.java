/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Validation and UserProfile data
	 */
	public class UserProfilePostResponse<T> {
	
		
		@SerializedName("Data")
        private T data;
		
		@SerializedName("IsPosted")
        private Boolean isPosted;



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