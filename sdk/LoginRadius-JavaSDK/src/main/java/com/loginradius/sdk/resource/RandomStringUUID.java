package com.loginradius.sdk.resource;

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
