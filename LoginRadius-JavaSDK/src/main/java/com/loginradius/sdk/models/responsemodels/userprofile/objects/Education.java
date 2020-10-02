/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Education data
	 */
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



		/**
		 * Activities
		 */
		public String getActivities() {
			return activities;
		}
		/**
		 * Activities
		 */
		public void setActivities(String activities) {
			this.activities = activities;
		}
		/**
		 * Degree
		 */
		public String getDegree() {
			return degree;
		}
		/**
		 * Degree
		 */
		public void setDegree(String degree) {
			this.degree = degree;
		}
		/**
		 * Education End Date
		 */
		public String getEndDate() {
			return endDate;
		}
		/**
		 * Education End Date
		 */
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		/**
		 * Fields of study
		 */
		public String getFieldofstudy() {
			return fieldofstudy;
		}
		/**
		 * Fields of study
		 */
		public void setFieldofstudy(String fieldofstudy) {
			this.fieldofstudy = fieldofstudy;
		}
		/**
		 * Notes
		 */
		public String getNotes() {
			return notes;
		}
		/**
		 * Notes
		 */
		public void setNotes(String notes) {
			this.notes = notes;
		}
		/**
		 * School of the user
		 */
		public String getSchool() {
			return school;
		}
		/**
		 * School of the user
		 */
		public void setSchool(String school) {
			this.school = school;
		}
		/**
		 * Start date of Education of user
		 */
		public String getStartDate() {
			return startDate;
		}
		/**
		 * Start date of Education of user
		 */
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		/**
		 * Type
		 */
		public String getType() {
			return type;
		}
		/**
		 * Type
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * Year of Education
		 */
		public String getYear() {
			return year;
		}
		/**
		 * Year of Education
		 */
		public void setYear(String year) {
			this.year = year;
		}
    }