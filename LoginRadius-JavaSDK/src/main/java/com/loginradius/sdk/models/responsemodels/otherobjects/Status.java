/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Status data
	 */
	public class Status {
	
		
		@SerializedName("DateTime")
        private String dateTime;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("ImageUrl")
        private String imageUrl;
		
		@SerializedName("Likes")
        private int likes;
		
		@SerializedName("LinkUrl")
        private String linkUrl;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Place")
        private String place;
		
		@SerializedName("Source")
        private String source;
		
		@SerializedName("Text")
        private String text;



		/**
		 * Status date and time
		 */
		public String getDateTime() {
			return dateTime;
		}
		/**
		 * Status date and time
		 */
		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
		/**
		 * ID of the User
		 */
		public String getId() {
			return id;
		}
		/**
		 * ID of the User
		 */
		public void setId(String id) {
			this.id = id;
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
		 * Status Link URL
		 */
		public String getLinkUrl() {
			return linkUrl;
		}
		/**
		 * Status Link URL
		 */
		public void setLinkUrl(String linkUrl) {
			this.linkUrl = linkUrl;
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
		 * Status Place
		 */
		public String getPlace() {
			return place;
		}
		/**
		 * Status Place
		 */
		public void setPlace(String place) {
			this.place = place;
		}
		/**
		 * Status Source
		 */
		public String getSource() {
			return source;
		}
		/**
		 * Status Source
		 */
		public void setSource(String source) {
			this.source = source;
		}
		/**
		 * text user
		 */
		public String getText() {
			return text;
		}
		/**
		 * text user
		 */
		public void setText(String text) {
			this.text = text;
		}
    }