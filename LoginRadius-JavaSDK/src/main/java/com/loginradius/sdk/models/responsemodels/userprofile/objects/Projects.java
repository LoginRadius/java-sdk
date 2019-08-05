/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Projects data
	// </summary>
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



		// <summary>
		//	End date of the project
		// </summary>
		public String getEndDate() {
			return endDate;
		}
		// <summary>
		//	End date of the project
		// </summary>
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		// <summary>
		//	Id of the project
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Id of the project
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	is current or not
		// </summary>
		public String getIsCurrent() {
			return isCurrent;
		}
		// <summary>
		//	is current or not
		// </summary>
		public void setIsCurrent(String isCurrent) {
			this.isCurrent = isCurrent;
		}
		// <summary>
		//	Name of the project
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of the project
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Start date of the project
		// </summary>
		public String getStartDate() {
			return startDate;
		}
		// <summary>
		//	Start date of the project
		// </summary>
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		// <summary>
		//	Summary of the project
		// </summary>
		public String getSummary() {
			return summary;
		}
		// <summary>
		//	Summary of the project
		// </summary>
		public void setSummary(String summary) {
			this.summary = summary;
		}
		// <summary>
		//	Projects done with
		// </summary>
		public List<NameId> getWith() {
			return with;
		}
		// <summary>
		//	Projects done with
		// </summary>
		public void setWith(List<NameId> with) {
			this.with = with;
		}
    }