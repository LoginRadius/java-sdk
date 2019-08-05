/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for RelatedProfileViews Property
	// </summary>
	public class RelatedProfileViews {
	
		
		@SerializedName("FirstName")
        private String firstName;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("LastName")
        private String lastName;



		// <summary>
		//	user's first name
		// </summary>
		public String getFirstName() {
			return firstName;
		}
		// <summary>
		//	user's first name
		// </summary>
		public void setFirstName(String firstName) {
			this.firstName = firstName;
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
		//	user's last name
		// </summary>
		public String getLastName() {
			return lastName;
		}
		// <summary>
		//	user's last name
		// </summary>
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
    }