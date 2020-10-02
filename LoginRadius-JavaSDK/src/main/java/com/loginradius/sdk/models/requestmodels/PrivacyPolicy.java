/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for PrivacyPolicy Property
	 */
	public class PrivacyPolicy {
	
		
		@SerializedName("Version")
        private String version;



		/**
		 * Privacy policy version
		 */
		public String getVersion() {
			return version;
		}
		/**
		 * Privacy policy version
		 */
		public void setVersion(String version) {
			this.version = version;
		}
    }