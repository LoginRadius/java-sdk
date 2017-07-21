package com.loginradius.sdk.models.phone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhoneDataResponse {
	
	
@SerializedName("IsPosted")
@Expose
private Boolean isPosted;

@SerializedName("Data")
@Expose
private PhoneForgotPasswordData data;


/**
*
* @return
* The isPosted
*/
public Boolean getIsPosted() {
   return isPosted;
}

/**
*
* @param isPosted
* The isPosted
*/
public void setIsPosted(Boolean isPosted) {
   this.isPosted = isPosted;
}

public PhoneForgotPasswordData getData() {
return data;
}

public void setData(PhoneForgotPasswordData data) {
this.data = data;
}
}
