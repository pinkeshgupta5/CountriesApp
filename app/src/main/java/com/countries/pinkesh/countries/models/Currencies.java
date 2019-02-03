package com.countries.pinkesh.countries.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Currencies implements Serializable {
    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("symbol")
    private String symbol;

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public String getSymbol(){
        return this.symbol;
    }

}
