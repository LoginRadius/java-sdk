
package com.loginradius.sdk.models.configuration;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegistrationFormSchema {

    @SerializedName("Checked")
    @Expose
    private Boolean checked;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("rules")
    @Expose
    private String rules;
    @SerializedName("options")
    @Expose
    private List<Object> options = null;
    @SerializedName("permission")
    @Expose
    private String permission;
    @SerializedName("DataSource")
    @Expose
    private String dataSource;
    @SerializedName("Parent")
    @Expose
    private String parent;
    @SerializedName("ParentDataSource")
    @Expose
    private Object parentDataSource;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Object getParentDataSource() {
        return parentDataSource;
    }

    public void setParentDataSource(Object parentDataSource) {
        this.parentDataSource = parentDataSource;
    }

}
