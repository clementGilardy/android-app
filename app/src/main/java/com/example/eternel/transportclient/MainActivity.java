package com.example.eternel.transportclient;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.apache.http.impl.client.DefaultHttpClient;


public class MainActivity extends ActionBarActivity {
    String SERVICE_ENDPOINT = "http://localhost:8000";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Demande l'activation du GPS si il n'est pas activé
         */
        LocationManager locManager;
        locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
/** Test si le gps est activé ou non */
        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            /** on lance notre activity (qui est une dialog) */
            Intent localIntent = new Intent(this, PermissionGps.class);
            localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(localIntent);
        }

        ClientGet client = new ClientGet();
        client.start();


    }
}
