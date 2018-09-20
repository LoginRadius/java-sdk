
package com.loginradius.sdk.models.cloudstorage.identity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUserIdentityResponse {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("next")
    @Expose
    private String next;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
