/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Complete verified response data
	// </summary>
	public class VerifiedResponse {
	
		
		@SerializedName("IsPosted")
        private Boolean isPosted;
		
		@SerializedName("IsVerified")
        private Boolean isVerified;



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
		// <summary>
		//	is verified or not
		// </summary>
		public Boolean getIsVerified() {
			return isVerified;
		}
		// <summary>
		//	is verified or not
		// </summary>
		public void setIsVerified(Boolean isVerified) {
			this.isVerified = isVerified;
		}
    }