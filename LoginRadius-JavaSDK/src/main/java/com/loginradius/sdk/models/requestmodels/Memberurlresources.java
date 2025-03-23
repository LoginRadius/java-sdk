/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Memberurlresources Property
	// </summary>
	public class Memberurlresources {
	
		
		@SerializedName("Url")
        private String url;
		
		@SerializedName("UrlName")
        private String urlName;



		// <summary>
		//	String represents website url
		// </summary>
		public String getUrl() {
			return url;
		}
		// <summary>
		//	String represents website url
		// </summary>
		public void setUrl(String url) {
			this.url = url;
		}
		// <summary>
		//	URL name
		// </summary>
		public String getUrlName() {
			return urlName;
		}
		// <summary>
		//	URL name
		// </summary>
		public void setUrlName(String urlName) {
			this.urlName = urlName;
		}
    }