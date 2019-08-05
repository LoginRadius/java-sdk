/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Album data
	// </summary>
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



		// <summary>
		//	Image url
		// </summary>
		public String getCoverImageUrl() {
			return coverImageUrl;
		}
		// <summary>
		//	Image url
		// </summary>
		public void setCoverImageUrl(String coverImageUrl) {
			this.coverImageUrl = coverImageUrl;
		}
		// <summary>
		//	Date of Creation of Profile
		// </summary>
		public String getCreatedDate() {
			return createdDate;
		}
		// <summary>
		//	Date of Creation of Profile
		// </summary>
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		// <summary>
		//	detailed information
		// </summary>
		public String getDescription() {
			return description;
		}
		// <summary>
		//	detailed information
		// </summary>
		public void setDescription(String description) {
			this.description = description;
		}
		// <summary>
		//	Directory's url
		// </summary>
		public String getDirectoryUrl() {
			return directoryUrl;
		}
		// <summary>
		//	Directory's url
		// </summary>
		public void setDirectoryUrl(String directoryUrl) {
			this.directoryUrl = directoryUrl;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public String getID() {
			return iD;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public void setID(String iD) {
			this.iD = iD;
		}
		// <summary>
		//	Number of images
		// </summary>
		public String getImageCount() {
			return imageCount;
		}
		// <summary>
		//	Number of images
		// </summary>
		public void setImageCount(String imageCount) {
			this.imageCount = imageCount;
		}
		// <summary>
		//	user's location
		// </summary>
		public String getLocation() {
			return location;
		}
		// <summary>
		//	user's location
		// </summary>
		public void setLocation(String location) {
			this.location = location;
		}
		// <summary>
		//	ID of account owner
		// </summary>
		public String getOwnerId() {
			return ownerId;
		}
		// <summary>
		//	ID of account owner
		// </summary>
		public void setOwnerId(String ownerId) {
			this.ownerId = ownerId;
		}
		// <summary>
		//	Name of account owner
		// </summary>
		public String getOwnerName() {
			return ownerName;
		}
		// <summary>
		//	Name of account owner
		// </summary>
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		// <summary>
		//	Title of Linked URL
		// </summary>
		public String getTitle() {
			return title;
		}
		// <summary>
		//	Title of Linked URL
		// </summary>
		public void setTitle(String title) {
			this.title = title;
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
		//	Updated date
		// </summary>
		public String getUpdatedDate() {
			return updatedDate;
		}
		// <summary>
		//	Updated date
		// </summary>
		public void setUpdatedDate(String updatedDate) {
			this.updatedDate = updatedDate;
		}
    }