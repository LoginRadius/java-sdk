/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Registration Data
	// </summary>
	public class RegistrationData {
	
		
		@SerializedName("Data")
        private List<DataValue> data;



		// <summary>
		//	Data
		// </summary>
		public List<DataValue> getData() {
			return data;
		}
		// <summary>
		//	Data
		// </summary>
		public void setData(List<DataValue> data) {
			this.data = data;
		}
    }