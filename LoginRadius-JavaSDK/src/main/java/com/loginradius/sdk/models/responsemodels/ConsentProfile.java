/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing consent profile
	// </summary>
	public class ConsentProfile {
	
		
		@SerializedName("AcceptedConsentVersions")
        private List<ConsentVersions> acceptedConsentVersions;
		
		@SerializedName("Consents")
        private List<ConsentOption> consents;



		// <summary>
		//	List of consent version
		// </summary>
		public List<ConsentVersions> getAcceptedConsentVersions() {
			return acceptedConsentVersions;
		}
		// <summary>
		//	List of consent version
		// </summary>
		public void setAcceptedConsentVersions(List<ConsentVersions> acceptedConsentVersions) {
			this.acceptedConsentVersions = acceptedConsentVersions;
		}
		// <summary>
		//	List of Consents
		// </summary>
		public List<ConsentOption> getConsents() {
			return consents;
		}
		// <summary>
		//	List of Consents
		// </summary>
		public void setConsents(List<ConsentOption> consents) {
			this.consents = consents;
		}
    }