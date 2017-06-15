package com.loginradius.sdk.util;


/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright © 2017 LoginRadius Inc. All rights reserved.  
   
 */

import java.util.Map;

//import org.javalite.http.Put;

import com.loginradius.sdk.resource.Endpoint;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * LoginRadiusRestRequest class for LoginRadius End point call
 *
 */
public class RestRequest {

	/**
	 * Get to handle get request
	 *
	 * 
	 * @param serviceUrl
	 *            requesting api's end point
	 * @return get response from LoginRadius with service URL
	 * 
	 */


	public RestResponse get(String serviceUrl, Map<String, String> params) {

		RestResponse response = new RestResponse();

		String url = Endpoint.GetRequestUrl(serviceUrl, params);
		HttpResponse<String> jsonResponse;
		try {
			Unirest.setTimeouts(15000, 15000);
			jsonResponse = Unirest.get(url).asString();

			if (jsonResponse.getBody().contains("loginRadiusAppJsonLoaded(")) {
				String abc = jsonResponse.getBody().replace("loginRadiusAppJsonLoaded(", "");
				abc = abc.substring(0, abc.length() - 1);

				response.setResponse(abc);
				response.setStatusCode(jsonResponse.getStatus());
			} else {
				response.setResponse(jsonResponse.getBody());
				response.setStatusCode(jsonResponse.getStatus());

			}

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	/**
	 * post to handle post request
	 *
	 * 
	 * @param serviceUrl
	 *            requesting api's end point
	 * @param getParams
	 *            Request parameters for GET method
	 * @param postParams
	 *            Request parameters for POST method
	 * @return post response from LoginRadius with GET/POST parameters
	 * 
	 */

	public RestResponse post(String serviceUrl, Map<String, String> getParams, String payload) {

		RestResponse response = new RestResponse();

		String url = Endpoint.GetRequestUrl(serviceUrl, getParams);

		HttpResponse<JsonNode> jsonResponse;
		try {
			Unirest.setTimeouts(15000, 15000);
			jsonResponse = Unirest.post(url)

					.header("accept", "application/json").header("Content-Type", "application/json").body(payload)
					.asJson();

			response.setResponse(jsonResponse.getBody().getObject().toString(2));
			response.setStatusCode(jsonResponse.getStatus());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	public RestResponse put(String serviceUrl, Map<String, String> getParams, String payload) {

		RestResponse response = new RestResponse();

		String url = Endpoint.GetRequestUrl(serviceUrl, getParams);

		HttpResponse<JsonNode> jsonResponse;
		try {
			Unirest.setTimeouts(15000, 15000);
			jsonResponse = Unirest.put(url)
             .header("accept", "application/json").header("Content-Type", "application/json").body(payload)
			 .asJson();

			response.setResponse(jsonResponse.getBody().getObject().toString(2));
			response.setStatusCode(jsonResponse.getStatus());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	public RestResponse delete(String serviceUrl, Map<String, String> getParams, String payload) {

		RestResponse response = new RestResponse();

		String url = Endpoint.GetRequestUrl(serviceUrl, getParams);
		HttpResponse<JsonNode> jsonResponse;
		try {
			Unirest.setTimeouts(15000, 15000);
			jsonResponse = Unirest.delete(url).header("accept", "application/json")
					.header("Content-Type", "application/json").body(payload).asJson();

			response.setResponse(jsonResponse.getBody().getObject().toString(2));
			response.setStatusCode(jsonResponse.getStatus());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}
}
