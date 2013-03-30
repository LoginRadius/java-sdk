/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loginradiusdataobject.userprofile;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Administrator
 */
public class LoginradiusRecommendationsReceived {

    @SerializedName("Id")
    public String id;
    @SerializedName("RecommendationType")
    public String recommendationType;
    @SerializedName("RecommendationText")
    public String recommendationText;
    @SerializedName("Recommender")
    public String recommender;
}
