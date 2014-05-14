package com.loginradius.sdk.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 *The Status API is used to get the status messages from the user’s social account. 
 *The data will be normalized into LoginRadius' data format.
 * 
 * 
 */
public class StatusUpdateAPI extends LoginRadiusAPI {
	private String title;
	private String url;
	private String imageurl;
	private String caption;
	private String status;
	private String description;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}


	public String getCaption() {
		return caption;
	}


	public void setCaption(String caption) {
		this.caption = caption;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 *getResponse	
	 * this function used to update status
	 *
	 * @param token Authentication token
	 
	 
	 */

	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);
		try 
		{
			params.put("title", URLEncoder.encode(title, "UTF-8"));
			params.put("url", URLEncoder.encode(url, "UTF-8"));
			params.put("imageurl", URLEncoder.encode(imageurl, "UTF-8"));
			params.put("status", URLEncoder.encode(status, "UTF-8"));
			params.put("caption", URLEncoder.encode(caption, "UTF-8"));
			params.put("description", URLEncoder.encode(description, "UTF-8"));
			
		} 
		catch (UnsupportedEncodingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
       return executePost("/api/v2/status", params, null);
	}

}
