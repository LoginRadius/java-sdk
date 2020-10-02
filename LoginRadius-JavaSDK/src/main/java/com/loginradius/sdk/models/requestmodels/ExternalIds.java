/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.enums.OperationType;

	/**
	 * Model Class containing Definition for Externallds Property
	 */
	public class ExternalIds {
	
		
		@SerializedName("Op")
        private OperationType op;
		
		@SerializedName("Source")
        private String source;
		
		@SerializedName("SourceId")
        private String sourceId;



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
		 * ExternalId source
		 */
		public String getSource() {
			return source;
		}
		/**
		 * ExternalId source
		 */
		public void setSource(String source) {
			this.source = source;
		}
		/**
		 * External source id
		 */
		public String getSourceId() {
			return sourceId;
		}
		/**
		 * External source id
		 */
		public void setSourceId(String sourceId) {
			this.sourceId = sourceId;
		}
    }