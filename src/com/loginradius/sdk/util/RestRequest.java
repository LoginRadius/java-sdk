package com.loginradius.sdk.util;

import java.util.Map;

import org.javalite.http.Get;
import org.javalite.http.Http;
import org.javalite.http.Post;

import com.loginradius.sdk.social.core.LoginRadiusEndpoint;

/** LoginRadiusRestRequest class for LoginRadius End point call
*
*/
public class RestRequest {

	/**
	 *Get
	 * to handle get request
	 *
	 * 
	 * @param serviceUrl requesting api's end point
	 * @return get response from LoginRadius with service URL
	 * 
	 */
	public RestResponse get(String serviceUrl) {

		String url = LoginRadiusEndpoint.getRequestUrl(serviceUrl);

		RestResponse response = new RestResponse();

		Get get = Http.get(url,15000,15000);

		response.setResponse(get.text());
		response.setStatusCode(get.responseCode());

		return response;
	}
	/**
	 *Get
	 * to handle get request
	 *
	 * 
	 * @param serviceUrl requesting api's end point
	 * 
	 * @param params request parameter
	 * @return Get response from LoginRadius with GET parameters 
	 */
	public RestResponse get(String serviceUrl,
			Map<String, String> params) {

		RestResponse response = new RestResponse();

		String url = LoginRadiusEndpoint.getRequestUrl(serviceUrl, params);
		
		Get get = Http.get(url,15000,15000);

		response.setResponse(get.text());
		response.setStatusCode(get.responseCode());

		return response;
	}

	/**
	 *post
	 * to handle post request
	 *
	 * 
	 * @param serviceUrl requesting api's end point
	 * @param getParams Request parameters for GET method
	 * @param postParams Request parameters for POST method
	 * @return post response from LoginRadius with GET/POST parameters
	 */
	
	public RestResponse post(String serviceUrl,
			Map<String, String> getParams, Map<String, String> postParams) {

		RestResponse response = new RestResponse();

		String url = LoginRadiusEndpoint.getRequestUrl(serviceUrl, getParams);
		
	
		String postContent ="" ;
		if(postParams !=null){
		 postContent = LoginRadiusEndpoint.createKeyValueString(postParams);
		}
		
		Post post = Http.post(url,postContent.getBytes(),15000,15000);

		response.setResponse(post.text());

		response.setStatusCode(post.responseCode());
		return response;
	}
	
	
	public RestResponse post(String serviceUrl,
			Map<String, String> getParams, String postJsonParams) {

		RestResponse response = new RestResponse();

		String url = LoginRadiusEndpoint.getRequestUrl(serviceUrl, getParams);
		
		String postContent ="" ;
		if(postJsonParams !=null){
		 postContent = postJsonParams;
		 } else {
			 postContent ="";
		 }
		
		Post post = Http.post(url,postContent.getBytes(),15000,15000);

		response.setResponse(post.text());
		response.setStatusCode(post.responseCode());

		return response;
	}
	
}
