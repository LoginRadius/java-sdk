package com.loginradius.sdk.raas.models;

public class RaaSClientConfig {

	private static RaaSConfiguration _configuration;

	public RaaSClientConfig(RaaSConfiguration configuration) {
		_configuration = configuration;
	}

	public static RaaSConfiguration getConfiguration() {
		return _configuration;
	}

}
