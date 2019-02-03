package com.countries.pinkesh.countries.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonResponse {


    public ArrayList<BaseCountry> getBaseCountryList() {
        return baseCountryList;
    }

    public void setBaseCountryList(ArrayList<BaseCountry> baseCountryList) {
        this.baseCountryList = baseCountryList;
    }
    @SerializedName("baseCountryList")
    private ArrayList<BaseCountry> baseCountryList = new ArrayList<>();
}
