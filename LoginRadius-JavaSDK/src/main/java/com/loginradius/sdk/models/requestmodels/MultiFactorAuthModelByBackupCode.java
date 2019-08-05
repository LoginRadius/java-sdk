/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for MultiFactorAuth By BackupCode API
	// </summary>
	public class MultiFactorAuthModelByBackupCode {
	
		
		@SerializedName("BackupCode")
        private String backupCode;



		// <summary>
		//	The Code generated as a recourse
		// </summary>
		public String getBackupCode() {
			return backupCode;
		}
		// <summary>
		//	The Code generated as a recourse
		// </summary>
		public void setBackupCode(String backupCode) {
			this.backupCode = backupCode;
		}
    }