/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model class containg list of multiple consent
	 */
	public class ConsentUpdateModel {
	
		
		@SerializedName("Consents")
        private List<ConsentDataModel> consents;



		/**
		 * List of Consents
		 */
		public List<ConsentDataModel> getConsents() {
			return consents;
		}
		/**
		 * List of Consents
		 */
		public void setConsents(List<ConsentDataModel> consents) {
			this.consents = consents;
		}
    }