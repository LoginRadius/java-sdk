/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete group data
	 */
	public class Group {
	
		
		@SerializedName("Country")
        private String country;
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("Email")
        private String email;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("Image")
        private String image;
		
		@SerializedName("Logo")
        private String logo;
		
		@SerializedName("MemberCount")
        private String memberCount;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("PostalCode")
        private String postalCode;
		
		@SerializedName("Type")
        private String type;



		/**
		 * Country of the user
		 */
		public String getCountry() {
			return country;
		}
		/**
		 * Country of the user
		 */
		public void setCountry(String country) {
			this.country = country;
		}
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
		 * user's email
		 */
		public String getEmail() {
			return email;
		}
		/**
		 * user's email
		 */
		public void setEmail(String email) {
			this.email = email;
		}
		/**
		 * Identity providers
		 */
		public String getID() {
			return iD;
		}
		/**
		 * Identity providers
		 */
		public void setID(String iD) {
			this.iD = iD;
		}
		/**
		 * Images
		 */
		public String getImage() {
			return image;
		}
		/**
		 * Images
		 */
		public void setImage(String image) {
			this.image = image;
		}
		/**
		 * logo
		 */
		public String getLogo() {
			return logo;
		}
		/**
		 * logo
		 */
		public void setLogo(String logo) {
			this.logo = logo;
		}
		/**
		 * Number of members
		 */
		public String getMemberCount() {
			return memberCount;
		}
		/**
		 * Number of members
		 */
		public void setMemberCount(String memberCount) {
			this.memberCount = memberCount;
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
		 * Postal code value that need to be updated
		 */
		public String getPostalCode() {
			return postalCode;
		}
		/**
		 * Postal code value that need to be updated
		 */
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
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
    }