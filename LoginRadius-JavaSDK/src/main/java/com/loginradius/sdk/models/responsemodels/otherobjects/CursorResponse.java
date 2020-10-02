/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Cursor data
	 */
	public class CursorResponse<T> {
	
		
		@SerializedName("Data")
        private List<T> data;
		
		@SerializedName("NextCursor")
        private String nextCursor;



		/**
		 * Data
		 */
		public List<T> getData() {
			return data;
		}
		/**
		 * Data
		 */
		public void setData(List<T> data) {
			this.data = data;
		}
		/**
		 * Cursor value if not all contacts can be retrieved once.
		 */
		public String getNextCursor() {
			return nextCursor;
		}
		/**
		 * Cursor value if not all contacts can be retrieved once.
		 */
		public void setNextCursor(String nextCursor) {
			this.nextCursor = nextCursor;
		}
    }