package com.example.touristapp;

public class Locations {
    private String locationName;

    private int locationImage;

    private int ratingImage;


    public Locations(){
    }




    public Locations(String locationName, int locationImage, int ratingImage) {
        this.locationName = locationName;
        this.locationImage = locationImage;
        this.ratingImage = ratingImage;
    }

    public int getRatingImage() {
        return ratingImage;
    }

    public void setRatingImage(int ratingImage) {
        this.ratingImage = ratingImage;
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


    public String toString() {
        return this.locationName;
    }

}
