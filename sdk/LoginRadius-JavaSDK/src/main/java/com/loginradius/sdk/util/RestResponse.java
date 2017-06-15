package com.loginradius.sdk.util;


/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright © 2017 LoginRadius Inc. All rights reserved.  
   
 */

public class RestResponse {

	private String Response;
	private int StatusCode;

	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

}
