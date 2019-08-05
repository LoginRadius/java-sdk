/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of List of Registration Data
	// </summary>
	public class RegistrationDataCreateModelList {
	
		
		@SerializedName("Data")
        private List<RegistrationDataCreateModel> data;



		// <summary>
		//	Data
		// </summary>
		public List<RegistrationDataCreateModel> getData() {
			return data;
		}
		// <summary>
		//	Data
		// </summary>
		public void setData(List<RegistrationDataCreateModel> data) {
			this.data = data;
		}
    }