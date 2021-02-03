package com.talarczyk.entities;

import java.sql.Timestamp;

public class SunriseSunset {
    public Timestamp day;
    public Temp sunset;
    public Temp sunrise;

    public Timestamp getDay() {
        return day;
    }

    public void setDay(Timestamp day) {
        this.day = day;
    }

    public Temp getSunset() {
        return sunset;
    }

    public void setSunset(Temp sunset) {
        this.sunset = sunset;
    }

    public Temp getSunrise() {
        return sunrise;
    }

    public void setSunrise(Temp sunrise) {
        this.sunrise = sunrise;
    }

    public boolean isValid(){
        return this.sunrise != null || this.sunset != null;
    }
}
