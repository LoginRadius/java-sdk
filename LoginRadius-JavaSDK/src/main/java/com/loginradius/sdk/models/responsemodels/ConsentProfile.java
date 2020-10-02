/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing consent profile
	 */
	public class ConsentProfile {
	
		
		@SerializedName("AcceptedConsentVersions")
        private List<ConsentVersions> acceptedConsentVersions;
		
		@SerializedName("Consents")
        private List<ConsentOption> consents;



		/**
		 * List of consent version
		 */
		public List<ConsentVersions> getAcceptedConsentVersions() {
			return acceptedConsentVersions;
		}
		/**
		 * List of consent version
		 */
		public void setAcceptedConsentVersions(List<ConsentVersions> acceptedConsentVersions) {
			this.acceptedConsentVersions = acceptedConsentVersions;
		}
		/**
		 * List of Consents
		 */
		public List<ConsentOption> getConsents() {
			return consents;
		}
		/**
		 * List of Consents
		 */
		public void setConsents(List<ConsentOption> consents) {
			this.consents = consents;
		}
    }