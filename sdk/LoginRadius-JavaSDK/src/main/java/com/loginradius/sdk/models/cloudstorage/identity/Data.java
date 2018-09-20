
package com.loginradius.sdk.models.cloudstorage.identity;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("Email")
    @Expose
    private List<Email> email = null;
    @SerializedName("NumRecommenders")
    @Expose
    private Integer numRecommenders;
    @SerializedName("LastLoginDate")
    @Expose
    private String lastLoginDate;
    @SerializedName("HttpsImageUrl")
    @Expose
    private String httpsImageUrl;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("Verified")
    @Expose
    private String verified;
    @SerializedName("FollowersCount")
    @Expose
    private Integer followersCount;
    @SerializedName("FirstLogin")
    @Expose
    private Boolean firstLogin;
    @SerializedName("IsLoginLocked")
    @Expose
    private Boolean isLoginLocked;
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("SecurityQuestionFailedResetPasswordAttempts")
    @Expose
    private Integer securityQuestionFailedResetPasswordAttempts;
    @SerializedName("LikesCount")
    @Expose
    private Integer likesCount;
    @SerializedName("IsDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("NoOfLogins")
    @Expose
    private Integer noOfLogins;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("Roles")
    @Expose
    private Object roles;
    @SerializedName("City")
    @Expose
    private String city;
    @SerializedName("TotalStatusesCount")
    @Expose
    private Integer totalStatusesCount;
    @SerializedName("GravatarImageUrl")
    @Expose
    private String gravatarImageUrl;
    @SerializedName("BoardsCount")
    @Expose
    private Integer boardsCount;
    @SerializedName("Uid")
    @Expose
    private String uid;
    @SerializedName("CustomFields")
    @Expose
    private Object customFields;
    @SerializedName("PublicGists")
    @Expose
    private Integer publicGists;
    @SerializedName("FailedLoginAttempt")
    @Expose
    private Integer failedLoginAttempt;
    @SerializedName("TotalPrivateRepository")
    @Expose
    private Integer totalPrivateRepository;
    @SerializedName("CreatedDate")
    @Expose
    private String createdDate;
    @SerializedName("RegistrationProvider")
    @Expose
    private String registrationProvider;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("ProfileUrl")
    @Expose
    private String profileUrl;
    @SerializedName("BirthDate")
    @Expose
    private Object birthDate;
    @SerializedName("ProfileImageUrls")
    @Expose
    private ProfileImageUrls profileImageUrls;
    @SerializedName("PhoneIdVerified")
    @Expose
    private Boolean phoneIdVerified;
    @SerializedName("IsCustomUid")
    @Expose
    private Boolean isCustomUid;
    @SerializedName("LocalCountry")
    @Expose
    private String localCountry;
    @SerializedName("LocalCity")
    @Expose
    private String localCity;
    @SerializedName("FriendsCount")
    @Expose
    private Integer friendsCount;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("IsEmailSubscribed")
    @Expose
    private Boolean isEmailSubscribed;
    @SerializedName("ModifiedDate")
    @Expose
    private String modifiedDate;
    @SerializedName("LastLoginLocation")
    @Expose
    private Object lastLoginLocation;
    @SerializedName("Created")
    @Expose
    private Object created;
    @SerializedName("AppName")
    @Expose
    private String appName;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("PinsCount")
    @Expose
    private Integer pinsCount;
    @SerializedName("user_agent")
    @Expose
    private UserAgent userAgent;
    @SerializedName("SignupDate")
    @Expose
    private String signupDate;
    @SerializedName("IsProtected")
    @Expose
    private Boolean isProtected;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("Hireable")
    @Expose
    private Boolean hireable;
    @SerializedName("SignupLog")
    @Expose
    private SignupLog signupLog;
    @SerializedName("Provider")
    @Expose
    private String provider;
    @SerializedName("EmailVerified")
    @Expose
    private Boolean emailVerified;
    @SerializedName("PrivateGists")
    @Expose
    private Integer privateGists;
    @SerializedName("ThumbnailImageUrl")
    @Expose
    private String thumbnailImageUrl;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("DisableLogin")
    @Expose
    private Boolean disableLogin;
    @SerializedName("LocalLanguage")
    @Expose
    private String localLanguage;
    @SerializedName("LoginLockedType")
    @Expose
    private String loginLockedType;
    @SerializedName("RegistrationSource")
    @Expose
    private String registrationSource;
    @SerializedName("PhoneId")
    @Expose
    private String phoneId;

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public Integer getNumRecommenders() {
        return numRecommenders;
    }

    public void setNumRecommenders(Integer numRecommenders) {
        this.numRecommenders = numRecommenders;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getHttpsImageUrl() {
        return httpsImageUrl;
    }

    public void setHttpsImageUrl(String httpsImageUrl) {
        this.httpsImageUrl = httpsImageUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Boolean getIsLoginLocked() {
        return isLoginLocked;
    }

    public void setIsLoginLocked(Boolean isLoginLocked) {
        this.isLoginLocked = isLoginLocked;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public Integer getSecurityQuestionFailedResetPasswordAttempts() {
        return securityQuestionFailedResetPasswordAttempts;
    }

    public void setSecurityQuestionFailedResetPasswordAttempts(Integer securityQuestionFailedResetPasswordAttempts) {
        this.securityQuestionFailedResetPasswordAttempts = securityQuestionFailedResetPasswordAttempts;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getNoOfLogins() {
        return noOfLogins;
    }

    public void setNoOfLogins(Integer noOfLogins) {
        this.noOfLogins = noOfLogins;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Object getRoles() {
        return roles;
    }

    public void setRoles(Object roles) {
        this.roles = roles;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTotalStatusesCount() {
        return totalStatusesCount;
    }

    public void setTotalStatusesCount(Integer totalStatusesCount) {
        this.totalStatusesCount = totalStatusesCount;
    }

    public String getGravatarImageUrl() {
        return gravatarImageUrl;
    }

    public void setGravatarImageUrl(String gravatarImageUrl) {
        this.gravatarImageUrl = gravatarImageUrl;
    }

    public Integer getBoardsCount() {
        return boardsCount;
    }

    public void setBoardsCount(Integer boardsCount) {
        this.boardsCount = boardsCount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    public Integer getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(Integer publicGists) {
        this.publicGists = publicGists;
    }

    public Integer getFailedLoginAttempt() {
        return failedLoginAttempt;
    }

    public void setFailedLoginAttempt(Integer failedLoginAttempt) {
        this.failedLoginAttempt = failedLoginAttempt;
    }

    public Integer getTotalPrivateRepository() {
        return totalPrivateRepository;
    }

    public void setTotalPrivateRepository(Integer totalPrivateRepository) {
        this.totalPrivateRepository = totalPrivateRepository;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getRegistrationProvider() {
        return registrationProvider;
    }

    public void setRegistrationProvider(String registrationProvider) {
        this.registrationProvider = registrationProvider;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public Object getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
    }

    public ProfileImageUrls getProfileImageUrls() {
        return profileImageUrls;
    }

    public void setProfileImageUrls(ProfileImageUrls profileImageUrls) {
        this.profileImageUrls = profileImageUrls;
    }

    public Boolean getPhoneIdVerified() {
        return phoneIdVerified;
    }

    public void setPhoneIdVerified(Boolean phoneIdVerified) {
        this.phoneIdVerified = phoneIdVerified;
    }

    public Boolean getIsCustomUid() {
        return isCustomUid;
    }

    public void setIsCustomUid(Boolean isCustomUid) {
        this.isCustomUid = isCustomUid;
    }

    public String getLocalCountry() {
        return localCountry;
    }

    public void setLocalCountry(String localCountry) {
        this.localCountry = localCountry;
    }

    public String getLocalCity() {
        return localCity;
    }

    public void setLocalCity(String localCity) {
        this.localCity = localCity;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsEmailSubscribed() {
        return isEmailSubscribed;
    }

    public void setIsEmailSubscribed(Boolean isEmailSubscribed) {
        this.isEmailSubscribed = isEmailSubscribed;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Object getLastLoginLocation() {
        return lastLoginLocation;
    }

    public void setLastLoginLocation(Object lastLoginLocation) {
        this.lastLoginLocation = lastLoginLocation;
    }

    public Object getCreated() {
        return created;
    }

    public void setCreated(Object created) {
        this.created = created;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPinsCount() {
        return pinsCount;
    }

    public void setPinsCount(Integer pinsCount) {
        this.pinsCount = pinsCount;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(UserAgent userAgent) {
        this.userAgent = userAgent;
    }

    public String getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(String signupDate) {
        this.signupDate = signupDate;
    }

    public Boolean getIsProtected() {
        return isProtected;
    }

    public void setIsProtected(Boolean isProtected) {
        this.isProtected = isProtected;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getHireable() {
        return hireable;
    }

    public void setHireable(Boolean hireable) {
        this.hireable = hireable;
    }

    public SignupLog getSignupLog() {
        return signupLog;
    }

    public void setSignupLog(SignupLog signupLog) {
        this.signupLog = signupLog;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Integer getPrivateGists() {
        return privateGists;
    }

    public void setPrivateGists(Integer privateGists) {
        this.privateGists = privateGists;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getDisableLogin() {
        return disableLogin;
    }

    public void setDisableLogin(Boolean disableLogin) {
        this.disableLogin = disableLogin;
    }

    public String getLocalLanguage() {
        return localLanguage;
    }

    public void setLocalLanguage(String localLanguage) {
        this.localLanguage = localLanguage;
    }

    public String getLoginLockedType() {
        return loginLockedType;
    }

    public void setLoginLockedType(String loginLockedType) {
        this.loginLockedType = loginLockedType;
    }

    public String getRegistrationSource() {
        return registrationSource;
    }

    public void setRegistrationSource(String registrationSource) {
        this.registrationSource = registrationSource;
    }

    public String getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(String phoneId) {
        this.phoneId = phoneId;
    }

}
