package loginradiusdataobject.userprofile;

import com.google.gson.annotations.SerializedName;

    public class LoginRadiusAddress
    {
        @SerializedName("Type")
        public String type ;
        
        @SerializedName("Address1")
        public String address1;
        
        @SerializedName("Address2")
        public String address2 ;
        
        @SerializedName("City")
        public String city ;
        
        @SerializedName("State")
        public String state;
        
        @SerializedName("PostalCode")
        public String postalCode;
        
        @SerializedName("Region")
        public String region;
    }

