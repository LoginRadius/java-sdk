/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Delete Request
	// </summary>
	public class DeleteResponse {
	
		
		@SerializedName("IsDeleted")
        private Boolean isDeleted;
		
		@SerializedName("RecordsDeleted")
        private Integer recordsDeleted;



		// <summary>
		//	boolean type value, default is true
		// </summary>
		public Boolean getIsDeleted() {
			return isDeleted;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setIsDeleted(Boolean isDeleted) {
			this.isDeleted = isDeleted;
		}
		// <summary>
		//	Number of Records Deleted
		// </summary>
		public Integer getRecordsDeleted() {
			return recordsDeleted;
		}
		// <summary>
		//	Number of Records Deleted
		// </summary>
		public void setRecordsDeleted(Integer recordsDeleted) {
			this.recordsDeleted = recordsDeleted;
		}
    }