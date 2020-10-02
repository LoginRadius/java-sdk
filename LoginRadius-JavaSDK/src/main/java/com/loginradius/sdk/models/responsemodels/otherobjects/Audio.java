/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Audio data
	 */
	public class Audio {
	
		
		@SerializedName("Artist")
        private String artist;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Duration")
        private String duration;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("OwnerId")
        private String ownerId;
		
		@SerializedName("OwnerName")
        private String ownerName;
		
		@SerializedName("Title")
        private String title;
		
		@SerializedName("UpdatedDate")
        private String updatedDate;
		
		@SerializedName("Url")
        private String url;



		/**
		 * Artist
		 */
		public String getArtist() {
			return artist;
		}
		/**
		 * Artist
		 */
		public void setArtist(String artist) {
			this.artist = artist;
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
		 * Total time of audio
		 */
		public String getDuration() {
			return duration;
		}
		/**
		 * Total time of audio
		 */
		public void setDuration(String duration) {
			this.duration = duration;
		}
		/**
		 * Id of audio file
		 */
		public String getID() {
			return iD;
		}
		/**
		 * Id of audio file
		 */
		public void setID(String iD) {
			this.iD = iD;
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
		 * Title of audio file
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * Title of audio file
		 */
		public void setTitle(String title) {
			this.title = title;
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
		 * String represents website url
		 */
		public String getUrl() {
			return url;
		}
		/**
		 * String represents website url
		 */
		public void setUrl(String url) {
			this.url = url;
		}
    }