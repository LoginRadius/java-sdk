package com.loginradius.sdk.models.activesession;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActiveSessionResponse {
	@SerializedName("data")
	@Expose
	private List<ActiveSessionData> data = null;
	@SerializedName("nextcursor")
	@Expose
	private Integer nextcursor;

	public List<ActiveSessionData> getData() {
	return data;
	}

	public void setData(List<ActiveSessionData> data) {
	this.data = data;
	}

	public Integer getNextcursor() {
	return nextcursor;
	}

	public void setNextcursor(Integer nextcursor) {
	this.nextcursor = nextcursor;
	}

	}

