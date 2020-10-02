/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Validation data
	 */
	public class PostMethodResponseBase {
	
		
		@SerializedName("isPosted")
        private Boolean isPosted;



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