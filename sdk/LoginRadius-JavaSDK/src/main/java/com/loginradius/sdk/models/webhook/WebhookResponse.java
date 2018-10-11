package com.loginradius.sdk.models.webhook;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WebhookResponse {
	@SerializedName("data")
	@Expose
	private List<DataSource> data = null;
	@SerializedName("Count")
	@Expose
	private Integer count;

	public List<DataSource> getData() {
	return data;
	}

	public void setData(List<DataSource> data) {
	this.data = data;
	}

	public Integer getCount() {
	return count;
	}

	public void setCount(Integer count) {
	this.count = count;
	}
}
