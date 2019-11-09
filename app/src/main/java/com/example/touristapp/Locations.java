package com.example.touristapp;

public class Locations {
    private String locationName;
    private String locationDetails;

    private String locationRating;


    public Locations(){
    }

    public Locations(String locationName, String locationDetails, String locationRating) {
        this.locationName = locationName;
        this.locationDetails = locationDetails;
        this.locationRating = locationRating;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public String getLocationRating() {
        return locationRating;
    }

    public void setLocationRating(String locationRating) {
        this.locationRating = locationRating;
    }

    public String toString() {
        return this.locationName;
    }

}
