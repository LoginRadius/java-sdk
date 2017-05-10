package com.loginradius.sdk.models.photo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

@SerializedName("Dimensions")
@Expose
private String dimensions;
@SerializedName("Image")
@Expose
private String image;

public String getDimensions() {
return dimensions;
}

public void setDimensions(String dimensions) {
this.dimensions = dimensions;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

}