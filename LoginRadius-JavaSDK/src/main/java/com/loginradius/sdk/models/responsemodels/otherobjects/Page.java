/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	// <summary>
	//	Response containing Definition of Complete page data
	// </summary>
	public class Page {
	
		
		@SerializedName("About")
        private String about;
		
		@SerializedName("Awards")
        private String awards;
		
		@SerializedName("Category")
        private String category;
		
		@SerializedName("CategoryList")
        private List<PageCategoryList> categoryList;
		
		@SerializedName("CheckinCount")
        private String checkinCount;
		
		@SerializedName("CoverImage")
        private PageCover coverImage;
		
		@SerializedName("Description")
        private String description;
		
		@SerializedName("EmployeeCountRange")
        private PageCodeName employeeCountRange;
		
		@SerializedName("Founded")
        private String founded;
		
		@SerializedName("ID")
        private String iD;
		
		@SerializedName("Image")
        private String image;
		
		@SerializedName("Industries")
        private List<PageCodeName> industries;
		
		@SerializedName("Likes")
        private String likes;
		
		@SerializedName("Locations")
        private List<PageLocations> locations;
		
		@SerializedName("Mission")
        private String mission;
		
		@SerializedName("Name")
        private String name;
		
		@SerializedName("Phone")
        private String phone;
		
		@SerializedName("Products")
        private String products;
		
		@SerializedName("Published")
        private Boolean published;
		
		@SerializedName("ReleaseDate")
        private String releaseDate;
		
		@SerializedName("Specialties")
        private Speciality specialties;
		
		@SerializedName("Status")
        private PageCodeName status;
		
		@SerializedName("StockExchange")
        private PageCodeName stockExchange;
		
		@SerializedName("TalkingAboutCount")
        private String talkingAboutCount;
		
		@SerializedName("Url")
        private String url;
		
		@SerializedName("UserName")
        private String userName;
		
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
		//	Array of Objects,String represents Id, Name and  Issuer
		// </summary>
		public String getAwards() {
			return awards;
		}
		// <summary>
		//	Array of Objects,String represents Id, Name and  Issuer
		// </summary>
		public void setAwards(String awards) {
			this.awards = awards;
		}
		// <summary>
		//	Page category
		// </summary>
		public String getCategory() {
			return category;
		}
		// <summary>
		//	Page category
		// </summary>
		public void setCategory(String category) {
			this.category = category;
		}
		// <summary>
		//	Category list
		// </summary>
		public List<PageCategoryList> getCategoryList() {
			return categoryList;
		}
		// <summary>
		//	Category list
		// </summary>
		public void setCategoryList(List<PageCategoryList> categoryList) {
			this.categoryList = categoryList;
		}
		// <summary>
		//	checkin count
		// </summary>
		public String getCheckinCount() {
			return checkinCount;
		}
		// <summary>
		//	checkin count
		// </summary>
		public void setCheckinCount(String checkinCount) {
			this.checkinCount = checkinCount;
		}
		// <summary>
		//	Image url
		// </summary>
		public PageCover getCoverImage() {
			return coverImage;
		}
		// <summary>
		//	Image url
		// </summary>
		public void setCoverImage(PageCover coverImage) {
			this.coverImage = coverImage;
		}
		// <summary>
		//	detailed information
		// </summary>
		public String getDescription() {
			return description;
		}
		// <summary>
		//	detailed information
		// </summary>
		public void setDescription(String description) {
			this.description = description;
		}
		// <summary>
		//	Employee count range
		// </summary>
		public PageCodeName getEmployeeCountRange() {
			return employeeCountRange;
		}
		// <summary>
		//	Employee count range
		// </summary>
		public void setEmployeeCountRange(PageCodeName employeeCountRange) {
			this.employeeCountRange = employeeCountRange;
		}
		// <summary>
		//	Founded
		// </summary>
		public String getFounded() {
			return founded;
		}
		// <summary>
		//	Founded
		// </summary>
		public void setFounded(String founded) {
			this.founded = founded;
		}
		// <summary>
		//	Page id
		// </summary>
		public String getID() {
			return iD;
		}
		// <summary>
		//	Page id
		// </summary>
		public void setID(String iD) {
			this.iD = iD;
		}
		// <summary>
		//	Image url
		// </summary>
		public String getImage() {
			return image;
		}
		// <summary>
		//	Image url
		// </summary>
		public void setImage(String image) {
			this.image = image;
		}
		// <summary>
		//	List of Industries
		// </summary>
		public List<PageCodeName> getIndustries() {
			return industries;
		}
		// <summary>
		//	List of Industries
		// </summary>
		public void setIndustries(List<PageCodeName> industries) {
			this.industries = industries;
		}
		// <summary>
		//	Page likes
		// </summary>
		public String getLikes() {
			return likes;
		}
		// <summary>
		//	Page likes
		// </summary>
		public void setLikes(String likes) {
			this.likes = likes;
		}
		// <summary>
		//	Location of page
		// </summary>
		public List<PageLocations> getLocations() {
			return locations;
		}
		// <summary>
		//	Location of page
		// </summary>
		public void setLocations(List<PageLocations> locations) {
			this.locations = locations;
		}
		// <summary>
		//	Page mission
		// </summary>
		public String getMission() {
			return mission;
		}
		// <summary>
		//	Page mission
		// </summary>
		public void setMission(String mission) {
			this.mission = mission;
		}
		// <summary>
		//	Page name
		// </summary>
		public String getName() {
			return name;
		}
		// <summary>
		//	Page name
		// </summary>
		public void setName(String name) {
			this.name = name;
		}
		// <summary>
		//	New Phone Number
		// </summary>
		public String getPhone() {
			return phone;
		}
		// <summary>
		//	New Phone Number
		// </summary>
		public void setPhone(String phone) {
			this.phone = phone;
		}
		// <summary>
		//	Products
		// </summary>
		public String getProducts() {
			return products;
		}
		// <summary>
		//	Products
		// </summary>
		public void setProducts(String products) {
			this.products = products;
		}
		// <summary>
		//	Published
		// </summary>
		public Boolean getPublished() {
			return published;
		}
		// <summary>
		//	Published
		// </summary>
		public void setPublished(Boolean published) {
			this.published = published;
		}
		// <summary>
		//	Release Date
		// </summary>
		public String getReleaseDate() {
			return releaseDate;
		}
		// <summary>
		//	Release Date
		// </summary>
		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}
		// <summary>
		//	Specialties
		// </summary>
		public Speciality getSpecialties() {
			return specialties;
		}
		// <summary>
		//	Specialties
		// </summary>
		public void setSpecialties(Speciality specialties) {
			this.specialties = specialties;
		}
		// <summary>
		//	Page Status
		// </summary>
		public PageCodeName getStatus() {
			return status;
		}
		// <summary>
		//	Page Status
		// </summary>
		public void setStatus(PageCodeName status) {
			this.status = status;
		}
		// <summary>
		//	Stock Exchange
		// </summary>
		public PageCodeName getStockExchange() {
			return stockExchange;
		}
		// <summary>
		//	Stock Exchange
		// </summary>
		public void setStockExchange(PageCodeName stockExchange) {
			this.stockExchange = stockExchange;
		}
		// <summary>
		//	Talking About Count
		// </summary>
		public String getTalkingAboutCount() {
			return talkingAboutCount;
		}
		// <summary>
		//	Talking About Count
		// </summary>
		public void setTalkingAboutCount(String talkingAboutCount) {
			this.talkingAboutCount = talkingAboutCount;
		}
		// <summary>
		//	String represents website url
		// </summary>
		public String getUrl() {
			return url;
		}
		// <summary>
		//	String represents website url
		// </summary>
		public void setUrl(String url) {
			this.url = url;
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