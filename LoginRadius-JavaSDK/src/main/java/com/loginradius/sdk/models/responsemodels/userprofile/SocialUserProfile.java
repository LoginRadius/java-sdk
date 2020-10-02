/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.userprofile;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Address;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.AgeRange;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Awards;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Badges;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Books;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Certifications;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Country;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Courses;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.CurrentStatus;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Education;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Email;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Family;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.FavoriteThings;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Games;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.GitHubPlan;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.IMAccount;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.InspirationalPeople;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Interests;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.JobBookmarks;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.KloutProfile;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Languages;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Memberurlresources;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Movies;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.MutualFriends;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Patents;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Phone;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.PlacesLived;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.ProfessionalPosition;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Projects;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.ProviderAccessCredential;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Publications;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.RecommendationsReceived;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.RelatedProfileViews;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Skills;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Sports;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Suggestions;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Television;
import com.loginradius.sdk.models.responsemodels.userprofile.objects.Volunteer;

	/**
	 * Response containing Definition for Complete SocialUserProfile data
	 */
	public class SocialUserProfile {
	
		
		@SerializedName("About")
        private String about;
		
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
		
		@SerializedName("BoardsCount")
        private Integer boardsCount;
		
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
		
		@SerializedName("Created")
        private String created;
		
		@SerializedName("CreatedDate")
        private String createdDate;
		
		@SerializedName("Currency")
        private String currency;
		
		@SerializedName("CurrentStatus")
        private List<CurrentStatus> currentStatus;
		
		@SerializedName("Educations")
        private List<Education> educations;
		
		@SerializedName("Email")
        private List<Email> email;
		
		@SerializedName("Family")
        private List<Family> family;
		
		@SerializedName("Favicon")
        private String favicon;
		
		@SerializedName("FavoriteThings")
        private List<FavoriteThings> favoriteThings;
		
		@SerializedName("FirstLogin")
        private Boolean firstLogin;
		
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
		
		@SerializedName("ID")
        private String iD;
		
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
		
		@SerializedName("IsGeoEnabled")
        private String isGeoEnabled;
		
		@SerializedName("IsProtected")
        private Boolean isProtected;
		
		@SerializedName("JobBookmarks")
        private List<JobBookmarks> jobBookmarks;
		
		@SerializedName("KloutScore")
        private KloutProfile kloutScore;
		
		@SerializedName("Language")
        private String language;
		
		@SerializedName("Languages")
        private List<Languages> languages;
		
		@SerializedName("LastLoginDate")
        private String lastLoginDate;
		
		@SerializedName("LastName")
        private String lastName;
		
		@SerializedName("LikesCount")
        private Integer likesCount;
		
		@SerializedName("LocalCity")
        private String localCity;
		
		@SerializedName("LocalCountry")
        private String localCountry;
		
		@SerializedName("LocalLanguage")
        private String localLanguage;
		
		@SerializedName("LRUserID")
        private String lRUserID;
		
		@SerializedName("MainAddress")
        private String mainAddress;
		
		@SerializedName("MemberUrlResources")
        private List<Memberurlresources> memberUrlResources;
		
		@SerializedName("MiddleName")
        private String middleName;
		
		@SerializedName("ModifiedDate")
        private String modifiedDate;
		
		@SerializedName("Movies")
        private List<Movies> movies;
		
		@SerializedName("MutualFriends")
        private List<MutualFriends> mutualFriends;
		
		@SerializedName("NickName")
        private String nickName;
		
		@SerializedName("NumRecommenders")
        private Integer numRecommenders;
		
		@SerializedName("Patents")
        private List<Patents> patents;
		
		@SerializedName("PhoneNumbers")
        private List<Phone> phoneNumbers;
		
		@SerializedName("PinsCount")
        private Integer pinsCount;
		
		@SerializedName("PlacesLived")
        private List<PlacesLived> placesLived;
		
		@SerializedName("Political")
        private String political;
		
		@SerializedName("Positions")
        private List<ProfessionalPosition> positions;
		
		@SerializedName("Prefix")
        private String prefix;
		
		@SerializedName("PreviousUids")
        private List<String> previousUids;
		
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
		
		@SerializedName("ProfileModifiedDate")
        private String profileModifiedDate;
		
		@SerializedName("ProfileName")
        private String profileName;
		
		@SerializedName("ProfileUrl")
        private String profileUrl;
		
		@SerializedName("Projects")
        private List<Projects> projects;
		
		@SerializedName("Provider")
        private String provider;
		
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
		
		@SerializedName("Quote")
        private String quote;
		
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
		
		@SerializedName("SignupDate")
        private String signupDate;
		
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
		
		@SerializedName("UpdatedTime")
        private String updatedTime;
		
		@SerializedName("Verified")
        private String verified;
		
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
		 * boards count
		 */
		public Integer getBoardsCount() {
			return boardsCount;
		}
		/**
		 * boards count
		 */
		public void setBoardsCount(Integer boardsCount) {
			this.boardsCount = boardsCount;
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
		 * created
		 */
		public String getCreated() {
			return created;
		}
		/**
		 * created
		 */
		public void setCreated(String created) {
			this.created = created;
		}
		/**
		 * Date of Creation of Profile
		 */
		public String getCreatedDate() {
			return createdDate;
		}
		/**
		 * Date of Creation of Profile
		 */
		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
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
		 * user's email
		 */
		public List<Email> getEmail() {
			return email;
		}
		/**
		 * user's email
		 */
		public void setEmail(List<Email> email) {
			this.email = email;
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
		 * first login
		 */
		public Boolean getFirstLogin() {
			return firstLogin;
		}
		/**
		 * first login
		 */
		public void setFirstLogin(Boolean firstLogin) {
			this.firstLogin = firstLogin;
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
		 * Git Repository URL
		 */
		public String getGistsUrl() {
			return gistsUrl;
		}
		/**
		 * Git Repository URL
		 */
		public void setGistsUrl(String gistsUrl) {
			this.gistsUrl = gistsUrl;
		}
		/**
		 * URL of image that need to be inserted
		 */
		public String getGravatarImageUrl() {
			return gravatarImageUrl;
		}
		/**
		 * URL of image that need to be inserted
		 */
		public void setGravatarImageUrl(String gravatarImageUrl) {
			this.gravatarImageUrl = gravatarImageUrl;
		}
		/**
		 * boolean type value, default value is true
		 */
		public Boolean getHireable() {
			return hireable;
		}
		/**
		 * boolean type value, default value is true
		 */
		public void setHireable(Boolean hireable) {
			this.hireable = hireable;
		}
		/**
		 * user's home town name
		 */
		public String getHomeTown() {
			return homeTown;
		}
		/**
		 * user's home town name
		 */
		public void setHomeTown(String homeTown) {
			this.homeTown = homeTown;
		}
		/**
		 * Awards lists from the social provider
		 */
		public String getHonors() {
			return honors;
		}
		/**
		 * Awards lists from the social provider
		 */
		public void setHonors(String honors) {
			this.honors = honors;
		}
		/**
		 * URL of the Image that need to be inserted
		 */
		public String getHttpsImageUrl() {
			return httpsImageUrl;
		}
		/**
		 * URL of the Image that need to be inserted
		 */
		public void setHttpsImageUrl(String httpsImageUrl) {
			this.httpsImageUrl = httpsImageUrl;
		}
		/**
		 * ID of the User
		 */
		public String getID() {
			return iD;
		}
		/**
		 * ID of the User
		 */
		public void setID(String iD) {
			this.iD = iD;
		}
		/**
		 * Array of objects, String represents account type and account name.
		 */
		public List<IMAccount> getIMAccounts() {
			return iMAccounts;
		}
		/**
		 * Array of objects, String represents account type and account name.
		 */
		public void setIMAccounts(List<IMAccount> iMAccounts) {
			this.iMAccounts = iMAccounts;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public String getImageUrl() {
			return imageUrl;
		}
		/**
		 * image URL should be absolute and has HTTPS domain
		 */
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		/**
		 * Industry name
		 */
		public String getIndustry() {
			return industry;
		}
		/**
		 * Industry name
		 */
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		/**
		 * Array of Objects,string represents Id and Name
		 */
		public List<InspirationalPeople> getInspirationalPeople() {
			return inspirationalPeople;
		}
		/**
		 * Array of Objects,string represents Id and Name
		 */
		public void setInspirationalPeople(List<InspirationalPeople> inspirationalPeople) {
			this.inspirationalPeople = inspirationalPeople;
		}
		/**
		 * array of string represents interest
		 */
		public List<String> getInterestedIn() {
			return interestedIn;
		}
		/**
		 * array of string represents interest
		 */
		public void setInterestedIn(List<String> interestedIn) {
			this.interestedIn = interestedIn;
		}
		/**
		 * Array of objects, string shows InterestedType and InterestedName
		 */
		public List<Interests> getInterests() {
			return interests;
		}
		/**
		 * Array of objects, string shows InterestedType and InterestedName
		 */
		public void setInterests(List<Interests> interests) {
			this.interests = interests;
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
		 * Array of Objects,Strings,boolean,object represents IsApplied,ApplyTimestamp,IsSaved,SavedTimestamp,Job
		 */
		public List<JobBookmarks> getJobBookmarks() {
			return jobBookmarks;
		}
		/**
		 * Array of Objects,Strings,boolean,object represents IsApplied,ApplyTimestamp,IsSaved,SavedTimestamp,Job
		 */
		public void setJobBookmarks(List<JobBookmarks> jobBookmarks) {
			this.jobBookmarks = jobBookmarks;
		}
		/**
		 * Object, string represents KloutId and double represents Score
		 */
		public KloutProfile getKloutScore() {
			return kloutScore;
		}
		/**
		 * Object, string represents KloutId and double represents Score
		 */
		public void setKloutScore(KloutProfile kloutScore) {
			this.kloutScore = kloutScore;
		}
		/**
		 * language known by user's
		 */
		public String getLanguage() {
			return language;
		}
		/**
		 * language known by user's
		 */
		public void setLanguage(String language) {
			this.language = language;
		}
		/**
		 * language known by user's
		 */
		public List<Languages> getLanguages() {
			return languages;
		}
		/**
		 * language known by user's
		 */
		public void setLanguages(List<Languages> languages) {
			this.languages = languages;
		}
		/**
		 * last login date
		 */
		public String getLastLoginDate() {
			return lastLoginDate;
		}
		/**
		 * last login date
		 */
		public void setLastLoginDate(String lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
		}
		/**
		 * user's last name
		 */
		public String getLastName() {
			return lastName;
		}
		/**
		 * user's last name
		 */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		/**
		 * likes count
		 */
		public Integer getLikesCount() {
			return likesCount;
		}
		/**
		 * likes count
		 */
		public void setLikesCount(Integer likesCount) {
			this.likesCount = likesCount;
		}
		/**
		 * Local City of the user
		 */
		public String getLocalCity() {
			return localCity;
		}
		/**
		 * Local City of the user
		 */
		public void setLocalCity(String localCity) {
			this.localCity = localCity;
		}
		/**
		 * Local country of the user
		 */
		public String getLocalCountry() {
			return localCountry;
		}
		/**
		 * Local country of the user
		 */
		public void setLocalCountry(String localCountry) {
			this.localCountry = localCountry;
		}
		/**
		 * Local language of the user
		 */
		public String getLocalLanguage() {
			return localLanguage;
		}
		/**
		 * Local language of the user
		 */
		public void setLocalLanguage(String localLanguage) {
			this.localLanguage = localLanguage;
		}
		/**
		 * LR user id
		 */
		public String getLRUserID() {
			return lRUserID;
		}
		/**
		 * LR user id
		 */
		public void setLRUserID(String lRUserID) {
			this.lRUserID = lRUserID;
		}
		/**
		 * Main address of the user
		 */
		public String getMainAddress() {
			return mainAddress;
		}
		/**
		 * Main address of the user
		 */
		public void setMainAddress(String mainAddress) {
			this.mainAddress = mainAddress;
		}
		/**
		 * Array of Objects,String represents Url,UrlName
		 */
		public List<Memberurlresources> getMemberUrlResources() {
			return memberUrlResources;
		}
		/**
		 * Array of Objects,String represents Url,UrlName
		 */
		public void setMemberUrlResources(List<Memberurlresources> memberUrlResources) {
			this.memberUrlResources = memberUrlResources;
		}
		/**
		 * user's middle name
		 */
		public String getMiddleName() {
			return middleName;
		}
		/**
		 * user's middle name
		 */
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		/**
		 * profile updated date
		 */
		public String getModifiedDate() {
			return modifiedDate;
		}
		/**
		 * profile updated date
		 */
		public void setModifiedDate(String modifiedDate) {
			this.modifiedDate = modifiedDate;
		}
		/**
		 * Array of Objects,strings represents	Id,Name,Category,CreatedDate
		 */
		public List<Movies> getMovies() {
			return movies;
		}
		/**
		 * Array of Objects,strings represents	Id,Name,Category,CreatedDate
		 */
		public void setMovies(List<Movies> movies) {
			this.movies = movies;
		}
		/**
		 * Array of Objects, strings represents Id,Name,FirstName,LastName,Birthday,Hometown,Link,Gender
		 */
		public List<MutualFriends> getMutualFriends() {
			return mutualFriends;
		}
		/**
		 * Array of Objects, strings represents Id,Name,FirstName,LastName,Birthday,Hometown,Link,Gender
		 */
		public void setMutualFriends(List<MutualFriends> mutualFriends) {
			this.mutualFriends = mutualFriends;
		}
		/**
		 * Nick name of the user
		 */
		public String getNickName() {
			return nickName;
		}
		/**
		 * Nick name of the user
		 */
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		/**
		 * Count for the user profile recommended
		 */
		public Integer getNumRecommenders() {
			return numRecommenders;
		}
		/**
		 * Count for the user profile recommended
		 */
		public void setNumRecommenders(Integer numRecommenders) {
			this.numRecommenders = numRecommenders;
		}
		/**
		 * Patents Registered
		 */
		public List<Patents> getPatents() {
			return patents;
		}
		/**
		 * Patents Registered
		 */
		public void setPatents(List<Patents> patents) {
			this.patents = patents;
		}
		/**
		 * Users Phone Number
		 */
		public List<Phone> getPhoneNumbers() {
			return phoneNumbers;
		}
		/**
		 * Users Phone Number
		 */
		public void setPhoneNumbers(List<Phone> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}
		/**
		 * count of pins
		 */
		public Integer getPinsCount() {
			return pinsCount;
		}
		/**
		 * count of pins
		 */
		public void setPinsCount(Integer pinsCount) {
			this.pinsCount = pinsCount;
		}
		/**
		 * Array of Objects,strings Name and boolean IsPrimary
		 */
		public List<PlacesLived> getPlacesLived() {
			return placesLived;
		}
		/**
		 * Array of Objects,strings Name and boolean IsPrimary
		 */
		public void setPlacesLived(List<PlacesLived> placesLived) {
			this.placesLived = placesLived;
		}
		/**
		 * List of Political interest
		 */
		public String getPolitical() {
			return political;
		}
		/**
		 * List of Political interest
		 */
		public void setPolitical(String political) {
			this.political = political;
		}
		/**
		 * Array of Objects,which represents the PositionSummary,StartDate,EndDate,IsCurrent,Company,Location
		 */
		public List<ProfessionalPosition> getPositions() {
			return positions;
		}
		/**
		 * Array of Objects,which represents the PositionSummary,StartDate,EndDate,IsCurrent,Company,Location
		 */
		public void setPositions(List<ProfessionalPosition> positions) {
			this.positions = positions;
		}
		/**
		 * Prefix for FirstName
		 */
		public String getPrefix() {
			return prefix;
		}
		/**
		 * Prefix for FirstName
		 */
		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		/**
		 * previous ids
		 */
		public List<String> getPreviousUids() {
			return previousUids;
		}
		/**
		 * previous ids
		 */
		public void setPreviousUids(List<String> previousUids) {
			this.previousUids = previousUids;
		}
		/**
		 * user private Repository Urls
		 */
		public Integer getPrivateGists() {
			return privateGists;
		}
		/**
		 * user private Repository Urls
		 */
		public void setPrivateGists(Integer privateGists) {
			this.privateGists = privateGists;
		}
		/**
		 * This field provide by linkedin.contain our linkedin profile headline
		 */
		public String getProfessionalHeadline() {
			return professionalHeadline;
		}
		/**
		 * This field provide by linkedin.contain our linkedin profile headline
		 */
		public void setProfessionalHeadline(String professionalHeadline) {
			this.professionalHeadline = professionalHeadline;
		}
		/**
		 * ProfileCity value that need to be inserted
		 */
		public String getProfileCity() {
			return profileCity;
		}
		/**
		 * ProfileCity value that need to be inserted
		 */
		public void setProfileCity(String profileCity) {
			this.profileCity = profileCity;
		}
		/**
		 * ProfileCountry value that need to be inserted
		 */
		public String getProfileCountry() {
			return profileCountry;
		}
		/**
		 * ProfileCountry value that need to be inserted
		 */
		public void setProfileCountry(String profileCountry) {
			this.profileCountry = profileCountry;
		}
		/**
		 * ProfileImageUrls that need to be inserted
		 */
		public Map<String,String> getProfileImageUrls() {
			return profileImageUrls;
		}
		/**
		 * ProfileImageUrls that need to be inserted
		 */
		public void setProfileImageUrls(Map<String,String> profileImageUrls) {
			this.profileImageUrls = profileImageUrls;
		}
		/**
		 * profile updated date
		 */
		public String getProfileModifiedDate() {
			return profileModifiedDate;
		}
		/**
		 * profile updated date
		 */
		public void setProfileModifiedDate(String profileModifiedDate) {
			this.profileModifiedDate = profileModifiedDate;
		}
		/**
		 * ProfileName value field that need to be inserted
		 */
		public String getProfileName() {
			return profileName;
		}
		/**
		 * ProfileName value field that need to be inserted
		 */
		public void setProfileName(String profileName) {
			this.profileName = profileName;
		}
		/**
		 * User profile url like facebook profile Url
		 */
		public String getProfileUrl() {
			return profileUrl;
		}
		/**
		 * User profile url like facebook profile Url
		 */
		public void setProfileUrl(String profileUrl) {
			this.profileUrl = profileUrl;
		}
		/**
		 * Array of Objects,string represents  Id,Name,Summary With StartDate,EndDate,IsCurrent
		 */
		public List<Projects> getProjects() {
			return projects;
		}
		/**
		 * Array of Objects,string represents  Id,Name,Summary With StartDate,EndDate,IsCurrent
		 */
		public void setProjects(List<Projects> projects) {
			this.projects = projects;
		}
		/**
		 * Name of the provider
		 */
		public String getProvider() {
			return provider;
		}
		/**
		 * Name of the provider
		 */
		public void setProvider(String provider) {
			this.provider = provider;
		}
		/**
		 * Object,string represents AccessToken,TokenSecret
		 */
		public ProviderAccessCredential getProviderAccessCredential() {
			return providerAccessCredential;
		}
		/**
		 * Object,string represents AccessToken,TokenSecret
		 */
		public void setProviderAccessCredential(ProviderAccessCredential providerAccessCredential) {
			this.providerAccessCredential = providerAccessCredential;
		}
		/**
		 * Array of Objects,string represents Id,Title,Publisher,Authors,Date,Url,Summary
		 */
		public List<Publications> getPublications() {
			return publications;
		}
		/**
		 * Array of Objects,string represents Id,Title,Publisher,Authors,Date,Url,Summary
		 */
		public void setPublications(List<Publications> publications) {
			this.publications = publications;
		}
		/**
		 * gist is a Git repository, which means that it can be forked and cloned.
		 */
		public Integer getPublicGists() {
			return publicGists;
		}
		/**
		 * gist is a Git repository, which means that it can be forked and cloned.
		 */
		public void setPublicGists(Integer publicGists) {
			this.publicGists = publicGists;
		}
		/**
		 * user public Repository Urls
		 */
		public String getPublicRepository() {
			return publicRepository;
		}
		/**
		 * user public Repository Urls
		 */
		public void setPublicRepository(String publicRepository) {
			this.publicRepository = publicRepository;
		}
		/**
		 * Quota
		 */
		public String getQuota() {
			return quota;
		}
		/**
		 * Quota
		 */
		public void setQuota(String quota) {
			this.quota = quota;
		}
		/**
		 * quote
		 */
		public String getQuote() {
			return quote;
		}
		/**
		 * quote
		 */
		public void setQuote(String quote) {
			this.quote = quote;
		}
		/**
		 * Array of Objects,string represents Id,RecommendationType,RecommendationText,Recommender
		 */
		public List<RecommendationsReceived> getRecommendationsReceived() {
			return recommendationsReceived;
		}
		/**
		 * Array of Objects,string represents Id,RecommendationType,RecommendationText,Recommender
		 */
		public void setRecommendationsReceived(List<RecommendationsReceived> recommendationsReceived) {
			this.recommendationsReceived = recommendationsReceived;
		}
		/**
		 * Array of Objects,String represents Id,FirstName,LastName
		 */
		public List<RelatedProfileViews> getRelatedProfileViews() {
			return relatedProfileViews;
		}
		/**
		 * Array of Objects,String represents Id,FirstName,LastName
		 */
		public void setRelatedProfileViews(List<RelatedProfileViews> relatedProfileViews) {
			this.relatedProfileViews = relatedProfileViews;
		}
		/**
		 * user's relationship status
		 */
		public String getRelationshipStatus() {
			return relationshipStatus;
		}
		/**
		 * user's relationship status
		 */
		public void setRelationshipStatus(String relationshipStatus) {
			this.relationshipStatus = relationshipStatus;
		}
		/**
		 * String shows users religion
		 */
		public String getReligion() {
			return religion;
		}
		/**
		 * String shows users religion
		 */
		public void setReligion(String religion) {
			this.religion = religion;
		}
		/**
		 * Repository URL
		 */
		public String getRepositoryUrl() {
			return repositoryUrl;
		}
		/**
		 * Repository URL
		 */
		public void setRepositoryUrl(String repositoryUrl) {
			this.repositoryUrl = repositoryUrl;
		}
		/**
		 * Signup date
		 */
		public String getSignupDate() {
			return signupDate;
		}
		/**
		 * Signup date
		 */
		public void setSignupDate(String signupDate) {
			this.signupDate = signupDate;
		}
		/**
		 * Array of objects, String represents ID and Name
		 */
		public List<Skills> getSkills() {
			return skills;
		}
		/**
		 * Array of objects, String represents ID and Name
		 */
		public void setSkills(List<Skills> skills) {
			this.skills = skills;
		}
		/**
		 * Array of objects, String represents ID and Name
		 */
		public List<Sports> getSports() {
			return sports;
		}
		/**
		 * Array of objects, String represents ID and Name
		 */
		public void setSports(List<Sports> sports) {
			this.sports = sports;
		}
		/**
		 * Git users bookmark repositories
		 */
		public String getStarredUrl() {
			return starredUrl;
		}
		/**
		 * Git users bookmark repositories
		 */
		public void setStarredUrl(String starredUrl) {
			this.starredUrl = starredUrl;
		}
		/**
		 * State of the user
		 */
		public String getState() {
			return state;
		}
		/**
		 * State of the user
		 */
		public void setState(String state) {
			this.state = state;
		}
		/**
		 * Object,string represents Name,Space,PrivateRepos,Collaborators
		 */
		public GitHubPlan getSubscription() {
			return subscription;
		}
		/**
		 * Object,string represents Name,Space,PrivateRepos,Collaborators
		 */
		public void setSubscription(GitHubPlan subscription) {
			this.subscription = subscription;
		}
		/**
		 * Suffix for the User.
		 */
		public String getSuffix() {
			return suffix;
		}
		/**
		 * Suffix for the User.
		 */
		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
		/**
		 * Object,array of objects represents	CompaniestoFollow,IndustriestoFollow,NewssourcetoFollow,PeopletoFollow
		 */
		public Suggestions getSuggestions() {
			return suggestions;
		}
		/**
		 * Object,array of objects represents	CompaniestoFollow,IndustriestoFollow,NewssourcetoFollow,PeopletoFollow
		 */
		public void setSuggestions(Suggestions suggestions) {
			this.suggestions = suggestions;
		}
		/**
		 * Tagline that need to be inserted
		 */
		public String getTagLine() {
			return tagLine;
		}
		/**
		 * Tagline that need to be inserted
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
		 * URL for the Thumbnail
		 */
		public String getThumbnailImageUrl() {
			return thumbnailImageUrl;
		}
		/**
		 * URL for the Thumbnail
		 */
		public void setThumbnailImageUrl(String thumbnailImageUrl) {
			this.thumbnailImageUrl = thumbnailImageUrl;
		}
		/**
		 * The Current Time Zone.
		 */
		public String getTimeZone() {
			return timeZone;
		}
		/**
		 * The Current Time Zone.
		 */
		public void setTimeZone(String timeZone) {
			this.timeZone = timeZone;
		}
		/**
		 * Total Private repository
		 */
		public Integer getTotalPrivateRepository() {
			return totalPrivateRepository;
		}
		/**
		 * Total Private repository
		 */
		public void setTotalPrivateRepository(Integer totalPrivateRepository) {
			this.totalPrivateRepository = totalPrivateRepository;
		}
		/**
		 * Count of Total status
		 */
		public Integer getTotalStatusesCount() {
			return totalStatusesCount;
		}
		/**
		 * Count of Total status
		 */
		public void setTotalStatusesCount(Integer totalStatusesCount) {
			this.totalStatusesCount = totalStatusesCount;
		}
		/**
		 * updated date
		 */
		public String getUpdatedTime() {
			return updatedTime;
		}
		/**
		 * updated date
		 */
		public void setUpdatedTime(String updatedTime) {
			this.updatedTime = updatedTime;
		}
		/**
		 * verified
		 */
		public String getVerified() {
			return verified;
		}
		/**
		 * verified
		 */
		public void setVerified(String verified) {
			this.verified = verified;
		}
		/**
		 * Array of Objects,string represents Id,Role,Organization,Cause
		 */
		public List<Volunteer> getVolunteer() {
			return volunteer;
		}
		/**
		 * Array of Objects,string represents Id,Role,Organization,Cause
		 */
		public void setVolunteer(List<Volunteer> volunteer) {
			this.volunteer = volunteer;
		}
		/**
		 * Twitter, Facebook ProfileUrls
		 */
		public Map<String,String> getWebProfiles() {
			return webProfiles;
		}
		/**
		 * Twitter, Facebook ProfileUrls
		 */
		public void setWebProfiles(Map<String,String> webProfiles) {
			this.webProfiles = webProfiles;
		}
		/**
		 * Personal Website a User has
		 */
		public String getWebsite() {
			return website;
		}
		/**
		 * Personal Website a User has
		 */
		public void setWebsite(String website) {
			this.website = website;
		}
    }