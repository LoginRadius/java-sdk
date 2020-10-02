/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.OperationType;

	/**
	 * Model Class containing Definition for PlacesLived Property
	 */
	public class PlacesLived {
	
		
		@SerializedName("IsPrimary")
        private Boolean isPrimary;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("op")
        private OperationType op;



		/**
		 * place is primary or not
		 */
		public Boolean getIsPrimary() {
			return isPrimary;
		}
		/**
		 * place is primary or not
		 */
		public void setIsPrimary(Boolean isPrimary) {
			this.isPrimary = isPrimary;
		}
		/**
		 * Name of lived place
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of lived place
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Places Lived Operation type
		 */
		public OperationType getOp() {
			return op;
		}
		/**
		 * Places Lived Operation type
		 */
		public void setOp(OperationType op) {
			this.op = op;
		}
    }