/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model class containing list of multiple consent
	 */
	public class ConsentSubmitModel {
	
		
		@SerializedName("Data")
        private List<ConsentDataModel> data;
		
		@SerializedName("Events")
        private List<ConsentEventModel> events;



		/**
		 * Data
		 */
		public List<ConsentDataModel> getData() {
			return data;
		}
		/**
		 * Data
		 */
		public void setData(List<ConsentDataModel> data) {
			this.data = data;
		}
		/**
		 * The event associated with the consent form
		 */
		public List<ConsentEventModel> getEvents() {
			return events;
		}
		/**
		 * The event associated with the consent form
		 */
		public void setEvents(List<ConsentEventModel> events) {
			this.events = events;
		}
    }