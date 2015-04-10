package com.example.eternel.transportclient;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button start;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.button_start);
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

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClientPost client = new ClientPost("positions", context);
                client.start();
            }
        });
    }
}
