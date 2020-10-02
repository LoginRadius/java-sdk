/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Patents data
	 */
	public class Patents {
	
		
		@SerializedName("Date")
        private String date;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Title")
        private String title;



		/**
		 * Date of patents
		 */
		public String getDate() {
			return date;
		}
		/**
		 * Date of patents
		 */
		public void setDate(String date) {
			this.date = date;
		}
		/**
		 * Id of the patents
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of the patents
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Title of the patents
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * Title of the patents
		 */
		public void setTitle(String title) {
			this.title = title;
		}
    }