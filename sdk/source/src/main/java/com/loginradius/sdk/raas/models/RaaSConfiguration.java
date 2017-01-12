package com.loginradius.sdk.raas.models;

public class RaaSConfiguration {
	private String appKey;
	private String appSecret;
	private String objectID;

	public String getAppKey() {
		return appKey;
	}

	public RaaSConfiguration(String appKey, String appSecret, String objectID) {
		super();
		this.appKey = appKey;
		this.appSecret = appSecret;
		this.objectID = objectID;
	}

	public RaaSConfiguration(String appKey, String appSecret) {
		super();
		this.appKey = appKey;
		this.appSecret = appSecret;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getObjectID() {
		return objectID;
	}

	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}

}
