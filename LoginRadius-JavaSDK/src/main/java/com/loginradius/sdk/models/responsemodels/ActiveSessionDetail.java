/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete ActiveSession data
	 */
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



		/**
		 * Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		 */
		public String getAccessToken() {
			return accessToken;
		}
		/**
		 * Uniquely generated identifier key by LoginRadius that is activated after successful authentication.
		 */
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}
		/**
		 * Browser details of user
		 */
		public String getBrowser() {
			return browser;
		}
		/**
		 * Browser details of user
		 */
		public void setBrowser(String browser) {
			this.browser = browser;
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
		 * Device of user
		 */
		public String getDevice() {
			return device;
		}
		/**
		 * Device of user
		 */
		public void setDevice(String device) {
			this.device = device;
		}
		/**
		 * type of device
		 */
		public String getDeviceType() {
			return deviceType;
		}
		/**
		 * type of device
		 */
		public void setDeviceType(String deviceType) {
			this.deviceType = deviceType;
		}
		/**
		 * IP of user
		 */
		public String getIp() {
			return ip;
		}
		/**
		 * IP of user
		 */
		public void setIp(String ip) {
			this.ip = ip;
		}
		/**
		 * last login date
		 */
		public String getLoginDate() {
			return loginDate;
		}
		/**
		 * last login date
		 */
		public void setLoginDate(String loginDate) {
			this.loginDate = loginDate;
		}
		/**
		 * Os Details of user
		 */
		public String getOs() {
			return os;
		}
		/**
		 * Os Details of user
		 */
		public void setOs(String os) {
			this.os = os;
		}
    }