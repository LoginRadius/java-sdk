/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Complete verified response data
	 */
	public class VerifiedResponse {
	
		
		@SerializedName("IsPosted")
        private Boolean isPosted;
		
		@SerializedName("IsVerified")
        private Boolean isVerified;



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
		/**
		 * is verified or not
		 */
		public Boolean getIsVerified() {
			return isVerified;
		}
		/**
		 * is verified or not
		 */
		public void setIsVerified(Boolean isVerified) {
			this.isVerified = isVerified;
		}
    }