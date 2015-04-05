package com.example.eternel.transportclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by eternel on 05/04/15.
 */
public class ClientGet extends Thread{

    public void run()
    {
        try
        {
            URL url = new URL("http://192.168.0.11:8080/users/1/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept","application/json");

            System.out.println(conn.getResponseCode());

            if(conn.getResponseCode() != 200){
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String output;
            System.out.println("Output from server \n");

            while((output = br.readLine()) != null){
                System.out.println(output);
            }
            conn.disconnect();
        }
        catch(Exception e)
        {
            System.out.println("other error");
            e.printStackTrace();
        }
    }

}
