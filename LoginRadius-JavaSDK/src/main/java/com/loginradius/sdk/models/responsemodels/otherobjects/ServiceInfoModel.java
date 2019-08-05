/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete service info data
	// </summary>
	public class ServiceInfoModel {
	
		
		@SerializedName("CurrentTime")
        private String currentTime;
		
		@SerializedName("ServerLocation")
        private String serverLocation;
		
		@SerializedName("ServerName")
        private String serverName;
		
		@SerializedName("Sott")
        private ServiceSottInfo sott;



		// <summary>
		//	Current time
		// </summary>
		public String getCurrentTime() {
			return currentTime;
		}
		// <summary>
		//	Current time
		// </summary>
		public void setCurrentTime(String currentTime) {
			this.currentTime = currentTime;
		}
		// <summary>
		//	Location of server
		// </summary>
		public String getServerLocation() {
			return serverLocation;
		}
		// <summary>
		//	Location of server
		// </summary>
		public void setServerLocation(String serverLocation) {
			this.serverLocation = serverLocation;
		}
		// <summary>
		//	server name
		// </summary>
		public String getServerName() {
			return serverName;
		}
		// <summary>
		//	server name
		// </summary>
		public void setServerName(String serverName) {
			this.serverName = serverName;
		}
		// <summary>
		//	SOTT is a secure one time token
		// </summary>
		public ServiceSottInfo getSott() {
			return sott;
		}
		// <summary>
		//	SOTT is a secure one time token
		// </summary>
		public void setSott(ServiceSottInfo sott) {
			this.sott = sott;
		}
    }