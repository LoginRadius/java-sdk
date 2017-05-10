package com.loginradius.sdk.models.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class LoginRadiusPhoto 
{
	@SerializedName("ID")
	@Expose
	private String iD;
	@SerializedName("AlbumId")
	@Expose
	private String albumId;
	@SerializedName("OwnerId")
	@Expose
	private String ownerId;
	@SerializedName("OwnerName")
	@Expose
	private String ownerName;
	@SerializedName("Name")
	@Expose
	private String name;
	@SerializedName("DirectUrl")
	@Expose
	private String directUrl;
	@SerializedName("ImageUrl")
	@Expose
	private String imageUrl;
	@SerializedName("Location")
	@Expose
	private String location;
	@SerializedName("Link")
	@Expose
	private String link;
	@SerializedName("Description")
	@Expose
	private Object description;
	@SerializedName("Height")
	@Expose
	private String height;
	@SerializedName("Width")
	@Expose
	private String width;
	@SerializedName("CreatedDate")
	@Expose
	private String createdDate;
	@SerializedName("UpdatedDate")
	@Expose
	private String updatedDate;
	@SerializedName("Images")
	@Expose
	private List<Image> images = null;
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
	* The albumId
	*/
	public String getAlbumId() {
	return albumId;
	}

	/**
	* 
	* @param albumId
	* The AlbumId
	*/
	public void setAlbumId(String albumId) {
	this.albumId = albumId;
	}

	/**
	* 
	* @return
	* The ownerId
	*/
	public String getOwnerId() {
	return ownerId;
	}

	/**
	* 
	* @param ownerId
	* The OwnerId
	*/
	public void setOwnerId(String ownerId) {
	this.ownerId = ownerId;
	}

	/**
	* 
	* @return
	* The ownerName
	*/
	public String getOwnerName() {
	return ownerName;
	}

	/**
	* 
	* @param ownerName
	* The OwnerName
	*/
	public void setOwnerName(String ownerName) {
	this.ownerName = ownerName;
	}

	/**
	* 
	* @return
	* The name
	*/
	public String getName() {
	return name;
	}

	/**
	* 
	* @param name
	* The Name
	*/
	public void setName(String name) {
	this.name = name;
	}

	/**
	* 
	* @return
	* The directUrl
	*/
	public String getDirectUrl() {
	return directUrl;
	}

	/**
	* 
	* @param directUrl
	* The DirectUrl
	*/
	public void setDirectUrl(String directUrl) {
	this.directUrl = directUrl;
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
	* The location
	*/
	public String getLocation() {
	return location;
	}

	/**
	* 
	* @param location
	* The Location
	*/
	public void setLocation(String location) {
	this.location = location;
	}

	/**
	* 
	* @return
	* The link
	*/
	public String getLink() {
	return link;
	}

	/**
	* 
	* @param link
	* The Link
	*/
	public void setLink(String link) {
	this.link = link;
	}

	/**
	* 
	* @return
	* The description
	*/
	public Object getDescription() {
	return description;
	}

	/**
	* 
	* @param description
	* The Description
	*/
	public void setDescription(Object description) {
	this.description = description;
	}

	/**
	* 
	* @return
	* The height
	*/
	public String getHeight() {
	return height;
	}

	/**
	* 
	* @param height
	* The Height
	*/
	public void setHeight(String height) {
	this.height = height;
	}

	/**
	* 
	* @return
	* The width
	*/
	public String getWidth() {
	return width;
	}

	/**
	* 
	* @param width
	* The Width
	*/
	public void setWidth(String width) {
	this.width = width;
	}

	/**
	* 
	* @return
	* The createdDate
	*/
	public String getCreatedDate() {
	return createdDate;
	}

	/**
	* 
	* @param createdDate
	* The CreatedDate
	*/
	public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
	}

	/**
	* 
	* @return
	* The updatedDate
	*/
	public String getUpdatedDate() {
	return updatedDate;
	}

	/**
	* 
	* @param updatedDate
	* The UpdatedDate
	*/
	public void setUpdatedDate(String updatedDate) {
	this.updatedDate = updatedDate;
	}
	
	public List<Image> getImages() {
	return images;
	}

	public void setImages(List<Image> images) {
	this.images = images;
	}
}
