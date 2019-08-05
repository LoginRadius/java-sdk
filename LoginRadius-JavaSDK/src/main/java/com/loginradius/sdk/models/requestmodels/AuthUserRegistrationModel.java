/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.requestmodels;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Model Class containing Definition of payload for Auth User Registration API
	// </summary>
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
		
		@SerializedName("KloutScore")
        private KloutProfile kloutScore;
		
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



		// <summary>
		//	About value that need to be inserted
		// </summary>
		public String getAbout() {
			return about;
		}
		// <summary>
		//	About value that need to be inserted
		// </summary>
		public void setAbout(String about) {
			this.about = about;
		}
		// <summary>
		//	caption to accept the privacy policy
		// </summary>
		public Boolean getAcceptPrivacyPolicy() {
			return acceptPrivacyPolicy;
		}
		// <summary>
		//	caption to accept the privacy policy
		// </summary>
		public void setAcceptPrivacyPolicy(Boolean acceptPrivacyPolicy) {
			this.acceptPrivacyPolicy = acceptPrivacyPolicy;
		}
		// <summary>
		//	Array of objects,String represents address of user
		// </summary>
		public List<Address> getAddresses() {
			return addresses;
		}
		// <summary>
		//	Array of objects,String represents address of user
		// </summary>
		public void setAddresses(List<Address> addresses) {
			this.addresses = addresses;
		}
		// <summary>
		//	User's Age
		// </summary>
		public String getAge() {
			return age;
		}
		// <summary>
		//	User's Age
		// </summary>
		public void setAge(String age) {
			this.age = age;
		}
		// <summary>
		//	user's age range.
		// </summary>
		public AgeRange getAgeRange() {
			return ageRange;
		}
		// <summary>
		//	user's age range.
		// </summary>
		public void setAgeRange(AgeRange ageRange) {
			this.ageRange = ageRange;
		}
		// <summary>
		//	Organization a person is assosciated with
		// </summary>
		public String getAssociations() {
			return associations;
		}
		// <summary>
		//	Organization a person is assosciated with
		// </summary>
		public void setAssociations(String associations) {
			this.associations = associations;
		}
		// <summary>
		//	Array of Objects,String represents Id, Name and  Issuer
		// </summary>
		public List<Awards> getAwards() {
			return awards;
		}
		// <summary>
		//	Array of Objects,String represents Id, Name and  Issuer
		// </summary>
		public void setAwards(List<Awards> awards) {
			this.awards = awards;
		}
		// <summary>
		//	User's Badges.
		// </summary>
		public List<Badges> getBadges() {
			return badges;
		}
		// <summary>
		//	User's Badges.
		// </summary>
		public void setBadges(List<Badges> badges) {
			this.badges = badges;
		}
		// <summary>
		//	user's birthdate
		// </summary>
		public String getBirthDate() {
			return birthDate;
		}
		// <summary>
		//	user's birthdate
		// </summary>
		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}
		// <summary>
		//	Array of Objects,String represents Id,Name,Category,CreatedDate
		// </summary>
		public List<Books> getBooks() {
			return books;
		}
		// <summary>
		//	Array of Objects,String represents Id,Name,Category,CreatedDate
		// </summary>
		public void setBooks(List<Books> books) {
			this.books = books;
		}
		// <summary>
		//	Array of Objects,string represents Id,Name,Authority Number,StartDate,EndDate
		// </summary>
		public List<Certifications> getCertifications() {
			return certifications;
		}
		// <summary>
		//	Array of Objects,string represents Id,Name,Authority Number,StartDate,EndDate
		// </summary>
		public void setCertifications(List<Certifications> certifications) {
			this.certifications = certifications;
		}
		// <summary>
		//	user's city
		// </summary>
		public String getCity() {
			return city;
		}
		// <summary>
		//	user's city
		// </summary>
		public void setCity(String city) {
			this.city = city;
		}
		// <summary>
		//	users company name
		// </summary>
		public String getCompany() {
			return company;
		}
		// <summary>
		//	users company name
		// </summary>
		public void setCompany(String company) {
			this.company = company;
		}
		// <summary>
		//	Country of the user
		// </summary>
		public Country getCountry() {
			return country;
		}
		// <summary>
		//	Country of the user
		// </summary>
		public void setCountry(Country country) {
			this.country = country;
		}
		// <summary>
		//	users course information
		// </summary>
		public List<Courses> getCourses() {
			return courses;
		}
		// <summary>
		//	users course information
		// </summary>
		public void setCourses(List<Courses> courses) {
			this.courses = courses;
		}
		// <summary>
		//	URL of the photo that need to be inserted
		// </summary>
		public String getCoverPhoto() {
			return coverPhoto;
		}
		// <summary>
		//	URL of the photo that need to be inserted
		// </summary>
		public void setCoverPhoto(String coverPhoto) {
			this.coverPhoto = coverPhoto;
		}
		// <summary>
		//	Currency
		// </summary>
		public String getCurrency() {
			return currency;
		}
		// <summary>
		//	Currency
		// </summary>
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		// <summary>
		//	Array of Objects,String represents  id ,Text ,Source  and CreatedDate
		// </summary>
		public List<CurrentStatus> getCurrentStatus() {
			return currentStatus;
		}
		// <summary>
		//	Array of Objects,String represents  id ,Text ,Source  and CreatedDate
		// </summary>
		public void setCurrentStatus(List<CurrentStatus> currentStatus) {
			this.currentStatus = currentStatus;
		}
		// <summary>
		//	Custom fields as user set on LoginRadius Admin Console.
		// </summary>
		public Map<String,String> getCustomFields() {
			return customFields;
		}
		// <summary>
		//	Custom fields as user set on LoginRadius Admin Console.
		// </summary>
		public void setCustomFields(Map<String,String> customFields) {
			this.customFields = customFields;
		}
		// <summary>
		//	Array of Objects,which represents the educations record
		// </summary>
		public List<Education> getEducations() {
			return educations;
		}
		// <summary>
		//	Array of Objects,which represents the educations record
		// </summary>
		public void setEducations(List<Education> educations) {
			this.educations = educations;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public List<EmailModel> getEmail() {
			return email;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setEmail(List<EmailModel> email) {
			this.email = email;
		}
		// <summary>
		//	External User Login Id
		// </summary>
		public String getExternalUserLoginId() {
			return externalUserLoginId;
		}
		// <summary>
		//	External User Login Id
		// </summary>
		public void setExternalUserLoginId(String externalUserLoginId) {
			this.externalUserLoginId = externalUserLoginId;
		}
		// <summary>
		//	user's family
		// </summary>
		public List<Family> getFamily() {
			return family;
		}
		// <summary>
		//	user's family
		// </summary>
		public void setFamily(List<Family> family) {
			this.family = family;
		}
		// <summary>
		//	URL of the favicon that need to be inserted
		// </summary>
		public String getFavicon() {
			return favicon;
		}
		// <summary>
		//	URL of the favicon that need to be inserted
		// </summary>
		public void setFavicon(String favicon) {
			this.favicon = favicon;
		}
		// <summary>
		//	Array of Objects,strings represents	Id ,Name ,Type
		// </summary>
		public List<FavoriteThings> getFavoriteThings() {
			return favoriteThings;
		}
		// <summary>
		//	Array of Objects,strings represents	Id ,Name ,Type
		// </summary>
		public void setFavoriteThings(List<FavoriteThings> favoriteThings) {
			this.favoriteThings = favoriteThings;
		}
		// <summary>
		//	user's first name
		// </summary>
		public String getFirstName() {
			return firstName;
		}
		// <summary>
		//	user's first name
		// </summary>
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		// <summary>
		//	user's followers count
		// </summary>
		public Integer getFollowersCount() {
			return followersCount;
		}
		// <summary>
		//	user's followers count
		// </summary>
		public void setFollowersCount(Integer followersCount) {
			this.followersCount = followersCount;
		}
		// <summary>
		//	users friends count
		// </summary>
		public Integer getFriendsCount() {
			return friendsCount;
		}
		// <summary>
		//	users friends count
		// </summary>
		public void setFriendsCount(Integer friendsCount) {
			this.friendsCount = friendsCount;
		}
		// <summary>
		//	Users complete name
		// </summary>
		public String getFullName() {
			return fullName;
		}
		// <summary>
		//	Users complete name
		// </summary>
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		// <summary>
		//	Array of Objects,string represents Id,Name,Category,CreatedDate
		// </summary>
		public List<Games> getGames() {
			return games;
		}
		// <summary>
		//	Array of Objects,string represents Id,Name,Category,CreatedDate
		// </summary>
		public void setGames(List<Games> games) {
			this.games = games;
		}
		// <summary>
		//	user's gender
		// </summary>
		public String getGender() {
			return gender;
		}
		// <summary>
		//	user's gender
		// </summary>
		public void setGender(String gender) {
			this.gender = gender;
		}
		// <summary>
		//	
		// </summary>
		public String getGistsUrl() {
			return gistsUrl;
		}
		// <summary>
		//	
		// </summary>
		public void setGistsUrl(String gistsUrl) {
			this.gistsUrl = gistsUrl;
		}
		// <summary>
		//	URL of image that need to be inserted
		// </summary>
		public String getGravatarImageUrl() {
			return gravatarImageUrl;
		}
		// <summary>
		//	URL of image that need to be inserted
		// </summary>
		public void setGravatarImageUrl(String gravatarImageUrl) {
			this.gravatarImageUrl = gravatarImageUrl;
		}
		// <summary>
		//	boolean type value, default value is true
		// </summary>
		public Boolean getHireable() {
			return hireable;
		}
		// <summary>
		//	boolean type value, default value is true
		// </summary>
		public void setHireable(Boolean hireable) {
			this.hireable = hireable;
		}
		// <summary>
		//	user's home town name
		// </summary>
		public String getHomeTown() {
			return homeTown;
		}
		// <summary>
		//	user's home town name
		// </summary>
		public void setHomeTown(String homeTown) {
			this.homeTown = homeTown;
		}
		// <summary>
		//	Awards lists from the social provider
		// </summary>
		public String getHonors() {
			return honors;
		}
		// <summary>
		//	Awards lists from the social provider
		// </summary>
		public void setHonors(String honors) {
			this.honors = honors;
		}
		// <summary>
		//	URL of the Image that need to be inserted
		// </summary>
		public String getHttpsImageUrl() {
			return httpsImageUrl;
		}
		// <summary>
		//	URL of the Image that need to be inserted
		// </summary>
		public void setHttpsImageUrl(String httpsImageUrl) {
			this.httpsImageUrl = httpsImageUrl;
		}
		// <summary>
		//	Array of objects, String represents account type and account name.
		// </summary>
		public List<IMAccount> getIMAccounts() {
			return iMAccounts;
		}
		// <summary>
		//	Array of objects, String represents account type and account name.
		// </summary>
		public void setIMAccounts(List<IMAccount> iMAccounts) {
			this.iMAccounts = iMAccounts;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public String getImageUrl() {
			return imageUrl;
		}
		// <summary>
		//	image URL should be absolute and has HTTPS domain
		// </summary>
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		// <summary>
		//	Industry name
		// </summary>
		public String getIndustry() {
			return industry;
		}
		// <summary>
		//	Industry name
		// </summary>
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		// <summary>
		//	Array of Objects,string represents Id and Name
		// </summary>
		public List<InspirationalPeople> getInspirationalPeople() {
			return inspirationalPeople;
		}
		// <summary>
		//	Array of Objects,string represents Id and Name
		// </summary>
		public void setInspirationalPeople(List<InspirationalPeople> inspirationalPeople) {
			this.inspirationalPeople = inspirationalPeople;
		}
		// <summary>
		//	array of string represents interest
		// </summary>
		public List<String> getInterestedIn() {
			return interestedIn;
		}
		// <summary>
		//	array of string represents interest
		// </summary>
		public void setInterestedIn(List<String> interestedIn) {
			this.interestedIn = interestedIn;
		}
		// <summary>
		//	Array of objects, string shows InterestedType and InterestedName
		// </summary>
		public List<Interests> getInterests() {
			return interests;
		}
		// <summary>
		//	Array of objects, string shows InterestedType and InterestedName
		// </summary>
		public void setInterests(List<Interests> interests) {
			this.interests = interests;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public Boolean getIsEmailSubscribed() {
			return isEmailSubscribed;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setIsEmailSubscribed(Boolean isEmailSubscribed) {
			this.isEmailSubscribed = isEmailSubscribed;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public String getIsGeoEnabled() {
			return isGeoEnabled;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setIsGeoEnabled(String isGeoEnabled) {
			this.isGeoEnabled = isGeoEnabled;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public Boolean getIsProtected() {
			return isProtected;
		}
		// <summary>
		//	boolean type value, default is true
		// </summary>
		public void setIsProtected(Boolean isProtected) {
			this.isProtected = isProtected;
		}
		// <summary>
		//	boolean type value, true if MFA enables otherwise false
		// </summary>
		public Boolean getIsTwoFactorAuthenticationEnabled() {
			return isTwoFactorAuthenticationEnabled;
		}
		// <summary>
		//	boolean type value, true if MFA enables otherwise false
		// </summary>
		public void setIsTwoFactorAuthenticationEnabled(Boolean isTwoFactorAuthenticationEnabled) {
			this.isTwoFactorAuthenticationEnabled = isTwoFactorAuthenticationEnabled;
		}
		// <summary>
		//	Array of Objects,Strings,boolean,object represents IsApplied,ApplyTimestamp,IsSaved,SavedTimestamp,Job
		// </summary>
		public List<JobBookmarks> getJobBookmarks() {
			return jobBookmarks;
		}
		// <summary>
		//	Array of Objects,Strings,boolean,object represents IsApplied,ApplyTimestamp,IsSaved,SavedTimestamp,Job
		// </summary>
		public void setJobBookmarks(List<JobBookmarks> jobBookmarks) {
			this.jobBookmarks = jobBookmarks;
		}
		// <summary>
		//	Object, string represents KloutId and double represents Score
		// </summary>
		public KloutProfile getKloutScore() {
			return kloutScore;
		}
		// <summary>
		//	Object, string represents KloutId and double represents Score
		// </summary>
		public void setKloutScore(KloutProfile kloutScore) {
			this.kloutScore = kloutScore;
		}
		// <summary>
		//	language known by user's
		// </summary>
		public List<Languages> getLanguages() {
			return languages;
		}
		// <summary>
		//	language known by user's
		// </summary>
		public void setLanguages(List<Languages> languages) {
			this.languages = languages;
		}
		// <summary>
		//	user's last name
		// </summary>
		public String getLastName() {
			return lastName;
		}
		// <summary>
		//	user's last name
		// </summary>
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		// <summary>
		//	Local City of the user
		// </summary>
		public String getLocalCity() {
			return localCity;
		}
		// <summary>
		//	Local City of the user
		// </summary>
		public void setLocalCity(String localCity) {
			this.localCity = localCity;
		}
		// <summary>
		//	Local country of the user
		// </summary>
		public String getLocalCountry() {
			return localCountry;
		}
		// <summary>
		//	Local country of the user
		// </summary>
		public void setLocalCountry(String localCountry) {
			this.localCountry = localCountry;
		}
		// <summary>
		//	Local language of the user
		// </summary>
		public String getLocalLanguage() {
			return localLanguage;
		}
		// <summary>
		//	Local language of the user
		// </summary>
		public void setLocalLanguage(String localLanguage) {
			this.localLanguage = localLanguage;
		}
		// <summary>
		//	Main address of the user
		// </summary>
		public String getMainAddress() {
			return mainAddress;
		}
		// <summary>
		//	Main address of the user
		// </summary>
		public void setMainAddress(String mainAddress) {
			this.mainAddress = mainAddress;
		}
		// <summary>
		//	Array of Objects,String represents Url,UrlName
		// </summary>
		public List<Memberurlresources> getMemberUrlResources() {
			return memberUrlResources;
		}
		// <summary>
		//	Array of Objects,String represents Url,UrlName
		// </summary>
		public void setMemberUrlResources(List<Memberurlresources> memberUrlResources) {
			this.memberUrlResources = memberUrlResources;
		}
		// <summary>
		//	user's middle name
		// </summary>
		public String getMiddleName() {
			return middleName;
		}
		// <summary>
		//	user's middle name
		// </summary>
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		// <summary>
		//	Array of Objects,strings represents	Id,Name,Category,CreatedDate
		// </summary>
		public List<Movies> getMovies() {
			return movies;
		}
		// <summary>
		//	Array of Objects,strings represents	Id,Name,Category,CreatedDate
		// </summary>
		public void setMovies(List<Movies> movies) {
			this.movies = movies;
		}
		// <summary>
		//	Array of Objects, strings represents Id,Name,FirstName,LastName,Birthday,Hometown,Link,Gender
		// </summary>
		public List<MutualFriends> getMutualFriends() {
			return mutualFriends;
		}
		// <summary>
		//	Array of Objects, strings represents Id,Name,FirstName,LastName,Birthday,Hometown,Link,Gender
		// </summary>
		public void setMutualFriends(List<MutualFriends> mutualFriends) {
			this.mutualFriends = mutualFriends;
		}
		// <summary>
		//	Nick name of the user
		// </summary>
		public String getNickName() {
			return nickName;
		}
		// <summary>
		//	Nick name of the user
		// </summary>
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		// <summary>
		//	Count for the user profile recommended
		// </summary>
		public Integer getNumRecommenders() {
			return numRecommenders;
		}
		// <summary>
		//	Count for the user profile recommended
		// </summary>
		public void setNumRecommenders(Integer numRecommenders) {
			this.numRecommenders = numRecommenders;
		}
		// <summary>
		//	Password for the email
		// </summary>
		public String getPassword() {
			return password;
		}
		// <summary>
		//	Password for the email
		// </summary>
		public void setPassword(String password) {
			this.password = password;
		}
		// <summary>
		//	Patents Registered
		// </summary>
		public List<Patents> getPatents() {
			return patents;
		}
		// <summary>
		//	Patents Registered
		// </summary>
		public void setPatents(List<Patents> patents) {
			this.patents = patents;
		}
		// <summary>
		//	Phone ID (Unique Phone Number Identifier of the user)
		// </summary>
		public String getPhoneId() {
			return phoneId;
		}
		// <summary>
		//	Phone ID (Unique Phone Number Identifier of the user)
		// </summary>
		public void setPhoneId(String phoneId) {
			this.phoneId = phoneId;
		}
		// <summary>
		//	Users Phone Number
		// </summary>
		public List<Phone> getPhoneNumbers() {
			return phoneNumbers;
		}
		// <summary>
		//	Users Phone Number
		// </summary>
		public void setPhoneNumbers(List<Phone> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}
		// <summary>
		//	Array of Objects,strings Name and boolean IsPrimary
		// </summary>
		public List<PlacesLived> getPlacesLived() {
			return placesLived;
		}
		// <summary>
		//	Array of Objects,strings Name and boolean IsPrimary
		// </summary>
		public void setPlacesLived(List<PlacesLived> placesLived) {
			this.placesLived = placesLived;
		}
		// <summary>
		//	List of Political interest
		// </summary>
		public String getPolitical() {
			return political;
		}
		// <summary>
		//	List of Political interest
		// </summary>
		public void setPolitical(String political) {
			this.political = political;
		}
		// <summary>
		//	Array of Objects,which represents the PositionSummary,StartDate,EndDate,IsCurrent,Company,Location
		// </summary>
		public List<ProfessionalPosition> getPositions() {
			return positions;
		}
		// <summary>
		//	Array of Objects,which represents the PositionSummary,StartDate,EndDate,IsCurrent,Company,Location
		// </summary>
		public void setPositions(List<ProfessionalPosition> positions) {
			this.positions = positions;
		}
		// <summary>
		//	Prefix for FirstName
		// </summary>
		public String getPrefix() {
			return prefix;
		}
		// <summary>
		//	Prefix for FirstName
		// </summary>
		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		// <summary>
		//	user private Repository Urls
		// </summary>
		public Integer getPrivateGists() {
			return privateGists;
		}
		// <summary>
		//	user private Repository Urls
		// </summary>
		public void setPrivateGists(Integer privateGists) {
			this.privateGists = privateGists;
		}
		// <summary>
		//	This field provide by linkedin.contain our linkedin profile headline
		// </summary>
		public String getProfessionalHeadline() {
			return professionalHeadline;
		}
		// <summary>
		//	This field provide by linkedin.contain our linkedin profile headline
		// </summary>
		public void setProfessionalHeadline(String professionalHeadline) {
			this.professionalHeadline = professionalHeadline;
		}
		// <summary>
		//	ProfileCity value that need to be inserted
		// </summary>
		public String getProfileCity() {
			return profileCity;
		}
		// <summary>
		//	ProfileCity value that need to be inserted
		// </summary>
		public void setProfileCity(String profileCity) {
			this.profileCity = profileCity;
		}
		// <summary>
		//	ProfileCountry value that need to be inserted
		// </summary>
		public String getProfileCountry() {
			return profileCountry;
		}
		// <summary>
		//	ProfileCountry value that need to be inserted
		// </summary>
		public void setProfileCountry(String profileCountry) {
			this.profileCountry = profileCountry;
		}
		// <summary>
		//	ProfileImageUrls that need to be inserted
		// </summary>
		public Map<String,String> getProfileImageUrls() {
			return profileImageUrls;
		}
		// <summary>
		//	ProfileImageUrls that need to be inserted
		// </summary>
		public void setProfileImageUrls(Map<String,String> profileImageUrls) {
			this.profileImageUrls = profileImageUrls;
		}
		// <summary>
		//	ProfileName value field that need to be inserted
		// </summary>
		public String getProfileName() {
			return profileName;
		}
		// <summary>
		//	ProfileName value field that need to be inserted
		// </summary>
		public void setProfileName(String profileName) {
			this.profileName = profileName;
		}
		// <summary>
		//	User profile url like facebook profile Url
		// </summary>
		public String getProfileUrl() {
			return profileUrl;
		}
		// <summary>
		//	User profile url like facebook profile Url
		// </summary>
		public void setProfileUrl(String profileUrl) {
			this.profileUrl = profileUrl;
		}
		// <summary>
		//	Array of Objects,string represents  Id,Name,Summary With StartDate,EndDate,IsCurrent
		// </summary>
		public List<Projects> getProjects() {
			return projects;
		}
		// <summary>
		//	Array of Objects,string represents  Id,Name,Summary With StartDate,EndDate,IsCurrent
		// </summary>
		public void setProjects(List<Projects> projects) {
			this.projects = projects;
		}
		// <summary>
		//	Object,string represents AccessToken,TokenSecret
		// </summary>
		public ProviderAccessCredential getProviderAccessCredential() {
			return providerAccessCredential;
		}
		// <summary>
		//	Object,string represents AccessToken,TokenSecret
		// </summary>
		public void setProviderAccessCredential(ProviderAccessCredential providerAccessCredential) {
			this.providerAccessCredential = providerAccessCredential;
		}
		// <summary>
		//	Array of Objects,string represents Id,Title,Publisher,Authors,Date,Url,Summary
		// </summary>
		public List<Publications> getPublications() {
			return publications;
		}
		// <summary>
		//	Array of Objects,string represents Id,Title,Publisher,Authors,Date,Url,Summary
		// </summary>
		public void setPublications(List<Publications> publications) {
			this.publications = publications;
		}
		// <summary>
		//	gist is a Git repository, which means that it can be forked and cloned.
		// </summary>
		public Integer getPublicGists() {
			return publicGists;
		}
		// <summary>
		//	gist is a Git repository, which means that it can be forked and cloned.
		// </summary>
		public void setPublicGists(Integer publicGists) {
			this.publicGists = publicGists;
		}
		// <summary>
		//	user public Repository Urls
		// </summary>
		public String getPublicRepository() {
			return publicRepository;
		}
		// <summary>
		//	user public Repository Urls
		// </summary>
		public void setPublicRepository(String publicRepository) {
			this.publicRepository = publicRepository;
		}
		// <summary>
		//	Quota
		// </summary>
		public String getQuota() {
			return quota;
		}
		// <summary>
		//	Quota
		// </summary>
		public void setQuota(String quota) {
			this.quota = quota;
		}
		// <summary>
		//	Array of Objects,string represents Id,RecommendationType,RecommendationText,Recommender
		// </summary>
		public List<RecommendationsReceived> getRecommendationsReceived() {
			return recommendationsReceived;
		}
		// <summary>
		//	Array of Objects,string represents Id,RecommendationType,RecommendationText,Recommender
		// </summary>
		public void setRecommendationsReceived(List<RecommendationsReceived> recommendationsReceived) {
			this.recommendationsReceived = recommendationsReceived;
		}
		// <summary>
		//	Array of Objects,String represents Id,FirstName,LastName
		// </summary>
		public List<RelatedProfileViews> getRelatedProfileViews() {
			return relatedProfileViews;
		}
		// <summary>
		//	Array of Objects,String represents Id,FirstName,LastName
		// </summary>
		public void setRelatedProfileViews(List<RelatedProfileViews> relatedProfileViews) {
			this.relatedProfileViews = relatedProfileViews;
		}
		// <summary>
		//	user's relationship status
		// </summary>
		public String getRelationshipStatus() {
			return relationshipStatus;
		}
		// <summary>
		//	user's relationship status
		// </summary>
		public void setRelationshipStatus(String relationshipStatus) {
			this.relationshipStatus = relationshipStatus;
		}
		// <summary>
		//	String shows users religion
		// </summary>
		public String getReligion() {
			return religion;
		}
		// <summary>
		//	String shows users religion
		// </summary>
		public void setReligion(String religion) {
			this.religion = religion;
		}
		// <summary>
		//	Repository URL
		// </summary>
		public String getRepositoryUrl() {
			return repositoryUrl;
		}
		// <summary>
		//	Repository URL
		// </summary>
		public void setRepositoryUrl(String repositoryUrl) {
			this.repositoryUrl = repositoryUrl;
		}
		// <summary>
		//	Valid JSON object of Unique Security Question ID and Answer of set Security Question
		// </summary>
		public Map<String,String> getSecurityQuestionAnswer() {
			return securityQuestionAnswer;
		}
		// <summary>
		//	Valid JSON object of Unique Security Question ID and Answer of set Security Question
		// </summary>
		public void setSecurityQuestionAnswer(Map<String,String> securityQuestionAnswer) {
			this.securityQuestionAnswer = securityQuestionAnswer;
		}
		// <summary>
		//	Array of objects, String represents ID and Name
		// </summary>
		public List<Skills> getSkills() {
			return skills;
		}
		// <summary>
		//	Array of objects, String represents ID and Name
		// </summary>
		public void setSkills(List<Skills> skills) {
			this.skills = skills;
		}
		// <summary>
		//	Array of objects, String represents ID and Name
		// </summary>
		public List<Sports> getSports() {
			return sports;
		}
		// <summary>
		//	Array of objects, String represents ID and Name
		// </summary>
		public void setSports(List<Sports> sports) {
			this.sports = sports;
		}
		// <summary>
		//	Git users bookmark repositories
		// </summary>
		public String getStarredUrl() {
			return starredUrl;
		}
		// <summary>
		//	Git users bookmark repositories
		// </summary>
		public void setStarredUrl(String starredUrl) {
			this.starredUrl = starredUrl;
		}
		// <summary>
		//	State of the user
		// </summary>
		public String getState() {
			return state;
		}
		// <summary>
		//	State of the user
		// </summary>
		public void setState(String state) {
			this.state = state;
		}
		// <summary>
		//	Object,string represents Name,Space,PrivateRepos,Collaborators
		// </summary>
		public GitHubPlan getSubscription() {
			return subscription;
		}
		// <summary>
		//	Object,string represents Name,Space,PrivateRepos,Collaborators
		// </summary>
		public void setSubscription(GitHubPlan subscription) {
			this.subscription = subscription;
		}
		// <summary>
		//	Suffix for the User.
		// </summary>
		public String getSuffix() {
			return suffix;
		}
		// <summary>
		//	Suffix for the User.
		// </summary>
		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
		// <summary>
		//	Object,array of objects represents	CompaniestoFollow,IndustriestoFollow,NewssourcetoFollow,PeopletoFollow
		// </summary>
		public Suggestions getSuggestions() {
			return suggestions;
		}
		// <summary>
		//	Object,array of objects represents	CompaniestoFollow,IndustriestoFollow,NewssourcetoFollow,PeopletoFollow
		// </summary>
		public void setSuggestions(Suggestions suggestions) {
			this.suggestions = suggestions;
		}
		// <summary>
		//	Tagline that need to be inserted
		// </summary>
		public String getTagLine() {
			return tagLine;
		}
		// <summary>
		//	Tagline that need to be inserted
		// </summary>
		public void setTagLine(String tagLine) {
			this.tagLine = tagLine;
		}
		// <summary>
		//	Array of Objects,string represents Id,Name,Category,CreatedDate
		// </summary>
		public List<Television> getTeleVisionShow() {
			return teleVisionShow;
		}
		// <summary>
		//	Array of Objects,string represents Id,Name,Category,CreatedDate
		// </summary>
		public void setTeleVisionShow(List<Television> teleVisionShow) {
			this.teleVisionShow = teleVisionShow;
		}
		// <summary>
		//	URL for the Thumbnail
		// </summary>
		public String getThumbnailImageUrl() {
			return thumbnailImageUrl;
		}
		// <summary>
		//	URL for the Thumbnail
		// </summary>
		public void setThumbnailImageUrl(String thumbnailImageUrl) {
			this.thumbnailImageUrl = thumbnailImageUrl;
		}
		// <summary>
		//	The Current Time Zone.
		// </summary>
		public String getTimeZone() {
			return timeZone;
		}
		// <summary>
		//	The Current Time Zone.
		// </summary>
		public void setTimeZone(String timeZone) {
			this.timeZone = timeZone;
		}
		// <summary>
		//	Total Private repository
		// </summary>
		public Integer getTotalPrivateRepository() {
			return totalPrivateRepository;
		}
		// <summary>
		//	Total Private repository
		// </summary>
		public void setTotalPrivateRepository(Integer totalPrivateRepository) {
			this.totalPrivateRepository = totalPrivateRepository;
		}
		// <summary>
		//	Count of Total status
		// </summary>
		public Integer getTotalStatusesCount() {
			return totalStatusesCount;
		}
		// <summary>
		//	Count of Total status
		// </summary>
		public void setTotalStatusesCount(Integer totalStatusesCount) {
			this.totalStatusesCount = totalStatusesCount;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public String getUid() {
			return uid;
		}
		// <summary>
		//	UID, the unified identifier for each user account
		// </summary>
		public void setUid(String uid) {
			this.uid = uid;
		}
		// <summary>
		//	Username of the user
		// </summary>
		public String getUserName() {
			return userName;
		}
		// <summary>
		//	Username of the user
		// </summary>
		public void setUserName(String userName) {
			this.userName = userName;
		}
		// <summary>
		//	Array of Objects,string represents Id,Role,Organization,Cause
		// </summary>
		public List<Volunteer> getVolunteer() {
			return volunteer;
		}
		// <summary>
		//	Array of Objects,string represents Id,Role,Organization,Cause
		// </summary>
		public void setVolunteer(List<Volunteer> volunteer) {
			this.volunteer = volunteer;
		}
		// <summary>
		//	Twitter, Facebook ProfileUrls
		// </summary>
		public Map<String,String> getWebProfiles() {
			return webProfiles;
		}
		// <summary>
		//	Twitter, Facebook ProfileUrls
		// </summary>
		public void setWebProfiles(Map<String,String> webProfiles) {
			this.webProfiles = webProfiles;
		}
		// <summary>
		//	Personal Website a User has
		// </summary>
		public String getWebsite() {
			return website;
		}
		// <summary>
		//	Personal Website a User has
		// </summary>
		public void setWebsite(String website) {
			this.website = website;
		}
    }