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
public class LoginradiusCertifications {

    @SerializedName("Id")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("Authority")
    public String authority;
    @SerializedName("Number")
    public String number;
    @SerializedName("StartDate")
    public String startDate;
    @SerializedName("EndDate")
    public String endDate;
}
