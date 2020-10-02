/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model class containing defination of consent data
	 */
	public class ConsentDataModel {
	
		
		@SerializedName("ConsentOptionId")
        private String consentOptionId;
		
		@SerializedName("IsAccepted")
        private Boolean isAccepted;



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
		/**
		 * Is Accepted
		 */
		public Boolean getIsAccepted() {
			return isAccepted;
		}
		/**
		 * Is Accepted
		 */
		public void setIsAccepted(Boolean isAccepted) {
			this.isAccepted = isAccepted;
		}
    }