/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	/**
	 * Model Class containing Definition of payload for Auth User Registration API
	 */
	public class AuthUserRegistrationModel {
	
		
		@SerializedName("About")
        private String about;
		
		@SerializedName("AcceptPrivacyPolicy")
        private Boolean acceptPrivacyPolicy;
		
		@SerializedName("Addresses")
        private List<Address> addresses;
		
		@SerializedName("Age")
        private String age;
		
		@SerializedName("AgeRange")
        private AgeRange ageRange;
		
		@SerializedName("Associations")
        private String associations;
		
		@SerializedName("Awards")
        private List<Awards> awards;
		
		@SerializedName("Badges")
        private List<Badges> badges;
		
		@SerializedName("BirthDate")
        private String birthDate;
		
		@SerializedName("Books")
        private List<Books> books;
		
		@SerializedName("Certifications")
        private List<Certifications> certifications;
		
		@SerializedName("City")
        private String city;
		
		@SerializedName("Company")
        private String company;
		
		@SerializedName("Consents")
        private ConsentSubmitModel consents;
		
		@SerializedName("Country")
        private Country country;
		
		@SerializedName("Courses")
        private List<Courses> courses;
		
		@SerializedName("CoverPhoto")
        private String coverPhoto;
		
		@SerializedName("Currency")
        private String currency;
		
		@SerializedName("CurrentStatus")
        private List<CurrentStatus> currentStatus;
		
		@SerializedName("CustomFields")
        private Map<String,String> customFields;
		
		@SerializedName("Educations")
        private List<Education> educations;
		
		@SerializedName("Email")
        private List<EmailModel> email;
		
		@SerializedName("ExternalUserLoginId")
        private String externalUserLoginId;
		
		@SerializedName("Family")
        private List<Family> family;
		
		@SerializedName("Favicon")
        private String favicon;
		
		@SerializedName("FavoriteThings")
        private List<FavoriteThings> favoriteThings;
		
		@SerializedName("FirstName")
        private String firstName;
		
		@SerializedName("FollowersCount")
        private Integer followersCount;
		
		@SerializedName("FriendsCount")
        private Integer friendsCount;
		
		@SerializedName("FullName")
        private String fullName;
		
		@SerializedName("Games")
        private List<Games> games;
		
		@SerializedName("Gender")
        private String gender;
		
		@SerializedName("GistsUrl")
        private String gistsUrl;
		
		@SerializedName("GravatarImageUrl")
        private String gravatarImageUrl;
		
		@SerializedName("Hireable")
        private Boolean hireable;
		
		@SerializedName("HomeTown")
        private String homeTown;
		
		@SerializedName("Honors")
        private String honors;
		
		@SerializedName("HttpsImageUrl")
        private String httpsImageUrl;
		
		@SerializedName("IMAccounts")
        private List<IMAccount> iMAccounts;
		
		@SerializedName("ImageUrl")
        private String imageUrl;
		
		@SerializedName("Industry")
        private String industry;
		
		@SerializedName("InspirationalPeople")
        private List<InspirationalPeople> inspirationalPeople;
		
		@SerializedName("InterestedIn")
        private List<String> interestedIn;
		
		@SerializedName("Interests")
        private List<Interests> interests;
		
		@SerializedName("IsEmailSubscribed")
        private Boolean isEmailSubscribed;
		
		@SerializedName("IsGeoEnabled")
        private String isGeoEnabled;
		
		@SerializedName("IsProtected")
        private Boolean isProtected;
		
		@SerializedName("IsTwoFactorAuthenticationEnabled")
        private Boolean isTwoFactorAuthenticationEnabled;
		
		@SerializedName("JobBookmarks")
        private List<JobBookmarks> jobBookmarks;
		
		@SerializedName("Languages")
        private List<Languages> languages;
		
		@SerializedName("LastName")
        private String lastName;
		
		@SerializedName("LocalCity")
        private String localCity;
		
		@SerializedName("LocalCountry")
        private String localCountry;
		
		@SerializedName("LocalLanguage")
        private String localLanguage;
		
		@SerializedName("MainAddress")
        private String mainAddress;
		
		@SerializedName("MemberUrlResources")
        private List<Memberurlresources> memberUrlResources;
		
		@SerializedName("MiddleName")
        private String middleName;
		
		@SerializedName("Movies")
        private List<Movies> movies;
		
		@SerializedName("MutualFriends")
        private List<MutualFriends> mutualFriends;
		
		@SerializedName("NickName")
        private String nickName;
		
		@SerializedName("NumRecommenders")
        private Integer numRecommenders;
		
		@SerializedName("Password")
        private String password;
		
		@SerializedName("Patents")
        private List<Patents> patents;
		
		@SerializedName("PhoneId")
        private String phoneId;
		
		@SerializedName("PhoneNumbers")
        private List<Phone> phoneNumbers;
		
		@SerializedName("PINInfo")
        private PINModel pinInfo;
		
		@SerializedName("PlacesLived")
        private List<PlacesLived> placesLived;
		
		@SerializedName("Political")
        private String political;
		
		@SerializedName("Positions")
        private List<ProfessionalPosition> positions;
		
		@SerializedName("Prefix")
        private String prefix;
		
		@SerializedName("PrivateGists")
        private Integer privateGists;
		
		@SerializedName("ProfessionalHeadline")
        private String professionalHeadline;
		
		@SerializedName("ProfileCity")
        private String profileCity;
		
		@SerializedName("ProfileCountry")
        private String profileCountry;
		
		@SerializedName("ProfileImageUrls")
        private Map<String,String> profileImageUrls;
		
		@SerializedName("ProfileName")
        private String profileName;
		
		@SerializedName("ProfileUrl")
        private String profileUrl;
		
		@SerializedName("Projects")
        private List<Projects> projects;
		
		@SerializedName("ProviderAccessCredential")
        private ProviderAccessCredential providerAccessCredential;
		
		@SerializedName("Publications")
        private List<Publications> publications;
		
		@SerializedName("PublicGists")
        private Integer publicGists;
		
		@SerializedName("PublicRepository")
        private String publicRepository;
		
		@SerializedName("Quota")
        private String quota;
		
		@SerializedName("RecommendationsReceived")
        private List<RecommendationsReceived> recommendationsReceived;
		
		@SerializedName("RelatedProfileViews")
        private List<RelatedProfileViews> relatedProfileViews;
		
		@SerializedName("RelationshipStatus")
        private String relationshipStatus;
		
		@SerializedName("Religion")
        private String religion;
		
		@SerializedName("RepositoryUrl")
        private String repositoryUrl;
		
		@SerializedName("SecurityQuestionAnswer")
        private Map<String,String> securityQuestionAnswer;
		
		@SerializedName("Skills")
        private List<Skills> skills;
		
		@SerializedName("Sports")
        private List<Sports> sports;
		
		@SerializedName("StarredUrl")
        private String starredUrl;
		
		@SerializedName("State")
        private String state;
		
		@SerializedName("Subscription")
        private GitHubPlan subscription;
		
		@SerializedName("Suffix")
        private String suffix;
		
		@SerializedName("Suggestions")
        private Suggestions suggestions;
		
		@SerializedName("TagLine")
        private String tagLine;
		
		@SerializedName("TeleVisionShow")
        private List<Television> teleVisionShow;
		
		@SerializedName("ThumbnailImageUrl")
        private String thumbnailImageUrl;
		
		@SerializedName("TimeZone")
        private String timeZone;
		
		@SerializedName("TotalPrivateRepository")
        private Integer totalPrivateRepository;
		
		@SerializedName("TotalStatusesCount")
        private Integer totalStatusesCount;
		
		@SerializedName("Uid")
        private String uid;
		
		@SerializedName("UserName")
        private String userName;
		
		@SerializedName("Volunteer")
        private List<Volunteer> volunteer;
		
		@SerializedName("WebProfiles")
        private Map<String,String> webProfiles;
		
		@SerializedName("Website")
        private String website;



		/**
		 * About value that need to be inserted
		 */
		public String getAbout() {
			return about;
		}
		/**
		 * About value that need to be inserted
		 */
		public void setAbout(String about) {
			this.about = about;
		}
		/**
		 * caption to accept the privacy policy
		 */
		public Boolean getAcceptPrivacyPolicy() {
			return acceptPrivacyPolicy;
		}
		/**
		 * caption to accept the privacy policy
		 */
		public void setAcceptPrivacyPolicy(Boolean acceptPrivacyPolicy) {
			this.acceptPrivacyPolicy = acceptPrivacyPolicy;
		}
		/**
		 * Array of objects,String represents address of user
		 */
		public List<Address> getAddresses() {
			return addresses;
		}
		/**
		 * Array of objects,String represents address of user
		 */
		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}
		/**
		 * User's Age
		 */
		public String getAge() {
			return age;
		}
		/**
		 * User's Age
		 */
		public void setAge(String age) {
			this.age = age;
		}
		/**
		 * user's age range.
		 */
		public AgeRange getAgeRange() {
			return ageRange;
		}
		/**
		 * user's age range.
		 */
		public void setAgeRange(AgeRange ageRange) {
			this.ageRange = ageRange;
		}
		/**
		 * Organization a person is assosciated with
		 */
		public String getAssociations() {
			return associations;
		}
		/**
		 * Organization a person is assosciated with
		 */
		public void setAssociations(String associations) {
			this.associations = associations;
		}
		/**
		 * Array of Objects,String represents Id, Name and  Issuer
		 */
		public List<Awards> getAwards() {
			return awards;
		}
		/**
		 * Array of Objects,String represents Id, Name and  Issuer
		 */
		public void setAwards(List<Awards> awards) {
			this.awards = awards;
		}
		/**
		 * User's Badges.
		 */
		public List<Badges> getBadges() {
			return badges;
		}
		/**
		 * User's Badges.
		 */
		public void setBadges(List<Badges> badges) {
			this.badges = badges;
		}
		/**
		 * user's birthdate
		 */
		public String getBirthDate() {
			return birthDate;
		}
		/**
		 * user's birthdate
		 */
		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}
		/**
		 * Array of Objects,String represents Id,Name,Category,CreatedDate
		 */
		public List<Books> getBooks() {
			return books;
		}
		/**
		 * Array of Objects,String represents Id,Name,Category,CreatedDate
		 */
		public void setBooks(List<Books> books) {
			this.books = books;
		}
		/**
		 * Array of Objects,string represents Id,Name,Authority Number,StartDate,EndDate
		 */
		public List<Certifications> getCertifications() {
			return certifications;
		}
		/**
		 * Array of Objects,string represents Id,Name,Authority Number,StartDate,EndDate
		 */
		public void setCertifications(List<Certifications> certifications) {
			this.certifications = certifications;
		}
		/**
		 * user's city
		 */
		public String getCity() {
			return city;
		}
		/**
		 * user's city
		 */
		public void setCity(String city) {
			this.city = city;
		}
		/**
		 * users company name
		 */
		public String getCompany() {
			return company;
		}
		/**
		 * users company name
		 */
		public void setCompany(String company) {
			this.company = company;
		}
		/**
		 * List of Consents
		 */
		public ConsentSubmitModel getConsents() {
			return consents;
		}
		/**
		 * List of Consents
		 */
		public void setConsents(ConsentSubmitModel consents) {
			this.consents = consents;
		}
		/**
		 * Country of the user
		 */
		public Country getCountry() {
			return country;
		}
		/**
		 * Country of the user
		 */
		public void setCountry(Country country) {
			this.country = country;
		}
		/**
		 * users course information
		 */
		public List<Courses> getCourses() {
			return courses;
		}
		/**
		 * users course information
		 */
		public void setCourses(List<Courses> courses) {
			this.courses = courses;
		}
		/**
		 * URL of the photo that need to be inserted
		 */
		public String getCoverPhoto() {
			return coverPhoto;
		}
		/**
		 * URL of the photo that need to be inserted
		 */
		public void setCoverPhoto(String coverPhoto) {
			this.coverPhoto = coverPhoto;
		}
		/**
		 * Currency
		 */
		public String getCurrency() {
			return currency;
		}
		/**
		 * Currency
		 */
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		/**
		 * Array of Objects,String represents  id ,Text ,Source  and CreatedDate
		 */
		public List<CurrentStatus> getCurrentStatus() {
			return currentStatus;
		}
		/**
		 * Array of Objects,String represents  id ,Text ,Source  and CreatedDate
		 */
		public void setCurrentStatus(List<CurrentStatus> currentStatus) {
			this.currentStatus = currentStatus;
		}
		/**
		 * Custom fields as user set on LoginRadius Admin Console.
		 */
		public Map<String,String> getCustomFields() {
			return customFields;
		}
		/**
		 * Custom fields as user set on LoginRadius Admin Console.
		 */
		public void setCustomFields(Map<String,String> customFields) {
			this.customFields = customFields;
		}
		/**
		 * Array of Objects,which represents the educations record
		 */
		public List<Education> getEducations() {
			return educations;
		}
		/**
		 * Array of Objects,which represents the educations record
		 */
		public void setEducations(List<Education> educations) {
			this.educations = educations;
		}
		/**
		 * boolean type value, default is true
		 */
		public List<EmailModel> getEmail() {
			return email;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setEmail(List<EmailModel> email) {
			this.email = email;
		}
		/**
		 * External User Login Id
		 */
		public String getExternalUserLoginId() {
			return externalUserLoginId;
		}
		/**
		 * External User Login Id
		 */
		public void setExternalUserLoginId(String externalUserLoginId) {
			this.externalUserLoginId = externalUserLoginId;
		}
		/**
		 * user's family
		 */
		public List<Family> getFamily() {
			return family;
		}
		/**
		 * user's family
		 */
		public void setFamily(List<Family> family) {
			this.family = family;
		}
		/**
		 * URL of the favicon that need to be inserted
		 */
		public String getFavicon() {
			return favicon;
		}
		/**
		 * URL of the favicon that need to be inserted
		 */
		public void setFavicon(String favicon) {
			this.favicon = favicon;
		}
		/**
		 * Array of Objects,strings represents	Id ,Name ,Type
		 */
		public List<FavoriteThings> getFavoriteThings() {
			return favoriteThings;
		}
		/**
		 * Array of Objects,strings represents	Id ,Name ,Type
		 */
		public void setFavoriteThings(List<FavoriteThings> favoriteThings) {
			this.favoriteThings = favoriteThings;
		}
		/**
		 * user's first name
		 */
		public String getFirstName() {
			return firstName;
		}
		/**
		 * user's first name
		 */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		/**
		 * user's followers count
		 */
		public Integer getFollowersCount() {
			return followersCount;
		}
		/**
		 * user's followers count
		 */
		public void setFollowersCount(Integer followersCount) {
			this.followersCount = followersCount;
		}
		/**
		 * users friends count
		 */
		public Integer getFriendsCount() {
			return friendsCount;
		}
		/**
		 * users friends count
		 */
		public void setFriendsCount(Integer friendsCount) {
			this.friendsCount = friendsCount;
		}
		/**
		 * Users complete name
		 */
		public String getFullName() {
			return fullName;
		}
		/**
		 * Users complete name
		 */
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		/**
		 * Array of Objects,string represents Id,Name,Category,CreatedDate
		 */
		public List<Games> getGames() {
			return games;
		}
		/**
		 * Array of Objects,string represents Id,Name,Category,CreatedDate
		 */
		public void setGames(List<Games> games) {
			this.games = games;
		}
		/**
		 * user's gender
		 */
		public String getGender() {
			return gender;
		}
		/**
		 * user's gender
		 */
		public void setGender(String gender) {
			this.gender = gender;
		}
		/**
		 */
		//	
		/**
		 */
		public String getGistsUrl() {
			return gistsUrl;
		}
		/**
		 */
		//	
		/**
		 */
		public void setGistsUrl(String gistsUrl) {
			this.gistsUrl = gistsUrl;
		}
		/**
		 */
		//	URL of image that need to be inserted
		/**
		 */
		public String getGravatarImageUrl() {
			return gravatarImageUrl;
		}
		/**
		 */
		//	URL of image that need to be inserted
		/**
		 */
		public void setGravatarImageUrl(String gravatarImageUrl) {
			this.gravatarImageUrl = gravatarImageUrl;
		}
		/**
		 */
		//	boolean type value, default value is true
		/**
		 */
		public Boolean getHireable() {
			return hireable;
		}
		/**
		 */
		//	boolean type value, default value is true
		/**
		 */
		public void setHireable(Boolean hireable) {
			this.hireable = hireable;
		}
		/**
		 */
		//	user's home town name
		/**
		 */
		public String getHomeTown() {
			return homeTown;
		}
		/**
		 */
		//	user's home town name
		/**
		 */
		public void setHomeTown(String homeTown) {
			this.homeTown = homeTown;
		}
		/**
		 */
		//	Awards lists from the social provider
		/**
		 */
		public String getHonors() {
			return honors;
		}
		/**
		 */
		//	Awards lists from the social provider
		/**
		 */
		public void setHonors(String honors) {
			this.honors = honors;
		}
		/**
		 */
		//	URL of the Image that need to be inserted
		/**
		 */
		public String getHttpsImageUrl() {
			return httpsImageUrl;
		}
		/**
		 */
		//	URL of the Image that need to be inserted
		/**
		 */
		public void setHttpsImageUrl(String httpsImageUrl) {
			this.httpsImageUrl = httpsImageUrl;
		}
		/**
		 */
		//	Array of objects, String represents account type and account name.
		/**
		 */
		public List<IMAccount> getIMAccounts() {
			return iMAccounts;
		}
		/**
		 */
		//	Array of objects, String represents account type and account name.
		/**
		 */
		public void setIMAccounts(List<IMAccount> iMAccounts) {
			this.iMAccounts = iMAccounts;
		}
		/**
		 */
		//	image URL should be absolute and has HTTPS domain
		/**
		 */
		public String getImageUrl() {
			return imageUrl;
		}
		/**
		 */
		//	image URL should be absolute and has HTTPS domain
		/**
		 */
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		/**
		 */
		//	Industry name
		/**
		 */
		public String getIndustry() {
			return industry;
		}
		/**
		 */
		//	Industry name
		/**
		 */
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		/**
		 */
		//	Array of Objects,string represents Id and Name
		/**
		 */
		public List<InspirationalPeople> getInspirationalPeople() {
			return inspirationalPeople;
		}
		/**
		 */
		//	Array of Objects,string represents Id and Name
		/**
		 */
		public void setInspirationalPeople(List<InspirationalPeople> inspirationalPeople) {
			this.inspirationalPeople = inspirationalPeople;
		}
		/**
		 */
		//	array of string represents interest
		/**
		 */
		public List<String> getInterestedIn() {
			return interestedIn;
		}
		/**
		 */
		//	array of string represents interest
		/**
		 */
		public void setInterestedIn(List<String> interestedIn) {
			this.interestedIn = interestedIn;
		}
		/**
		 */
		//	Array of objects, string shows InterestedType and InterestedName
		/**
		 */
		public List<Interests> getInterests() {
			return interests;
		}
		/**
		 */
		//	Array of objects, string shows InterestedType and InterestedName
		/**
		 */
		public void setInterests(List<Interests> interests) {
			this.interests = interests;
		}
		/**
		 * boolean type value, default is true
		 */
		public Boolean getIsEmailSubscribed() {
			return isEmailSubscribed;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setIsEmailSubscribed(Boolean isEmailSubscribed) {
			this.isEmailSubscribed = isEmailSubscribed;
		}
		/**
		 * boolean type value, default is true
		 */
		public String getIsGeoEnabled() {
			return isGeoEnabled;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setIsGeoEnabled(String isGeoEnabled) {
			this.isGeoEnabled = isGeoEnabled;
		}
		/**
		 * boolean type value, default is true
		 */
		public Boolean getIsProtected() {
			return isProtected;
		}
		/**
		 * boolean type value, default is true
		 */
		public void setIsProtected(Boolean isProtected) {
			this.isProtected = isProtected;
		}
		/**
		 */
		//	boolean type value, true if MFA enables otherwise false
		/**
		 */
		public Boolean getIsTwoFactorAuthenticationEnabled() {
			return isTwoFactorAuthenticationEnabled;
		}
		/**
		 */
		//	boolean type value, true if MFA enables otherwise false
		/**
		 */
		public void setIsTwoFactorAuthenticationEnabled(Boolean isTwoFactorAuthenticationEnabled) {
			this.isTwoFactorAuthenticationEnabled = isTwoFactorAuthenticationEnabled;
		}
		/**
		 */
		//	Array of Objects,Strings,boolean,object represents IsApplied,ApplyTimestamp,IsSaved,SavedTimestamp,Job
		/**
		 */
		public List<JobBookmarks> getJobBookmarks() {
			return jobBookmarks;
		}
		/**
		 */
		//	Array of Objects,Strings,boolean,object represents IsApplied,ApplyTimestamp,IsSaved,SavedTimestamp,Job
		/**
		 */
		public void setJobBookmarks(List<JobBookmarks> jobBookmarks) {
			this.jobBookmarks = jobBookmarks;
		}
		/**
		 */
		//	language known by user's
		/**
		 */
		public List<Languages> getLanguages() {
			return languages;
		}
		/**
		 */
		//	language known by user's
		/**
		 */
		public void setLanguages(List<Languages> languages) {
			this.languages = languages;
		}
		/**
		 */
		//	user's last name
		/**
		 */
		public String getLastName() {
			return lastName;
		}
		/**
		 */
		//	user's last name
		/**
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		/**
		 */
		//	Local City of the user
		/**
		 */
		public String getLocalCity() {
			return localCity;
		}
		/**
		 */
		//	Local City of the user
		/**
		 */
		public void setLocalCity(String localCity) {
			this.localCity = localCity;
		}
		/**
		 */
		//	Local country of the user
		/**
		 */
		public String getLocalCountry() {
			return localCountry;
		}
		/**
		 */
		//	Local country of the user
		/**
		 */
		public void setLocalCountry(String localCountry) {
			this.localCountry = localCountry;
		}
		/**
		 */
		//	Local language of the user
		/**
		 */
		public String getLocalLanguage() {
			return localLanguage;
		}
		/**
		 */
		//	Local language of the user
		/**
		 */
		public void setLocalLanguage(String localLanguage) {
			this.localLanguage = localLanguage;
		}
		/**
		 */
		//	Main address of the user
		/**
		 */
		public String getMainAddress() {
			return mainAddress;
		}
		/**
		 */
		//	Main address of the user
		/**
		 */
		public void setMainAddress(String mainAddress) {
			this.mainAddress = mainAddress;
		}
		/**
		 */
		//	Array of Objects,String represents Url,UrlName
		/**
		 */
		public List<Memberurlresources> getMemberUrlResources() {
			return memberUrlResources;
		}
		/**
		 */
		//	Array of Objects,String represents Url,UrlName
		/**
		 */
		public void setMemberUrlResources(List<Memberurlresources> memberUrlResources) {
			this.memberUrlResources = memberUrlResources;
		}
		/**
		 */
		//	user's middle name
		/**
		 */
		public String getMiddleName() {
			return middleName;
		}
		/**
		 */
		//	user's middle name
		/**
		 */
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		/**
		 */
		//	Array of Objects,strings represents	Id,Name,Category,CreatedDate
		/**
		 */
		public List<Movies> getMovies() {
			return movies;
		}
		/**
		 */
		//	Array of Objects,strings represents	Id,Name,Category,CreatedDate
		/**
		 */
		public void setMovies(List<Movies> movies) {
			this.movies = movies;
		}
		/**
		 */
		//	Array of Objects, strings represents Id,Name,FirstName,LastName,Birthday,Hometown,Link,Gender
		/**
		 */
		public List<MutualFriends> getMutualFriends() {
			return mutualFriends;
		}
		/**
		 */
		//	Array of Objects, strings represents Id,Name,FirstName,LastName,Birthday,Hometown,Link,Gender
		/**
		 */
		public void setMutualFriends(List<MutualFriends> mutualFriends) {
			this.mutualFriends = mutualFriends;
		}
		/**
		 */
		//	Nick name of the user
		/**
		 */
		public String getNickName() {
			return nickName;
		}
		/**
		 */
		//	Nick name of the user
		/**
		 */
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		/**
		 */
		//	Count for the user profile recommended
		/**
		 */
		public Integer getNumRecommenders() {
			return numRecommenders;
		}
		/**
		 */
		//	Count for the user profile recommended
		/**
		 */
		public void setNumRecommenders(Integer numRecommenders) {
			this.numRecommenders = numRecommenders;
		}
		/**
		 */
		//	Password for the email
		/**
		 */
		public String getPassword() {
			return password;
		}
		/**
		 */
		//	Password for the email
		/**
		 */
		public void setPassword(String password) {
			this.password = password;
		}
		/**
		 */
		//	Patents Registered
		/**
		 */
		public List<Patents> getPatents() {
			return patents;
		}
		/**
		 */
		//	Patents Registered
		/**
		 */
		public void setPatents(List<Patents> patents) {
			this.patents = patents;
		}
		/**
		 */
		//	Phone ID (Unique Phone Number Identifier of the user)
		/**
		 */
		public String getPhoneId() {
			return phoneId;
		}
		/**
		 */
		//	Phone ID (Unique Phone Number Identifier of the user)
		/**
		 */
		public void setPhoneId(String phoneId) {
			this.phoneId = phoneId;
		}
		/**
		 */
		//	Users Phone Number
		/**
		 */
		public List<Phone> getPhoneNumbers() {
			return phoneNumbers;
		}
		/**
		 */
		//	Users Phone Number
		/**
		 */
		public void setPhoneNumbers(List<Phone> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}
		/**
		 */
		//	PIN Info
		/**
		 */
		public PINModel getPINInfo() {
			return pinInfo;
		}
		/**
		 */
		//	PIN Info
		/**
		 */
		public void setPINInfo(PINModel pinInfo) {
			this.pinInfo = pinInfo;
		}
		/**
		 */
		//	Array of Objects,strings Name and boolean IsPrimary
		/**
		 */
		public List<PlacesLived> getPlacesLived() {
			return placesLived;
		}
		/**
		 */
		//	Array of Objects,strings Name and boolean IsPrimary
		/**
		 */
		public void setPlacesLived(List<PlacesLived> placesLived) {
			this.placesLived = placesLived;
		}
		/**
		 */
		//	List of Political interest
		/**
		 */
		public String getPolitical() {
			return political;
		}
		/**
		 */
		//	List of Political interest
		/**
		 */
		public void setPolitical(String political) {
			this.political = political;
		}
		/**
		 */
		//	Array of Objects,which represents the PositionSummary,StartDate,EndDate,IsCurrent,Company,Location
		/**
		 */
		public List<ProfessionalPosition> getPositions() {
			return positions;
		}
		/**
		 */
		//	Array of Objects,which represents the PositionSummary,StartDate,EndDate,IsCurrent,Company,Location
		/**
		 */
		public void setPositions(List<ProfessionalPosition> positions) {
			this.positions = positions;
		}
		/**
		 */
		//	Prefix for FirstName
		/**
		 */
		public String getPrefix() {
			return prefix;
		}
		/**
		 */
		//	Prefix for FirstName
		/**
		 */
		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		/**
		 */
		//	user private Repository Urls
		/**
		 */
		public Integer getPrivateGists() {
			return privateGists;
		}
		/**
		 */
		//	user private Repository Urls
		/**
		 */
		public void setPrivateGists(Integer privateGists) {
			this.privateGists = privateGists;
		}
		/**
		 */
		//	This field provide by linkedin.contain our linkedin profile headline
		/**
		 */
		public String getProfessionalHeadline() {
			return professionalHeadline;
		}
		/**
		 */
		//	This field provide by linkedin.contain our linkedin profile headline
		/**
		 */
		public void setProfessionalHeadline(String professionalHeadline) {
			this.professionalHeadline = professionalHeadline;
		}
		/**
		 */
		//	ProfileCity value that need to be inserted
		/**
		 */
		public String getProfileCity() {
			return profileCity;
		}
		/**
		 */
		//	ProfileCity value that need to be inserted
		/**
		 */
		public void setProfileCity(String profileCity) {
			this.profileCity = profileCity;
		}
		/**
		 */
		//	ProfileCountry value that need to be inserted
		/**
		 */
		public String getProfileCountry() {
			return profileCountry;
		}
		/**
		 */
		//	ProfileCountry value that need to be inserted
		/**
		 */
		public void setProfileCountry(String profileCountry) {
			this.profileCountry = profileCountry;
		}
		/**
		 */
		//	ProfileImageUrls that need to be inserted
		/**
		 */
		public Map<String,String> getProfileImageUrls() {
			return profileImageUrls;
		}
		/**
		 */
		//	ProfileImageUrls that need to be inserted
		/**
		 */
		public void setProfileImageUrls(Map<String,String> profileImageUrls) {
			this.profileImageUrls = profileImageUrls;
		}
		/**
		 */
		//	ProfileName value field that need to be inserted
		/**
		 */
		public String getProfileName() {
			return profileName;
		}
		/**
		 */
		//	ProfileName value field that need to be inserted
		/**
		 */
		public void setProfileName(String profileName) {
			this.profileName = profileName;
		}
		/**
		 */
		//	User profile url like facebook profile Url
		/**
		 */
		public String getProfileUrl() {
			return profileUrl;
		}
		/**
		 */
		//	User profile url like facebook profile Url
		/**
		 */
		public void setProfileUrl(String profileUrl) {
			this.profileUrl = profileUrl;
		}
		/**
		 */
		//	Array of Objects,string represents  Id,Name,Summary With StartDate,EndDate,IsCurrent
		/**
		 */
		public List<Projects> getProjects() {
			return projects;
		}
		/**
		 */
		//	Array of Objects,string represents  Id,Name,Summary With StartDate,EndDate,IsCurrent
		/**
		 */
		public void setProjects(List<Projects> projects) {
			this.projects = projects;
		}
		/**
		 */
		//	Object,string represents AccessToken,TokenSecret
		/**
		 */
		public ProviderAccessCredential getProviderAccessCredential() {
			return providerAccessCredential;
		}
		/**
		 */
		//	Object,string represents AccessToken,TokenSecret
		/**
		 */
		public void setProviderAccessCredential(ProviderAccessCredential providerAccessCredential) {
			this.providerAccessCredential = providerAccessCredential;
		}
		/**
		 */
		//	Array of Objects,string represents Id,Title,Publisher,Authors,Date,Url,Summary
		/**
		 */
		public List<Publications> getPublications() {
			return publications;
		}
		/**
		 */
		//	Array of Objects,string represents Id,Title,Publisher,Authors,Date,Url,Summary
		/**
		 */
		public void setPublications(List<Publications> publications) {
			this.publications = publications;
		}
		/**
		 */
		//	gist is a Git repository, which means that it can be forked and cloned.
		/**
		 */
		public Integer getPublicGists() {
			return publicGists;
		}
		/**
		 */
		//	gist is a Git repository, which means that it can be forked and cloned.
		/**
		 */
		public void setPublicGists(Integer publicGists) {
			this.publicGists = publicGists;
		}
		/**
		 */
		//	user public Repository Urls
		/**
		 */
		public String getPublicRepository() {
			return publicRepository;
		}
		/**
		 */
		//	user public Repository Urls
		/**
		 */
		public void setPublicRepository(String publicRepository) {
			this.publicRepository = publicRepository;
		}
		/**
		 */
		//	Quota
		/**
		 */
		public String getQuota() {
			return quota;
		}
		/**
		 */
		//	Quota
		/**
		 */
		public void setQuota(String quota) {
			this.quota = quota;
		}
		/**
		 */
		//	Array of Objects,string represents Id,RecommendationType,RecommendationText,Recommender
		/**
		 */
		public List<RecommendationsReceived> getRecommendationsReceived() {
			return recommendationsReceived;
		}
		/**
		 */
		//	Array of Objects,string represents Id,RecommendationType,RecommendationText,Recommender
		/**
		 */
		public void setRecommendationsReceived(List<RecommendationsReceived> recommendationsReceived) {
			this.recommendationsReceived = recommendationsReceived;
		}
		/**
		 */
		//	Array of Objects,String represents Id,FirstName,LastName
		/**
		 */
		public List<RelatedProfileViews> getRelatedProfileViews() {
			return relatedProfileViews;
		}
		/**
		 */
		//	Array of Objects,String represents Id,FirstName,LastName
		/**
		 */
		public void setRelatedProfileViews(List<RelatedProfileViews> relatedProfileViews) {
			this.relatedProfileViews = relatedProfileViews;
		}
		/**
		 */
		//	user's relationship status
		/**
		 */
		public String getRelationshipStatus() {
			return relationshipStatus;
		}
		/**
		 */
		//	user's relationship status
		/**
		 */
		public void setRelationshipStatus(String relationshipStatus) {
			this.relationshipStatus = relationshipStatus;
		}
		/**
		 */
		//	String shows users religion
		/**
		 */
		public String getReligion() {
			return religion;
		}
		/**
		 */
		//	String shows users religion
		/**
		 */
		public void setReligion(String religion) {
			this.religion = religion;
		}
		/**
		 */
		//	Repository URL
		/**
		 */
		public String getRepositoryUrl() {
			return repositoryUrl;
		}
		/**
		 */
		//	Repository URL
		/**
		 */
		public void setRepositoryUrl(String repositoryUrl) {
			this.repositoryUrl = repositoryUrl;
		}
		/**
		 */
		//	Valid JSON object of Unique Security Question ID and Answer of set Security Question
		/**
		 */
		public Map<String,String> getSecurityQuestionAnswer() {
			return securityQuestionAnswer;
		}
		/**
		 */
		//	Valid JSON object of Unique Security Question ID and Answer of set Security Question
		/**
		 */
		public void setSecurityQuestionAnswer(Map<String,String> securityQuestionAnswer) {
			this.securityQuestionAnswer = securityQuestionAnswer;
		}
		/**
		 */
		//	Array of objects, String represents ID and Name
		/**
		 */
		public List<Skills> getSkills() {
			return skills;
		}
		/**
		 */
		//	Array of objects, String represents ID and Name
		/**
		 */
		public void setSkills(List<Skills> skills) {
			this.skills = skills;
		}
		/**
		 */
		//	Array of objects, String represents ID and Name
		/**
		 */
		public List<Sports> getSports() {
			return sports;
		}
		/**
		 */
		//	Array of objects, String represents ID and Name
		/**
		 */
		public void setSports(List<Sports> sports) {
			this.sports = sports;
		}
		/**
		 */
		//	Git users bookmark repositories
		/**
		 */
		public String getStarredUrl() {
			return starredUrl;
		}
		/**
		 */
		//	Git users bookmark repositories
		/**
		 */
		public void setStarredUrl(String starredUrl) {
			this.starredUrl = starredUrl;
		}
		/**
		 */
		//	State of the user
		/**
		 */
		public String getState() {
			return state;
		}
		/**
		 */
		//	State of the user
		/**
		 */
		public void setState(String state) {
			this.state = state;
		}
		/**
		 */
		//	Object,string represents Name,Space,PrivateRepos,Collaborators
		/**
		 */
		public GitHubPlan getSubscription() {
			return subscription;
		}
		/**
		 */
		//	Object,string represents Name,Space,PrivateRepos,Collaborators
		/**
		 */
		public void setSubscription(GitHubPlan subscription) {
			this.subscription = subscription;
		}
		/**
		 */
		//	Suffix for the User.
		/**
		 */
		public String getSuffix() {
			return suffix;
		}
		/**
		 */
		//	Suffix for the User.
		/**
		 */
		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
		/**
		 */
		//	Object,array of objects represents	CompaniestoFollow,IndustriestoFollow,NewssourcetoFollow,PeopletoFollow
		/**
		 */
		public Suggestions getSuggestions() {
			return suggestions;
		}
		/**
		 */
		//	Object,array of objects represents	CompaniestoFollow,IndustriestoFollow,NewssourcetoFollow,PeopletoFollow
		/**
		 */
		public void setSuggestions(Suggestions suggestions) {
			this.suggestions = suggestions;
		}
		/**
		 */
		//	Tagline that need to be inserted
		/**
		 */
		public String getTagLine() {
			return tagLine;
		}
		/**
		 */
		//	Tagline that need to be inserted
		/**
		 */
		public void setTagLine(String tagLine) {
			this.tagLine = tagLine;
		}
		/**
		 * Array of Objects,string represents Id,Name,Category,CreatedDate
		 */
		public List<Television> getTeleVisionShow() {
			return teleVisionShow;
		}
		/**
		 * Array of Objects,string represents Id,Name,Category,CreatedDate
		 */
		public void setTeleVisionShow(List<Television> teleVisionShow) {
			this.teleVisionShow = teleVisionShow;
		}
		/**
		 */
		//	URL for the Thumbnail
		/**
		 */
		public String getThumbnailImageUrl() {
			return thumbnailImageUrl;
		}
		/**
		 */
		//	URL for the Thumbnail
		/**
		 */
		public void setThumbnailImageUrl(String thumbnailImageUrl) {
			this.thumbnailImageUrl = thumbnailImageUrl;
		}
		/**
		 */
		//	The Current Time Zone.
		/**
		 */
		public String getTimeZone() {
			return timeZone;
		}
		/**
		 */
		//	The Current Time Zone.
		/**
		 */
		public void setTimeZone(String timeZone) {
			this.timeZone = timeZone;
		}
		/**
		 */
		//	Total Private repository
		/**
		 */
		public Integer getTotalPrivateRepository() {
			return totalPrivateRepository;
		}
		/**
		 */
		//	Total Private repository
		/**
		 */
		public void setTotalPrivateRepository(Integer totalPrivateRepository) {
			this.totalPrivateRepository = totalPrivateRepository;
		}
		/**
		 */
		//	Count of Total status
		/**
		 */
		public Integer getTotalStatusesCount() {
			return totalStatusesCount;
		}
		/**
		 */
		//	Count of Total status
		/**
		 */
		public void setTotalStatusesCount(Integer totalStatusesCount) {
			this.totalStatusesCount = totalStatusesCount;
		}
		/**
		 */
		//	UID, the unified identifier for each user account
		/**
		 */
		public String getUid() {
			return uid;
		}
		/**
		 */
		//	UID, the unified identifier for each user account
		/**
		 */
		public void setUid(String uid) {
			this.uid = uid;
		}
		/**
		 */
		//	Username of the user
		/**
		 */
		public String getUserName() {
			return userName;
		}
		/**
		 */
		//	Username of the user
		/**
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/**
		 */
		//	Array of Objects,string represents Id,Role,Organization,Cause
		/**
		 */
		public List<Volunteer> getVolunteer() {
			return volunteer;
		}
		/**
		 */
		//	Array of Objects,string represents Id,Role,Organization,Cause
		/**
		 */
		public void setVolunteer(List<Volunteer> volunteer) {
			this.volunteer = volunteer;
		}
		/**
		 */
		//	Twitter, Facebook ProfileUrls
		/**
		 */
		public Map<String,String> getWebProfiles() {
			return webProfiles;
		}
		/**
		 */
		//	Twitter, Facebook ProfileUrls
		/**
		 */
		public void setWebProfiles(Map<String,String> webProfiles) {
			this.webProfiles = webProfiles;
		}
		/**
		 */
		//	Personal Website a User has
		/**
		 */
		public String getWebsite() {
			return website;
		}
		/**
		 */
		//	Personal Website a User has
		/**
		 */
		public void setWebsite(String website) {
			this.website = website;
		}
    }