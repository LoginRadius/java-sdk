/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.OperationType;

	// <summary>
	//	Model Class containing Definition for Languages Property
	// </summary>
	public class Languages {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("op")
        private OperationType op;
		
		@SerializedName("Proficiency")
        private String proficiency;



		// <summary>
		//	Language id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Language id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Name of language
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Name of language
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Languages operation Type
		// </summary>
		public OperationType getOp() {
			return op;
		}
		// <summary>
		//	Languages operation Type
		// </summary>
		public void setOp(OperationType op) {
			this.op = op;
		}
		// <summary>
		//	Proficiency in language
		// </summary>
		public String getProficiency() {
			return proficiency;
		}
		// <summary>
		//	Proficiency in language
		// </summary>
		public void setProficiency(String proficiency) {
			this.proficiency = proficiency;
		}
    }