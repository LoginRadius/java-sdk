/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Delete Request
	 */
	public class DeleteRequestAcceptResponse {
	
		
		@SerializedName("IsDeleteRequestAccepted")
        private Boolean isDeleteRequestAccepted;



		/**
		 * Is Delete Request Accepted
		 */
		public Boolean getIsDeleteRequestAccepted() {
			return isDeleteRequestAccepted;
		}
		/**
		 * Is Delete Request Accepted
		 */
		public void setIsDeleteRequestAccepted(Boolean isDeleteRequestAccepted) {
			this.isDeleteRequestAccepted = isDeleteRequestAccepted;
		}
    }