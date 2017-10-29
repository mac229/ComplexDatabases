package com.example.maciej.complexdatabases.greendao.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Maciej on 2017-05-12.
 */

@Entity
public class Time {

    @Id
    private long id;
    private int hour;
    private int minute;

    @Generated(hash = 1115231360)
    public Time(long id, int hour, int minute) {
        this.id = id;
        this.hour = hour;
        this.minute = minute;
    }

    @Generated(hash = 37380482)
    public Time() {
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
