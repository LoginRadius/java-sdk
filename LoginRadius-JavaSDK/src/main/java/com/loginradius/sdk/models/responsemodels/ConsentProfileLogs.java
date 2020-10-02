/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.ConsentProfileUpdateType;

	/**
	 * Response containg consent profile logs
	 */
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



		/**
		 * List of consent logs
		 */
		public List<ConsentProfileLog> getConsentLogs() {
			return consentLogs;
		}
		/**
		 * List of consent logs
		 */
		public void setConsentLogs(List<ConsentProfileLog> consentLogs) {
			this.consentLogs = consentLogs;
		}
		/**
		 * List of consetforms version
		 */
		public List<ConsentVersions> getCurrentConsentFormsVersions() {
			return currentConsentFormsVersions;
		}
		/**
		 * List of consetforms version
		 */
		public void setCurrentConsentFormsVersions(List<ConsentVersions> currentConsentFormsVersions) {
			this.currentConsentFormsVersions = currentConsentFormsVersions;
		}
		/**
		 * Host name
		 */
		public String getHost() {
			return host;
		}
		/**
		 * Host name
		 */
		public void setHost(String host) {
			this.host = host;
		}
		/**
		 * ID of the User
		 */
		public String getId() {
			return id;
		}
		/**
		 * ID of the User
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * users ip address
		 */
		public String getIP() {
			return iP;
		}
		/**
		 * users ip address
		 */
		public void setIP(String iP) {
			this.iP = iP;
		}
		/**
		 * Logged On Date
		 */
		public String getLoggedOnDate() {
			return loggedOnDate;
		}
		/**
		 * Logged On Date
		 */
		public void setLoggedOnDate(String loggedOnDate) {
			this.loggedOnDate = loggedOnDate;
		}
		/**
		 * Consent Profile Update Type
		 */
		public ConsentProfileUpdateType getUpdateType() {
			return updateType;
		}
		/**
		 * Consent Profile Update Type
		 */
		public void setUpdateType(ConsentProfileUpdateType updateType) {
			this.updateType = updateType;
		}
		/**
		 * UserAgent
		 */
		public String getUserAgent() {
			return userAgent;
		}
		/**
		 * UserAgent
		 */
		public void setUserAgent(String userAgent) {
			this.userAgent = userAgent;
		}
    }