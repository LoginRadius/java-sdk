/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for EmailModel Property
	// </summary>
	public class EmailModel {
	
		
		@SerializedName("Type")
        private String type;
		
		@SerializedName("Value")
        private String value;



		// <summary>
		//	String to identify the type of parameter
		// </summary>
		public String getType() {
			return type;
		}
		// <summary>
		//	String to identify the type of parameter
		// </summary>
		public void setType(String type) {
			this.type = type;
		}
		// <summary>
		//	Value of the dropdown member
		// </summary>
		public String getValue() {
			return value;
		}
		// <summary>
		//	Value of the dropdown member
		// </summary>
		public void setValue(String value) {
			this.value = value;
		}
    }