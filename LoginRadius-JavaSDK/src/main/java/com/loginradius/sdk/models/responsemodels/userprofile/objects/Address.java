/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Address data
	 */
	public class Address {
	
		
		@SerializedName("Address1")
        private String address1;
		
		@SerializedName("Address2")
        private String address2;
		
		@SerializedName("City")
        private String city;
		
		@SerializedName("Country")
        private String country;
		
		@SerializedName("PostalCode")
        private String postalCode;
		
		@SerializedName("Region")
        private String region;
		
		@SerializedName("State")
        private String state;
		
		@SerializedName("Type")
        private String type;



		/**
		 * Address field value that needs to be updated
		 */
		public String getAddress1() {
			return address1;
		}
		/**
		 * Address field value that needs to be updated
		 */
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		/**
		 * Address field value that needs to be updated
		 */
		public String getAddress2() {
			return address2;
		}
		/**
		 * Address field value that needs to be updated
		 */
		public void setAddress2(String address2) {
			this.address2 = address2;
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
		 * Postal code value that need to be updated
		 */
		public String getPostalCode() {
			return postalCode;
		}
		/**
		 * Postal code value that need to be updated
		 */
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		/**
		 * Region
		 */
		public String getRegion() {
			return region;
		}
		/**
		 * Region
		 */
		public void setRegion(String region) {
			this.region = region;
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
		 * type of address
		 */
		public String getType() {
			return type;
		}
		/**
		 * type of address
		 */
		public void setType(String type) {
			this.type = type;
		}
    }