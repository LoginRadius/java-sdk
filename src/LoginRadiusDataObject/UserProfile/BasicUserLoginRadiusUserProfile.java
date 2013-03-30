package loginradiusdataobject.userprofile;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

public class BasicUserLoginRadiusUserProfile {

    @SerializedName("ID")
    public String id;
    @SerializedName("Provider")
    public String provider;
    @SerializedName("Prefix")
    public String prefix;
    @SerializedName("FirstName")
    public String firstName;
    @SerializedName("MiddleName")
    public String middleName;
    @SerializedName("LastName")
    public String lastName;
    @SerializedName("Suffix")
    public String suffix;
    @SerializedName("FullName")
    public String fullName;
    @SerializedName("NickName")
    public String nickName;
    @SerializedName("ProfileName")
    public String profileName;
    @SerializedName("BirthDate")
    public String birthDate;
    @SerializedName("Gender")
    public String gender;
    @SerializedName("ImageUrl")
    public String imageUrl;
    @SerializedName("ThumbnailImageUrl")
    public String thumbnailImageUrl;
    @SerializedName("Email")
    public List<LoginRadiusEmail> emails;
    @SerializedName("Country")
    public LoginRadiusCountry country;
    @SerializedName("CreatedDate")
    public Date createdDate;
    @SerializedName("ModifiedDate")
    public Date modifiedDate;
    @SerializedName("LocalCountry")
    public String localCountry;
    @SerializedName("ProfileCountry")
    public String profileCountry;
}
