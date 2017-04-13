package com.loginradius.sdk.models.register;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by loginradius on 9/22/2016.
 */
public class DeleteResponse {


    @SerializedName("IsDeleted")
        @Expose
        private Boolean isDeleted;

        /**
         *
         * @return
         * The isDeleted
         */
        public Boolean getIsDeleted() {
            return isDeleted;
        }

        /**
         *
         * @param isDeleted
         * The isDeleted
         */
        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

    }

