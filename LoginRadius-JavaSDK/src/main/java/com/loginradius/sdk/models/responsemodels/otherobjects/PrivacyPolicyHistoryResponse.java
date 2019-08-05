/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.AcceptedPrivacyPolicy;

	// <summary>
	//	Response containing Definition of Complete PrivacyPolicyHistory
	// </summary>
	public class PrivacyPolicyHistoryResponse {
	
		
		@SerializedName("Current")
        private AcceptedPrivacyPolicy current;
		
		@SerializedName("History")
        private List<AcceptedPrivacyPolicy> history;
		
		@SerializedName("Uid")
        private String uid;



		// <summary>
		//	Current privacy policy
		// </summary>
		public AcceptedPrivacyPolicy getCurrent() {
			return current;
		}
		// <summary>
		//	Current privacy policy
		// </summary>
		public void setCurrent(AcceptedPrivacyPolicy current) {
			this.current = current;
		}
		// <summary>
		//	Privacy policy history
		// </summary>
		public List<AcceptedPrivacyPolicy> getHistory() {
			return history;
		}
		// <summary>
		//	Privacy policy history
		// </summary>
		public void setHistory(List<AcceptedPrivacyPolicy> history) {
			this.history = history;
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