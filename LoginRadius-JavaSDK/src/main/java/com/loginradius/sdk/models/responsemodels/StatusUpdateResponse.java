/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete status data
	// </summary>
	public class StatusUpdateResponse {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Url")
        private ShortUrlResponse url;



		// <summary>
		//	Status id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Status id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	String represents website url
		// </summary>
		public ShortUrlResponse getUrl() {
			return url;
		}
		// <summary>
		//	String represents website url
		// </summary>
		public void setUrl(ShortUrlResponse url) {
			this.url = url;
		}
    }