/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;
import java.util.Map;
import java.util.List;
import java.util.UUID;
import com.google.gson.JsonObject;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.*;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for WebHookEventModel Property
	// </summary>
	public class WebHookEventModel {
	
		
		@SerializedName("Data")
        private List<String> data;



		// <summary>
		//	Data
		// </summary>
		public List<String> getData() {
			return data;
		}
		// <summary>
		//	Data
		// </summary>
		public void setData(List<String> data) {
			this.data = data;
		}
    }