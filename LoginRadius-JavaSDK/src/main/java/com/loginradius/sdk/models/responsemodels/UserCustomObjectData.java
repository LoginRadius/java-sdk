/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete user custom object data
	// </summary>
	public class UserCustomObjectData {
	
		
		@SerializedName("CustomObject")
        private JsonObject customObject;
		
		@SerializedName("DateCreated")
        private String dateCreated;
		
		@SerializedName("DateModified")
        private String dateModified;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("IsActive")
        private Boolean isActive;
		
		@SerializedName("IsDeleted")
        private Boolean isDeleted;
		
		@SerializedName("Uid")
        private String uid;



		// <summary>
		//	custom object
		// </summary>
		public JsonObject getCustomObject() {
			return customObject;
		}
		// <summary>
		//	custom object
		// </summary>
		public void setCustomObject(JsonObject customObject) {
			this.customObject = customObject;
		}
		// <summary>
		//	Custom object created date
		// </summary>
		public String getDateCreated() {
			return dateCreated;
		}
		// <summary>
		//	Custom object created date
		// </summary>
		public void setDateCreated(String dateCreated) {
			this.dateCreated = dateCreated;
		}
		// <summary>
		//	Custom object modified date
		// </summary>
		public String getDateModified() {
			return dateModified;
		}
		// <summary>
		//	Custom object modified date
		// </summary>
		public void setDateModified(String dateModified) {
			this.dateModified = dateModified;
		}
		// <summary>
		//	Custom object id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Custom object id
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
		//	boolean type value, default is true
		// </summary>
		public Boolean getIsDeleted() {
			return isDeleted;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setIsDeleted(Boolean isDeleted) {
			this.isDeleted = isDeleted;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public String getUid() {
			return uid;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public void setUid(String uid) {
			this.uid = uid;
		}
    }