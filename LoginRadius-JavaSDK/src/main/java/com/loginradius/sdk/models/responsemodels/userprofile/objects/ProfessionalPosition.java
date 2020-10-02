/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Professional Position data
	 */
	public class ProfessionalPosition {
	
		
		@SerializedName("Company")
        private PositionCompany company;
		
		@SerializedName("EndDate")
        private String endDate;
		
		@SerializedName("IsCurrent")
        private String isCurrent;
		
		@SerializedName("Location")
        private String location;
		
		@SerializedName("Position")
        private String position;
		
		@SerializedName("StartDate")
        private String startDate;
		
		@SerializedName("Summary")
        private String summary;



		/**
		 * Company of the professional position
		 */
		public PositionCompany getCompany() {
			return company;
		}
		/**
		 * Company of the professional position
		 */
		public void setCompany(PositionCompany company) {
			this.company = company;
		}
		/**
		 * End date of the professional position
		 */
		public String getEndDate() {
			return endDate;
		}
		/**
		 * End date of the professional position
		 */
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		/**
		 * Is current or not
		 */
		public String getIsCurrent() {
			return isCurrent;
		}
		/**
		 * Is current or not
		 */
		public void setIsCurrent(String isCurrent) {
			this.isCurrent = isCurrent;
		}
		/**
		 * Location of the professional position
		 */
		public String getLocation() {
			return location;
		}
		/**
		 * Location of the professional position
		 */
		public void setLocation(String location) {
			this.location = location;
		}
		/**
		 * Position
		 */
		public String getPosition() {
			return position;
		}
		/**
		 * Position
		 */
		public void setPosition(String position) {
			this.position = position;
		}
		/**
		 * Start date of the professional position
		 */
		public String getStartDate() {
			return startDate;
		}
		/**
		 * Start date of the professional position
		 */
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		/**
		 * Summary of the professional position
		 */
		public String getSummary() {
			return summary;
		}
		/**
		 * Summary of the professional position
		 */
		public void setSummary(String summary) {
			this.summary = summary;
		}
    }