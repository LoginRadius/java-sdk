/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Validation and UserProfile data
	// </summary>
	public class UserProfilePostResponse<T> {
	
		
		@SerializedName("Data")
        private T data;
		
		@SerializedName("IsPosted")
        private Boolean isPosted;



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