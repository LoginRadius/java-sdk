/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Album data
	 */
	public class Album {
	
		
		@SerializedName("CoverImageUrl")
        private String coverImageUrl;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("DirectoryUrl")
        private String directoryUrl;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("ImageCount")
        private String imageCount;
		
		@SerializedName("Location")
        private String location;
		
		@SerializedName("OwnerId")
        private String ownerId;
		
		@SerializedName("OwnerName")
        private String ownerName;
		
		@SerializedName("Title")
        private String title;
		
		@SerializedName("Type")
        private String type;
		
		@SerializedName("UpdatedDate")
        private String updatedDate;



		/**
		 * Image url
		 */
		public String getCoverImageUrl() {
			return coverImageUrl;
		}
		/**
		 * Image url
		 */
		public void setCoverImageUrl(String coverImageUrl) {
			this.coverImageUrl = coverImageUrl;
		}
		/**
		 * Date of Creation of Profile
		 */
		public String getCreatedDate() {
			return createdDate;
		}
		/**
		 * Date of Creation of Profile
		 */
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		/**
		 * detailed information
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * detailed information
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		/**
		 * Directory's url
		 */
		public String getDirectoryUrl() {
			return directoryUrl;
		}
		/**
		 * Directory's url
		 */
		public void setDirectoryUrl(String directoryUrl) {
			this.directoryUrl = directoryUrl;
		}
		/**
		 * ID of the User
		 */
		public String getID() {
			return iD;
		}
		/**
		 * ID of the User
		 */
		public void setID(String iD) {
			this.iD = iD;
		}
		/**
		 * Number of images
		 */
		public String getImageCount() {
			return imageCount;
		}
		/**
		 * Number of images
		 */
		public void setImageCount(String imageCount) {
			this.imageCount = imageCount;
		}
		/**
		 * user's location
		 */
		public String getLocation() {
			return location;
		}
		/**
		 * user's location
		 */
		public void setLocation(String location) {
			this.location = location;
		}
		/**
		 * ID of account owner
		 */
		public String getOwnerId() {
			return ownerId;
		}
		/**
		 * ID of account owner
		 */
		public void setOwnerId(String ownerId) {
			this.ownerId = ownerId;
		}
		/**
		 * Name of account owner
		 */
		public String getOwnerName() {
			return ownerName;
		}
		/**
		 * Name of account owner
		 */
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		/**
		 * Title of Linked URL
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * Title of Linked URL
		 */
		public void setTitle(String title) {
			this.title = title;
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
		 * Updated date
		 */
		public String getUpdatedDate() {
			return updatedDate;
		}
		/**
		 * Updated date
		 */
		public void setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
		}
    }