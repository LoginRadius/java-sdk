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
	public class PostValidationResponse {
	
		
		@SerializedName("IsValid")
        private Boolean isValid;



		/**
		 * check data is validate
		 */
		public Boolean getIsValid() {
			return isValid;
		}
		/**
		 * check data is validate
		 */
		public void setIsValid(Boolean isValid) {
			this.isValid = isValid;
		}
    }