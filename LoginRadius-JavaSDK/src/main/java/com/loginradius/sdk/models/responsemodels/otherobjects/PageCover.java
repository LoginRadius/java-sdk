/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Page Cover data
	 */
	public class PageCover {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("OffsetX")
        private String offsetX;
		
		@SerializedName("OffsetY")
        private String offsetY;
		
		@SerializedName("Source")
        private String source;



		/**
		 * Page cover id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Page cover id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Page cover offset X
		 */
		public String getOffsetX() {
			return offsetX;
		}
		/**
		 * Page cover offset X
		 */
		public void setOffsetX(String offsetX) {
			this.offsetX = offsetX;
		}
		/**
		 * Page cover offset Y
		 */
		public String getOffsetY() {
			return offsetY;
		}
		/**
		 * Page cover offset Y
		 */
		public void setOffsetY(String offsetY) {
			this.offsetY = offsetY;
		}
		/**
		 * Page cover source
		 */
		public String getSource() {
			return source;
		}
		/**
		 * Page cover source
		 */
		public void setSource(String source) {
			this.source = source;
		}
    }