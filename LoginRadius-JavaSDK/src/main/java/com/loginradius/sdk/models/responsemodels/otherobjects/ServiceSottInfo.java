/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Sott data
	// </summary>
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



		// <summary>
		//	EndTime
		// </summary>
		public String getEndTime() {
			return endTime;
		}
		// <summary>
		//	EndTime
		// </summary>
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		// <summary>
		//	Forwarded IP
		// </summary>
		public String getForWardedIP() {
			return forWardedIP;
		}
		// <summary>
		//	Forwarded IP
		// </summary>
		public void setForWardedIP(String forWardedIP) {
			this.forWardedIP = forWardedIP;
		}
		// <summary>
		//	users ip address
		// </summary>
		public String getIP() {
			return iP;
		}
		// <summary>
		//	users ip address
		// </summary>
		public void setIP(String iP) {
			this.iP = iP;
		}
		// <summary>
		//	Start time
		// </summary>
		public String getStartTime() {
			return startTime;
		}
		// <summary>
		//	Start time
		// </summary>
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		// <summary>
		//	Difference between start time and end time
		// </summary>
		public String getTimeDifference() {
			return timeDifference;
		}
		// <summary>
		//	Difference between start time and end time
		// </summary>
		public void setTimeDifference(String timeDifference) {
			this.timeDifference = timeDifference;
		}
    }