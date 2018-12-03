package com.example.palexis3.imageviewer.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BusinessResponse {

    @SerializedName("businesses")
    List<Business> businesses;

    public BusinessResponse() {
        businesses = new ArrayList<>();
    }

    public List<Business> getBusinesses() { return businesses; }
}
