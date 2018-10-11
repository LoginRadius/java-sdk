package com.loginradius.sdk.resource;

public class EndpointContent {
    private String path;
    private Boolean isToken;
    private String[] templateParams;
    private String apiKeyPhrase;
    private String apiSecretPhrase;

    public EndpointContent(String name, Boolean token, String... params) {
        path = name;
        isToken = token;
        templateParams = params;
    }

    public EndpointContent(String key, String secret, String name, Boolean token, String... params) {
        path = name;
        isToken = token;
        templateParams = params;
        apiKeyPhrase = key;
        apiSecretPhrase = secret;
    }

    public String getPath() {
        return path;
    }
    
    public Boolean getIsToken() {
        return isToken;
    }

    public String[] getTemplateParams() {
        return templateParams;
    }

    public String getApiKeyPhrase() {
        return apiKeyPhrase;
    }

    public String getApiSecretPhrase() {
        return apiSecretPhrase;
    }
}