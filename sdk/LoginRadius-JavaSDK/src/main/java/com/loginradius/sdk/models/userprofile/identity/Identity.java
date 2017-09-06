package com.loginradius.sdk.models.userprofile.identity;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identity {
	
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
	private String firstName;
	@SerializedName("MiddleName")
	@Expose
	private String middleName;
	@SerializedName("LastName")
	@Expose
	private String lastName;
	@SerializedName("Suffix")
	@Expose
	private Object suffix;
	@SerializedName("FullName")
	@Expose
	private String fullName;
	@SerializedName("NickName")
	@Expose
	private Object nickName;
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
	private List<Email> email = null;
	@SerializedName("Country")
	@Expose
	private Object country;
	@SerializedName("ThumbnailImageUrl")
	@Expose
	private String thumbnailImageUrl;
	@SerializedName("ImageUrl")
	@Expose
	private String imageUrl;
	@SerializedName("Favicon")
	@Expose
	private Object favicon;
	@SerializedName("ProfileUrl")
	@Expose
	private String profileUrl;
	@SerializedName("HomeTown")
	@Expose
	private String homeTown;
	@SerializedName("State")
	@Expose
	private Object state;
	@SerializedName("City")
	@Expose
	private String city;
	@SerializedName("Industry")
	@Expose
	private Object industry;
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
	private Object tagLine;
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
	private List<Position> positions = null;
	@SerializedName("Educations")
	@Expose
	private List<Education> educations = null;
	@SerializedName("PhoneNumbers")
	@Expose
	private Object phoneNumbers;
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
	@SerializedName("CreatedDate")
	@Expose
	private String createdDate;
	@SerializedName("ModifiedDate")
	@Expose
	private String modifiedDate;
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
	private Object profileCountry;
	@SerializedName("FirstLogin")
	@Expose
	private Boolean firstLogin;
	@SerializedName("IsProtected")
	@Expose
	private Boolean isProtected;
	@SerializedName("RelationshipStatus")
	@Expose
	private String relationshipStatus;
	@SerializedName("Quota")
	@Expose
	private String quota;
	@SerializedName("Quote")
	@Expose
	private String quote;
	@SerializedName("InterestedIn")
	@Expose
	private List<String> interestedIn = null;
	@SerializedName("Interests")
	@Expose
	private Object interests;
	@SerializedName("Religion")
	@Expose
	private String religion;
	@SerializedName("Political")
	@Expose
	private String political;
	@SerializedName("Sports")
	@Expose
	private List<Sport> sports = null;
	@SerializedName("InspirationalPeople")
	@Expose
	private Object inspirationalPeople;
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
	private List<Language> languages = null;
	@SerializedName("Projects")
	@Expose
	private List<Object> projects = null;
	@SerializedName("Games")
	@Expose
	private List<Game> games = null;
	@SerializedName("Family")
	@Expose
	private Object family;
	@SerializedName("TeleVisionShow")
	@Expose
	private List<TeleVisionShow> teleVisionShow = null;
	@SerializedName("MutualFriends")
	@Expose
	private Object mutualFriends;
	@SerializedName("Movies")
	@Expose
	private List<Movie> movies = null;
	@SerializedName("Books")
	@Expose
	private List<Book> books = null;
	@SerializedName("AgeRange")
	@Expose
	private AgeRange ageRange;
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
	private String age;
	@SerializedName("Patents")
	@Expose
	private Object patents;
	@SerializedName("FavoriteThings")
	@Expose
	private List<FavoriteThing> favoriteThings = null;
	@SerializedName("ProfessionalHeadline")
	@Expose
	private Object professionalHeadline;
	
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
	private String currency;
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
	private String gravatarImageUrl;
	@SerializedName("ProfileImageUrls")
	@Expose
	private ProfileImageUrls profileImageUrls;
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

	public String getID() {
	return iD;
	}

	public void setID(String iD) {
	this.iD = iD;
	}

	public String getProvider() {
	return provider;
	}

	public void setProvider(String provider) {
	this.provider = provider;
	}

	public Object getPrefix() {
	return prefix;
	}

	public void setPrefix(Object prefix) {
	this.prefix = prefix;
	}

	public String getFirstName() {
	return firstName;
	}

	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}

	public String getMiddleName() {
	return middleName;
	}

	public void setMiddleName(String middleName) {
	this.middleName = middleName;
	}

	public String getLastName() {
	return lastName;
	}

	public void setLastName(String lastName) {
	this.lastName = lastName;
	}

	public Object getSuffix() {
	return suffix;
	}

	public void setSuffix(Object suffix) {
	this.suffix = suffix;
	}

	public String getFullName() {
	return fullName;
	}

	public void setFullName(String fullName) {
	this.fullName = fullName;
	}

	public Object getNickName() {
	return nickName;
	}

	public void setNickName(Object nickName) {
	this.nickName = nickName;
	}

	public String getProfileName() {
	return profileName;
	}

	public void setProfileName(String profileName) {
	this.profileName = profileName;
	}

	public String getBirthDate() {
	return birthDate;
	}

	public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
	}

	public String getGender() {
	return gender;
	}

	public void setGender(String gender) {
	this.gender = gender;
	}

	public String getWebsite() {
	return website;
	}

	public void setWebsite(String website) {
	this.website = website;
	}

	public List<Email> getEmail() {
	return email;
	}

	public void setEmail(List<Email> email) {
	this.email = email;
	}

	public Object getCountry() {
	return country;
	}

	public void setCountry(Object country) {
	this.country = country;
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

	public Object getFavicon() {
	return favicon;
	}

	public void setFavicon(Object favicon) {
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

	public Object getState() {
	return state;
	}

	public void setState(Object state) {
	this.state = state;
	}

	public String getCity() {
	return city;
	}

	public void setCity(String city) {
	this.city = city;
	}

	public Object getIndustry() {
	return industry;
	}

	public void setIndustry(Object industry) {
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

	public Object getTagLine() {
	return tagLine;
	}

	public void setTagLine(Object tagLine) {
	this.tagLine = tagLine;
	}

	public String getLanguage() {
	return language;
	}

	public void setLanguage(String language) {
	this.language = language;
	}

	public String getVerified() {
	return verified;
	}

	public void setVerified(String verified) {
	this.verified = verified;
	}

	public String getUpdatedTime() {
	return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
	this.updatedTime = updatedTime;
	}

	public List<Position> getPositions() {
	return positions;
	}

	public void setPositions(List<Position> positions) {
	this.positions = positions;
	}

	public List<Education> getEducations() {
	return educations;
	}

	public void setEducations(List<Education> educations) {
	this.educations = educations;
	}

	public Object getPhoneNumbers() {
	return phoneNumbers;
	}

	public void setPhoneNumbers(Object phoneNumbers) {
	this.phoneNumbers = phoneNumbers;
	}

	public Object getIMAccounts() {
	return iMAccounts;
	}

	public void setIMAccounts(Object iMAccounts) {
	this.iMAccounts = iMAccounts;
	}

	public Object getAddresses() {
	return addresses;
	}

	public void setAddresses(Object addresses) {
	this.addresses = addresses;
	}

	public Object getMainAddress() {
	return mainAddress;
	}

	public void setMainAddress(Object mainAddress) {
	this.mainAddress = mainAddress;
	}

	public Object getCreated() {
	return created;
	}

	public void setCreated(Object created) {
	this.created = created;
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

	public String getLocalCity() {
	return localCity;
	}

	public void setLocalCity(String localCity) {
	this.localCity = localCity;
	}

	public String getProfileCity() {
	return profileCity;
	}

	public void setProfileCity(String profileCity) {
	this.profileCity = profileCity;
	}

	public String getLocalCountry() {
	return localCountry;
	}

	public void setLocalCountry(String localCountry) {
	this.localCountry = localCountry;
	}

	public Object getProfileCountry() {
	return profileCountry;
	}

	public void setProfileCountry(Object profileCountry) {
	this.profileCountry = profileCountry;
	}

	public Boolean getFirstLogin() {
	return firstLogin;
	}

	public void setFirstLogin(Boolean firstLogin) {
	this.firstLogin = firstLogin;
	}

	public Boolean getIsProtected() {
	return isProtected;
	}

	public void setIsProtected(Boolean isProtected) {
	this.isProtected = isProtected;
	}

	public String getRelationshipStatus() {
	return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
	this.relationshipStatus = relationshipStatus;
	}

	public String getQuota() {
	return quota;
	}

	public void setQuota(String quota) {
	this.quota = quota;
	}

	public String getQuote() {
	return quote;
	}

	public void setQuote(String quote) {
	this.quote = quote;
	}

	public List<String> getInterestedIn() {
	return interestedIn;
	}

	public void setInterestedIn(List<String> interestedIn) {
	this.interestedIn = interestedIn;
	}

	public Object getInterests() {
	return interests;
	}

	public void setInterests(Object interests) {
	this.interests = interests;
	}

	public String getReligion() {
	return religion;
	}

	public void setReligion(String religion) {
	this.religion = religion;
	}

	public String getPolitical() {
	return political;
	}

	public void setPolitical(String political) {
	this.political = political;
	}

	public List<Sport> getSports() {
	return sports;
	}

	public void setSports(List<Sport> sports) {
	this.sports = sports;
	}

	public Object getInspirationalPeople() {
	return inspirationalPeople;
	}

	public void setInspirationalPeople(Object inspirationalPeople) {
	this.inspirationalPeople = inspirationalPeople;
	}

	public String getHttpsImageUrl() {
	return httpsImageUrl;
	}

	public void setHttpsImageUrl(String httpsImageUrl) {
	this.httpsImageUrl = httpsImageUrl;
	}

	public Integer getFollowersCount() {
	return followersCount;
	}

	public void setFollowersCount(Integer followersCount) {
	this.followersCount = followersCount;
	}

	public Integer getFriendsCount() {
	return friendsCount;
	}

	public void setFriendsCount(Integer friendsCount) {
	this.friendsCount = friendsCount;
	}

	public Object getIsGeoEnabled() {
	return isGeoEnabled;
	}

	public void setIsGeoEnabled(Object isGeoEnabled) {
	this.isGeoEnabled = isGeoEnabled;
	}

	public Integer getTotalStatusesCount() {
	return totalStatusesCount;
	}

	public void setTotalStatusesCount(Integer totalStatusesCount) {
	this.totalStatusesCount = totalStatusesCount;
	}

	public Object getAssociations() {
	return associations;
	}

	public void setAssociations(Object associations) {
	this.associations = associations;
	}

	public Integer getNumRecommenders() {
	return numRecommenders;
	}

	public void setNumRecommenders(Integer numRecommenders) {
	this.numRecommenders = numRecommenders;
	}

	public Object getHonors() {
	return honors;
	}

	public void setHonors(Object honors) {
	this.honors = honors;
	}

	public Object getAwards() {
	return awards;
	}

	public void setAwards(Object awards) {
	this.awards = awards;
	}

	public Object getSkills() {
	return skills;
	}

	public void setSkills(Object skills) {
	this.skills = skills;
	}

	public Object getCurrentStatus() {
	return currentStatus;
	}

	public void setCurrentStatus(Object currentStatus) {
	this.currentStatus = currentStatus;
	}

	public Object getCertifications() {
	return certifications;
	}

	public void setCertifications(Object certifications) {
	this.certifications = certifications;
	}

	public Object getCourses() {
	return courses;
	}

	public void setCourses(Object courses) {
	this.courses = courses;
	}

	public Object getVolunteer() {
	return volunteer;
	}

	public void setVolunteer(Object volunteer) {
	this.volunteer = volunteer;
	}

	public Object getRecommendationsReceived() {
	return recommendationsReceived;
	}

	public void setRecommendationsReceived(Object recommendationsReceived) {
	this.recommendationsReceived = recommendationsReceived;
	}

	public List<Language> getLanguages() {
	return languages;
	}

	public void setLanguages(List<Language> languages) {
	this.languages = languages;
	}

	public List<Object> getProjects() {
	return projects;
	}

	public void setProjects(List<Object> projects) {
	this.projects = projects;
	}

	public List<Game> getGames() {
	return games;
	}

	public void setGames(List<Game> games) {
	this.games = games;
	}

	public Object getFamily() {
	return family;
	}

	public void setFamily(Object family) {
	this.family = family;
	}

	public List<TeleVisionShow> getTeleVisionShow() {
	return teleVisionShow;
	}

	public void setTeleVisionShow(List<TeleVisionShow> teleVisionShow) {
	this.teleVisionShow = teleVisionShow;
	}

	public Object getMutualFriends() {
	return mutualFriends;
	}

	public void setMutualFriends(Object mutualFriends) {
	this.mutualFriends = mutualFriends;
	}

	public List<Movie> getMovies() {
	return movies;
	}

	public void setMovies(List<Movie> movies) {
	this.movies = movies;
	}

	public List<Book> getBooks() {
	return books;
	}

	public void setBooks(List<Book> books) {
	this.books = books;
	}

	public AgeRange getAgeRange() {
	return ageRange;
	}

	public void setAgeRange(AgeRange ageRange) {
	this.ageRange = ageRange;
	}

	public Object getPublicRepository() {
	return publicRepository;
	}

	public void setPublicRepository(Object publicRepository) {
	this.publicRepository = publicRepository;
	}

	public Boolean getHireable() {
	return hireable;
	}

	public void setHireable(Boolean hireable) {
	this.hireable = hireable;
	}

	public Object getRepositoryUrl() {
	return repositoryUrl;
	}

	public void setRepositoryUrl(Object repositoryUrl) {
	this.repositoryUrl = repositoryUrl;
	}

	public String getAge() {
	return age;
	}

	public void setAge(String age) {
	this.age = age;
	}

	public Object getPatents() {
	return patents;
	}

	public void setPatents(Object patents) {
	this.patents = patents;
	}

	public List<FavoriteThing> getFavoriteThings() {
	return favoriteThings;
	}

	public void setFavoriteThings(List<FavoriteThing> favoriteThings) {
	this.favoriteThings = favoriteThings;
	}

	public Object getProfessionalHeadline() {
	return professionalHeadline;
	}

	public void setProfessionalHeadline(Object professionalHeadline) {
	this.professionalHeadline = professionalHeadline;
	}

	public Object getRelatedProfileViews() {
	return relatedProfileViews;
	}

	public void setRelatedProfileViews(Object relatedProfileViews) {
	this.relatedProfileViews = relatedProfileViews;
	}

	public Object getKloutScore() {
	return kloutScore;
	}

	public void setKloutScore(Object kloutScore) {
	this.kloutScore = kloutScore;
	}

	public Object getLRUserID() {
	return lRUserID;
	}

	public void setLRUserID(Object lRUserID) {
	this.lRUserID = lRUserID;
	}

	public Object getPlacesLived() {
	return placesLived;
	}

	public void setPlacesLived(Object placesLived) {
	this.placesLived = placesLived;
	}

	public Object getPublications() {
	return publications;
	}

	public void setPublications(Object publications) {
	this.publications = publications;
	}

	public Object getJobBookmarks() {
	return jobBookmarks;
	}

	public void setJobBookmarks(Object jobBookmarks) {
	this.jobBookmarks = jobBookmarks;
	}

	public Object getSuggestions() {
	return suggestions;
	}

	public void setSuggestions(Object suggestions) {
	this.suggestions = suggestions;
	}

	public Object getBadges() {
	return badges;
	}

	public void setBadges(Object badges) {
	this.badges = badges;
	}

	public Object getMemberUrlResources() {
	return memberUrlResources;
	}

	public void setMemberUrlResources(Object memberUrlResources) {
	this.memberUrlResources = memberUrlResources;
	}

	public Integer getTotalPrivateRepository() {
	return totalPrivateRepository;
	}

	public void setTotalPrivateRepository(Integer totalPrivateRepository) {
	this.totalPrivateRepository = totalPrivateRepository;
	}

	public String getCurrency() {
	return currency;
	}

	public void setCurrency(String currency) {
	this.currency = currency;
	}

	public Object getStarredUrl() {
	return starredUrl;
	}

	public void setStarredUrl(Object starredUrl) {
	this.starredUrl = starredUrl;
	}

	public Object getGistsUrl() {
	return gistsUrl;
	}

	public void setGistsUrl(Object gistsUrl) {
	this.gistsUrl = gistsUrl;
	}

	public Integer getPublicGists() {
	return publicGists;
	}

	public void setPublicGists(Integer publicGists) {
	this.publicGists = publicGists;
	}

	public Integer getPrivateGists() {
	return privateGists;
	}

	public void setPrivateGists(Integer privateGists) {
	this.privateGists = privateGists;
	}

	public Object getSubscription() {
	return subscription;
	}

	public void setSubscription(Object subscription) {
	this.subscription = subscription;
	}

	public Object getCompany() {
	return company;
	}

	public void setCompany(Object company) {
	this.company = company;
	}

	public String getGravatarImageUrl() {
	return gravatarImageUrl;
	}

	public void setGravatarImageUrl(String gravatarImageUrl) {
	this.gravatarImageUrl = gravatarImageUrl;
	}

	public ProfileImageUrls getProfileImageUrls() {
	return profileImageUrls;
	}

	public void setProfileImageUrls(ProfileImageUrls profileImageUrls) {
	this.profileImageUrls = profileImageUrls;
	}

	public Object getWebProfiles() {
	return webProfiles;
	}

	public void setWebProfiles(Object webProfiles) {
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
}
