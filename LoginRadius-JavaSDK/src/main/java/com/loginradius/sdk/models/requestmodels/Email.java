/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Email Property
	// </summary>
	public class Email {
	
		
		@SerializedName("Type")
        private String type;
		
		@SerializedName("Value")
        private String value;



		// <summary>
		//	type of email id
		// </summary>
		public String getType() {
			return type;
		}
		// <summary>
		//	type of email id
		// </summary>
		public void setType(String type) {
			this.type = type;
		}
		// <summary>
		//	Email address
		// </summary>
		public String getValue() {
			return value;
		}
		// <summary>
		//	Email address
		// </summary>
		public void setValue(String value) {
			this.value = value;
		}
    }