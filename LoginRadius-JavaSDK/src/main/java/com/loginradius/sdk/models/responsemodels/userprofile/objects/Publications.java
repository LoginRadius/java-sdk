/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Publications data
	// </summary>
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



		// <summary>
		//	Author of the publication
		// </summary>
		public List<PublicationsAuthors> getAuthors() {
			return authors;
		}
		// <summary>
		//	Author of the publication
		// </summary>
		public void setAuthors(List<PublicationsAuthors> authors) {
			this.authors = authors;
		}
		// <summary>
		//	Date of the publication
		// </summary>
		public String getDate() {
			return date;
		}
		// <summary>
		//	Date of the publication
		// </summary>
		public void setDate(String date) {
			this.date = date;
		}
		// <summary>
		//	Id of the Publication
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of the Publication
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Publisher of the Publication
		// </summary>
		public String getPublisher() {
			return publisher;
		}
		// <summary>
		//	Publisher of the Publication
		// </summary>
		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}
		// <summary>
		//	Summary of the publication
		// </summary>
		public String getSummary() {
			return summary;
		}
		// <summary>
		//	Summary of the publication
		// </summary>
		public void setSummary(String summary) {
			this.summary = summary;
		}
		// <summary>
		//	Title of the publication
		// </summary>
		public String getTitle() {
			return title;
		}
		// <summary>
		//	Title of the publication
		// </summary>
		public void setTitle(String title) {
			this.title = title;
		}
		// <summary>
		//	Publication url
		// </summary>
		public String getUrl() {
			return url;
		}
		// <summary>
		//	Publication url
		// </summary>
		public void setUrl(String url) {
			this.url = url;
		}
    }