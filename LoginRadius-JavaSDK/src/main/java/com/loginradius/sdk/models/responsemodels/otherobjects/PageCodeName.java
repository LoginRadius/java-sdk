/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Page Category data
	// </summary>
	public class PageCodeName {
	
		
		@SerializedName("Code")
        private String code;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	page code
		// </summary>
		public String getCode() {
			return code;
		}
		// <summary>
		//	page code
		// </summary>
		public void setCode(String code) {
			this.code = code;
		}
		// <summary>
		//	page code name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	page code name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }