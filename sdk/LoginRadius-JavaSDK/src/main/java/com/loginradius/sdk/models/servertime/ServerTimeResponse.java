package com.loginradius.sdk.models.servertime;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ServerTimeResponse {

@SerializedName("ServerLocation")
@Expose
private String serverLocation;
@SerializedName("ServerName")
@Expose
private String serverName;
@SerializedName("CurrentTime")
@Expose
private Object currentTime;
@SerializedName("Sott")
@Expose
private SottTime sottTime;

public String getServerLocation() {
return serverLocation;
}

public void setServerLocation(String serverLocation) {
this.serverLocation = serverLocation;
}

public String getServerName() {
return serverName;
}

public void setServerName(String serverName) {
this.serverName = serverName;
}

public Object getCurrentTime() {
return currentTime;
}

public void setCurrentTime(Object currentTime) {
this.currentTime = currentTime;
}

public SottTime getSottTime() {
return sottTime;
}

public void setSott(SottTime sottTime) {
this.sottTime = sottTime;
}

}