/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Patents data
	// </summary>
	public class Patents {
	
		
		@SerializedName("Date")
        private String date;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Title")
        private String title;



		// <summary>
		//	Date of patents
		// </summary>
		public String getDate() {
			return date;
		}
		// <summary>
		//	Date of patents
		// </summary>
		public void setDate(String date) {
			this.date = date;
		}
		// <summary>
		//	Id of the patents
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of the patents
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Title of the patents
		// </summary>
		public String getTitle() {
			return title;
		}
		// <summary>
		//	Title of the patents
		// </summary>
		public void setTitle(String title) {
			this.title = title;
		}
    }