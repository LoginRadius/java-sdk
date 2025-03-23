/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model class containing defination of consent data
	// </summary>
	public class ConsentDataModel {
	
		
		@SerializedName("ConsentOptionId")
        private String consentOptionId;
		
		@SerializedName("IsAccepted")
        private Boolean isAccepted;



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
		// <summary>
		//	Is Accepted
		// </summary>
		public Boolean getIsAccepted() {
			return isAccepted;
		}
		// <summary>
		//	Is Accepted
		// </summary>
		public void setIsAccepted(Boolean isAccepted) {
			this.isAccepted = isAccepted;
		}
    }