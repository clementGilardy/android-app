package com.example.eternel.transportclient;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    Button start = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.button_start);
    }
}
