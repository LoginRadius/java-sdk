/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Sott data
	 */
	public class ServiceSottInfo {
	
		
		@SerializedName("EndTime")
        private String endTime;
		
		@SerializedName("ForWardedIP")
        private String forWardedIP;
		
		@SerializedName("IP")
        private String iP;
		
		@SerializedName("StartTime")
        private String startTime;
		
		@SerializedName("TimeDifference")
        private String timeDifference;



		/**
		 * EndTime
		 */
		public String getEndTime() {
			return endTime;
		}
		/**
		 * EndTime
		 */
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		/**
		 * Forwarded IP
		 */
		public String getForWardedIP() {
			return forWardedIP;
		}
		/**
		 * Forwarded IP
		 */
		public void setForWardedIP(String forWardedIP) {
			this.forWardedIP = forWardedIP;
		}
		/**
		 * users ip address
		 */
		public String getIP() {
			return iP;
		}
		/**
		 * users ip address
		 */
		public void setIP(String iP) {
			this.iP = iP;
		}
		/**
		 * Start time
		 */
		public String getStartTime() {
			return startTime;
		}
		/**
		 * Start time
		 */
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		/**
		 * Difference between start time and end time
		 */
		public String getTimeDifference() {
			return timeDifference;
		}
		/**
		 * Difference between start time and end time
		 */
		public void setTimeDifference(String timeDifference) {
			this.timeDifference = timeDifference;
		}
    }