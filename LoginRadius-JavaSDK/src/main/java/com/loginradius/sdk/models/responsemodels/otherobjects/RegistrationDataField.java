/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Custom registration data object
	// </summary>
	public class RegistrationDataField extends RegistrationDataFieldBasic {
	
		
		@SerializedName("Code")
        private String code;



		// <summary>
		//	Validation Code/Secret Code,Code Parameter, given when Login Dialog is performed
		// </summary>
		public String getCode() {
			return code;
		}
		// <summary>
		//	Validation Code/Secret Code,Code Parameter, given when Login Dialog is performed
		// </summary>
		public void setCode(String code) {
			this.code = code;
		}
    }