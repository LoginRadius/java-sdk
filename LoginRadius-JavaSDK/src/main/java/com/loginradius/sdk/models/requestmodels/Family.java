/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Family Property
	// </summary>
	public class Family {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Relationship")
        private String relationship;



		// <summary>
		//	Family id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Family id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Family name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Family name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Family relationship
		// </summary>
		public String getRelationship() {
			return relationship;
		}
		// <summary>
		//	Family relationship
		// </summary>
		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}
    }