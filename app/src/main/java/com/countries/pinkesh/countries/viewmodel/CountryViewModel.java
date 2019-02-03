package com.countries.pinkesh.countries.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.countries.pinkesh.countries.models.BaseCountry;
import com.countries.pinkesh.countries.models.JsonResponse;
import com.countries.pinkesh.countries.remote.ApiService;
import com.countries.pinkesh.countries.remote.RetroClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<BaseCountry>> CountriesList;    //we will call this method to get the data
    public LiveData<List<BaseCountry>> getCountries() {
        //if the list is null
        if (CountriesList== null) {
            CountriesList = new MutableLiveData<List<BaseCountry>>();
            //we will load it asynchronously from server in this method
            loadUsers();
        }

        //finally we will return the list
        return CountriesList;
    }

    private void loadUsers() {
        ApiService apiService = RetroClass.getApiService();
        Call< ArrayList<BaseCountry>> callList = apiService.getallcountriesdata();
        callList.enqueue(new Callback<ArrayList<BaseCountry>>() {
            @Override
            public void onResponse(Call<ArrayList<BaseCountry>> call, Response<ArrayList<BaseCountry>> response) {

                CountriesList.setValue(response.body());

    }

            @Override
            public void onFailure(Call<ArrayList<BaseCountry>> call, Throwable t) {
                CountriesList.setValue(null);


            }
        });
    }
    }
