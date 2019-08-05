/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition Complete ExistResponse data
	// </summary>
	public class ExistResponse {
	
		
		@SerializedName("IsExist")
        private Boolean isExist;



		// <summary>
		//	IsExist
		// </summary>
		public Boolean getIsExist() {
			return isExist;
		}
		// <summary>
		//	IsExist
		// </summary>
		public void setIsExist(Boolean isExist) {
			this.isExist = isExist;
		}
    }