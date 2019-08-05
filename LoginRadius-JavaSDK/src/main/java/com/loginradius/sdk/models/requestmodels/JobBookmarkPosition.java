/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for JobBookmarkPosition Property
	// </summary>
	public class JobBookmarkPosition {
	
		
		@SerializedName("Title")
        private String title;



		// <summary>
		//	Position title
		// </summary>
		public String getTitle() {
			return title;
		}
		// <summary>
		//	Position title
		// </summary>
		public void setTitle(String title) {
			this.title = title;
		}
    }