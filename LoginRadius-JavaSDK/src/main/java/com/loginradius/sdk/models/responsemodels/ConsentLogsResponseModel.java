/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing consent logs
	// </summary>
	public class ConsentLogsResponseModel {
	
		
		@SerializedName("ConsentLogs")
        private List<ConsentProfileLogs> consentLogs;
		
		@SerializedName("Uid")
        private String uid;



		// <summary>
		//	List of consent logs
		// </summary>
		public List<ConsentProfileLogs> getConsentLogs() {
			return consentLogs;
		}
		// <summary>
		//	List of consent logs
		// </summary>
		public void setConsentLogs(List<ConsentProfileLogs> consentLogs) {
			this.consentLogs = consentLogs;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public String getUid() {
			return uid;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public void setUid(String uid) {
			this.uid = uid;
		}
    }