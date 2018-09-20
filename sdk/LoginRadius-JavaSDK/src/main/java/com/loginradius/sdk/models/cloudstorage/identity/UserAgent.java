
package com.loginradius.sdk.models.cloudstorage.identity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAgent {

    @SerializedName("patch")
    @Expose
    private String patch;
    @SerializedName("major")
    @Expose
    private String major;
    @SerializedName("minor")
    @Expose
    private String minor;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("os_name")
    @Expose
    private String osName;
    @SerializedName("device")
    @Expose
    private String device;

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

}
