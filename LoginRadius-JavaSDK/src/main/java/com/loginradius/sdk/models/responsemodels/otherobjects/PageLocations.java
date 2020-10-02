/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Page data
	 */
	public class PageLocations {
	
		
		@SerializedName("City")
        private String city;
		
		@SerializedName("Country")
        private CountryCodeName country;
		
		@SerializedName("Latitude")
        private double latitude;
		
		@SerializedName("Longitude")
        private double longitude;
		
		@SerializedName("Phone")
        private String phone;
		
		@SerializedName("State")
        private String state;
		
		@SerializedName("Street")
        private String street;
		
		@SerializedName("Zip")
        private String zip;



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
		public CountryCodeName getCountry() {
			return country;
		}
		/**
		 * Country of the user
		 */
		public void setCountry(CountryCodeName country) {
			this.country = country;
		}
		/**
		 * The Latitude
		 */
		public double getLatitude() {
			return latitude;
		}
		/**
		 * The Latitude
		 */
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		/**
		 * The Longitude
		 */
		public double getLongitude() {
			return longitude;
		}
		/**
		 * The Longitude
		 */
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		/**
		 * New Phone Number
		 */
		public String getPhone() {
			return phone;
		}
		/**
		 * New Phone Number
		 */
		public void setPhone(String phone) {
			this.phone = phone;
		}
		/**
		 * State of the user
		 */
		public String getState() {
			return state;
		}
		/**
		 * State of the user
		 */
		public void setState(String state) {
			this.state = state;
		}
		/**
		 * Street of the user
		 */
		public String getStreet() {
			return street;
		}
		/**
		 * Street of the user
		 */
		public void setStreet(String street) {
			this.street = street;
		}
		/**
		 * ZipCode of the user
		 */
		public String getZip() {
			return zip;
		}
		/**
		 * ZipCode of the user
		 */
		public void setZip(String zip) {
			this.zip = zip;
		}
    }