
package com.loginradius.sdk.models.socialinterface;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Provider {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Endpoint")
    @Expose
    private String endpoint;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * 
     * @param endpoint
     *     The Endpoint
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

}
