/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Registration Data Basic Field
	 */
	public class RegistrationDataFieldBasic {
	
		
		@SerializedName("DateCreated")
        private String dateCreated;
		
		@SerializedName("DateModified")
        private String dateModified;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("IsActive")
        private Boolean isActive;
		
		@SerializedName("Key")
        private String key;
		
		@SerializedName("ParentId")
        private String parentId;
		
		@SerializedName("ParentType")
        private String parentType;
		
		@SerializedName("Type")
        private String type;
		
		@SerializedName("Value")
        private String value;



		/**
		 * Creation data
		 */
		public String getDateCreated() {
			return dateCreated;
		}
		/**
		 * Creation data
		 */
		public void setDateCreated(String dateCreated) {
			this.dateCreated = dateCreated;
		}
		/**
		 * Any modification date
		 */
		public String getDateModified() {
			return dateModified;
		}
		/**
		 * Any modification date
		 */
		public void setDateModified(String dateModified) {
			this.dateModified = dateModified;
		}
		/**
		 * ID of the User
		 */
		public String getId() {
			return id;
		}
		/**
		 * ID of the User
		 */
		public void setId(String id) {
			this.id = id;
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
		 * Parent type
		 */
		public String getParentType() {
			return parentType;
		}
		/**
		 * Parent type
		 */
		public void setParentType(String parentType) {
			this.parentType = parentType;
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