package com.talarczyk.entities;

import com.talarczyk.utils.FormatTimestamp;

import java.sql.Timestamp;

public class Temp {
    public int id;
    public Timestamp time;
    public Double measurement;

    public Temp(int id, Timestamp time, Double measurement) {
        this.id = id;
        this.time = time;
        this.measurement = measurement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public String getSimplifiedTime(){
        return FormatTimestamp.format(time);
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Double measurement) {
        this.measurement = measurement;
    }


}
