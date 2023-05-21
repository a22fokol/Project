package com.example.project;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class Country implements Serializable {
    private String name;
    private String location;
    private int population;
    private String description;
    private String imageUrl;
    private String website; // Additional field for website

    public Country(String name, String location, int population, String description, String imageUrl, String website) {
        this.name = name;
        this.location = location;
        this.population = population;
        this.description = description;
        this.imageUrl = imageUrl;
        this.website = website;
    }

    // Getters and setters for the fields

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }



    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getPopulation() {
        return population;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAuxdata() {
        return description;
    }
}
