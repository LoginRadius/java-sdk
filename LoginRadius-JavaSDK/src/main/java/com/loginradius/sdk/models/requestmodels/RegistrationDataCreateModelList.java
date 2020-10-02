/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of List of Registration Data
	 */
	public class RegistrationDataCreateModelList {
	
		
		@SerializedName("Data")
        private List<RegistrationDataCreateModel> data;



		/**
		 * Data
		 */
		public List<RegistrationDataCreateModel> getData() {
			return data;
		}
		/**
		 * Data
		 */
		public void setData(List<RegistrationDataCreateModel> data) {
			this.data = data;
		}
    }