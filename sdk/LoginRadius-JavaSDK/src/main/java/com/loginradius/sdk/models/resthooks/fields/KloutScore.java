package com.loginradius.sdk.models.resthooks.fields;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KloutScore {
	@SerializedName("KloutId")
	@Expose
	private String kloutId;
	@SerializedName("Score")
	@Expose
	private Double score;

	/**
	* 
	* @return
	* The kloutId
	*/
	public String getKloutId() {
	return kloutId;
	}

	/**
	* 
	* @param kloutId
	* The KloutId
	*/
	public void setKloutId(String kloutId) {
	this.kloutId = kloutId;
	}

	/**
	* 
	* @return
	* The score
	*/
	public Double getScore() {
	return score;
	}

	/**
	* 
	* @param score
	* The Score
	*/
	public void setScore(Double score) {
	this.score = score;
	}
}
