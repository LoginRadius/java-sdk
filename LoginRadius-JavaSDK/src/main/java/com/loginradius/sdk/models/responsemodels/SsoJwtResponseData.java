/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels;

import com.google.gson.annotations.SerializedName;

// <summary>
//	Response containing Definition of Jwt Response Data
// </summary>
public class SsoJwtResponseData {

	@SerializedName("signature")
	private String signature;
	
	public String getSignature() {
	return signature;
	}
	
	public void setSignature(String signature) {
	this.signature = signature;
	}

}