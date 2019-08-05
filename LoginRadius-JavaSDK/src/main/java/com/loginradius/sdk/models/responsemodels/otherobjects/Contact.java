/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Contact data
	// </summary>
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



		// <summary>
		//	Country of the user
		// </summary>
		public String getCountry() {
			return country;
		}
		// <summary>
		//	Country of the user
		// </summary>
		public void setCountry(String country) {
			this.country = country;
		}
		// <summary>
		//	user's date of birth
		// </summary>
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		// <summary>
		//	user's date of birth
		// </summary>
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		// <summary>
		//	user's email address
		// </summary>
		public String getEmailID() {
			return emailID;
		}
		// <summary>
		//	user's email address
		// </summary>
		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}
		// <summary>
		//	user's gender
		// </summary>
		public String getGender() {
			return gender;
		}
		// <summary>
		//	user's gender
		// </summary>
		public void setGender(String gender) {
			this.gender = gender;
		}
		// <summary>
		//	Contact ID
		// </summary>
		public String getID() {
			return iD;
		}
		// <summary>
		//	Contact ID
		// </summary>
		public void setID(String iD) {
			this.iD = iD;
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
		//	Industry name
		// </summary>
		public String getIndustry() {
			return industry;
		}
		// <summary>
		//	Industry name
		// </summary>
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		// <summary>
		//	Contact location
		// </summary>
		public String getLocation() {
			return location;
		}
		// <summary>
		//	Contact location
		// </summary>
		public void setLocation(String location) {
			this.location = location;
		}
		// <summary>
		//	Contact's name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Contact's name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Phone number of contact
		// </summary>
		public String getPhoneNumber() {
			return phoneNumber;
		}
		// <summary>
		//	Phone number of contact
		// </summary>
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		// <summary>
		//	Profile URL
		// </summary>
		public String getProfileUrl() {
			return profileUrl;
		}
		// <summary>
		//	Profile URL
		// </summary>
		public void setProfileUrl(String profileUrl) {
			this.profileUrl = profileUrl;
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
    }