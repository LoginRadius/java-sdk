/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing consent logs
	 */
	public class ConsentLogsResponseModel {
	
		
		@SerializedName("ConsentLogs")
        private List<ConsentProfileLogs> consentLogs;
		
		@SerializedName("Uid")
        private String uid;



		/**
		 * List of consent logs
		 */
		public List<ConsentProfileLogs> getConsentLogs() {
			return consentLogs;
		}
		/**
		 * List of consent logs
		 */
		public void setConsentLogs(List<ConsentProfileLogs> consentLogs) {
			this.consentLogs = consentLogs;
		}
		/**
		 * UID, the unified identifier for each user account
		 */
		public String getUid() {
			return uid;
		}
		/**
		 * UID, the unified identifier for each user account
		 */
		public void setUid(String uid) {
			this.uid = uid;
		}
    }