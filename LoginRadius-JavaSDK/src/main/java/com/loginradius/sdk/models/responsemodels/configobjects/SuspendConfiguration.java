
package com.loginradius.sdk.models.responsemodels.configobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuspendConfiguration {

	@SerializedName("EffectivePeriodInSeconds")
	@Expose
	private Integer effectivePeriodInSeconds;

	/**
	 * Suspended time in seconds
	 */
	public Integer getEffectivePeriodInSeconds() {
		return effectivePeriodInSeconds;
	}

	/**
	 * Suspended time in seconds
	 */
	public void setEffectivePeriodInSeconds(Integer effectivePeriodInSeconds) {
		this.effectivePeriodInSeconds = effectivePeriodInSeconds;
	}

}
