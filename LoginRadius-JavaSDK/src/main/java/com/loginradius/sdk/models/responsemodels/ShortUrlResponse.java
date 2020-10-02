/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete ShortUrl data
	 */
	public class ShortUrlResponse {
	
		
		@SerializedName("ShortUrl")
        private String shortUrl;
		
		@SerializedName("UrlBase36Key")
        private String urlBase36Key;
		
		@SerializedName("UrlKey")
        private long urlKey;



		/**
		 * short url
		 */
		public String getShortUrl() {
			return shortUrl;
		}
		/**
		 * short url
		 */
		public void setShortUrl(String shortUrl) {
			this.shortUrl = shortUrl;
		}
		/**
		 * Base 36 key of url
		 */
		public String getUrlBase36Key() {
			return urlBase36Key;
		}
		/**
		 * Base 36 key of url
		 */
		public void setUrlBase36Key(String urlBase36Key) {
			this.urlBase36Key = urlBase36Key;
		}
		/**
		 * Url key
		 */
		public long getUrlKey() {
			return urlKey;
		}
		/**
		 * Url key
		 */
		public void setUrlKey(long urlKey) {
			this.urlKey = urlKey;
		}
    }