
package com.loginradius.sdk.models.responsemodels.configobjects;

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
	private Object options;
	@SerializedName("permission")
	@Expose
	private String permission;
	@SerializedName("DataSource")
	@Expose
	private Object dataSource;
	@SerializedName("Parent")
	@Expose
	private String parent;
	@SerializedName("ParentDataSource")
	@Expose
	private Object parentDataSource;

	/// <summary>
	/// Checked
	/// </summary>
	public Boolean getChecked() {
		return checked;
	}

	/// <summary>
	/// Checked
	/// </summary>
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	/// <summary>
	/// Type
	/// </summary>
	public String getType() {
		return type;
	}

	/// <summary>
	/// Type
	/// </summary>
	public void setType(String type) {
		this.type = type;
	}

	/// <summary>
	/// Name
	/// </summary>
	public String getName() {
		return name;
	}

	/// <summary>
	/// Name
	/// </summary>
	public void setName(String name) {
		this.name = name;
	}

	/// <summary>
	/// Display
	/// </summary>
	public String getDisplay() {
		return display;
	}

	/// <summary>
	/// Display
	/// </summary>
	public void setDisplay(String display) {
		this.display = display;
	}

	/// <summary>
	/// Rules
	/// </summary>
	public String getRules() {
		return rules;
	}

	/// <summary>
	/// Rules
	/// </summary>
	public void setRules(String rules) {
		this.rules = rules;
	}

	/// <summary>
	/// Options
	/// </summary>
	public Object getOptions() {
		return options;
	}

	/// <summary>
	/// Options
	/// </summary>
	public void setOptions(Object options) {
		this.options = options;
	}

	/// <summary>
	/// User's permissions
	/// </summary>
	public String getPermission() {
		return permission;
	}

	/// <summary>
	/// User's permissions
	/// </summary>
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/// <summary>
	/// Data Source
	/// </summary>
	public Object getDataSource() {
		return dataSource;
	}

	/// <summary>
	/// Data Source
	/// </summary>
	public void setDataSource(Object dataSource) {
		this.dataSource = dataSource;
	}

	/// <summary>
	/// Parent data
	/// </summary>
	public String getParent() {
		return parent;
	}

	/// <summary>
	/// Parent data
	/// </summary>
	public void setParent(String parent) {
		this.parent = parent;
	}

	/// <summary>
	/// Partent data source
	/// </summary>
	public Object getParentDataSource() {
		return parentDataSource;
	}

	/// <summary>
	/// Parent data source
	/// </summary>
	public void setParentDataSource(Object parentDataSource) {
		this.parentDataSource = parentDataSource;
	}

}
