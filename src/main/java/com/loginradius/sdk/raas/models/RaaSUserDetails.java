package com.loginradius.sdk.raas.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.google.gson.JsonObject;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusAddress;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusAgeRange;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusAward;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusBadge;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusBook;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusCertification;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusCountry;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusCourse;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusCurrentStatus;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusEducation;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusEmail;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusFamily;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusFavoriteThing;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusGame;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusIMAccount;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusInspirationalPeople;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusInterest;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusJobBookmark;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusKloutProfile;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusLanguage;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusMemberUrlResource;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusMovie;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusMutualFriend;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusPatent;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusPhoneNumber;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusPlaceLived;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusPosition;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusProject;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusPublication;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusRecommendationReceived;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusRelatedProfileViews;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusSkill;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusSport;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusSuggestion;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusTelevisionShow;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusUltimateUserProfile;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusUserSubscription;
import com.loginradius.sdk.social.models.userprofile.LoginradiusVolunteer;
import com.loginradius.sdk.social.models.userprofile.ProviderAccessCredential;

public class RaaSUserDetails extends LoginRadiusUltimateUserProfile {

	@SerializedName("password")
	private String password;
	@SerializedName("Uid")
	private String Uid;
	@SerializedName("emailid")
	private String emailId;
	
	@SerializedName("EmailVerified")
	private boolean emailVerified;
	@SerializedName("IsDeleted")
	private boolean isDeleted;
	@SerializedName("FirstLogin")
	private boolean FirstLogin;
	@SerializedName("IsActive")
	private boolean IsActive;
	@SerializedName("IsEmailSubscribed")
	private boolean IsEmailSubscribed;
	
	@SerializedName("CustomFields")
	private transient JsonObject CustomFields;

	
	public boolean getIsEmailSubscribed() {
		return IsEmailSubscribed;
	}

	
	public boolean getIsActive() {
		return IsActive;
	}

	public JsonObject getCustomFields() {
		
		return CustomFields;
	
	}

	public String getEmailId() {
		return emailId;
	}

	public boolean getFirstLogin() {
		return FirstLogin;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getUid() {
		return Uid;
	}

	public void setUid(String Uid) {
		this.Uid = Uid;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getProvider() {
		return Provider;
	}

	public void setProvider(String provider) {
		Provider = provider;
	}

	public String getPrefix() {
		return Prefix;
	}

	public void setPrefix(String prefix) {
		Prefix = prefix;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getSuffix() {
		return Suffix;
	}

	public void setSuffix(String suffix) {
		Suffix = suffix;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public String getProfileName() {
		return ProfileName;
	}

	public void setProfileName(String profileName) {
		ProfileName = profileName;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public List<LoginRadiusEmail> getEmail() {
		return Email;
	}

	public void setEmail(List<LoginRadiusEmail> email) {
		Email = email;
	}

	public LoginRadiusCountry getCountry() {
		return Country;
	}

	public void setCountry(LoginRadiusCountry country) {
		Country = country;
	}

	public String getThumbnailImageUrl() {
		return ThumbnailImageUrl;
	}

	public void setThumbnailImageUrl(String thumbnailImageUrl) {
		ThumbnailImageUrl = thumbnailImageUrl;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public String getFavicon() {
		return Favicon;
	}

	public void setFavicon(String favicon) {
		Favicon = favicon;
	}

	public String getProfileUrl() {
		return ProfileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		ProfileUrl = profileUrl;
	}

	public String getHomeTown() {
		return HomeTown;
	}

	public void setHomeTown(String homeTown) {
		HomeTown = homeTown;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getIndustry() {
		return Industry;
	}

	public void setIndustry(String industry) {
		Industry = industry;
	}

	public String getAbout() {
		return About;
	}

	public void setAbout(String about) {
		About = about;
	}

	public String getTimeZone() {
		return TimeZone;
	}

	public void setTimeZone(String timeZone) {
		TimeZone = timeZone;
	}

	public String getLocalLanguage() {
		return LocalLanguage;
	}

	public void setLocalLanguage(String localLanguage) {
		LocalLanguage = localLanguage;
	}

	public String getCoverPhoto() {
		return CoverPhoto;
	}

	public void setCoverPhoto(String coverPhoto) {
		CoverPhoto = coverPhoto;
	}

	public String getTagLine() {
		return TagLine;
	}

	public void setTagLine(String tagLine) {
		TagLine = tagLine;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getVerified() {
		return Verified;
	}

	public void setVerified(String verified) {
		Verified = verified;
	}

	public String getUpdatedTime() {
		return UpdatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		UpdatedTime = updatedTime;
	}

	public List<LoginRadiusPosition> getPositions() {
		return Positions;
	}

	public void setPositions(List<LoginRadiusPosition> positions) {
		Positions = positions;
	}

	public List<LoginRadiusEducation> getEducations() {
		return Educations;
	}

	public void setEducations(List<LoginRadiusEducation> educations) {
		Educations = educations;
	}

	public List<LoginRadiusPhoneNumber> getPhoneNumbers() {
		return PhoneNumbers;
	}

	public void setPhoneNumbers(List<LoginRadiusPhoneNumber> phoneNumbers) {
		PhoneNumbers = phoneNumbers;
	}

	public List<LoginRadiusIMAccount> getIMAccounts() {
		return IMAccounts;
	}

	public void setIMAccounts(List<LoginRadiusIMAccount> iMAccounts) {
		IMAccounts = iMAccounts;
	}

	public List<LoginRadiusAddress> getAddresses() {
		return Addresses;
	}

	public void setAddresses(List<LoginRadiusAddress> addresses) {
		Addresses = addresses;
	}

	public String getMainAddress() {
		return MainAddress;
	}

	public void setMainAddress(String mainAddress) {
		MainAddress = mainAddress;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	public String getLocalCity() {
		return LocalCity;
	}

	public void setLocalCity(String localCity) {
		LocalCity = localCity;
	}

	public String getProfileCity() {
		return ProfileCity;
	}

	public void setProfileCity(String profileCity) {
		ProfileCity = profileCity;
	}

	public String getLocalCountry() {
		return LocalCountry;
	}

	public void setLocalCountry(String localCountry) {
		LocalCountry = localCountry;
	}

	public String getProfileCountry() {
		return ProfileCountry;
	}

	public void setProfileCountry(String profileCountry) {
		ProfileCountry = profileCountry;
	}

	public boolean isIsProtected() {
		return IsProtected;
	}

	public void setIsProtected(boolean isProtected) {
		IsProtected = isProtected;
	}

	public String getRelationshipStatus() {
		return RelationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		RelationshipStatus = relationshipStatus;
	}

	public String getQuota() {
		return Quota;
	}

	public void setQuota(String quota) {
		Quota = quota;
	}

	public List<String> getInterestedIn() {
		return InterestedIn;
	}

	public void setInterestedIn(List<String> interestedIn) {
		InterestedIn = interestedIn;
	}

	public List<LoginRadiusInterest> getInterests() {
		return Interests;
	}

	public void setInterests(List<LoginRadiusInterest> interests) {
		Interests = interests;
	}

	public String getReligion() {
		return Religion;
	}

	public void setReligion(String religion) {
		Religion = religion;
	}

	public String getPolitical() {
		return Political;
	}

	public void setPolitical(String political) {
		Political = political;
	}

	public List<LoginRadiusSport> getSports() {
		return Sports;
	}

	public void setSports(List<LoginRadiusSport> sports) {
		Sports = sports;
	}

	public List<LoginRadiusInspirationalPeople> getInspirationalPeople() {
		return InspirationalPeople;
	}

	public void setInspirationalPeople(
			List<LoginRadiusInspirationalPeople> inspirationalPeople) {
		InspirationalPeople = inspirationalPeople;
	}

	public String getHttpsImageUrl() {
		return HttpsImageUrl;
	}

	public void setHttpsImageUrl(String httpsImageUrl) {
		HttpsImageUrl = httpsImageUrl;
	}

	public int getFollowersCount() {
		return FollowersCount;
	}

	public void setFollowersCount(int followersCount) {
		FollowersCount = followersCount;
	}

	public int getFriendsCount() {
		return FriendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		FriendsCount = friendsCount;
	}

	public String getIsGeoEnabled() {
		return IsGeoEnabled;
	}

	public void setIsGeoEnabled(String isGeoEnabled) {
		IsGeoEnabled = isGeoEnabled;
	}

	public int getTotalStatusesCount() {
		return TotalStatusesCount;
	}

	public void setTotalStatusesCount(int totalStatusesCount) {
		TotalStatusesCount = totalStatusesCount;
	}

	public String getAssociations() {
		return Associations;
	}

	public void setAssociations(String associations) {
		Associations = associations;
	}

	public int getNumRecommenders() {
		return NumRecommenders;
	}

	public void setNumRecommenders(int numRecommenders) {
		NumRecommenders = numRecommenders;
	}

	public String getHonors() {
		return Honors;
	}

	public void setHonors(String honors) {
		Honors = honors;
	}

	public List<LoginRadiusAward> getAwards() {
		return Awards;
	}

	public void setAwards(List<LoginRadiusAward> awards) {
		Awards = awards;
	}

	public List<LoginRadiusSkill> getSkills() {
		return Skills;
	}

	public void setSkills(List<LoginRadiusSkill> skills) {
		Skills = skills;
	}

	public List<LoginRadiusCurrentStatus> getCurrentStatus() {
		return CurrentStatus;
	}

	public void setCurrentStatus(List<LoginRadiusCurrentStatus> currentStatus) {
		CurrentStatus = currentStatus;
	}

	public List<LoginRadiusCertification> getCertifications() {
		return Certifications;
	}

	public void setCertifications(List<LoginRadiusCertification> certifications) {
		Certifications = certifications;
	}

	public List<LoginRadiusCourse> getCourses() {
		return Courses;
	}

	public void setCourses(List<LoginRadiusCourse> courses) {
		Courses = courses;
	}

	public List<LoginradiusVolunteer> getVolunteer() {
		return Volunteer;
	}

	public void setVolunteer(List<LoginradiusVolunteer> volunteer) {
		Volunteer = volunteer;
	}

	public List<LoginRadiusRecommendationReceived> getRecommendationsReceived() {
		return RecommendationsReceived;
	}

	public void setRecommendationsReceived(
			List<LoginRadiusRecommendationReceived> recommendationsReceived) {
		RecommendationsReceived = recommendationsReceived;
	}

	public List<LoginRadiusLanguage> getLanguages() {
		return Languages;
	}

	public void setLanguages(List<LoginRadiusLanguage> languages) {
		Languages = languages;
	}

	public List<LoginRadiusProject> getProjects() {
		return Projects;
	}

	public void setProjects(List<LoginRadiusProject> projects) {
		Projects = projects;
	}

	public List<LoginRadiusGame> getGames() {
		return Games;
	}

	public void setGames(List<LoginRadiusGame> games) {
		Games = games;
	}

	public List<LoginRadiusFamily> getFamily() {
		return Family;
	}

	public void setFamily(List<LoginRadiusFamily> family) {
		Family = family;
	}

	public List<LoginRadiusTelevisionShow> getTeleVisionShow() {
		return TeleVisionShow;
	}

	public void setTeleVisionShow(List<LoginRadiusTelevisionShow> teleVisionShow) {
		TeleVisionShow = teleVisionShow;
	}

	public List<LoginRadiusMutualFriend> getMutualFriends() {
		return MutualFriends;
	}

	public void setMutualFriends(List<LoginRadiusMutualFriend> mutualFriends) {
		MutualFriends = mutualFriends;
	}

	public List<LoginRadiusMovie> getMovies() {
		return Movies;
	}

	public void setMovies(List<LoginRadiusMovie> movies) {
		Movies = movies;
	}

	public List<LoginRadiusBook> getBooks() {
		return Books;
	}

	public void setBooks(List<LoginRadiusBook> books) {
		Books = books;
	}

	public LoginRadiusAgeRange getAgeRange() {
		return AgeRange;
	}

	public void setAgeRange(LoginRadiusAgeRange ageRange) {
		AgeRange = ageRange;
	}

	public String getPublicRepository() {
		return PublicRepository;
	}

	public void setPublicRepository(String publicRepository) {
		PublicRepository = publicRepository;
	}

	public Boolean getHireable() {
		return Hireable;
	}

	public void setHireable(Boolean hireable) {
		Hireable = hireable;
	}

	public String getRepositoryUrl() {
		return RepositoryUrl;
	}

	public void setRepositoryUrl(String repositoryUrl) {
		RepositoryUrl = repositoryUrl;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public List<LoginRadiusPatent> getPatents() {
		return Patents;
	}

	public void setPatents(List<LoginRadiusPatent> patents) {
		Patents = patents;
	}

	public List<LoginRadiusFavoriteThing> getFavoriteThings() {
		return FavoriteThings;
	}

	public void setFavoriteThings(List<LoginRadiusFavoriteThing> favoriteThings) {
		FavoriteThings = favoriteThings;
	}

	public String getProfessionalHeadline() {
		return ProfessionalHeadline;
	}

	public void setProfessionalHeadline(String professionalHeadline) {
		ProfessionalHeadline = professionalHeadline;
	}

	public ProviderAccessCredential getProviderAccessCredential() {
		return ProviderAccessCredential;
	}

	public void setProviderAccessCredential(
			ProviderAccessCredential providerAccessCredential) {
		ProviderAccessCredential = providerAccessCredential;
	}

	public List<LoginRadiusRelatedProfileViews> getRelatedProfileViews() {
		return RelatedProfileViews;
	}

	public void setRelatedProfileViews(
			List<LoginRadiusRelatedProfileViews> relatedProfileViews) {
		RelatedProfileViews = relatedProfileViews;
	}

	public LoginRadiusKloutProfile getKloutScore() {
		return KloutScore;
	}

	public void setKloutScore(LoginRadiusKloutProfile kloutScore) {
		KloutScore = kloutScore;
	}

	public String getLRUserID() {
		return LRUserID;
	}

	public void setLRUserID(String lRUserID) {
		LRUserID = lRUserID;
	}

	public List<LoginRadiusPlaceLived> getPlacesLived() {
		return PlacesLived;
	}

	public void setPlacesLived(List<LoginRadiusPlaceLived> placesLived) {
		PlacesLived = placesLived;
	}

	public List<LoginRadiusPublication> getPublications() {
		return Publications;
	}

	public void setPublications(List<LoginRadiusPublication> publications) {
		Publications = publications;
	}

	public List<LoginRadiusJobBookmark> getJobBookmarks() {
		return JobBookmarks;
	}

	public void setJobBookmarks(List<LoginRadiusJobBookmark> jobBookmarks) {
		JobBookmarks = jobBookmarks;
	}

	public LoginRadiusSuggestion getSuggestions() {
		return Suggestions;
	}

	public void setSuggestions(LoginRadiusSuggestion suggestions) {
		Suggestions = suggestions;
	}

	public List<LoginRadiusBadge> getBadges() {
		return Badges;
	}

	public void setBadges(List<LoginRadiusBadge> badges) {
		Badges = badges;
	}

	public List<LoginRadiusMemberUrlResource> getMemberUrlResources() {
		return MemberUrlResources;
	}

	public void setMemberUrlResources(
			List<LoginRadiusMemberUrlResource> memberUrlResources) {
		MemberUrlResources = memberUrlResources;
	}

	public int getTotalPrivateRepository() {
		return TotalPrivateRepository;
	}

	public void setTotalPrivateRepository(int totalPrivateRepository) {
		TotalPrivateRepository = totalPrivateRepository;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getStarredUrl() {
		return StarredUrl;
	}

	public void setStarredUrl(String starredUrl) {
		StarredUrl = starredUrl;
	}

	public String getGistsUrl() {
		return GistsUrl;
	}

	public void setGistsUrl(String gistsUrl) {
		GistsUrl = gistsUrl;
	}

	public int getPublicGists() {
		return PublicGists;
	}

	public void setPublicGists(int publicGists) {
		PublicGists = publicGists;
	}

	public int getPrivateGists() {
		return PrivateGists;
	}

	public void setPrivateGists(int privateGists) {
		PrivateGists = privateGists;
	}

	public LoginRadiusUserSubscription getSubscription() {
		return Subscription;
	}

	public void setSubscription(LoginRadiusUserSubscription subscription) {
		Subscription = subscription;
	}
	
	public void setCustomFields(JsonObject customfields) {
		
		 this.CustomFields = customfields;
	
	}

}
