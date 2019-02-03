package com.countries.pinkesh.countries.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "countries")
public class BaseCountry implements Serializable {

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    @Expose
    private String name;

    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    @Expose
    private String flag;
    /* @SerializedName("topLevelDomain")
     private List<String> topLevelDomain = new ArrayList<>();
     @SerializedName("alpha2Code")
     private String alpha2Code;
     @SerializedName("alpha3Code")
     private String alpha3Code;*/

    @SerializedName("callingCodes")
    @Ignore
    private List<String> callingCodes = new ArrayList<>();
    @SerializedName("capital")
    private String capital;
    /* @SerializedName("altSpellings")
     private List<String> altSpellings = new ArrayList<>();*/
    @SerializedName("region")
    @Ignore
    private String region;
    @SerializedName("subregion")
    @Ignore
    private String subregion;
    /*@SerializedName("population")
    private int population;
    @SerializedName("latlng")
    private List<Integer> latlng= new ArrayList<>();
    @SerializedName("demonyn")
    private String demonym;
    @SerializedName("area")
    private int area;
    @SerializedName("gini")
    private int gini;*/
    @SerializedName("timezones")
    @Ignore
    private List<String> timezones = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<Currencies> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currencies> currencies) {
        this.currencies = currencies;
    }

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    /*@SerializedName("borders")
        /*private List<String> borders = new ArrayList<>();
        @SerializedName("nativeName")
        private String nativeName;
        @SerializedName("numericCode")
        private String numericCode;*/
    @SerializedName("currencies")
    @Ignore
    private List<Currencies> currencies = new ArrayList<Currencies>();
    @SerializedName("languages")
    @Ignore
    private List<Languages> languages = new ArrayList<>();
    /* @SerializedName("translations")
     private Translations translations;*/

   /* @SerializedName("regionalBlocs")
    private List<RegionalBlocs> regionalBlocs = new ArrayList<>();
    @SerializedName("cioc")
    private String cioc;*/


    /*public BaseCountry(String name,  List<String> callingCodes,
                       String capital,  String region, String subregion,
                       List<String> timezones,
                       List<Currencies> currencies, List<Languages> languages,
                       String flag)

    {
        this.name=name;
        //this.topLevelDomain= topLevelDomain;
       // this.alpha2Code=alpha2Code;
       // this.alpha3Code=alpha3Code;
        this.callingCodes=callingCodes;
        this.capital=capital;
       // this.altSpellings=altSpellings;
        this.region=region;
        this.subregion=subregion;
        //this.population=population;
        //this.latlng=latlng;
       // this.demonym=demonym;
       // this.area=area;
       // this.gini=gini;
        this.timezones=timezones;
       // this.borders=borders;
        //this.nativeName=nativeName;
        //this.numericCode=numericCode;
        this.currencies=currencies;
        this.languages=languages;
        //this.translations=translations;
        this.flag=flag;
        //this.regionalBlocs=regionalBlocs;
        //this.cioc=cioc;



    }*/

    public BaseCountry(String name,String flag)
    {
        this.name=name;
        this.flag=flag;
    }



}
