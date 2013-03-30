package loginradiusdataobject.userprofile;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Date;

public class UltimateUserLoginRadiusUserProfile {

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
    @SerializedName("Website")
    public String website;
    @SerializedName("Email")
    public List<LoginRadiusEmail> emails;
    @SerializedName("Country")
    public LoginRadiusCountry country;
    @SerializedName("ThumbnailImageUrl")
    public String thumbnailImageUrl;
    @SerializedName("ImageUrl")
    public String imageUrl;
    @SerializedName("Favicon")
    public String favicon;
    @SerializedName("ProfileUrl")
    public String profileUrl;
    @SerializedName("HomeTown")
    public String homeTown;
    @SerializedName("State")
    public String state;
    @SerializedName("City")
    public String city;
    @SerializedName("Industry")
    public String industry;
    @SerializedName("About")
    public String about;
    @SerializedName("TimeZone")
    public String timeZone;
    @SerializedName("LocalLanguage")
    public String localLanguage;
    @SerializedName("Language")
    public String language;
    @SerializedName("Verified")
    public String verified;
    @SerializedName("UpdatedTime")
    public String updatedTime;
    @SerializedName("Positions")
    public List<LoginRadiusPosition> positions;
    @SerializedName("Educations")
    public List<LoginRadiusEducation> educations;
    @SerializedName("PhoneNumbers")
    public List<LoginRadiusPhoneNumber> phoneNumbers;
    @SerializedName("IMAccounts")
    public List<LoginradiusIMAccount> imAccounts;
    @SerializedName("Addresses")
    public List<LoginRadiusAddress> addresses;
    @SerializedName("MainAddress")
    public String mainAddress;
    @SerializedName("Created")
    public String created;
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
    @SerializedName("RelationshipStatus")
    public String relationshipStatus;
    @SerializedName("Quota")
    public String quota;
    @SerializedName("InterestedIn")
    public List<String> interestedIn;
    @SerializedName("Interests")
    public List<LoginradiusInterests> interests;
    @SerializedName("Religion")
    public String religion;
    @SerializedName("Political")
    public String political;
    @SerializedName("Sports")
    public List<LoginradiusSports> sports;
    @SerializedName("InspirationalPeople")
    public List<LoginradiusInspirationalPeople> inspirationalPeople;
    @SerializedName("HttpsImageUrl")
    public String httpsImageUrl;
    @SerializedName("FollowersCount")
    public int followersCount;
    @SerializedName("FriendsCount")
    public int friendsCount;
    @SerializedName("IsGeoEnabled")
    public String isGeoEnabled;
    @SerializedName("TotalStatusesCount")
    public int totalStatusesCount;
    @SerializedName("Associations")
    public String associations;
    @SerializedName("NumRecommenders")
    public int numRecommenders;
    @SerializedName("Honors")
    public String honors;
    @SerializedName("Skills")
    public List<LoginRadiusSkills> skills;
    @SerializedName("CurrentStatus")
    public List<LoginRadiusCurrentStatus> currentStatus;
    @SerializedName("Certifications")
    public List<LoginradiusCertifications> certifications;
    @SerializedName("Courses")
    public List<LoginradiusCourses> courses;
    @SerializedName("Volunteer")
    public List<LoginradiusVolunteer> volunteer;
    @SerializedName("RecommendationsReceived")
    public List<LoginradiusRecommendationsReceived> recommendationsReceived;
    @SerializedName("Languages")
    public List<LoginradiusLanguages> languages;
    @SerializedName("PublicRepository")
    public String publicRepository;
    @SerializedName("Hireable")
    public boolean hireable;
    @SerializedName("RepositoryUrl")
    public String repositoryUrl;
    @SerializedName("Age")
    public String age;
    @SerializedName("Patents")
    public List<LoginRadiusPatents> patents;
    @SerializedName("FavoriteThings")
    public List<LoginRadiusFavoriteThings> favoriteThings;
    @SerializedName("ProfessionalHeadline")
    public String professionalHeadline;
    @SerializedName("ProviderAccessCredential")
    public ProviderAccessCredential providerAccessCredential;
}
