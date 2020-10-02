/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Externalids data
	 */
	public class ExternalIds {
	
		
		@SerializedName("Source")
        private String source;
		
		@SerializedName("SourceId")
        private String sourceId;



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