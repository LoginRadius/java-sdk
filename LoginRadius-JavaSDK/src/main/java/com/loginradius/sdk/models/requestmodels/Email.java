/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Email Property
	 */
	public class Email {
	
		
		@SerializedName("Type")
        private String type;
		
		@SerializedName("Value")
        private String value;



		/**
		 * type of email id
		 */
		public String getType() {
			return type;
		}
		/**
		 * type of email id
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * Email address
		 */
		public String getValue() {
			return value;
		}
		/**
		 * Email address
		 */
		public void setValue(String value) {
			this.value = value;
		}
    }