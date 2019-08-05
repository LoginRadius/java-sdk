/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete active sessions
	// </summary>
	public class UserActiveSession {
	
		
		@SerializedName("data")
        private List<ActiveSessionDetail> data;
		
		@SerializedName("nextcursor")
        private int nextcursor;



		// <summary>
		//	Data
		// </summary>
		public List<ActiveSessionDetail> getData() {
			return data;
		}
		// <summary>
		//	Data
		// </summary>
		public void setData(List<ActiveSessionDetail> data) {
			this.data = data;
		}
		// <summary>
		//	Cursor value if not all contacts can be retrieved once.
		// </summary>
		public int getNextcursor() {
			return nextcursor;
		}
		// <summary>
		//	Cursor value if not all contacts can be retrieved once.
		// </summary>
		public void setNextcursor(int nextcursor) {
			this.nextcursor = nextcursor;
		}
    }