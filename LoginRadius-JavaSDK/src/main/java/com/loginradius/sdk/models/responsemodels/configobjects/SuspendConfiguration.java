
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuspendConfiguration {

	@SerializedName("EffectivePeriodInSeconds")
	@Expose
	private Integer effectivePeriodInSeconds;

	/// <summary>
	/// Suspended time in seconds
	/// </summary>
	public Integer getEffectivePeriodInSeconds() {
		return effectivePeriodInSeconds;
	}

	/// <summary>
	/// Suspended time in seconds
	/// </summary>
	public void setEffectivePeriodInSeconds(Integer effectivePeriodInSeconds) {
		this.effectivePeriodInSeconds = effectivePeriodInSeconds;
	}

}
