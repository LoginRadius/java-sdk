/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete Klout Profile data
	// </summary>
	public class KloutProfile {
	
		
		@SerializedName("KloutId")
        private String kloutId;
		
		@SerializedName("Score")
        private Double score;



		// <summary>
		//	Id of klout
		// </summary>
		public String getKloutId() {
			return kloutId;
		}
		// <summary>
		//	Id of klout
		// </summary>
		public void setKloutId(String kloutId) {
			this.kloutId = kloutId;
		}
		// <summary>
		//	Object, string represents KloutId and double represents Score
		// </summary>
		public Double getScore() {
			return score;
		}
		// <summary>
		//	Object, string represents KloutId and double represents Score
		// </summary>
		public void setScore(Double score) {
			this.score = score;
		}
    }