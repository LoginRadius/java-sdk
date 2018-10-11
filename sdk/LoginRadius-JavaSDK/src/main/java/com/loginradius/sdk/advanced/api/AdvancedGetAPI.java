package com.loginradius.sdk.advanced.api;


/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright 2017 LoginRadius Inc. All rights reserved.
   
 */

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.resource.EndpointContent;
import com.loginradius.sdk.resource.LoginRadiusException;

public class AdvancedGetAPI extends LRAdvancedAPI {
	private String method = "";
	private Map<String, String> map = new HashMap<String, String>();

	public AdvancedGetAPI(String method, Map<String, String> map) {
		this.method = method;
		this.map = map;
	}

	@Override
	public String getResponse(String token) {
		EndpointContent api = getApi(method);
		if (api == null) {
			throw new LoginRadiusException("Invalid Argument used. Please refer documentation and use the correct argument");
		}
		Map<String, String> params = getParams(api, map, token);
		String finalPath = getFinalPath(api.getPath(), map);

		return executeGet(finalPath, params);
	}
}