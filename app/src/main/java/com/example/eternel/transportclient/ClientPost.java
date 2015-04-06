package com.example.eternel.transportclient;

import android.content.Context;

import java.util.Timer;

/**
 * Created by eternel on 05/04/15.
 */
public class ClientPost extends Thread {

    private String methode;
    private Timer t;
    private Context mContext;

    public ClientPost(String methode, Context mContext)
    {
        this.methode = methode;
        this.mContext = mContext;
        t = new Timer();
    }

    public void run()
    {
        t.schedule(new GPSPosition(methode,mContext),0,5000);
    }
}
