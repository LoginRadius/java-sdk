/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model class containg list of multiple consent
	// </summary>
	public class ConsentUpdateModel {
	
		
		@SerializedName("Consents")
        private List<ConsentDataModel> consents;



		// <summary>
		//	List of Consents
		// </summary>
		public List<ConsentDataModel> getConsents() {
			return consents;
		}
		// <summary>
		//	List of Consents
		// </summary>
		public void setConsents(List<ConsentDataModel> consents) {
			this.consents = consents;
		}
    }