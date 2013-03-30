package loginradiusdataobject.postcomman;

import com.google.gson.annotations.SerializedName;

public class LoginRadiusPost {

    @SerializedName("ID")
    public String id;
    
    @SerializedName("Name")
    public String name;
    
    @SerializedName("Title")
    public String title;
    
    @SerializedName("StartTime")
    public String startTime;
    
    @SerializedName("UpdateTime")
    public String updateTime;
    
    @SerializedName("Message")
    public String message;
    
    @SerializedName("Place")
    public String place;
    
    @SerializedName("Picture")
    public String picture;
    
    @SerializedName("Likes")
    public int likes;
    
    @SerializedName("Share")
    public int share;
}
