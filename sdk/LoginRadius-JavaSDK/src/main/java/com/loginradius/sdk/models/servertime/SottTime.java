package com.loginradius.sdk.models.servertime;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class SottTime {

@SerializedName("StartTime")
@Expose
private String startTime;
@SerializedName("EndTime")
@Expose
private String endTime;
@SerializedName("TimeDifference")
@Expose
private String difference;

public String getStartTime() {
return startTime;
}

public void setStartTime(String startTime) {
this.startTime = startTime;
}

public String getEndTime() {
return endTime;
}

public void setEndTime(String endTime) {
this.endTime = endTime;
}

public String getDifference() {
return difference;
}

public void setDifference(String difference) {
this.difference = difference;
}

}
