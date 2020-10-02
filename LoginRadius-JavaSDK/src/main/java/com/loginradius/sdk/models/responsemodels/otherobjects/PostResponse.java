/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Validation data
	 */
	public class PostResponse {
	
		
		@SerializedName("IsPosted")
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