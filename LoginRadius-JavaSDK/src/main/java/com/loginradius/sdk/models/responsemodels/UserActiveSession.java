/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete active sessions
	 */
	public class UserActiveSession {
	
		
		@SerializedName("data")
        private List<ActiveSessionDetail> data;
		
		@SerializedName("nextcursor")
        private int nextcursor;



		/**
		 * Data
		 */
		public List<ActiveSessionDetail> getData() {
			return data;
		}
		/**
		 * Data
		 */
		public void setData(List<ActiveSessionDetail> data) {
			this.data = data;
		}
		/**
		 * Cursor value if not all contacts can be retrieved once.
		 */
		public int getNextcursor() {
			return nextcursor;
		}
		/**
		 * Cursor value if not all contacts can be retrieved once.
		 */
		public void setNextcursor(int nextcursor) {
			this.nextcursor = nextcursor;
		}
    }