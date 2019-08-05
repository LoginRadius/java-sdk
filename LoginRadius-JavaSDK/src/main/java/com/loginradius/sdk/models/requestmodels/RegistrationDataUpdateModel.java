/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Registration Data update API
	// </summary>
	public class RegistrationDataUpdateModel {
	
		
		@SerializedName("Code")
        private String code;
		
		@SerializedName("Id")
        private String id;
		
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