package com.example.eternel.transportclient;

import com.exemple.eternel.pojo.Posistion;
import com.exemple.eternel.pojo.User;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by eternel on 05/04/15.
 */
public class ClientPost extends Thread {

    private String methode;

    public ClientPost(String methode)
    {
        this.methode = methode;
    }

    public void run()
    {
        String driver       = "http://192.168.0.11:8080/drivers/1/";
        Posistion position  = new Posistion();
        User user           = new User();
        ObjectMapper mapper = new ObjectMapper();
        String input        = null;

        try {

            URL url = new URL("http://192.168.0.11:8080/"+methode+"/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");


            switch (methode)
            {
                case "users" :
                   break;
                case "drivers" :
                   break;
                case "positions" :
                    position.setDriver(driver);
                    position.setLatitude(3.12f);
                    position.setLongitude(4.5f);
                    input =  mapper.writeValueAsString(position);
                    break;
                default:
                    System.out.println("Anything methode wrong, methode : "+methode);
                    break;
            }

            if(input != null && !input.isEmpty())
            {
                System.out.println(input);
                OutputStream os = conn.getOutputStream();
                os.write(input.getBytes());
                os.flush();

                if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode()+ " : message : "+conn.getResponseMessage());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
            }
            else
            {
                System.out.println("l'obejet est vide !");
            }
            conn.disconnect();
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
