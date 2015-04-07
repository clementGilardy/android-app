package com.example.eternel.transportclient;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import com.exemple.eternel.pojo.Posistion;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by eternel on 06/04/15.
 */
class GPSPosition extends TimerTask {
    String context = Context.LOCATION_SERVICE;
    Context mContext;
    String methode;
    String driver = "1";
    Posistion position = new Posistion();
    ObjectMapper mapper = new ObjectMapper();
    String input = null;
    LocationManager locationManager;

    public GPSPosition(String methode, Context mContext)
    {
        this.methode = methode;
        this.mContext = mContext;
        locationManager =(LocationManager)mContext.getSystemService(context);
    }

    public void run() {
        try {

            URL url = new URL("http://ingepute.audemar.fr:8000/" + methode + "/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");


            switch (methode) {
                case "users":
                    break;
                case "drivers":
                    break;
                case "positions":
                    position.setDriver(driver);

                    Location location = getLastKnownLocation();
                    if (location != null) {
                        position.setLatitude(location.getLatitude());
                        position.setLongitude(location.getLongitude());
                    } else {
                        throw new Exception("The location is null !");
                    }
                    input = mapper.writeValueAsString(position);
                    break;
                default:
                    System.out.println("Anything methode wrong, methode : " + methode);
                    break;
            }

            if (input != null && !input.isEmpty()) {
                System.out.println(input);
                OutputStream os = conn.getOutputStream();
                os.write(input.getBytes());
                os.flush();

                if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode() + " : message : " + conn.getResponseMessage());
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                String output;
                System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
            } else {
                System.out.println("l'objet is empty !");
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Location getLastKnownLocation() {
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = locationManager.getLastKnownLocation(provider);

            if (l == null) {
                continue;
            }
            if (bestLocation == null
                    || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
        }
        if (bestLocation == null) {
            return null;
        }
        return bestLocation;
    }
}
