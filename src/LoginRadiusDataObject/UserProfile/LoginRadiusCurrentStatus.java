/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loginradiusdataobject.userprofile;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Administrator
 */
public class LoginRadiusCurrentStatus {

    @SerializedName("Id")
    public String id;
    @SerializedName("Text")
    public String text;
    @SerializedName("Source")
    public String source;
    @SerializedName("CreatedDate")
    public String createdDate;
}
