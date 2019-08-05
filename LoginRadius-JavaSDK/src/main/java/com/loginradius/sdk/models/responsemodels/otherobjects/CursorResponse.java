/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Cursor data
	// </summary>
	public class CursorResponse<T> {
	
		
		@SerializedName("Data")
        private List<T> data;
		
		@SerializedName("NextCursor")
        private String nextCursor;



		// <summary>
		//	Data
		// </summary>
		public List<T> getData() {
			return data;
		}
		// <summary>
		//	Data
		// </summary>
		public void setData(List<T> data) {
			this.data = data;
		}
		// <summary>
		//	Cursor value if not all contacts can be retrieved once.
		// </summary>
		public String getNextCursor() {
			return nextCursor;
		}
		// <summary>
		//	Cursor value if not all contacts can be retrieved once.
		// </summary>
		public void setNextCursor(String nextCursor) {
			this.nextCursor = nextCursor;
		}
    }