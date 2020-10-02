/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for change PIN Property
	 */
	public class ChangePINModel {
	
		
		@SerializedName("NewPIN")
        private String newPIN;
		
		@SerializedName("OldPIN")
        private String oldPIN;



		/**
		 * New PIN of user
		 */
		public String getNewPIN() {
			return newPIN;
		}
		/**
		 * New PIN of user
		 */
		public void setNewPIN(String newPIN) {
			this.newPIN = newPIN;
		}
		/**
		 * Old PIN of user
		 */
		public String getOldPIN() {
			return oldPIN;
		}
		/**
		 * Old PIN of user
		 */
		public void setOldPIN(String oldPIN) {
			this.oldPIN = oldPIN;
		}
    }