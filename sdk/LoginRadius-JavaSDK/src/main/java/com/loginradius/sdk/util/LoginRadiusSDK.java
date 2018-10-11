package com.loginradius.sdk.util;

import com.loginradius.sdk.resource.Endpoint;


public class LoginRadiusSDK {
    private LoginRadiusSDK() {}
    private static final String LOGINRADIUS_API_ROOT = "https://api.loginradius.com";
    public static class Initialize {
        private static String apiKey,apiSecret;
        private static Boolean apiRequestSigning = false;
      

        public Initialize() {
        	Endpoint.LOGINRADIUS_API_ROOT=LOGINRADIUS_API_ROOT;
        }

        public void setApiKey(String apiKey) {
            Initialize.apiKey = apiKey;
        }

        public void setApiSecret(String apiSecret) {
            Initialize.apiSecret = apiSecret;
        }

        public void setRequestSigning(Boolean apiRequestSigning) {
            Initialize.apiRequestSigning = apiRequestSigning;
        }
        
        public void setCustomDomain(String domain) {
        	Endpoint.LOGINRADIUS_API_ROOT = domain;	
        }
    }

    public static String getApiKey() {
        return Initialize.apiKey;
    }

    public static String getApiSecret() {
        return Initialize.apiSecret;
    }

    public static Boolean getRequestSigning() {
        return Initialize.apiRequestSigning;
    }

    public static String getDomain() {
       return Endpoint.LOGINRADIUS_API_ROOT;
    }

   
}