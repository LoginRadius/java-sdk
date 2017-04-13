
package com.loginradius.sdk.models.socialinterface;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SocialInterface {

    @SerializedName("Providers")
    @Expose
    private List<Provider> providers = new ArrayList<Provider>();
    @SerializedName("IconUrl")
    @Expose
    private Object iconUrl;
    @SerializedName("RequestEndpoint")
    @Expose
    private String requestEndpoint;
    @SerializedName("SubDomain")
    @Expose
    private String subDomain;
    @SerializedName("IconSize")
    @Expose
    private String iconSize;
    @SerializedName("Interface")
    @Expose
    private String _interface;
    @SerializedName("WhiteLabel")
    @Expose
    private Boolean whiteLabel;
    @SerializedName("IsSlide")
    @Expose
    private Boolean isSlide;
    @SerializedName("IsHttps")
    @Expose
    private Boolean isHttps;
    @SerializedName("IsPaid")
    @Expose
    private Boolean isPaid;
    @SerializedName("IsIframe")
    @Expose
    private Boolean isIframe;
    @SerializedName("Height")
    @Expose
    private Integer height;
    @SerializedName("Width")
    @Expose
    private Integer width;
    @SerializedName("IsAccessToken")
    @Expose
    private Boolean isAccessToken;
    @SerializedName("cdndomain")
    @Expose
    private Object cdndomain;
    @SerializedName("domain")
    @Expose
    private Object domain;

    /**
     * 
     * @return
     *     The providers
     */
    public List<Provider> getProviders() {
        return providers;
    }

    /**
     * 
     * @param providers
     *     The Providers
     */
    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    /**
     * 
     * @return
     *     The iconUrl
     */
    public Object getIconUrl() {
        return iconUrl;
    }

    /**
     * 
     * @param iconUrl
     *     The IconUrl
     */
    public void setIconUrl(Object iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * 
     * @return
     *     The requestEndpoint
     */
    public String getRequestEndpoint() {
        return requestEndpoint;
    }

    /**
     * 
     * @param requestEndpoint
     *     The RequestEndpoint
     */
    public void setRequestEndpoint(String requestEndpoint) {
        this.requestEndpoint = requestEndpoint;
    }

    /**
     * 
     * @return
     *     The subDomain
     */
    public String getSubDomain() {
        return subDomain;
    }

    /**
     * 
     * @param subDomain
     *     The SubDomain
     */
    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

    /**
     * 
     * @return
     *     The iconSize
     */
    public String getIconSize() {
        return iconSize;
    }

    /**
     * 
     * @param iconSize
     *     The IconSize
     */
    public void setIconSize(String iconSize) {
        this.iconSize = iconSize;
    }

    /**
     * 
     * @return
     *     The _interface
     */
    public String getInterface() {
        return _interface;
    }

    /**
     * 
     * @param _interface
     *     The Interface
     */
    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    /**
     * 
     * @return
     *     The whiteLabel
     */
    public Boolean getWhiteLabel() {
        return whiteLabel;
    }

    /**
     * 
     * @param whiteLabel
     *     The WhiteLabel
     */
    public void setWhiteLabel(Boolean whiteLabel) {
        this.whiteLabel = whiteLabel;
    }

    /**
     * 
     * @return
     *     The isSlide
     */
    public Boolean getIsSlide() {
        return isSlide;
    }

    /**
     * 
     * @param isSlide
     *     The IsSlide
     */
    public void setIsSlide(Boolean isSlide) {
        this.isSlide = isSlide;
    }

    /**
     * 
     * @return
     *     The isHttps
     */
    public Boolean getIsHttps() {
        return isHttps;
    }

    /**
     * 
     * @param isHttps
     *     The IsHttps
     */
    public void setIsHttps(Boolean isHttps) {
        this.isHttps = isHttps;
    }

    /**
     * 
     * @return
     *     The isPaid
     */
    public Boolean getIsPaid() {
        return isPaid;
    }

    /**
     * 
     * @param isPaid
     *     The IsPaid
     */
    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    /**
     * 
     * @return
     *     The isIframe
     */
    public Boolean getIsIframe() {
        return isIframe;
    }

    /**
     * 
     * @param isIframe
     *     The IsIframe
     */
    public void setIsIframe(Boolean isIframe) {
        this.isIframe = isIframe;
    }

    /**
     * 
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The Height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The Width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The isAccessToken
     */
    public Boolean getIsAccessToken() {
        return isAccessToken;
    }

    /**
     * 
     * @param isAccessToken
     *     The IsAccessToken
     */
    public void setIsAccessToken(Boolean isAccessToken) {
        this.isAccessToken = isAccessToken;
    }

    /**
     * 
     * @return
     *     The cdndomain
     */
    public Object getCdndomain() {
        return cdndomain;
    }

    /**
     * 
     * @param cdndomain
     *     The cdndomain
     */
    public void setCdndomain(Object cdndomain) {
        this.cdndomain = cdndomain;
    }

    /**
     * 
     * @return
     *     The domain
     */
    public Object getDomain() {
        return domain;
    }

    /**
     * 
     * @param domain
     *     The domain
     */
    public void setDomain(Object domain) {
        this.domain = domain;
    }

}
