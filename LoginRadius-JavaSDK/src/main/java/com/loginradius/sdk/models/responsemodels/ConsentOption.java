/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing consent information
	 */
	public class ConsentOption {
	
		
		@SerializedName("AcceptOnDate")
        private String acceptOnDate;
		
		@SerializedName("ConsentOptionId")
        private String consentOptionId;



		/**
		 * Consent Accept on Date
		 */
		public String getAcceptOnDate() {
			return acceptOnDate;
		}
		/**
		 * Consent Accept on Date
		 */
		public void setAcceptOnDate(String acceptOnDate) {
			this.acceptOnDate = acceptOnDate;
		}
		/**
		 * Consent Option Id
		 */
		public String getConsentOptionId() {
			return consentOptionId;
		}
		/**
		 * Consent Option Id
		 */
		public void setConsentOptionId(String consentOptionId) {
			this.consentOptionId = consentOptionId;
		}
    }