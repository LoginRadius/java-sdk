/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete privacy policy data
	 */
	public class AcceptedPrivacyPolicy {
	
		
		@SerializedName("AcceptDateTime")
        private String acceptDateTime;
		
		@SerializedName("AcceptSource")
        private String acceptSource;
		
		@SerializedName("Version")
        private String version;



		/**
		 * Privacy policy accept date time
		 */
		public String getAcceptDateTime() {
			return acceptDateTime;
		}
		/**
		 * Privacy policy accept date time
		 */
		public void setAcceptDateTime(String acceptDateTime) {
			this.acceptDateTime = acceptDateTime;
		}
		/**
		 * Privacy policy accept source
		 */
		public String getAcceptSource() {
			return acceptSource;
		}
		/**
		 * Privacy policy accept source
		 */
		public void setAcceptSource(String acceptSource) {
			this.acceptSource = acceptSource;
		}
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