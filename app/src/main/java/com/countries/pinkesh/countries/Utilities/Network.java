package com.countries.pinkesh.countries.Utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by pingupta on 2/27/2018.
 */

public class Network {
    public static boolean checkNetworkAvailability(Context context){
        boolean status = false;
        ConnectivityManager connMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nwInfo = connMgr.getActiveNetworkInfo();
        if(nwInfo != null && nwInfo.isConnected()) status = true;
        return status;
    }
}
