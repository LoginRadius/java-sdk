/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Page Cover data
	// </summary>
	public class PageCover {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("OffsetX")
        private String offsetX;
		
		@SerializedName("OffsetY")
        private String offsetY;
		
		@SerializedName("Source")
        private String source;



		// <summary>
		//	Page cover id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Page cover id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Page cover offset X
		// </summary>
		public String getOffsetX() {
			return offsetX;
		}
		// <summary>
		//	Page cover offset X
		// </summary>
		public void setOffsetX(String offsetX) {
			this.offsetX = offsetX;
		}
		// <summary>
		//	Page cover offset Y
		// </summary>
		public String getOffsetY() {
			return offsetY;
		}
		// <summary>
		//	Page cover offset Y
		// </summary>
		public void setOffsetY(String offsetY) {
			this.offsetY = offsetY;
		}
		// <summary>
		//	Page cover source
		// </summary>
		public String getSource() {
			return source;
		}
		// <summary>
		//	Page cover source
		// </summary>
		public void setSource(String source) {
			this.source = source;
		}
    }