/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Backup Code data
	// </summary>
	public class BackupCodeResponse {
	
		
		@SerializedName("BackUpCodes")
        private List<String> backUpCodes;



		// <summary>
		//	The Code generated as a recourse
		// </summary>
		public List<String> getBackUpCodes() {
			return backUpCodes;
		}
		// <summary>
		//	The Code generated as a recourse
		// </summary>
		public void setBackUpCodes(List<String> backUpCodes) {
			this.backUpCodes = backUpCodes;
		}
    }