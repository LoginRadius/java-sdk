/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete ActiveSession data
	// </summary>
	public class ActiveSessionDetail {
	
		
		@SerializedName("AccessToken")
        private String accessToken;
		
		@SerializedName("Browser")
        private String browser;
		
		@SerializedName("City")
        private String city;
		
		@SerializedName("Country")
        private String country;
		
		@SerializedName("Device")
        private String device;
		
		@SerializedName("DeviceType")
        private String deviceType;
		
		@SerializedName("Ip")
        private String ip;
		
		@SerializedName("LoginDate")
        private String loginDate;
		
		@SerializedName("Os")
        private String os;



		// <summary>
		//	Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		// </summary>
		public String getAccessToken() {
			return accessToken;
		}
		// <summary>
		//	Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		// </summary>
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
		// <summary>
		//	Browser details of user
		// </summary>
		public String getBrowser() {
			return browser;
		}
		// <summary>
		//	Browser details of user
		// </summary>
		public void setBrowser(String browser) {
			this.browser = browser;
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
		//	Device of user
		// </summary>
		public String getDevice() {
			return device;
		}
		// <summary>
		//	Device of user
		// </summary>
		public void setDevice(String device) {
			this.device = device;
		}
		// <summary>
		//	type of device
		// </summary>
		public String getDeviceType() {
			return deviceType;
		}
		// <summary>
		//	type of device
		// </summary>
		public void setDeviceType(String deviceType) {
			this.deviceType = deviceType;
		}
		// <summary>
		//	IP of user
		// </summary>
		public String getIp() {
			return ip;
		}
		// <summary>
		//	IP of user
		// </summary>
		public void setIp(String ip) {
			this.ip = ip;
		}
		// <summary>
		//	last login date
		// </summary>
		public String getLoginDate() {
			return loginDate;
		}
		// <summary>
		//	last login date
		// </summary>
		public void setLoginDate(String loginDate) {
			this.loginDate = loginDate;
		}
		// <summary>
		//	Os Details of user
		// </summary>
		public String getOs() {
			return os;
		}
		// <summary>
		//	Os Details of user
		// </summary>
		public void setOs(String os) {
			this.os = os;
		}
    }