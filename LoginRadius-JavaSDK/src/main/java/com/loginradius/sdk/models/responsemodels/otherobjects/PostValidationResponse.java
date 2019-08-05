/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Validation data
	// </summary>
	public class PostValidationResponse {
	
		
		@SerializedName("IsValid")
        private Boolean isValid;



		// <summary>
		//	check data is validate
		// </summary>
		public Boolean getIsValid() {
			return isValid;
		}
		// <summary>
		//	check data is validate
		// </summary>
		public void setIsValid(Boolean isValid) {
			this.isValid = isValid;
		}
    }