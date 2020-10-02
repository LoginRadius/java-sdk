/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition for Complete Klout Profile data
	 */
	public class KloutProfile {
	
		
		@SerializedName("KloutId")
        private String kloutId;
		
		@SerializedName("Score")
        private Double score;



		/**
		 * Id of klout
		 */
		public String getKloutId() {
			return kloutId;
		}
		/**
		 * Id of klout
		 */
		public void setKloutId(String kloutId) {
			this.kloutId = kloutId;
		}
		/**
		 * Object, string represents KloutId and double represents Score
		 */
		public Double getScore() {
			return score;
		}
		/**
		 * Object, string represents KloutId and double represents Score
		 */
		public void setScore(Double score) {
			this.score = score;
		}
    }