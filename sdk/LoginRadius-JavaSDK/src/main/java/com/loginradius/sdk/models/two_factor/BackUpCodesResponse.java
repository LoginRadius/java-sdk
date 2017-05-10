package com.loginradius.sdk.models.two_factor;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class BackUpCodesResponse {
	@SerializedName("BackUpCodes")
	@Expose
	private List<String> backUpCodes = null;

	public List<String> getBackUpCodes() {
	return backUpCodes;
	}

	public void setBackUpCodes(List<String> backUpCodes) {
	this.backUpCodes = backUpCodes;
	}

}
