/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Status API
	 */
	public class StatusModel {
	
		
		@SerializedName("caption")
        private String caption;
		
		@SerializedName("description")
        private String description;
		
		@SerializedName("imageurl")
        private String imageurl;
		
		@SerializedName("shorturl")
        private String shorturl;
		
		@SerializedName("status")
        private String status;
		
		@SerializedName("title")
        private String title;
		
		@SerializedName("url")
        private String url;



		/**
		 * Message displayed below the description(Requires URL, Under 70 Characters).
		 */
		public String getCaption() {
			return caption;
		}
		/**
		 * Message displayed below the description(Requires URL, Under 70 Characters).
		 */
		public void setCaption(String caption) {
			this.caption = caption;
		}
		/**
		 * Description of the displayed URL and Image
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * Description of the displayed URL and Image
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public String getImageurl() {
			return imageurl;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}
		/**
		 * short url
		 */
		public String getShorturl() {
			return shorturl;
		}
		/**
		 * short url
		 */
		public void setShorturl(String shorturl) {
			this.shorturl = shorturl;
		}
		/**
		 * Main body of the Status update.
		 */
		public String getStatus() {
			return status;
		}
		/**
		 * Main body of the Status update.
		 */
		public void setStatus(String status) {
			this.status = status;
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