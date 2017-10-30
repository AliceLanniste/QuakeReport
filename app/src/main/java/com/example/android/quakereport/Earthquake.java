package com.example.android.quakereport;

/**
 * Created by pc-zhs on 2017/10/30.
 */

public class Earthquake {
    private String magnitude;
    private String location;
    private String date;

    public Earthquake(String magnitude,String location,String date){
        this.magnitude= magnitude;
        this.location = location;
        this.date = date;
    }

    public String getMagnitude( ) {
        return this.magnitude;
    }

    public String getLocation( ) {
        return this.location;
    }

    public String getDate( ) {
        return this.date;
    }
}
