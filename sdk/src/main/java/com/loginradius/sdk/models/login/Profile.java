package com.loginradius.sdk.models.login;

/**
 * Created by loginradius on 7/30/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Profile {

    @SerializedName("Identities")
    @Expose
    private Object identities;
    @SerializedName("PasswordExpirationDate")
    @Expose
    private Object passwordExpirationDate;
    @SerializedName("EmailVerified")
    @Expose
    private Boolean emailVerified;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("Uid")
    @Expose
    private String uid;
    @SerializedName("CustomFields")
    @Expose
    private Object customFields;
    @SerializedName("IsEmailSubscribed")
    @Expose
    private Boolean isEmailSubscribed;
    @SerializedName("UserName")
    @Expose
    private Object userName;
    @SerializedName("NoOfLogins")
    @Expose
    private Integer noOfLogins;
    @SerializedName("PreviousUids")
    @Expose
    private Object previousUids;
    @SerializedName("PhoneId")
    @Expose
    private String phoneId;
    @SerializedName("PhoneIdVerified")
    @Expose
    private Boolean phoneIdVerified;
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("Provider")
    @Expose
    private String provider;
    @SerializedName("Prefix")
    @Expose
    private Object prefix;
    @SerializedName("FirstName")
    @Expose
    private Object firstName;
    @SerializedName("MiddleName")
    @Expose
    private Object middleName;
    @SerializedName("LastName")
    @Expose
    private Object lastName;
    @SerializedName("Suffix")
    @Expose
    private Object suffix;
    @SerializedName("FullName")
    @Expose
    private Object fullName;
    @SerializedName("NickName")
    @Expose
    private Object nickName;
    @SerializedName("ProfileName")
    @Expose
    private Object profileName;
    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("Website")
    @Expose
    private Object website;
    @SerializedName("Email")
    @Expose
    private List<Email> email = new ArrayList<Email>();
    @SerializedName("Country")
    @Expose
    private Object country;
    @SerializedName("ThumbnailImageUrl")
    @Expose
    private Object thumbnailImageUrl;
    @SerializedName("ImageUrl")
    @Expose
    private Object imageUrl;
    @SerializedName("Favicon")
    @Expose
    private Object favicon;
    @SerializedName("ProfileUrl")
    @Expose
    private Object profileUrl;
    @SerializedName("HomeTown")
    @Expose
    private Object homeTown;
    @SerializedName("State")
    @Expose
    private Object state;
    @SerializedName("City")
    @Expose
    private Object city;
    @SerializedName("Industry")
    @Expose
    private Object industry;
    @SerializedName("About")
    @Expose
    private Object about;
    @SerializedName("TimeZone")
    @Expose
    private Object timeZone;
    @SerializedName("LocalLanguage")
    @Expose
    private Object localLanguage;
    @SerializedName("CoverPhoto")
    @Expose
    private Object coverPhoto;
    @SerializedName("TagLine")
    @Expose
    private Object tagLine;
    @SerializedName("Language")
    @Expose
    private Object language;
    @SerializedName("Verified")
    @Expose
    private Object verified;
    @SerializedName("UpdatedTime")
    @Expose
    private Object updatedTime;
    @SerializedName("Positions")
    @Expose
    private Object positions;
    @SerializedName("Educations")
    @Expose
    private Object educations;
    @SerializedName("PhoneNumbers")
    @Expose
    private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
    @SerializedName("IMAccounts")
    @Expose
    private Object iMAccounts;
    @SerializedName("Addresses")
    @Expose
    private Object addresses;
    @SerializedName("MainAddress")
    @Expose
    private Object mainAddress;
    @SerializedName("Created")
    @Expose
    private Object created;
    @SerializedName("LocalCity")
    @Expose
    private Object localCity;
    @SerializedName("ProfileCity")
    @Expose
    private Object profileCity;
    @SerializedName("LocalCountry")
    @Expose
    private Object localCountry;
    @SerializedName("ProfileCountry")
    @Expose
    private Object profileCountry;
    @SerializedName("FirstLogin")
    @Expose
    private Boolean firstLogin;
    @SerializedName("IsProtected")
    @Expose
    private Boolean isProtected;
    @SerializedName("RelationshipStatus")
    @Expose
    private Object relationshipStatus;
    @SerializedName("Quota")
    @Expose
    private Object quota;
    @SerializedName("Quote")
    @Expose
    private Object quote;
    @SerializedName("InterestedIn")
    @Expose
    private Object interestedIn;
    @SerializedName("Interests")
    @Expose
    private Object interests;
    @SerializedName("Religion")
    @Expose
    private Object religion;
    @SerializedName("Political")
    @Expose
    private Object political;
    @SerializedName("Sports")
    @Expose
    private Object sports;
    @SerializedName("InspirationalPeople")
    @Expose
    private Object inspirationalPeople;
    @SerializedName("HttpsImageUrl")
    @Expose
    private Object httpsImageUrl;
    @SerializedName("FollowersCount")
    @Expose
    private Integer followersCount;
    @SerializedName("FriendsCount")
    @Expose
    private Integer friendsCount;
    @SerializedName("IsGeoEnabled")
    @Expose
    private Object isGeoEnabled;
    @SerializedName("TotalStatusesCount")
    @Expose
    private Integer totalStatusesCount;
    @SerializedName("Associations")
    @Expose
    private Object associations;
    @SerializedName("NumRecommenders")
    @Expose
    private Integer numRecommenders;
    @SerializedName("Honors")
    @Expose
    private Object honors;
    @SerializedName("Awards")
    @Expose
    private Object awards;
    @SerializedName("Skills")
    @Expose
    private Object skills;
    @SerializedName("CurrentStatus")
    @Expose
    private Object currentStatus;
    @SerializedName("Certifications")
    @Expose
    private Object certifications;
    @SerializedName("Courses")
    @Expose
    private Object courses;
    @SerializedName("Volunteer")
    @Expose
    private Object volunteer;
    @SerializedName("RecommendationsReceived")
    @Expose
    private Object recommendationsReceived;
    @SerializedName("Languages")
    @Expose
    private Object languages;
    @SerializedName("Projects")
    @Expose
    private Object projects;
    @SerializedName("Games")
    @Expose
    private Object games;
    @SerializedName("Family")
    @Expose
    private Object family;
    @SerializedName("TeleVisionShow")
    @Expose
    private Object teleVisionShow;
    @SerializedName("MutualFriends")
    @Expose
    private Object mutualFriends;
    @SerializedName("Movies")
    @Expose
    private Object movies;
    @SerializedName("Books")
    @Expose
    private Object books;
    @SerializedName("AgeRange")
    @Expose
    private Object ageRange;
    @SerializedName("PublicRepository")
    @Expose
    private Object publicRepository;
    @SerializedName("Hireable")
    @Expose
    private Boolean hireable;
    @SerializedName("RepositoryUrl")
    @Expose
    private Object repositoryUrl;
    @SerializedName("Age")
    @Expose
    private Object age;
    @SerializedName("Patents")
    @Expose
    private Object patents;
    @SerializedName("FavoriteThings")
    @Expose
    private Object favoriteThings;
    @SerializedName("ProfessionalHeadline")
    @Expose
    private Object professionalHeadline;
    @SerializedName("ProviderAccessCredential")
    @Expose
    private Object providerAccessCredential;
    @SerializedName("RelatedProfileViews")
    @Expose
    private Object relatedProfileViews;
    @SerializedName("KloutScore")
    @Expose
    private Object kloutScore;
    @SerializedName("LRUserID")
    @Expose
    private Object lRUserID;
    @SerializedName("PlacesLived")
    @Expose
    private Object placesLived;
    @SerializedName("Publications")
    @Expose
    private Object publications;
    @SerializedName("JobBookmarks")
    @Expose
    private Object jobBookmarks;
    @SerializedName("Suggestions")
    @Expose
    private Object suggestions;
    @SerializedName("Badges")
    @Expose
    private Object badges;
    @SerializedName("MemberUrlResources")
    @Expose
    private Object memberUrlResources;
    @SerializedName("TotalPrivateRepository")
    @Expose
    private Integer totalPrivateRepository;
    @SerializedName("Currency")
    @Expose
    private Object currency;
    @SerializedName("StarredUrl")
    @Expose
    private Object starredUrl;
    @SerializedName("GistsUrl")
    @Expose
    private Object gistsUrl;
    @SerializedName("PublicGists")
    @Expose
    private Integer publicGists;
    @SerializedName("PrivateGists")
    @Expose
    private Integer privateGists;
    @SerializedName("Subscription")
    @Expose
    private Object subscription;
    @SerializedName("Company")
    @Expose
    private Object company;
    @SerializedName("GravatarImageUrl")
    @Expose
    private Object gravatarImageUrl;
    @SerializedName("ProfileImageUrls")
    @Expose
    private Object profileImageUrls;
    @SerializedName("WebProfiles")
    @Expose
    private Object webProfiles;
    @SerializedName("PinsCount")
    @Expose
    private Integer pinsCount;
    @SerializedName("BoardsCount")
    @Expose
    private Integer boardsCount;
    @SerializedName("LikesCount")
    @Expose
    private Integer likesCount;
    
    @SerializedName("SignupDate")
    @Expose
    private String signupDate;
    @SerializedName("LastLoginDate")
    @Expose
    private String lastLoginDate;

    /**
     *
     * @return
     * The identities
     */
    public Object getIdentities() {
        return identities;
    }

    /**
     *
     * @param identities
     * The Identities
     */
    public void setIdentities(Object identities) {
        this.identities = identities;
    }

    /**
     *
     * @return
     * The passwordExpirationDate
     */
    public Object getPasswordExpirationDate() {
        return passwordExpirationDate;
    }

    /**
     *
     * @param passwordExpirationDate
     * The PasswordExpirationDate
     */
    public void setPasswordExpirationDate(Object passwordExpirationDate) {
        this.passwordExpirationDate = passwordExpirationDate;
    }

    /**
     *
     * @return
     * The emailVerified
     */
    public Boolean getEmailVerified() {
        return emailVerified;
    }

    /**
     *
     * @param emailVerified
     * The EmailVerified
     */
    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    /**
     *
     * @return
     * The isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     *
     * @param isActive
     * The IsActive
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     *
     * @return
     * The isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     *
     * @param isDeleted
     * The IsDeleted
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     *
     * @return
     * The uid
     */
    public String getUid() {
        return uid;
    }

    /**
     *
     * @param uid
     * The Uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     *
     * @return
     * The customFields
     */
    public Object getCustomFields() {
        return customFields;
    }

    /**
     *
     * @param customFields
     * The CustomFields
     */
    public void setCustomFields(Object customFields) {
        this.customFields = customFields;
    }

    /**
     *
     * @return
     * The isEmailSubscribed
     */
    public Boolean getIsEmailSubscribed() {
        return isEmailSubscribed;
    }

    /**
     *
     * @param isEmailSubscribed
     * The IsEmailSubscribed
     */
    public void setIsEmailSubscribed(Boolean isEmailSubscribed) {
        this.isEmailSubscribed = isEmailSubscribed;
    }

    /**
     *
     * @return
     * The userName
     */
    public Object getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     * The UserName
     */
    public void setUserName(Object userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     * The noOfLogins
     */
    public Integer getNoOfLogins() {
        return noOfLogins;
    }

    /**
     *
     * @param noOfLogins
     * The NoOfLogins
     */
    public void setNoOfLogins(Integer noOfLogins) {
        this.noOfLogins = noOfLogins;
    }

    /**
     *
     * @return
     * The previousUids
     */
    public Object getPreviousUids() {
        return previousUids;
    }

    /**
     *
     * @param previousUids
     * The PreviousUids
     */
    public void setPreviousUids(Object previousUids) {
        this.previousUids = previousUids;
    }

    /**
     *
     * @return
     * The phoneId
     */
    public String getPhoneId() {
        return phoneId;
    }

    /**
     *
     * @param phoneId
     * The PhoneId
     */
    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

    /**
     *
     * @return
     * The phoneIdVerified
     */
    public Boolean getPhoneIdVerified() {
        return phoneIdVerified;
    }

    /**
     *
     * @param phoneIdVerified
     * The PhoneIdVerified
     */
    public void setPhoneIdVerified(Boolean phoneIdVerified) {
        this.phoneIdVerified = phoneIdVerified;
    }

    /**
     *
     * @return
     * The iD
     */
    public String getID() {
        return iD;
    }

    /**
     *
     * @param iD
     * The ID
     */
    public void setID(String iD) {
        this.iD = iD;
    }

    /**
     *
     * @return
     * The provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     *
     * @param provider
     * The Provider
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     *
     * @return
     * The prefix
     */
    public Object getPrefix() {
        return prefix;
    }

    /**
     *
     * @param prefix
     * The Prefix
     */
    public void setPrefix(Object prefix) {
        this.prefix = prefix;
    }

    /**
     *
     * @return
     * The firstName
     */
    public Object getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     * The FirstName
     */
    public void setFirstName(Object firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     * The middleName
     */
    public Object getMiddleName() {
        return middleName;
    }

    /**
     *
     * @param middleName
     * The MiddleName
     */
    public void setMiddleName(Object middleName) {
        this.middleName = middleName;
    }

    /**
     *
     * @return
     * The lastName
     */
    public Object getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     * The LastName
     */
    public void setLastName(Object lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     * The suffix
     */
    public Object getSuffix() {
        return suffix;
    }

    /**
     *
     * @param suffix
     * The Suffix
     */
    public void setSuffix(Object suffix) {
        this.suffix = suffix;
    }

    /**
     *
     * @return
     * The fullName
     */
    public Object getFullName() {
        return fullName;
    }

    /**
     *
     * @param fullName
     * The FullName
     */
    public void setFullName(Object fullName) {
        this.fullName = fullName;
    }

    /**
     *
     * @return
     * The nickName
     */
    public Object getNickName() {
        return nickName;
    }

    /**
     *
     * @param nickName
     * The NickName
     */
    public void setNickName(Object nickName) {
        this.nickName = nickName;
    }

    /**
     *
     * @return
     * The profileName
     */
    public Object getProfileName() {
        return profileName;
    }

    /**
     *
     * @param profileName
     * The ProfileName
     */
    public void setProfileName(Object profileName) {
        this.profileName = profileName;
    }

    /**
     *
     * @return
     * The birthDate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param birthDate
     * The BirthDate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @return
     * The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     * The Gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     * The website
     */
    public Object getWebsite() {
        return website;
    }

    /**
     *
     * @param website
     * The Website
     */
    public void setWebsite(Object website) {
        this.website = website;
    }

    /**
     *
     * @return
     * The email
     */
    public List<Email> getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The Email
     */
    public void setEmail(List<Email> email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The country
     */
    public Object getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The Country
     */
    public void setCountry(Object country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The thumbnailImageUrl
     */
    public Object getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    /**
     *
     * @param thumbnailImageUrl
     * The ThumbnailImageUrl
     */
    public void setThumbnailImageUrl(Object thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    /**
     *
     * @return
     * The imageUrl
     */
    public Object getImageUrl() {
        return imageUrl;
    }

    /**
     *
     * @param imageUrl
     * The ImageUrl
     */
    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     *
     * @return
     * The favicon
     */
    public Object getFavicon() {
        return favicon;
    }

    /**
     *
     * @param favicon
     * The Favicon
     */
    public void setFavicon(Object favicon) {
        this.favicon = favicon;
    }

    /**
     *
     * @return
     * The profileUrl
     */
    public Object getProfileUrl() {
        return profileUrl;
    }

    /**
     *
     * @param profileUrl
     * The ProfileUrl
     */
    public void setProfileUrl(Object profileUrl) {
        this.profileUrl = profileUrl;
    }

    /**
     *
     * @return
     * The homeTown
     */
    public Object getHomeTown() {
        return homeTown;
    }

    /**
     *
     * @param homeTown
     * The HomeTown
     */
    public void setHomeTown(Object homeTown) {
        this.homeTown = homeTown;
    }

    /**
     *
     * @return
     * The state
     */
    public Object getState() {
        return state;
    }

    /**
     *
     * @param state
     * The State
     */
    public void setState(Object state) {
        this.state = state;
    }

    /**
     *
     * @return
     * The city
     */
    public Object getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The City
     */
    public void setCity(Object city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The industry
     */
    public Object getIndustry() {
        return industry;
    }

    /**
     *
     * @param industry
     * The Industry
     */
    public void setIndustry(Object industry) {
        this.industry = industry;
    }

    /**
     *
     * @return
     * The about
     */
    public Object getAbout() {
        return about;
    }

    /**
     *
     * @param about
     * The About
     */
    public void setAbout(Object about) {
        this.about = about;
    }

    /**
     *
     * @return
     * The timeZone
     */
    public Object getTimeZone() {
        return timeZone;
    }

    /**
     *
     * @param timeZone
     * The TimeZone
     */
    public void setTimeZone(Object timeZone) {
        this.timeZone = timeZone;
    }

    /**
     *
     * @return
     * The localLanguage
     */
    public Object getLocalLanguage() {
        return localLanguage;
    }

    /**
     *
     * @param localLanguage
     * The LocalLanguage
     */
    public void setLocalLanguage(Object localLanguage) {
        this.localLanguage = localLanguage;
    }

    /**
     *
     * @return
     * The coverPhoto
     */
    public Object getCoverPhoto() {
        return coverPhoto;
    }

    /**
     *
     * @param coverPhoto
     * The CoverPhoto
     */
    public void setCoverPhoto(Object coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    /**
     *
     * @return
     * The tagLine
     */
    public Object getTagLine() {
        return tagLine;
    }

    /**
     *
     * @param tagLine
     * The TagLine
     */
    public void setTagLine(Object tagLine) {
        this.tagLine = tagLine;
    }

    /**
     *
     * @return
     * The language
     */
    public Object getLanguage() {
        return language;
    }

    /**
     *
     * @param language
     * The Language
     */
    public void setLanguage(Object language) {
        this.language = language;
    }

    /**
     *
     * @return
     * The verified
     */
    public Object getVerified() {
        return verified;
    }

    /**
     *
     * @param verified
     * The Verified
     */
    public void setVerified(Object verified) {
        this.verified = verified;
    }

    /**
     *
     * @return
     * The updatedTime
     */
    public Object getUpdatedTime() {
        return updatedTime;
    }

    /**
     *
     * @param updatedTime
     * The UpdatedTime
     */
    public void setUpdatedTime(Object updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     *
     * @return
     * The positions
     */
    public Object getPositions() {
        return positions;
    }

    /**
     *
     * @param positions
     * The Positions
     */
    public void setPositions(Object positions) {
        this.positions = positions;
    }

    /**
     *
     * @return
     * The educations
     */
    public Object getEducations() {
        return educations;
    }

    /**
     *
     * @param educations
     * The Educations
     */
    public void setEducations(Object educations) {
        this.educations = educations;
    }

    /**
     *
     * @return
     * The phoneNumbers
     */
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    /**
     *
     * @param phoneNumbers
     * The PhoneNumbers
     */
    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    /**
     *
     * @return
     * The iMAccounts
     */
    public Object getIMAccounts() {
        return iMAccounts;
    }

    /**
     *
     * @param iMAccounts
     * The IMAccounts
     */
    public void setIMAccounts(Object iMAccounts) {
        this.iMAccounts = iMAccounts;
    }

    /**
     *
     * @return
     * The addresses
     */
    public Object getAddresses() {
        return addresses;
    }

    /**
     *
     * @param addresses
     * The Addresses
     */
    public void setAddresses(Object addresses) {
        this.addresses = addresses;
    }

    /**
     *
     * @return
     * The mainAddress
     */
    public Object getMainAddress() {
        return mainAddress;
    }

    /**
     *
     * @param mainAddress
     * The MainAddress
     */
    public void setMainAddress(Object mainAddress) {
        this.mainAddress = mainAddress;
    }

    /**
     *
     * @return
     * The created
     */
    public Object getCreated() {
        return created;
    }

    /**
     *
     * @param created
     * The Created
     */
    public void setCreated(Object created) {
        this.created = created;
    }

    /**
     *
     * @return
     * The localCity
     */
    public Object getLocalCity() {
        return localCity;
    }

    /**
     *
     * @param localCity
     * The LocalCity
     */
    public void setLocalCity(Object localCity) {
        this.localCity = localCity;
    }

    /**
     *
     * @return
     * The profileCity
     */
    public Object getProfileCity() {
        return profileCity;
    }

    /**
     *
     * @param profileCity
     * The ProfileCity
     */
    public void setProfileCity(Object profileCity) {
        this.profileCity = profileCity;
    }

    /**
     *
     * @return
     * The localCountry
     */
    public Object getLocalCountry() {
        return localCountry;
    }

    /**
     *
     * @param localCountry
     * The LocalCountry
     */
    public void setLocalCountry(Object localCountry) {
        this.localCountry = localCountry;
    }

    /**
     *
     * @return
     * The profileCountry
     */
    public Object getProfileCountry() {
        return profileCountry;
    }

    /**
     *
     * @param profileCountry
     * The ProfileCountry
     */
    public void setProfileCountry(Object profileCountry) {
        this.profileCountry = profileCountry;
    }

    /**
     *
     * @return
     * The firstLogin
     */
    public Boolean getFirstLogin() {
        return firstLogin;
    }

    /**
     *
     * @param firstLogin
     * The FirstLogin
     */
    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    /**
     *
     * @return
     * The isProtected
     */
    public Boolean getIsProtected() {
        return isProtected;
    }

    /**
     *
     * @param isProtected
     * The IsProtected
     */
    public void setIsProtected(Boolean isProtected) {
        this.isProtected = isProtected;
    }

    /**
     *
     * @return
     * The relationshipStatus
     */
    public Object getRelationshipStatus() {
        return relationshipStatus;
    }

    /**
     *
     * @param relationshipStatus
     * The RelationshipStatus
     */
    public void setRelationshipStatus(Object relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    /**
     *
     * @return
     * The quota
     */
    public Object getQuota() {
        return quota;
    }

    /**
     *
     * @param quota
     * The Quota
     */
    public void setQuota(Object quota) {
        this.quota = quota;
    }

    /**
     *
     * @return
     * The quote
     */
    public Object getQuote() {
        return quote;
    }

    /**
     *
     * @param quote
     * The Quote
     */
    public void setQuote(Object quote) {
        this.quote = quote;
    }

    /**
     *
     * @return
     * The interestedIn
     */
    public Object getInterestedIn() {
        return interestedIn;
    }

    /**
     *
     * @param interestedIn
     * The InterestedIn
     */
    public void setInterestedIn(Object interestedIn) {
        this.interestedIn = interestedIn;
    }

    /**
     *
     * @return
     * The interests
     */
    public Object getInterests() {
        return interests;
    }

    /**
     *
     * @param interests
     * The Interests
     */
    public void setInterests(Object interests) {
        this.interests = interests;
    }

    /**
     *
     * @return
     * The religion
     */
    public Object getReligion() {
        return religion;
    }

    /**
     *
     * @param religion
     * The Religion
     */
    public void setReligion(Object religion) {
        this.religion = religion;
    }

    /**
     *
     * @return
     * The political
     */
    public Object getPolitical() {
        return political;
    }

    /**
     *
     * @param political
     * The Political
     */
    public void setPolitical(Object political) {
        this.political = political;
    }

    /**
     *
     * @return
     * The sports
     */
    public Object getSports() {
        return sports;
    }

    /**
     *
     * @param sports
     * The Sports
     */
    public void setSports(Object sports) {
        this.sports = sports;
    }

    /**
     *
     * @return
     * The inspirationalPeople
     */
    public Object getInspirationalPeople() {
        return inspirationalPeople;
    }

    /**
     *
     * @param inspirationalPeople
     * The InspirationalPeople
     */
    public void setInspirationalPeople(Object inspirationalPeople) {
        this.inspirationalPeople = inspirationalPeople;
    }

    /**
     *
     * @return
     * The httpsImageUrl
     */
    public Object getHttpsImageUrl() {
        return httpsImageUrl;
    }

    /**
     *
     * @param httpsImageUrl
     * The HttpsImageUrl
     */
    public void setHttpsImageUrl(Object httpsImageUrl) {
        this.httpsImageUrl = httpsImageUrl;
    }

    /**
     *
     * @return
     * The followersCount
     */
    public Integer getFollowersCount() {
        return followersCount;
    }

    /**
     *
     * @param followersCount
     * The FollowersCount
     */
    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    /**
     *
     * @return
     * The friendsCount
     */
    public Integer getFriendsCount() {
        return friendsCount;
    }

    /**
     *
     * @param friendsCount
     * The FriendsCount
     */
    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    /**
     *
     * @return
     * The isGeoEnabled
     */
    public Object getIsGeoEnabled() {
        return isGeoEnabled;
    }

    /**
     *
     * @param isGeoEnabled
     * The IsGeoEnabled
     */
    public void setIsGeoEnabled(Object isGeoEnabled) {
        this.isGeoEnabled = isGeoEnabled;
    }

    /**
     *
     * @return
     * The totalStatusesCount
     */
    public Integer getTotalStatusesCount() {
        return totalStatusesCount;
    }

    /**
     *
     * @param totalStatusesCount
     * The TotalStatusesCount
     */
    public void setTotalStatusesCount(Integer totalStatusesCount) {
        this.totalStatusesCount = totalStatusesCount;
    }

    /**
     *
     * @return
     * The associations
     */
    public Object getAssociations() {
        return associations;
    }

    /**
     *
     * @param associations
     * The Associations
     */
    public void setAssociations(Object associations) {
        this.associations = associations;
    }

    /**
     *
     * @return
     * The numRecommenders
     */
    public Integer getNumRecommenders() {
        return numRecommenders;
    }

    /**
     *
     * @param numRecommenders
     * The NumRecommenders
     */
    public void setNumRecommenders(Integer numRecommenders) {
        this.numRecommenders = numRecommenders;
    }

    /**
     *
     * @return
     * The honors
     */
    public Object getHonors() {
        return honors;
    }

    /**
     *
     * @param honors
     * The Honors
     */
    public void setHonors(Object honors) {
        this.honors = honors;
    }

    /**
     *
     * @return
     * The awards
     */
    public Object getAwards() {
        return awards;
    }

    /**
     *
     * @param awards
     * The Awards
     */
    public void setAwards(Object awards) {
        this.awards = awards;
    }

    /**
     *
     * @return
     * The skills
     */
    public Object getSkills() {
        return skills;
    }

    /**
     *
     * @param skills
     * The Skills
     */
    public void setSkills(Object skills) {
        this.skills = skills;
    }

    /**
     *
     * @return
     * The currentStatus
     */
    public Object getCurrentStatus() {
        return currentStatus;
    }

    /**
     *
     * @param currentStatus
     * The CurrentStatus
     */
    public void setCurrentStatus(Object currentStatus) {
        this.currentStatus = currentStatus;
    }

    /**
     *
     * @return
     * The certifications
     */
    public Object getCertifications() {
        return certifications;
    }

    /**
     *
     * @param certifications
     * The Certifications
     */
    public void setCertifications(Object certifications) {
        this.certifications = certifications;
    }

    /**
     *
     * @return
     * The courses
     */
    public Object getCourses() {
        return courses;
    }

    /**
     *
     * @param courses
     * The Courses
     */
    public void setCourses(Object courses) {
        this.courses = courses;
    }

    /**
     *
     * @return
     * The volunteer
     */
    public Object getVolunteer() {
        return volunteer;
    }

    /**
     *
     * @param volunteer
     * The Volunteer
     */
    public void setVolunteer(Object volunteer) {
        this.volunteer = volunteer;
    }

    /**
     *
     * @return
     * The recommendationsReceived
     */
    public Object getRecommendationsReceived() {
        return recommendationsReceived;
    }

    /**
     *
     * @param recommendationsReceived
     * The RecommendationsReceived
     */
    public void setRecommendationsReceived(Object recommendationsReceived) {
        this.recommendationsReceived = recommendationsReceived;
    }

    /**
     *
     * @return
     * The languages
     */
    public Object getLanguages() {
        return languages;
    }

    /**
     *
     * @param languages
     * The Languages
     */
    public void setLanguages(Object languages) {
        this.languages = languages;
    }

    /**
     *
     * @return
     * The projects
     */
    public Object getProjects() {
        return projects;
    }

    /**
     *
     * @param projects
     * The Projects
     */
    public void setProjects(Object projects) {
        this.projects = projects;
    }

    /**
     *
     * @return
     * The games
     */
    public Object getGames() {
        return games;
    }

    /**
     *
     * @param games
     * The Games
     */
    public void setGames(Object games) {
        this.games = games;
    }

    /**
     *
     * @return
     * The family
     */
    public Object getFamily() {
        return family;
    }

    /**
     *
     * @param family
     * The Family
     */
    public void setFamily(Object family) {
        this.family = family;
    }

    /**
     *
     * @return
     * The teleVisionShow
     */
    public Object getTeleVisionShow() {
        return teleVisionShow;
    }

    /**
     *
     * @param teleVisionShow
     * The TeleVisionShow
     */
    public void setTeleVisionShow(Object teleVisionShow) {
        this.teleVisionShow = teleVisionShow;
    }

    /**
     *
     * @return
     * The mutualFriends
     */
    public Object getMutualFriends() {
        return mutualFriends;
    }

    /**
     *
     * @param mutualFriends
     * The MutualFriends
     */
    public void setMutualFriends(Object mutualFriends) {
        this.mutualFriends = mutualFriends;
    }

    /**
     *
     * @return
     * The movies
     */
    public Object getMovies() {
        return movies;
    }

    /**
     *
     * @param movies
     * The Movies
     */
    public void setMovies(Object movies) {
        this.movies = movies;
    }

    /**
     *
     * @return
     * The books
     */
    public Object getBooks() {
        return books;
    }

    /**
     *
     * @param books
     * The Books
     */
    public void setBooks(Object books) {
        this.books = books;
    }

    /**
     *
     * @return
     * The ageRange
     */
    public Object getAgeRange() {
        return ageRange;
    }

    /**
     *
     * @param ageRange
     * The AgeRange
     */
    public void setAgeRange(Object ageRange) {
        this.ageRange = ageRange;
    }

    /**
     *
     * @return
     * The publicRepository
     */
    public Object getPublicRepository() {
        return publicRepository;
    }

    /**
     *
     * @param publicRepository
     * The PublicRepository
     */
    public void setPublicRepository(Object publicRepository) {
        this.publicRepository = publicRepository;
    }

    /**
     *
     * @return
     * The hireable
     */
    public Boolean getHireable() {
        return hireable;
    }

    /**
     *
     * @param hireable
     * The Hireable
     */
    public void setHireable(Boolean hireable) {
        this.hireable = hireable;
    }

    /**
     *
     * @return
     * The repositoryUrl
     */
    public Object getRepositoryUrl() {
        return repositoryUrl;
    }

    /**
     *
     * @param repositoryUrl
     * The RepositoryUrl
     */
    public void setRepositoryUrl(Object repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    /**
     *
     * @return
     * The age
     */
    public Object getAge() {
        return age;
    }

    /**
     *
     * @param age
     * The Age
     */
    public void setAge(Object age) {
        this.age = age;
    }

    /**
     *
     * @return
     * The patents
     */
    public Object getPatents() {
        return patents;
    }

    /**
     *
     * @param patents
     * The Patents
     */
    public void setPatents(Object patents) {
        this.patents = patents;
    }

    /**
     *
     * @return
     * The favoriteThings
     */
    public Object getFavoriteThings() {
        return favoriteThings;
    }

    /**
     *
     * @param favoriteThings
     * The FavoriteThings
     */
    public void setFavoriteThings(Object favoriteThings) {
        this.favoriteThings = favoriteThings;
    }

    /**
     *
     * @return
     * The professionalHeadline
     */
    public Object getProfessionalHeadline() {
        return professionalHeadline;
    }

    /**
     *
     * @param professionalHeadline
     * The ProfessionalHeadline
     */
    public void setProfessionalHeadline(Object professionalHeadline) {
        this.professionalHeadline = professionalHeadline;
    }

    /**
     *
     * @return
     * The providerAccessCredential
     */
    public Object getProviderAccessCredential() {
        return providerAccessCredential;
    }

    /**
     *
     * @param providerAccessCredential
     * The ProviderAccessCredential
     */
    public void setProviderAccessCredential(Object providerAccessCredential) {
        this.providerAccessCredential = providerAccessCredential;
    }

    /**
     *
     * @return
     * The relatedProfileViews
     */
    public Object getRelatedProfileViews() {
        return relatedProfileViews;
    }

    /**
     *
     * @param relatedProfileViews
     * The RelatedProfileViews
     */
    public void setRelatedProfileViews(Object relatedProfileViews) {
        this.relatedProfileViews = relatedProfileViews;
    }

    /**
     *
     * @return
     * The kloutScore
     */
    public Object getKloutScore() {
        return kloutScore;
    }

    /**
     *
     * @param kloutScore
     * The KloutScore
     */
    public void setKloutScore(Object kloutScore) {
        this.kloutScore = kloutScore;
    }

    /**
     *
     * @return
     * The lRUserID
     */
    public Object getLRUserID() {
        return lRUserID;
    }

    /**
     *
     * @param lRUserID
     * The LRUserID
     */
    public void setLRUserID(Object lRUserID) {
        this.lRUserID = lRUserID;
    }

    /**
     *
     * @return
     * The placesLived
     */
    public Object getPlacesLived() {
        return placesLived;
    }

    /**
     *
     * @param placesLived
     * The PlacesLived
     */
    public void setPlacesLived(Object placesLived) {
        this.placesLived = placesLived;
    }

    /**
     *
     * @return
     * The publications
     */
    public Object getPublications() {
        return publications;
    }

    /**
     *
     * @param publications
     * The Publications
     */
    public void setPublications(Object publications) {
        this.publications = publications;
    }

    /**
     *
     * @return
     * The jobBookmarks
     */
    public Object getJobBookmarks() {
        return jobBookmarks;
    }

    /**
     *
     * @param jobBookmarks
     * The JobBookmarks
     */
    public void setJobBookmarks(Object jobBookmarks) {
        this.jobBookmarks = jobBookmarks;
    }

    /**
     *
     * @return
     * The suggestions
     */
    public Object getSuggestions() {
        return suggestions;
    }

    /**
     *
     * @param suggestions
     * The Suggestions
     */
    public void setSuggestions(Object suggestions) {
        this.suggestions = suggestions;
    }

    /**
     *
     * @return
     * The badges
     */
    public Object getBadges() {
        return badges;
    }

    /**
     *
     * @param badges
     * The Badges
     */
    public void setBadges(Object badges) {
        this.badges = badges;
    }

    /**
     *
     * @return
     * The memberUrlResources
     */
    public Object getMemberUrlResources() {
        return memberUrlResources;
    }

    /**
     *
     * @param memberUrlResources
     * The MemberUrlResources
     */
    public void setMemberUrlResources(Object memberUrlResources) {
        this.memberUrlResources = memberUrlResources;
    }

    /**
     *
     * @return
     * The totalPrivateRepository
     */
    public Integer getTotalPrivateRepository() {
        return totalPrivateRepository;
    }

    /**
     *
     * @param totalPrivateRepository
     * The TotalPrivateRepository
     */
    public void setTotalPrivateRepository(Integer totalPrivateRepository) {
        this.totalPrivateRepository = totalPrivateRepository;
    }

    /**
     *
     * @return
     * The currency
     */
    public Object getCurrency() {
        return currency;
    }

    /**
     *
     * @param currency
     * The Currency
     */
    public void setCurrency(Object currency) {
        this.currency = currency;
    }

    /**
     *
     * @return
     * The starredUrl
     */
    public Object getStarredUrl() {
        return starredUrl;
    }

    /**
     *
     * @param starredUrl
     * The StarredUrl
     */
    public void setStarredUrl(Object starredUrl) {
        this.starredUrl = starredUrl;
    }

    /**
     *
     * @return
     * The gistsUrl
     */
    public Object getGistsUrl() {
        return gistsUrl;
    }

    /**
     *
     * @param gistsUrl
     * The GistsUrl
     */
    public void setGistsUrl(Object gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    /**
     *
     * @return
     * The publicGists
     */
    public Integer getPublicGists() {
        return publicGists;
    }

    /**
     *
     * @param publicGists
     * The PublicGists
     */
    public void setPublicGists(Integer publicGists) {
        this.publicGists = publicGists;
    }

    /**
     *
     * @return
     * The privateGists
     */
    public Integer getPrivateGists() {
        return privateGists;
    }

    /**
     *
     * @param privateGists
     * The PrivateGists
     */
    public void setPrivateGists(Integer privateGists) {
        this.privateGists = privateGists;
    }

    /**
     *
     * @return
     * The subscription
     */
    public Object getSubscription() {
        return subscription;
    }

    /**
     *
     * @param subscription
     * The Subscription
     */
    public void setSubscription(Object subscription) {
        this.subscription = subscription;
    }

    /**
     *
     * @return
     * The company
     */
    public Object getCompany() {
        return company;
    }

    /**
     *
     * @param company
     * The Company
     */
    public void setCompany(Object company) {
        this.company = company;
    }

    /**
     *
     * @return
     * The gravatarImageUrl
     */
    public Object getGravatarImageUrl() {
        return gravatarImageUrl;
    }

    /**
     *
     * @param gravatarImageUrl
     * The GravatarImageUrl
     */
    public void setGravatarImageUrl(Object gravatarImageUrl) {
        this.gravatarImageUrl = gravatarImageUrl;
    }

    /**
     *
     * @return
     * The profileImageUrls
     */
    public Object getProfileImageUrls() {
        return profileImageUrls;
    }

    /**
     *
     * @param profileImageUrls
     * The ProfileImageUrls
     */
    public void setProfileImageUrls(Object profileImageUrls) {
        this.profileImageUrls = profileImageUrls;
    }

    /**
     *
     * @return
     * The webProfiles
     */
    public Object getWebProfiles() {
        return webProfiles;
    }

    /**
     *
     * @param webProfiles
     * The WebProfiles
     */
    public void setWebProfiles(Object webProfiles) {
        this.webProfiles = webProfiles;
    }

    /**
     *
     * @return
     * The pinsCount
     */
    public Integer getPinsCount() {
        return pinsCount;
    }

    /**
     *
     * @param pinsCount
     * The PinsCount
     */
    public void setPinsCount(Integer pinsCount) {
        this.pinsCount = pinsCount;
    }

    /**
     *
     * @return
     * The boardsCount
     */
    public Integer getBoardsCount() {
        return boardsCount;
    }

    /**
     *
     * @param boardsCount
     * The BoardsCount
     */
    public void setBoardsCount(Integer boardsCount) {
        this.boardsCount = boardsCount;
    }

    /**
     *
     * @return
     * The likesCount
     */
    public Integer getLikesCount() {
        return likesCount;
    }

    /**
     *
     * @param likesCount
     * The LikesCount
     */
    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }
    
    
    /**
	 * 
	 * @return
	 * The signupDate
	 */
	 public String getSignupDate() {
	 return signupDate;
	 }

	 /**
	 * 
	 * @param signupDate
	 * The SignupDate
	 */
	 public void setSignupDate(String signupDate) {
	 this.signupDate = signupDate;
	 }

	 /**
	 * 
	 * @return
	 * The lastLoginDate
	 */
	 public String getLastLoginDate() {
	 return lastLoginDate;
	 }

	 /**
	 * 
	 * @param lastLoginDate
	 * The LastLoginDate
	 */
	 public void setLastLoginDate(String lastLoginDate) {
	 this.lastLoginDate = lastLoginDate;
	 }
	 

}