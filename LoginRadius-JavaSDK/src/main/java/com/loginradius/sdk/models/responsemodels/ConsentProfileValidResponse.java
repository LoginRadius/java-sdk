/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing consent profile
	// </summary>
	public class ConsentProfileValidResponse {
	
		
		@SerializedName("ConsentProfile")
        private ConsentProfile consentProfile;
		
		@SerializedName("IsValid")
        private Boolean isValid;



		// <summary>
		//	Consent Profile
		// </summary>
		public ConsentProfile getConsentProfile() {
			return consentProfile;
		}
		// <summary>
		//	Consent Profile
		// </summary>
		public void setConsentProfile(ConsentProfile consentProfile) {
			this.consentProfile = consentProfile;
		}
		// <summary>
		//	check data is validate
		// </summary>
		public Boolean getIsValid() {
			return isValid;
		}
		// <summary>
		//	check data is validate
		// </summary>
		public void setIsValid(Boolean isValid) {
			this.isValid = isValid;
		}
    }