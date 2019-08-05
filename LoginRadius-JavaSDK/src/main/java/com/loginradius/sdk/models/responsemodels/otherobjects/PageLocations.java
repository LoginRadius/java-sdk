/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Page data
	// </summary>
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
		public CountryCodeName getCountry() {
			return country;
		}
		// <summary>
		//	Country of the user
		// </summary>
		public void setCountry(CountryCodeName country) {
			this.country = country;
		}
		// <summary>
		//	The Latitude
		// </summary>
		public double getLatitude() {
			return latitude;
		}
		// <summary>
		//	The Latitude
		// </summary>
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		// <summary>
		//	The Longitude
		// </summary>
		public double getLongitude() {
			return longitude;
		}
		// <summary>
		//	The Longitude
		// </summary>
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		// <summary>
		//	New Phone Number
		// </summary>
		public String getPhone() {
			return phone;
		}
		// <summary>
		//	New Phone Number
		// </summary>
		public void setPhone(String phone) {
			this.phone = phone;
		}
		// <summary>
		//	State of the user
		// </summary>
		public String getState() {
			return state;
		}
		// <summary>
		//	State of the user
		// </summary>
		public void setState(String state) {
			this.state = state;
		}
		// <summary>
		//	Street of the user
		// </summary>
		public String getStreet() {
			return street;
		}
		// <summary>
		//	Street of the user
		// </summary>
		public void setStreet(String street) {
			this.street = street;
		}
		// <summary>
		//	ZipCode of the user
		// </summary>
		public String getZip() {
			return zip;
		}
		// <summary>
		//	ZipCode of the user
		// </summary>
		public void setZip(String zip) {
			this.zip = zip;
		}
    }