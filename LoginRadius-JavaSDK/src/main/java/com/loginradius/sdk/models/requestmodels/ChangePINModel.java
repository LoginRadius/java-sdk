/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for change PIN Property
	// </summary>
	public class ChangePINModel {
	
		
		@SerializedName("NewPIN")
        private String newPIN;
		
		@SerializedName("OldPIN")
        private String oldPIN;



		// <summary>
		//	New PIN of user
		// </summary>
		public String getNewPIN() {
			return newPIN;
		}
		// <summary>
		//	New PIN of user
		// </summary>
		public void setNewPIN(String newPIN) {
			this.newPIN = newPIN;
		}
		// <summary>
		//	Old PIN of user
		// </summary>
		public String getOldPIN() {
			return oldPIN;
		}
		// <summary>
		//	Old PIN of user
		// </summary>
		public void setOldPIN(String oldPIN) {
			this.oldPIN = oldPIN;
		}
    }