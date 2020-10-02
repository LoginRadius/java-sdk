/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Backup Code data
	 */
	public class BackupCodeResponse {
	
		
		@SerializedName("BackUpCodes")
        private List<String> backUpCodes;



		/**
		 * The Code generated as a recourse
		 */
		public List<String> getBackUpCodes() {
			return backUpCodes;
		}
		/**
		 * The Code generated as a recourse
		 */
		public void setBackUpCodes(List<String> backUpCodes) {
			this.backUpCodes = backUpCodes;
		}
    }