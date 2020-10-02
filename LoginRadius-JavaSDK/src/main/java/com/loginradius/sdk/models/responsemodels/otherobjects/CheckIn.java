/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete CheckIn data
	 */
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



		/**
		 * Array of objects,String represents address of user
		 */
		public String getAddress() {
			return address;
		}
		/**
		 * Array of objects,String represents address of user
		 */
		public void setAddress(String address) {
			this.address = address;
		}
		/**
		 * user's city
		 */
		public String getCity() {
			return city;
		}
		/**
		 * user's city
		 */
		public void setCity(String city) {
			this.city = city;
		}
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
		 * Date of Creation of Profile
		 */
		public String getCreatedDate() {
			return createdDate;
		}
		/**
		 * Date of Creation of Profile
		 */
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		/**
		 * distance
		 */
		public String getDistance() {
			return distance;
		}
		/**
		 * distance
		 */
		public void setDistance(String distance) {
			this.distance = distance;
		}
		/**
		 * ID of the User
		 */
		public String getID() {
			return iD;
		}
		/**
		 * ID of the User
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
		 * The Latitude
		 */
		public String getLatitude() {
			return latitude;
		}
		/**
		 * The Latitude
		 */
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		/**
		 * The Longitude
		 */
		public String getLongitude() {
			return longitude;
		}
		/**
		 * The Longitude
		 */
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		/**
		 * message
		 */
		public String getMessage() {
			return message;
		}
		/**
		 * message
		 */
		public void setMessage(String message) {
			this.message = message;
		}
		/**
		 * ID of account owner
		 */
		public String getOwnerId() {
			return ownerId;
		}
		/**
		 * ID of account owner
		 */
		public void setOwnerId(String ownerId) {
			this.ownerId = ownerId;
		}
		/**
		 * Name of account owner
		 */
		public String getOwnerName() {
			return ownerName;
		}
		/**
		 * Name of account owner
		 */
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		/**
		 * The place title
		 */
		public String getPlaceTitle() {
			return placeTitle;
		}
		/**
		 * The place title
		 */
		public void setPlaceTitle(String placeTitle) {
			this.placeTitle = placeTitle;
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