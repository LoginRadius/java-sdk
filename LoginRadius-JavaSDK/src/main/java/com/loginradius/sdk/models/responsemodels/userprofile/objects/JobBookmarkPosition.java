/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Job Bookmark Position data
	 */
	public class JobBookmarkPosition {
	
		
		@SerializedName("Title")
        private String title;



		/**
		 * Position title
		 */
		public String getTitle() {
			return title;
		}
		/**
		 * Position title
		 */
		public void setTitle(String title) {
			this.title = title;
		}
    }