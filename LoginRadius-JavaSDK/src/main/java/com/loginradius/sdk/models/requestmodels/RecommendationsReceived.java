/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for RecommendationsReceived
	 */
	public class RecommendationsReceived {
	
		
		@SerializedName("Id")
        private String id;
		
		@SerializedName("RecommendationText")
        private String recommendationText;
		
		@SerializedName("RecommendationType")
        private String recommendationType;
		
		@SerializedName("Recommender")
        private String recommender;



		/**
		 * Recommendation id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Recommendation id
		 */
		public void setId(String id) {
			this.id = id;
		}
		/**
		 * Recommendation text
		 */
		public String getRecommendationText() {
			return recommendationText;
		}
		/**
		 * Recommendation text
		 */
		public void setRecommendationText(String recommendationText) {
			this.recommendationText = recommendationText;
		}
		/**
		 * Recommendation type
		 */
		public String getRecommendationType() {
			return recommendationType;
		}
		/**
		 * Recommendation type
		 */
		public void setRecommendationType(String recommendationType) {
			this.recommendationType = recommendationType;
		}
		/**
		 * Recommender
		 */
		public String getRecommender() {
			return recommender;
		}
		/**
		 * Recommender
		 */
		public void setRecommender(String recommender) {
			this.recommender = recommender;
		}
    }