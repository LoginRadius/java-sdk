/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Photo data
	// </summary>
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



		// <summary>
		//	User's Album Id
		// </summary>
		public String getAlbumId() {
			return albumId;
		}
		// <summary>
		//	User's Album Id
		// </summary>
		public void setAlbumId(String albumId) {
			this.albumId = albumId;
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
		//	DirectUrl
		// </summary>
		public String getDirectUrl() {
			return directUrl;
		}
		// <summary>
		//	DirectUrl
		// </summary>
		public void setDirectUrl(String directUrl) {
			this.directUrl = directUrl;
		}
		// <summary>
		//	Height of the image
		// </summary>
		public String getHeight() {
			return height;
		}
		// <summary>
		//	Height of the image
		// </summary>
		public void setHeight(String height) {
			this.height = height;
		}
		// <summary>
		//	Id of the image
		// </summary>
		public String getID() {
			return iD;
		}
		// <summary>
		//	Id of the image
		// </summary>
		public void setID(String iD) {
			this.iD = iD;
		}
		// <summary>
		//	Images
		// </summary>
		public List<FacebookAlbumImages> getImages() {
			return images;
		}
		// <summary>
		//	Images
		// </summary>
		public void setImages(List<FacebookAlbumImages> images) {
			this.images = images;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public String getImageUrl() {
			return imageUrl;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		// <summary>
		//	Image's link
		// </summary>
		public String getLink() {
			return link;
		}
		// <summary>
		//	Image's link
		// </summary>
		public void setLink(String link) {
			this.link = link;
		}
		// <summary>
		//	Photo Location
		// </summary>
		public String getLocation() {
			return location;
		}
		// <summary>
		//	Photo Location
		// </summary>
		public void setLocation(String location) {
			this.location = location;
		}
		// <summary>
		//	Name of the image
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of the image
		// </summary>
		public void setName(String name) {
			this.name = name;
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
		// <summary>
		//	Width of the image
		// </summary>
		public String getWidth() {
			return width;
		}
		// <summary>
		//	Width of the image
		// </summary>
		public void setWidth(String width) {
			this.width = width;
		}
    }