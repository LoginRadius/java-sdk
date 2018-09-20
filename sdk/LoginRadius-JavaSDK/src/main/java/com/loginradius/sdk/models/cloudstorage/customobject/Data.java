
package com.loginradius.sdk.models.cloudstorage.customobject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("DateCreated")
    @Expose
    private String dateCreated;
    @SerializedName("DateModified")
    @Expose
    private String dateModified;
    @SerializedName("IsDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("Uid")
    @Expose
    private String uid;
    @SerializedName("CustomObject")
    @Expose
    private Object customObject;
    @SerializedName("_id")
    @Expose
    private Integer id;

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
