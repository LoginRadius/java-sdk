package com.loginradius.sdk.util;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

/* 
 * 
 * Created by LoginRadius Development Team on 16/11/2017
   Copyright � 2017 LoginRadius Inc. All rights reserved.  
   
 */



import java.util.Map;


import com.loginradius.sdk.resource.Endpoint;



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
		
		try {
			   HttpURLConnection.setFollowRedirects(false);
			   HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			   con.setRequestMethod("GET");
               con.setConnectTimeout(15000); //set timeout to 15 seconds
               con.setReadTimeout(150000);
               con.setDoOutput(true);
               
               BufferedReader br = new BufferedReader(new InputStreamReader(con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
			   String output;
			   while ((output = br.readLine()) != null) {
				     response.setResponse(output);
	                 response.setStatusCode(con.getResponseCode());
		   }
          }catch (MalformedURLException e) {
	         e.printStackTrace();
         } catch (SocketTimeoutException e) {
		   e.printStackTrace();
		} catch (IOException e) {
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
        String sott="";
		if(getParams.containsKey("sott")) {
        	sott=getParams.get("sott");
        	getParams.remove("sott");
        }
		RestResponse response = new RestResponse();
		String url = Endpoint.GetRequestUrl(serviceUrl, getParams);
		try {
			   HttpURLConnection.setFollowRedirects(false);
			   HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			   con.setRequestMethod("POST");
               con.setConnectTimeout(15000); //set timeout to 15 seconds
			   con.setReadTimeout(150000);
			   con.setRequestProperty( "Content-Type", "application/json"); 
			   con.setRequestProperty("charset", "utf-8");
			
			   if(sott!="") {
				con.setRequestProperty("X-LoginRadius-Sott", sott); 
			   }
			  
			   con.setDoOutput(true);
			   
			   OutputStream os = con.getOutputStream();
			   OutputStreamWriter body = new OutputStreamWriter(os, "UTF-8");
			   body.write(payload);
			   body.flush();
			   body.close();
			   
			   BufferedReader br = new BufferedReader(new InputStreamReader(con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
			   String output;
			   while ((output = br.readLine()) != null) {
				     response.setResponse(output);
	                 response.setStatusCode(con.getResponseCode());
			     }  
				 }catch (MalformedURLException e) {
		         e.printStackTrace();
	          } catch (SocketTimeoutException e) {
			   e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			  e.printStackTrace();
		}
		return response;
	}

	
	
	/**
	 * Put to handle put request
	 *
	 * 
	 * @param serviceUrl
	 *            requesting api's end point
	 * @return put response from LoginRadius with service URL
	 * 
	 */
	
	
	public RestResponse put(String serviceUrl, Map<String, String> getParams, String payload) {

		RestResponse response = new RestResponse();
		String url = Endpoint.GetRequestUrl(serviceUrl, getParams);
		try {
			   HttpURLConnection.setFollowRedirects(false);
			   HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			   con.setRequestMethod("PUT");
               con.setConnectTimeout(15000); //set timeout to 15 seconds
			   con.setReadTimeout(150000);
			   con.setRequestProperty( "Content-Type", "application/json"); 
			   con.setRequestProperty("charset", "utf-8");
			   con.setDoOutput(true);
			   
			   OutputStream os = con.getOutputStream();
			   OutputStreamWriter body = new OutputStreamWriter(os, "UTF-8");
			   body.write(payload);
			   body.flush();
			   body.close();
			   
			   
			   BufferedReader br = new BufferedReader(new InputStreamReader(con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
			   String output;
			   while ((output = br.readLine()) != null) {
				     response.setResponse(output);
	                 response.setStatusCode(con.getResponseCode());
				}
           
			  }catch (MalformedURLException e) {
		         e.printStackTrace();
	          } catch (SocketTimeoutException e) {
			   e.printStackTrace();
			} catch (IOException e) {
			  e.printStackTrace();
		}
		return response;
	}
	
	
	/**
	 * Delete to handle delete request
	 *
	 * 
	 * @param serviceUrl
	 *            requesting api's end point
	 * @return delete response from LoginRadius with service URL
	 * 
	 */

	public RestResponse delete(String serviceUrl, Map<String, String> getParams, String payload) {

		RestResponse response = new RestResponse();
		String url = Endpoint.GetRequestUrl(serviceUrl, getParams);
		
		try {
			   HttpURLConnection.setFollowRedirects(false);
			   HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			   con.setRequestMethod("DELETE");
               con.setConnectTimeout(15000); //set timeout to 15 seconds
			   con.setReadTimeout(150000);
			   con.setRequestProperty( "Content-Type", "application/json"); 
			   con.setRequestProperty("charset", "utf-8");
			   con.setDoOutput(true);
			   
			   OutputStream os = con.getOutputStream();
			   OutputStreamWriter body = new OutputStreamWriter(os, "UTF-8");
			   body.write(payload);
			   body.flush();
			   body.close();
			   
			   
			   BufferedReader br = new BufferedReader(new InputStreamReader(con.getResponseCode() / 100 == 2 ? con.getInputStream() : con.getErrorStream()));
			   String output;
			   while ((output = br.readLine()) != null) {
				     response.setResponse(output);
	                 response.setStatusCode(con.getResponseCode());
				}
        
			  }catch (MalformedURLException e) {
		         e.printStackTrace();
	          } catch (SocketTimeoutException e) {
			   e.printStackTrace();
			} catch (IOException e) {
			  e.printStackTrace();
		}
		return response;
	}
}
