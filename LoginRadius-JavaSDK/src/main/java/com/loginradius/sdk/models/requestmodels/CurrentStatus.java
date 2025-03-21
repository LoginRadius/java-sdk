/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Current Status Property
	// </summary>
	public class CurrentStatus {
	
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Source")
        private String source;
		
		@SerializedName("Text")
        private String text;



		// <summary>
		//	Current status created date
		// </summary>
		public String getCreatedDate() {
			return createdDate;
		}
		// <summary>
		//	Current status created date
		// </summary>
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}
		// <summary>
		//	Current status id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Current status id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Current status source
		// </summary>
		public String getSource() {
			return source;
		}
		// <summary>
		//	Current status source
		// </summary>
		public void setSource(String source) {
			this.source = source;
		}
		// <summary>
		//	Current status text
		// </summary>
		public String getText() {
			return text;
		}
		// <summary>
		//	Current status text
		// </summary>
		public void setText(String text) {
			this.text = text;
		}
    }