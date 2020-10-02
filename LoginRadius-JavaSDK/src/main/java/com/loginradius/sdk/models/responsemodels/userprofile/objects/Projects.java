/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Projects data
	 */
	public class Projects {
	
		
		@SerializedName("EndDate")
        private String endDate;
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("IsCurrent")
        private String isCurrent;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("StartDate")
        private String startDate;
		
		@SerializedName("Summary")
        private String summary;
		
		@SerializedName("With")
        private List<NameId> with;



		/**
		 * End date of the project
		 */
		public String getEndDate() {
			return endDate;
		}
		/**
		 * End date of the project
		 */
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		/**
		 * Id of the project
		 */
		public String getId() {
			return id;
		}
		/**
		 * Id of the project
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * is current or not
		 */
		public String getIsCurrent() {
			return isCurrent;
		}
		/**
		 * is current or not
		 */
		public void setIsCurrent(String isCurrent) {
			this.isCurrent = isCurrent;
		}
		/**
		 * Name of the project
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of the project
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Start date of the project
		 */
		public String getStartDate() {
			return startDate;
		}
		/**
		 * Start date of the project
		 */
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		/**
		 * Summary of the project
		 */
		public String getSummary() {
			return summary;
		}
		/**
		 * Summary of the project
		 */
		public void setSummary(String summary) {
			this.summary = summary;
		}
		/**
		 * Projects done with
		 */
		public List<NameId> getWith() {
			return with;
		}
		/**
		 * Projects done with
		 */
		public void setWith(List<NameId> with) {
			this.with = with;
		}
    }