/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Post data
	 */
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
		 * Likes
		 */
		public int getLikes() {
			return likes;
		}
		/**
		 * Likes
		 */
		public void setLikes(int likes) {
			this.likes = likes;
		}
		/**
		 * message
		 */
		public String getMessage() {
			return message;
		}
		/**
		 * message
		 */
		public void setMessage(String message) {
			this.message = message;
		}
		/**
		 * Name of the customer
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of the customer
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Images
		 */
		public String getPicture() {
			return picture;
		}
		/**
		 * Images
		 */
		public void setPicture(String picture) {
			this.picture = picture;
		}
		/**
		 * Location of user
		 */
		public String getPlace() {
			return place;
		}
		/**
		 * Location of user
		 */
		public void setPlace(String place) {
			this.place = place;
		}
		/**
		 * share
		 */
		public int getShare() {
			return share;
		}
		/**
		 * share
		 */
		public void setShare(int share) {
			this.share = share;
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
		 * Title of Linked URL
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * Title of Linked URL
		 */
		public void setTitle(String title) {
			this.title = title;
		}
		/**
		 * String to identify the type of parameter
		 */
		public String getType() {
			return type;
		}
		/**
		 * String to identify the type of parameter
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * last update time
		 */
		public String getUpdateTime() {
			return updateTime;
		}
		/**
		 * last update time
		 */
		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
    }