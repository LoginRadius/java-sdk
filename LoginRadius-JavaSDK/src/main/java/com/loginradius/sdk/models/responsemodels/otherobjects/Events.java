/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Events data
	 */
	public class Events {
	
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("EndTime")
        private String endTime;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("Location")
        private String location;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("OwnerId")
        private String ownerId;
		
		@SerializedName("OwnerName")
        private String ownerName;
		
		@SerializedName("Privacy")
        private String privacy;
		
		@SerializedName("RsvpStatus")
        private String rsvpStatus;
		
		@SerializedName("StartTime")
        private String startTime;
		
		@SerializedName("UpdatedDate")
        private String updatedDate;



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
		 * EndTime
		 */
		public String getEndTime() {
			return endTime;
		}
		/**
		 * EndTime
		 */
		public void setEndTime(String endTime) {
			this.endTime = endTime;
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
		 * Event Location
		 */
		public String getLocation() {
			return location;
		}
		/**
		 * Event Location
		 */
		public void setLocation(String location) {
			this.location = location;
		}
		/**
		 * Event name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Event name
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
		 * Privacy
		 */
		public String getPrivacy() {
			return privacy;
		}
		/**
		 * Privacy
		 */
		public void setPrivacy(String privacy) {
			this.privacy = privacy;
		}
		/**
		 * RsvpStatus
		 */
		public String getRsvpStatus() {
			return rsvpStatus;
		}
		/**
		 * RsvpStatus
		 */
		public void setRsvpStatus(String rsvpStatus) {
			this.rsvpStatus = rsvpStatus;
		}
		/**
		 * Start time
		 */
		public String getStartTime() {
			return startTime;
		}
		/**
		 * Start time
		 */
		public void setStartTime(String startTime) {
			this.startTime = startTime;
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