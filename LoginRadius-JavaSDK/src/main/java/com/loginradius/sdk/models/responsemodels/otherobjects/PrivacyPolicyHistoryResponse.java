/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.AcceptedPrivacyPolicy;

	/**
	 * Response containing Definition of Complete PrivacyPolicyHistory
	 */
	public class PrivacyPolicyHistoryResponse {
	
		
		@SerializedName("Current")
        private AcceptedPrivacyPolicy current;
		
		@SerializedName("History")
        private List<AcceptedPrivacyPolicy> history;
		
		@SerializedName("Uid")
        private String uid;



		/**
		 * Current privacy policy
		 */
		public AcceptedPrivacyPolicy getCurrent() {
			return current;
		}
		/**
		 * Current privacy policy
		 */
		public void setCurrent(AcceptedPrivacyPolicy current) {
			this.current = current;
		}
		/**
		 * Privacy policy history
		 */
		public List<AcceptedPrivacyPolicy> getHistory() {
			return history;
		}
		/**
		 * Privacy policy history
		 */
		public void setHistory(List<AcceptedPrivacyPolicy> history) {
			this.history = history;
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