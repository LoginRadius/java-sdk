/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete CheckIn data
	// </summary>
	public class CheckIn {
	
		
		@SerializedName("Address")
        private String address;
		
		@SerializedName("City")
        private String city;
		
		@SerializedName("Country")
        private String country;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Distance")
        private String distance;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("ImageUrl")
        private String imageUrl;
		
		@SerializedName("Latitude")
        private String latitude;
		
		@SerializedName("Longitude")
        private String longitude;
		
		@SerializedName("Message")
        private String message;
		
		@SerializedName("OwnerId")
        private String ownerId;
		
		@SerializedName("OwnerName")
        private String ownerName;
		
		@SerializedName("PlaceTitle")
        private String placeTitle;
		
		@SerializedName("Type")
        private String type;



		// <summary>
		//	Array of objects,String represents address of user
		// </summary>
		public String getAddress() {
			return address;
		}
		// <summary>
		//	Array of objects,String represents address of user
		// </summary>
		public void setAddress(String address) {
			this.address = address;
		}
		// <summary>
		//	user's city
		// </summary>
		public String getCity() {
			return city;
		}
		// <summary>
		//	user's city
		// </summary>
		public void setCity(String city) {
			this.city = city;
		}
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
		//	Date of Creation of Profile
		// </summary>
		public String getCreatedDate() {
			return createdDate;
		}
		// <summary>
		//	Date of Creation of Profile
		// </summary>
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		// <summary>
		//	distance
		// </summary>
		public String getDistance() {
			return distance;
		}
		// <summary>
		//	distance
		// </summary>
		public void setDistance(String distance) {
			this.distance = distance;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public String getID() {
			return iD;
		}
		// <summary>
		//	ID of the User
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
		//	The Latitude
		// </summary>
		public String getLatitude() {
			return latitude;
		}
		// <summary>
		//	The Latitude
		// </summary>
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		// <summary>
		//	The Longitude
		// </summary>
		public String getLongitude() {
			return longitude;
		}
		// <summary>
		//	The Longitude
		// </summary>
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		// <summary>
		//	message
		// </summary>
		public String getMessage() {
			return message;
		}
		// <summary>
		//	message
		// </summary>
		public void setMessage(String message) {
			this.message = message;
		}
		// <summary>
		//	ID of account owner
		// </summary>
		public String getOwnerId() {
			return ownerId;
		}
		// <summary>
		//	ID of account owner
		// </summary>
		public void setOwnerId(String ownerId) {
			this.ownerId = ownerId;
		}
		// <summary>
		//	Name of account owner
		// </summary>
		public String getOwnerName() {
			return ownerName;
		}
		// <summary>
		//	Name of account owner
		// </summary>
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		// <summary>
		//	The place title
		// </summary>
		public String getPlaceTitle() {
			return placeTitle;
		}
		// <summary>
		//	The place title
		// </summary>
		public void setPlaceTitle(String placeTitle) {
			this.placeTitle = placeTitle;
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