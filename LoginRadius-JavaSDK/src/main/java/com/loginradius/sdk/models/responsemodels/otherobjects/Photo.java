/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Photo data
	 */
	public class Photo {
	
		
		@SerializedName("AlbumId")
        private String albumId;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("DirectUrl")
        private String directUrl;
		
		@SerializedName("Height")
        private String height;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("Images")
        private List<FacebookAlbumImages> images;
		
		@SerializedName("ImageUrl")
        private String imageUrl;
		
		@SerializedName("Link")
        private String link;
		
		@SerializedName("Location")
        private String location;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("OwnerId")
        private String ownerId;
		
		@SerializedName("OwnerName")
        private String ownerName;
		
		@SerializedName("UpdatedDate")
        private String updatedDate;
		
		@SerializedName("Width")
        private String width;



		/**
		 * User's Album Id
		 */
		public String getAlbumId() {
			return albumId;
		}
		/**
		 * User's Album Id
		 */
		public void setAlbumId(String albumId) {
			this.albumId = albumId;
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
		 * DirectUrl
		 */
		public String getDirectUrl() {
			return directUrl;
		}
		/**
		 * DirectUrl
		 */
		public void setDirectUrl(String directUrl) {
			this.directUrl = directUrl;
		}
		/**
		 * Height of the image
		 */
		public String getHeight() {
			return height;
		}
		/**
		 * Height of the image
		 */
		public void setHeight(String height) {
			this.height = height;
		}
		/**
		 * Id of the image
		 */
		public String getID() {
			return iD;
		}
		/**
		 * Id of the image
		 */
		public void setID(String iD) {
			this.iD = iD;
		}
		/**
		 * Images
		 */
		public List<FacebookAlbumImages> getImages() {
			return images;
		}
		/**
		 * Images
		 */
		public void setImages(List<FacebookAlbumImages> images) {
			this.images = images;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public String getImageUrl() {
			return imageUrl;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		/**
		 * Image's link
		 */
		public String getLink() {
			return link;
		}
		/**
		 * Image's link
		 */
		public void setLink(String link) {
			this.link = link;
		}
		/**
		 * Photo Location
		 */
		public String getLocation() {
			return location;
		}
		/**
		 * Photo Location
		 */
		public void setLocation(String location) {
			this.location = location;
		}
		/**
		 * Name of the image
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of the image
		 */
		public void setName(String name) {
			this.name = name;
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
		/**
		 * Width of the image
		 */
		public String getWidth() {
			return width;
		}
		/**
		 * Width of the image
		 */
		public void setWidth(String width) {
			this.width = width;
		}
    }