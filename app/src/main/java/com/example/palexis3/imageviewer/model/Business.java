package com.example.palexis3.imageviewer.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Business {

    @SerializedName("name")
    String name;

    @SerializedName("price")
    String price;

    @SerializedName("title")
    String title;

    @SerializedName("rating")
    Double rating;

    @SerializedName("id")
    String id;

    @SerializedName("image_url")
    String image_url;

    @SerializedName("coordinates")
    Coordinates coordinates;

    public Business(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
