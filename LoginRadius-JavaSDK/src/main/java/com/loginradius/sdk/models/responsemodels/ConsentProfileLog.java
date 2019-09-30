/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.ConsentProfileActions;

	// <summary>
	//	Response containing consent profile logs
	// </summary>
	public class ConsentProfileLog {
	
		
		@SerializedName("ConsentId")
        private String consentId;
		
		@SerializedName("Event")
        private ConsentProfileActions event;



		// <summary>
		//	Consent ID
		// </summary>
		public String getConsentId() {
			return consentId;
		}
		// <summary>
		//	Consent ID
		// </summary>
		public void setConsentId(String consentId) {
			this.consentId = consentId;
		}
		// <summary>
		//	ConsentProfileActions
		// </summary>
		public ConsentProfileActions getEvent() {
			return event;
		}
		// <summary>
		//	ConsentProfileActions
		// </summary>
		public void setEvent(ConsentProfileActions event) {
			this.event = event;
		}
    }