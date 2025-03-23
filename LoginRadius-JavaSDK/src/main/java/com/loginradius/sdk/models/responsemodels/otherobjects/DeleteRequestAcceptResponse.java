/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Delete Request
	// </summary>
	public class DeleteRequestAcceptResponse {
	
		
		@SerializedName("IsDeleteRequestAccepted")
        private Boolean isDeleteRequestAccepted;



		// <summary>
		//	Is Delete Request Accepted
		// </summary>
		public Boolean getIsDeleteRequestAccepted() {
			return isDeleteRequestAccepted;
		}
		// <summary>
		//	Is Delete Request Accepted
		// </summary>
		public void setIsDeleteRequestAccepted(Boolean isDeleteRequestAccepted) {
			this.isDeleteRequestAccepted = isDeleteRequestAccepted;
		}
    }