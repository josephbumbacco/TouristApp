package com.example.touristapp;

public class Locations {
    private String locationName;

    private String locationRating;

    private int locationImage;


    public Locations(){
    }



    public Locations(String locationName, String locationRating, int locationImage) {
        this.locationName = locationName;
        this.locationRating = locationRating;
        this.locationImage = locationImage;
    }

    public int getLocationImage() {
        return locationImage;
    }

    public void setLocationImage(int locationImage) {
        this.locationImage = locationImage;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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
