package com.countries.pinkesh.countries.remote;

import com.countries.pinkesh.countries.models.BaseCountry;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("all")
    Call<ArrayList<BaseCountry>> getallcountriesdata();
}
