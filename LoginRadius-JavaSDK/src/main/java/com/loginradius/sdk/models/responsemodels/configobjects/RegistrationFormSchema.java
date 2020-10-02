
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

	/**
	 * Checked
	 */
	public Boolean getChecked() {
		return checked;
	}

	/**
	 * Checked
	 */
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	/**
	 * Type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * Display
	 */
	public void setDisplay(String display) {
		this.display = display;
	}

	/**
	 * Rules
	 */
	public String getRules() {
		return rules;
	}

	/**
	 * Rules
	 */
	public void setRules(String rules) {
		this.rules = rules;
	}

	/**
	 * Options
	 */
	public Object getOptions() {
		return options;
	}

	/**
	 * Options
	 */
	public void setOptions(Object options) {
		this.options = options;
	}

	/**
	 * User's permissions
	 */
	public String getPermission() {
		return permission;
	}

	/**
	 * User's permissions
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * Data Source
	 */
	public Object getDataSource() {
		return dataSource;
	}

	/**
	 * Data Source
	 */
	public void setDataSource(Object dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Parent data
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * Parent data
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

	/**
	 * Partent data source
	 */
	public Object getParentDataSource() {
		return parentDataSource;
	}

	/**
	 * Parent data source
	 */
	public void setParentDataSource(Object parentDataSource) {
		this.parentDataSource = parentDataSource;
	}

}
