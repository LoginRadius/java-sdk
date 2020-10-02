/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.OperationType;

	/**
	 * Model Class containing Definition for Languages Property
	 */
	public class Languages {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Op")
        private OperationType op;
		
		@SerializedName("Proficiency")
        private String proficiency;



		/**
		 * Language id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Language id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Name of language
		 */
		public String getName() {
			return name;
		}
		/**
		 * Name of language
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Languages operation Type
		 */
		public OperationType getOp() {
			return op;
		}
		/**
		 * Languages operation Type
		 */
		public void setOp(OperationType op) {
			this.op = op;
		}
		/**
		 * Proficiency in language
		 */
		public String getProficiency() {
			return proficiency;
		}
		/**
		 * Proficiency in language
		 */
		public void setProficiency(String proficiency) {
			this.proficiency = proficiency;
		}
    }