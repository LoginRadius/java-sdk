/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Registration Data create API
	 */
	public class RegistrationDataCreateModel {
	
		
		@SerializedName("Code")
        private String code;
		
		@SerializedName("IsActive")
        private Boolean isActive;
		
		@SerializedName("Key")
        private String key;
		
		@SerializedName("ParentId")
        private String parentId;
		
		@SerializedName("Type")
        private String type;
		
		@SerializedName("Value")
        private String value;



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
		/**
		 * boolean type value, default is true
		 */
		public Boolean getIsActive() {
			return isActive;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}
		/**
		 * Text to display for the dropdown member
		 */
		public String getKey() {
			return key;
		}
		/**
		 * Text to display for the dropdown member
		 */
		public void setKey(String key) {
			this.key = key;
		}
		/**
		 * Id of parent dropdown member
		 */
		public String getParentId() {
			return parentId;
		}
		/**
		 * Id of parent dropdown member
		 */
		public void setParentId(String parentId) {
			this.parentId = parentId;
		}
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