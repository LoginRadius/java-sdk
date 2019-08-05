/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete group data
	// </summary>
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
		//	user's email
		// </summary>
		public String getEmail() {
			return email;
		}
		// <summary>
		//	user's email
		// </summary>
		public void setEmail(String email) {
			this.email = email;
		}
		// <summary>
		//	Identity providers
		// </summary>
		public String getID() {
			return iD;
		}
		// <summary>
		//	Identity providers
		// </summary>
		public void setID(String iD) {
			this.iD = iD;
		}
		// <summary>
		//	Images
		// </summary>
		public String getImage() {
			return image;
		}
		// <summary>
		//	Images
		// </summary>
		public void setImage(String image) {
			this.image = image;
		}
		// <summary>
		//	logo
		// </summary>
		public String getLogo() {
			return logo;
		}
		// <summary>
		//	logo
		// </summary>
		public void setLogo(String logo) {
			this.logo = logo;
		}
		// <summary>
		//	Number of members
		// </summary>
		public String getMemberCount() {
			return memberCount;
		}
		// <summary>
		//	Number of members
		// </summary>
		public void setMemberCount(String memberCount) {
			this.memberCount = memberCount;
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
		//	Postal code value that need to be updated
		// </summary>
		public String getPostalCode() {
			return postalCode;
		}
		// <summary>
		//	Postal code value that need to be updated
		// </summary>
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		// <summary>
		//	String to identify the type of parameter
		// </summary>
		public String getType() {
			return type;
		}
		// <summary>
		//	String to identify the type of parameter
		// </summary>
		public void setType(String type) {
			this.type = type;
		}
    }