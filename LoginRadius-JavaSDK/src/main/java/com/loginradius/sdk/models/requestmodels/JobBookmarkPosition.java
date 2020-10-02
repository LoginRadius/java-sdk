/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for JobBookmarkPosition Property
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