package loginradiusdataobject.eventcomman;

import com.google.gson.annotations.*;

public class LoginRadiusEvent {

    @SerializedName("ID")
    public String id;
    @SerializedName("Name")
    public String name;
    @SerializedName("StartTime")
    public String startTime;
    @SerializedName("RsvpStatus")
    public String rsvpStatus;
    @SerializedName("Location")
    public String location;
}
