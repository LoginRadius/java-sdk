/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Validation data
	// </summary>
	public class EntityPermissionAcknowledgement {
	
		
		@SerializedName("IsAllowed")
        private Boolean isAllowed;



		// <summary>
		//	Webhook is allowed or not
		// </summary>
		public Boolean getIsAllowed() {
			return isAllowed;
		}
		// <summary>
		//	Webhook is allowed or not
		// </summary>
		public void setIsAllowed(Boolean isAllowed) {
			this.isAllowed = isAllowed;
		}
    }