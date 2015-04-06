package com.exemple.eternel.pojo;

/**
 * Created by eternel on 05/04/15.
 */
public class Posistion {

    String driver;
    Double latitude;
    Double longitude;
    public Posistion()
    {

    }

    public Posistion(String driver, Double latitude, Double longitude)
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
