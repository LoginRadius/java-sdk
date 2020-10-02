/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Contact data
	 */
	public class Contact {
	
		
		@SerializedName("Country")
        private String country;
		
		@SerializedName("DateOfBirth")
        private String dateOfBirth;
		
		@SerializedName("EmailID")
        private String emailID;
		
		@SerializedName("Gender")
        private String gender;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("ImageUrl")
        private String imageUrl;
		
		@SerializedName("Industry")
        private String industry;
		
		@SerializedName("Location")
        private String location;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("PhoneNumber")
        private String phoneNumber;
		
		@SerializedName("ProfileUrl")
        private String profileUrl;
		
		@SerializedName("Status")
        private String status;



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
		 * user's date of birth
		 */
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		/**
		 * user's date of birth
		 */
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		/**
		 * user's email address
		 */
		public String getEmailID() {
			return emailID;
		}
		/**
		 * user's email address
		 */
		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}
		/**
		 * user's gender
		 */
		public String getGender() {
			return gender;
		}
		/**
		 * user's gender
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}
		/**
		 * Contact ID
		 */
		public String getID() {
			return iD;
		}
		/**
		 * Contact ID
		 */
		public void setID(String iD) {
			this.iD = iD;
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
		 * Industry name
		 */
		public String getIndustry() {
			return industry;
		}
		/**
		 * Industry name
		 */
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		/**
		 * Contact location
		 */
		public String getLocation() {
			return location;
		}
		/**
		 * Contact location
		 */
		public void setLocation(String location) {
			this.location = location;
		}
		/**
		 * Contact's name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Contact's name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Phone number of contact
		 */
		public String getPhoneNumber() {
			return phoneNumber;
		}
		/**
		 * Phone number of contact
		 */
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		/**
		 * Profile URL
		 */
		public String getProfileUrl() {
			return profileUrl;
		}
		/**
		 * Profile URL
		 */
		public void setProfileUrl(String profileUrl) {
			this.profileUrl = profileUrl;
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
    }