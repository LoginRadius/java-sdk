/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Validation data
	// </summary>
	public class PostResponse {
	
		
		@SerializedName("IsPosted")
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