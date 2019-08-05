/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Audio data
	// </summary>
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



		// <summary>
		//	Artist
		// </summary>
		public String getArtist() {
			return artist;
		}
		// <summary>
		//	Artist
		// </summary>
		public void setArtist(String artist) {
			this.artist = artist;
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
		//	Total time of audio
		// </summary>
		public String getDuration() {
			return duration;
		}
		// <summary>
		//	Total time of audio
		// </summary>
		public void setDuration(String duration) {
			this.duration = duration;
		}
		// <summary>
		//	Id of audio file
		// </summary>
		public String getID() {
			return iD;
		}
		// <summary>
		//	Id of audio file
		// </summary>
		public void setID(String iD) {
			this.iD = iD;
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
		//	Title of audio file
		// </summary>
		public String getTitle() {
			return title;
		}
		// <summary>
		//	Title of audio file
		// </summary>
		public void setTitle(String title) {
			this.title = title;
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
		//	String represents website url
		// </summary>
		public String getUrl() {
			return url;
		}
		// <summary>
		//	String represents website url
		// </summary>
		public void setUrl(String url) {
			this.url = url;
		}
    }