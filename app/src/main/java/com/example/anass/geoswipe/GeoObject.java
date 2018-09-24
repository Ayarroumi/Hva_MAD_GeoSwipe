package com.example.anass.geoswipe;

import android.graphics.Color;

public class GeoObject {

    private String geoName;
    private int imageName;
    private boolean europe;
    private int backgroundColor = Color.parseColor("#ffffff");


    public GeoObject(){}

    public String getGeoName() {
        return geoName;
    }

    public void setGeoName(String geoName) {
        this.geoName = geoName;
    }

    public int getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    public boolean isEurope() {
        return europe;
    }

    public void setEurope(boolean europe) {
        this.europe = europe;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
