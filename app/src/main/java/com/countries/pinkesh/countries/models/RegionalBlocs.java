package com.countries.pinkesh.countries.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegionalBlocs implements Serializable {
    @SerializedName("acronym")
    private String acronym;
    @SerializedName("name")
    private String name;
    @SerializedName("otherAcronyms")
    private List<String> otherAcronyms = new ArrayList<>();
    @SerializedName("otherNames")
    private List<String> otherNames= new ArrayList<>();

    public void setAcronym(String acronym){
        this.acronym = acronym;
    }
    public String getAcronym(){
        return this.acronym;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setOtherAcronyms(List<String> otherAcronyms){
        this.otherAcronyms = otherAcronyms;
    }
    public List<String> getOtherAcronyms(){
        return this.otherAcronyms;
    }
    public void setOtherNames(List<String> otherNames){
        this.otherNames = otherNames;
    }
    public List<String> getOtherNames(){
        return this.otherNames;
    }

}
