/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for PrivacyPolicy Property
	// </summary>
	public class PrivacyPolicy {
	
		
		@SerializedName("Version")
        private String version;



		// <summary>
		//	Privacy policy version
		// </summary>
		public String getVersion() {
			return version;
		}
		// <summary>
		//	Privacy policy version
		// </summary>
		public void setVersion(String version) {
			this.version = version;
		}
    }