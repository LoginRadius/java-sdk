/* 
 * 
 * Created by LoginRadius Development Team
   Copyright 2019 LoginRadius Inc. All rights reserved.
   
 */

package com.loginradius.sdk.models.responsemodels.otherobjects;
import java.util.List;

import com.google.gson.annotations.SerializedName;

	/**
	 * Response containing Definition of Complete page data
	 */
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
		 * Array of Objects,String represents Id, Name and  Issuer
		 */
		public String getAwards() {
			return awards;
		}
		/**
		 * Array of Objects,String represents Id, Name and  Issuer
		 */
		public void setAwards(String awards) {
			this.awards = awards;
		}
		/**
		 * Page category
		 */
		public String getCategory() {
			return category;
		}
		/**
		 * Page category
		 */
		public void setCategory(String category) {
			this.category = category;
		}
		/**
		 * Category list
		 */
		public List<PageCategoryList> getCategoryList() {
			return categoryList;
		}
		/**
		 * Category list
		 */
		public void setCategoryList(List<PageCategoryList> categoryList) {
			this.categoryList = categoryList;
		}
		/**
		 * checkin count
		 */
		public String getCheckinCount() {
			return checkinCount;
		}
		/**
		 * checkin count
		 */
		public void setCheckinCount(String checkinCount) {
			this.checkinCount = checkinCount;
		}
		/**
		 * Image url
		 */
		public PageCover getCoverImage() {
			return coverImage;
		}
		/**
		 * Image url
		 */
		public void setCoverImage(PageCover coverImage) {
			this.coverImage = coverImage;
		}
		/**
		 * detailed information
		 */
		public String getDescription() {
			return description;
		}
		/**
		 * detailed information
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		/**
		 * Employee count range
		 */
		public PageCodeName getEmployeeCountRange() {
			return employeeCountRange;
		}
		/**
		 * Employee count range
		 */
		public void setEmployeeCountRange(PageCodeName employeeCountRange) {
			this.employeeCountRange = employeeCountRange;
		}
		/**
		 * Founded
		 */
		public String getFounded() {
			return founded;
		}
		/**
		 * Founded
		 */
		public void setFounded(String founded) {
			this.founded = founded;
		}
		/**
		 * Page id
		 */
		public String getID() {
			return iD;
		}
		/**
		 * Page id
		 */
		public void setID(String iD) {
			this.iD = iD;
		}
		/**
		 * Image url
		 */
		public String getImage() {
			return image;
		}
		/**
		 * Image url
		 */
		public void setImage(String image) {
			this.image = image;
		}
		/**
		 * List of Industries
		 */
		public List<PageCodeName> getIndustries() {
			return industries;
		}
		/**
		 * List of Industries
		 */
		public void setIndustries(List<PageCodeName> industries) {
			this.industries = industries;
		}
		/**
		 * Page likes
		 */
		public String getLikes() {
			return likes;
		}
		/**
		 * Page likes
		 */
		public void setLikes(String likes) {
			this.likes = likes;
		}
		/**
		 * Location of page
		 */
		public List<PageLocations> getLocations() {
			return locations;
		}
		/**
		 * Location of page
		 */
		public void setLocations(List<PageLocations> locations) {
			this.locations = locations;
		}
		/**
		 * Page mission
		 */
		public String getMission() {
			return mission;
		}
		/**
		 * Page mission
		 */
		public void setMission(String mission) {
			this.mission = mission;
		}
		/**
		 * Page name
		 */
		public String getName() {
			return name;
		}
		/**
		 * Page name
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * New Phone Number
		 */
		public String getPhone() {
			return phone;
		}
		/**
		 * New Phone Number
		 */
		public void setPhone(String phone) {
			this.phone = phone;
		}
		/**
		 * Products
		 */
		public String getProducts() {
			return products;
		}
		/**
		 * Products
		 */
		public void setProducts(String products) {
			this.products = products;
		}
		/**
		 * Published
		 */
		public Boolean getPublished() {
			return published;
		}
		/**
		 * Published
		 */
		public void setPublished(Boolean published) {
			this.published = published;
		}
		/**
		 * Release Date
		 */
		public String getReleaseDate() {
			return releaseDate;
		}
		/**
		 * Release Date
		 */
		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}
		/**
		 * Specialties
		 */
		public Speciality getSpecialties() {
			return specialties;
		}
		/**
		 * Specialties
		 */
		public void setSpecialties(Speciality specialties) {
			this.specialties = specialties;
		}
		/**
		 * Page Status
		 */
		public PageCodeName getStatus() {
			return status;
		}
		/**
		 * Page Status
		 */
		public void setStatus(PageCodeName status) {
			this.status = status;
		}
		/**
		 * Stock Exchange
		 */
		public PageCodeName getStockExchange() {
			return stockExchange;
		}
		/**
		 * Stock Exchange
		 */
		public void setStockExchange(PageCodeName stockExchange) {
			this.stockExchange = stockExchange;
		}
		/**
		 * Talking About Count
		 */
		public String getTalkingAboutCount() {
			return talkingAboutCount;
		}
		/**
		 * Talking About Count
		 */
		public void setTalkingAboutCount(String talkingAboutCount) {
			this.talkingAboutCount = talkingAboutCount;
		}
		/**
		 * String represents website url
		 */
		public String getUrl() {
			return url;
		}
		/**
		 * String represents website url
		 */
		public void setUrl(String url) {
			this.url = url;
		}
		/**
		 * Username of the user
		 */
		public String getUserName() {
			return userName;
		}
		/**
		 * Username of the user
		 */
		public void setUserName(String userName) {
			this.userName = userName;
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