/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete user custom object data
	 */
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



		/**
		 * custom object
		 */
		public JsonObject getCustomObject() {
			return customObject;
		}
		/**
		 * custom object
		 */
		public void setCustomObject(JsonObject customObject) {
			this.customObject = customObject;
		}
		/**
		 * Custom object created date
		 */
		public String getDateCreated() {
			return dateCreated;
		}
		/**
		 * Custom object created date
		 */
		public void setDateCreated(String dateCreated) {
			this.dateCreated = dateCreated;
		}
		/**
		 * Custom object modified date
		 */
		public String getDateModified() {
			return dateModified;
		}
		/**
		 * Custom object modified date
		 */
		public void setDateModified(String dateModified) {
			this.dateModified = dateModified;
		}
		/**
		 * Custom object id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Custom object id
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
		 * boolean type value, default is true
		 */
		public Boolean getIsDeleted() {
			return isDeleted;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setIsDeleted(Boolean isDeleted) {
			this.isDeleted = isDeleted;
		}
		/**
		 * UID, the unified identifier for each user account
		 */
		public String getUid() {
			return uid;
		}
		/**
		 * UID, the unified identifier for each user account
		 */
		public void setUid(String uid) {
			this.uid = uid;
		}
    }