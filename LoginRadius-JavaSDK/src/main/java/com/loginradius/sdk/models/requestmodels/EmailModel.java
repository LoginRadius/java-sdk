/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for EmailModel Property
	 */
	public class EmailModel {
	
		
		@SerializedName("Type")
        private String type;
		
		@SerializedName("Value")
        private String value;



		/**
		 * String to identify the type of parameter
		 */
		public String getType() {
			return type;
		}
		/**
		 * String to identify the type of parameter
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * Value of the dropdown member
		 */
		public String getValue() {
			return value;
		}
		/**
		 * Value of the dropdown member
		 */
		public void setValue(String value) {
			this.value = value;
		}
    }