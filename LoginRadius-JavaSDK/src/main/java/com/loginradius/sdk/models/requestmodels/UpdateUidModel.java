/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Payload containing Update UID
	 */
	public class UpdateUidModel {
	
		
		@SerializedName("NewUid")
        private String newUid;



		/**
		 * New Uid
		 */
		public String getNewUid() {
			return newUid;
		}
		/**
		 * New Uid
		 */
		public void setNewUid(String newUid) {
			this.newUid = newUid;
		}
    }