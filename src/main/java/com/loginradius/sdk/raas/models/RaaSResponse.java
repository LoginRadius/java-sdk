package com.loginradius.sdk.raas.models;

import com.loginradius.sdk.social.models.LoginRadiusPostResponse;

public class RaaSResponse extends LoginRadiusPostResponse  {


	  public String description;
	  public int errorCode;
	  public boolean isProviderError;
	  public String message;
	  public boolean providerErrorResponse;
}
