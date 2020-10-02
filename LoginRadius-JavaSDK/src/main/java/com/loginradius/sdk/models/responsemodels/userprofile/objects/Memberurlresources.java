/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Member url resources data
	 */
	public class Memberurlresources {
	
		
		@SerializedName("Url")
        private String url;
		
		@SerializedName("UrlName")
        private String urlName;



		/**
		 * String represents website url
		 */
		public String getUrl() {
			return url;
		}
		/**
		 * String represents website url
		 */
		public void setUrl(String url) {
			this.url = url;
		}
		/**
		 * URL name
		 */
		public String getUrlName() {
			return urlName;
		}
		/**
		 * URL name
		 */
		public void setUrlName(String urlName) {
			this.urlName = urlName;
		}
    }