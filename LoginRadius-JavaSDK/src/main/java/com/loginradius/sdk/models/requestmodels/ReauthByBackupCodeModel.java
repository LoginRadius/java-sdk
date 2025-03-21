/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for MFA Reauthentication by Backup code
	// </summary>
	public class ReauthByBackupCodeModel {
	
		
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