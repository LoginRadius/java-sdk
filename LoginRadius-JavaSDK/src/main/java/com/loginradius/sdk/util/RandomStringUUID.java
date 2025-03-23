package com.loginradius.sdk.util;

/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright 2025 LoginRadius Inc. All rights reserved.
   
 */

import java.util.UUID;

public class RandomStringUUID {
	public static String getGuuid() {
		//
		// Creating a random UUID (Universally unique identifier).
		//
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();

		return randomUUIDString;
	}
}
