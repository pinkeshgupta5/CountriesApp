package com.countries.pinkesh.countries.room;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.countries.pinkesh.countries.models.BaseCountry;

@Database(entities ={BaseCountry.class},version = 1,exportSchema = false)
public abstract class CountryDatabase extends RoomDatabase{


    public abstract CountryDao getcountryDao();

    private static CountryDatabase countryDatabase;

    public static CountryDatabase getInstance(Context context) {
        if (countryDatabase==null) {
            countryDatabase = buildDatabaseInstance(context);
        }
        return countryDatabase;
    }

    @NonNull
    private static CountryDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                CountryDatabase.class,
                "countrydatabase")
                .allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {
        countryDatabase= null;
    }
}
