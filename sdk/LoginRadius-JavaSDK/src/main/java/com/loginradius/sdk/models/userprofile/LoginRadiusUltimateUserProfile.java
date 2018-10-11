package com.loginradius.sdk.models.userprofile;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.userprofile.identity.Identity;

public class LoginRadiusUltimateUserProfile {
	@SerializedName("Identities")
	public List<Identity> identities = null;
	@SerializedName("Password")
	public String password;
	@SerializedName("LastPasswordChangeDate")
	public String lastPasswordChangeDate;
	@SerializedName("PasswordExpirationDate")
	public String passwordExpirationDate;
	@SerializedName("LastPasswordChangeToken")
	public String lastPasswordChangeToken;
	@SerializedName("EmailVerified")
	public Boolean emailVerified;
	@SerializedName("IsActive")
	public Boolean isActive;
	@SerializedName("IsDeleted")
	public Boolean isDeleted;
	@SerializedName("Uid")
	public String uid;
	@SerializedName("CustomFields")
	public Object customFields;
	@SerializedName("IsEmailSubscribed")
	public Boolean isEmailSubscribed;
	@SerializedName("UserName")
	public String userName;
	@SerializedName("NoOfLogins")
	public Integer noOfLogins;
	@SerializedName("PreviousUids")
	public Object previousUids;
	@SerializedName("PhoneId")
	public String PhoneId;
	@SerializedName("PhoneIdVerified")
	public String PhoneIdVerified;
	@SerializedName("ID")
	public String ID;
	@SerializedName("Provider")
	public String Provider;
	@SerializedName("Prefix")
	public String Prefix;
	@SerializedName("FirstName")
	public String FirstName;
	@SerializedName("MiddleName")
	public String MiddleName;
	@SerializedName("LastName")
	public String LastName;
	@SerializedName("Suffix")
	public String Suffix;
	@SerializedName("FullName")
	public String FullName;
	@SerializedName("NickName")
	public String NickName;
	@SerializedName("ProfileName")
	public String ProfileName;
	@SerializedName("BirthDate")
	public String BirthDate;
	@SerializedName("Gender")
	public String Gender;
	@SerializedName("Website")
	public String Website;
	@SerializedName("Email")
	public List<LoginRadiusEmail> Email;
	@SerializedName("Country")
	public LoginRadiusCountry Country;
	@SerializedName("ThumbnailImageUrl")
	@Expose
	private String thumbnailImageUrl;
	@SerializedName("ImageUrl")
	@Expose
	private String imageUrl;
	@SerializedName("Favicon")
	@Expose
	private String favicon;
	@SerializedName("ProfileUrl")
	@Expose
	private String profileUrl;
	@SerializedName("HomeTown")
	@Expose
	private String homeTown;
	@SerializedName("State")
	@Expose
	private String state;
	@SerializedName("City")
	@Expose
	private String city;
	@SerializedName("Industry")
	@Expose
	private String industry;
	@SerializedName("About")
	@Expose
	private String about;
	@SerializedName("TimeZone")
	@Expose
	private String timeZone;
	@SerializedName("LocalLanguage")
	@Expose
	private String localLanguage;
	@SerializedName("CoverPhoto")
	@Expose
	private String coverPhoto;
	@SerializedName("TagLine")
	@Expose
	private String tagLine;
	@SerializedName("Language")
	@Expose
	private String language;
	@SerializedName("Verified")
	@Expose
	private Object verified;
	@SerializedName("UpdatedTime")
	@Expose
	private Object updatedTime;
	@SerializedName("Positions")
	public List<LoginRadiusPosition> Positions;

	@SerializedName("Educations")
	public List<LoginRadiusEducation> educations;
	@SerializedName("PhoneNumbers")
	public List<LoginRadiusPhoneNumber> PhoneNumbers;
	@SerializedName("IMAccounts")
	public List<LoginRadiusIMAccount> IMAccounts;
	@SerializedName("Addresses")
	public List<LoginRadiusAddress> Addresses;
	@SerializedName("MainAddress")
	public String MainAddress;
	@SerializedName("Created")
	public String Created;
	@SerializedName("CreatedDate")
	public String createdDate;
	@SerializedName("ModifiedDate")
	public String modifiedDate;
	@SerializedName("LocalCity")
	public String LocalCity;

	@SerializedName("ProfileCity")
	public String ProfileCity;
	@SerializedName("LocalCountry")
	public String LocalCountry;

	@SerializedName("ProfileCountry")
	public String ProfileCountry;
	@SerializedName("FirstLogin")
	public Boolean firstLogin;
	@SerializedName("IsProtected")
	public boolean IsProtected;
	@SerializedName("RelationshipStatus")
	public String RelationshipStatus;
	@SerializedName("Quota")
	public String Quota;
	@SerializedName("Quote")
	public String quote;
	@SerializedName("InterestedIn")
	public List<String> InterestedIn;
	@SerializedName("Interests")
	public List<LoginRadiusInterest> Interests;
	@SerializedName("Religion")
	public String Religion;
	@SerializedName("Political")
	public String Political;
	@SerializedName("Sports")
	public List<LoginRadiusSport> Sports;
	@SerializedName("InspirationalPeople")
	public List<LoginRadiusInspirationalPeople> InspirationalPeople;
	@SerializedName("HttpsImageUrl")
	public String HttpsImageUrl;
	@SerializedName("FollowersCount")
	public int FollowersCount;
	@SerializedName("FriendsCount")
	public int FriendsCount;
	@SerializedName("IsGeoEnabled")
	public String IsGeoEnabled;
	@SerializedName("TotalStatusesCount")
	public int TotalStatusesCount;
	@SerializedName("Associations")
	public String Associations;
	@SerializedName("NumRecommenders")
	public int NumRecommenders;
	@SerializedName("Honors")
	public String Honors;
	@SerializedName("Awards")
	public List<LoginRadiusAward> Awards;
	@SerializedName("Skills")
	public List<LoginRadiusSkill> Skills;
	@SerializedName("CurrentStatus")
	public List<LoginRadiusCurrentStatus> CurrentStatus;
	@SerializedName("Certifications")
	public List<LoginRadiusCertification> Certifications;
	@SerializedName("Courses")
	public List<LoginRadiusCourse> Courses;
	@SerializedName("Volunteer")
	public List<LoginradiusVolunteer> Volunteer;
	@SerializedName("RecommendationsReceived")
	public List<LoginRadiusRecommendationReceived> RecommendationsReceived;
	@SerializedName("Languages")
	public List<LoginRadiusLanguage> Languages;
	@SerializedName("Projects")
	public List<LoginRadiusProject> Projects;
	@SerializedName("Games")
	public List<LoginRadiusGame> Games;
	@SerializedName("Family")
	public List<LoginRadiusFamily> Family;
	@SerializedName("TeleVisionShow")
	public List<LoginRadiusTelevisionShow> TeleVisionShow;
	@SerializedName("MutualFriends")
	public List<LoginRadiusMutualFriend> MutualFriends;
	@SerializedName("Movies")
	public List<LoginRadiusMovie> Movies;
	@SerializedName("Books")
	public List<LoginRadiusBook> Books;
	@SerializedName("AgeRange")
	public LoginRadiusAgeRange AgeRange;
	@SerializedName("PublicRepository")
	public String PublicRepository;
	@SerializedName("Hireable")
	public Boolean Hireable;
	@SerializedName("RepositoryUrl")
	public String RepositoryUrl;
	@SerializedName("Age")
	public String Age;
	@SerializedName("Patents")
	public List<LoginRadiusPatent> Patents;
	@SerializedName("FavoriteThings")
	public List<LoginRadiusFavoriteThing> FavoriteThings;
	@SerializedName("ProfessionalHeadline")
	public String ProfessionalHeadline;
	@SerializedName("ProviderAccessCredential")
	public ProviderAccessCredential ProviderAccessCredential;
	@SerializedName("RelatedProfileViews")
	public List<LoginRadiusRelatedProfileViews> RelatedProfileViews;
	@SerializedName("KloutScore")
	public LoginRadiusKloutProfile KloutScore;
	@SerializedName("LRUserID")
	public String LRUserID;
	@SerializedName("PlacesLived")
	public List<LoginRadiusPlaceLived> PlacesLived;
	@SerializedName("Publications")
	public List<LoginRadiusPublication> Publications;
	@SerializedName("JobBookmarks")
	public List<LoginRadiusJobBookmark> JobBookmarks;
	@SerializedName("Suggestions")
	public LoginRadiusSuggestion Suggestions;
	@SerializedName("Badges")
	public List<LoginRadiusBadge> Badges;
	@SerializedName("MemberUrlResources")
	public List<LoginRadiusMemberUrlResource> MemberUrlResources;
	@SerializedName("TotalPrivateRepository")
	public int TotalPrivateRepository;
	@SerializedName("Currency")
	public String Currency;
	@SerializedName("StarredUrl")
	public String StarredUrl;
	@SerializedName("GistsUrl")
	public String GistsUrl;
	@SerializedName("PublicGists")
	public int PublicGists;
	@SerializedName("PrivateGists")
	public int PrivateGists;
	@SerializedName("Subscription")
	public LoginRadiusUserSubscription Subscription;
	@SerializedName("Company")
	public String company;
	@SerializedName("GravatarImageUrl")
	public String gravatarImageUrl;
	@SerializedName("ProfileImageUrls")
	public Object profileImageUrls;
	@SerializedName("WebProfiles")
	public WebProfiles webProfiles;
	@SerializedName("PinsCount")
	public int pinsCount;
	@SerializedName("BoardsCount")
	public int boardsCount;
	@SerializedName("LikesCount")
	public int likesCount;
	@SerializedName("SignupDate")
	@Expose
	private String signupDate;
	@SerializedName("LastLoginDate")
	public String lastLoginDate;

	@SerializedName("ExternalUserLoginId")
	private String externalUserLoginId;
	@SerializedName("RegistrationProvider")
	private String registrationProvider;
	@SerializedName("IsLoginLocked")
	private Boolean isLoginLocked;
	@SerializedName("LoginLockedType")
	private String loginLockedType;
	@SerializedName("LastLoginLocation")
	private String lastLoginLocation;
	@SerializedName("RegistrationSource")
	private String registrationSource;
	@SerializedName("IsCustomUid")
	private Boolean isCustomUid;
	@SerializedName("UnverifiedEmail")
	private List<UnverifiedEmail> unverifiedEmail = null;
	@SerializedName("PrivacyPolicy")
	private LoginRadiusPrivacyPolicy privacyPolicy;

	@SerializedName("ExternalIds")
	private List<ExternalId> externalIds = null;

	@SerializedName("IsRequiredFieldsFilledOnce")
	@Expose
	private Boolean isRequiredFieldsFilledOnce;

	@SerializedName("IsSecurePassword")
	private Boolean isSecurePassword;

	public List<Identity> getIdentities() {
		return identities;
	}

	public void setIdentities(List<Identity> identities) {
		this.identities = identities;
	}

	/**
	 *
	 * @return The password
	 */

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 *
	 * @return The lastPasswordChangeDate
	 */

	public String getLastPasswordChangeDate() {
		return lastPasswordChangeDate;
	}

	public void setLastPasswordChangeDate(String lastPasswordChangeDate) {
		this.lastPasswordChangeDate = lastPasswordChangeDate;
	}

	/**
	 *
	 * @return The passwordExpirationDate
	 */
	public String getPasswordExpirationDate() {
		return passwordExpirationDate;
	}

	/**
	 *
	 * @param passwordExpirationDate
	 *            The PasswordExpirationDate
	 */
	public void setPasswordExpirationDate(String passwordExpirationDate) {
		this.passwordExpirationDate = passwordExpirationDate;
	}

	/**
	 * 
	 * @return last password change token
	 */

	public String getLastPasswordChangeToken() {
		return lastPasswordChangeToken;
	}

	public void setLastPasswordChangeToken(String lastPasswordChangeToken) {
		this.lastPasswordChangeToken = lastPasswordChangeToken;
	}

	/**
	 *
	 * @return The emailVerified
	 */
	public Boolean getEmailVerified() {
		return emailVerified;
	}

	/**
	 *
	 * @param emailVerified
	 *            The EmailVerified
	 */
	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	/**
	 *
	 * @return The isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 *
	 * @param isActive
	 *            The IsActive
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 *
	 * @return The isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 *
	 * @param isDeleted
	 *            The IsDeleted
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 *
	 * @return The uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 *
	 * @param uid
	 *            The Uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 *
	 * @return The customFields
	 */
	public Object getCustomFields() {
		return customFields;
	}

	/**
	 *
	 * @param customFields
	 *            The CustomFields
	 */
	public void setCustomFields(Object customFields) {
		this.customFields = customFields;
	}

	/**
	 *
	 * @return The isEmailSubscribed
	 */
	public Boolean getIsEmailSubscribed() {
		return isEmailSubscribed;
	}

	/**
	 *
	 * @param isEmailSubscribed
	 *            The IsEmailSubscribed
	 */
	public void setIsEmailSubscribed(Boolean isEmailSubscribed) {
		this.isEmailSubscribed = isEmailSubscribed;
	}

	/**
	 *
	 * @return The userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 *
	 * @param userName
	 *            The UserName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 *
	 * @return The noOfLogins
	 */
	public Integer getNoOfLogins() {
		return noOfLogins;
	}

	/**
	 *
	 * @param noOfLogins
	 *            The NoOfLogins
	 */
	public void setNoOfLogins(Integer noOfLogins) {
		this.noOfLogins = noOfLogins;
	}

	/**
	 *
	 * @return The previousUids
	 */
	public Object getPreviousUids() {
		return previousUids;
	}

	/**
	 *
	 * @param previousUids
	 *            The PreviousUids
	 */
	public void setPreviousUids(Object previousUids) {
		this.previousUids = previousUids;
	}

	public String getExternalUserLoginId() {
		return externalUserLoginId;
	}

	public void setExternalUserLoginId(String externalUserLoginId) {
		this.externalUserLoginId = externalUserLoginId;
	}

	public String getRegistrationProvider() {
		return registrationProvider;
	}

	public void setRegistrationProvider(String registrationProvider) {
		this.registrationProvider = registrationProvider;
	}

	public Boolean getIsLoginLocked() {
		return isLoginLocked;
	}

	public void setIsLoginLocked(Boolean isLoginLocked) {
		this.isLoginLocked = isLoginLocked;
	}

	public String getLoginLockedType() {
		return loginLockedType;
	}

	public void setLoginLockedType(String loginLockedType) {
		this.loginLockedType = loginLockedType;
	}

	public String getLastLoginLocation() {
		return lastLoginLocation;
	}

	public void setLastLoginLocation(String lastLoginLocation) {
		this.lastLoginLocation = lastLoginLocation;
	}

	public String getRegistrationSource() {
		return registrationSource;
	}

	public void setRegistrationSource(String registrationSource) {
		this.registrationSource = registrationSource;
	}

	public Boolean getIsCustomUid() {
		return isCustomUid;
	}

	public void setIsCustomUid(Boolean isCustomUid) {
		this.isCustomUid = isCustomUid;
	}

	public List<UnverifiedEmail> getUnverifiedEmail() {
		return unverifiedEmail;
	}

	public void setUnverifiedEmail(List<UnverifiedEmail> unverifiedEmail) {
		this.unverifiedEmail = unverifiedEmail;
	}

	public LoginRadiusPrivacyPolicy getPrivacyPolicy() {
		return privacyPolicy;
	}

	public void setPrivacyPolicy(LoginRadiusPrivacyPolicy privacyPolicy) {
		this.privacyPolicy = privacyPolicy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(Boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getGravatarImageUrl() {
		return gravatarImageUrl;
	}

	public void setGravatarImageUrl(String gravatarImageUrl) {
		this.gravatarImageUrl = gravatarImageUrl;
	}

	public Object getProfileImageUrls() {
		return profileImageUrls;
	}

	public void setProfileImageUrls(Object profileImageUrls) {
		this.profileImageUrls = profileImageUrls;
	}

	public WebProfiles getWebProfiles() {
		return webProfiles;
	}

	public void setWebProfiles(WebProfiles webProfiles) {
		this.webProfiles = webProfiles;
	}

	public Integer getPinsCount() {
		return pinsCount;
	}

	public void setPinsCount(Integer pinsCount) {
		this.pinsCount = pinsCount;
	}

	public Integer getBoardsCount() {
		return boardsCount;
	}

	public void setBoardsCount(Integer boardsCount) {
		this.boardsCount = boardsCount;
	}

	public Integer getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(Integer likesCount) {
		this.likesCount = likesCount;
	}

	public String getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Boolean getIsSecurePassword() {
		return isSecurePassword;
	}

	public void setIsSecurePassword(Boolean isSecurePassword) {
		this.isSecurePassword = isSecurePassword;
	}

	/**
	 * 
	 * @return external Id
	 */

	public List<ExternalId> getExternalIds() {
		return externalIds;
	}

	public void setExternalIds(List<ExternalId> externalIds) {
		this.externalIds = externalIds;
	}

	public Boolean getIsRequiredFieldsFilledOnce() {
		return isRequiredFieldsFilledOnce;
	}

	public void setIsRequiredFieldsFilledOnce(Boolean isRequiredFieldsFilledOnce) {
		this.isRequiredFieldsFilledOnce = isRequiredFieldsFilledOnce;
	}

	public String getThumbnailImageUrl() {
		return thumbnailImageUrl;
	}

	public void setThumbnailImageUrl(String thumbnailImageUrl) {
		this.thumbnailImageUrl = thumbnailImageUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getFavicon() {
		return favicon;
	}

	public void setFavicon(String favicon) {
		this.favicon = favicon;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getLocalLanguage() {
		return localLanguage;
	}

	public void setLocalLanguage(String localLanguage) {
		this.localLanguage = localLanguage;
	}

	public String getCoverPhoto() {
		return coverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Object getVerified() {
		return verified;
	}

	public void setVerified(Object verified) {
		this.verified = verified;
	}

	public Object getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Object updatedTime) {
		this.updatedTime = updatedTime;
	}

	public List<LoginRadiusPosition> getPositions() {
		return Positions;
	}

	/**
	 *
	 * @param Positions
	 *            The Positions
	 */
	public void setPositions(List<LoginRadiusPosition> Positions) {
		this.Positions = Positions;
	}

	public List<LoginRadiusEducation> getEducations() {
		return educations;
	}

	/**
	 *
	 * @param educations
	 *            The Educations
	 */
	public void setEducations(List<LoginRadiusEducation> educations) {
		this.educations = educations;
	}

	/**
	 *
	 * @return The iMAccounts
	 */
	public List<LoginRadiusIMAccount> getIMAccounts() {
		return IMAccounts;
	}

	/**
	 *
	 * @param IMAccounts
	 *            The IMAccounts
	 */
	public void setLoginRadiusIMAccount(List<LoginRadiusIMAccount> IMAccounts) {
		this.IMAccounts = IMAccounts;
	}

	/**
	 *
	 * @return The Addresses
	 */
	public List<LoginRadiusAddress> getAddresses() {
		return Addresses;
	}

	/**
	 *
	 * @param Addresses
	 *            The Addresses
	 */
	public void setAddresses(List<LoginRadiusAddress> Addresses) {
		this.Addresses = Addresses;
	}

	public String getMainAddress() {
		return MainAddress;
	}

	public void setMainAddress(String MainAddress) {
		this.MainAddress = MainAddress;
	}
}
