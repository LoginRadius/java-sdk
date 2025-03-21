/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Badges Property
	// </summary>
	public class Badges {
	
		
		@SerializedName("BadgeId")
        private String badgeId;
		
		@SerializedName("BadgeMessage")
        private String badgeMessage;
		
		@SerializedName("BageId")
        private String bageId;
		
		@SerializedName("BageMessage")
        private String bageMessage;
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("ImageUrl")
        private String imageUrl;
		
		@SerializedName("Name")
        private String name;



		// <summary>
		//	Badge ID
		// </summary>
		public String getBadgeId() {
			return badgeId;
		}
		// <summary>
		//	Badge ID
		// </summary>
		public void setBadgeId(String badgeId) {
			this.badgeId = badgeId;
		}
		// <summary>
		//	Badge Message
		// </summary>
		public String getBadgeMessage() {
			return badgeMessage;
		}
		// <summary>
		//	Badge Message
		// </summary>
		public void setBadgeMessage(String badgeMessage) {
			this.badgeMessage = badgeMessage;
		}
		// <summary>
		//	Bage Id
		// </summary>
		public String getBageId() {
			return bageId;
		}
		// <summary>
		//	Bage Id
		// </summary>
		public void setBageId(String bageId) {
			this.bageId = bageId;
		}
		// <summary>
		//	Bage Message
		// </summary>
		public String getBageMessage() {
			return bageMessage;
		}
		// <summary>
		//	Bage Message
		// </summary>
		public void setBageMessage(String bageMessage) {
			this.bageMessage = bageMessage;
		}
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
		//	Badge Name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Badge Name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }