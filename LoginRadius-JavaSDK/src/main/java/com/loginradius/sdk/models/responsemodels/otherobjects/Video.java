/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Video data
	 */
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
		 * Video direct link
		 */
		public String getDirectLink() {
			return directLink;
		}
		/**
		 * Video direct link
		 */
		public void setDirectLink(String directLink) {
			this.directLink = directLink;
		}
		/**
		 * Video duration
		 */
		public String getDuration() {
			return duration;
		}
		/**
		 * Video duration
		 */
		public void setDuration(String duration) {
			this.duration = duration;
		}
		/**
		 * Embed html of video
		 */
		public String getEmbedHtml() {
			return embedHtml;
		}
		/**
		 * Embed html of video
		 */
		public void setEmbedHtml(String embedHtml) {
			this.embedHtml = embedHtml;
		}
		/**
		 * Video id
		 */
		public String getID() {
			return iD;
		}
		/**
		 * Video id
		 */
		public void setID(String iD) {
			this.iD = iD;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public String getImage() {
			return image;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public void setImage(String image) {
			this.image = image;
		}
		/**
		 * Video name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Video name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Video owner id
		 */
		public String getOwnerId() {
			return ownerId;
		}
		/**
		 * Video owner id
		 */
		public void setOwnerId(String ownerId) {
			this.ownerId = ownerId;
		}
		/**
		 * Video owner name
		 */
		public String getOwnerName() {
			return ownerName;
		}
		/**
		 * Video owner name
		 */
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		/**
		 * Source of video
		 */
		public String getSource() {
			return source;
		}
		/**
		 * Source of video
		 */
		public void setSource(String source) {
			this.source = source;
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