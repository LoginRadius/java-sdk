/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Delete Request
	 */
	public class DeleteResponse {
	
		
		@SerializedName("IsDeleted")
        private Boolean isDeleted;
		
		@SerializedName("RecordsDeleted")
        private Integer recordsDeleted;



		/**
		 * boolean type value, default is true
		 */
		public Boolean getIsDeleted() {
			return isDeleted;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setIsDeleted(Boolean isDeleted) {
			this.isDeleted = isDeleted;
		}
		/**
		 * Number of Records Deleted
		 */
		public Integer getRecordsDeleted() {
			return recordsDeleted;
		}
		/**
		 * Number of Records Deleted
		 */
		public void setRecordsDeleted(Integer recordsDeleted) {
			this.recordsDeleted = recordsDeleted;
		}
    }