/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.ConsentProfileUpdateType;

	// <summary>
	//	Response containg consent profile logs
	// </summary>
	public class ConsentProfileLogs {
	
		
		@SerializedName("ConsentLogs")
        private List<ConsentProfileLog> consentLogs;
		
		@SerializedName("CurrentConsentFormsVersions")
        private List<ConsentVersions> currentConsentFormsVersions;
		
		@SerializedName("Host")
        private String host;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("IP")
        private String iP;
		
		@SerializedName("LoggedOnDate")
        private String loggedOnDate;
		
		@SerializedName("UpdateType")
        private ConsentProfileUpdateType updateType;
		
		@SerializedName("UserAgent")
        private String userAgent;



		// <summary>
		//	List of consent logs
		// </summary>
		public List<ConsentProfileLog> getConsentLogs() {
			return consentLogs;
		}
		// <summary>
		//	List of consent logs
		// </summary>
		public void setConsentLogs(List<ConsentProfileLog> consentLogs) {
			this.consentLogs = consentLogs;
		}
		// <summary>
		//	List of consetforms version
		// </summary>
		public List<ConsentVersions> getCurrentConsentFormsVersions() {
			return currentConsentFormsVersions;
		}
		// <summary>
		//	List of consetforms version
		// </summary>
		public void setCurrentConsentFormsVersions(List<ConsentVersions> currentConsentFormsVersions) {
			this.currentConsentFormsVersions = currentConsentFormsVersions;
		}
		// <summary>
		//	Host name
		// </summary>
		public String getHost() {
			return host;
		}
		// <summary>
		//	Host name
		// </summary>
		public void setHost(String host) {
			this.host = host;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	ID of the User
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	users ip address
		// </summary>
		public String getIP() {
			return iP;
		}
		// <summary>
		//	users ip address
		// </summary>
		public void setIP(String iP) {
			this.iP = iP;
		}
		// <summary>
		//	Logged On Date
		// </summary>
		public String getLoggedOnDate() {
			return loggedOnDate;
		}
		// <summary>
		//	Logged On Date
		// </summary>
		public void setLoggedOnDate(String loggedOnDate) {
			this.loggedOnDate = loggedOnDate;
		}
		// <summary>
		//	Consent Profile Update Type
		// </summary>
		public ConsentProfileUpdateType getUpdateType() {
			return updateType;
		}
		// <summary>
		//	Consent Profile Update Type
		// </summary>
		public void setUpdateType(ConsentProfileUpdateType updateType) {
			this.updateType = updateType;
		}
		// <summary>
		//	UserAgent
		// </summary>
		public String getUserAgent() {
			return userAgent;
		}
		// <summary>
		//	UserAgent
		// </summary>
		public void setUserAgent(String userAgent) {
			this.userAgent = userAgent;
		}
    }