/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete service info data
	 */
	public class ServiceInfoModel {
	
		
		@SerializedName("CurrentTime")
        private String currentTime;
		
		@SerializedName("ServerLocation")
        private String serverLocation;
		
		@SerializedName("ServerName")
        private String serverName;
		
		@SerializedName("Sott")
        private ServiceSottInfo sott;



		/**
		 * Current time
		 */
		public String getCurrentTime() {
			return currentTime;
		}
		/**
		 * Current time
		 */
		public void setCurrentTime(String currentTime) {
			this.currentTime = currentTime;
		}
		/**
		 * Location of server
		 */
		public String getServerLocation() {
			return serverLocation;
		}
		/**
		 * Location of server
		 */
		public void setServerLocation(String serverLocation) {
			this.serverLocation = serverLocation;
		}
		/**
		 * server name
		 */
		public String getServerName() {
			return serverName;
		}
		/**
		 * server name
		 */
		public void setServerName(String serverName) {
			this.serverName = serverName;
		}
		/**
		 * SOTT is a secure one time token
		 */
		public ServiceSottInfo getSott() {
			return sott;
		}
		/**
		 * SOTT is a secure one time token
		 */
		public void setSott(ServiceSottInfo sott) {
			this.sott = sott;
		}
    }