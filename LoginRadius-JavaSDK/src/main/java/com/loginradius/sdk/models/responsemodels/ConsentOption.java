/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing consent information
	// </summary>
	public class ConsentOption {
	
		
		@SerializedName("AcceptOnDate")
        private String acceptOnDate;
		
		@SerializedName("ConsentOptionId")
        private String consentOptionId;



		// <summary>
		//	Consent Accept on Date
		// </summary>
		public String getAcceptOnDate() {
			return acceptOnDate;
		}
		// <summary>
		//	Consent Accept on Date
		// </summary>
		public void setAcceptOnDate(String acceptOnDate) {
			this.acceptOnDate = acceptOnDate;
		}
		// <summary>
		//	Consent Option Id
		// </summary>
		public String getConsentOptionId() {
			return consentOptionId;
		}
		// <summary>
		//	Consent Option Id
		// </summary>
		public void setConsentOptionId(String consentOptionId) {
			this.consentOptionId = consentOptionId;
		}
    }