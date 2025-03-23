/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Validation data
	// </summary>
	public class PostMethodResponseBase {
	
		
		@SerializedName("isPosted")
        private Boolean isPosted;



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