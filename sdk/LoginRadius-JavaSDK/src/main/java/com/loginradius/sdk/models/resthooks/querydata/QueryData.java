package com.loginradius.sdk.models.resthooks.querydata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryData {
	@SerializedName("Os")
	@Expose
	private Data os;

	@SerializedName("FriendsCount")
	@Expose
	private Data friendscount;
	
	
	@SerializedName("Browser")
	@Expose
	private Data browser;
	
	@SerializedName("Device")
	@Expose
	private Data device;
	
	@SerializedName("Country")
	@Expose
	private Data country;
	
	@SerializedName("City")
	@Expose
	private Data city;
	
	
	@SerializedName("Provider")
	@Expose
	private Data provider;
	
	@SerializedName("EmailType")
	@Expose
	private Data emailType;
	
	
	
	/**
	* 
	* @return
	* The os
	*/
	public Data getOs() {
	return os;
	}
	
	
	public Data getFriendsCount() {
		return friendscount;
		}
	
	public Data getBrowser() {
		return browser;
		}
	
	public Data getDevice() {
		return device;
		}
	
	
	public Data getCountry() {
		return country;
		}
	
	public Data getCity() {
		return city;
		}
	
	
	public Data getProvider() {
		return provider;
		}
	
	
	public Data getEmailType() {
		return emailType;
		}
	
	/**
	* 
	* @param os
	* The Os
	*/
	public void setOs(Data os) {
	this.os = os;
	}
	

}
