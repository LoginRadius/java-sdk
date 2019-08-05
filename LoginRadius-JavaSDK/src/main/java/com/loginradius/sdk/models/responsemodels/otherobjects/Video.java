/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Video data
	// </summary>
	public class Video {
	
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("DirectLink")
        private String directLink;
		
		@SerializedName("Duration")
        private String duration;
		
		@SerializedName("EmbedHtml")
        private String embedHtml;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("Image")
        private String image;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("OwnerId")
        private String ownerId;
		
		@SerializedName("OwnerName")
        private String ownerName;
		
		@SerializedName("Source")
        private String source;
		
		@SerializedName("UpdatedDate")
        private String updatedDate;



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
		//	Video direct link
		// </summary>
		public String getDirectLink() {
			return directLink;
		}
		// <summary>
		//	Video direct link
		// </summary>
		public void setDirectLink(String directLink) {
			this.directLink = directLink;
		}
		// <summary>
		//	Video duration
		// </summary>
		public String getDuration() {
			return duration;
		}
		// <summary>
		//	Video duration
		// </summary>
		public void setDuration(String duration) {
			this.duration = duration;
		}
		// <summary>
		//	Embed html of video
		// </summary>
		public String getEmbedHtml() {
			return embedHtml;
		}
		// <summary>
		//	Embed html of video
		// </summary>
		public void setEmbedHtml(String embedHtml) {
			this.embedHtml = embedHtml;
		}
		// <summary>
		//	Video id
		// </summary>
		public String getID() {
			return iD;
		}
		// <summary>
		//	Video id
		// </summary>
		public void setID(String iD) {
			this.iD = iD;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public String getImage() {
			return image;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public void setImage(String image) {
			this.image = image;
		}
		// <summary>
		//	Video name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Video name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Video owner id
		// </summary>
		public String getOwnerId() {
			return ownerId;
		}
		// <summary>
		//	Video owner id
		// </summary>
		public void setOwnerId(String ownerId) {
			this.ownerId = ownerId;
		}
		// <summary>
		//	Video owner name
		// </summary>
		public String getOwnerName() {
			return ownerName;
		}
		// <summary>
		//	Video owner name
		// </summary>
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		// <summary>
		//	Source of video
		// </summary>
		public String getSource() {
			return source;
		}
		// <summary>
		//	Source of video
		// </summary>
		public void setSource(String source) {
			this.source = source;
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