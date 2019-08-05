/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete privacy policy data
	// </summary>
	public class AcceptedPrivacyPolicy {
	
		
		@SerializedName("AcceptDateTime")
        private String acceptDateTime;
		
		@SerializedName("AcceptSource")
        private String acceptSource;
		
		@SerializedName("Version")
        private String version;



		// <summary>
		//	Privacy policy accept date time
		// </summary>
		public String getAcceptDateTime() {
			return acceptDateTime;
		}
		// <summary>
		//	Privacy policy accept date time
		// </summary>
		public void setAcceptDateTime(String acceptDateTime) {
			this.acceptDateTime = acceptDateTime;
		}
		// <summary>
		//	Privacy policy accept source
		// </summary>
		public String getAcceptSource() {
			return acceptSource;
		}
		// <summary>
		//	Privacy policy accept source
		// </summary>
		public void setAcceptSource(String acceptSource) {
			this.acceptSource = acceptSource;
		}
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