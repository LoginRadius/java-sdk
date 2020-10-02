/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete CurrentStatus data
	 */
	public class CurrentStatus {
	
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Source")
        private String source;
		
		@SerializedName("Text")
        private String text;



		/**
		 * Current status created date
		 */
		public String getCreatedDate() {
			return createdDate;
		}
		/**
		 * Current status created date
		 */
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		/**
		 * Current status id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Current status id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Current status source
		 */
		public String getSource() {
			return source;
		}
		/**
		 * Current status source
		 */
		public void setSource(String source) {
			this.source = source;
		}
		/**
		 * Current status text
		 */
		public String getText() {
			return text;
		}
		/**
		 * Current status text
		 */
		public void setText(String text) {
			this.text = text;
		}
    }