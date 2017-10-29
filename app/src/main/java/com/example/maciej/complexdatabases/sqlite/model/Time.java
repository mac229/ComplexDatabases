package com.example.maciej.complexdatabases.sqlite.model;

/**
 * Created by Maciej on 2017-05-12.
 */

public class Time {

    private long id;
    private int hour;
    private int minute;

    public Time(long id, int hour, int minute) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
