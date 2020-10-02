/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for Publications Property
	 */
	public class Publications {
	
		
		@SerializedName("Authors")
        private List<PublicationsAuthors> authors;
		
		@SerializedName("Date")
        private String date;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Publisher")
        private String publisher;
		
		@SerializedName("Summary")
        private String summary;
		
		@SerializedName("Title")
        private String title;
		
		@SerializedName("Url")
        private String url;



		/**
		 * Author of the publication
		 */
		public List<PublicationsAuthors> getAuthors() {
			return authors;
		}
		/**
		 * Author of the publication
		 */
		public void setAuthors(List<PublicationsAuthors> authors) {
			this.authors = authors;
		}
		/**
		 * Date of the publication
		 */
		public String getDate() {
			return date;
		}
		/**
		 * Date of the publication
		 */
		public void setDate(String date) {
			this.date = date;
		}
		/**
		 * Id of the Publication
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of the Publication
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Publisher of the Publication
		 */
		public String getPublisher() {
			return publisher;
		}
		/**
		 * Publisher of the Publication
		 */
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		/**
		 * Summary of the publication
		 */
		public String getSummary() {
			return summary;
		}
		/**
		 * Summary of the publication
		 */
		public void setSummary(String summary) {
			this.summary = summary;
		}
		/**
		 * Title of the publication
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * Title of the publication
		 */
		public void setTitle(String title) {
			this.title = title;
		}
		/**
		 * Publication url
		 */
		public String getUrl() {
			return url;
		}
		/**
		 * Publication url
		 */
		public void setUrl(String url) {
			this.url = url;
		}
    }