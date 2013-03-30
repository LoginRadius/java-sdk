package loginradiusdataobject.userprofile;

import com.google.gson.annotations.SerializedName;

public class LoginRadiusPosition {

    @SerializedName("Position")
    public String position;
    @SerializedName("Summary")
    public String summary;
    @SerializedName("StartDate")
    public String startDate;
    @SerializedName("EndDate")
    public String endDate;
    @SerializedName("IsCurrent")
    public String isCurrent;
    @SerializedName("Comapny")
    public LoginRadiusPositionCompany comapny;
    @SerializedName("Location")
    public String location;
}
