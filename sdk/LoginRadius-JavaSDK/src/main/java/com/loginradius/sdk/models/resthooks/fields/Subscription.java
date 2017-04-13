package com.loginradius.sdk.models.resthooks.fields;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subscription {
	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("Space")
	@Expose
	private String space;
	@SerializedName("PrivateRepos")
	@Expose
	private String privateRepos;
	@SerializedName("Collaborators")
	@Expose
	private String collaborators;

	/**
	* 
	* @return
	* The name
	*/
	public String getName() {
	return name;
	}

	/**
	* 
	* @param name
	* The Name
	*/
	public void setName(String name) {
	this.name = name;
	}

	/**
	* 
	* @return
	* The space
	*/
	public String getSpace() {
	return space;
	}

	/**
	* 
	* @param space
	* The Space
	*/
	public void setSpace(String space) {
	this.space = space;
	}

	/**
	* 
	* @return
	* The privateRepos
	*/
	public String getPrivateRepos() {
	return privateRepos;
	}

	/**
	* 
	* @param privateRepos
	* The PrivateRepos
	*/
	public void setPrivateRepos(String privateRepos) {
	this.privateRepos = privateRepos;
	}

	/**
	* 
	* @return
	* The collaborators
	*/
	public String getCollaborators() {
	return collaborators;
	}

	/**
	* 
	* @param collaborators
	* The Collaborators
	*/
	public void setCollaborators(String collaborators) {
	this.collaborators = collaborators;
	}
}
