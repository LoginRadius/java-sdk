/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Album data
	 */
	public class FacebookAlbumImages {
	
		
		@SerializedName("Dimensions")
        private String dimensions;
		
		@SerializedName("Image")
        private String image;



		/**
		 * Photo dimensions
		 */
		public String getDimensions() {
			return dimensions;
		}
		/**
		 * Photo dimensions
		 */
		public void setDimensions(String dimensions) {
			this.dimensions = dimensions;
		}
		/**
		 * Images
		 */
		public String getImage() {
			return image;
		}
		/**
		 * Images
		 */
		public void setImage(String image) {
			this.image = image;
		}
    }