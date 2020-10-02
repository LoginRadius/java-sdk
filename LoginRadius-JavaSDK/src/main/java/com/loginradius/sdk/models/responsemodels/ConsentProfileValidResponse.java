/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing consent profile
	 */
	public class ConsentProfileValidResponse {
	
		
		@SerializedName("ConsentProfile")
        private ConsentProfile consentProfile;
		
		@SerializedName("IsValid")
        private Boolean isValid;



		/**
		 * Consent Profile
		 */
		public ConsentProfile getConsentProfile() {
			return consentProfile;
		}
		/**
		 * Consent Profile
		 */
		public void setConsentProfile(ConsentProfile consentProfile) {
			this.consentProfile = consentProfile;
		}
		/**
		 * check data is validate
		 */
		public Boolean getIsValid() {
			return isValid;
		}
		/**
		 * check data is validate
		 */
		public void setIsValid(Boolean isValid) {
			this.isValid = isValid;
		}
    }