package com.loginradius.sdk.util;

public class LoginRadiusSDK {
	private LoginRadiusSDK() {}

    public static class Initialize{
        private static String apiKey,apiSecret;
        private static Boolean apiRequestSigning = false;
        

        public void setApiKey(String apiKey) {
            Initialize.apiKey = apiKey;
        }

        public void setApiSecret(String apiSecret) {
            Initialize.apiSecret = apiSecret;
        }
        
        public void setRequestSigning(Boolean apiRequestSigning) {
            Initialize.apiRequestSigning = apiRequestSigning;
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
}
