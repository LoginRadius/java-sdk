/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile.objects;
import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition for Complete GitHubPlan data
	// </summary>
	public class GitHubPlan {
	
		
		@SerializedName("Collaborators")
        private String collaborators;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("PrivateRepos")
        private String privateRepos;
		
		@SerializedName("Space")
        private String space;



		// <summary>
		//	Github plan collaborators
		// </summary>
		public String getCollaborators() {
			return collaborators;
		}
		// <summary>
		//	Github plan collaborators
		// </summary>
		public void setCollaborators(String collaborators) {
			this.collaborators = collaborators;
		}
		// <summary>
		//	Github plan name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Github plan name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	Private repos of github
		// </summary>
		public String getPrivateRepos() {
			return privateRepos;
		}
		// <summary>
		//	Private repos of github
		// </summary>
		public void setPrivateRepos(String privateRepos) {
			this.privateRepos = privateRepos;
		}
		// <summary>
		//	Github plan space
		// </summary>
		public String getSpace() {
			return space;
		}
		// <summary>
		//	Github plan space
		// </summary>
		public void setSpace(String space) {
			this.space = space;
		}
    }