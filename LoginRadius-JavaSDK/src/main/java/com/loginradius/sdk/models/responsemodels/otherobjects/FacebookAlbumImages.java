/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Album data
	// </summary>
	public class FacebookAlbumImages {
	
		
		@SerializedName("Dimensions")
        private String dimensions;
		
		@SerializedName("Image")
        private String image;



		// <summary>
		//	Photo dimensions
		// </summary>
		public String getDimensions() {
			return dimensions;
		}
		// <summary>
		//	Photo dimensions
		// </summary>
		public void setDimensions(String dimensions) {
			this.dimensions = dimensions;
		}
		// <summary>
		//	Images
		// </summary>
		public String getImage() {
			return image;
		}
		// <summary>
		//	Images
		// </summary>
		public void setImage(String image) {
			this.image = image;
		}
    }