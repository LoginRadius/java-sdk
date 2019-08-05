/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Status data
	// </summary>
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



		// <summary>
		//	Status date and time
		// </summary>
		public String getDateTime() {
			return dateTime;
		}
		// <summary>
		//	Status date and time
		// </summary>
		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public void setId(String id) {
			this.id = id;
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
		//	Status Link URL
		// </summary>
		public String getLinkUrl() {
			return linkUrl;
		}
		// <summary>
		//	Status Link URL
		// </summary>
		public void setLinkUrl(String linkUrl) {
			this.linkUrl = linkUrl;
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
		//	Status Place
		// </summary>
		public String getPlace() {
			return place;
		}
		// <summary>
		//	Status Place
		// </summary>
		public void setPlace(String place) {
			this.place = place;
		}
		// <summary>
		//	Status Source
		// </summary>
		public String getSource() {
			return source;
		}
		// <summary>
		//	Status Source
		// </summary>
		public void setSource(String source) {
			this.source = source;
		}
		// <summary>
		//	text user
		// </summary>
		public String getText() {
			return text;
		}
		// <summary>
		//	text user
		// </summary>
		public void setText(String text) {
			this.text = text;
		}
    }