/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.ConsentProfileActions;

	/**
	 * Response containing consent profile logs
	 */
	public class ConsentProfileLog {
	
		
		@SerializedName("ConsentId")
        private String consentId;
		
		@SerializedName("Event")
        private ConsentProfileActions event;



		/**
		 * Consent ID
		 */
		public String getConsentId() {
			return consentId;
		}
		/**
		 * Consent ID
		 */
		public void setConsentId(String consentId) {
			this.consentId = consentId;
		}
		/**
		 * ConsentProfileActions
		 */
		public ConsentProfileActions getEvent() {
			return event;
		}
		/**
		 * ConsentProfileActions
		 */
		public void setEvent(ConsentProfileActions event) {
			this.event = event;
		}
    }