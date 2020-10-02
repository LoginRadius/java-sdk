/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition for GitHubPlan Property
	 */
	public class GitHubPlan {
	
		
		@SerializedName("Collaborators")
        private String collaborators;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("PrivateRepos")
        private String privateRepos;
		
		@SerializedName("Space")
        private String space;



		/**
		 * Github plan collaborators
		 */
		public String getCollaborators() {
			return collaborators;
		}
		/**
		 * Github plan collaborators
		 */
		public void setCollaborators(String collaborators) {
			this.collaborators = collaborators;
		}
		/**
		 * Github plan name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Github plan name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * Private repos of github
		 */
		public String getPrivateRepos() {
			return privateRepos;
		}
		/**
		 * Private repos of github
		 */
		public void setPrivateRepos(String privateRepos) {
			this.privateRepos = privateRepos;
		}
		/**
		 * Github plan space
		 */
		public String getSpace() {
			return space;
		}
		/**
		 * Github plan space
		 */
		public void setSpace(String space) {
			this.space = space;
		}
    }