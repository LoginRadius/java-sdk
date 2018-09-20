package com.loginradius.sdk.models.cloudstorage.insights;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InsightsResponse {
	@SerializedName("total")
	@Expose
	private Integer total;
	@SerializedName("aggregations")
	@Expose
	private Object aggregations;

	public Integer getTotal() {
	return total;
	}

	public void setTotal(Integer total) {
	this.total = total;
	}

	
}
