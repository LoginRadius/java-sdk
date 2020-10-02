/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition Complete ExistResponse data
	 */
	public class ExistResponse {
	
		
		@SerializedName("IsExist")
        private Boolean isExist;



		/**
		 * IsExist
		 */
		public Boolean getIsExist() {
			return isExist;
		}
		/**
		 * IsExist
		 */
		public void setIsExist(Boolean isExist) {
			this.isExist = isExist;
		}
    }