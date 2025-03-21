/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Job Bookmark data
	// </summary>
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



		// <summary>
		//	Job Bookmarks Apply Timestamp
		// </summary>
		public String getApplyTimestamp() {
			return applyTimestamp;
		}
		// <summary>
		//	Job Bookmarks Apply Timestamp
		// </summary>
		public void setApplyTimestamp(String applyTimestamp) {
			this.applyTimestamp = applyTimestamp;
		}
		// <summary>
		//	Job bookmark is applied or not
		// </summary>
		public Boolean getIsApplied() {
			return isApplied;
		}
		// <summary>
		//	Job bookmark is applied or not
		// </summary>
		public void setIsApplied(Boolean isApplied) {
			this.isApplied = isApplied;
		}
		// <summary>
		//	Job bookmark is saved or not
		// </summary>
		public Boolean getIsSaved() {
			return isSaved;
		}
		// <summary>
		//	Job bookmark is saved or not
		// </summary>
		public void setIsSaved(Boolean isSaved) {
			this.isSaved = isSaved;
		}
		// <summary>
		//	Job
		// </summary>
		public Job getJob() {
			return job;
		}
		// <summary>
		//	Job
		// </summary>
		public void setJob(Job job) {
			this.job = job;
		}
		// <summary>
		//	Saved time stamp of Job bookmarks
		// </summary>
		public String getSavedTimestamp() {
			return savedTimestamp;
		}
		// <summary>
		//	Saved time stamp of Job bookmarks
		// </summary>
		public void setSavedTimestamp(String savedTimestamp) {
			this.savedTimestamp = savedTimestamp;
		}
    }