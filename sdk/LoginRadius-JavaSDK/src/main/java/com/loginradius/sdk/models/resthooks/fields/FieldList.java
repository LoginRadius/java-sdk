package com.loginradius.sdk.models.resthooks.fields;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FieldList {
	@SerializedName("ID")
	@Expose
	private String iD;
	@SerializedName("Provider")
	@Expose
	private String provider;
	@SerializedName("Prefix")
	@Expose
	private String prefix;
	@SerializedName("FirstName")
	@Expose
	private String firstName;
	@SerializedName("MiddleName")
	@Expose
	private String middleName;
	@SerializedName("LastName")
	@Expose
	private String lastName;
	@SerializedName("Suffix")
	@Expose
	private String suffix;
	@SerializedName("FullName")
	@Expose
	private String fullName;
	@SerializedName("NickName")
	@Expose
	private String nickName;
	@SerializedName("ProfileName")
	@Expose
	private String profileName;
	@SerializedName("BirthDate")
	@Expose
	private String birthDate;
	@SerializedName("Gender")
	@Expose
	private String gender;
	@SerializedName("Website")
	@Expose
	private String website;
	@SerializedName("Email")
	@Expose
	private String email;
	@SerializedName("Country")
	@Expose
	private Country country;
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
	private String verified;
	@SerializedName("UpdatedTime")
	@Expose
	private String updatedTime;
	@SerializedName("Positions")
	@Expose
	private String positions;
	@SerializedName("Educations")
	@Expose
	private String educations;
	@SerializedName("PhoneNumbers")
	@Expose
	private String phoneNumbers;
	@SerializedName("IMAccounts")
	@Expose
	private String iMAccounts;
	@SerializedName("Addresses")
	@Expose
	private String addresses;
	@SerializedName("MainAddress")
	@Expose
	private String mainAddress;
	@SerializedName("Created")
	@Expose
	private String created;
	@SerializedName("LocalCity")
	@Expose
	private String localCity;
	@SerializedName("ProfileCity")
	@Expose
	private String profileCity;
	@SerializedName("LocalCountry")
	@Expose
	private String localCountry;
	@SerializedName("ProfileCountry")
	@Expose
	private String profileCountry;
	@SerializedName("IsProtected")
	@Expose
	private Boolean isProtected;
	@SerializedName("RelationshipStatus")
	@Expose
	private String relationshipStatus;
	@SerializedName("Quote")
	@Expose
	private String quote;
	@SerializedName("InterestedIn")
	@Expose
	private String interestedIn;
	@SerializedName("Interests")
	@Expose
	private String interests;
	@SerializedName("Religion")
	@Expose
	private String religion;
	@SerializedName("Political")
	@Expose
	private String political;
	@SerializedName("Sports")
	@Expose
	private String sports;
	@SerializedName("InspirationalPeople")
	@Expose
	private String inspirationalPeople;
	@SerializedName("HttpsImageUrl")
	@Expose
	private String httpsImageUrl;
	@SerializedName("FollowersCount")
	@Expose
	private Integer followersCount;
	@SerializedName("FriendsCount")
	@Expose
	private Integer friendsCount;
	@SerializedName("IsGeoEnabled")
	@Expose
	private String isGeoEnabled;
	@SerializedName("TotalStatusesCount")
	@Expose
	private Integer totalStatusesCount;
	@SerializedName("Associations")
	@Expose
	private String associations;
	@SerializedName("NumRecommenders")
	@Expose
	private Integer numRecommenders;
	@SerializedName("Honors")
	@Expose
	private String honors;
	@SerializedName("Awards")
	@Expose
	private String awards;
	@SerializedName("Skills")
	@Expose
	private String skills;
	@SerializedName("CurrentStatus")
	@Expose
	private String currentStatus;
	@SerializedName("Certifications")
	@Expose
	private String certifications;
	@SerializedName("Courses")
	@Expose
	private String courses;
	@SerializedName("Volunteer")
	@Expose
	private String volunteer;
	@SerializedName("RecommendationsReceived")
	@Expose
	private String recommendationsReceived;
	@SerializedName("Languages")
	@Expose
	private String languages;
	@SerializedName("Projects")
	@Expose
	private String projects;
	@SerializedName("Games")
	@Expose
	private String games;
	@SerializedName("Family")
	@Expose
	private String family;
	@SerializedName("TeleVisionShow")
	@Expose
	private String teleVisionShow;
	@SerializedName("MutualFriends")
	@Expose
	private String mutualFriends;
	@SerializedName("Movies")
	@Expose
	private String movies;
	@SerializedName("Books")
	@Expose
	private String books;
	@SerializedName("AgeRange")
	@Expose
	private AgeRange ageRange;
	@SerializedName("PublicRepository")
	@Expose
	private String publicRepository;
	@SerializedName("Hireable")
	@Expose
	private Boolean hireable;
	@SerializedName("RepositoryUrl")
	@Expose
	private String repositoryUrl;
	@SerializedName("Age")
	@Expose
	private String age;
	@SerializedName("Patents")
	@Expose
	private String patents;
	@SerializedName("FavoriteThings")
	@Expose
	private String favoriteThings;
	@SerializedName("ProfessionalHeadline")
	@Expose
	private String professionalHeadline;
	@SerializedName("RelatedProfileViews")
	@Expose
	private String relatedProfileViews;
	@SerializedName("KloutScore")
	@Expose
	private KloutScore kloutScore;
	@SerializedName("LRUserID")
	@Expose
	private String lRUserID;
	@SerializedName("PlacesLived")
	@Expose
	private String placesLived;
	@SerializedName("Publications")
	@Expose
	private String publications;
	@SerializedName("JobBookmarks")
	@Expose
	private String jobBookmarks;
	@SerializedName("Suggestions")
	@Expose
	private String suggestions;
	@SerializedName("Badges")
	@Expose
	private String badges;
	@SerializedName("MemberUrlResources")
	@Expose
	private String memberUrlResources;
	@SerializedName("TotalPrivateRepository")
	@Expose
	private Integer totalPrivateRepository;
	@SerializedName("Currency")
	@Expose
	private String currency;
	@SerializedName("StarredUrl")
	@Expose
	private String starredUrl;
	@SerializedName("GistsUrl")
	@Expose
	private String gistsUrl;
	@SerializedName("PublicGists")
	@Expose
	private Integer publicGists;
	@SerializedName("PrivateGists")
	@Expose
	private Integer privateGists;
	@SerializedName("Subscription")
	@Expose
	private Subscription subscription;
	@SerializedName("Company")
	@Expose
	private String company;
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
	@SerializedName("PreviousUids")
	@Expose
	private List<String> previousUids = new ArrayList<String>();
	@SerializedName("PhoneId")
	@Expose
	private String phoneId;
	@SerializedName("PhoneIdVerified")
	@Expose
	private Boolean phoneIdVerified;
	@SerializedName("SecurityQuestionAnswer")
	@Expose
	private Object securityQuestionAnswer;
	@SerializedName("NoOfLogins")
	@Expose
	private Integer noOfLogins;
	@SerializedName("WebProfiles")
	@Expose
	private Object webProfiles;

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
	public String getPrefix() {
	return prefix;
	}

	/**
	* 
	* @param prefix
	* The Prefix
	*/
	public void setPrefix(String prefix) {
	this.prefix = prefix;
	}

	/**
	* 
	* @return
	* The firstName
	*/
	public String getFirstName() {
	return firstName;
	}

	/**
	* 
	* @param firstName
	* The FirstName
	*/
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}

	/**
	* 
	* @return
	* The middleName
	*/
	public String getMiddleName() {
	return middleName;
	}

	/**
	* 
	* @param middleName
	* The MiddleName
	*/
	public void setMiddleName(String middleName) {
	this.middleName = middleName;
	}

	/**
	* 
	* @return
	* The lastName
	*/
	public String getLastName() {
	return lastName;
	}

	/**
	* 
	* @param lastName
	* The LastName
	*/
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}

	/**
	* 
	* @return
	* The suffix
	*/
	public String getSuffix() {
	return suffix;
	}

	/**
	* 
	* @param suffix
	* The Suffix
	*/
	public void setSuffix(String suffix) {
	this.suffix = suffix;
	}

	/**
	* 
	* @return
	* The fullName
	*/
	public String getFullName() {
	return fullName;
	}

	/**
	* 
	* @param fullName
	* The FullName
	*/
	public void setFullName(String fullName) {
	this.fullName = fullName;
	}

	/**
	* 
	* @return
	* The nickName
	*/
	public String getNickName() {
	return nickName;
	}

	/**
	* 
	* @param nickName
	* The NickName
	*/
	public void setNickName(String nickName) {
	this.nickName = nickName;
	}

	/**
	* 
	* @return
	* The profileName
	*/
	public String getProfileName() {
	return profileName;
	}

	/**
	* 
	* @param profileName
	* The ProfileName
	*/
	public void setProfileName(String profileName) {
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
	public String getWebsite() {
	return website;
	}

	/**
	* 
	* @param website
	* The Website
	*/
	public void setWebsite(String website) {
	this.website = website;
	}

	/**
	* 
	* @return
	* The email
	*/
	public String getEmail() {
	return email;
	}

	/**
	* 
	* @param email
	* The Email
	*/
	public void setEmail(String email) {
	this.email = email;
	}

	/**
	* 
	* @return
	* The country
	*/
	public Country getCountry() {
	return country;
	}

	/**
	* 
	* @param country
	* The Country
	*/
	public void setCountry(Country country) {
	this.country = country;
	}

	/**
	* 
	* @return
	* The thumbnailImageUrl
	*/
	public String getThumbnailImageUrl() {
	return thumbnailImageUrl;
	}

	/**
	* 
	* @param thumbnailImageUrl
	* The ThumbnailImageUrl
	*/
	public void setThumbnailImageUrl(String thumbnailImageUrl) {
	this.thumbnailImageUrl = thumbnailImageUrl;
	}

	/**
	* 
	* @return
	* The imageUrl
	*/
	public String getImageUrl() {
	return imageUrl;
	}

	/**
	* 
	* @param imageUrl
	* The ImageUrl
	*/
	public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
	}

	/**
	* 
	* @return
	* The favicon
	*/
	public String getFavicon() {
	return favicon;
	}

	/**
	* 
	* @param favicon
	* The Favicon
	*/
	public void setFavicon(String favicon) {
	this.favicon = favicon;
	}

	/**
	* 
	* @return
	* The profileUrl
	*/
	public String getProfileUrl() {
	return profileUrl;
	}

	/**
	* 
	* @param profileUrl
	* The ProfileUrl
	*/
	public void setProfileUrl(String profileUrl) {
	this.profileUrl = profileUrl;
	}

	/**
	* 
	* @return
	* The homeTown
	*/
	public String getHomeTown() {
	return homeTown;
	}

	/**
	* 
	* @param homeTown
	* The HomeTown
	*/
	public void setHomeTown(String homeTown) {
	this.homeTown = homeTown;
	}

	/**
	* 
	* @return
	* The state
	*/
	public String getState() {
	return state;
	}

	/**
	* 
	* @param state
	* The State
	*/
	public void setState(String state) {
	this.state = state;
	}

	/**
	* 
	* @return
	* The city
	*/
	public String getCity() {
	return city;
	}

	/**
	* 
	* @param city
	* The City
	*/
	public void setCity(String city) {
	this.city = city;
	}

	/**
	* 
	* @return
	* The industry
	*/
	public String getIndustry() {
	return industry;
	}

	/**
	* 
	* @param industry
	* The Industry
	*/
	public void setIndustry(String industry) {
	this.industry = industry;
	}

	/**
	* 
	* @return
	* The about
	*/
	public String getAbout() {
	return about;
	}

	/**
	* 
	* @param about
	* The About
	*/
	public void setAbout(String about) {
	this.about = about;
	}

	/**
	* 
	* @return
	* The timeZone
	*/
	public String getTimeZone() {
	return timeZone;
	}

	/**
	* 
	* @param timeZone
	* The TimeZone
	*/
	public void setTimeZone(String timeZone) {
	this.timeZone = timeZone;
	}

	/**
	* 
	* @return
	* The localLanguage
	*/
	public String getLocalLanguage() {
	return localLanguage;
	}

	/**
	* 
	* @param localLanguage
	* The LocalLanguage
	*/
	public void setLocalLanguage(String localLanguage) {
	this.localLanguage = localLanguage;
	}

	/**
	* 
	* @return
	* The coverPhoto
	*/
	public String getCoverPhoto() {
	return coverPhoto;
	}

	/**
	* 
	* @param coverPhoto
	* The CoverPhoto
	*/
	public void setCoverPhoto(String coverPhoto) {
	this.coverPhoto = coverPhoto;
	}

	/**
	* 
	* @return
	* The tagLine
	*/
	public String getTagLine() {
	return tagLine;
	}

	/**
	* 
	* @param tagLine
	* The TagLine
	*/
	public void setTagLine(String tagLine) {
	this.tagLine = tagLine;
	}

	/**
	* 
	* @return
	* The language
	*/
	public String getLanguage() {
	return language;
	}

	/**
	* 
	* @param language
	* The Language
	*/
	public void setLanguage(String language) {
	this.language = language;
	}

	/**
	* 
	* @return
	* The verified
	*/
	public String getVerified() {
	return verified;
	}

	/**
	* 
	* @param verified
	* The Verified
	*/
	public void setVerified(String verified) {
	this.verified = verified;
	}

	/**
	* 
	* @return
	* The updatedTime
	*/
	public String getUpdatedTime() {
	return updatedTime;
	}

	/**
	* 
	* @param updatedTime
	* The UpdatedTime
	*/
	public void setUpdatedTime(String updatedTime) {
	this.updatedTime = updatedTime;
	}

	/**
	* 
	* @return
	* The positions
	*/
	public String getPositions() {
	return positions;
	}

	/**
	* 
	* @param positions
	* The Positions
	*/
	public void setPositions(String positions) {
	this.positions = positions;
	}

	/**
	* 
	* @return
	* The educations
	*/
	public String getEducations() {
	return educations;
	}

	/**
	* 
	* @param educations
	* The Educations
	*/
	public void setEducations(String educations) {
	this.educations = educations;
	}

	/**
	* 
	* @return
	* The phoneNumbers
	*/
	public String getPhoneNumbers() {
	return phoneNumbers;
	}

	/**
	* 
	* @param phoneNumbers
	* The PhoneNumbers
	*/
	public void setPhoneNumbers(String phoneNumbers) {
	this.phoneNumbers = phoneNumbers;
	}

	/**
	* 
	* @return
	* The iMAccounts
	*/
	public String getIMAccounts() {
	return iMAccounts;
	}

	/**
	* 
	* @param iMAccounts
	* The IMAccounts
	*/
	public void setIMAccounts(String iMAccounts) {
	this.iMAccounts = iMAccounts;
	}

	/**
	* 
	* @return
	* The addresses
	*/
	public String getAddresses() {
	return addresses;
	}

	/**
	* 
	* @param addresses
	* The Addresses
	*/
	public void setAddresses(String addresses) {
	this.addresses = addresses;
	}

	/**
	* 
	* @return
	* The mainAddress
	*/
	public String getMainAddress() {
	return mainAddress;
	}

	/**
	* 
	* @param mainAddress
	* The MainAddress
	*/
	public void setMainAddress(String mainAddress) {
	this.mainAddress = mainAddress;
	}

	/**
	* 
	* @return
	* The created
	*/
	public String getCreated() {
	return created;
	}

	/**
	* 
	* @param created
	* The Created
	*/
	public void setCreated(String created) {
	this.created = created;
	}

	/**
	* 
	* @return
	* The localCity
	*/
	public String getLocalCity() {
	return localCity;
	}

	/**
	* 
	* @param localCity
	* The LocalCity
	*/
	public void setLocalCity(String localCity) {
	this.localCity = localCity;
	}

	/**
	* 
	* @return
	* The profileCity
	*/
	public String getProfileCity() {
	return profileCity;
	}

	/**
	* 
	* @param profileCity
	* The ProfileCity
	*/
	public void setProfileCity(String profileCity) {
	this.profileCity = profileCity;
	}

	/**
	* 
	* @return
	* The localCountry
	*/
	public String getLocalCountry() {
	return localCountry;
	}

	/**
	* 
	* @param localCountry
	* The LocalCountry
	*/
	public void setLocalCountry(String localCountry) {
	this.localCountry = localCountry;
	}

	/**
	* 
	* @return
	* The profileCountry
	*/
	public String getProfileCountry() {
	return profileCountry;
	}

	/**
	* 
	* @param profileCountry
	* The ProfileCountry
	*/
	public void setProfileCountry(String profileCountry) {
	this.profileCountry = profileCountry;
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
	public String getRelationshipStatus() {
	return relationshipStatus;
	}

	/**
	* 
	* @param relationshipStatus
	* The RelationshipStatus
	*/
	public void setRelationshipStatus(String relationshipStatus) {
	this.relationshipStatus = relationshipStatus;
	}

	/**
	* 
	* @return
	* The quote
	*/
	public String getQuote() {
	return quote;
	}

	/**
	* 
	* @param quote
	* The Quote
	*/
	public void setQuote(String quote) {
	this.quote = quote;
	}

	/**
	* 
	* @return
	* The interestedIn
	*/
	public String getInterestedIn() {
	return interestedIn;
	}

	/**
	* 
	* @param interestedIn
	* The InterestedIn
	*/
	public void setInterestedIn(String interestedIn) {
	this.interestedIn = interestedIn;
	}

	/**
	* 
	* @return
	* The interests
	*/
	public String getInterests() {
	return interests;
	}

	/**
	* 
	* @param interests
	* The Interests
	*/
	public void setInterests(String interests) {
	this.interests = interests;
	}

	/**
	* 
	* @return
	* The religion
	*/
	public String getReligion() {
	return religion;
	}

	/**
	* 
	* @param religion
	* The Religion
	*/
	public void setReligion(String religion) {
	this.religion = religion;
	}

	/**
	* 
	* @return
	* The political
	*/
	public String getPolitical() {
	return political;
	}

	/**
	* 
	* @param political
	* The Political
	*/
	public void setPolitical(String political) {
	this.political = political;
	}

	/**
	* 
	* @return
	* The sports
	*/
	public String getSports() {
	return sports;
	}

	/**
	* 
	* @param sports
	* The Sports
	*/
	public void setSports(String sports) {
	this.sports = sports;
	}

	/**
	* 
	* @return
	* The inspirationalPeople
	*/
	public String getInspirationalPeople() {
	return inspirationalPeople;
	}

	/**
	* 
	* @param inspirationalPeople
	* The InspirationalPeople
	*/
	public void setInspirationalPeople(String inspirationalPeople) {
	this.inspirationalPeople = inspirationalPeople;
	}

	/**
	* 
	* @return
	* The httpsImageUrl
	*/
	public String getHttpsImageUrl() {
	return httpsImageUrl;
	}

	/**
	* 
	* @param httpsImageUrl
	* The HttpsImageUrl
	*/
	public void setHttpsImageUrl(String httpsImageUrl) {
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
	public String getIsGeoEnabled() {
	return isGeoEnabled;
	}

	/**
	* 
	* @param isGeoEnabled
	* The IsGeoEnabled
	*/
	public void setIsGeoEnabled(String isGeoEnabled) {
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
	public String getAssociations() {
	return associations;
	}

	/**
	* 
	* @param associations
	* The Associations
	*/
	public void setAssociations(String associations) {
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
	public String getHonors() {
	return honors;
	}

	/**
	* 
	* @param honors
	* The Honors
	*/
	public void setHonors(String honors) {
	this.honors = honors;
	}

	/**
	* 
	* @return
	* The awards
	*/
	public String getAwards() {
	return awards;
	}

	/**
	* 
	* @param awards
	* The Awards
	*/
	public void setAwards(String awards) {
	this.awards = awards;
	}

	/**
	* 
	* @return
	* The skills
	*/
	public String getSkills() {
	return skills;
	}

	/**
	* 
	* @param skills
	* The Skills
	*/
	public void setSkills(String skills) {
	this.skills = skills;
	}

	/**
	* 
	* @return
	* The currentStatus
	*/
	public String getCurrentStatus() {
	return currentStatus;
	}

	/**
	* 
	* @param currentStatus
	* The CurrentStatus
	*/
	public void setCurrentStatus(String currentStatus) {
	this.currentStatus = currentStatus;
	}

	/**
	* 
	* @return
	* The certifications
	*/
	public String getCertifications() {
	return certifications;
	}

	/**
	* 
	* @param certifications
	* The Certifications
	*/
	public void setCertifications(String certifications) {
	this.certifications = certifications;
	}

	/**
	* 
	* @return
	* The courses
	*/
	public String getCourses() {
	return courses;
	}

	/**
	* 
	* @param courses
	* The Courses
	*/
	public void setCourses(String courses) {
	this.courses = courses;
	}

	/**
	* 
	* @return
	* The volunteer
	*/
	public String getVolunteer() {
	return volunteer;
	}

	/**
	* 
	* @param volunteer
	* The Volunteer
	*/
	public void setVolunteer(String volunteer) {
	this.volunteer = volunteer;
	}

	/**
	* 
	* @return
	* The recommendationsReceived
	*/
	public String getRecommendationsReceived() {
	return recommendationsReceived;
	}

	/**
	* 
	* @param recommendationsReceived
	* The RecommendationsReceived
	*/
	public void setRecommendationsReceived(String recommendationsReceived) {
	this.recommendationsReceived = recommendationsReceived;
	}

	/**
	* 
	* @return
	* The languages
	*/
	public String getLanguages() {
	return languages;
	}

	/**
	* 
	* @param languages
	* The Languages
	*/
	public void setLanguages(String languages) {
	this.languages = languages;
	}

	/**
	* 
	* @return
	* The projects
	*/
	public String getProjects() {
	return projects;
	}

	/**
	* 
	* @param projects
	* The Projects
	*/
	public void setProjects(String projects) {
	this.projects = projects;
	}

	/**
	* 
	* @return
	* The games
	*/
	public String getGames() {
	return games;
	}

	/**
	* 
	* @param games
	* The Games
	*/
	public void setGames(String games) {
	this.games = games;
	}

	/**
	* 
	* @return
	* The family
	*/
	public String getFamily() {
	return family;
	}

	/**
	* 
	* @param family
	* The Family
	*/
	public void setFamily(String family) {
	this.family = family;
	}

	/**
	* 
	* @return
	* The teleVisionShow
	*/
	public String getTeleVisionShow() {
	return teleVisionShow;
	}

	/**
	* 
	* @param teleVisionShow
	* The TeleVisionShow
	*/
	public void setTeleVisionShow(String teleVisionShow) {
	this.teleVisionShow = teleVisionShow;
	}

	/**
	* 
	* @return
	* The mutualFriends
	*/
	public String getMutualFriends() {
	return mutualFriends;
	}

	/**
	* 
	* @param mutualFriends
	* The MutualFriends
	*/
	public void setMutualFriends(String mutualFriends) {
	this.mutualFriends = mutualFriends;
	}

	/**
	* 
	* @return
	* The movies
	*/
	public String getMovies() {
	return movies;
	}

	/**
	* 
	* @param movies
	* The Movies
	*/
	public void setMovies(String movies) {
	this.movies = movies;
	}

	/**
	* 
	* @return
	* The books
	*/
	public String getBooks() {
	return books;
	}

	/**
	* 
	* @param books
	* The Books
	*/
	public void setBooks(String books) {
	this.books = books;
	}

	/**
	* 
	* @return
	* The ageRange
	*/
	public AgeRange getAgeRange() {
	return ageRange;
	}

	/**
	* 
	* @param ageRange
	* The AgeRange
	*/
	public void setAgeRange(AgeRange ageRange) {
	this.ageRange = ageRange;
	}

	/**
	* 
	* @return
	* The publicRepository
	*/
	public String getPublicRepository() {
	return publicRepository;
	}

	/**
	* 
	* @param publicRepository
	* The PublicRepository
	*/
	public void setPublicRepository(String publicRepository) {
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
	public String getRepositoryUrl() {
	return repositoryUrl;
	}

	/**
	* 
	* @param repositoryUrl
	* The RepositoryUrl
	*/
	public void setRepositoryUrl(String repositoryUrl) {
	this.repositoryUrl = repositoryUrl;
	}

	/**
	* 
	* @return
	* The age
	*/
	public String getAge() {
	return age;
	}

	/**
	* 
	* @param age
	* The Age
	*/
	public void setAge(String age) {
	this.age = age;
	}

	/**
	* 
	* @return
	* The patents
	*/
	public String getPatents() {
	return patents;
	}

	/**
	* 
	* @param patents
	* The Patents
	*/
	public void setPatents(String patents) {
	this.patents = patents;
	}

	/**
	* 
	* @return
	* The favoriteThings
	*/
	public String getFavoriteThings() {
	return favoriteThings;
	}

	/**
	* 
	* @param favoriteThings
	* The FavoriteThings
	*/
	public void setFavoriteThings(String favoriteThings) {
	this.favoriteThings = favoriteThings;
	}

	/**
	* 
	* @return
	* The professionalHeadline
	*/
	public String getProfessionalHeadline() {
	return professionalHeadline;
	}

	/**
	* 
	* @param professionalHeadline
	* The ProfessionalHeadline
	*/
	public void setProfessionalHeadline(String professionalHeadline) {
	this.professionalHeadline = professionalHeadline;
	}

	/**
	* 
	* @return
	* The relatedProfileViews
	*/
	public String getRelatedProfileViews() {
	return relatedProfileViews;
	}

	/**
	* 
	* @param relatedProfileViews
	* The RelatedProfileViews
	*/
	public void setRelatedProfileViews(String relatedProfileViews) {
	this.relatedProfileViews = relatedProfileViews;
	}

	/**
	* 
	* @return
	* The kloutScore
	*/
	public KloutScore getKloutScore() {
	return kloutScore;
	}

	/**
	* 
	* @param kloutScore
	* The KloutScore
	*/
	public void setKloutScore(KloutScore kloutScore) {
	this.kloutScore = kloutScore;
	}

	/**
	* 
	* @return
	* The lRUserID
	*/
	public String getLRUserID() {
	return lRUserID;
	}

	/**
	* 
	* @param lRUserID
	* The LRUserID
	*/
	public void setLRUserID(String lRUserID) {
	this.lRUserID = lRUserID;
	}

	/**
	* 
	* @return
	* The placesLived
	*/
	public String getPlacesLived() {
	return placesLived;
	}

	/**
	* 
	* @param placesLived
	* The PlacesLived
	*/
	public void setPlacesLived(String placesLived) {
	this.placesLived = placesLived;
	}

	/**
	* 
	* @return
	* The publications
	*/
	public String getPublications() {
	return publications;
	}

	/**
	* 
	* @param publications
	* The Publications
	*/
	public void setPublications(String publications) {
	this.publications = publications;
	}

	/**
	* 
	* @return
	* The jobBookmarks
	*/
	public String getJobBookmarks() {
	return jobBookmarks;
	}

	/**
	* 
	* @param jobBookmarks
	* The JobBookmarks
	*/
	public void setJobBookmarks(String jobBookmarks) {
	this.jobBookmarks = jobBookmarks;
	}

	/**
	* 
	* @return
	* The suggestions
	*/
	public String getSuggestions() {
	return suggestions;
	}

	/**
	* 
	* @param suggestions
	* The Suggestions
	*/
	public void setSuggestions(String suggestions) {
	this.suggestions = suggestions;
	}

	/**
	* 
	* @return
	* The badges
	*/
	public String getBadges() {
	return badges;
	}

	/**
	* 
	* @param badges
	* The Badges
	*/
	public void setBadges(String badges) {
	this.badges = badges;
	}

	/**
	* 
	* @return
	* The memberUrlResources
	*/
	public String getMemberUrlResources() {
	return memberUrlResources;
	}

	/**
	* 
	* @param memberUrlResources
	* The MemberUrlResources
	*/
	public void setMemberUrlResources(String memberUrlResources) {
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
	public String getCurrency() {
	return currency;
	}

	/**
	* 
	* @param currency
	* The Currency
	*/
	public void setCurrency(String currency) {
	this.currency = currency;
	}

	/**
	* 
	* @return
	* The starredUrl
	*/
	public String getStarredUrl() {
	return starredUrl;
	}

	/**
	* 
	* @param starredUrl
	* The StarredUrl
	*/
	public void setStarredUrl(String starredUrl) {
	this.starredUrl = starredUrl;
	}

	/**
	* 
	* @return
	* The gistsUrl
	*/
	public String getGistsUrl() {
	return gistsUrl;
	}

	/**
	* 
	* @param gistsUrl
	* The GistsUrl
	*/
	public void setGistsUrl(String gistsUrl) {
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
	public Subscription getSubscription() {
	return subscription;
	}

	/**
	* 
	* @param subscription
	* The Subscription
	*/
	public void setSubscription(Subscription subscription) {
	this.subscription = subscription;
	}

	/**
	* 
	* @return
	* The company
	*/
	public String getCompany() {
	return company;
	}

	/**
	* 
	* @param company
	* The Company
	*/
	public void setCompany(String company) {
	this.company = company;
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
	* The previousUids
	*/
	public List<String> getPreviousUids() {
	return previousUids;
	}

	/**
	* 
	* @param previousUids
	* The PreviousUids
	*/
	public void setPreviousUids(List<String> previousUids) {
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
	* The securityQuestionAnswer
	*/
	public Object getSecurityQuestionAnswer() {
	return securityQuestionAnswer;
	}

	/**
	* 
	* @param securityQuestionAnswer
	* The SecurityQuestionAnswer
	*/
	public void setSecurityQuestionAnswer(Object securityQuestionAnswer) {
	this.securityQuestionAnswer = securityQuestionAnswer;
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

}
