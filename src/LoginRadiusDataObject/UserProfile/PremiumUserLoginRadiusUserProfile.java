package loginradiusdataobject.userprofile;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Date;

    public class PremiumUserLoginRadiusUserProfile 
    
    {
        @SerializedName("ID")
        public String id ;
        
        @SerializedName("Provider")
        public String provider ;
        
        @SerializedName("Prefix")
        public String prefix ;
        
        @SerializedName("FirstName")
        public String firstName ;
        
        @SerializedName("MiddleName")
        public String middleName ;
        
        @SerializedName("LastName")
        public String lastName ;
        
        @SerializedName("Suffix")
        public String suffix ;
        
        @SerializedName("FullName")
        public String fullName ;
        
        @SerializedName("NickName")
        public String nickName ;
        
        @SerializedName("ProfileName")
        public String profileName ;
        
        @SerializedName("BirthDate")
        public String birthDate ;
        
        @SerializedName("Gender")
        public String gender ;
        
        @SerializedName("Email")
        public List<LoginRadiusEmail> email ;
        
        @SerializedName("Country")
        public LoginRadiusCountry country ;
        
        @SerializedName("ThumbnailImageUrl")
        public String thumbnailImageUrl;
        
        @SerializedName("ImageUrl")
        public String imageUrl ;
        
        @SerializedName("Favicon")
        public String favicon ;
        
        @SerializedName("ProfileUrl")
        public String profileUrl ;
        
        @SerializedName("HomeTown")
        public String homeTown ;
        
        @SerializedName("State")
        public String state ;
        
        @SerializedName("City")
        public String city ;
        
        @SerializedName("Industry")
        public String industry ;
        
        @SerializedName("About")
        public String about ;
        
        @SerializedName("TimeZone")
        public String timeZone ;
        
        @SerializedName("LocalLanguage")
        public String localLanguage ;
        
        @SerializedName("Language")
        public String language;
        
        @SerializedName("Verified")
        public String verified ;
        
        @SerializedName("UpdatedTime")
        public String updatedTime ;
        
        @SerializedName("CreatedDate")
        public Date createdDate;
        
        @SerializedName("ModifiedDate")
        public Date modifiedDate;
        
        @SerializedName("LocalCity")
        public String localCity;
        
        @SerializedName("ProfileCity")
        public String profileCity;
        
        @SerializedName("LocalCountry")
        public String localCountry;
        
        @SerializedName("ProfileCountry")
        public String profileCountry;
       
    }

