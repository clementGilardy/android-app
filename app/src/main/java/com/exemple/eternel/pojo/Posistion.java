package com.exemple.eternel.pojo;

/**
 * Created by eternel on 05/04/15.
 */
public class Posistion {

    String driver;
    Float latitude;
    Float longitude;
    public Posistion()
    {

    }

    public Posistion(String driver, Float latitude, Float longitude)
    {
        this.driver = driver;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

}
