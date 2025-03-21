/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.OperationType;

	// <summary>
	//	Model Class containing Definition for PlacesLived Property
	// </summary>
	public class PlacesLived {
	
		
		@SerializedName("IsPrimary")
        private Boolean isPrimary;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("op")
        private OperationType op;



		// <summary>
		//	place is primary or not
		// </summary>
		public Boolean getIsPrimary() {
			return isPrimary;
		}
		// <summary>
		//	place is primary or not
		// </summary>
		public void setIsPrimary(Boolean isPrimary) {
			this.isPrimary = isPrimary;
		}
		// <summary>
		//	Name of lived place
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of lived place
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Places Lived Operation type
		// </summary>
		public OperationType getOp() {
			return op;
		}
		// <summary>
		//	Places Lived Operation type
		// </summary>
		public void setOp(OperationType op) {
			this.op = op;
		}
    }