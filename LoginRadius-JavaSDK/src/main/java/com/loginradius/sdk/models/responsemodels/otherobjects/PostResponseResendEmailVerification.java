/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete AuthSendVerificationEmailForLinkingSocialProfiles API Response
	// </summary>
	public class PostResponseResendEmailVerification {
	
		
		@SerializedName("IsPosted")
        private Boolean isPosted;
		
		@SerializedName("uuid")
        private String uuid;



		// <summary>
		//	check data is posted
		// </summary>
		public Boolean getIsPosted() {
			return isPosted;
		}
		// <summary>
		//	check data is posted
		// </summary>
		public void setIsPosted(Boolean isPosted) {
			this.isPosted = isPosted;
		}
		// <summary>
		//	The uuid received in the response
		// </summary>
		public String getUuid() {
			return uuid;
		}
		// <summary>
		//	The uuid received in the response
		// </summary>
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
    }