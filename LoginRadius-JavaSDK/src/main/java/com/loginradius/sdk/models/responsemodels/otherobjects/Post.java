/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Post data
	// </summary>
	public class Post {
	
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("Likes")
        private int likes;
		
		@SerializedName("Message")
        private String message;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Picture")
        private String picture;
		
		@SerializedName("Place")
        private String place;
		
		@SerializedName("Share")
        private int share;
		
		@SerializedName("StartTime")
        private String startTime;
		
		@SerializedName("Title")
        private String title;
		
		@SerializedName("Type")
        private String type;
		
		@SerializedName("UpdateTime")
        private String updateTime;



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
		//	Likes
		// </summary>
		public int getLikes() {
			return likes;
		}
		// <summary>
		//	Likes
		// </summary>
		public void setLikes(int likes) {
			this.likes = likes;
		}
		// <summary>
		//	message
		// </summary>
		public String getMessage() {
			return message;
		}
		// <summary>
		//	message
		// </summary>
		public void setMessage(String message) {
			this.message = message;
		}
		// <summary>
		//	Name of the customer
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of the customer
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Images
		// </summary>
		public String getPicture() {
			return picture;
		}
		// <summary>
		//	Images
		// </summary>
		public void setPicture(String picture) {
			this.picture = picture;
		}
		// <summary>
		//	Location of user
		// </summary>
		public String getPlace() {
			return place;
		}
		// <summary>
		//	Location of user
		// </summary>
		public void setPlace(String place) {
			this.place = place;
		}
		// <summary>
		//	share
		// </summary>
		public int getShare() {
			return share;
		}
		// <summary>
		//	share
		// </summary>
		public void setShare(int share) {
			this.share = share;
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
		//	last update time
		// </summary>
		public String getUpdateTime() {
			return updateTime;
		}
		// <summary>
		//	last update time
		// </summary>
		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
    }