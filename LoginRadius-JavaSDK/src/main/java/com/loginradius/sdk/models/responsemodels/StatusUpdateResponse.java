/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete status data
	 */
	public class StatusUpdateResponse {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Url")
        private ShortUrlResponse url;



		/**
		 * Status id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Status id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * String represents website url
		 */
		public ShortUrlResponse getUrl() {
			return url;
		}
		/**
		 * String represents website url
		 */
		public void setUrl(ShortUrlResponse url) {
			this.url = url;
		}
    }