/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Events data
	// </summary>
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
		//	EndTime
		// </summary>
		public String getEndTime() {
			return endTime;
		}
		// <summary>
		//	EndTime
		// </summary>
		public void setEndTime(String endTime) {
			this.endTime = endTime;
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
		//	Event Location
		// </summary>
		public String getLocation() {
			return location;
		}
		// <summary>
		//	Event Location
		// </summary>
		public void setLocation(String location) {
			this.location = location;
		}
		// <summary>
		//	Event name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Event name
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
		//	Privacy
		// </summary>
		public String getPrivacy() {
			return privacy;
		}
		// <summary>
		//	Privacy
		// </summary>
		public void setPrivacy(String privacy) {
			this.privacy = privacy;
		}
		// <summary>
		//	RsvpStatus
		// </summary>
		public String getRsvpStatus() {
			return rsvpStatus;
		}
		// <summary>
		//	RsvpStatus
		// </summary>
		public void setRsvpStatus(String rsvpStatus) {
			this.rsvpStatus = rsvpStatus;
		}
		// <summary>
		//	Start time
		// </summary>
		public String getStartTime() {
			return startTime;
		}
		// <summary>
		//	Start time
		// </summary>
		public void setStartTime(String startTime) {
			this.startTime = startTime;
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