package com.loginradius.sdk.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
/**
The MessageSend API is used to post messages to the user’s contacts. 
After using the Contact API, you can send messages to the retrieved contacts.
*/
public class MessageSendAPI extends LoginRadiusAPI {

	private String _to;
	private String _subject;
	private String _message;

	public String get_To() {
		return _to;
	}

	public void set_To(String _To) {
		this._to = _To;
	}

	public String get_Subject() {
		return _subject;
	}

	public void set_Subject(String _Subject) {
		this._subject = _Subject;
	}

	public String get_Message() {
		return _message;
	}

	public void set_Message(String _Message) {
		this._message = _Message;
	}
	/**
	 *getResponse	
	 * this function used to get send direct messages
	 *
	 * @param token Authentication token
	 *
	 
	 */
	@Override
	public String getResponse(String token) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);
		try 
		{
			params.put("to", URLEncoder.encode(_to, "UTF-8"));
			params.put("subject", URLEncoder.encode(_subject, "UTF-8"));
			params.put("message", URLEncoder.encode(_message, "UTF-8"));
		} 
		catch (UnsupportedEncodingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return executePost("/api/v2/message", params, null);
	}

}
