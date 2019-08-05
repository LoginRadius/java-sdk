/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Registration Data Basic Field
	// </summary>
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



		// <summary>
		//	Creation data
		// </summary>
		public String getDateCreated() {
			return dateCreated;
		}
		// <summary>
		//	Creation data
		// </summary>
		public void setDateCreated(String dateCreated) {
			this.dateCreated = dateCreated;
		}
		// <summary>
		//	Any modification date
		// </summary>
		public String getDateModified() {
			return dateModified;
		}
		// <summary>
		//	Any modification date
		// </summary>
		public void setDateModified(String dateModified) {
			this.dateModified = dateModified;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public Boolean getIsActive() {
			return isActive;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}
		// <summary>
		//	Text to display for the dropdown member
		// </summary>
		public String getKey() {
			return key;
		}
		// <summary>
		//	Text to display for the dropdown member
		// </summary>
		public void setKey(String key) {
			this.key = key;
		}
		// <summary>
		//	Id of parent dropdown member
		// </summary>
		public String getParentId() {
			return parentId;
		}
		// <summary>
		//	Id of parent dropdown member
		// </summary>
		public void setParentId(String parentId) {
			this.parentId = parentId;
		}
		// <summary>
		//	Parent type
		// </summary>
		public String getParentType() {
			return parentType;
		}
		// <summary>
		//	Parent type
		// </summary>
		public void setParentType(String parentType) {
			this.parentType = parentType;
		}
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