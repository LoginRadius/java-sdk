/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete ShortUrl data
	// </summary>
	public class ShortUrlResponse {
	
		
		@SerializedName("ShortUrl")
        private String shortUrl;
		
		@SerializedName("UrlBase36Key")
        private String urlBase36Key;
		
		@SerializedName("UrlKey")
        private long urlKey;



		// <summary>
		//	short url
		// </summary>
		public String getShortUrl() {
			return shortUrl;
		}
		// <summary>
		//	short url
		// </summary>
		public void setShortUrl(String shortUrl) {
			this.shortUrl = shortUrl;
		}
		// <summary>
		//	Base 36 key of url
		// </summary>
		public String getUrlBase36Key() {
			return urlBase36Key;
		}
		// <summary>
		//	Base 36 key of url
		// </summary>
		public void setUrlBase36Key(String urlBase36Key) {
			this.urlBase36Key = urlBase36Key;
		}
		// <summary>
		//	Url key
		// </summary>
		public long getUrlKey() {
			return urlKey;
		}
		// <summary>
		//	Url key
		// </summary>
		public void setUrlKey(long urlKey) {
			this.urlKey = urlKey;
		}
    }