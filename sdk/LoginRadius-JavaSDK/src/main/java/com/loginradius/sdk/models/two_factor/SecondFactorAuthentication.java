package com.loginradius.sdk.models.two_factor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecondFactorAuthentication {

@SerializedName("SecondFactorAuthenticationToken")
@Expose
private String secondFactorAuthenticationToken;
@SerializedName("ExpireIn")
@Expose
private String expireIn;
@SerializedName("QRCode")
@Expose
private String qRCode;
@SerializedName("ManualEntryCode")
@Expose
private String manualEntryCode;
@SerializedName("IsGoogleAuthenticatorVerified")
@Expose
private Boolean isGoogleAuthenticatorVerified;
@SerializedName("IsOTPAuthenticatorVerified")
@Expose
private Boolean isOTPAuthenticatorVerified;
@SerializedName("OTPPhoneNo")
@Expose
private String oTPPhoneNo;
@SerializedName("OTPStatus")
@Expose
private OTPStatus oTPStatus;

public String getSecondFactorAuthenticationToken() {
return secondFactorAuthenticationToken;
}

public void setSecondFactorAuthenticationToken(String secondFactorAuthenticationToken) {
this.secondFactorAuthenticationToken = secondFactorAuthenticationToken;
}

public String getExpireIn() {
return expireIn;
}

public void setExpireIn(String expireIn) {
this.expireIn = expireIn;
}

public String getQRCode() {
return qRCode;
}

public void setQRCode(String qRCode) {
this.qRCode = qRCode;
}

public String getManualEntryCode() {
return manualEntryCode;
}

public void setManualEntryCode(String manualEntryCode) {
this.manualEntryCode = manualEntryCode;
}

public Boolean getIsGoogleAuthenticatorVerified() {
return isGoogleAuthenticatorVerified;
}

public void setIsGoogleAuthenticatorVerified(Boolean isGoogleAuthenticatorVerified) {
this.isGoogleAuthenticatorVerified = isGoogleAuthenticatorVerified;
}

public Boolean getIsOTPAuthenticatorVerified() {
return isOTPAuthenticatorVerified;
}

public void setIsOTPAuthenticatorVerified(Boolean isOTPAuthenticatorVerified) {
this.isOTPAuthenticatorVerified = isOTPAuthenticatorVerified;
}

public String getOTPPhoneNo() {
return oTPPhoneNo;
}

public void setOTPPhoneNo(String oTPPhoneNo) {
this.oTPPhoneNo = oTPPhoneNo;
}

public OTPStatus getOTPStatus() {
return oTPStatus;
}

public void setOTPStatus(OTPStatus oTPStatus) {
this.oTPStatus = oTPStatus;
}

}


