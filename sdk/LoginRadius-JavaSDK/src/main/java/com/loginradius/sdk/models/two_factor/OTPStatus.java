package com.loginradius.sdk.models.two_factor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class OTPStatus {
	@SerializedName("AccountSid")
	@Expose
	private String accountSid;
	@SerializedName("Sid")
	@Expose
	private String sid;

	public String getAccountSid() {
	return accountSid;
	}

	public void setAccountSid(String accountSid) {
	this.accountSid = accountSid;
	}

	public String getSid() {
	return sid;
	}

	public void setSid(String sid) {
	this.sid = sid;
	}
}
