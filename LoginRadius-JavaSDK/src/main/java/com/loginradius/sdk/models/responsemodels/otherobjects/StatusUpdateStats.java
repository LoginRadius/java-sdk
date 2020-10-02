/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete Status Update data
	 */
	public class StatusUpdateStats {
	
		
		@SerializedName("Comments")
        private int comments;
		
		@SerializedName("Likes")
        private int likes;
		
		@SerializedName("Shares")
        private int shares;



		/**
		 * Comments
		 */
		public int getComments() {
			return comments;
		}
		/**
		 * Comments
		 */
		public void setComments(int comments) {
			this.comments = comments;
		}
		/**
		 * Likes
		 */
		public int getLikes() {
			return likes;
		}
		/**
		 * Likes
		 */
		public void setLikes(int likes) {
			this.likes = likes;
		}
		/**
		 * share
		 */
		public int getShares() {
			return shares;
		}
		/**
		 * share
		 */
		public void setShares(int shares) {
			this.shares = shares;
		}
    }