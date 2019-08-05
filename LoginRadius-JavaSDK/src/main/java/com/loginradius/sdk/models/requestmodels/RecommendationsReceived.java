/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition for RecommendationsReceived
	// </summary>
	public class RecommendationsReceived {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("RecommendationText")
        private String recommendationText;
		
		@SerializedName("RecommendationType")
        private String recommendationType;
		
		@SerializedName("Recommender")
        private String recommender;



		// <summary>
		//	Recommendation id
		// </summary>
		public String getId() {
			return id;
		}
		// <summary>
		//	Recommendation id
		// </summary>
		public void setId(String id) {
			this.id = id;
		}
		// <summary>
		//	Recommendation text
		// </summary>
		public String getRecommendationText() {
			return recommendationText;
		}
		// <summary>
		//	Recommendation text
		// </summary>
		public void setRecommendationText(String recommendationText) {
			this.recommendationText = recommendationText;
		}
		// <summary>
		//	Recommendation type
		// </summary>
		public String getRecommendationType() {
			return recommendationType;
		}
		// <summary>
		//	Recommendation type
		// </summary>
		public void setRecommendationType(String recommendationType) {
			this.recommendationType = recommendationType;
		}
		// <summary>
		//	Recommender
		// </summary>
		public String getRecommender() {
			return recommender;
		}
		// <summary>
		//	Recommender
		// </summary>
		public void setRecommender(String recommender) {
			this.recommender = recommender;
		}
    }