/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for MultiFactorAuth By BackupCode API
	 */
	public class MultiFactorAuthModelByBackupCode {
	
		
		@SerializedName("BackupCode")
        private String backupCode;



		/**
		 * The Code generated as a recourse
		 */
		public String getBackupCode() {
			return backupCode;
		}
		/**
		 * The Code generated as a recourse
		 */
		public void setBackupCode(String backupCode) {
			this.backupCode = backupCode;
		}
    }