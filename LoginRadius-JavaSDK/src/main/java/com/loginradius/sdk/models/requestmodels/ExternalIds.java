/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.OperationType;

	// <summary>
	//	Model Class containing Definition for Externallds Property
	// </summary>
	public class ExternalIds {
	
		
		@SerializedName("Op")
        private OperationType op;
		
		@SerializedName("Source")
        private String source;
		
		@SerializedName("SourceId")
        private String sourceId;



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
		//	ExternalId source
		// </summary>
		public String getSource() {
			return source;
		}
		// <summary>
		//	ExternalId source
		// </summary>
		public void setSource(String source) {
			this.source = source;
		}
		// <summary>
		//	External source id
		// </summary>
		public String getSourceId() {
			return sourceId;
		}
		// <summary>
		//	External source id
		// </summary>
		public void setSourceId(String sourceId) {
			this.sourceId = sourceId;
		}
    }