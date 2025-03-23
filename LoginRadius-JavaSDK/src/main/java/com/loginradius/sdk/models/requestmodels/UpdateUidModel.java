/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Payload containing Update UID
	// </summary>
	public class UpdateUidModel {
	
		
		@SerializedName("NewUid")
        private String newUid;



		// <summary>
		//	New Uid
		// </summary>
		public String getNewUid() {
			return newUid;
		}
		// <summary>
		//	New Uid
		// </summary>
		public void setNewUid(String newUid) {
			this.newUid = newUid;
		}
    }