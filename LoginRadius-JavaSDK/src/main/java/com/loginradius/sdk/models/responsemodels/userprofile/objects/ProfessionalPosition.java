/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Professional Position data
	// </summary>
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



		// <summary>
		//	Company of the professional position
		// </summary>
		public PositionCompany getCompany() {
			return company;
		}
		// <summary>
		//	Company of the professional position
		// </summary>
		public void setCompany(PositionCompany company) {
			this.company = company;
		}
		// <summary>
		//	End date of the professional position
		// </summary>
		public String getEndDate() {
			return endDate;
		}
		// <summary>
		//	End date of the professional position
		// </summary>
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		// <summary>
		//	Is current or not
		// </summary>
		public String getIsCurrent() {
			return isCurrent;
		}
		// <summary>
		//	Is current or not
		// </summary>
		public void setIsCurrent(String isCurrent) {
			this.isCurrent = isCurrent;
		}
		// <summary>
		//	Location of the professional position
		// </summary>
		public String getLocation() {
			return location;
		}
		// <summary>
		//	Location of the professional position
		// </summary>
		public void setLocation(String location) {
			this.location = location;
		}
		// <summary>
		//	Position
		// </summary>
		public String getPosition() {
			return position;
		}
		// <summary>
		//	Position
		// </summary>
		public void setPosition(String position) {
			this.position = position;
		}
		// <summary>
		//	Start date of the professional position
		// </summary>
		public String getStartDate() {
			return startDate;
		}
		// <summary>
		//	Start date of the professional position
		// </summary>
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		// <summary>
		//	Summary of the professional position
		// </summary>
		public String getSummary() {
			return summary;
		}
		// <summary>
		//	Summary of the professional position
		// </summary>
		public void setSummary(String summary) {
			this.summary = summary;
		}
    }