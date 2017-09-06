package com.loginradius.sdk.models.activesession;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActiveSessionData {

	@SerializedName("AccessToken")
	@Expose
	private String accessToken;
	@SerializedName("Browser")
	@Expose
	private String browser;
	@SerializedName("Device")
	@Expose
	private String device;
	@SerializedName("Os")
	@Expose
	private String os;
	@SerializedName("DeviceType")
	@Expose
	private String deviceType;
	@SerializedName("City")
	@Expose
	private String city;
	@SerializedName("Country")
	@Expose
	private String country;
	@SerializedName("Ip")
	@Expose
	private String ip;
	@SerializedName("LoginDate")
	@Expose
	private String loginDate;

	public String getAccessToken() {
	return accessToken;
	}

	public void setAccessToken(String accessToken) {
	this.accessToken = accessToken;
	}

	public String getBrowser() {
	return browser;
	}

	public void setBrowser(String browser) {
	this.browser = browser;
	}

	public String getDevice() {
	return device;
	}

	public void setDevice(String device) {
	this.device = device;
	}

	public String getOs() {
	return os;
	}

	public void setOs(String os) {
	this.os = os;
	}

	public String getDeviceType() {
	return deviceType;
	}

	public void setDeviceType(String deviceType) {
	this.deviceType = deviceType;
	}

	public String getCity() {
	return city;
	}

	public void setCity(String city) {
	this.city = city;
	}

	public String getCountry() {
	return country;
	}

	public void setCountry(String country) {
	this.country = country;
	}

	public String getIp() {
	return ip;
	}

	public void setIp(String ip) {
	this.ip = ip;
	}

	public String getLoginDate() {
	return loginDate;
	}

	public void setLoginDate(String loginDate) {
	this.loginDate = loginDate;
	}

}
