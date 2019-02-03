package com.countries.pinkesh.countries.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Translations implements Serializable {
    @SerializedName("de")
    private String de;
    @SerializedName("es")
    private String es;
    @SerializedName("fr")
    private String fr;
    @SerializedName("ja")
    private String ja;
    @SerializedName("it")
    private String it;
    @SerializedName("br")
    private String br;
    @SerializedName("pt")
    private String pt;
    @SerializedName("nl")
    private String nl;
    @SerializedName("hr")
    private String hr;
    @SerializedName("fa")
    private String fa;

    public void setDe(String de){
        this.de = de;
    }
    public String getDe(){
        return this.de;
    }
    public void setEs(String es){
        this.es = es;
    }
    public String getEs(){
        return this.es;
    }
    public void setFr(String fr){
        this.fr = fr;
    }
    public String getFr(){
        return this.fr;
    }
    public void setJa(String ja){
        this.ja = ja;
    }
    public String getJa(){
        return this.ja;
    }
    public void setIt(String it){
        this.it = it;
    }
    public String getIt(){
        return this.it;
    }
    public void setBr(String br){
        this.br = br;
    }
    public String getBr(){
        return this.br;
    }
    public void setPt(String pt){
        this.pt = pt;
    }
    public String getPt(){
        return this.pt;
    }
    public void setNl(String nl){
        this.nl = nl;
    }
    public String getNl(){
        return this.nl;
    }
    public void setHr(String hr){
        this.hr = hr;
    }
    public String getHr(){
        return this.hr;
    }
    public void setFa(String fa){
        this.fa = fa;
    }
    public String getFa(){
        return this.fa;
    }

}
