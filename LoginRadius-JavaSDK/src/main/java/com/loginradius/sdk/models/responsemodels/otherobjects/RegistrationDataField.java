/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Custom registration data object
	 */
	public class RegistrationDataField extends RegistrationDataFieldBasic {
	
		
		@SerializedName("Code")
        private String code;



		/**
		 * Validation Code/Secret Code,Code Parameter, given when Login Dialog is performed
		 */
		public String getCode() {
			return code;
		}
		/**
		 * Validation Code/Secret Code,Code Parameter, given when Login Dialog is performed
		 */
		public void setCode(String code) {
			this.code = code;
		}
    }