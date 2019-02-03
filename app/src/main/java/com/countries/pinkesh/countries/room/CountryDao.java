package com.countries.pinkesh.countries.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.countries.pinkesh.countries.models.BaseCountry;
import java.util.List;
@Dao
public interface CountryDao {
    @Query("select * from countries")
    List<BaseCountry> getAllCountries();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(BaseCountry...baseCountries);

}
