package com.loginradius.sdk.raas.models;

import com.google.gson.annotations.SerializedName;

public class RaaSCustomObjectStats {

	@SerializedName("TotalUsedMemory")
	private String TotalUsedMemory;
	@SerializedName("RemainingMemory")
	private String RemainingMemory;
	@SerializedName("TotalRecords")
	private String TotalRecords;
	public String getTotalUsedMemory() {
		return TotalUsedMemory;
	}
	public void setTotalUsedMemory(String totalUsedMemory) {
		TotalUsedMemory = totalUsedMemory;
	}
	public String getRemainingMemory() {
		return RemainingMemory;
	}
	public void setRemainingMemory(String remainingMemory) {
		RemainingMemory = remainingMemory;
	}
	public String getTotalRecords() {
		return TotalRecords;
	}
	public void setTotalRecords(String totalRecords) {
		TotalRecords = totalRecords;
	}
	
}
