package com.loginradius.sdk.util;

import java.util.Map;

import org.javalite.http.Get;
import org.javalite.http.Http;
import org.javalite.http.Post;

import com.loginradius.sdk.core.LoginRadiusEndpoint;

/** LoginRadiusRestRequest class for LoginRadius End point call
*
*/
public class LoginRadiusRestRequest {

	/**
	 *Get
	 * to handle get request
	 *
	 * 
	 * @param serviceUrl requesting api's end point
	 * @return get response from LoginRadius with service URL
	 * 
	 */
	public LoginRadiusRestResponse Get(String serviceUrl) {

		String url = LoginRadiusEndpoint.GetRequestUrl(serviceUrl);

		LoginRadiusRestResponse response = new LoginRadiusRestResponse();

		Get get = Http.get(url);

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
	public LoginRadiusRestResponse Get(String serviceUrl,
			Map<String, String> params) {

		LoginRadiusRestResponse response = new LoginRadiusRestResponse();

		String url = LoginRadiusEndpoint.GetRequestUrl(serviceUrl, params);

		Get get = Http.get(url);

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
	
	public LoginRadiusRestResponse Post(String serviceUrl,
			Map<String, String> getParams, Map<String, String> postParams) {

		LoginRadiusRestResponse response = new LoginRadiusRestResponse();

		String url = LoginRadiusEndpoint.GetRequestUrl(serviceUrl, getParams);
		
		String postContent ="" ;
		if(postParams !=null){
		 postContent = LoginRadiusEndpoint.createKeyValueString(postParams);
		}

		Post post = Http.post(url,postContent);

		response.setResponse(post.text());
		response.setStatusCode(post.responseCode());

		return response;
	}
}
