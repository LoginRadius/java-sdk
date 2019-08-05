/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for Externallds Property
	// </summary>
	public class ExternalIds {
	
		
		@SerializedName("Source")
        private String source;
		
		@SerializedName("SourceId")
        private String sourceId;



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