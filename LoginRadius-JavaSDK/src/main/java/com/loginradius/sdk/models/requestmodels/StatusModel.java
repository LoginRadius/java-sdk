/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Status API
	// </summary>
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



		// <summary>
		//	Message displayed below the description(Requires URL, Under 70 Characters).
		// </summary>
		public String getCaption() {
			return caption;
		}
		// <summary>
		//	Message displayed below the description(Requires URL, Under 70 Characters).
		// </summary>
		public void setCaption(String caption) {
			this.caption = caption;
		}
		// <summary>
		//	Description of the displayed URL and Image
		// </summary>
		public String getDescription() {
			return description;
		}
		// <summary>
		//	Description of the displayed URL and Image
		// </summary>
		public void setDescription(String description) {
			this.description = description;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public String getImageurl() {
			return imageurl;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public void setImageurl(String imageurl) {
			this.imageurl = imageurl;
		}
		// <summary>
		//	short url
		// </summary>
		public String getShorturl() {
			return shorturl;
		}
		// <summary>
		//	short url
		// </summary>
		public void setShorturl(String shorturl) {
			this.shorturl = shorturl;
		}
		// <summary>
		//	Main body of the Status update.
		// </summary>
		public String getStatus() {
			return status;
		}
		// <summary>
		//	Main body of the Status update.
		// </summary>
		public void setStatus(String status) {
			this.status = status;
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