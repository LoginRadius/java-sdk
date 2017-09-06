package com.loginradius.sdk.models.userprofile;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.userprofile.identity.Identity;

public class LoginRadiusUltimateUserProfile {
	@SerializedName("Identities")
	private List<Identity> identities = null;
	@SerializedName("Password")
	private String password;
	@SerializedName("LastPasswordChangeDate")
	private String lastPasswordChangeDate;
	@SerializedName("PasswordExpirationDate")
	private String passwordExpirationDate;
	@SerializedName("LastPasswordChangeToken")
	private Object lastPasswordChangeToken;
	@SerializedName("EmailVerified")
	private Boolean emailVerified;
	@SerializedName("IsActive")
	private Boolean isActive;
	@SerializedName("IsDeleted")
	private Boolean isDeleted;
	@SerializedName("Uid")
	private String uid;
	@SerializedName("CustomFields")
    private Object customFields;
	@SerializedName("IsEmailSubscribed")
    private Boolean isEmailSubscribed;
	@SerializedName("UserName")
	private String userName;
	@SerializedName("NoOfLogins")
	private Integer noOfLogins;
	@SerializedName("PreviousUids")
	private Object previousUids;
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
	public String ThumbnailImageUrl;
	@SerializedName("ImageUrl")
	public String ImageUrl;
	@SerializedName("Favicon")
	public String Favicon;
	@SerializedName("ProfileUrl")
	public String ProfileUrl;
	@SerializedName("HomeTown")
	public String HomeTown;
	@SerializedName("State")
	public String State;
	@SerializedName("City")
	public String City;
	@SerializedName("Industry")
	public String Industry;
	@SerializedName("About")
	public String About;
	@SerializedName("TimeZone")
	public String TimeZone;
	@SerializedName("LocalLanguage")
	public String LocalLanguage;
	@SerializedName("CoverPhoto")
	public String CoverPhoto;
	@SerializedName("TagLine")
	public String TagLine;
	@SerializedName("Language")
	public String Language;
	@SerializedName("Verified")
	public String Verified;
	@SerializedName("UpdatedTime")
	public String UpdatedTime;
	@SerializedName("Positions")
	public List<LoginRadiusPosition> Positions;
	@SerializedName("Educations")
	public List<LoginRadiusEducation> Educations;
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
	@SerializedName("LocalCity")
	public String LocalCity;

	@SerializedName("ProfileCity")
	public String ProfileCity;
	@SerializedName("LocalCountry")
	public String LocalCountry;

	@SerializedName("ProfileCountry")
	public String ProfileCountry;
	@SerializedName("IsProtected")
	public boolean IsProtected;
	@SerializedName("RelationshipStatus")
	public String RelationshipStatus;
	@SerializedName("Quota")
	public String Quota;
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

	@SerializedName("ExternalUserLoginId")
    private Object externalUserLoginId;
	@SerializedName("RegistrationProvider")
    private Object registrationProvider;
	@SerializedName("IsLoginLocked")
    private Boolean isLoginLocked;
	@SerializedName("LastLoginLocation")
    private Object lastLoginLocation;
	@SerializedName("RegistrationSource")
    private Object registrationSource;
	@SerializedName("IsCustomUid")
    private Boolean isCustomUid;
	@SerializedName("UnverifiedEmail")

	private List<UnverifiedEmail> unverifiedEmail = null;

	public List<Identity> getIdentities() {
		return identities;
		}

	public void setIdentities(List<Identity> identities) {
		this.identities = identities;
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

	public Object getExternalUserLoginId() {
		return externalUserLoginId;
	}

	public void setExternalUserLoginId(Object externalUserLoginId) {
		this.externalUserLoginId = externalUserLoginId;
	}

	public Object getRegistrationProvider() {
		return registrationProvider;
	}

	public void setRegistrationProvider(Object registrationProvider) {
		this.registrationProvider = registrationProvider;
	}

	public Boolean getIsLoginLocked() {
		return isLoginLocked;
	}

	public void setIsLoginLocked(Boolean isLoginLocked) {
		this.isLoginLocked = isLoginLocked;
	}

	public Object getLastLoginLocation() {
		return lastLoginLocation;
	}

	public void setLastLoginLocation(Object lastLoginLocation) {
		this.lastLoginLocation = lastLoginLocation;
	}

	public Object getRegistrationSource() {
		return registrationSource;
	}

	public void setRegistrationSource(Object registrationSource) {
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

}
