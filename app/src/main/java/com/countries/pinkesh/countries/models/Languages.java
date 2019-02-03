package com.countries.pinkesh.countries.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Languages implements Serializable{
    @SerializedName("iso639_1")
    private String iso639_1;
    @SerializedName("iso639_2")
    private String iso639_2;
    @SerializedName("name")
    private String name;
    @SerializedName("nativeName")
    private String nativeName;

    public void setIso639_1(String iso639_1){
        this.iso639_1 = iso639_1;
    }
    public String getIso639_1(){
        return this.iso639_1;
    }
    public void setIso639_2(String iso639_2){
        this.iso639_2 = iso639_2;
    }
    public String getIso639_2(){
        return this.iso639_2;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setNativeName(String nativeName){
        this.nativeName = nativeName;
    }
    public String getNativeName(){
        return this.nativeName;
    }

}
