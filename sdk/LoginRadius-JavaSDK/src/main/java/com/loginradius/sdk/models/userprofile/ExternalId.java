package com.loginradius.sdk.models.userprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExternalId {
	@SerializedName("Source")
	@Expose
	private String source;
	@SerializedName("SourceId")
	@Expose
	private String sourceId;

	public String getSource() {
	return source;
	}

	public void setSource(String source) {
	this.source = source;
	}

	public String getSourceId() {
	return sourceId;
	}

	public void setSourceId(String sourceId) {
	this.sourceId = sourceId;
	}
}
