/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model class containing list of multiple consent
	// </summary>
	public class ConsentSubmitModel {
	
		
		@SerializedName("Data")
        private List<ConsentDataModel> data;
		
		@SerializedName("Events")
        private List<ConsentEventModel> events;



		// <summary>
		//	Data
		// </summary>
		public List<ConsentDataModel> getData() {
			return data;
		}
		// <summary>
		//	Data
		// </summary>
		public void setData(List<ConsentDataModel> data) {
			this.data = data;
		}
		// <summary>
		//	The event associated with the consent form
		// </summary>
		public List<ConsentEventModel> getEvents() {
			return events;
		}
		// <summary>
		//	The event associated with the consent form
		// </summary>
		public void setEvents(List<ConsentEventModel> events) {
			this.events = events;
		}
    }