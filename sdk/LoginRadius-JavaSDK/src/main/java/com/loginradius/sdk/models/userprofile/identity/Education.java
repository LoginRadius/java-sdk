
package com.loginradius.sdk.models.userprofile.identity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Education {

    @SerializedName("School")
    @Expose
    private String school;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("notes")
    @Expose
    private Object notes;
    @SerializedName("activities")
    @Expose
    private Object activities;
    @SerializedName("degree")
    @Expose
    private Object degree;
    @SerializedName("fieldofstudy")
    @Expose
    private String fieldofstudy;
    @SerializedName("StartDate")
    @Expose
    private Object startDate;
    @SerializedName("EndDate")
    @Expose
    private Object endDate;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Object getActivities() {
        return activities;
    }

    public void setActivities(Object activities) {
        this.activities = activities;
    }

    public Object getDegree() {
        return degree;
    }

    public void setDegree(Object degree) {
        this.degree = degree;
    }

    public String getFieldofstudy() {
        return fieldofstudy;
    }

    public void setFieldofstudy(String fieldofstudy) {
        this.fieldofstudy = fieldofstudy;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    public Object getEndDate() {
        return endDate;
    }

    public void setEndDate(Object endDate) {
        this.endDate = endDate;
    }

}
