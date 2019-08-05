/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for MutualFriends Property
	// </summary>
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



		// <summary>
		//	Birthday of mutual friend
		// </summary>
		public String getBirthday() {
			return birthday;
		}
		// <summary>
		//	Birthday of mutual friend
		// </summary>
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		// <summary>
		//	first name of mutual friend
		// </summary>
		public String getFirstName() {
			return firstName;
		}
		// <summary>
		//	first name of mutual friend
		// </summary>
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		// <summary>
		//	Gender of mutual friend
		// </summary>
		public String getGender() {
			return gender;
		}
		// <summary>
		//	Gender of mutual friend
		// </summary>
		public void setGender(String gender) {
			this.gender = gender;
		}
		// <summary>
		//	Hometown of mutual friend
		// </summary>
		public String getHometown() {
			return hometown;
		}
		// <summary>
		//	Hometown of mutual friend
		// </summary>
		public void setHometown(String hometown) {
			this.hometown = hometown;
		}
		// <summary>
		//	Id of mutual friend
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of mutual friend
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Last name of mutual friend
		// </summary>
		public String getLastName() {
			return lastName;
		}
		// <summary>
		//	Last name of mutual friend
		// </summary>
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		// <summary>
		//	Link of mutual friend
		// </summary>
		public String getLink() {
			return link;
		}
		// <summary>
		//	Link of mutual friend
		// </summary>
		public void setLink(String link) {
			this.link = link;
		}
		// <summary>
		//	Name of mutual friend
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of mutual friend
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
    }