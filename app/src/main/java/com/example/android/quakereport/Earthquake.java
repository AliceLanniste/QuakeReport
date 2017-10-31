package com.example.android.quakereport;

/**
 * Created by pc-zhs on 2017/10/30.
 */

public class Earthquake {
    private double magnitude;
    private String location;
    private long time;

    public Earthquake(double magnitude,String location,long time){
        this.magnitude= magnitude;
        this.location = location;
        this.time = time;
    }

    public double getMagnitude( ) {
        return this.magnitude;
    }

    public String getLocation( ) {
        return this.location;
    }

    public long getTime( ) {
        return this.time;
    }
}
