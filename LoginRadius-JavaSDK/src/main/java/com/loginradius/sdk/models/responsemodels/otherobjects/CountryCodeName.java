/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Country Code data
	// </summary>
	public class CountryCodeName {
	
		
		@SerializedName("Code")
        private String code;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Country code
		// </summary>
		public String getCode() {
			return code;
		}
		// <summary>
		//	Country code
		// </summary>
		public void setCode(String code) {
			this.code = code;
		}
		// <summary>
		//	Country name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Country name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }