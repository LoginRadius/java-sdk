/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete Status Update data
	// </summary>
	public class StatusUpdateStats {
	
		
		@SerializedName("Comments")
        private int comments;
		
		@SerializedName("Likes")
        private int likes;
		
		@SerializedName("Shares")
        private int shares;



		// <summary>
		//	Comments
		// </summary>
		public int getComments() {
			return comments;
		}
		// <summary>
		//	Comments
		// </summary>
		public void setComments(int comments) {
			this.comments = comments;
		}
		// <summary>
		//	Likes
		// </summary>
		public int getLikes() {
			return likes;
		}
		// <summary>
		//	Likes
		// </summary>
		public void setLikes(int likes) {
			this.likes = likes;
		}
		// <summary>
		//	share
		// </summary>
		public int getShares() {
			return shares;
		}
		// <summary>
		//	share
		// </summary>
		public void setShares(int shares) {
			this.shares = shares;
		}
    }