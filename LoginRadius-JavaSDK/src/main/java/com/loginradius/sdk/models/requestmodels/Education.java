/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Education Property
	// </summary>
	public class Education {
	
		
		@SerializedName("activities")
        private String activities;
		
		@SerializedName("degree")
        private String degree;
		
		@SerializedName("EndDate")
        private String endDate;
		
		@SerializedName("fieldofstudy")
        private String fieldofstudy;
		
		@SerializedName("notes")
        private String notes;
		
		@SerializedName("School")
        private String school;
		
		@SerializedName("StartDate")
        private String startDate;
		
		@SerializedName("type")
        private String type;
		
		@SerializedName("year")
        private String year;



		// <summary>
		//	Activities
		// </summary>
		public String getActivities() {
			return activities;
		}
		// <summary>
		//	Activities
		// </summary>
		public void setActivities(String activities) {
			this.activities = activities;
		}
		// <summary>
		//	Degree
		// </summary>
		public String getDegree() {
			return degree;
		}
		// <summary>
		//	Degree
		// </summary>
		public void setDegree(String degree) {
			this.degree = degree;
		}
		// <summary>
		//	Education End Date
		// </summary>
		public String getEndDate() {
			return endDate;
		}
		// <summary>
		//	Education End Date
		// </summary>
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		// <summary>
		//	Fields of study
		// </summary>
		public String getFieldofstudy() {
			return fieldofstudy;
		}
		// <summary>
		//	Fields of study
		// </summary>
		public void setFieldofstudy(String fieldofstudy) {
			this.fieldofstudy = fieldofstudy;
		}
		// <summary>
		//	Notes
		// </summary>
		public String getNotes() {
			return notes;
		}
		// <summary>
		//	Notes
		// </summary>
		public void setNotes(String notes) {
			this.notes = notes;
		}
		// <summary>
		//	School of the user
		// </summary>
		public String getSchool() {
			return school;
		}
		// <summary>
		//	School of the user
		// </summary>
		public void setSchool(String school) {
			this.school = school;
		}
		// <summary>
		//	Start date of Education of user
		// </summary>
		public String getStartDate() {
			return startDate;
		}
		// <summary>
		//	Start date of Education of user
		// </summary>
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		// <summary>
		//	Type
		// </summary>
		public String getType() {
			return type;
		}
		// <summary>
		//	Type
		// </summary>
		public void setType(String type) {
			this.type = type;
		}
		// <summary>
		//	Year of Education
		// </summary>
		public String getYear() {
			return year;
		}
		// <summary>
		//	Year of Education
		// </summary>
		public void setYear(String year) {
			this.year = year;
		}
    }