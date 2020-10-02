/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for JobBookmarks Property
	 */
	public class JobBookmarks {
	
		
		@SerializedName("ApplyTimestamp")
        private String applyTimestamp;
		
		@SerializedName("IsApplied")
        private Boolean isApplied;
		
		@SerializedName("IsSaved")
        private Boolean isSaved;
		
		@SerializedName("Job")
        private Job job;
		
		@SerializedName("SavedTimestamp")
        private String savedTimestamp;



		/**
		 * Job Bookmarks Apply Timestamp
		 */
		public String getApplyTimestamp() {
			return applyTimestamp;
		}
		/**
		 * Job Bookmarks Apply Timestamp
		 */
		public void setApplyTimestamp(String applyTimestamp) {
			this.applyTimestamp = applyTimestamp;
		}
		/**
		 * Job bookmark is applied or not
		 */
		public Boolean getIsApplied() {
			return isApplied;
		}
		/**
		 * Job bookmark is applied or not
		 */
		public void setIsApplied(Boolean isApplied) {
			this.isApplied = isApplied;
		}
		/**
		 * Job bookmark is saved or not
		 */
		public Boolean getIsSaved() {
			return isSaved;
		}
		/**
		 * Job bookmark is saved or not
		 */
		public void setIsSaved(Boolean isSaved) {
			this.isSaved = isSaved;
		}
		/**
		 * Job
		 */
		public Job getJob() {
			return job;
		}
		/**
		 * Job
		 */
		public void setJob(Job job) {
			this.job = job;
		}
		/**
		 * Saved time stamp of Job bookmarks
		 */
		public String getSavedTimestamp() {
			return savedTimestamp;
		}
		/**
		 * Saved time stamp of Job bookmarks
		 */
		public void setSavedTimestamp(String savedTimestamp) {
			this.savedTimestamp = savedTimestamp;
		}
    }