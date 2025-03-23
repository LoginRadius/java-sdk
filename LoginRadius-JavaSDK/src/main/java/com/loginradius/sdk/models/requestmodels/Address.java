/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.OperationType;

	// <summary>
	//	Model Class containing Definition for Address Property
	// </summary>
	public class Address {
	
		
		@SerializedName("Address1")
        private String address1;
		
		@SerializedName("Address2")
        private String address2;
		
		@SerializedName("City")
        private String city;
		
		@SerializedName("Country")
        private String country;
		
		@SerializedName("op")
        private OperationType op;
		
		@SerializedName("PostalCode")
        private String postalCode;
		
		@SerializedName("Region")
        private String region;
		
		@SerializedName("State")
        private String state;
		
		@SerializedName("Type")
        private String type;



		// <summary>
		//	Address field value that needs to be updated
		// </summary>
		public String getAddress1() {
			return address1;
		}
		// <summary>
		//	Address field value that needs to be updated
		// </summary>
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		// <summary>
		//	Address field value that needs to be updated
		// </summary>
		public String getAddress2() {
			return address2;
		}
		// <summary>
		//	Address field value that needs to be updated
		// </summary>
		public void setAddress2(String address2) {
			this.address2 = address2;
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
		//	operation type
		// </summary>
		public OperationType getOp() {
			return op;
		}
		// <summary>
		//	operation type
		// </summary>
		public void setOp(OperationType op) {
			this.op = op;
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
		//	Region
		// </summary>
		public String getRegion() {
			return region;
		}
		// <summary>
		//	Region
		// </summary>
		public void setRegion(String region) {
			this.region = region;
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