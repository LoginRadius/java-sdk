/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Validation data
	 */
	public class EntityPermissionAcknowledgement {
	
		
		@SerializedName("IsAllowed")
        private Boolean isAllowed;



		/**
		 * Webhook is allowed or not
		 */
		public Boolean getIsAllowed() {
			return isAllowed;
		}
		/**
		 * Webhook is allowed or not
		 */
		public void setIsAllowed(Boolean isAllowed) {
			this.isAllowed = isAllowed;
		}
    }