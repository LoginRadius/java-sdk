/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for MutualFriends Property
	 */
	public class MutualFriends {
	
		
		@SerializedName("Birthday")
        private String birthday;
		
		@SerializedName("FirstName")
        private String firstName;
		
		@SerializedName("Gender")
        private String gender;
		
		@SerializedName("Hometown")
        private String hometown;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("LastName")
        private String lastName;
		
		@SerializedName("Link")
        private String link;
		
		@SerializedName("Name")
        private String name;



		/**
		 * Birthday of mutual friend
		 */
		public String getBirthday() {
			return birthday;
		}
		/**
		 * Birthday of mutual friend
		 */
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		/**
		 * first name of mutual friend
		 */
		public String getFirstName() {
			return firstName;
		}
		/**
		 * first name of mutual friend
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		/**
		 * Gender of mutual friend
		 */
		public String getGender() {
			return gender;
		}
		/**
		 * Gender of mutual friend
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}
		/**
		 * Hometown of mutual friend
		 */
		public String getHometown() {
			return hometown;
		}
		/**
		 * Hometown of mutual friend
		 */
		public void setHometown(String hometown) {
			this.hometown = hometown;
		}
		/**
		 * Id of mutual friend
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of mutual friend
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Last name of mutual friend
		 */
		public String getLastName() {
			return lastName;
		}
		/**
		 * Last name of mutual friend
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		/**
		 * Link of mutual friend
		 */
		public String getLink() {
			return link;
		}
		/**
		 * Link of mutual friend
		 */
		public void setLink(String link) {
			this.link = link;
		}
		/**
		 * Name of mutual friend
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of mutual friend
		 */
		public void setName(String name) {
			this.name = name;
		}
    }