package com.loginradius.sdk.models.traditionalinterface;

/**
 * Created by loginradius on 8/5/2016.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegisteration {


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

                /**
                 *
                 * @return
                 * The checked
                 */
                public Boolean getChecked() {
                        return checked;
                }

                /**
                 *
                 * @param checked
                 * The Checked
                 */
                public void setChecked(Boolean checked) {
                        this.checked = checked;
                }

                /**
                 *
                 * @return
                 * The type
                 */
                public String getType() {
                        return type;
                }

                /**
                 *
                 * @param type
                 * The type
                 */
                public void setType(String type) {
                        this.type = type;
                }

                /**
                 *
                 * @return
                 * The name
                 */
                public String getName() {
                        return name;
                }

                /**
                 *
                 * @param name
                 * The name
                 */
                public void setName(String name) {
                        this.name = name;
                }

                /**
                 *
                 * @return
                 * The display
                 */
                public String getDisplay() {
                        return display;
                }

                /**
                 *
                 * @param display
                 * The display
                 */
                public void setDisplay(String display) {
                        this.display = display;
                }

                /**
                 *
                 * @return
                 * The rules
                 */
                public String getRules() {
                        return rules;
                }

                /**
                 *
                 * @param rules
                 * The rules
                 */
                public void setRules(String rules) {
                        this.rules = rules;
                }

                /**
                 *
                 * @return
                 * The options
                 */
                public Object getOptions() {
                        return options;
                }

                /**
                 *
                 * @param options
                 * The options
                 */
                public void setOptions(Object options) {
                        this.options = options;
                }

                /**
                 *
                 * @return
                 * The permission
                 */
                public String getPermission() {
                        return permission;
                }

                /**
                 *
                 * @param permission
                 * The permission
                 */
                public void setPermission(String permission) {
                        this.permission = permission;
                }

        }